package com.blamejared.dustydiscoveries.fabric.platform;

import com.blamejared.dustydiscoveries.platform.IPlatformHelper;
import com.blamejared.dustydiscoveries.world.item.crafting.DDRecipeTypes;
import com.blamejared.dustydiscoveries.world.item.crafting.FossilPrepRecipe;
import com.google.auto.service.AutoService;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.Nullable;

import java.util.Collection;
import java.util.Collections;
import java.util.function.BiFunction;

@AutoService(IPlatformHelper.class)
public class FabricPlatformHelper implements IPlatformHelper {
    
    @Override
    public CreativeModeTab.Builder creativeTabBuilder() {
        
        return FabricCreativeModeTab.builder();
    }
    
    @Override
    public boolean isModLoaded(final String modId) {
        
        return FabricLoader.getInstance().isModLoaded(modId);
    }
    
    @Override
    public <T extends AbstractContainerMenu> MenuType<T> createMenuType(final BiFunction<Integer, Inventory, T> factory) {
        
        return new MenuType<>(factory::apply, FeatureFlagSet.of());
    }
    
    public Collection<RecipeHolder<FossilPrepRecipe>> getFossilPrepRecipes(final @Nullable Level level) {
        
        if(level == null) {
            return Collections.emptyList();
        }
        return level.recipeAccess().getSynchronizedRecipes().getAllOfType(DDRecipeTypes.FOSSIL_PREP.get());
    }
    
    
}
