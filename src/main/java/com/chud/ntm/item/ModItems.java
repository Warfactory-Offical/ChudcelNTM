package com.chud.ntm.item;

import net.minecraft.item.Item;
import com.chud.ntm.item.tool.*;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModItems {

    public static final Item REDSTONE_SWORD = new RedstoneSwordItem();

    public static void register() {
        ForgeRegistries.ITEMS.register(REDSTONE_SWORD);
    }

}
