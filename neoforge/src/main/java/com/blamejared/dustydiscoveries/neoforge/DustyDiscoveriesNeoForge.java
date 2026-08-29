package com.blamejared.dustydiscoveries.neoforge;

import com.blamejared.dustydiscoveries.DDConstants;
import com.blamejared.dustydiscoveries.DustyDiscoveries;
import com.blamejared.dustydiscoveries.world.item.DDItems;
import com.blamejared.dustydiscoveries.world.level.block.DDBlocks;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@Mod(DDConstants.MODID)
public class DustyDiscoveriesNeoForge {
    
    public DustyDiscoveriesNeoForge(final IEventBus modEventBus) {
        
        DustyDiscoveries.init();
        modEventBus.addListener(this::commonSetup);
    }
    
    private void commonSetup(final FMLCommonSetupEvent event) {
        
        DDBlocks.modifyBlockEntityTypes();
    }
    
}
