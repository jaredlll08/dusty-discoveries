package com.blamejared.dustydiscoveries.world.level.block.entity;

import com.mojang.logging.LogUtils;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.util.ProblemReporter;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.Container;
import net.minecraft.world.entity.ItemOwner;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.TagValueOutput;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.ticks.ContainerSingleItem;
import org.slf4j.Logger;

import java.util.Objects;

public class DisplayCaseBlockEntity extends BlockEntity implements ContainerSingleItem.BlockContainerSingleItem, ItemOwner {
    
    private static final Logger LOGGER = LogUtils.getLogger();
    private ItemStack item = ItemStack.EMPTY;
    
    private DisplayRotation rotation = DisplayRotation.ROT_0;
    
    public DisplayCaseBlockEntity(final BlockPos worldPosition, final BlockState blockState) {
        
        super(DDBlockEntities.DISPLAY_CASE.get(), worldPosition, blockState);
    }
    
    @Override
    protected void saveAdditional(final ValueOutput output) {
        
        super.saveAdditional(output);
        
        output.store("item", ItemStack.OPTIONAL_CODEC, this.item);
        output.store("rotation", DisplayRotation.CODEC, this.rotation);
    }
    
    @Override
    protected void loadAdditional(final ValueInput input) {
        
        super.loadAdditional(input);
        this.item = input.read("item", ItemStack.OPTIONAL_CODEC).orElse(ItemStack.EMPTY);
        this.rotation = input.read("rotation", DisplayRotation.CODEC).orElse(DisplayRotation.ROT_0);
    }
    
    @Override
    public ItemStack getTheItem() {
        
        return this.item;
    }
    
    @Override
    public void setTheItem(final ItemStack itemStack) {
        
        this.item = itemStack;
    }
    
    @Override
    public boolean stillValid(final Player player) {
        
        return Container.stillValidBlockEntity(this, player);
    }
    
    @Override
    public BlockEntity getContainerBlockEntity() {
        
        return this;
    }
    
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        
        return ClientboundBlockEntityDataPacket.create(this);
    }
    
    @Override
    public CompoundTag getUpdateTag(final HolderLookup.Provider registries) {
        
        try(ProblemReporter.ScopedCollector reporter = new ProblemReporter.ScopedCollector(this.problemPath(), LOGGER)) {
            TagValueOutput output = TagValueOutput.createWithContext(reporter, registries);
            output.store("item", ItemStack.CODEC, this.item);
            output.store("rotation", DisplayRotation.CODEC, this.rotation);
            return output.buildResult();
        }
    }
    
    @Override
    public Level level() {
        
        return Objects.requireNonNull(this.level);
    }
    
    @Override
    public Vec3 position() {
        
        return Vec3.atCenterOf(this.getBlockPos());
    }
    
    @Override
    public float getVisualRotationYInDegrees() {
        
        return this.rotation().rotation();
    }
    
    
    public DisplayRotation rotation() {
        
        return rotation;
    }
    
    public void rotation(DisplayRotation rotation) {
        
        this.rotation = rotation;
    }
    
    public enum DisplayRotation implements StringRepresentable {
        ROT_0(0),
        ROT_45(45),
        ROT_90(90),
        ROT_135(135),
        ROT_180(180),
        ROT_225(225),
        ROT_270(270),
        ROT_315(315);
        
        public static final Codec<DisplayRotation> CODEC = StringRepresentable.fromEnum(DisplayRotation::values);
        
        private final int rotation;
        
        DisplayRotation(final int rotation) {
            
            this.rotation = rotation;
        }
        
        public DisplayRotation next() {
            
            DisplayRotation[] values = DisplayRotation.values();
            int length = values.length;
            return values[(this.ordinal() + 1) % length];
        }
        
        @Override
        public String getSerializedName() {
            
            return String.valueOf(this.rotation);
        }
        
        public int rotation() {
            
            return rotation;
        }
    }
    
}
