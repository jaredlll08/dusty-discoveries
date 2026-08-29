package com.blamejared.dustydiscoveries.neoforge;

import com.blamejared.dustydiscoveries.DDConstants;
import com.blamejared.dustydiscoveries.world.item.crafting.DDRecipeTypes;
import com.blamejared.dustydiscoveries.world.level.levelgen.DDLevelGen;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.OnDatapackSyncEvent;
import net.neoforged.neoforge.event.server.ServerAboutToStartEvent;

@EventBusSubscriber(modid = DDConstants.MODID)
public class DDEvents {
    
    @SubscribeEvent
    public static void datapackSync(final OnDatapackSyncEvent event) {
        
        event.sendRecipes(DDRecipeTypes.FOSSIL_PREP.get());
    }
    
    @SubscribeEvent
    public static void addNewVillageBuilding(final ServerAboutToStartEvent event) {
        
        DDLevelGen.addNewVillageBuilding(event.getServer().registryAccess());
    }
    
}
