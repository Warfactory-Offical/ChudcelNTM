package com.chud.ntm.hazard;

import akka.japi.Pair;
import com.chud.ntm.ChudNTM;
import com.chud.ntm.item.enums.MaterialNTM;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

import java.util.*;
import java.util.stream.Collectors;

public class HazardRegistry {

    private static final Map<String, Float> shapeMultipliers = new LinkedHashMap<>();

    static {
        final float nugget = 0.1F;
        final float wire = 0.2F;
        final float rod = 0.5F;
        final float stick = 0.5F;
        final float billet = 0.5F;
        final float ingot = 1.0F;
        final float gem = 1.0F;
        final float powderMult = 3.0F;
        final float block = 10.0F;
        final float plate = ingot;
        final float plateCast = plate * 3; //IDK what that is
        final float powder = ingot * powderMult;
        final float powderTiny = nugget * powderMult;
        final float ore = ingot * 3;
        final float crystal = block;
        final float rtg = billet * 3;
        final float rodDual = rod * 2;
        final float rodQuad = rod * 4;
        final float rodRbmk = rod * 8;

        shapeMultipliers.put("nugget",  nugget);
        shapeMultipliers.put("wire",    wire);
        shapeMultipliers.put("stick",   stick);
        shapeMultipliers.put("ingot",   ingot);
        shapeMultipliers.put("gem",     gem);
        shapeMultipliers.put("plate",   plate);
        shapeMultipliers.put("powder",  powder);
        shapeMultipliers.put("block",   powderTiny);
        shapeMultipliers.put("crystal", crystal);
        shapeMultipliers.put("rod",     rod);
        shapeMultipliers.put("rodDual", rodDual);
        shapeMultipliers.put("rodQuad", rodQuad);
        shapeMultipliers.put("rodRbmk", rodRbmk);
        shapeMultipliers.put("rtg",     rtg);
        shapeMultipliers.put("ore",     ore);
    }

    private static final Map<MaterialNTM, HazardList> materialHazards = new LinkedHashMap<>();

