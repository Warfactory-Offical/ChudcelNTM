package com.chud.ntm.client;

import com.chud.ntm.machine.FurnaceIron;
import mcjty.theoneprobe.proxy.CommonProxy;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {

    public static void init() {
        ClientRegistry.bindTileEntitySpecialRenderer(FurnaceIron.TileEntity.class, new FurnaceIron.Renderer());
    }

}