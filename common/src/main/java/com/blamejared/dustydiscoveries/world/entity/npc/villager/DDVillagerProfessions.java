package com.blamejared.dustydiscoveries.world.entity.npc.villager;

import com.blamejared.dustydiscoveries.DDConstants;
import com.blamejared.dustydiscoveries.platform.IRegister;
import com.blamejared.dustydiscoveries.platform.RegistrationProvider;
import com.blamejared.dustydiscoveries.platform.RegistryObject;
import com.blamejared.dustydiscoveries.world.entity.ai.village.poi.DDPoiTypes;
import com.blamejared.dustydiscoveries.world.item.trading.DDTradeSets;
import com.google.auto.service.AutoService;
import com.google.common.collect.ImmutableSet;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.npc.villager.VillagerProfession;

import java.util.Collection;

@AutoService(IRegister.class)
public class DDVillagerProfessions implements IRegister {
    
    private static final RegistrationProvider<VillagerProfession> VILLAGER_PROFESSIONS = RegistrationProvider.get(Registries.VILLAGER_PROFESSION, DDConstants.MODID);
    public static final RegistryObject<VillagerProfession> PALEONTOLOGIST = VILLAGER_PROFESSIONS.register("paleontologist", () -> new VillagerProfession(Component.translatable("entity." + DDConstants.MODID + ".villager.paleontologist"), poiTypeHolder -> poiTypeHolder.is(DDPoiTypes.FOSSIL_PREP_STATION.getResourceKey()), poiTypeHolder -> poiTypeHolder.is(DDPoiTypes.FOSSIL_PREP_STATION.getResourceKey()), ImmutableSet.of(), ImmutableSet.of(), null, Int2ObjectMap.ofEntries(
            Int2ObjectMap.entry(1, DDTradeSets.PALEONTOLOGIST_1),
            Int2ObjectMap.entry(2, DDTradeSets.PALEONTOLOGIST_2),
            Int2ObjectMap.entry(3, DDTradeSets.PALEONTOLOGIST_3),
            Int2ObjectMap.entry(4, DDTradeSets.PALEONTOLOGIST_4),
            Int2ObjectMap.entry(5, DDTradeSets.PALEONTOLOGIST_5)
    )));
    
    public static Collection<RegistryObject<VillagerProfession>> getEntries() {
        
        return VILLAGER_PROFESSIONS.getEntries();
    }
    
}
