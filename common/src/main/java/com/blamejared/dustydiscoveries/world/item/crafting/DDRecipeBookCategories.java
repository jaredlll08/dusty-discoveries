package com.blamejared.dustydiscoveries.world.item.crafting;

import com.blamejared.dustydiscoveries.DDConstants;
import com.blamejared.dustydiscoveries.platform.IRegister;
import com.blamejared.dustydiscoveries.platform.RegistrationProvider;
import com.blamejared.dustydiscoveries.platform.RegistryObject;
import com.google.auto.service.AutoService;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeBookCategory;

import java.util.Collection;

@AutoService(IRegister.class)
public class DDRecipeBookCategories implements IRegister {
    
    private static final RegistrationProvider<RecipeBookCategory> RECIPE_BOOK_CATEGORY = RegistrationProvider.get(Registries.RECIPE_BOOK_CATEGORY, DDConstants.MODID);
    
    public static final RegistryObject<RecipeBookCategory> FOSSIL_PREP = RECIPE_BOOK_CATEGORY.register("fossil_prep", RecipeBookCategory::new);
    
    public static Collection<RegistryObject<RecipeBookCategory>> getEntries() {
        
        return RECIPE_BOOK_CATEGORY.getEntries();
    }
    
    
}
