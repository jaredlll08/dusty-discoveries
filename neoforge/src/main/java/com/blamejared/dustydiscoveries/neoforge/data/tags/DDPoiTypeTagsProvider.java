package com.blamejared.dustydiscoveries.neoforge.data.tags;

import com.blamejared.dustydiscoveries.DDConstants;
import com.blamejared.dustydiscoveries.world.entity.ai.village.poi.DDPoiTypes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.PoiTypeTags;
import net.minecraft.world.entity.ai.village.poi.PoiType;

import java.util.concurrent.CompletableFuture;

public class DDPoiTypeTagsProvider extends TagsProvider<PoiType> {
    
    public DDPoiTypeTagsProvider(final PackOutput output, final CompletableFuture<HolderLookup.Provider> lookup) {
        
        super(output, Registries.POINT_OF_INTEREST_TYPE, lookup, DDConstants.MODID);
    }
    
    @Override
    protected void addTags(final HolderLookup.Provider provider) {
        
        this.tag(PoiTypeTags.ACQUIRABLE_JOB_SITE).add(DDPoiTypes.FOSSIL_PREP_STATION.getResourceKey());
    }
    
}
