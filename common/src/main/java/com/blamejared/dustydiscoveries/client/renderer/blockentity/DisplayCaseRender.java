package com.blamejared.dustydiscoveries.client.renderer.blockentity;

import com.blamejared.dustydiscoveries.client.renderer.blockentity.state.DisplayCaseRenderState;
import com.blamejared.dustydiscoveries.world.level.block.entity.DisplayCaseBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;

public class DisplayCaseRender implements BlockEntityRenderer<DisplayCaseBlockEntity, DisplayCaseRenderState> {
    
    private final ItemModelResolver itemModelResolver;
    
    public DisplayCaseRender(final BlockEntityRendererProvider.Context context) {
        
        this.itemModelResolver = context.itemModelResolver();
    }
    
    @Override
    public DisplayCaseRenderState createRenderState() {
        
        return new DisplayCaseRenderState();
    }
    
    @Override
    public void extractRenderState(final DisplayCaseBlockEntity blockEntity, final DisplayCaseRenderState state, final float partialTicks, final Vec3 cameraPosition, final ModelFeatureRenderer.@Nullable CrumblingOverlay breakProgress) {
        
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTicks, cameraPosition, breakProgress);
        
        ItemStackRenderState displayedItem = new ItemStackRenderState();
        this.itemModelResolver.updateForTopItem(displayedItem, blockEntity.getTheItem(), ItemDisplayContext.FIXED, blockEntity.getLevel(), blockEntity, 0);
        state.displayedItem = displayedItem;
        state.displayRotation = blockEntity.rotation();
    }
    
    @Override
    public void submit(final DisplayCaseRenderState state, final PoseStack poseStack, final SubmitNodeCollector submitNodeCollector, final CameraRenderState camera) {
        
        poseStack.pushPose();
        poseStack.translate(0.5, 0.5, 0.5);
        poseStack.mulPose(Axis.YP.rotationDegrees(state.displayRotation.rotation()));
        poseStack.scale(0.5f, 0.5f, 0.5f);
        state.displayedItem.submit(poseStack, submitNodeCollector, state.lightCoords, OverlayTexture.NO_OVERLAY, 0);
        poseStack.popPose();
    }
    
}
