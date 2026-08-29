package com.blamejared.dustydiscoveries.world.item;

import com.blamejared.dustydiscoveries.DDConstants;
import com.blamejared.dustydiscoveries.core.component.DDComponents;
import com.blamejared.dustydiscoveries.tags.DDTags;
import com.blamejared.dustydiscoveries.world.level.saveddata.maps.DDMapDecorationTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.MapItem;
import net.minecraft.world.item.component.ItemLore;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;

import java.util.List;

public class FieldNotesItem extends Item {
    
    public FieldNotesItem(final Properties properties) {
        
        super(properties);
    }
    
    public static DataComponentPatch getFossilComponents(final TagKey<Structure> structure) {
        
        return DataComponentPatch.builder()
                .set(DDComponents.FOSSIL.get(), structure)
                .set(DataComponents.LORE, new ItemLore(List.of(Component.translatable("lore.dustydiscoveries.field_note." + structure.location()
                        .getPath())))).build();
    }
    
    public static ItemStack stackWithFossilComponents(final TagKey<Structure> structure) {
        
        ItemStack defaultInstance = DDItems.FOSSIL_FIELD_NOTES.get().getDefaultInstance();
        defaultInstance.applyComponents(getFossilComponents(structure));
        return defaultInstance;
    }
    
    public static ItemStackTemplate templateWithFossilComponents(final TagKey<Structure> structure) {
        
        return new ItemStackTemplate(DDItems.FOSSIL_FIELD_NOTES.get(), getFossilComponents(structure));
    }
    
    
    @Override
    public InteractionResult use(final Level level, final Player player, final InteractionHand hand) {
        
        ItemStack itemStack = player.getItemInHand(hand);
        if(!itemStack.has(DDComponents.FOSSIL.get())) {
            return InteractionResult.PASS;
        }
        if(level instanceof ServerLevel serverLevel) {
            TagKey<Structure> structureTag = itemStack.getOrDefault(DDComponents.FOSSIL.get(), DDTags.Structures.FOSSILS);
            //TODO make max search radius a config and cooldown
            BlockPos nearestMapStructure = serverLevel.findNearestMapStructure(structureTag, player.blockPosition(), 100, true);
            if(nearestMapStructure != null) {
                player.getCooldowns().addCooldown(itemStack, 10);
                itemStack.consume(1, player);
                player.awardStat(Stats.ITEM_USED.get(this));
                serverLevel.playSound(null, player, SoundEvents.UI_CARTOGRAPHY_TABLE_TAKE_RESULT, player.getSoundSource(), 1.0F, 1.0F);
                
                ItemStack map = MapItem.create(serverLevel, nearestMapStructure.getX(), nearestMapStructure.getZ(), (byte) 0, true, true);
                MapItem.renderBiomePreviewMap(serverLevel, map);
                MapItemSavedData.addTargetDecoration(map, nearestMapStructure, "+", DDMapDecorationTypes.FOSSIL.asHolder());
                map.set(DataComponents.ITEM_NAME, Component.translatable("filled_map." + DDConstants.sid("fossil")));
                
                if(itemStack.isEmpty()) {
                    return InteractionResult.SUCCESS.heldItemTransformedTo(map);
                }
                if(!player.getInventory().add(map.copy())) {
                    player.drop(map, false);
                }
                
            }
            
            
        }
        return InteractionResult.SUCCESS;
    }
    
}
