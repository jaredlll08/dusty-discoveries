package com.blamejared.dustydiscoveries.world.item.trading;

import com.blamejared.dustydiscoveries.DDConstants;
import com.blamejared.dustydiscoveries.platform.IRegister;
import com.blamejared.dustydiscoveries.tags.DDTags;
import com.google.auto.service.AutoService;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.trading.TradeSet;
import net.minecraft.world.item.trading.VillagerTrade;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.Optional;

@AutoService(IRegister.class)
public class DDTradeSets implements IRegister {
    
    public static final ResourceKey<TradeSet> PALEONTOLOGIST_1 = DDConstants.rc(Registries.TRADE_SET, "paleontologist/level_1");
    public static final ResourceKey<TradeSet> PALEONTOLOGIST_2 = DDConstants.rc(Registries.TRADE_SET, "paleontologist/level_2");
    public static final ResourceKey<TradeSet> PALEONTOLOGIST_3 = DDConstants.rc(Registries.TRADE_SET, "paleontologist/level_3");
    public static final ResourceKey<TradeSet> PALEONTOLOGIST_4 = DDConstants.rc(Registries.TRADE_SET, "paleontologist/level_4");
    public static final ResourceKey<TradeSet> PALEONTOLOGIST_5 = DDConstants.rc(Registries.TRADE_SET, "paleontologist/level_5");
    
    public static void bootstrap(final BootstrapContext<TradeSet> context) {
        
        HolderGetter<VillagerTrade> lookup = context.lookup(Registries.VILLAGER_TRADE);
        ConstantValue amount = ConstantValue.exactly(2);
        context.register(PALEONTOLOGIST_1, new TradeSet(lookup.getOrThrow(DDTags.VillagerTrades.PALEONTOLOGIST_LEVEL_1), amount, false, Optional.of(PALEONTOLOGIST_1.identifier()
                .withPrefix("trade_set/"))));
        context.register(PALEONTOLOGIST_2, new TradeSet(lookup.getOrThrow(DDTags.VillagerTrades.PALEONTOLOGIST_LEVEL_2), amount, false, Optional.of(PALEONTOLOGIST_2.identifier()
                .withPrefix("trade_set/"))));
        context.register(PALEONTOLOGIST_3, new TradeSet(lookup.getOrThrow(DDTags.VillagerTrades.PALEONTOLOGIST_LEVEL_3), amount, false, Optional.of(PALEONTOLOGIST_3.identifier()
                .withPrefix("trade_set/"))));
        context.register(PALEONTOLOGIST_4, new TradeSet(lookup.getOrThrow(DDTags.VillagerTrades.PALEONTOLOGIST_LEVEL_4), amount, false, Optional.of(PALEONTOLOGIST_4.identifier()
                .withPrefix("trade_set/"))));
        context.register(PALEONTOLOGIST_5, new TradeSet(lookup.getOrThrow(DDTags.VillagerTrades.PALEONTOLOGIST_LEVEL_5), amount, false, Optional.of(PALEONTOLOGIST_5.identifier()
                .withPrefix("trade_set/"))));
    }
    
}
