package com.chud.ntm.hazard;

import akka.japi.Pair;
import com.chud.ntm.ChudNTM;
import com.chud.ntm.item.enums.EMaterial;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
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

    public static void postInit() {
        populate();
    }

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
//        final float plateCast = plate * 3;
        final float powder = ingot * powderMult;
        final float powderTiny = nugget * powderMult;
        final float ore = ingot * 3;
        final float crystal = block;
        final float rtg = billet * 3;
        final float rodDual = rod * 2;
        final float rodQuad = rod * 4;
        final float rodRbmk = rod * 8;

        shapeMultipliers.put("billet",      billet);
        shapeMultipliers.put("block",       block);
        shapeMultipliers.put("crystal",     crystal);
        shapeMultipliers.put("gem",         gem);
        shapeMultipliers.put("ingot",       ingot);
        shapeMultipliers.put("nugget",      nugget);
        shapeMultipliers.put("ore",         ore);
        shapeMultipliers.put("plate",       plate);
        shapeMultipliers.put("dust",        powder);
        shapeMultipliers.put("dustTiny",    powderTiny);
        shapeMultipliers.put("rod",         rod);
        shapeMultipliers.put("rodDual",     rodDual);
        shapeMultipliers.put("rodQuad",     rodQuad);
        shapeMultipliers.put("rodRbmk",     rodRbmk);
        shapeMultipliers.put("rtg",         rtg);
        shapeMultipliers.put("stick",       stick);
        shapeMultipliers.put("wire",        wire);
    }

    private static final Map<EMaterial, HazardList> materialHazards = new LinkedHashMap<>();

    static {
        materialHazards.put(EMaterial.lead, new HazardList(
                new Hazard(Hazard.Type.TOXIC, 2.f)
        ));
        materialHazards.put(EMaterial.asbestos, new HazardList(
                new Hazard(Hazard.Type.ASBESTOS, 1f)
        ));
        materialHazards.put(EMaterial.pb209, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 10_000.f),
                new Hazard(Hazard.Type.TOXIC, 2.f),
                new Hazard(Hazard.Type.BLINDING, 50.f),
                new Hazard(Hazard.Type.HOT, 3.f)
        ));
        materialHazards.put(EMaterial.arsenic, new HazardList(
                new Hazard(Hazard.Type.TOXIC, 10.f)
        ));
        materialHazards.put(EMaterial.c4, new HazardList(
                new Hazard(Hazard.Type.EXPLOSIVE, 10.f)
        ));
        materialHazards.put(EMaterial.phosphorus, new HazardList(
                new Hazard(Hazard.Type.EXPLOSIVE, 4.f)
        ));
        materialHazards.put(EMaterial.lithium, new HazardList(
                new Hazard(Hazard.Type.HYDROACTIVE, 2.f)
        ));
        materialHazards.put(EMaterial.cerium, new HazardList(
                new Hazard(Hazard.Type.HYDROACTIVE, 4.f)
        ));
        materialHazards.put(EMaterial.th232, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 0.1f)
        ));
        materialHazards.put(EMaterial.thorium_fuel, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 1.75f)
        ));
        materialHazards.put(EMaterial.ferrouranium, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 0.175f)
        ));
        materialHazards.put(EMaterial.uranium, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 0.35f)
        ));
        materialHazards.put(EMaterial.u233, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 5.f)
        ));
        materialHazards.put(EMaterial.u238, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 5.f)
        ));
        materialHazards.put(EMaterial.u235, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 1.f)
        ));
        materialHazards.put(EMaterial.uranium_fuel, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 0.5f)
        ));
        materialHazards.put(EMaterial.schrabidate, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 3.f),
                new Hazard(Hazard.Type.BLINDING,  50.f)
        ));
        materialHazards.put(EMaterial.schrabidium, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 15.f),
                new Hazard(Hazard.Type.BLINDING,  50.f)
        ));
        materialHazards.put(EMaterial.schraranium, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 1.5f),
                new Hazard(Hazard.Type.BLINDING,  50.f)
        ));
        materialHazards.put(EMaterial.solinium, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 17.5f),
                new Hazard(Hazard.Type.BLINDING,  50.f)
        ));
        materialHazards.put(EMaterial.schrabidium_fuel, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 5.85f),
                new Hazard(Hazard.Type.BLINDING,  50.f)
        ));
        materialHazards.put(EMaterial.les, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 2.52f),
                new Hazard(Hazard.Type.BLINDING,  50.f)
        ));
        materialHazards.put(EMaterial.hes, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 8.8f),
                new Hazard(Hazard.Type.BLINDING,  50.f)
        ));
        materialHazards.put(EMaterial.neptunium, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 2.5f),
                new Hazard(Hazard.Type.HOT, 3.f)
        ));
        materialHazards.put(EMaterial.neptunium_fuel, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 1.5f),
                new Hazard(Hazard.Type.HOT, 3.f)
        ));
        materialHazards.put(EMaterial.plutonium, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 7.5f)
        ));
        materialHazards.put(EMaterial.pu238, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 10.f),
                new Hazard(Hazard.Type.HOT,  6.f)
        ));
        materialHazards.put(EMaterial.pu239, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 5.f)
        ));
        materialHazards.put(EMaterial.pu240, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 7.5f)
        ));
        materialHazards.put(EMaterial.pu241, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 25.f)
        ));
        materialHazards.put(EMaterial.pu_mix, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 6.25f)
        ));
        materialHazards.put(EMaterial.plutonium_fuel, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 4.25f)
        ));

        materialHazards.put(EMaterial.am241, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 8.5f)
        ));
        materialHazards.put(EMaterial.am242, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 9.5f)
        ));
        materialHazards.put(EMaterial.am_mix, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 9.f)
        ));
        materialHazards.put(EMaterial.americium_fuel, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 4.75f)
        ));
        materialHazards.put(EMaterial.co60, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 30.f),
                new Hazard(Hazard.Type.HOT, 6.f)
        ));
        materialHazards.put(EMaterial.tennessine, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 120.f)
        ));
        materialHazards.put(EMaterial.magnetized_tungsten, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 0.75f)
        ));
        materialHazards.put(EMaterial.technetium, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 2.75f)
        ));
        materialHazards.put(EMaterial.tcalloy, new HazardList(
               new Hazard(Hazard.Type.RADIATION, 0.075f)
        ));
        materialHazards.put(EMaterial.polonium, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 75.f)
        ));
        materialHazards.put(EMaterial.strontium, new HazardList(
                new Hazard(Hazard.Type.HYDROACTIVE, 8f)
        ));
        materialHazards.put(EMaterial.sr90, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 15f),
                new Hazard(Hazard.Type.HYDROACTIVE, 8f),
                new Hazard(Hazard.Type.HOT, 8f)
        ));
        materialHazards.put(EMaterial.i131, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 150.f)
        ));
        materialHazards.put(EMaterial.ra226, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 7.5f),
                new Hazard(Hazard.Type.HYDROACTIVE, 10f)
        ));
        materialHazards.put(EMaterial.ra226, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 500.f),
                new Hazard(Hazard.Type.HOT, 8f)
        ));
        materialHazards.put(EMaterial.ac227, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 30.f)
        ));
        materialHazards.put(EMaterial.radspice, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 20_000.f)
        ));
    }

    private static final Map<Pair<Item, Integer>, HazardList> hazardMap = new LinkedHashMap();

    private static void populate() {
        for (Map.Entry<String, Float> shapeEntry : shapeMultipliers.entrySet()) {
            for (EMaterial material : EMaterial.values()) {
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
            }
        }

        // Quick fix. Will be rewritten in the near future
        hazardMap.put(new Pair<>(Items.COAL, 0), new HazardList(
                new Hazard(Hazard.Type.COAL, 1.f)
        ));
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

        for (int i = 0; i < mainInventory.size(); i++) {
            ItemStack stack = mainInventory.get(i);

            if (!stack.isEmpty()) {
                applyHazards(stack, player);

                if (stack.getCount() == 0) {
                    mainInventory.set(i, ItemStack.EMPTY);
                }
            }
        }

        for (ItemStack stack : armorInventory) {
            if (!stack.isEmpty()) {
                applyHazards(stack, player);
            }
        }
    }

}
