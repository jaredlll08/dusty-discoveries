package com.blamejared.dustydiscoveries.neoforge.client;

import com.blamejared.dustydiscoveries.DDConstants;
import com.blamejared.dustydiscoveries.client.gui.screens.inventory.FossilPrepStationScreen;
import com.blamejared.dustydiscoveries.client.renderer.blockentity.DDBlockEntityRenderers;
import com.blamejared.dustydiscoveries.neoforge.platform.NeoForgePlatformHelper;
import com.blamejared.dustydiscoveries.world.inventory.DDMenuTypes;
import com.blamejared.dustydiscoveries.world.item.crafting.DDRecipeTypes;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RecipesReceivedEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@EventBusSubscriber(value = Dist.CLIENT, modid = DDConstants.MODID)
public class DDClientEvents {
    
    @SubscribeEvent
    public static void registerEntityRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        
        DDBlockEntityRenderers.registerEntityRenderers(event::registerBlockEntityRenderer);
    }
    
    @SubscribeEvent
    public static void registerScreens(final RegisterMenuScreensEvent event) {
        
        event.register(DDMenuTypes.FOSSIL_PREP_STATION.get(), FossilPrepStationScreen::new);
    }
    
    @SubscribeEvent
    public static void recipesReceived(final RecipesReceivedEvent event) {
        
        NeoForgePlatformHelper.FOSSIL_PREP_RECIPES.clear();
        NeoForgePlatformHelper.FOSSIL_PREP_RECIPES.addAll(event.getRecipeMap().byType(DDRecipeTypes.FOSSIL_PREP.get()));
    }
    
    @SubscribeEvent
    public static void clientLogOut(final ClientPlayerNetworkEvent.LoggingOut event) {
        
        NeoForgePlatformHelper.FOSSIL_PREP_RECIPES.clear();
    }
    
}
