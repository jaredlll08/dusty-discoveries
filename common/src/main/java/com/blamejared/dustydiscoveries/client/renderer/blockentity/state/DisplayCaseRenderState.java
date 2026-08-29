package com.blamejared.dustydiscoveries.client.renderer.blockentity.state;

import com.blamejared.dustydiscoveries.world.level.block.entity.DisplayCaseBlockEntity;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;

public class DisplayCaseRenderState extends BlockEntityRenderState {
    
    public ItemStackRenderState displayedItem = new ItemStackRenderState();
    public DisplayCaseBlockEntity.DisplayRotation displayRotation = DisplayCaseBlockEntity.DisplayRotation.ROT_0;
    
}
