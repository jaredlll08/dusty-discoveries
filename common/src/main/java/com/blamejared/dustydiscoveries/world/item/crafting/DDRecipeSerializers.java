package com.blamejared.dustydiscoveries.world.item.crafting;

import com.blamejared.dustydiscoveries.DDConstants;
import com.blamejared.dustydiscoveries.platform.IRegister;
import com.blamejared.dustydiscoveries.platform.RegistrationProvider;
import com.blamejared.dustydiscoveries.platform.RegistryObject;
import com.google.auto.service.AutoService;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;

import java.util.Collection;

@AutoService(IRegister.class)
public class DDRecipeSerializers implements IRegister {
    
    private static final RegistrationProvider<RecipeSerializer<?>> RECIPE_SERIALIZERS = RegistrationProvider.get(Registries.RECIPE_SERIALIZER, DDConstants.MODID);
    
    public static final RegistryObject<RecipeSerializer<?>> FOSSIL_PREP = RECIPE_SERIALIZERS.register("fossil_prep", () -> FossilPrepRecipe.SERIALIZER);
    
    public static Collection<RegistryObject<RecipeSerializer<?>>> getEntries() {
        
        return RECIPE_SERIALIZERS.getEntries();
    }
    
}