    static {
        materialHazards.put(MaterialNTM.lead, new HazardList(
                new Hazard(Hazard.Type.TOXIC, 2.f)
        ));
        materialHazards.put(MaterialNTM.pb209, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 10_000.f),
                new Hazard(Hazard.Type.TOXIC, 2.f),
                new Hazard(Hazard.Type.BLINDING, 50.f),
                new Hazard(Hazard.Type.HOT, 3.f)
        ));
        materialHazards.put(MaterialNTM.arsenic, new HazardList(
                new Hazard(Hazard.Type.TOXIC, 10.f)
        ));
        materialHazards.put(MaterialNTM.c4, new HazardList(
                new Hazard(Hazard.Type.EXPLOSIVE, 10.f)
        ));
        materialHazards.put(MaterialNTM.phosphorus, new HazardList(
                new Hazard(Hazard.Type.EXPLOSIVE, 4.f)
        ));
        materialHazards.put(MaterialNTM.lithium, new HazardList(
                new Hazard(Hazard.Type.HYDROACTIVE, 2.f)
        ));
        materialHazards.put(MaterialNTM.cerium, new HazardList(
                new Hazard(Hazard.Type.HYDROACTIVE, 4.f)
        ));
        //THORIUM
        materialHazards.put(MaterialNTM.th232, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 0.1f)
        ));
        materialHazards.put(MaterialNTM.thorium_fuel, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 1.75f)
        ));
        //URANIUM
        materialHazards.put(MaterialNTM.ferrouranium, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 0.175f)
        ));
        materialHazards.put(MaterialNTM.uranium, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 0.35f)
        ));
        materialHazards.put(MaterialNTM.u233, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 5.f)
        ));
        materialHazards.put(MaterialNTM.u238, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 5.f)
        ));
        materialHazards.put(MaterialNTM.u235, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 1.f)
        ));
        materialHazards.put(MaterialNTM.uranium_fuel, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 0.5f)
        ));
        //SCHRABIDIUMLIKE
        materialHazards.put(MaterialNTM.schrabidate, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 3.f),
                new Hazard(Hazard.Type.BLINDING,  50.f)
        ));
        materialHazards.put(MaterialNTM.schrabidium, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 15.f),
                new Hazard(Hazard.Type.BLINDING,  50.f)
        ));
        materialHazards.put(MaterialNTM.schraranium, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 1.5f),
                new Hazard(Hazard.Type.BLINDING,  50.f)
        ));
        materialHazards.put(MaterialNTM.solinium, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 17.5f),
                new Hazard(Hazard.Type.BLINDING,  50.f)
        ));
        materialHazards.put(MaterialNTM.schrabidium_fuel, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 5.85f),
                new Hazard(Hazard.Type.BLINDING,  50.f)
        ));
        materialHazards.put(MaterialNTM.les, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 2.52f),
                new Hazard(Hazard.Type.BLINDING,  50.f)
        ));
        materialHazards.put(MaterialNTM.hes, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 8.8f),
                new Hazard(Hazard.Type.BLINDING,  50.f)
        ));
        //NEPTUNIUM
        materialHazards.put(MaterialNTM.neptunium, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 2.5f),
                new Hazard(Hazard.Type.HOT, 3.f)
        ));
        materialHazards.put(MaterialNTM.neptunium_fuel, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 1.5f),
                new Hazard(Hazard.Type.HOT, 3.f)
        ));
        //PLUTONIUM
        materialHazards.put(MaterialNTM.plutonium, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 7.5f)
        ));
        materialHazards.put(MaterialNTM.pu238, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 10.f),
                new Hazard(Hazard.Type.HOT,  6.f)
        ));
        materialHazards.put(MaterialNTM.pu239, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 5.f)
        ));
        materialHazards.put(MaterialNTM.pu240, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 7.5f)
        ));
        materialHazards.put(MaterialNTM.pu241, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 25.f)
        ));
        materialHazards.put(MaterialNTM.pu_mix, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 6.25f)
        ));
        materialHazards.put(MaterialNTM.plutonium_fuel, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 4.25f)
        ));
        ///AMERICIUM
        materialHazards.put(MaterialNTM.am241, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 8.5f)
        ));
        materialHazards.put(MaterialNTM.am242, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 9.5f)
        ));
        materialHazards.put(MaterialNTM.am_mix, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 9.f)
        ));
        materialHazards.put(MaterialNTM.americium_fuel, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 4.75f)
        ));
        //COBALT60
        materialHazards.put(MaterialNTM.co60, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 30.f),
                new Hazard(Hazard.Type.HOT, 6.f)
        ));

        //TENNESINE
        materialHazards.put(MaterialNTM.tennessine, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 120.f)
        ));
        //MAGTUNGST
        materialHazards.put(MaterialNTM.magnetized_tungsten, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 0.75f)
        ));
        //TECHNICIUM
        materialHazards.put(MaterialNTM.technetium, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 2.75f)
        ));
        materialHazards.put(MaterialNTM.tcalloy, new HazardList(
               new Hazard(Hazard.Type.RADIATION, 0.075f)
        ));
        //POLONIUM
        materialHazards.put(MaterialNTM.polonium, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 75.f)
        ));
        //STRONTIUM
        materialHazards.put(MaterialNTM.strontium, new HazardList(
                new Hazard(Hazard.Type.HYDROACTIVE, 8f)
        ));
        materialHazards.put(MaterialNTM.sr90, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 15f),
                new Hazard(Hazard.Type.HYDROACTIVE, 8f),
                new Hazard(Hazard.Type.HOT, 8f)
        ));
        //IODINE131
        materialHazards.put(MaterialNTM.i131, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 150.f)
        ));
        //RADIUM
        materialHazards.put(MaterialNTM.ra226, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 7.5f),
                new Hazard(Hazard.Type.HYDROACTIVE, 10f)
        ));
        //GOLD 198
        materialHazards.put(MaterialNTM.ra226, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 500.f),
                new Hazard(Hazard.Type.HOT, 8f)
        ));
        //AC227
        materialHazards.put(MaterialNTM.ac227, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 30.f)
        ));
        //RADSPICE
        materialHazards.put(MaterialNTM.radspice, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 20_000.f)
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

    @SideOnly(Side.CLIENT)
    public static void addFullTooltip(ItemStack stack, EntityPlayer player, List<String> list) {
        HazardList hazards = getHazardsForItemStack(stack);
        hazards.addHazardInformation(player, list, stack);
    }

    private static void applyHazards(ItemStack stack, EntityPlayer target) {
        HazardList hazards = getHazardsForItemStack(stack);
        hazards.onUpdate(target, stack);
    }

    public static void updatePlayerInventory(EntityPlayer player) {
        NonNullList<ItemStack> mainInventory = player.inventory.mainInventory;
        NonNullList<ItemStack> armorInventory = player.inventory.armorInventory;

        // Iterate over main inventory
        for (int i = 0; i < mainInventory.size(); i++) {
            ItemStack stack = mainInventory.get(i);

            // Check if stack is not empty
            if (!stack.isEmpty()) {
                applyHazards(stack, player);

                // Check if stack is now empty after applying hazards
                if (stack.getCount() == 0) {
                    mainInventory.set(i, ItemStack.EMPTY);
                }
            }
        }

        // Iterate over armor inventory
        for (ItemStack stack : armorInventory) {
            if (!stack.isEmpty()) {
                applyHazards(stack, player);
            }
        }
    }

}
