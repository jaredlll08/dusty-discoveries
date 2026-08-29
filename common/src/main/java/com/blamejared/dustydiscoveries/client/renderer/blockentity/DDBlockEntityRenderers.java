package com.blamejared.dustydiscoveries.client.renderer.blockentity;

import com.blamejared.dustydiscoveries.world.level.block.entity.DDBlockEntities;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.BiConsumer;

public class DDBlockEntityRenderers {
    
    @SuppressWarnings("rawtypes")
    public static void registerEntityRenderers(final BiConsumer<BlockEntityType<?>, BlockEntityRendererProvider> registrar) {
        
        registrar.accept(DDBlockEntities.DISPLAY_CASE.get(), DisplayCaseRender::new);
    }
    
}
