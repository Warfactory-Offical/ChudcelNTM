package com.chud.ntm;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import static com.chud.ntm.RefStrings.*;

@Mod(modid = MODID, version = VERSION, name = NAME, acceptedMinecraftVersions = "[1.12.2]")
public class Main {

    public static final Logger LOGGER = LogManager.getLogger(MODID);

    @EventHandler
    public void preLoad(FMLPreInitializationEvent event){

        LOGGER.warn("You are running Chud NTM: " + VERSION);

    }

}
