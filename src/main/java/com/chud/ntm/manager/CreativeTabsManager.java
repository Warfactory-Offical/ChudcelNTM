package com.chud.ntm.manager;

import com.chud.ntm.item.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.gen.structure.StructureVillagePieces;

import java.lang.reflect.Field;

public class CreativeTabsManager {

    public static class Tab extends CreativeTabs {

        private final Item modItem;

        public Tab(String label, Item modItem) {
            super(label);
            this.modItem = modItem;
        }

        @Override
        public ItemStack createIcon() {
            return new ItemStack(modItem);
        }

    }

    // Creative Tabs
    // ingots, nuggets, wires, machine parts
    public static CreativeTabs partsTab = new Tab("tabParts", ModItems.ingot_zirconium);
    // items that belong in machines, fuels, etc
    public static CreativeTabs controlTab = new Tab("tabControl", /* TODO: ModItems.pellet_rtg */ Items.IRON_PICKAXE);
    // templates, siren tracks
    public static CreativeTabs templateTab = new Tab("tabTemplate", Items.IRON_PICKAXE);
    // ore and mineral blocks
    public static CreativeTabs resourceTab = new Tab("tabResource", Items.IRON_PICKAXE);
    // construction blocks
    public static CreativeTabs blockTab = new Tab("tabBlocks", Items.IRON_PICKAXE);
    // machines, structure parts
    public static CreativeTabs machineTab = new Tab("tabMachine", Items.IRON_PICKAXE);
    // bombs
    public static CreativeTabs nukeTab = new Tab("tabNuke", /* TODO: ModBlocks.nuke_man */ Items.IRON_PICKAXE);
    // missiles, satellites
    public static CreativeTabs missileTab = new Tab("tabMissile", Items.IRON_PICKAXE);
    // turrets, weapons, ammo
    public static CreativeTabs weaponTab = new Tab("tabWeapon", /* TODO: ModItems.gun_lever_action */ Items.IRON_PICKAXE);
    // drinks, kits, tools
    public static CreativeTabs consumableTab = new Tab("tabConsumable", /* TODO: ModItems.bottle_nuka */ Items.IRON_PICKAXE);

}
