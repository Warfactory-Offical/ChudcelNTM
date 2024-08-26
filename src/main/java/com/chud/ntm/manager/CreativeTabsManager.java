package com.chud.ntm.manager;

import com.chud.ntm.item.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.gen.structure.StructureVillagePieces;

import java.lang.reflect.Field;

public class CreativeTabsManager {

    public static class Tab extends CreativeTabs {

        private final String modItemName;

        public Tab(String label, String modItemName) {
            super(label);
            this.modItemName = modItemName;
        }

        public Item getIconItem() {
            Field[] modItemFields = ModItems.class.getFields();

            for (Field field : modItemFields) {
                if (field.getName().equals(modItemName)) {
                    field.setAccessible(true);
                    try {
                        return (Item) field.get(null);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            return Item.getByNameOrId("iron_pickaxe");
        }

        @Override
        public ItemStack createIcon() {
            return new ItemStack(getIconItem());
        }

    }

    // Creative Tabs
    // ingots, nuggets, wires, machine parts
    public static CreativeTabs partsTab = new Tab("tabParts", "ingot_zirconium");
//    // items that belong in machines, fuels, etc
//    public static CreativeTabs controlTab = new Tab("tabControl");
//    // templates, siren tracks
//    public static CreativeTabs templateTab = new Tab("tabTemplate");
//    // ore and mineral blocks
//    public static CreativeTabs resourceTab = new Tab("tabResource");
//    // construction blocks
//    public static CreativeTabs blockTab = new Tab("tabBlocks");
//    // machines, structure parts
//    public static CreativeTabs machineTab = new Tab("tabMachine");
//    // bombs
//    public static CreativeTabs nukeTab = new Tab("tabNuke");
//    // missiles, satellites
//    public static CreativeTabs missileTab = new Tab("tabMissile");
//    // turrets, weapons, ammo
//    public static CreativeTabs weaponTab = new Tab("tabWeapon");
//    // drinks, kits, tools
//    public static CreativeTabs consumableTab = new Tab("tabConsumable");

}
