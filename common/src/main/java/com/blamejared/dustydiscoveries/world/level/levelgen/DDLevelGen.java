package com.blamejared.dustydiscoveries.world.level.levelgen;

import com.blamejared.dustydiscoveries.DDConstants;
import com.blamejared.dustydiscoveries.mixin.AccessStructureTemplatePool;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.pools.SinglePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

import java.util.ArrayList;
import java.util.List;

public class DDLevelGen {
    
    private static final ResourceKey<StructureProcessorList> EMPTY_PROCESSOR_LIST_KEY = ResourceKey.create(
            Registries.PROCESSOR_LIST, Identifier.withDefaultNamespace("empty"));
    
    public static void addNewVillageBuilding(final RegistryAccess registryAccess) {
        
        Registry<StructureTemplatePool> templatePoolRegistry = registryAccess.lookupOrThrow(Registries.TEMPLATE_POOL);
        Registry<StructureProcessorList> processorListRegistry = registryAccess.lookupOrThrow(Registries.PROCESSOR_LIST);
        
        addBuildingToPool(templatePoolRegistry, processorListRegistry,
                Identifier.withDefaultNamespace("village/plains/houses"),
                DDConstants.sid("village/plains/houses/paleontologist"), 7);
        
        addBuildingToPool(templatePoolRegistry, processorListRegistry,
                Identifier.withDefaultNamespace("village/snowy/houses"),
                DDConstants.sid("village/snowy/houses/paleontologist"), 7);
        
        addBuildingToPool(templatePoolRegistry, processorListRegistry,
                Identifier.withDefaultNamespace("village/savanna/houses"),
                DDConstants.sid("village/savanna/houses/paleontologist"), 7);
        
        addBuildingToPool(templatePoolRegistry, processorListRegistry,
                Identifier.withDefaultNamespace("village/taiga/houses"),
                DDConstants.sid("village/taiga/houses/paleontologist"), 7);
        
        addBuildingToPool(templatePoolRegistry, processorListRegistry,
                Identifier.withDefaultNamespace("village/desert/houses"),
                DDConstants.sid("village/desert/houses/paleontologist"), 7);
    }
    
    private static void addBuildingToPool(final Registry<StructureTemplatePool> templatePoolRegistry,
                                          final Registry<StructureProcessorList> processorListRegistry,
                                          final Identifier poolRL,
                                          final String nbtPieceRL,
                                          final int weight) {
        
        Holder<StructureProcessorList> emptyProcessorList = processorListRegistry.getOrThrow(EMPTY_PROCESSOR_LIST_KEY);
        
        if(!(templatePoolRegistry.getValue(poolRL) instanceof AccessStructureTemplatePool pool)) {
            return;
        }
        SinglePoolElement piece = SinglePoolElement.single(nbtPieceRL, emptyProcessorList)
                .apply(StructureTemplatePool.Projection.RIGID);
        
        for(int i = 0; i < weight; i++) {
            pool.dustydiscoveries$getTemplates().add(piece);
        }
        
        List<Pair<StructurePoolElement, Integer>> listOfPieceEntries = new ArrayList<>(pool.dustydiscoveries$getRawTemplates());
        listOfPieceEntries.add(new Pair<>(piece, weight));
        pool.setRawTemplates(listOfPieceEntries);
    }
    
}
