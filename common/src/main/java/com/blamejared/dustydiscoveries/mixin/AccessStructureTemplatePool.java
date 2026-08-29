package com.blamejared.dustydiscoveries.mixin;

import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(StructureTemplatePool.class)
public interface AccessStructureTemplatePool {
    
    @Accessor("templates")
    ObjectArrayList<StructurePoolElement> dustydiscoveries$getTemplates();
    
    @Accessor("rawTemplates")
    List<Pair<StructurePoolElement, Integer>> dustydiscoveries$getRawTemplates();
    
    @Mutable
    @Accessor("rawTemplates")
    void setRawTemplates(final List<Pair<StructurePoolElement, Integer>> dustydiscoveries$rawTemplates);
    
}
