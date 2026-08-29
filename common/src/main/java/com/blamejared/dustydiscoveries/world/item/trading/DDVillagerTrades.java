package com.blamejared.dustydiscoveries.world.item.trading;

import com.blamejared.dustydiscoveries.DDConstants;
import com.blamejared.dustydiscoveries.tags.DDTags;
import com.blamejared.dustydiscoveries.world.item.DDItems;
import com.blamejared.dustydiscoveries.world.item.FieldNotesItem;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.item.trading.TradeCost;
import net.minecraft.world.item.trading.VillagerTrade;
import net.minecraft.world.level.block.ColorCollection;

import java.util.List;
import java.util.Optional;

public class DDVillagerTrades {
    
    public static final ResourceKey<VillagerTrade> PALEONTOLOGIST_1_EMERALD_BRUSH = DDConstants.rc(Registries.VILLAGER_TRADE, "paleontologist/1/emerald_brush");
    public static final ResourceKey<VillagerTrade> PALEONTOLOGIST_1_EMERALD_AND_COMPASS_FLOW_FOSSIL_FIELD_NOTES = DDConstants.rc(Registries.VILLAGER_TRADE, "paleontologist/1/emerald_and_compass_flow_fossil_field_notes");
    public static final ResourceKey<VillagerTrade> PALEONTOLOGIST_1_EMERALD_AND_COMPASS_SHELL_FOSSIL_FIELD_NOTES = DDConstants.rc(Registries.VILLAGER_TRADE, "paleontologist/1/emerald_and_compass_shell_fossil_field_notes");
    public static final ResourceKey<VillagerTrade> PALEONTOLOGIST_1_EMERALD_AND_COMPASS_SILENCE_FOSSIL_FIELD_NOTES = DDConstants.rc(Registries.VILLAGER_TRADE, "paleontologist/1/emerald_and_compass_silence_fossil_field_notes");
    public static final ResourceKey<VillagerTrade> PALEONTOLOGIST_1_EMERALD_AND_COMPASS_SKULL_FOSSIL_FIELD_NOTES = DDConstants.rc(Registries.VILLAGER_TRADE, "paleontologist/1/emerald_and_compass_skull_fossil_field_notes");
    public static final ResourceKey<VillagerTrade> PALEONTOLOGIST_1_EMERALD_AND_COMPASS_SNOUT_FOSSIL_FIELD_NOTES = DDConstants.rc(Registries.VILLAGER_TRADE, "paleontologist/1/emerald_and_compass_snout_fossil_field_notes");
    public static final ResourceKey<VillagerTrade> PALEONTOLOGIST_1_EMERALD_AND_COMPASS_TOOTH_FOSSIL_FIELD_NOTES = DDConstants.rc(Registries.VILLAGER_TRADE, "paleontologist/1/emerald_and_compass_tooth_fossil_field_notes");
    
