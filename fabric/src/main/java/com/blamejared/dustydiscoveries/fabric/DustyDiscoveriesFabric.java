package com.blamejared.dustydiscoveries.fabric;

import com.blamejared.dustydiscoveries.DustyDiscoveries;
import com.blamejared.dustydiscoveries.mixin.AccessPoiTypes;
import com.blamejared.dustydiscoveries.world.entity.ai.village.poi.DDPoiTypes;
import com.blamejared.dustydiscoveries.world.item.DDItems;
import com.blamejared.dustydiscoveries.world.item.crafting.DDRecipeSerializers;
import com.blamejared.dustydiscoveries.world.item.crafting.DDRecipeTypes;
import com.blamejared.dustydiscoveries.world.level.block.DDBlocks;
import com.blamejared.dustydiscoveries.world.level.levelgen.DDLevelGen;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.recipe.v1.sync.RecipeSynchronization;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.state.BlockState;

public class DustyDiscoveriesFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        
        DustyDiscoveries.init();
        DDBlocks.modifyBlockEntityTypes();
        ServerLifecycleEvents.SERVER_STARTING.register(server -> DDLevelGen.addNewVillageBuilding(server.registryAccess()));
        RecipeSynchronization.synchronizeRecipeSerializer(DDRecipeSerializers.FOSSIL_PREP.get());
        
        // NeoForge patches the game so this isn't required, need to do it manually here though
        Holder.Reference<PoiType> poiType = BuiltInRegistries.POINT_OF_INTEREST_TYPE.getOrThrow(DDPoiTypes.FOSSIL_PREP_STATION.getResourceKey());
        for(BlockState possibleState : DDBlocks.FOSSIL_PREP_STATION.get().getStateDefinition().getPossibleStates()) {
            AccessPoiTypes.dustydiscoveries$getTYPE_BY_STATE().put(possibleState, poiType);
        }
    }
    
}
