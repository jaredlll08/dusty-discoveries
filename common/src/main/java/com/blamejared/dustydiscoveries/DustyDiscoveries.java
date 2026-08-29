package com.blamejared.dustydiscoveries;

import com.blamejared.dustydiscoveries.platform.IRegister;
import com.blamejared.dustydiscoveries.platform.Services;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ServiceLoader;

public class DustyDiscoveries {
    
    public static final Logger LOG = LogManager.getLogger(DDConstants.MODID);
    
    public static void init() {
        
        Services.loadAll(IRegister.class).forEach(ServiceLoader.Provider::get);
    }
    
}
