package com.blamejared.dustydiscoveries.world.item.crafting;

import com.blamejared.dustydiscoveries.world.item.DDItems;
import com.blamejared.dustydiscoveries.world.item.crafting.display.FossilPrepRecipeDisplay;
import com.mojang.serialization.MapCodec;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeBookCategory;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleItemRecipe;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import net.minecraft.world.item.crafting.display.SlotDisplay;

import java.util.List;

public class FossilPrepRecipe extends SingleItemRecipe {
    
    public static final MapCodec<FossilPrepRecipe> MAP_CODEC = simpleMapCodec(FossilPrepRecipe::new);
    public static final StreamCodec<RegistryFriendlyByteBuf, FossilPrepRecipe> STREAM_CODEC = simpleStreamCodec(FossilPrepRecipe::new);
    public static final RecipeSerializer<FossilPrepRecipe> SERIALIZER = new RecipeSerializer<>(MAP_CODEC, STREAM_CODEC);
    
    public FossilPrepRecipe(final CommonInfo commonInfo, final Ingredient input, final ItemStackTemplate result) {
        
        super(commonInfo, input, result);
    }
    
    @Override
    public String group() {
        
        return "";
    }
    
    @Override
    public RecipeSerializer<? extends SingleItemRecipe> getSerializer() {
        
        return SERIALIZER;
    }
    
    @Override
    public RecipeType<? extends SingleItemRecipe> getType() {
        
        return DDRecipeTypes.FOSSIL_PREP.get();
    }
    
    @Override
    public List<RecipeDisplay> display() {
        
        return List.of(new FossilPrepRecipeDisplay(this.input()
                .display(), this.resultDisplay(), new SlotDisplay.ItemSlotDisplay(DDItems.FOSSIL_PREP_STATION.get())));
    }
    
    public SlotDisplay resultDisplay() {
        
        return new SlotDisplay.ItemStackSlotDisplay(this.result());
    }
    
    @Override
    public RecipeBookCategory recipeBookCategory() {
        
        return DDRecipeBookCategories.FOSSIL_PREP.get();
    }
    
}
