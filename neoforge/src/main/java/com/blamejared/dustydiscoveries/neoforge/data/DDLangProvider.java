package com.blamejared.dustydiscoveries.neoforge.data;

import com.blamejared.dustydiscoveries.DDConstants;
import com.blamejared.dustydiscoveries.tags.DDTags;
import com.blamejared.dustydiscoveries.world.item.DDItems;
import com.blamejared.dustydiscoveries.world.level.block.DDBlocks;
import com.blamejared.dustydiscoveries.world.level.storage.loot.DDLoot;
import com.google.common.collect.ImmutableMap;
import net.minecraft.data.PackOutput;
import net.minecraft.util.Util;
import net.minecraft.world.item.DyeColor;
import net.neoforged.neoforge.common.data.LanguageProvider;

import java.util.Map;

public class DDLangProvider extends LanguageProvider {
    
    private static final Map<DyeColor, String> DYE_NAMES = Util.make(() -> {
        ImmutableMap.Builder<DyeColor, String> map = ImmutableMap.builder();
        map.put(DyeColor.WHITE, "White");
        map.put(DyeColor.ORANGE, "Orange");
        map.put(DyeColor.MAGENTA, "Magenta");
        map.put(DyeColor.LIGHT_BLUE, "Light Blue");
        map.put(DyeColor.YELLOW, "Yellow");
        map.put(DyeColor.LIME, "Lime");
        map.put(DyeColor.PINK, "Pink");
        map.put(DyeColor.GRAY, "Gray");
        map.put(DyeColor.LIGHT_GRAY, "Light Gray");
        map.put(DyeColor.CYAN, "Cyan");
        map.put(DyeColor.PURPLE, "Purple");
        map.put(DyeColor.BLUE, "Blue");
        map.put(DyeColor.BROWN, "Brown");
        map.put(DyeColor.GREEN, "Green");
        map.put(DyeColor.RED, "Red");
        map.put(DyeColor.BLACK, "Black");
        return map.build();
    });
    
    public DDLangProvider(final PackOutput output) {
        
        super(output, DDConstants.MODID, "en_us");
    }
    
