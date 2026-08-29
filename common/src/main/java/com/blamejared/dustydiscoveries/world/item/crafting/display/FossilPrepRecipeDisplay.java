package com.blamejared.dustydiscoveries.world.item.crafting.display;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import net.minecraft.world.item.crafting.display.SlotDisplay;

public record FossilPrepRecipeDisplay(SlotDisplay input, SlotDisplay result,
                                      SlotDisplay craftingStation) implements RecipeDisplay {
    
    public static final MapCodec<FossilPrepRecipeDisplay> MAP_CODEC = RecordCodecBuilder.mapCodec(
            i -> i.group(
                            SlotDisplay.CODEC.fieldOf("input").forGetter(FossilPrepRecipeDisplay::input),
                            SlotDisplay.CODEC.fieldOf("result").forGetter(FossilPrepRecipeDisplay::result),
                            SlotDisplay.CODEC.fieldOf("crafting_station").forGetter(FossilPrepRecipeDisplay::craftingStation)
                    )
                    .apply(i, FossilPrepRecipeDisplay::new)
    );
    public static final StreamCodec<RegistryFriendlyByteBuf, FossilPrepRecipeDisplay> STREAM_CODEC = StreamCodec.composite(
            SlotDisplay.STREAM_CODEC,
            FossilPrepRecipeDisplay::input,
            SlotDisplay.STREAM_CODEC,
            FossilPrepRecipeDisplay::result,
            SlotDisplay.STREAM_CODEC,
            FossilPrepRecipeDisplay::craftingStation,
            FossilPrepRecipeDisplay::new
    );
    public static final RecipeDisplay.Type<FossilPrepRecipeDisplay> TYPE = new RecipeDisplay.Type<>(MAP_CODEC, STREAM_CODEC);
    
    @Override
    public RecipeDisplay.Type<FossilPrepRecipeDisplay> type() {
        
        return TYPE;
    }
    
}