    public static final ResourceKey<VillagerTrade> PALEONTOLOGIST_2_EMERALD_UNBREAKING_BRUSH = DDConstants.rc(Registries.VILLAGER_TRADE, "paleontologist/2/emerald_unbreaking_brush");
    public static final ResourceKey<VillagerTrade> PALEONTOLOGIST_2_EMERALD_AND_COMPASS_FLOW_FOSSIL_FIELD_NOTES = DDConstants.rc(Registries.VILLAGER_TRADE, "paleontologist/2/emerald_and_compass_flow_fossil_field_notes");
    public static final ResourceKey<VillagerTrade> PALEONTOLOGIST_2_EMERALD_AND_COMPASS_SHELL_FOSSIL_FIELD_NOTES = DDConstants.rc(Registries.VILLAGER_TRADE, "paleontologist/2/emerald_and_compass_shell_fossil_field_notes");
    public static final ResourceKey<VillagerTrade> PALEONTOLOGIST_2_EMERALD_AND_COMPASS_SILENCE_FOSSIL_FIELD_NOTES = DDConstants.rc(Registries.VILLAGER_TRADE, "paleontologist/2/emerald_and_compass_silence_fossil_field_notes");
    public static final ResourceKey<VillagerTrade> PALEONTOLOGIST_2_EMERALD_AND_COMPASS_SKULL_FOSSIL_FIELD_NOTES = DDConstants.rc(Registries.VILLAGER_TRADE, "paleontologist/2/emerald_and_compass_skull_fossil_field_notes");
    public static final ResourceKey<VillagerTrade> PALEONTOLOGIST_2_EMERALD_AND_COMPASS_SNOUT_FOSSIL_FIELD_NOTES = DDConstants.rc(Registries.VILLAGER_TRADE, "paleontologist/2/emerald_and_compass_snout_fossil_field_notes");
    public static final ResourceKey<VillagerTrade> PALEONTOLOGIST_2_EMERALD_AND_COMPASS_TOOTH_FOSSIL_FIELD_NOTES = DDConstants.rc(Registries.VILLAGER_TRADE, "paleontologist/2/emerald_and_compass_tooth_fossil_field_notes");
    
    public static final ColorCollection<ResourceKey<VillagerTrade>> PALEONTOLOGIST_3_DISPLAY_CASES = ColorCollection.NAMES.map(color -> DDConstants.rc(Registries.VILLAGER_TRADE, "paleontologist/3/emerald_" + color + "_display_case"));
    
    public static final ResourceKey<VillagerTrade> PALEONTOLOGIST_4_EMERALD_FIELD_NOTES = DDConstants.rc(Registries.VILLAGER_TRADE, "paleontologist/4/emerald_field_notes");
    public static final ResourceKey<VillagerTrade> PALEONTOLOGIST_4_EMERALD_UNBREAKING_BRUSH = DDConstants.rc(Registries.VILLAGER_TRADE, "paleontologist/4/emerald_unbreaking_brush");
    
    public static final ColorCollection<ResourceKey<VillagerTrade>> PALEONTOLOGIST_5_EMERALD_PALEONTOLOGIST_HATS = ColorCollection.NAMES.map(color -> DDConstants.rc(Registries.VILLAGER_TRADE, "paleontologist/5/emerald_" + color + "_paleontologist_hat"));
    public static final ResourceKey<VillagerTrade> PALEONTOLOGIST_5_EMERALD_UNBREAKING_BRUSH = DDConstants.rc(Registries.VILLAGER_TRADE, "paleontologist/5/emerald_unbreaking_brush");
    
