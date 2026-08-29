package com.blamejared.dustydiscoveries.world.item;

import com.blamejared.dustydiscoveries.DDConstants;
import com.blamejared.dustydiscoveries.platform.IRegister;
import com.blamejared.dustydiscoveries.platform.RegistrationProvider;
import com.blamejared.dustydiscoveries.platform.RegistryObject;
import com.blamejared.dustydiscoveries.platform.Services;
import com.blamejared.dustydiscoveries.tags.DDTags;
import com.blamejared.dustydiscoveries.world.level.block.DDBlocks;
import com.blamejared.dustydiscoveries.world.level.storage.loot.DDLoot;
import com.google.auto.service.AutoService;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemLore;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.Equippable;
import net.minecraft.world.level.block.ColorCollection;
import net.minecraft.world.level.block.entity.BlockEntityTypes;
import net.minecraft.world.level.storage.TagValueOutput;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.Collection;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

@AutoService(IRegister.class)
public class DDItems implements IRegister {
    
    private static final RegistrationProvider<Item> ITEMS = RegistrationProvider.get(Registries.ITEM, DDConstants.MODID);
    private static final RegistrationProvider<CreativeModeTab> TABS = RegistrationProvider.get(Registries.CREATIVE_MODE_TAB, DDConstants.MODID);
    
    public static final RegistryObject<CreativeModeTab> TAB = TABS.register(DDConstants.MODID, () -> Services.PLATFORM.creativeTabBuilder()
            .displayItems((_, output) -> DDItems.registerCreativeTabs(output))
            .icon(() -> DDItems.TOOTH_FOSSIL_0.get().getDefaultInstance())
            .title(Component.translatable("itemGroup." + DDConstants.MODID))
            .build());
    
    public static final ColorCollection<RegistryObject<Item>> DISPLAY_CASES = ColorCollection.zipMap(
            ColorCollection.VALUES,
            ColorCollection.prefixWithColor(ColorCollection.create("display_case")),
            (dyeColor, s) -> ITEMS.blockItem(s, DDBlocks.DISPLAY_CASES.pick(dyeColor), UnaryOperator.identity()));
    
    public static final RegistryObject<BlockItem> FOSSILIZED_BONE_BLOCK = ITEMS.blockItem("fossilized_bone_block", DDBlocks.FOSSILIZED_BONE_BLOCK, UnaryOperator.identity());
    public static final RegistryObject<BlockItem> FOSSIL_PREP_STATION = ITEMS.blockItem("fossil_prep_station", DDBlocks.FOSSIL_PREP_STATION, UnaryOperator.identity());
    public static final RegistryObject<Item> FLOW_FOSSIL_0 = ITEMS.item("flow_fossil_0", Item::new);
    public static final RegistryObject<Item> FLOW_FOSSIL_1 = ITEMS.item("flow_fossil_1", Item::new);
    public static final RegistryObject<Item> FLOW_FOSSIL_2 = ITEMS.item("flow_fossil_2", Item::new);
    public static final RegistryObject<Item> SHELL_FOSSIL_0 = ITEMS.item("shell_fossil_0", Item::new);
    public static final RegistryObject<Item> SHELL_FOSSIL_1 = ITEMS.item("shell_fossil_1", Item::new);
    public static final RegistryObject<Item> SHELL_FOSSIL_2 = ITEMS.item("shell_fossil_2", Item::new);
    public static final RegistryObject<Item> SILENCE_FOSSIL_0 = ITEMS.item("silence_fossil_0", Item::new);
    public static final RegistryObject<Item> SILENCE_FOSSIL_1 = ITEMS.item("silence_fossil_1", Item::new);
    public static final RegistryObject<Item> SILENCE_FOSSIL_2 = ITEMS.item("silence_fossil_2", Item::new);
    public static final RegistryObject<Item> SILENCE_FOSSIL_3 = ITEMS.item("silence_fossil_3", Item::new);
    public static final RegistryObject<Item> SKULL_FOSSIL_0 = ITEMS.item("skull_fossil_0", Item::new);
    public static final RegistryObject<Item> SKULL_FOSSIL_1 = ITEMS.item("skull_fossil_1", Item::new);
    public static final RegistryObject<Item> SKULL_FOSSIL_2 = ITEMS.item("skull_fossil_2", Item::new);
    public static final RegistryObject<Item> SNOUT_FOSSIL_0 = ITEMS.item("snout_fossil_0", Item::new);
    public static final RegistryObject<Item> SNOUT_FOSSIL_1 = ITEMS.item("snout_fossil_1", Item::new);
    public static final RegistryObject<Item> SNOUT_FOSSIL_2 = ITEMS.item("snout_fossil_2", Item::new);
    public static final RegistryObject<Item> TOOTH_FOSSIL_0 = ITEMS.item("tooth_fossil_0", Item::new);
    public static final RegistryObject<Item> TOOTH_FOSSIL_1 = ITEMS.item("tooth_fossil_1", Item::new);
    public static final RegistryObject<Item> TOOTH_FOSSIL_2 = ITEMS.item("tooth_fossil_2", Item::new);
    public static final RegistryObject<Item> TOOTH_FOSSIL_3 = ITEMS.item("tooth_fossil_3", Item::new);
    
