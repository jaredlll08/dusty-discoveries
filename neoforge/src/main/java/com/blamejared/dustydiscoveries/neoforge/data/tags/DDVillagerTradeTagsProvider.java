package com.blamejared.dustydiscoveries.neoforge.data.tags;

import com.blamejared.dustydiscoveries.DDConstants;
import com.blamejared.dustydiscoveries.tags.DDTags;
import com.blamejared.dustydiscoveries.world.item.trading.DDVillagerTrades;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.item.trading.VillagerTrade;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unchecked")
public class DDVillagerTradeTagsProvider extends TagsProvider<VillagerTrade> {
    
    public DDVillagerTradeTagsProvider(final PackOutput output, final CompletableFuture<HolderLookup.Provider> lookup) {
        
        super(output, Registries.VILLAGER_TRADE, lookup, DDConstants.MODID);
    }
    
    @Override
    protected void addTags(final HolderLookup.Provider provider) {
        
        this.tag(DDTags.VillagerTrades.PALEONTOLOGIST_LEVEL_1)
                .add(
                        DDVillagerTrades.PALEONTOLOGIST_1_EMERALD_BRUSH,
                        DDVillagerTrades.PALEONTOLOGIST_1_EMERALD_AND_COMPASS_FLOW_FOSSIL_FIELD_NOTES,
                        DDVillagerTrades.PALEONTOLOGIST_1_EMERALD_AND_COMPASS_SHELL_FOSSIL_FIELD_NOTES,
                        DDVillagerTrades.PALEONTOLOGIST_1_EMERALD_AND_COMPASS_SILENCE_FOSSIL_FIELD_NOTES,
                        DDVillagerTrades.PALEONTOLOGIST_1_EMERALD_AND_COMPASS_SKULL_FOSSIL_FIELD_NOTES,
                        DDVillagerTrades.PALEONTOLOGIST_1_EMERALD_AND_COMPASS_SNOUT_FOSSIL_FIELD_NOTES,
                        DDVillagerTrades.PALEONTOLOGIST_1_EMERALD_AND_COMPASS_TOOTH_FOSSIL_FIELD_NOTES
                );
        this.tag(DDTags.VillagerTrades.PALEONTOLOGIST_LEVEL_2)
                .add(
                        DDVillagerTrades.PALEONTOLOGIST_2_EMERALD_UNBREAKING_BRUSH,
                        DDVillagerTrades.PALEONTOLOGIST_2_EMERALD_AND_COMPASS_FLOW_FOSSIL_FIELD_NOTES,
                        DDVillagerTrades.PALEONTOLOGIST_2_EMERALD_AND_COMPASS_SHELL_FOSSIL_FIELD_NOTES,
                        DDVillagerTrades.PALEONTOLOGIST_2_EMERALD_AND_COMPASS_SILENCE_FOSSIL_FIELD_NOTES,
                        DDVillagerTrades.PALEONTOLOGIST_2_EMERALD_AND_COMPASS_SKULL_FOSSIL_FIELD_NOTES,
                        DDVillagerTrades.PALEONTOLOGIST_2_EMERALD_AND_COMPASS_SNOUT_FOSSIL_FIELD_NOTES,
                        DDVillagerTrades.PALEONTOLOGIST_2_EMERALD_AND_COMPASS_TOOTH_FOSSIL_FIELD_NOTES
                );
        this.tag(DDTags.VillagerTrades.PALEONTOLOGIST_LEVEL_3)
                .addAll(DDVillagerTrades.PALEONTOLOGIST_3_DISPLAY_CASES.asList().stream());
        this.tag(DDTags.VillagerTrades.PALEONTOLOGIST_LEVEL_4)
                .add(
                        DDVillagerTrades.PALEONTOLOGIST_4_EMERALD_FIELD_NOTES,
                        DDVillagerTrades.PALEONTOLOGIST_4_EMERALD_UNBREAKING_BRUSH
                );
        this.tag(DDTags.VillagerTrades.PALEONTOLOGIST_LEVEL_5)
                .addAll(DDVillagerTrades.PALEONTOLOGIST_5_EMERALD_PALEONTOLOGIST_HATS.asList().stream())
                .add(
                        DDVillagerTrades.PALEONTOLOGIST_5_EMERALD_UNBREAKING_BRUSH
                );
    }
    
}
