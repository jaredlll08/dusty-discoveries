package com.blamejared.dustydiscoveries.world.entity.ai.village.poi;

import com.blamejared.dustydiscoveries.DDConstants;
import com.blamejared.dustydiscoveries.platform.IRegister;
import com.blamejared.dustydiscoveries.platform.RegistrationProvider;
import com.blamejared.dustydiscoveries.platform.RegistryObject;
import com.blamejared.dustydiscoveries.world.level.block.DDBlocks;
import com.google.auto.service.AutoService;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.village.poi.PoiType;

import java.util.Collection;
import java.util.Set;

@AutoService(IRegister.class)
public class DDPoiTypes implements IRegister {
    
    private static final RegistrationProvider<PoiType> POI_TYPES = RegistrationProvider.get(Registries.POINT_OF_INTEREST_TYPE, DDConstants.MODID);
    public static final RegistryObject<PoiType> FOSSIL_PREP_STATION = POI_TYPES.register("fossil_prep_station", () -> new PoiType(Set.of(DDBlocks.FOSSIL_PREP_STATION.get()
            .defaultBlockState()), 1, 1));
    
    public static Collection<RegistryObject<PoiType>> getEntries() {
        
        return POI_TYPES.getEntries();
    }
    
}
