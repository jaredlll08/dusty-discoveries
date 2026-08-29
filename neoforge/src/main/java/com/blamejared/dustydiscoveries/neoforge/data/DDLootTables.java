package com.blamejared.dustydiscoveries.neoforge.data;

import com.blamejared.dustydiscoveries.neoforge.data.loot.DDBlockLoot;
import com.blamejared.dustydiscoveries.neoforge.data.loot.DDFossilLoot;
import com.blamejared.dustydiscoveries.world.level.storage.loot.DDLoot;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class DDLootTables extends LootTableProvider {
    
    public DDLootTables(final PackOutput output, final CompletableFuture<HolderLookup.Provider> lookup) {
        
        super(output, DDLoot.getEntries(), List.of(
                new SubProviderEntry(DDBlockLoot::new, LootContextParamSets.BLOCK),
                new SubProviderEntry(DDFossilLoot::new, LootContextParamSets.ARCHAEOLOGY)
        ), lookup);
    }
    
}
