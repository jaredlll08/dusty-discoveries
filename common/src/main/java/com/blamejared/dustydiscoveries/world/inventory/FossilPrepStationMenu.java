package com.blamejared.dustydiscoveries.world.inventory;

import com.blamejared.dustydiscoveries.platform.Services;
import com.blamejared.dustydiscoveries.world.item.crafting.FossilPrepRecipe;
import com.blamejared.dustydiscoveries.world.level.block.DDBlocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Util;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.DataSlot;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.ResultContainer;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.SelectableRecipe;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class FossilPrepStationMenu extends AbstractContainerMenu {
    
    public static final int INPUT_SLOT = 0;
    public static final int RESULT_SLOT = 1;
    private static final int INV_SLOT_START = 2;
    private static final int INV_SLOT_END = 29;
    private static final int USE_ROW_SLOT_END = 38;
    private final ContainerLevelAccess access;
    private final DataSlot selectedRecipeIndex = DataSlot.standalone();
    private final Level level;
    private SelectableRecipe.SingleInputSet<FossilPrepRecipe> recipesForInput = SelectableRecipe.SingleInputSet.empty();
    private final Function<Collection<RecipeHolder<FossilPrepRecipe>>, SelectableRecipe.SingleInputSet<FossilPrepRecipe>> cachedRecipes = Util.memoize((recipeHolders) -> new SelectableRecipe.SingleInputSet<>(recipeHolders.stream()
            .map(fossilPrepRecipe -> new SelectableRecipe.SingleInputEntry<>(fossilPrepRecipe.value()
                    .input(), new SelectableRecipe<>(fossilPrepRecipe.value()
                    .resultDisplay(), Optional.of(fossilPrepRecipe))))
            .toList()));
    private ItemStack input = ItemStack.EMPTY;
    private long lastSoundTime;
    private final Slot inputSlot;
    private final Slot resultSlot;
    private Runnable slotUpdateListener = () -> {};
    public final Container container = new SimpleContainer(1) {
        @Override
        public void setChanged() {
            
            super.setChanged();
            FossilPrepStationMenu.this.slotsChanged(this);
            FossilPrepStationMenu.this.slotUpdateListener.run();
        }
    };
    private final ResultContainer resultContainer = new ResultContainer();
    
    public FossilPrepStationMenu(final int containerId, final Inventory inventory) {
        
        this(containerId, inventory, ContainerLevelAccess.NULL);
    }
    
    public FossilPrepStationMenu(final int containerId, final Inventory inventory, final ContainerLevelAccess access) {
        
        super(DDMenuTypes.FOSSIL_PREP_STATION.get(), containerId);
        this.access = access;
        this.level = inventory.player.level();
        this.inputSlot = this.addSlot(new Slot(this.container, INPUT_SLOT, 20, 33));
        this.resultSlot = this.addSlot(new Slot(this.resultContainer, RESULT_SLOT, 143, 33) {
            @Override
            public boolean mayPlace(final ItemStack itemStack) {
                
                return false;
            }
            
            @Override
            public void onTake(final Player player, final ItemStack carried) {
                
                carried.onCraftedBy(player, carried.getCount());
                FossilPrepStationMenu.this.resultContainer.awardUsedRecipes(player, this.getRelevantItems());
                ItemStack remaining = FossilPrepStationMenu.this.inputSlot.remove(1);
                if(!remaining.isEmpty()) {
                    FossilPrepStationMenu.this.setupResultSlot(FossilPrepStationMenu.this.selectedRecipeIndex.get());
                }
                
                access.execute((level, pos) -> {
                    long gameTime = level.getGameTime();
                    if(FossilPrepStationMenu.this.lastSoundTime != gameTime) {
                        level.playSound(null, pos, SoundEvents.UI_STONECUTTER_TAKE_RESULT, SoundSource.BLOCKS, 1.0F, 1.0F);
                        FossilPrepStationMenu.this.lastSoundTime = gameTime;
                    }
                });
                super.onTake(player, carried);
            }
            
            private List<ItemStack> getRelevantItems() {
                
                return List.of(FossilPrepStationMenu.this.inputSlot.getItem());
            }
        });
        this.addStandardInventorySlots(inventory, 8, 84);
        this.addDataSlot(this.selectedRecipeIndex);
    }
    
    public int getSelectedRecipeIndex() {
        
        return this.selectedRecipeIndex.get();
    }
    
    public SelectableRecipe.SingleInputSet<FossilPrepRecipe> getVisibleRecipes() {
        
        return this.recipesForInput;
    }
    
    public int getNumberOfVisibleRecipes() {
        
        return this.recipesForInput.size();
    }
    
    public boolean hasInputItem() {
        
        return this.inputSlot.hasItem() && !this.recipesForInput.isEmpty();
    }
    
    @Override
    public boolean stillValid(final Player player) {
        
        return stillValid(this.access, player, DDBlocks.FOSSIL_PREP_STATION.get());
    }
    
    @Override
    public boolean clickMenuButton(final Player player, final int buttonId) {
        
        if(this.selectedRecipeIndex.get() == buttonId) {
            return false;
        }
        
        if(this.isValidRecipeIndex(buttonId)) {
            this.selectedRecipeIndex.set(buttonId);
            this.setupResultSlot(buttonId);
        }
        
        return true;
    }
    
    private boolean isValidRecipeIndex(final int buttonId) {
        
        return buttonId >= 0 && buttonId < this.recipesForInput.size();
    }
    
    @Override
    public void slotsChanged(final Container container) {
        
        ItemStack input = this.inputSlot.getItem();
        if(!input.is(this.input.getItem())) {
            this.input = input.copy();
            this.setupRecipeList(input);
        }
    }
    
    private void setupRecipeList(final ItemStack item) {
        
        this.selectedRecipeIndex.set(-1);
        this.resultSlot.set(ItemStack.EMPTY);
        if(!item.isEmpty()) {
            this.recipesForInput = cachedRecipes().selectByInput(item);
        } else {
            this.recipesForInput = SelectableRecipe.SingleInputSet.empty();
        }
    }
    
    private void setupResultSlot(final int index) {
        
        Optional<RecipeHolder<FossilPrepRecipe>> usedRecipe;
        if(!this.recipesForInput.isEmpty() && this.isValidRecipeIndex(index)) {
            SelectableRecipe.SingleInputEntry<FossilPrepRecipe> entry = this.recipesForInput.entries().get(index);
            usedRecipe = entry.recipe().recipe();
        } else {
            usedRecipe = Optional.empty();
        }
        
        usedRecipe.ifPresentOrElse(recipe -> {
            this.resultContainer.setRecipeUsed(recipe);
            this.resultSlot.set(recipe.value().assemble(new SingleRecipeInput(this.container.getItem(INPUT_SLOT))));
        }, () -> {
            this.resultSlot.set(ItemStack.EMPTY);
            this.resultContainer.setRecipeUsed(null);
        });
        this.broadcastChanges();
    }
    
    @Override
    public MenuType<?> getType() {
        
        return DDMenuTypes.FOSSIL_PREP_STATION.get();
    }
    
    public void registerUpdateListener(final Runnable slotUpdateListener) {
        
        this.slotUpdateListener = slotUpdateListener;
    }
    
    @Override
    public boolean canTakeItemForPickAll(final ItemStack carried, final Slot target) {
        
        return target.container != this.resultContainer && super.canTakeItemForPickAll(carried, target);
    }
    
    @Override
    public ItemStack quickMoveStack(final Player player, final int slotIndex) {
        
        ItemStack clicked = ItemStack.EMPTY;
        Slot slot = this.slots.get(slotIndex);
        if(slot.hasItem()) {
            ItemStack stack = slot.getItem();
            Item item = stack.getItem();
            clicked = stack.copy();
            if(slotIndex == RESULT_SLOT) {
                item.onCraftedBy(stack, player);
                if(!this.moveItemStackTo(stack, INV_SLOT_START, USE_ROW_SLOT_END, true)) {
                    return ItemStack.EMPTY;
                }
                
                slot.onQuickCraft(stack, clicked);
            } else if(slotIndex == INPUT_SLOT) {
                if(!this.moveItemStackTo(stack, INV_SLOT_START, USE_ROW_SLOT_END, false)) {
                    return ItemStack.EMPTY;
                }
            } else if(cachedRecipes().acceptsInput(stack)) {
                if(!this.moveItemStackTo(stack, 0, 1, false)) {
                    return ItemStack.EMPTY;
                }
            } else if(slotIndex >= INV_SLOT_START && slotIndex < INV_SLOT_END) {
                if(!this.moveItemStackTo(stack, INV_SLOT_END, USE_ROW_SLOT_END, false)) {
                    return ItemStack.EMPTY;
                }
            } else if(slotIndex >= INV_SLOT_END && slotIndex < USE_ROW_SLOT_END && !this.moveItemStackTo(stack, INV_SLOT_START, INV_SLOT_END, false)) {
                return ItemStack.EMPTY;
            }
            
            if(stack.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            }
            
            slot.setChanged();
            if(stack.getCount() == clicked.getCount()) {
                return ItemStack.EMPTY;
            }
            
            slot.onTake(player, stack);
            if(slotIndex == RESULT_SLOT) {
                player.drop(stack, false);
            }
            
            this.broadcastChanges();
        }
        
        return clicked;
    }
    
    @Override
    public void removed(final Player player) {
        
        super.removed(player);
        this.resultContainer.removeItemNoUpdate(RESULT_SLOT);
        this.access.execute((_, _) -> this.clearContainer(player, this.container));
    }
    
    
    private SelectableRecipe.SingleInputSet<FossilPrepRecipe> cachedRecipes() {
        
        return this.cachedRecipes.apply(Services.PLATFORM.getFossilPrepRecipes(level));
    }
    
}
