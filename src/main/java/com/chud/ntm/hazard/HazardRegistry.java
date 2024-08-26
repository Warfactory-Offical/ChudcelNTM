package com.chud.ntm.hazard;

import akka.japi.Pair;
import com.chud.ntm.ChudNTM;
import com.chud.ntm.item.enums.MaterialNTM;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.*;
import java.util.stream.Collectors;

import static com.chud.ntm.RefStrings.*;

@EventBusSubscriber(modid=MODID)
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
                new Hazard(Hazard.Type.TOXIC, 2.f),
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
        materialHazards.put(MaterialNTM.uranium, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 0.35f)
        ));
        materialHazards.put(MaterialNTM.u233, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 5.f)
        ));
        materialHazards.put(MaterialNTM.u238, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 5.f)
        ));
        materialHazards.put(MaterialNTM.schrabidium, new HazardList(
                new Hazard(Hazard.Type.RADIATION, 15.f),
                new Hazard(Hazard.Type.BLINDING,  50.f)
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

    @SubscribeEvent
    public static void drawTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        EntityPlayer entityPlayer = event.getEntityPlayer();
        List<String> list = event.getToolTip();

        // TODO: HAZMAT INFO

        // TODO: CLADDING

        // TODO: ARMOR MODS

        // TODO: CUSTOM NUKE

        // TODO: NEUTRON RADS

        // TODO: MKU

        // HAZARD

        HazardRegistry.addFullTooltip(stack, entityPlayer, list);
    }

}