    public static final RegistryObject<Item> ENCASED_FLOW_FOSSIL = ITEMS.item("encased_flow_fossil", Item::new);
    public static final RegistryObject<Item> ENCASED_SHELL_FOSSIL = ITEMS.item("encased_shell_fossil", Item::new);
    public static final RegistryObject<Item> ENCASED_SILENCE_FOSSIL = ITEMS.item("encased_silence_fossil", Item::new);
    public static final RegistryObject<Item> ENCASED_SKULL_FOSSIL = ITEMS.item("encased_skull_fossil", Item::new);
    public static final RegistryObject<Item> ENCASED_SNOUT_FOSSIL = ITEMS.item("encased_snout_fossil", Item::new);
    public static final RegistryObject<Item> ENCASED_TOOTH_FOSSIL = ITEMS.item("encased_tooth_fossil", Item::new);
    
    public static final RegistryObject<Item> FOSSIL_FIELD_NOTES = ITEMS.item("fossil_field_notes", FieldNotesItem::new, new Item.Properties().stacksTo(16));
    
    public static final ColorCollection<RegistryObject<Item>> PALEONTOLOGIST_HATS = ColorCollection.zipMap(
            ColorCollection.VALUES,
            ColorCollection.prefixWithColor(ColorCollection.create("paleontologist_hat")),
            (_, s) -> ITEMS.item(s, Item::new, new Item.Properties().stacksTo(1)
                    .component(DataComponents.EQUIPPABLE, Equippable.builder(ArmorType.HELMET.getSlot()).build())));
    
    
    public static void registerCreativeTabs(final CreativeModeTab.Output registrar) {
        
        List<DyeColor> gameplayColorOrder = List.of(
                DyeColor.WHITE,
                DyeColor.LIGHT_GRAY,
                DyeColor.GRAY,
                DyeColor.BLACK,
                DyeColor.BROWN,
                DyeColor.RED,
                DyeColor.ORANGE,
                DyeColor.YELLOW,
                DyeColor.LIME,
                DyeColor.GREEN,
                DyeColor.CYAN,
                DyeColor.LIGHT_BLUE,
                DyeColor.BLUE,
                DyeColor.PURPLE,
                DyeColor.MAGENTA,
                DyeColor.PINK
        );
        
        gameplayColorOrder.forEach(dyeColor -> registrar.accept(DDItems.DISPLAY_CASES.pick(dyeColor).get()));
        registrar.accept(DDItems.FOSSILIZED_BONE_BLOCK.get());
        BiConsumer<Supplier<? extends Item>, ResourceKey<LootTable>> fossilLoot = (item, lootTable) -> {
            ItemStack stack = item.get().getDefaultInstance();
            TagValueOutput output = TagValueOutput.createWithoutContext(ProblemReporter.DISCARDING);
            output.store("LootTable", LootTable.KEY_CODEC, lootTable);
            BlockItem.setBlockEntityData(stack, BlockEntityTypes.BRUSHABLE_BLOCK, output);
            stack.set(DataComponents.LORE, new ItemLore(List.of(Component.translatable("lore.dustydiscoveries.fossilized_bone_block." + lootTable.identifier()
                    .getPath()))));
            registrar.accept(stack);
        };
        fossilLoot.accept(DDItems.FOSSILIZED_BONE_BLOCK, DDLoot.FLOW_FOSSIL);
        fossilLoot.accept(DDItems.FOSSILIZED_BONE_BLOCK, DDLoot.SHELL_FOSSIL);
        fossilLoot.accept(DDItems.FOSSILIZED_BONE_BLOCK, DDLoot.SILENCE_FOSSIL);
        fossilLoot.accept(DDItems.FOSSILIZED_BONE_BLOCK, DDLoot.SKULL_FOSSIL);
        fossilLoot.accept(DDItems.FOSSILIZED_BONE_BLOCK, DDLoot.SNOUT_FOSSIL);
        fossilLoot.accept(DDItems.FOSSILIZED_BONE_BLOCK, DDLoot.TOOTH_FOSSIL);
        
        registrar.accept(FieldNotesItem.stackWithFossilComponents(DDTags.Structures.FOSSILS));
        registrar.accept(FieldNotesItem.stackWithFossilComponents(DDTags.Structures.FLOW_FOSSILS));
        registrar.accept(FieldNotesItem.stackWithFossilComponents(DDTags.Structures.SHELL_FOSSILS));
        registrar.accept(FieldNotesItem.stackWithFossilComponents(DDTags.Structures.SILENCE_FOSSILS));
        registrar.accept(FieldNotesItem.stackWithFossilComponents(DDTags.Structures.SKULL_FOSSILS));
        registrar.accept(FieldNotesItem.stackWithFossilComponents(DDTags.Structures.SNOUT_FOSSILS));
        registrar.accept(FieldNotesItem.stackWithFossilComponents(DDTags.Structures.TOOTH_FOSSILS));
        
        registrar.accept(DDItems.FOSSIL_PREP_STATION.get());
        registrar.accept(DDItems.ENCASED_FLOW_FOSSIL.get());
        registrar.accept(DDItems.FLOW_FOSSIL_0.get());
        registrar.accept(DDItems.FLOW_FOSSIL_1.get());
        registrar.accept(DDItems.FLOW_FOSSIL_2.get());
        registrar.accept(DDItems.ENCASED_SHELL_FOSSIL.get());
        registrar.accept(DDItems.SHELL_FOSSIL_0.get());
        registrar.accept(DDItems.SHELL_FOSSIL_1.get());
        registrar.accept(DDItems.SHELL_FOSSIL_2.get());
        registrar.accept(DDItems.ENCASED_SILENCE_FOSSIL.get());
        registrar.accept(DDItems.SILENCE_FOSSIL_0.get());
        registrar.accept(DDItems.SILENCE_FOSSIL_1.get());
        registrar.accept(DDItems.SILENCE_FOSSIL_2.get());
        registrar.accept(DDItems.SILENCE_FOSSIL_3.get());
        registrar.accept(DDItems.ENCASED_SKULL_FOSSIL.get());
        registrar.accept(DDItems.SKULL_FOSSIL_0.get());
        registrar.accept(DDItems.SKULL_FOSSIL_1.get());
        registrar.accept(DDItems.SKULL_FOSSIL_2.get());
        registrar.accept(DDItems.ENCASED_SNOUT_FOSSIL.get());
        registrar.accept(DDItems.SNOUT_FOSSIL_0.get());
        registrar.accept(DDItems.SNOUT_FOSSIL_1.get());
        registrar.accept(DDItems.SNOUT_FOSSIL_2.get());
        registrar.accept(DDItems.ENCASED_TOOTH_FOSSIL.get());
        registrar.accept(DDItems.TOOTH_FOSSIL_0.get());
        registrar.accept(DDItems.TOOTH_FOSSIL_1.get());
        registrar.accept(DDItems.TOOTH_FOSSIL_2.get());
        registrar.accept(DDItems.TOOTH_FOSSIL_3.get());
        
        gameplayColorOrder.forEach(dyeColor -> registrar.accept(DDItems.PALEONTOLOGIST_HATS.pick(dyeColor).get()));
    }
    
    public static Collection<RegistryObject<Item>> getEntries() {
        
        return ITEMS.getEntries();
    }
    
}
