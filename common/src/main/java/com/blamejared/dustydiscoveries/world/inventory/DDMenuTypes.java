package com.blamejared.dustydiscoveries.world.inventory;

import com.blamejared.dustydiscoveries.DDConstants;
import com.blamejared.dustydiscoveries.platform.IRegister;
import com.blamejared.dustydiscoveries.platform.RegistrationProvider;
import com.blamejared.dustydiscoveries.platform.RegistryObject;
import com.blamejared.dustydiscoveries.platform.Services;
import com.google.auto.service.AutoService;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;

import java.util.Collection;

@AutoService(IRegister.class)
public class DDMenuTypes implements IRegister {
    
    private static final RegistrationProvider<MenuType<?>> MENUS = RegistrationProvider.get(Registries.MENU, DDConstants.MODID);
    public static final RegistryObject<MenuType<FossilPrepStationMenu>> FOSSIL_PREP_STATION = MENUS.register("fossil_prep_station", () -> Services.PLATFORM.createMenuType(FossilPrepStationMenu::new));
    
    public static Collection<RegistryObject<MenuType<?>>> getEntries() {
        
        return MENUS.getEntries();
    }
    
}
