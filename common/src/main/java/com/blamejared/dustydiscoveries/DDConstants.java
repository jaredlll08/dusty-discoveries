package com.blamejared.dustydiscoveries;

import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;

public class DDConstants {
    
    public static final String MODID = "dustydiscoveries";
    
    public static Identifier id(final String path) {
        
        return Identifier.fromNamespaceAndPath(MODID, path);
    }
    
    public static String sid(final String path) {
        
        return MODID + ":" + path;
    }
    
    public static <T> ResourceKey<T> rc(final ResourceKey<? extends Registry<T>> registry, final String path) {
        
        return ResourceKey.create(registry, id(path));
    }
    
}
