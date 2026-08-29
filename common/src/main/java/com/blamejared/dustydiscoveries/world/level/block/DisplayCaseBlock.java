package com.blamejared.dustydiscoveries.world.level.block;

import com.blamejared.dustydiscoveries.world.level.block.entity.DDBlockEntities;
import com.blamejared.dustydiscoveries.world.level.block.entity.DisplayCaseBlockEntity;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.Nullable;

public class DisplayCaseBlock extends BaseEntityBlock implements SimpleWaterloggedBlock {
    
    public static final MapCodec<DisplayCaseBlock> CODEC = RecordCodecBuilder.mapCodec(i -> i.group(propertiesCodec(), DyeColor.CODEC.fieldOf("color")
                    .forGetter(displayCaseBlock -> displayCaseBlock.color))
            .apply(i, DisplayCaseBlock::new));
    
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private static final VoxelShape SHAPE = Block.column(14.0, 0.0, 16.0);
    
    private final DyeColor color;
    
    public DisplayCaseBlock(final Properties properties, final DyeColor color) {
        
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(WATERLOGGED, false));
        this.color = color;
    }
    
    @Override
    protected InteractionResult useItemOn(
            final ItemStack itemStack, final BlockState state, final Level level, final BlockPos pos, final Player player, final InteractionHand hand, final BlockHitResult hitResult
    ) {
        
        if(level.getBlockEntity(pos) instanceof DisplayCaseBlockEntity displayCase) {
            if(level.isClientSide()) {
                return InteractionResult.SUCCESS;
            }
            if(itemStack.isEmpty()) {
                return InteractionResult.TRY_WITH_EMPTY_HAND;
            }
            ItemStack caseItem = displayCase.getTheItem();
            if(caseItem.isEmpty()) {
                player.awardStat(Stats.ITEM_USED.get(itemStack.getItem()));
                ItemStack awardedItem = itemStack.consumeAndReturn(1, player);
                displayCase.setTheItem(awardedItem);
                level.playSound(null, pos, SoundEvents.DECORATED_POT_INSERT, SoundSource.BLOCKS, 1.0F, 0.7F + 0.5F);
                
                displayCase.setChanged();
                level.sendBlockUpdated(pos, state, state, UPDATE_ALL);
                level.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }
    
    @Override
    protected InteractionResult useWithoutItem(final BlockState state, final Level level, final BlockPos pos, final Player player, final BlockHitResult hitResult) {
        
        if(level.getBlockEntity(pos) instanceof DisplayCaseBlockEntity displayCase) {
            
            if(displayCase.getTheItem().isEmpty()) {
                return InteractionResult.PASS;
            }
            if(player.isShiftKeyDown()) {
                if(!player.getInventory().add(displayCase.getTheItem())) {
                    player.drop(displayCase.getTheItem(), false);
                }
                level.playSound(null, pos, SoundEvents.DECORATED_POT_INSERT_FAIL, SoundSource.BLOCKS, 1.0F, 0.7F + 0.5F);
                displayCase.setTheItem(ItemStack.EMPTY);
                level.sendBlockUpdated(pos, state, state, UPDATE_ALL);
            } else {
                displayCase.rotation(displayCase.rotation().next());
                level.playSound(null, pos, SoundEvents.DECORATED_POT_INSERT, SoundSource.BLOCKS, 1.0F, 0.7F + 0.5F);
                level.sendBlockUpdated(pos, state, state, UPDATE_ALL);
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
    
    @Override
    protected BlockState updateShape(
            final BlockState state,
            final LevelReader level,
            final ScheduledTickAccess ticks,
            final BlockPos pos,
            final Direction directionToNeighbour,
            final BlockPos neighbourPos,
            final BlockState neighbourState,
            final RandomSource random
    ) {
        
        if(state.getValue(WATERLOGGED)) {
            ticks.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }
        
        return super.updateShape(state, level, ticks, pos, directionToNeighbour, neighbourPos, neighbourState, random);
    }
    
    @Override
    public BlockState getStateForPlacement(final BlockPlaceContext context) {
        
        FluidState replacedFluidState = context.getLevel().getFluidState(context.getClickedPos());
        return this.defaultBlockState()
                .setValue(WATERLOGGED, replacedFluidState.is(Fluids.WATER));
    }
    
    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        
        return CODEC;
    }
    
    @Override
    protected boolean isPathfindable(final BlockState state, final PathComputationType type) {
        
        return false;
    }
    
    @Override
    protected VoxelShape getShape(final BlockState state, final BlockGetter level, final BlockPos pos, final CollisionContext context) {
        
        return SHAPE;
    }
    
    @Override
    protected void createBlockStateDefinition(final StateDefinition.Builder<Block, BlockState> builder) {
        
        builder.add(WATERLOGGED);
    }
    
    @Override
    protected FluidState getFluidState(final BlockState state) {
        
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }
    
    @Override
    public @Nullable BlockEntity newBlockEntity(final BlockPos worldPosition, final BlockState blockState) {
        
        return new DisplayCaseBlockEntity(worldPosition, blockState);
    }
    
    @Override
    protected boolean hasAnalogOutputSignal(final BlockState state) {
        
        return true;
    }
    
    @Override
    protected int getAnalogOutputSignal(final BlockState state, final Level level, final BlockPos pos, final Direction direction) {
        
        return level.getBlockEntity(pos, DDBlockEntities.DISPLAY_CASE.get())
                .filter(be -> !be.getTheItem().isEmpty())
                .map(_ -> 15)
                .orElse(0);
    }
    
}
