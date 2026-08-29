package com.blamejared.dustydiscoveries.tags;

import com.blamejared.dustydiscoveries.DDConstants;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.trading.VillagerTrade;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.structure.Structure;

public class DDTags {
    
    public static class Items {
        
        public static final TagKey<Item> PALEONTOLOGIST_HATS = TagKey.create(Registries.ITEM, DDConstants.id("paleontologist_hats"));
        public static final TagKey<Item> DISPLAY_CASES = TagKey.create(Registries.ITEM, DDConstants.id("display_cases"));
        
    }
    
    public static class Blocks {
        
        public static final TagKey<Block> DISPLAY_CASES = TagKey.create(Registries.BLOCK, DDConstants.id("display_cases"));
        
    }
    
    public static class Structures {
        
        public static final TagKey<Structure> FOSSILS = TagKey.create(Registries.STRUCTURE, DDConstants.id("fossils"));
        public static final TagKey<Structure> FLOW_FOSSILS = TagKey.create(Registries.STRUCTURE, DDConstants.id("fossils/flow"));
        public static final TagKey<Structure> SHELL_FOSSILS = TagKey.create(Registries.STRUCTURE, DDConstants.id("fossils/shell"));
        public static final TagKey<Structure> SILENCE_FOSSILS = TagKey.create(Registries.STRUCTURE, DDConstants.id("fossils/silence"));
        public static final TagKey<Structure> SKULL_FOSSILS = TagKey.create(Registries.STRUCTURE, DDConstants.id("fossils/skull"));
        public static final TagKey<Structure> SNOUT_FOSSILS = TagKey.create(Registries.STRUCTURE, DDConstants.id("fossils/snout"));
        public static final TagKey<Structure> TOOTH_FOSSILS = TagKey.create(Registries.STRUCTURE, DDConstants.id("fossils/tooth"));
        
    }
    
    public static class VillagerTrades {
        
        public static final TagKey<VillagerTrade> PALEONTOLOGIST_LEVEL_1 = TagKey.create(Registries.VILLAGER_TRADE, DDConstants.id("paleontologist/level_1"));
        public static final TagKey<VillagerTrade> PALEONTOLOGIST_LEVEL_2 = TagKey.create(Registries.VILLAGER_TRADE, DDConstants.id("paleontologist/level_2"));
        public static final TagKey<VillagerTrade> PALEONTOLOGIST_LEVEL_3 = TagKey.create(Registries.VILLAGER_TRADE, DDConstants.id("paleontologist/level_3"));
        public static final TagKey<VillagerTrade> PALEONTOLOGIST_LEVEL_4 = TagKey.create(Registries.VILLAGER_TRADE, DDConstants.id("paleontologist/level_4"));
        public static final TagKey<VillagerTrade> PALEONTOLOGIST_LEVEL_5 = TagKey.create(Registries.VILLAGER_TRADE, DDConstants.id("paleontologist/level_5"));
        
    }
    
}
