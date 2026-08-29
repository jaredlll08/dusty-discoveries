package com.blamejared.dustydiscoveries.world.item.crafting.display;

import com.blamejared.dustydiscoveries.DDConstants;
import com.blamejared.dustydiscoveries.platform.IRegister;
import com.blamejared.dustydiscoveries.platform.RegistrationProvider;
import com.blamejared.dustydiscoveries.platform.RegistryObject;
import com.google.auto.service.AutoService;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.display.RecipeDisplay;

import java.util.Collection;

@AutoService(IRegister.class)
public class DDRecipeDisplays implements IRegister {
    
    private static final RegistrationProvider<RecipeDisplay.Type<?>> RECIPE_DISPLAYS = RegistrationProvider.get(Registries.RECIPE_DISPLAY, DDConstants.MODID);
    
    public static final RegistryObject<RecipeDisplay.Type<FossilPrepRecipeDisplay>> FOSSIL_PREP = RECIPE_DISPLAYS.register("fossil_prep", () -> FossilPrepRecipeDisplay.TYPE);
    
    public static Collection<RegistryObject<RecipeDisplay.Type<?>>> getEntries() {
        
        return RECIPE_DISPLAYS.getEntries();
    }
    
}
