package com.chud.ntm;

import com.chud.ntm.item.ModItems;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.chud.ntm.RefStrings.*;

@Mod(modid = MODID, version = VERSION, name = NAME, acceptedMinecraftVersions = "[1.12.2]")
public class ChudNTM {

    public static final Logger LOGGER = LogManager.getLogger(MODID);

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        LOGGER.info("PreInit " + NAME + " v" + VERSION);
    }

}
