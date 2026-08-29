package com.blamejared.dustydiscoveries.neoforge.data.tags;

import com.blamejared.dustydiscoveries.DDConstants;
import com.blamejared.dustydiscoveries.tags.DDTags;
import com.blamejared.dustydiscoveries.world.level.levelgen.structure.DDStructures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.levelgen.structure.Structure;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unchecked")
public class DDStructureTagsProvider extends TagsProvider<Structure> {
    
    public DDStructureTagsProvider(final PackOutput output, final CompletableFuture<HolderLookup.Provider> lookup) {
        
        super(output, Registries.STRUCTURE, lookup, DDConstants.MODID);
    }
    
    @Override
    protected void addTags(final HolderLookup.Provider provider) {
        
        this.tag(DDTags.Structures.FLOW_FOSSILS).add(DDStructures.FLOW_0, DDStructures.FLOW_1, DDStructures.FLOW_2);
        this.tag(DDTags.Structures.SHELL_FOSSILS).add(DDStructures.SHELL_0, DDStructures.SHELL_1, DDStructures.SHELL_2);
        this.tag(DDTags.Structures.SILENCE_FOSSILS).add(DDStructures.SILENCE_0, DDStructures.SILENCE_1);
        this.tag(DDTags.Structures.SKULL_FOSSILS).add(DDStructures.SKULL_0, DDStructures.SKULL_1);
        this.tag(DDTags.Structures.SNOUT_FOSSILS).add(DDStructures.SNOUT_0, DDStructures.SNOUT_1);
        this.tag(DDTags.Structures.TOOTH_FOSSILS).add(DDStructures.TOOTH_0);
        this.tag(DDTags.Structures.FOSSILS)
                .addTags(DDTags.Structures.FLOW_FOSSILS, DDTags.Structures.SHELL_FOSSILS, DDTags.Structures.SILENCE_FOSSILS, DDTags.Structures.SKULL_FOSSILS, DDTags.Structures.SNOUT_FOSSILS, DDTags.Structures.TOOTH_FOSSILS);
    }
    
}
