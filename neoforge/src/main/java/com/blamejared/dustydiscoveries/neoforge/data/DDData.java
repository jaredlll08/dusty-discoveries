package com.blamejared.dustydiscoveries.neoforge.data;

import com.blamejared.dustydiscoveries.DDConstants;
import com.blamejared.dustydiscoveries.neoforge.data.tags.DDBlockTagsProvider;
import com.blamejared.dustydiscoveries.neoforge.data.tags.DDItemTagsProvider;
import com.blamejared.dustydiscoveries.neoforge.data.tags.DDPoiTypeTagsProvider;
import com.blamejared.dustydiscoveries.neoforge.data.tags.DDStructureTagsProvider;
import com.blamejared.dustydiscoveries.neoforge.data.tags.DDVillagerTradeTagsProvider;
import com.blamejared.dustydiscoveries.world.item.trading.DDTradeSets;
import com.blamejared.dustydiscoveries.world.item.trading.DDVillagerTrades;
import com.blamejared.dustydiscoveries.world.level.levelgen.structure.DDStructureSets;
import com.blamejared.dustydiscoveries.world.level.levelgen.structure.DDStructures;
import com.blamejared.dustydiscoveries.world.level.levelgen.structure.pools.DDTemplatePools;
import com.blamejared.dustydiscoveries.world.level.levelgen.structure.templatesystem.DDProcessorLists;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = DDConstants.MODID)
public class DDData {
    
    private static final RegistrySetBuilder REGISTRIES = new RegistrySetBuilder()
            .add(Registries.PROCESSOR_LIST, DDProcessorLists::bootstrap)
            .add(Registries.TEMPLATE_POOL, DDTemplatePools::bootstrap)
            .add(Registries.STRUCTURE, DDStructures::bootstrap)
            .add(Registries.STRUCTURE_SET, DDStructureSets::bootstrap)
            .add(Registries.VILLAGER_TRADE, DDVillagerTrades::bootstrap)
            .add(Registries.TRADE_SET, DDTradeSets::bootstrap);
    
    @SubscribeEvent
    public static void gatherClient(final GatherDataEvent.Client event) {
        
        PackOutput output = event.getGenerator().getPackOutput();
        DatapackBuiltinEntriesProvider datapackBuiltinEntriesProvider = event.addProvider(new DatapackBuiltinEntriesProvider(output, event.getLookupProvider(), REGISTRIES, Set.of(DDConstants.MODID)));
        CompletableFuture<HolderLookup.Provider> lookupProvider = datapackBuiltinEntriesProvider.getRegistryProvider();
        event.addProvider(new DDLangProvider(output));
        event.addProvider(new DDModelProvider(output));
        event.addProvider(new DDLootTables(output, lookupProvider));
        event.addProvider(new DDBlockTagsProvider(output, lookupProvider));
        event.addProvider(new DDItemTagsProvider(output, lookupProvider));
        event.addProvider(new DDPoiTypeTagsProvider(output, lookupProvider));
        event.addProvider(new DDVillagerTradeTagsProvider(output, lookupProvider));
        event.addProvider(new DDStructureTagsProvider(output, lookupProvider));
        event.addProvider(new DDRecipeProvider.Runner(output, lookupProvider));
        
    }
    
}
