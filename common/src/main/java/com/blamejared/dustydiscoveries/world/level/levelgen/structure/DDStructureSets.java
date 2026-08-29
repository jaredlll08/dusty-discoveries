package com.blamejared.dustydiscoveries.world.level.levelgen.structure;

import com.blamejared.dustydiscoveries.DDConstants;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Mth;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;

public class DDStructureSets {
    
    public static final ResourceKey<StructureSet> FLOW_0 = DDConstants.rc(Registries.STRUCTURE_SET, "fossil/flow_0");
    public static final ResourceKey<StructureSet> FLOW_1 = DDConstants.rc(Registries.STRUCTURE_SET, "fossil/flow_1");
    public static final ResourceKey<StructureSet> FLOW_2 = DDConstants.rc(Registries.STRUCTURE_SET, "fossil/flow_2");
    
    public static final ResourceKey<StructureSet> SHELL_0 = DDConstants.rc(Registries.STRUCTURE_SET, "fossil/shell_0");
    public static final ResourceKey<StructureSet> SHELL_1 = DDConstants.rc(Registries.STRUCTURE_SET, "fossil/shell_1");
    public static final ResourceKey<StructureSet> SHELL_2 = DDConstants.rc(Registries.STRUCTURE_SET, "fossil/shell_2");
    
    public static final ResourceKey<StructureSet> SILENCE_0 = DDConstants.rc(Registries.STRUCTURE_SET, "fossil/silence_0");
    public static final ResourceKey<StructureSet> SILENCE_1 = DDConstants.rc(Registries.STRUCTURE_SET, "fossil/silence_1");
    
    public static final ResourceKey<StructureSet> SKULL_0 = DDConstants.rc(Registries.STRUCTURE_SET, "fossil/skull_0");
    public static final ResourceKey<StructureSet> SKULL_1 = DDConstants.rc(Registries.STRUCTURE_SET, "fossil/skull_1");
    
    public static final ResourceKey<StructureSet> SNOUT_0 = DDConstants.rc(Registries.STRUCTURE_SET, "fossil/snout_0");
    public static final ResourceKey<StructureSet> SNOUT_1 = DDConstants.rc(Registries.STRUCTURE_SET, "fossil/snout_1");
    
    public static final ResourceKey<StructureSet> TOOTH_0 = DDConstants.rc(Registries.STRUCTURE_SET, "fossil/tooth_0");
    
    public static void bootstrap(final BootstrapContext<StructureSet> context) {
        
        HolderGetter<Structure> structures = context.lookup(Registries.STRUCTURE);
        context.register(FLOW_0, fossil(structures, DDStructures.FLOW_0));
        context.register(FLOW_1, fossil(structures, DDStructures.FLOW_1));
        context.register(FLOW_2, fossil(structures, DDStructures.FLOW_2));
        context.register(SHELL_0, fossil(structures, DDStructures.SHELL_0));
        context.register(SHELL_1, fossil(structures, DDStructures.SHELL_1));
        context.register(SHELL_2, fossil(structures, DDStructures.SHELL_2));
        context.register(SILENCE_0, fossil(structures, DDStructures.SILENCE_0));
        context.register(SILENCE_1, fossil(structures, DDStructures.SILENCE_1));
        context.register(SKULL_0, fossil(structures, DDStructures.SKULL_0));
        context.register(SKULL_1, fossil(structures, DDStructures.SKULL_1));
        context.register(SNOUT_0, fossil(structures, DDStructures.SNOUT_0));
        context.register(SNOUT_1, fossil(structures, DDStructures.SNOUT_1));
        context.register(TOOTH_0, fossil(structures, DDStructures.TOOTH_0));
    }
    
    private static StructureSet fossil(final HolderGetter<Structure> structures, final ResourceKey<Structure> structureId) {
        
        return new StructureSet(structures.getOrThrow(structureId), new RandomSpreadStructurePlacement(24, 8, RandomSpreadType.LINEAR, salt(structureId)));
    }
    
    private static int salt(final ResourceKey<Structure> structureId) {
        return Mth.abs(structureId.identifier().hashCode());
    }
    
}
