package com.chud.ntm;

import com.chud.ntm.block.ModBlocks;
import com.chud.ntm.client.ClientProxy;
import com.chud.ntm.hazard.HazardRegistry;
import com.chud.ntm.item.ModItems;
import com.chud.ntm.manager.GameRegistryManager;
import com.chud.ntm.manager.OreDictionaryManager;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.chud.ntm.RefStrings.*;

@Mod(modid = MODID, version = VERSION, name = NAME, acceptedMinecraftVersions = "[1.12.2]")
public class ChudNTM {

    public static ChudNTM INSTANCE;

    public ChudNTM() {
        assert INSTANCE == null;
        INSTANCE = this;
    }

    public static final Logger LOGGER = LogManager.getLogger(MODID);

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        LOGGER.info("PreInit start " + NAME + " v" + VERSION);
        {
            ModItems.preInit();
            ModBlocks.preInit();
            GameRegistryManager.preInit();
        }
        LOGGER.info("PreInit end");
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        LOGGER.info("Init start");
        {
            ModBlocks.init();
            ClientProxy.init();
        }
        LOGGER.info("Init end");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        LOGGER.info("PostInit start");
        {
            OreDictionaryManager.postInit();
            HazardRegistry.postInit();
        }
        LOGGER.info("PostInit end");
    }

}