    @Override
    protected void addTranslations() {
        
        this.add("itemGroup.dustydiscoveries", "Dusty Discoveries");
        this.add("container.dustydiscoveries.fossil_prep_station", "Fossil Prep Station");
        this.add("filled_map." + DDConstants.sid("fossil"), "Fossil Field Notes");
        this.add("entity." + DDConstants.MODID + ".villager.paleontologist", "Paleontologist");
        this.add("gui.dustydiscoveries.jei.category.fossilprep", "Fossil Prep Station");
        
        this.add("lore.dustydiscoveries.fossilized_bone_block." + DDLoot.FLOW_FOSSIL.identifier()
                .getPath(), "Flow Fossil");
        this.add("lore.dustydiscoveries.fossilized_bone_block." + DDLoot.SHELL_FOSSIL.identifier()
                .getPath(), "Shell Fossil");
        this.add("lore.dustydiscoveries.fossilized_bone_block." + DDLoot.SILENCE_FOSSIL.identifier()
                .getPath(), "Silence Fossil");
        this.add("lore.dustydiscoveries.fossilized_bone_block." + DDLoot.SKULL_FOSSIL.identifier()
                .getPath(), "Skull Fossil");
        this.add("lore.dustydiscoveries.fossilized_bone_block." + DDLoot.SNOUT_FOSSIL.identifier()
                .getPath(), "Snout Fossil");
        this.add("lore.dustydiscoveries.fossilized_bone_block." + DDLoot.TOOTH_FOSSIL.identifier()
                .getPath(), "Tooth Fossil");
        
        this.add("lore.dustydiscoveries.field_note." + DDTags.Structures.FOSSILS.location().getPath(), "Fossils");
        this.add("lore.dustydiscoveries.field_note." + DDTags.Structures.FLOW_FOSSILS.location()
                .getPath(), "Flow Fossil");
        this.add("lore.dustydiscoveries.field_note." + DDTags.Structures.SHELL_FOSSILS.location()
                .getPath(), "Shell Fossil");
        this.add("lore.dustydiscoveries.field_note." + DDTags.Structures.SILENCE_FOSSILS.location()
                .getPath(), "Silence Fossil");
        this.add("lore.dustydiscoveries.field_note." + DDTags.Structures.SKULL_FOSSILS.location()
                .getPath(), "Skull Fossil");
        this.add("lore.dustydiscoveries.field_note." + DDTags.Structures.SNOUT_FOSSILS.location()
                .getPath(), "Snout Fossil");
        this.add("lore.dustydiscoveries.field_note." + DDTags.Structures.TOOTH_FOSSILS.location()
                .getPath(), "Tooth Fossil");
        
        DYE_NAMES.forEach((dyeColor, s) -> {
            this.addBlock(DDBlocks.DISPLAY_CASES.pick(dyeColor), s + " Display Case");
            this.addItem(DDItems.DISPLAY_CASES.pick(dyeColor), s + " Display Case");
            this.addItem(DDItems.PALEONTOLOGIST_HATS.pick(dyeColor), s + " Paleontologist Hat");
        });
        
        this.addBlock(DDBlocks.FOSSIL_PREP_STATION, "Fossil Prep Station");
        this.addItem(DDItems.FOSSIL_PREP_STATION, "Fossil Prep Station");
        
        this.addBlock(DDBlocks.FOSSILIZED_BONE_BLOCK, "Fossilized Bone Block");
        this.addItem(DDItems.FOSSILIZED_BONE_BLOCK, "Fossilized Bone Block");
        
        this.addItem(DDItems.FLOW_FOSSIL_0, "Flow Fossil");
        this.addItem(DDItems.FLOW_FOSSIL_1, "Flow Fossil");
        this.addItem(DDItems.FLOW_FOSSIL_2, "Flow Fossil");
        this.addItem(DDItems.SHELL_FOSSIL_0, "Shell Fossil");
        this.addItem(DDItems.SHELL_FOSSIL_1, "Shell Fossil");
        this.addItem(DDItems.SHELL_FOSSIL_2, "Shell Fossil");
        this.addItem(DDItems.SILENCE_FOSSIL_0, "Silence Fossil");
        this.addItem(DDItems.SILENCE_FOSSIL_1, "Silence Fossil");
        this.addItem(DDItems.SILENCE_FOSSIL_2, "Silence Fossil");
        this.addItem(DDItems.SILENCE_FOSSIL_3, "Silence Fossil");
        this.addItem(DDItems.SKULL_FOSSIL_0, "Skull Fossil");
        this.addItem(DDItems.SKULL_FOSSIL_1, "Skull Fossil");
        this.addItem(DDItems.SKULL_FOSSIL_2, "Skull Fossil");
        this.addItem(DDItems.SNOUT_FOSSIL_0, "Snout Fossil");
        this.addItem(DDItems.SNOUT_FOSSIL_1, "Snout Fossil");
        this.addItem(DDItems.SNOUT_FOSSIL_2, "Snout Fossil");
        this.addItem(DDItems.TOOTH_FOSSIL_0, "Tooth Fossil");
        this.addItem(DDItems.TOOTH_FOSSIL_1, "Tooth Fossil");
        this.addItem(DDItems.TOOTH_FOSSIL_2, "Tooth Fossil");
        this.addItem(DDItems.TOOTH_FOSSIL_3, "Tooth Fossil");
        
        this.addItem(DDItems.ENCASED_FLOW_FOSSIL, "Encased Flow Fossil");
        this.addItem(DDItems.ENCASED_SHELL_FOSSIL, "Encased Shell Fossil");
        this.addItem(DDItems.ENCASED_SILENCE_FOSSIL, "Encased Silence Fossil");
        this.addItem(DDItems.ENCASED_SKULL_FOSSIL, "Encased Skull Fossil");
        this.addItem(DDItems.ENCASED_SNOUT_FOSSIL, "Encased Snout Fossil");
        this.addItem(DDItems.ENCASED_TOOTH_FOSSIL, "Encased Tooth Fossil");
        
        this.addItem(DDItems.FOSSIL_FIELD_NOTES, "Fossil Field Notes");
        
        this.add(DDTags.Items.PALEONTOLOGIST_HATS, "Paleontologist Hats");
        this.add(DDTags.Items.DISPLAY_CASES, "Display Cases");
        this.add(DDTags.Blocks.DISPLAY_CASES, "Display Cases");
        this.add(DDTags.Structures.FOSSILS, "Fossils");
        this.add(DDTags.Structures.FLOW_FOSSILS, "Flow Fossils");
        this.add(DDTags.Structures.SHELL_FOSSILS, "Shell Fossils");
        this.add(DDTags.Structures.SILENCE_FOSSILS, "Silence Fossils");
        this.add(DDTags.Structures.SKULL_FOSSILS, "Skull Fossils");
        this.add(DDTags.Structures.SNOUT_FOSSILS, "Snout Fossils");
        this.add(DDTags.Structures.TOOTH_FOSSILS, "Tooth Fossils");
        
        this.add(DDTags.VillagerTrades.PALEONTOLOGIST_LEVEL_1, "Paleontologist Level 1 Trades");
        this.add(DDTags.VillagerTrades.PALEONTOLOGIST_LEVEL_2, "Paleontologist Level 2 Trades");
        this.add(DDTags.VillagerTrades.PALEONTOLOGIST_LEVEL_3, "Paleontologist Level 3 Trades");
        this.add(DDTags.VillagerTrades.PALEONTOLOGIST_LEVEL_4, "Paleontologist Level 4 Trades");
        this.add(DDTags.VillagerTrades.PALEONTOLOGIST_LEVEL_5, "Paleontologist Level 5 Trades");
        
    }
    
    
}
