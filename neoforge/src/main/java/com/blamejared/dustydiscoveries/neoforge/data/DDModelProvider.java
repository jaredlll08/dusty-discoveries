package com.blamejared.dustydiscoveries.neoforge.data;

import com.blamejared.dustydiscoveries.DDConstants;
import com.blamejared.dustydiscoveries.world.item.DDItems;
import com.blamejared.dustydiscoveries.world.level.block.DDBlocks;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.data.PackOutput;

public class DDModelProvider extends ModelProvider {
    
    public DDModelProvider(final PackOutput output) {
        
        super(output, DDConstants.MODID);
    }
    
    @Override
    protected void registerModels(final BlockModelGenerators blockModels, final ItemModelGenerators itemModels) {
        
        TexturedModel.Provider displayCase = block -> new TexturedModel(TextureMapping.defaultTexture(block), ModelTemplates.create(DDConstants.sid("display_case"), TextureSlot.CONTENT, TextureSlot.PARTICLE));
        DDBlocks.DISPLAY_CASES.forEach(blockRegistryObject -> {
            Material blockTexture = TextureMapping.getBlockTexture(blockRegistryObject.get());
            blockModels.createTrivialBlock(blockRegistryObject.get(), displayCase.updateTexture(textureMapping -> textureMapping.put(TextureSlot.CONTENT, blockTexture).put(TextureSlot.PARTICLE, blockTexture)));
        });
        blockModels.createBrushableBlock(DDBlocks.FOSSILIZED_BONE_BLOCK.get());
        blockModels.createTrivialBlock(DDBlocks.FOSSIL_PREP_STATION.get(), TexturedModel.CUBE_TOP_BOTTOM);
        itemModels.generateFlatItem(DDItems.FLOW_FOSSIL_0.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(DDItems.FLOW_FOSSIL_1.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(DDItems.FLOW_FOSSIL_2.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(DDItems.SHELL_FOSSIL_0.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(DDItems.SHELL_FOSSIL_1.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(DDItems.SHELL_FOSSIL_2.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(DDItems.SILENCE_FOSSIL_0.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(DDItems.SILENCE_FOSSIL_1.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(DDItems.SILENCE_FOSSIL_2.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(DDItems.SILENCE_FOSSIL_3.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(DDItems.SKULL_FOSSIL_0.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(DDItems.SKULL_FOSSIL_1.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(DDItems.SKULL_FOSSIL_2.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(DDItems.SNOUT_FOSSIL_0.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(DDItems.SNOUT_FOSSIL_1.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(DDItems.SNOUT_FOSSIL_2.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(DDItems.TOOTH_FOSSIL_0.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(DDItems.TOOTH_FOSSIL_1.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(DDItems.TOOTH_FOSSIL_2.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(DDItems.TOOTH_FOSSIL_3.get(), ModelTemplates.FLAT_ITEM);
        
        itemModels.generateFlatItem(DDItems.ENCASED_FLOW_FOSSIL.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(DDItems.ENCASED_SHELL_FOSSIL.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(DDItems.ENCASED_SILENCE_FOSSIL.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(DDItems.ENCASED_SKULL_FOSSIL.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(DDItems.ENCASED_SNOUT_FOSSIL.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(DDItems.ENCASED_TOOTH_FOSSIL.get(), ModelTemplates.FLAT_ITEM);
        
        itemModels.generateFlatItem(DDItems.FOSSIL_FIELD_NOTES.get(), ModelTemplates.FLAT_ITEM);
        
        ModelTemplate paleontologistHat = ModelTemplates.createItem(DDConstants.sid("paleontologist_hat"), TextureSlot.LAYER0);
        DDItems.PALEONTOLOGIST_HATS.forEach(hat -> itemModels.generateFlatItem(hat.get(), paleontologistHat));
        
    }
    
}
