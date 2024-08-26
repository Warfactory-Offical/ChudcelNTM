package com.chud.ntm;

import com.chud.ntm.hazard.HazardRegistry;
import com.chud.ntm.manager.OreDictionaryManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.chud.ntm.RefStrings.*;

@Mod(modid = MODID, version = VERSION, name = NAME, acceptedMinecraftVersions = "[1.12.2]")
public class ChudNTM {

    public static final Logger LOGGER = LogManager.getLogger(MODID);


    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        LOGGER.info("PreInit start " + NAME + " v" + VERSION);
        {

        }
        LOGGER.info("PreInit end");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        LOGGER.info("PostInit start");
        {
            OreDictionaryManager.registerAll();
            HazardRegistry.populate();
        }
        LOGGER.info("PostInit end");
    }

}
