package com.blamejared.dustydiscoveries.world.level.block;

import com.blamejared.dustydiscoveries.DDConstants;
import com.blamejared.dustydiscoveries.mixin.AccessBlockEntityType;
import com.blamejared.dustydiscoveries.platform.IRegister;
import com.blamejared.dustydiscoveries.platform.RegistrationProvider;
import com.blamejared.dustydiscoveries.platform.RegistryObject;
import com.google.auto.service.AutoService;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BrushableBlock;
import net.minecraft.world.level.block.ColorCollection;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityTypes;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@AutoService(IRegister.class)
public class DDBlocks implements IRegister {
    
    private static final RegistrationProvider<Block> BLOCKS = RegistrationProvider.get(Registries.BLOCK, DDConstants.MODID);
    public static final ColorCollection<RegistryObject<Block>> DISPLAY_CASES = ColorCollection.zipMap(
            ColorCollection.VALUES,
            ColorCollection.prefixWithColor(ColorCollection.create("display_case")),
            (dyeColor, s) -> BLOCKS.block(s, properties -> new DisplayCaseBlock(properties, dyeColor),
                    BlockBehaviour.Properties.of()
                            .isViewBlocking((_, _, _) -> false)
                            .noOcclusion()
                            .mapColor(MapColor.DIAMOND)
                            .strength(2.0F)
                            .lightLevel(_ -> 1)
            ));
    public static final RegistryObject<Block> FOSSILIZED_BONE_BLOCK = BLOCKS.block("fossilized_bone_block", properties -> new BrushableBlock(Blocks.BONE_BLOCK, SoundEvents.ARMADILLO_BRUSH, SoundEvents.BRUSH_GRAVEL_COMPLETED, properties),
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SAND)
                    .instrument(NoteBlockInstrument.XYLOPHONE)
                    .requiresCorrectToolForDrops()
                    .strength(2.0F)
                    .sound(SoundType.BONE_BLOCK)
    );
    public static final RegistryObject<Block> FOSSIL_PREP_STATION = BLOCKS.block("fossil_prep_station", FossilPrepStationBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SAND)
                    .instrument(NoteBlockInstrument.XYLOPHONE)
                    .requiresCorrectToolForDrops()
                    .strength(2.0F)
                    .sound(SoundType.BONE_BLOCK)
    );
    
    
    public static void modifyBlockEntityTypes() {
        
        AccessBlockEntityType abet = (AccessBlockEntityType) BlockEntityTypes.BRUSHABLE_BLOCK;
        Set<Block> blocks = new HashSet<>(abet.dustydiscoveries$getValidBlocks());
        blocks.add(DDBlocks.FOSSILIZED_BONE_BLOCK.get());
        abet.dustydiscoveries$setValidBlocks(blocks);
    }
    
    public static Collection<RegistryObject<Block>> getEntries() {
        
        return BLOCKS.getEntries();
    }
    
}
