package com.blamejared.dustydiscoveries.core.component;

import com.blamejared.dustydiscoveries.DDConstants;
import com.blamejared.dustydiscoveries.platform.IRegister;
import com.blamejared.dustydiscoveries.platform.RegistrationProvider;
import com.blamejared.dustydiscoveries.platform.RegistryObject;
import com.google.auto.service.AutoService;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.structure.Structure;

import java.util.Collection;

@AutoService(IRegister.class)
public class DDComponents implements IRegister {
    
    private static final RegistrationProvider<DataComponentType<?>> COMPONENTS = RegistrationProvider.get(Registries.DATA_COMPONENT_TYPE, DDConstants.MODID);
    public static final RegistryObject<DataComponentType<TagKey<Structure>>> FOSSIL = COMPONENTS.register("fossil", () -> DataComponentType.<TagKey<Structure>> builder()
            .persistent(TagKey.codec(Registries.STRUCTURE))
            .networkSynchronized(TagKey.streamCodec(Registries.STRUCTURE))
            .build());
    
    public static Collection<RegistryObject<DataComponentType<?>>> getEntries() {
        
        return COMPONENTS.getEntries();
    }
    
}
