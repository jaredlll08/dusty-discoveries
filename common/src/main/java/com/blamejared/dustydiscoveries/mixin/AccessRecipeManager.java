package com.blamejared.dustydiscoveries.mixin;

import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeMap;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(RecipeManager.class)
public interface AccessRecipeManager {
    
    @Accessor("recipes")
    RecipeMap dustydiscoveries$getRecipes();
    
}
