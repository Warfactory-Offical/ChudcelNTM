package com.chud.ntm.manager;

import com.chud.ntm.ChudNTM;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

import java.util.HashMap;
import java.util.Map;

public class OreDictionaryManager {

    public static final Map<String, Item> itemMap = new HashMap<>();

    public static void postInit() {
        register();
    }

    public static void queueRegisterOre(String name, Item ore) {
        itemMap.put(name, ore);
    }

    private static void register() {
        for (Map.Entry<String, Item> entry : itemMap.entrySet()) {
            OreDictionary.registerOre(entry.getKey(), entry.getValue());
            ChudNTM.LOGGER.info("new OreDict entry: {}", entry.getKey());
        }
    }

}
