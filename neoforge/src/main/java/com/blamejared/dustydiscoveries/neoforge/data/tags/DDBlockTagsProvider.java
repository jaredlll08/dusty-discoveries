package com.blamejared.dustydiscoveries.neoforge.data.tags;

import com.blamejared.dustydiscoveries.DDConstants;
import com.blamejared.dustydiscoveries.platform.RegistryObject;
import com.blamejared.dustydiscoveries.tags.DDTags;
import com.blamejared.dustydiscoveries.world.level.block.DDBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ColorCollection;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unchecked")
public class DDBlockTagsProvider extends BlockTagsProvider {
    
    public DDBlockTagsProvider(final PackOutput output, final CompletableFuture<HolderLookup.Provider> lookup) {
        
        super(output, lookup, DDConstants.MODID);
    }
    
    @Override
    protected void addTags(final HolderLookup.Provider provider) {
        
        tag(DDTags.Blocks.DISPLAY_CASES).addAll(DDBlocks.DISPLAY_CASES.asList()
                .stream()
                .map(RegistryObject::getResourceKey));
        tag(Tags.Blocks.VILLAGER_JOB_SITES)
                .add(DDBlocks.FOSSIL_PREP_STATION.getResourceKey());
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .addAll(DDBlocks.DISPLAY_CASES.asList().stream().map(RegistryObject::getResourceKey))
                .add(
                        DDBlocks.FOSSILIZED_BONE_BLOCK.getResourceKey(),
                        DDBlocks.FOSSIL_PREP_STATION.getResourceKey());
        
        tag(Tags.Blocks.DYED).addAll(DDBlocks.DISPLAY_CASES.asList()
                .stream()
                .map(RegistryObject::getResourceKey));
        
        ColorCollection<TagKey<Block>> dyedTags = new ColorCollection<>(Tags.Blocks.DYED_WHITE,
                Tags.Blocks.DYED_ORANGE,
                Tags.Blocks.DYED_MAGENTA,
                Tags.Blocks.DYED_LIGHT_BLUE,
                Tags.Blocks.DYED_YELLOW,
                Tags.Blocks.DYED_LIME,
                Tags.Blocks.DYED_PINK,
                Tags.Blocks.DYED_GRAY,
                Tags.Blocks.DYED_LIGHT_GRAY,
                Tags.Blocks.DYED_CYAN,
                Tags.Blocks.DYED_PURPLE,
                Tags.Blocks.DYED_BLUE,
                Tags.Blocks.DYED_BROWN,
                Tags.Blocks.DYED_GREEN,
                Tags.Blocks.DYED_RED,
                Tags.Blocks.DYED_BLACK);
        ColorCollection.zipApply(dyedTags, DDBlocks.DISPLAY_CASES, (tag, block) -> tag(tag).add(block.getResourceKey()));
    }
    
}
