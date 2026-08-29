package com.blamejared.dustydiscoveries.fabric;

import com.blamejared.dustydiscoveries.client.gui.screens.inventory.FossilPrepStationScreen;
import com.blamejared.dustydiscoveries.client.renderer.blockentity.DDBlockEntityRenderers;
import com.blamejared.dustydiscoveries.world.inventory.DDMenuTypes;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;

public class DustyDiscoveriesFabricClient implements ClientModInitializer {
    
    @Override
    public void onInitializeClient() {
        
        MenuScreens.register(DDMenuTypes.FOSSIL_PREP_STATION.get(), FossilPrepStationScreen::new);
        DDBlockEntityRenderers.registerEntityRenderers(BlockEntityRenderers::register);
    }
    
}
