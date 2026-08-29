package com.blamejared.dustydiscoveries.compat.jei;

import com.blamejared.dustydiscoveries.DDConstants;
import com.blamejared.dustydiscoveries.platform.Services;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.Identifier;

@JeiPlugin
public class DDJEIPlugin implements IModPlugin {
    
    @Override
    public Identifier getPluginUid() {
        
        return DDConstants.id("builtin");
    }
    
    @Override
    public void registerCategories(final IRecipeCategoryRegistration registration) {
        
        registration.addRecipeCategories(new FossilPrepCategory(registration.getJeiHelpers().getGuiHelper()));
    }
    
    @Override
    public void registerRecipes(final IRecipeRegistration registration) {
        
        registration.addRecipes(DDJEIRecipeTypes.FOSSIL_PREP_RECIPE_TYPE, Services.PLATFORM.getFossilPrepRecipes(Minecraft.getInstance().level)
                .stream()
                .toList());
    }
    
}