    public static void bootstrap(final BootstrapContext<VillagerTrade> context) {
        
        HolderGetter<Enchantment> enchantments = context.lookup(Registries.ENCHANTMENT);
        
        context.register(PALEONTOLOGIST_1_EMERALD_BRUSH, new VillagerTrade(new TradeCost(Items.EMERALD, 1), new ItemStackTemplate(Items.BRUSH), 8, 10, 0.02f, Optional.empty(), List.of()));
        context.register(PALEONTOLOGIST_1_EMERALD_AND_COMPASS_FLOW_FOSSIL_FIELD_NOTES, new VillagerTrade(new TradeCost(Items.EMERALD, 2), Optional.of(new TradeCost(Items.COMPASS, 1)), FieldNotesItem.templateWithFossilComponents(DDTags.Structures.FLOW_FOSSILS), 12, 10, 0.02f, Optional.empty(), List.of()));
        context.register(PALEONTOLOGIST_1_EMERALD_AND_COMPASS_SHELL_FOSSIL_FIELD_NOTES, new VillagerTrade(new TradeCost(Items.EMERALD, 2), Optional.of(new TradeCost(Items.COMPASS, 1)), FieldNotesItem.templateWithFossilComponents(DDTags.Structures.SHELL_FOSSILS), 12, 10, 0.02f, Optional.empty(), List.of()));
        context.register(PALEONTOLOGIST_1_EMERALD_AND_COMPASS_SILENCE_FOSSIL_FIELD_NOTES, new VillagerTrade(new TradeCost(Items.EMERALD, 2), Optional.of(new TradeCost(Items.COMPASS, 1)), FieldNotesItem.templateWithFossilComponents(DDTags.Structures.SILENCE_FOSSILS), 12, 10, 0.02f, Optional.empty(), List.of()));
        context.register(PALEONTOLOGIST_1_EMERALD_AND_COMPASS_SKULL_FOSSIL_FIELD_NOTES, new VillagerTrade(new TradeCost(Items.EMERALD, 2), Optional.of(new TradeCost(Items.COMPASS, 1)), FieldNotesItem.templateWithFossilComponents(DDTags.Structures.SKULL_FOSSILS), 12, 10, 0.02f, Optional.empty(), List.of()));
        context.register(PALEONTOLOGIST_1_EMERALD_AND_COMPASS_SNOUT_FOSSIL_FIELD_NOTES, new VillagerTrade(new TradeCost(Items.EMERALD, 2), Optional.of(new TradeCost(Items.COMPASS, 1)), FieldNotesItem.templateWithFossilComponents(DDTags.Structures.SNOUT_FOSSILS), 12, 10, 0.02f, Optional.empty(), List.of()));
        context.register(PALEONTOLOGIST_1_EMERALD_AND_COMPASS_TOOTH_FOSSIL_FIELD_NOTES, new VillagerTrade(new TradeCost(Items.EMERALD, 2), Optional.of(new TradeCost(Items.COMPASS, 1)), FieldNotesItem.templateWithFossilComponents(DDTags.Structures.TOOTH_FOSSILS), 12, 10, 0.02f, Optional.empty(), List.of()));
        
        {
            ItemEnchantments.Mutable brushEnchantments = new ItemEnchantments.Mutable(ItemEnchantments.EMPTY);
            brushEnchantments.set(enchantments.getOrThrow(Enchantments.UNBREAKING), 1);
            context.register(PALEONTOLOGIST_2_EMERALD_UNBREAKING_BRUSH, new VillagerTrade(new TradeCost(Items.EMERALD, 1), Optional.of(new TradeCost(Items.BRUSH, 1)), new ItemStackTemplate(Items.BRUSH, DataComponentPatch.builder()
                    .set(DataComponents.ENCHANTMENTS, brushEnchantments.toImmutable())
                    .build()), 4, 10, 0.02f, Optional.empty(), List.of()));
        }
        
        context.register(PALEONTOLOGIST_2_EMERALD_AND_COMPASS_FLOW_FOSSIL_FIELD_NOTES, new VillagerTrade(new TradeCost(Items.EMERALD, 1), Optional.of(new TradeCost(Items.COMPASS, 1)), FieldNotesItem.templateWithFossilComponents(DDTags.Structures.FLOW_FOSSILS), 8, 8, 0.02f, Optional.empty(), List.of()));
        context.register(PALEONTOLOGIST_2_EMERALD_AND_COMPASS_SHELL_FOSSIL_FIELD_NOTES, new VillagerTrade(new TradeCost(Items.EMERALD, 1), Optional.of(new TradeCost(Items.COMPASS, 1)), FieldNotesItem.templateWithFossilComponents(DDTags.Structures.SHELL_FOSSILS), 8, 8, 0.02f, Optional.empty(), List.of()));
        context.register(PALEONTOLOGIST_2_EMERALD_AND_COMPASS_SILENCE_FOSSIL_FIELD_NOTES, new VillagerTrade(new TradeCost(Items.EMERALD, 1), Optional.of(new TradeCost(Items.COMPASS, 1)), FieldNotesItem.templateWithFossilComponents(DDTags.Structures.SILENCE_FOSSILS), 8, 8, 0.02f, Optional.empty(), List.of()));
        context.register(PALEONTOLOGIST_2_EMERALD_AND_COMPASS_SKULL_FOSSIL_FIELD_NOTES, new VillagerTrade(new TradeCost(Items.EMERALD, 1), Optional.of(new TradeCost(Items.COMPASS, 1)), FieldNotesItem.templateWithFossilComponents(DDTags.Structures.SKULL_FOSSILS), 8, 8, 0.02f, Optional.empty(), List.of()));
        context.register(PALEONTOLOGIST_2_EMERALD_AND_COMPASS_SNOUT_FOSSIL_FIELD_NOTES, new VillagerTrade(new TradeCost(Items.EMERALD, 1), Optional.of(new TradeCost(Items.COMPASS, 1)), FieldNotesItem.templateWithFossilComponents(DDTags.Structures.SNOUT_FOSSILS), 8, 8, 0.02f, Optional.empty(), List.of()));
        context.register(PALEONTOLOGIST_2_EMERALD_AND_COMPASS_TOOTH_FOSSIL_FIELD_NOTES, new VillagerTrade(new TradeCost(Items.EMERALD, 1), Optional.of(new TradeCost(Items.COMPASS, 1)), FieldNotesItem.templateWithFossilComponents(DDTags.Structures.TOOTH_FOSSILS), 8, 8, 0.02f, Optional.empty(), List.of()));
        
        ColorCollection.zipApply(PALEONTOLOGIST_3_DISPLAY_CASES, DDItems.DISPLAY_CASES, (name, item) -> context.register(name, new VillagerTrade(new TradeCost(Items.EMERALD, 3), new ItemStackTemplate(item.get(), 1), 8, 8, 0.5f, Optional.empty(), List.of())));
        
        context.register(PALEONTOLOGIST_4_EMERALD_FIELD_NOTES, new VillagerTrade(new TradeCost(Items.EMERALD, 2), FieldNotesItem.templateWithFossilComponents(DDTags.Structures.FOSSILS), 16, 8, 0.02f, Optional.empty(), List.of()));
        {
            ItemEnchantments.Mutable brushEnchantments = new ItemEnchantments.Mutable(ItemEnchantments.EMPTY);
            brushEnchantments.set(enchantments.getOrThrow(Enchantments.UNBREAKING), 2);
            context.register(PALEONTOLOGIST_4_EMERALD_UNBREAKING_BRUSH, new VillagerTrade(new TradeCost(Items.EMERALD, 2), Optional.of(new TradeCost(Items.BRUSH, 1)), new ItemStackTemplate(Items.BRUSH, DataComponentPatch.builder()
                    .set(DataComponents.ENCHANTMENTS, brushEnchantments.toImmutable())
                    .build()), 4, 10, 0.02f, Optional.empty(), List.of()));
        }
        
        {
            ItemEnchantments.Mutable brushEnchantments = new ItemEnchantments.Mutable(ItemEnchantments.EMPTY);
            brushEnchantments.set(enchantments.getOrThrow(Enchantments.UNBREAKING), 3);
            context.register(PALEONTOLOGIST_5_EMERALD_UNBREAKING_BRUSH, new VillagerTrade(new TradeCost(Items.EMERALD, 3), Optional.of(new TradeCost(Items.BRUSH, 1)), new ItemStackTemplate(Items.BRUSH, DataComponentPatch.builder()
                    .set(DataComponents.ENCHANTMENTS, brushEnchantments.toImmutable())
                    .build()), 4, 10, 0.02f, Optional.empty(), List.of()));
        }
        ColorCollection.zipApply(PALEONTOLOGIST_5_EMERALD_PALEONTOLOGIST_HATS, DDItems.PALEONTOLOGIST_HATS, (name, item) -> context.register(name, new VillagerTrade(new TradeCost(Items.EMERALD, 3), new ItemStackTemplate(item.get(), 1), 4, 8, 0.5f, Optional.empty(), List.of())));
        
    }
    
}
