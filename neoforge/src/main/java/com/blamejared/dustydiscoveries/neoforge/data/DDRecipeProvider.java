package com.blamejared.dustydiscoveries.neoforge.data;

import com.blamejared.dustydiscoveries.DDConstants;
import com.blamejared.dustydiscoveries.platform.RegistryObject;
import com.blamejared.dustydiscoveries.world.item.DDItems;
import com.blamejared.dustydiscoveries.world.item.crafting.FossilPrepRecipe;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ColorCollection;
import net.neoforged.neoforge.common.Tags;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class DDRecipeProvider extends RecipeProvider {
    
    
    protected DDRecipeProvider(final HolderLookup.Provider registries, final RecipeOutput output) {
        
        super(registries, output);
    }
    
    @Override
    protected void buildRecipes() {
        
        this.shaped(RecipeCategory.DECORATIONS, DDItems.FOSSIL_PREP_STATION.get())
                .pattern(" M ")
                .pattern("MBM")
                .pattern(" M ")
                .define('M', Items.PACKED_MUD)
                .define('B', Items.BRUSH)
                .unlockedBy(DDConstants.sid(getHasName(Items.BRUSH)), this.has(Items.BRUSH))
                .save(this.output);
        
        List<Item> dyes = Items.DYE.asList();
        this.colorItemWithDye(dyes, DDItems.DISPLAY_CASES.map(RegistryObject::get)
                .asList(), "display_case_dye", RecipeCategory.DECORATIONS);
        this.colorItemWithDye(dyes, DDItems.PALEONTOLOGIST_HATS.map(RegistryObject::get)
                .asList(), "paleontologist_hat_dye", RecipeCategory.DECORATIONS);
        
        ColorCollection.zipApply(DDItems.DISPLAY_CASES, Blocks.WOOL, (displayCase, wool) -> this.shaped(RecipeCategory.DECORATIONS, displayCase.get())
                .pattern("G")
                .pattern("W")
                .define('G', Tags.Items.GLASS_BLOCKS_COLORLESS)
                .define('W', wool)
                .unlockedBy(DDConstants.sid(getHasName(Items.GLASS)), this.has(Tags.Items.GLASS_BLOCKS_COLORLESS))
                .unlockedBy(DDConstants.sid(getHasName(wool)), this.has(ItemTags.WOOL))
                .save(this.output));
        
        fossilPrep(DDItems.ENCASED_FLOW_FOSSIL.get(), RecipeCategory.MISC, DDItems.FLOW_FOSSIL_0.get());
        fossilPrep(DDItems.ENCASED_FLOW_FOSSIL.get(), RecipeCategory.MISC, DDItems.FLOW_FOSSIL_1.get());
        fossilPrep(DDItems.ENCASED_FLOW_FOSSIL.get(), RecipeCategory.MISC, DDItems.FLOW_FOSSIL_2.get());
        fossilPrep(DDItems.ENCASED_FLOW_FOSSIL.get(), RecipeCategory.MISC, Items.BONE, 3);
        
        fossilPrep(DDItems.ENCASED_SHELL_FOSSIL.get(), RecipeCategory.MISC, DDItems.SHELL_FOSSIL_0.get());
        fossilPrep(DDItems.ENCASED_SHELL_FOSSIL.get(), RecipeCategory.MISC, DDItems.SHELL_FOSSIL_1.get());
        fossilPrep(DDItems.ENCASED_SHELL_FOSSIL.get(), RecipeCategory.MISC, DDItems.SHELL_FOSSIL_2.get());
        fossilPrep(DDItems.ENCASED_SHELL_FOSSIL.get(), RecipeCategory.MISC, Items.BONE, 3);
        
        fossilPrep(DDItems.ENCASED_SILENCE_FOSSIL.get(), RecipeCategory.MISC, DDItems.SILENCE_FOSSIL_0.get());
        fossilPrep(DDItems.ENCASED_SILENCE_FOSSIL.get(), RecipeCategory.MISC, DDItems.SILENCE_FOSSIL_1.get());
        fossilPrep(DDItems.ENCASED_SILENCE_FOSSIL.get(), RecipeCategory.MISC, DDItems.SILENCE_FOSSIL_2.get());
        fossilPrep(DDItems.ENCASED_SILENCE_FOSSIL.get(), RecipeCategory.MISC, DDItems.SILENCE_FOSSIL_3.get());
        fossilPrep(DDItems.ENCASED_SILENCE_FOSSIL.get(), RecipeCategory.MISC, Items.BONE, 3);
        
        fossilPrep(DDItems.ENCASED_SKULL_FOSSIL.get(), RecipeCategory.MISC, DDItems.SKULL_FOSSIL_0.get());
        fossilPrep(DDItems.ENCASED_SKULL_FOSSIL.get(), RecipeCategory.MISC, DDItems.SKULL_FOSSIL_1.get());
        fossilPrep(DDItems.ENCASED_SKULL_FOSSIL.get(), RecipeCategory.MISC, DDItems.SKULL_FOSSIL_2.get());
        fossilPrep(DDItems.ENCASED_SKULL_FOSSIL.get(), RecipeCategory.MISC, Items.BONE, 3);
        
        fossilPrep(DDItems.ENCASED_SNOUT_FOSSIL.get(), RecipeCategory.MISC, DDItems.SNOUT_FOSSIL_0.get());
        fossilPrep(DDItems.ENCASED_SNOUT_FOSSIL.get(), RecipeCategory.MISC, DDItems.SNOUT_FOSSIL_1.get());
        fossilPrep(DDItems.ENCASED_SNOUT_FOSSIL.get(), RecipeCategory.MISC, DDItems.SNOUT_FOSSIL_2.get());
        fossilPrep(DDItems.ENCASED_SNOUT_FOSSIL.get(), RecipeCategory.MISC, Items.BONE, 3);
        
        fossilPrep(DDItems.ENCASED_TOOTH_FOSSIL.get(), RecipeCategory.MISC, DDItems.TOOTH_FOSSIL_0.get());
        fossilPrep(DDItems.ENCASED_TOOTH_FOSSIL.get(), RecipeCategory.MISC, DDItems.TOOTH_FOSSIL_1.get());
        fossilPrep(DDItems.ENCASED_TOOTH_FOSSIL.get(), RecipeCategory.MISC, DDItems.TOOTH_FOSSIL_2.get());
        fossilPrep(DDItems.ENCASED_TOOTH_FOSSIL.get(), RecipeCategory.MISC, DDItems.TOOTH_FOSSIL_3.get());
        fossilPrep(DDItems.ENCASED_TOOTH_FOSSIL.get(), RecipeCategory.MISC, Items.BONE, 3);
    }
    
    private void fossilPrep(final ItemLike ingredient, final RecipeCategory category, final ItemLike result) {
        
        fossilPrep(ingredient, category, result, 1);
    }
    
    private void fossilPrep(final ItemLike ingredient, final RecipeCategory category, final ItemLike result, final int count) {
        
        new SingleItemRecipeBuilder(category, FossilPrepRecipe::new, Ingredient.of(ingredient), result, count)
                .unlockedBy(DDConstants.sid(getHasName(ingredient)), this.has(ingredient))
                .save(this.output, DDConstants.sid(getConversionRecipeName(result, ingredient) + "_fossil_prep"));
    }
    
    public static class Runner extends RecipeProvider.Runner {
        
        public Runner(final PackOutput output, final CompletableFuture<HolderLookup.Provider> lookupProvider) {
            
            super(output, lookupProvider);
        }
        
        @Override
        protected RecipeProvider createRecipeProvider(final HolderLookup.Provider provider, final RecipeOutput output) {
            
            return new DDRecipeProvider(provider, output);
        }
        
        @Override
        public String getName() {
            
            return "Dusty Discoveries Recipe Provider";
        }
        
    }
    
}
