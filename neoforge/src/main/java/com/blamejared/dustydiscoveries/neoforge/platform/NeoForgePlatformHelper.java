package com.blamejared.dustydiscoveries.neoforge.platform;

import com.blamejared.dustydiscoveries.mixin.AccessRecipeManager;
import com.blamejared.dustydiscoveries.platform.IPlatformHelper;
import com.blamejared.dustydiscoveries.world.item.crafting.DDRecipeTypes;
import com.blamejared.dustydiscoveries.world.item.crafting.FossilPrepRecipe;
import com.google.auto.service.AutoService;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.neoforged.fml.ModList;
import org.jspecify.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.function.BiFunction;

@AutoService(IPlatformHelper.class)
public class NeoForgePlatformHelper implements IPlatformHelper {
    
    @Override
    public CreativeModeTab.Builder creativeTabBuilder() {
        
        return new CreativeModeTab.Builder(CreativeModeTab.Row.TOP, 0);
    }
    
    @Override
    public boolean isModLoaded(final String modId) {
        
        return ModList.get().isLoaded(modId);
    }
    
    @Override
    public <T extends AbstractContainerMenu> MenuType<T> createMenuType(final BiFunction<Integer, Inventory, T> factory) {
        
        return new MenuType<>(factory::apply, FeatureFlagSet.of());
    }
    
    public static final Collection<RecipeHolder<FossilPrepRecipe>> FOSSIL_PREP_RECIPES = new ArrayList<>();
    
    @Override
    public Collection<RecipeHolder<FossilPrepRecipe>> getFossilPrepRecipes(final @Nullable Level level) {
        
        if(level == null) {
            return Collections.emptyList();
        }
        if(level.getServer() instanceof MinecraftServer server) {
            return ((AccessRecipeManager) server.getRecipeManager()).dustydiscoveries$getRecipes()
                    .byType(DDRecipeTypes.FOSSIL_PREP.get());
        }
        return FOSSIL_PREP_RECIPES;
    }
    
}
