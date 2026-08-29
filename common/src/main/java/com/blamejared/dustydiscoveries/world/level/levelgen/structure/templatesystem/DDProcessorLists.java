package com.blamejared.dustydiscoveries.world.level.levelgen.structure.templatesystem;

import com.blamejared.dustydiscoveries.DDConstants;
import com.blamejared.dustydiscoveries.world.level.block.DDBlocks;
import com.blamejared.dustydiscoveries.world.level.storage.loot.DDLoot;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.AlwaysTrueTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.PosAlwaysTrueTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.ProcessorRule;
import net.minecraft.world.level.levelgen.structure.templatesystem.ProtectedBlockProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.RandomBlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import net.minecraft.world.level.levelgen.structure.templatesystem.rule.blockentity.AppendLoot;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.List;

public class DDProcessorLists {
    
    public static final ResourceKey<StructureProcessorList> FOSSILIZE_FLOW = DDConstants.rc(Registries.PROCESSOR_LIST, "fossilize/flow");
    public static final ResourceKey<StructureProcessorList> FOSSILIZE_SHELL = DDConstants.rc(Registries.PROCESSOR_LIST, "fossilize/shell");
    public static final ResourceKey<StructureProcessorList> FOSSILIZE_SILENCE = DDConstants.rc(Registries.PROCESSOR_LIST, "fossilize/silence");
    public static final ResourceKey<StructureProcessorList> FOSSILIZE_SKULL = DDConstants.rc(Registries.PROCESSOR_LIST, "fossilize/skull");
    public static final ResourceKey<StructureProcessorList> FOSSILIZE_SNOUT = DDConstants.rc(Registries.PROCESSOR_LIST, "fossilize/snout");
    public static final ResourceKey<StructureProcessorList> FOSSILIZE_TOOTH = DDConstants.rc(Registries.PROCESSOR_LIST, "fossilize/tooth");
    
    public static void bootstrap(final BootstrapContext<StructureProcessorList> context) {
        
        HolderGetter<Block> blocks = context.lookup(Registries.BLOCK);
        
        context.register(FOSSILIZE_FLOW, fossilize(blocks, DDLoot.FLOW_FOSSIL));
        context.register(FOSSILIZE_SHELL, fossilize(blocks, DDLoot.SHELL_FOSSIL));
        context.register(FOSSILIZE_SILENCE, fossilize(blocks, DDLoot.SILENCE_FOSSIL));
        context.register(FOSSILIZE_SKULL, fossilize(blocks, DDLoot.SKULL_FOSSIL));
        context.register(FOSSILIZE_SNOUT, fossilize(blocks, DDLoot.SNOUT_FOSSIL));
        context.register(FOSSILIZE_TOOTH, fossilize(blocks, DDLoot.TOOTH_FOSSIL));
    }
    
    private static StructureProcessorList fossilize(final HolderGetter<Block> blocks, final ResourceKey<LootTable> loot) {
        
        return new StructureProcessorList(List.of(
                new RuleProcessor(
                        List.of(
                                new ProcessorRule(new RandomBlockMatchTest(Blocks.BONE_BLOCK, 0.1f),
                                        AlwaysTrueTest.INSTANCE,
                                        PosAlwaysTrueTest.INSTANCE,
                                        DDBlocks.FOSSILIZED_BONE_BLOCK.get().defaultBlockState(),
                                        new AppendLoot(loot))
                        )
                ),
                new ProtectedBlockProcessor(blocks.getOrThrow(BlockTags.FEATURES_CANNOT_REPLACE))
        ));
    }
    
    
}
