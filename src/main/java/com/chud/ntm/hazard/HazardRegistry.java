package com.chud.ntm.hazard;

import akka.japi.Pair;
import com.chud.ntm.ChudNTM;
import com.chud.ntm.item.enums.MaterialNTM;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.*;
import java.util.stream.Collectors;

public class HazardRegistry {

    private static final Map<String, Float> shapeMultipliers = new LinkedHashMap<>();

    static {
        shapeMultipliers.put("nugget", 0.1f);
        shapeMultipliers.put("ingot", 1.f);
        shapeMultipliers.put("gem", 1.f);
        shapeMultipliers.put("plate", 1.f);
        shapeMultipliers.put("powder", 3.f);
        shapeMultipliers.put("block", 10.f);
    }

    private static final Map<MaterialNTM, HazardList> materialHazards = new LinkedHashMap<>();

    static {
        materialHazards.put(MaterialNTM.lead, new HazardList(
                new Hazard(Hazard.Type.TOXIC, 2.f)
        ));
    }

    private static final Map<Pair<Item, Integer>, HazardList> hazardMap = new LinkedHashMap();

    public static void populate() {
        for (Map.Entry<String, Float> shapeEntry : shapeMultipliers.entrySet()) {
            for (MaterialNTM material : MaterialNTM.values()) {
                if (!materialHazards.containsKey(material)) continue; // TODO: remove

                final String oreDictEntryName = shapeEntry.getKey() + material.PascalCase();

                HazardList hazards = new HazardList(
                        materialHazards
                            .get(material)
                            .stream()
                            .map(hazard -> hazard.multiply(shapeEntry.getValue()))
                            .collect(Collectors.toList())
                );

                for (ItemStack is : OreDictionary.getOres(oreDictEntryName)) {
                    Pair<Item, Integer> key = new Pair<>(is.getItem(), is.getMetadata());
                    hazardMap.put(key, hazards);
                }

                ChudNTM.LOGGER.info("oreDictEntryName: {}, hazards: {}", oreDictEntryName, hazards);
            }
        }
    }

    public static HazardList getHazardsForItemStack(ItemStack is) {
        Pair<Item, Integer> key = new Pair<>(is.getItem(), is.getMetadata());

        return new HazardList(
            hazardMap.containsKey(key)
                ? hazardMap
                    .get(key)
                    .stream()
                    .map(hazard -> hazard.multiply(is.getCount()))
                    .collect(Collectors.toList())
                : new ArrayList<>()
        );
    }

}
