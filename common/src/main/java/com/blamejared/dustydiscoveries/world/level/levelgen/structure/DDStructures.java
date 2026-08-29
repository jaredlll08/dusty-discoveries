package com.blamejared.dustydiscoveries.world.level.levelgen.structure;

import com.blamejared.dustydiscoveries.DDConstants;
import com.blamejared.dustydiscoveries.world.level.levelgen.structure.pools.DDTemplatePools;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;

import java.util.List;
import java.util.Optional;

public class DDStructures {
    
    public static final ResourceKey<Structure> FLOW_0 = DDConstants.rc(Registries.STRUCTURE, "fossil/flow_0");
    public static final ResourceKey<Structure> FLOW_1 = DDConstants.rc(Registries.STRUCTURE, "fossil/flow_1");
    public static final ResourceKey<Structure> FLOW_2 = DDConstants.rc(Registries.STRUCTURE, "fossil/flow_2");
    
    public static final ResourceKey<Structure> SHELL_0 = DDConstants.rc(Registries.STRUCTURE, "fossil/shell_0");
    public static final ResourceKey<Structure> SHELL_1 = DDConstants.rc(Registries.STRUCTURE, "fossil/shell_1");
    public static final ResourceKey<Structure> SHELL_2 = DDConstants.rc(Registries.STRUCTURE, "fossil/shell_2");
    
    public static final ResourceKey<Structure> SILENCE_0 = DDConstants.rc(Registries.STRUCTURE, "fossil/silence_0");
    public static final ResourceKey<Structure> SILENCE_1 = DDConstants.rc(Registries.STRUCTURE, "fossil/silence_1");
    
    public static final ResourceKey<Structure> SKULL_0 = DDConstants.rc(Registries.STRUCTURE, "fossil/skull_0");
    public static final ResourceKey<Structure> SKULL_1 = DDConstants.rc(Registries.STRUCTURE, "fossil/skull_1");
    
    public static final ResourceKey<Structure> SNOUT_0 = DDConstants.rc(Registries.STRUCTURE, "fossil/snout_0");
    public static final ResourceKey<Structure> SNOUT_1 = DDConstants.rc(Registries.STRUCTURE, "fossil/snout_1");
    
    public static final ResourceKey<Structure> TOOTH_0 = DDConstants.rc(Registries.STRUCTURE, "fossil/tooth_0");
    
    public static void bootstrap(final BootstrapContext<Structure> context) {
        
        HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        
        context.register(FLOW_0, fossil(pools, biomes, DDTemplatePools.FLOW_0));
        context.register(FLOW_1, fossil(pools, biomes, DDTemplatePools.FLOW_1));
        context.register(FLOW_2, fossil(pools, biomes, DDTemplatePools.FLOW_2));
        context.register(SHELL_0, fossil(pools, biomes, DDTemplatePools.SHELL_0));
        context.register(SHELL_1, fossil(pools, biomes, DDTemplatePools.SHELL_1));
        context.register(SHELL_2, fossil(pools, biomes, DDTemplatePools.SHELL_2));
        context.register(SILENCE_0, fossil(pools, biomes, DDTemplatePools.SILENCE_0));
        context.register(SILENCE_1, fossil(pools, biomes, DDTemplatePools.SILENCE_1));
        context.register(SKULL_0, fossil(pools, biomes, DDTemplatePools.SKULL_0));
        context.register(SKULL_1, fossil(pools, biomes, DDTemplatePools.SKULL_1));
        context.register(SNOUT_0, fossil(pools, biomes, DDTemplatePools.SNOUT_0));
        context.register(SNOUT_1, fossil(pools, biomes, DDTemplatePools.SNOUT_1));
        context.register(TOOTH_0, fossil(pools, biomes, DDTemplatePools.TOOTH_0));
    }
    
    private static JigsawStructure fossil(final HolderGetter<StructureTemplatePool> pools, HolderGetter<Biome> biomes, final ResourceKey<StructureTemplatePool> startPoolId) {
        
        Structure.StructureSettings settings = new Structure.StructureSettings.Builder(biomes.getOrThrow(BiomeTags.HAS_MINESHAFT)).terrainAdapation(TerrainAdjustment.NONE)
                .generationStep(GenerationStep.Decoration.UNDERGROUND_STRUCTURES)
                .build();
        Holder.Reference<StructureTemplatePool> startPool = pools.getOrThrow(startPoolId);
        Optional<Heightmap.Types> worldSurfaceWg = Optional.empty();
        return new JigsawStructure(settings, startPool, Optional.empty(), 2, UniformHeight.of(VerticalAnchor.aboveBottom(10), VerticalAnchor.absolute(20)), false, worldSurfaceWg, new JigsawStructure.MaxDistance(116, 256), List.of(), JigsawStructure.DEFAULT_DIMENSION_PADDING, JigsawStructure.DEFAULT_LIQUID_SETTINGS);
    }
    
}
