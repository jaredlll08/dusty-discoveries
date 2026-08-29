package com.blamejared.dustydiscoveries.platform;

import com.blamejared.dustydiscoveries.world.item.crafting.FossilPrepRecipe;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.Nullable;

import java.util.Collection;
import java.util.function.BiFunction;

public interface IPlatformHelper {
    
    CreativeModeTab.Builder creativeTabBuilder();
    
    boolean isModLoaded(final String modId);
    
    <T extends AbstractContainerMenu> MenuType<T> createMenuType(final BiFunction<Integer, Inventory, T> factory);
    
    Collection<RecipeHolder<FossilPrepRecipe>> getFossilPrepRecipes(final @Nullable Level level);
    
}
