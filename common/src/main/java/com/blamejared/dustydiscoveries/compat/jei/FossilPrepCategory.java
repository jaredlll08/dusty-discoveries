package com.blamejared.dustydiscoveries.compat.jei;

import com.blamejared.dustydiscoveries.world.item.crafting.FossilPrepRecipe;
import com.blamejared.dustydiscoveries.world.item.crafting.display.FossilPrepRecipeDisplay;
import com.blamejared.dustydiscoveries.world.level.block.DDBlocks;
import com.mojang.serialization.Codec;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.widgets.IRecipeExtrasBuilder;
import mezz.jei.api.helpers.ICodecHelper;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.IRecipeManager;
import mezz.jei.api.recipe.category.AbstractRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.display.RecipeDisplay;

public class FossilPrepCategory extends AbstractRecipeCategory<RecipeHolder<FossilPrepRecipe>> {
    
    public static final int width = 82;
    public static final int height = 34;
    
    public FossilPrepCategory(final IGuiHelper guiHelper) {
        
        super(
                DDJEIRecipeTypes.FOSSIL_PREP_RECIPE_TYPE,
                Component.translatable("gui.dustydiscoveries.jei.category.fossilprep"),
                guiHelper.createDrawableItemLike(DDBlocks.FOSSIL_PREP_STATION.get()),
                width,
                height
        );
    }
    
    @Override
    public void setRecipe(final IRecipeLayoutBuilder builder, final RecipeHolder<FossilPrepRecipe> recipeHolder, final IFocusGroup focuses) {
        
        FossilPrepRecipe recipe = recipeHolder.value();
        RecipeDisplay display = recipe.display().getFirst();
        if(display instanceof FossilPrepRecipeDisplay recipeDisplay) {
            builder.addInputSlot(1, 9)
                    .setStandardSlotBackground()
                    .add(recipeDisplay.input());
            
            builder.addOutputSlot(61, 9)
                    .setOutputSlotBackground()
                    .add(recipeDisplay.result());
        }
    }
    
    @Override
    public void createRecipeExtras(final IRecipeExtrasBuilder builder, final RecipeHolder<FossilPrepRecipe> recipe, final IFocusGroup focuses) {
        
        builder.addRecipeArrow().setPosition(26, 9);
    }
    
    @Override
    public boolean isHandled(final RecipeHolder<FossilPrepRecipe> recipeHolder) {
        
        FossilPrepRecipe recipe = recipeHolder.value();
        return !recipe.isSpecial();
    }
    
    @Override
    public Identifier getIdentifier(final RecipeHolder<FossilPrepRecipe> recipe) {
        
        return recipe.id().identifier();
    }
    
    @Override
    public Codec<RecipeHolder<FossilPrepRecipe>> getCodec(final ICodecHelper codecHelper, final IRecipeManager recipeManager) {
        
        return codecHelper.getRecipeHolderCodec();
    }
    
}
