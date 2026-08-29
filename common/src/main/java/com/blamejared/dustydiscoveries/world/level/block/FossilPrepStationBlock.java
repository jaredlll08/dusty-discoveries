package com.blamejared.dustydiscoveries.world.level.block;

import com.blamejared.dustydiscoveries.world.inventory.FossilPrepStationMenu;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class FossilPrepStationBlock extends Block {
    
    public static final MapCodec<FossilPrepStationBlock> CODEC = simpleCodec(FossilPrepStationBlock::new);
    private static final Component CONTAINER_TITLE = Component.translatable("container.dustydiscoveries.fossil_prep_station");
    
    @Override
    public MapCodec<? extends FossilPrepStationBlock> codec() {
        
        return CODEC;
    }
    
    protected FossilPrepStationBlock(final BlockBehaviour.Properties properties) {
        
        super(properties);
    }
    
    @Override
    protected InteractionResult useWithoutItem(final BlockState state, final Level level, final BlockPos pos, final Player player, final BlockHitResult hitResult) {
        
        if(!level.isClientSide()) {
            player.openMenu(state.getMenuProvider(level, pos));
            player.awardStat(Stats.INTERACT_WITH_CRAFTING_TABLE);
        }
        
        return InteractionResult.SUCCESS;
    }
    
    @Override
    protected MenuProvider getMenuProvider(final BlockState state, final Level level, final BlockPos pos) {
        
        return new SimpleMenuProvider((containerId, inventory, _) -> new FossilPrepStationMenu(containerId, inventory, ContainerLevelAccess.create(level, pos)), CONTAINER_TITLE);
    }
    
}
