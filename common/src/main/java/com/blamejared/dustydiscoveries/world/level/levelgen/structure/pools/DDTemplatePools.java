package com.blamejared.dustydiscoveries.world.level.levelgen.structure.pools;

import com.blamejared.dustydiscoveries.DDConstants;
import com.blamejared.dustydiscoveries.world.level.levelgen.structure.templatesystem.DDProcessorLists;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

import java.util.List;
import java.util.function.Function;

public class DDTemplatePools {
    
    public static final ResourceKey<StructureTemplatePool> FLOW_0 = DDConstants.rc(Registries.TEMPLATE_POOL, "fossil/flow_0");
    public static final ResourceKey<StructureTemplatePool> FLOW_1 = DDConstants.rc(Registries.TEMPLATE_POOL, "fossil/flow_1");
    public static final ResourceKey<StructureTemplatePool> FLOW_2 = DDConstants.rc(Registries.TEMPLATE_POOL, "fossil/flow_2");
    
    public static final ResourceKey<StructureTemplatePool> SHELL_0 = DDConstants.rc(Registries.TEMPLATE_POOL, "fossil/shell_0");
    public static final ResourceKey<StructureTemplatePool> SHELL_1 = DDConstants.rc(Registries.TEMPLATE_POOL, "fossil/shell_1");
    public static final ResourceKey<StructureTemplatePool> SHELL_2 = DDConstants.rc(Registries.TEMPLATE_POOL, "fossil/shell_2");
    
    public static final ResourceKey<StructureTemplatePool> SILENCE_0 = DDConstants.rc(Registries.TEMPLATE_POOL, "fossil/silence_0");
    public static final ResourceKey<StructureTemplatePool> SILENCE_1 = DDConstants.rc(Registries.TEMPLATE_POOL, "fossil/silence_1");
    
    public static final ResourceKey<StructureTemplatePool> SKULL_0 = DDConstants.rc(Registries.TEMPLATE_POOL, "fossil/skull_0");
    public static final ResourceKey<StructureTemplatePool> SKULL_1 = DDConstants.rc(Registries.TEMPLATE_POOL, "fossil/skull_1");
    
    public static final ResourceKey<StructureTemplatePool> SNOUT_0 = DDConstants.rc(Registries.TEMPLATE_POOL, "fossil/snout_0");
    public static final ResourceKey<StructureTemplatePool> SNOUT_1 = DDConstants.rc(Registries.TEMPLATE_POOL, "fossil/snout_1");
    
    public static final ResourceKey<StructureTemplatePool> TOOTH_0 = DDConstants.rc(Registries.TEMPLATE_POOL, "fossil/tooth_0");
    
    public static void bootstrap(final BootstrapContext<StructureTemplatePool> context) {
        
        HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);
        Holder<StructureTemplatePool> empty = pools.getOrThrow(Pools.EMPTY);
        HolderGetter<StructureProcessorList> processorLists = context.lookup(Registries.PROCESSOR_LIST);
        
        context.register(FLOW_0, fossil(empty, processorLists, DDProcessorLists.FOSSILIZE_FLOW, com.blamejared.dustydiscoveries.world.level.levelgen.structure.DDStructures.FLOW_0));
        context.register(FLOW_1, fossil(empty, processorLists, DDProcessorLists.FOSSILIZE_FLOW, com.blamejared.dustydiscoveries.world.level.levelgen.structure.DDStructures.FLOW_1));
        context.register(FLOW_2, fossil(empty, processorLists, DDProcessorLists.FOSSILIZE_FLOW, com.blamejared.dustydiscoveries.world.level.levelgen.structure.DDStructures.FLOW_2));
        context.register(SHELL_0, fossil(empty, processorLists, DDProcessorLists.FOSSILIZE_SHELL, com.blamejared.dustydiscoveries.world.level.levelgen.structure.DDStructures.SHELL_0));
        context.register(SHELL_1, fossil(empty, processorLists, DDProcessorLists.FOSSILIZE_SHELL, com.blamejared.dustydiscoveries.world.level.levelgen.structure.DDStructures.SHELL_1));
        context.register(SHELL_2, fossil(empty, processorLists, DDProcessorLists.FOSSILIZE_SHELL, com.blamejared.dustydiscoveries.world.level.levelgen.structure.DDStructures.SHELL_2));
        context.register(SILENCE_0, fossil(empty, processorLists, DDProcessorLists.FOSSILIZE_SILENCE, com.blamejared.dustydiscoveries.world.level.levelgen.structure.DDStructures.SILENCE_0));
        context.register(SILENCE_1, fossil(empty, processorLists, DDProcessorLists.FOSSILIZE_SILENCE, com.blamejared.dustydiscoveries.world.level.levelgen.structure.DDStructures.SILENCE_1));
        context.register(SKULL_0, fossil(empty, processorLists, DDProcessorLists.FOSSILIZE_SKULL, com.blamejared.dustydiscoveries.world.level.levelgen.structure.DDStructures.SKULL_0));
        context.register(SKULL_1, fossil(empty, processorLists, DDProcessorLists.FOSSILIZE_SKULL, com.blamejared.dustydiscoveries.world.level.levelgen.structure.DDStructures.SKULL_1));
        context.register(SNOUT_0, fossil(empty, processorLists, DDProcessorLists.FOSSILIZE_SNOUT, com.blamejared.dustydiscoveries.world.level.levelgen.structure.DDStructures.SNOUT_0));
        context.register(SNOUT_1, fossil(empty, processorLists, DDProcessorLists.FOSSILIZE_SNOUT, com.blamejared.dustydiscoveries.world.level.levelgen.structure.DDStructures.SNOUT_1));
        context.register(TOOTH_0, fossil(empty, processorLists, DDProcessorLists.FOSSILIZE_TOOTH, com.blamejared.dustydiscoveries.world.level.levelgen.structure.DDStructures.TOOTH_0));
    }
    
    
    private static Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer> elementPair(final String structureId, final Holder.Reference<StructureProcessorList> fossilized) {
        
        return Pair.of(StructurePoolElement.single(structureId, fossilized), 1);
    }
    
    private static StructureTemplatePool fossil(final Holder<StructureTemplatePool> empty, final HolderGetter<StructureProcessorList> processorLists, final ResourceKey<StructureProcessorList> processorListId, final ResourceKey<Structure> structureId) {
        
        Holder.Reference<StructureProcessorList> fossilized = processorLists.getOrThrow(processorListId);
        return new StructureTemplatePool(empty, List.of(elementPair(structureId.identifier()
                .toString(), fossilized)), StructureTemplatePool.Projection.RIGID);
    }
    
}
