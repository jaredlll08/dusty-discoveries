package com.blamejared.dustydiscoveries.compat.jei;

import com.blamejared.dustydiscoveries.world.item.crafting.DDRecipeTypes;
import com.blamejared.dustydiscoveries.world.item.crafting.FossilPrepRecipe;
import mezz.jei.api.recipe.types.IRecipeHolderType;

public class DDJEIRecipeTypes {
    
    public static final IRecipeHolderType<FossilPrepRecipe> FOSSIL_PREP_RECIPE_TYPE = IRecipeHolderType.create(DDRecipeTypes.FOSSIL_PREP.get());
    
}
