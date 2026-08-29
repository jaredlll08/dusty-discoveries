package com.blamejared.dustydiscoveries.world.item.crafting;

import com.blamejared.dustydiscoveries.DDConstants;
import com.blamejared.dustydiscoveries.platform.IRegister;
import com.blamejared.dustydiscoveries.platform.RegistrationProvider;
import com.blamejared.dustydiscoveries.platform.RegistryObject;
import com.google.auto.service.AutoService;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeType;

import java.util.Collection;

@AutoService(IRegister.class)
public class DDRecipeTypes implements IRegister {
    
    private static final RegistrationProvider<RecipeType<?>> RECIPES = RegistrationProvider.get(Registries.RECIPE_TYPE, DDConstants.MODID);
    
    public static final RegistryObject<RecipeType<FossilPrepRecipe>> FOSSIL_PREP = RECIPES.register("fossil_prep", () -> new RecipeType<>() {
        @Override
        public String toString() {
            
            return DDConstants.id("fossil_prep").toString();
        }
    });
    
    public static Collection<RegistryObject<RecipeType<?>>> getEntries() {
        
        return RECIPES.getEntries();
    }
    
}
