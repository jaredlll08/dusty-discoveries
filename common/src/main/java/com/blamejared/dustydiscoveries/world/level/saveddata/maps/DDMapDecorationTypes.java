package com.blamejared.dustydiscoveries.world.level.saveddata.maps;

import com.blamejared.dustydiscoveries.DDConstants;
import com.blamejared.dustydiscoveries.platform.IRegister;
import com.blamejared.dustydiscoveries.platform.RegistrationProvider;
import com.blamejared.dustydiscoveries.platform.RegistryObject;
import com.google.auto.service.AutoService;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.saveddata.maps.MapDecorationType;

import java.util.Collection;

@AutoService(IRegister.class)
public class DDMapDecorationTypes implements IRegister {
    
    private static final RegistrationProvider<MapDecorationType> MAP_DECORATION_TYPES = RegistrationProvider.get(Registries.MAP_DECORATION_TYPE, DDConstants.MODID);
    public static final RegistryObject<MapDecorationType> FOSSIL = MAP_DECORATION_TYPES.register("fossil", () -> new MapDecorationType(DDConstants.id("fossil"), true, 0xffd3cfb9, true, false));
    
    public static Collection<RegistryObject<MapDecorationType>> getEntries() {
        
        return MAP_DECORATION_TYPES.getEntries();
    }
    
}
