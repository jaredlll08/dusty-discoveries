package com.blamejared.dustydiscoveries.neoforge.data.loot;

import com.blamejared.dustydiscoveries.platform.RegistryObject;
import com.blamejared.dustydiscoveries.world.item.DDItems;
import com.blamejared.dustydiscoveries.world.level.storage.loot.DDLoot;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.function.BiConsumer;

public record DDFossilLoot(HolderLookup.Provider registries) implements LootTableSubProvider {
    
    @Override
    public void generate(final BiConsumer<ResourceKey<LootTable>, LootTable.Builder> output) {
        
        output.accept(
                DDLoot.FLOW_FOSSIL,
                fossilLoot(DDItems.ENCASED_FLOW_FOSSIL)
        );
        output.accept(
                DDLoot.SHELL_FOSSIL,
                fossilLoot(DDItems.ENCASED_SHELL_FOSSIL)
        );
        output.accept(
                DDLoot.SILENCE_FOSSIL,
                fossilLoot(DDItems.ENCASED_SILENCE_FOSSIL)
        );
        output.accept(
                DDLoot.SKULL_FOSSIL,
                fossilLoot(DDItems.ENCASED_SKULL_FOSSIL)
        );
        output.accept(
                DDLoot.SNOUT_FOSSIL,
                fossilLoot(DDItems.ENCASED_SNOUT_FOSSIL)
        );
        output.accept(
                DDLoot.TOOTH_FOSSIL,
                fossilLoot(DDItems.ENCASED_TOOTH_FOSSIL)
        );
        
    }
    
    private LootTable.Builder fossilLoot(final RegistryObject<Item> encasedItem) {
        
        return LootTable.lootTable()
                .withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(encasedItem.get()).setWeight(3))
                                .add(LootItem.lootTableItem(Items.BONE))
                                .add(LootItem.lootTableItem(Items.BONE_MEAL))
                                .add(LootItem.lootTableItem(Items.COAL))
                                .add(LootItem.lootTableItem(Items.DIAMOND))
                );
    }
    
}
