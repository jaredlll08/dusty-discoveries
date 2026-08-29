package com.blamejared.dustydiscoveries.mixin;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Set;

@Mixin(BlockEntityType.class)
public interface AccessBlockEntityType {
    
    @Mutable
    @Accessor("validBlocks")
    void dustydiscoveries$setValidBlocks(final Set<Block> validBlocks);
    
    @Accessor("validBlocks")
    Set<Block> dustydiscoveries$getValidBlocks();
    
}
