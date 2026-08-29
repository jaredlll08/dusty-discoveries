package com.blamejared.dustydiscoveries.neoforge.data.loot;

import com.blamejared.dustydiscoveries.world.level.block.DDBlocks;
import it.unimi.dsi.fastutil.objects.ReferenceOpenHashSet;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.Set;

public class DDBlockLoot extends BlockLootSubProvider {
    
    private final Set<Block> knownBlocks = new ReferenceOpenHashSet<>();
    
    public DDBlockLoot(final HolderLookup.Provider provider) {
        
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }
    
    @Override
    protected void generate() {
        
        DDBlocks.DISPLAY_CASES.forEach(blockRegistryObject -> this.dropSelf(blockRegistryObject.get()));
        this.dropOther(DDBlocks.FOSSILIZED_BONE_BLOCK.get(), Blocks.BONE_BLOCK);
        this.dropSelf(DDBlocks.FOSSIL_PREP_STATION.get());
    }
    
    @Override
    protected void add(final Block block, final LootTable.Builder table) {
        
        super.add(block, table);
        knownBlocks.add(block);
    }
    
    @Override
    protected Iterable<Block> getKnownBlocks() {
        
        return knownBlocks;
    }
    
}
