package com.blamejared.dustydiscoveries.world.level.block.entity;

import com.blamejared.dustydiscoveries.DDConstants;
import com.blamejared.dustydiscoveries.platform.IRegister;
import com.blamejared.dustydiscoveries.platform.RegistrationProvider;
import com.blamejared.dustydiscoveries.platform.RegistryObject;
import com.blamejared.dustydiscoveries.world.level.block.DDBlocks;
import com.google.auto.service.AutoService;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.Collection;
import java.util.stream.Collectors;

@AutoService(IRegister.class)
public class DDBlockEntities implements IRegister {
    
    private static final RegistrationProvider<BlockEntityType<?>> REGISTRY = RegistrationProvider.get(Registries.BLOCK_ENTITY_TYPE, DDConstants.MODID);
    public static final RegistryObject<BlockEntityType<DisplayCaseBlockEntity>> DISPLAY_CASE = REGISTRY.register("display_case", () -> new BlockEntityType<>(DisplayCaseBlockEntity::new, DDBlocks.DISPLAY_CASES.asList()
            .stream()
            .map(RegistryObject::get)
            .collect(Collectors.toSet())));
    
    public static Collection<RegistryObject<BlockEntityType<?>>> getEntries() {
        
        return REGISTRY.getEntries();
    }
    
}
