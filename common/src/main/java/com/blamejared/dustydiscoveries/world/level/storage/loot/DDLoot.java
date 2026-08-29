package com.blamejared.dustydiscoveries.world.level.storage.loot;

import com.blamejared.dustydiscoveries.DDConstants;
import com.blamejared.dustydiscoveries.platform.IRegister;
import com.google.auto.service.AutoService;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@AutoService(IRegister.class)
public class DDLoot implements IRegister {
    
    private static final Set<ResourceKey<LootTable>> LOCATIONS = new HashSet<>();
    private static final Set<ResourceKey<LootTable>> IMMUTABLE_LOCATIONS = Collections.unmodifiableSet(LOCATIONS);
    
    public static final ResourceKey<LootTable> FLOW_FOSSIL = register("fossil/flow");
    public static final ResourceKey<LootTable> SHELL_FOSSIL = register("fossil/shell");
    public static final ResourceKey<LootTable> SILENCE_FOSSIL = register("fossil/silence");
    public static final ResourceKey<LootTable> SKULL_FOSSIL = register("fossil/skull");
    public static final ResourceKey<LootTable> SNOUT_FOSSIL = register("fossil/snout");
    public static final ResourceKey<LootTable> TOOTH_FOSSIL = register("fossil/tooth");
    
    private static ResourceKey<LootTable> register(final String path) {
        
        ResourceKey<LootTable> location = DDConstants.rc(Registries.LOOT_TABLE, path);
        if(LOCATIONS.add(location)) {
            return location;
        } else {
            throw new IllegalArgumentException(location.identifier() + " is already a registered loot table");
        }
    }
    
    public static Set<ResourceKey<LootTable>> getEntries() {
        
        return IMMUTABLE_LOCATIONS;
    }
    
}
