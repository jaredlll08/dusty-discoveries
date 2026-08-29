package com.blamejared.dustydiscoveries.neoforge.data.tags;

import com.blamejared.dustydiscoveries.DDConstants;
import com.blamejared.dustydiscoveries.platform.RegistryObject;
import com.blamejared.dustydiscoveries.tags.DDTags;
import com.blamejared.dustydiscoveries.world.item.DDItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.ColorCollection;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class DDItemTagsProvider extends ItemTagsProvider {
    
    public DDItemTagsProvider(final PackOutput output, final CompletableFuture<HolderLookup.Provider> lookup) {
        
        super(output, lookup, DDConstants.MODID);
    }
    
    @Override
    protected void addTags(final HolderLookup.Provider provider) {
        
        tag(DDTags.Items.DISPLAY_CASES).addAll(DDItems.DISPLAY_CASES.asList()
                .stream()
                .map(RegistryObject::getResourceKey));
        tag(Tags.Items.DYED).addAll(DDItems.DISPLAY_CASES.asList().stream().map(RegistryObject::getResourceKey))
                .addAll(DDItems.PALEONTOLOGIST_HATS.asList().stream().map(RegistryObject::getResourceKey));
        
        ColorCollection<TagKey<Item>> dyedTags = new ColorCollection<>(Tags.Items.DYED_WHITE, Tags.Items.DYED_ORANGE, Tags.Items.DYED_MAGENTA, Tags.Items.DYED_LIGHT_BLUE, Tags.Items.DYED_YELLOW, Tags.Items.DYED_LIME, Tags.Items.DYED_PINK, Tags.Items.DYED_GRAY, Tags.Items.DYED_LIGHT_GRAY, Tags.Items.DYED_CYAN, Tags.Items.DYED_PURPLE, Tags.Items.DYED_BLUE, Tags.Items.DYED_BROWN, Tags.Items.DYED_GREEN, Tags.Items.DYED_RED, Tags.Items.DYED_BLACK);
        ColorCollection.zipApply(dyedTags, DDItems.PALEONTOLOGIST_HATS, (tag, item) -> tag(tag).add(item.getResourceKey()));
        ColorCollection.zipApply(dyedTags, DDItems.DISPLAY_CASES, (tag, item) -> tag(tag).add(item.getResourceKey()));
        
    }
    
}
