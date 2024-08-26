package com.chud.ntm.item;

import com.chud.ntm.item.enums.MaterialNTM;
import com.chud.ntm.item.templates.IngotItem;
import com.chud.ntm.item.templates.PlateItem;
import com.chud.ntm.item.templates.WireItem;
import com.chud.ntm.item.tool.*;

import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.function.Consumer;


public class ModItems {

    public static void forEachItem(Consumer<Item> action) {
        Field[] fields = ModItems.class.getFields();

        for (Field field : fields) {
            if (field.getType() == Item.class) {
                field.setAccessible(true);
                try {
                    Item item = (Item) field.get(null);
                    if (item != null) {
                        ResourceLocation itemRegistryName = item.getRegistryName();

                        if (itemRegistryName == null) continue;

                        ResourceLocation textureLocation = new ResourceLocation(
                                itemRegistryName.getNamespace(),
                                "textures/items/" + itemRegistryName.getPath() + ".png"
                        );

                        try {
                            if (Minecraft.getMinecraft().getResourceManager().getResource(textureLocation) != null) {
                                action.accept(item);
                            } else {
                                // TODO: Generate textures on the fly??
                            }
                        } catch (IOException ignored) {

                        }
                    } else {
                        throw new RuntimeException();
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    // items

    public static final Item redstone_sword = new RedstoneSwordItem();

    // ingots

    public static final Item ingot_ac227 = new IngotItem(MaterialNTM.ac227);
    public static final Item ingot_actinium = new IngotItem(MaterialNTM.actinium);
    public static final Item ingot_advanced_alloy = new IngotItem(MaterialNTM.advanced_alloy);
    public static final Item ingot_aluminium = new IngotItem(MaterialNTM.aluminium);
    public static final Item ingot_am241 = new IngotItem(MaterialNTM.am241);
    public static final Item ingot_am242 = new IngotItem(MaterialNTM.am242);
    public static final Item ingot_am_mix = new IngotItem(MaterialNTM.am_mix);
    public static final Item ingot_americium_fuel = new IngotItem(MaterialNTM.americium_fuel);
    public static final Item ingot_arsenic = new IngotItem(MaterialNTM.arsenic);
    public static final Item ingot_asbestos = new IngotItem(MaterialNTM.asbestos);
    public static final Item ingot_astatine = new IngotItem(MaterialNTM.astatine);
    public static final Item ingot_au198 = new IngotItem(MaterialNTM.au198);
    public static final Item ingot_australium = new IngotItem(MaterialNTM.australium);
    public static final Item ingot_bakelite = new IngotItem(MaterialNTM.bakelite);
    public static final Item ingot_beryllium = new IngotItem(MaterialNTM.beryllium);
    public static final Item ingot_biorubber = new IngotItem(MaterialNTM.biorubber);
    public static final Item ingot_bismuth = new IngotItem(MaterialNTM.bismuth);
    public static final Item ingot_boron = new IngotItem(MaterialNTM.boron);
    public static final Item ingot_bromine = new IngotItem(MaterialNTM.bromine);
    public static final Item ingot_c4 = new IngotItem(MaterialNTM.c4);
    public static final Item ingot_cadmium = new IngotItem(MaterialNTM.cadmium);
    public static final Item ingot_caesium = new IngotItem(MaterialNTM.caesium);
    public static final Item ingot_cdalloy = new IngotItem(MaterialNTM.cdalloy);
    public static final Item ingot_cerium = new IngotItem(MaterialNTM.cerium);
    public static final Item ingot_chainsteel = new IngotItem(MaterialNTM.chainsteel);
    public static final Item ingot_co60 = new IngotItem(MaterialNTM.co60);
    public static final Item ingot_cobalt = new IngotItem(MaterialNTM.cobalt);
    public static final Item ingot_combine_steel = new IngotItem(MaterialNTM.combine_steel);
    public static final Item ingot_copper = new IngotItem(MaterialNTM.copper);
    public static final Item ingot_daffergon = new IngotItem(MaterialNTM.daffergon);
    public static final Item ingot_desh = new IngotItem(MaterialNTM.desh);
    public static final Item ingot_dineutronium = new IngotItem(MaterialNTM.dineutronium);
    public static final Item ingot_dura_steel = new IngotItem(MaterialNTM.dura_steel);
    public static final Item ingot_electronium = new IngotItem(MaterialNTM.electronium);
    public static final Item ingot_euphemium = new IngotItem(MaterialNTM.euphemium);
    public static final Item ingot_ferrouranium = new IngotItem(MaterialNTM.ferrouranium);
    public static final Item ingot_fiberglass = new IngotItem(MaterialNTM.fiberglass);
    public static final Item ingot_firebrick = new IngotItem(MaterialNTM.firebrick);
    public static final Item ingot_gh336 = new IngotItem(MaterialNTM.gh336);
    public static final Item ingot_graphite = new IngotItem(MaterialNTM.graphite);
    public static final Item ingot_hes = new IngotItem(MaterialNTM.hes);
    public static final Item ingot_i131 = new IngotItem(MaterialNTM.i131);
    public static final Item ingot_iodine = new IngotItem(MaterialNTM.iodine);
    public static final Item ingot_lanthanium = new IngotItem(MaterialNTM.lanthanium);
    public static final Item ingot_lead = new IngotItem(MaterialNTM.lead);
    public static final Item ingot_les = new IngotItem(MaterialNTM.les);
    public static final Item ingot_magnetized_tungsten = new IngotItem(MaterialNTM.magnetized_tungsten);
    public static final Item ingot_meteorite = new IngotItem(MaterialNTM.meteorite);
    public static final Item ingot_meteorite_forged = new IngotItem(MaterialNTM.meteorite_forged);
    public static final Item ingot_mox_fuel = new IngotItem(MaterialNTM.mox_fuel);
    public static final Item ingot_neodymium = new IngotItem(MaterialNTM.neodymium);
    public static final Item ingot_neptunium = new IngotItem(MaterialNTM.neptunium);
    public static final Item ingot_neptunium_fuel = new IngotItem(MaterialNTM.neptunium_fuel);
    public static final Item ingot_niobium = new IngotItem(MaterialNTM.niobium);
    public static final Item ingot_osmiridium = new IngotItem(MaterialNTM.osmiridium);
    public static final Item ingot_pb209 = new IngotItem(MaterialNTM.pb209);
    public static final Item ingot_phosphorus = new IngotItem(MaterialNTM.phosphorus);
    public static final Item ingot_plutonium = new IngotItem(MaterialNTM.plutonium);
    public static final Item ingot_plutonium_fuel = new IngotItem(MaterialNTM.plutonium_fuel);
    public static final Item ingot_polonium = new IngotItem(MaterialNTM.polonium);
    public static final Item ingot_polymer = new IngotItem(MaterialNTM.polymer);
    public static final Item ingot_pu238 = new IngotItem(MaterialNTM.pu238);
    public static final Item ingot_pu239 = new IngotItem(MaterialNTM.pu239);
    public static final Item ingot_pu240 = new IngotItem(MaterialNTM.pu240);
    public static final Item ingot_pu241 = new IngotItem(MaterialNTM.pu241);
    public static final Item ingot_pu_mix = new IngotItem(MaterialNTM.pu_mix);
    public static final Item ingot_ra226 = new IngotItem(MaterialNTM.ra226);
    public static final Item ingot_radspice = new IngotItem(MaterialNTM.radspice);
    public static final Item ingot_red_copper = new IngotItem(MaterialNTM.red_copper);
    public static final Item ingot_reiium = new IngotItem(MaterialNTM.reiium);
    public static final Item ingot_rubber = new IngotItem(MaterialNTM.rubber);
    public static final Item ingot_saturnite = new IngotItem(MaterialNTM.saturnite);
    public static final Item ingot_schrabidate = new IngotItem(MaterialNTM.schrabidate);
    public static final Item ingot_schrabidium = new IngotItem(MaterialNTM.schrabidium);
    public static final Item ingot_schrabidium_fuel = new IngotItem(MaterialNTM.schrabidium_fuel);
    public static final Item ingot_schraranium = new IngotItem(MaterialNTM.schraranium);
    public static final Item ingot_semtex = new IngotItem(MaterialNTM.semtex);
    public static final Item ingot_smore = new IngotItem(MaterialNTM.smore);
    public static final Item ingot_solinium = new IngotItem(MaterialNTM.solinium);
    public static final Item ingot_sr90 = new IngotItem(MaterialNTM.sr90);
    public static final Item ingot_starmetal = new IngotItem(MaterialNTM.starmetal);
    public static final Item ingot_steel = new IngotItem(MaterialNTM.steel);
    public static final Item ingot_steel_dusted = new IngotItem(MaterialNTM.steel_dusted);
    public static final Item ingot_strontium = new IngotItem(MaterialNTM.strontium);
    public static final Item ingot_tantalium = new IngotItem(MaterialNTM.tantalium);
    public static final Item ingot_tcalloy = new IngotItem(MaterialNTM.tcalloy);
    public static final Item ingot_technetium = new IngotItem(MaterialNTM.technetium);
    public static final Item ingot_tennessine = new IngotItem(MaterialNTM.tennessine);
    public static final Item ingot_th232 = new IngotItem(MaterialNTM.th232);
    public static final Item ingot_thorium_fuel = new IngotItem(MaterialNTM.thorium_fuel);
    public static final Item ingot_titanium = new IngotItem(MaterialNTM.titanium);
    public static final Item ingot_tungsten = new IngotItem(MaterialNTM.tungsten);
    public static final Item ingot_u233 = new IngotItem(MaterialNTM.u233);
    public static final Item ingot_u235 = new IngotItem(MaterialNTM.u235);
    public static final Item ingot_u238 = new IngotItem(MaterialNTM.u238);
    public static final Item ingot_u238m2 = new IngotItem(MaterialNTM.u238m2);
    public static final Item ingot_unobtainium = new IngotItem(MaterialNTM.unobtainium);
    public static final Item ingot_uranium = new IngotItem(MaterialNTM.uranium);
    public static final Item ingot_uranium_fuel = new IngotItem(MaterialNTM.uranium_fuel);
    public static final Item ingot_verticium = new IngotItem(MaterialNTM.verticium);
    public static final Item ingot_weidanium = new IngotItem(MaterialNTM.weidanium);
    public static final Item ingot_zirconium = new IngotItem(MaterialNTM.zirconium);

    // wires

    public static final Item wire_ac227 = new WireItem(MaterialNTM.ac227);
    public static final Item wire_actinium = new WireItem(MaterialNTM.actinium);
    public static final Item wire_advanced_alloy = new WireItem(MaterialNTM.advanced_alloy);
    public static final Item wire_aluminium = new WireItem(MaterialNTM.aluminium);
    public static final Item wire_am241 = new WireItem(MaterialNTM.am241);
    public static final Item wire_am242 = new WireItem(MaterialNTM.am242);
    public static final Item wire_am_mix = new WireItem(MaterialNTM.am_mix);
    public static final Item wire_americium_fuel = new WireItem(MaterialNTM.americium_fuel);
    public static final Item wire_arsenic = new WireItem(MaterialNTM.arsenic);
    public static final Item wire_asbestos = new WireItem(MaterialNTM.asbestos);
    public static final Item wire_astatine = new WireItem(MaterialNTM.astatine);
    public static final Item wire_au198 = new WireItem(MaterialNTM.au198);
    public static final Item wire_australium = new WireItem(MaterialNTM.australium);
    public static final Item wire_bakelite = new WireItem(MaterialNTM.bakelite);
    public static final Item wire_beryllium = new WireItem(MaterialNTM.beryllium);
    public static final Item wire_biorubber = new WireItem(MaterialNTM.biorubber);
    public static final Item wire_bismuth = new WireItem(MaterialNTM.bismuth);
    public static final Item wire_boron = new WireItem(MaterialNTM.boron);
    public static final Item wire_bromine = new WireItem(MaterialNTM.bromine);
    public static final Item wire_c4 = new WireItem(MaterialNTM.c4);
    public static final Item wire_cadmium = new WireItem(MaterialNTM.cadmium);
    public static final Item wire_caesium = new WireItem(MaterialNTM.caesium);
    public static final Item wire_cdalloy = new WireItem(MaterialNTM.cdalloy);
    public static final Item wire_cerium = new WireItem(MaterialNTM.cerium);
    public static final Item wire_chainsteel = new WireItem(MaterialNTM.chainsteel);
    public static final Item wire_co60 = new WireItem(MaterialNTM.co60);
    public static final Item wire_cobalt = new WireItem(MaterialNTM.cobalt);
    public static final Item wire_combine_steel = new WireItem(MaterialNTM.combine_steel);
    public static final Item wire_copper = new WireItem(MaterialNTM.copper);
    public static final Item wire_daffergon = new WireItem(MaterialNTM.daffergon);
    public static final Item wire_desh = new WireItem(MaterialNTM.desh);
    public static final Item wire_dineutronium = new WireItem(MaterialNTM.dineutronium);
    public static final Item wire_dura_steel = new WireItem(MaterialNTM.dura_steel);
    public static final Item wire_electronium = new WireItem(MaterialNTM.electronium);
    public static final Item wire_euphemium = new WireItem(MaterialNTM.euphemium);
    public static final Item wire_ferrouranium = new WireItem(MaterialNTM.ferrouranium);
    public static final Item wire_fiberglass = new WireItem(MaterialNTM.fiberglass);
    public static final Item wire_firebrick = new WireItem(MaterialNTM.firebrick);
    public static final Item wire_gh336 = new WireItem(MaterialNTM.gh336);
    public static final Item wire_graphite = new WireItem(MaterialNTM.graphite);
    public static final Item wire_hes = new WireItem(MaterialNTM.hes);
    public static final Item wire_i131 = new WireItem(MaterialNTM.i131);
    public static final Item wire_iodine = new WireItem(MaterialNTM.iodine);
    public static final Item wire_lanthanium = new WireItem(MaterialNTM.lanthanium);
    public static final Item wire_lead = new WireItem(MaterialNTM.lead);
    public static final Item wire_les = new WireItem(MaterialNTM.les);
    public static final Item wire_magnetized_tungsten = new WireItem(MaterialNTM.magnetized_tungsten);
    public static final Item wire_meteorite = new WireItem(MaterialNTM.meteorite);
    public static final Item wire_meteorite_forged = new WireItem(MaterialNTM.meteorite_forged);
    public static final Item wire_mox_fuel = new WireItem(MaterialNTM.mox_fuel);
    public static final Item wire_neodymium = new WireItem(MaterialNTM.neodymium);
    public static final Item wire_neptunium = new WireItem(MaterialNTM.neptunium);
    public static final Item wire_neptunium_fuel = new WireItem(MaterialNTM.neptunium_fuel);
    public static final Item wire_niobium = new WireItem(MaterialNTM.niobium);
    public static final Item wire_osmiridium = new WireItem(MaterialNTM.osmiridium);
    public static final Item wire_pb209 = new WireItem(MaterialNTM.pb209);
    public static final Item wire_phosphorus = new WireItem(MaterialNTM.phosphorus);
    public static final Item wire_plutonium = new WireItem(MaterialNTM.plutonium);
    public static final Item wire_plutonium_fuel = new WireItem(MaterialNTM.plutonium_fuel);
    public static final Item wire_polonium = new WireItem(MaterialNTM.polonium);
    public static final Item wire_polymer = new WireItem(MaterialNTM.polymer);
    public static final Item wire_pu238 = new WireItem(MaterialNTM.pu238);
    public static final Item wire_pu239 = new WireItem(MaterialNTM.pu239);
    public static final Item wire_pu240 = new WireItem(MaterialNTM.pu240);
    public static final Item wire_pu241 = new WireItem(MaterialNTM.pu241);
    public static final Item wire_pu_mix = new WireItem(MaterialNTM.pu_mix);
    public static final Item wire_ra226 = new WireItem(MaterialNTM.ra226);
    public static final Item wire_radspice = new WireItem(MaterialNTM.radspice);
    public static final Item wire_red_copper = new WireItem(MaterialNTM.red_copper);
    public static final Item wire_reiium = new WireItem(MaterialNTM.reiium);
    public static final Item wire_rubber = new WireItem(MaterialNTM.rubber);
    public static final Item wire_saturnite = new WireItem(MaterialNTM.saturnite);
    public static final Item wire_schrabidate = new WireItem(MaterialNTM.schrabidate);
    public static final Item wire_schrabidium = new WireItem(MaterialNTM.schrabidium);
    public static final Item wire_schrabidium_fuel = new WireItem(MaterialNTM.schrabidium_fuel);
    public static final Item wire_schraranium = new WireItem(MaterialNTM.schraranium);
    public static final Item wire_semtex = new WireItem(MaterialNTM.semtex);
    public static final Item wire_smore = new WireItem(MaterialNTM.smore);
    public static final Item wire_solinium = new WireItem(MaterialNTM.solinium);
    public static final Item wire_sr90 = new WireItem(MaterialNTM.sr90);
    public static final Item wire_starmetal = new WireItem(MaterialNTM.starmetal);
    public static final Item wire_steel = new WireItem(MaterialNTM.steel);
    public static final Item wire_steel_dusted = new WireItem(MaterialNTM.steel_dusted);
    public static final Item wire_strontium = new WireItem(MaterialNTM.strontium);
    public static final Item wire_tantalium = new WireItem(MaterialNTM.tantalium);
    public static final Item wire_tcalloy = new WireItem(MaterialNTM.tcalloy);
    public static final Item wire_technetium = new WireItem(MaterialNTM.technetium);
    public static final Item wire_tennessine = new WireItem(MaterialNTM.tennessine);
    public static final Item wire_th232 = new WireItem(MaterialNTM.th232);
    public static final Item wire_thorium_fuel = new WireItem(MaterialNTM.thorium_fuel);
    public static final Item wire_titanium = new WireItem(MaterialNTM.titanium);
    public static final Item wire_tungsten = new WireItem(MaterialNTM.tungsten);
    public static final Item wire_u233 = new WireItem(MaterialNTM.u233);
    public static final Item wire_u235 = new WireItem(MaterialNTM.u235);
    public static final Item wire_u238 = new WireItem(MaterialNTM.u238);
    public static final Item wire_u238m2 = new WireItem(MaterialNTM.u238m2);
    public static final Item wire_unobtainium = new WireItem(MaterialNTM.unobtainium);
    public static final Item wire_uranium = new WireItem(MaterialNTM.uranium);
    public static final Item wire_uranium_fuel = new WireItem(MaterialNTM.uranium_fuel);
    public static final Item wire_verticium = new WireItem(MaterialNTM.verticium);
    public static final Item wire_weidanium = new WireItem(MaterialNTM.weidanium);
    public static final Item wire_zirconium = new WireItem(MaterialNTM.zirconium);

    // plates

    public static final Item plate_ac227 = new PlateItem(MaterialNTM.ac227);
    public static final Item plate_actinium = new PlateItem(MaterialNTM.actinium);
    public static final Item plate_advanced_alloy = new PlateItem(MaterialNTM.advanced_alloy);
    public static final Item plate_aluminium = new PlateItem(MaterialNTM.aluminium);
    public static final Item plate_am241 = new PlateItem(MaterialNTM.am241);
    public static final Item plate_am242 = new PlateItem(MaterialNTM.am242);
    public static final Item plate_am_mix = new PlateItem(MaterialNTM.am_mix);
    public static final Item plate_americium_fuel = new PlateItem(MaterialNTM.americium_fuel);
    public static final Item plate_arsenic = new PlateItem(MaterialNTM.arsenic);
    public static final Item plate_asbestos = new PlateItem(MaterialNTM.asbestos);
    public static final Item plate_astatine = new PlateItem(MaterialNTM.astatine);
    public static final Item plate_au198 = new PlateItem(MaterialNTM.au198);
    public static final Item plate_australium = new PlateItem(MaterialNTM.australium);
    public static final Item plate_bakelite = new PlateItem(MaterialNTM.bakelite);
    public static final Item plate_beryllium = new PlateItem(MaterialNTM.beryllium);
    public static final Item plate_biorubber = new PlateItem(MaterialNTM.biorubber);
    public static final Item plate_bismuth = new PlateItem(MaterialNTM.bismuth);
    public static final Item plate_boron = new PlateItem(MaterialNTM.boron);
    public static final Item plate_bromine = new PlateItem(MaterialNTM.bromine);
    public static final Item plate_c4 = new PlateItem(MaterialNTM.c4);
    public static final Item plate_cadmium = new PlateItem(MaterialNTM.cadmium);
    public static final Item plate_caesium = new PlateItem(MaterialNTM.caesium);
    public static final Item plate_cdalloy = new PlateItem(MaterialNTM.cdalloy);
    public static final Item plate_cerium = new PlateItem(MaterialNTM.cerium);
    public static final Item plate_chainsteel = new PlateItem(MaterialNTM.chainsteel);
    public static final Item plate_co60 = new PlateItem(MaterialNTM.co60);
    public static final Item plate_cobalt = new PlateItem(MaterialNTM.cobalt);
    public static final Item plate_combine_steel = new PlateItem(MaterialNTM.combine_steel);
    public static final Item plate_copper = new PlateItem(MaterialNTM.copper);
    public static final Item plate_daffergon = new PlateItem(MaterialNTM.daffergon);
    public static final Item plate_desh = new PlateItem(MaterialNTM.desh);
    public static final Item plate_dineutronium = new PlateItem(MaterialNTM.dineutronium);
    public static final Item plate_dura_steel = new PlateItem(MaterialNTM.dura_steel);
    public static final Item plate_electronium = new PlateItem(MaterialNTM.electronium);
    public static final Item plate_euphemium = new PlateItem(MaterialNTM.euphemium);
    public static final Item plate_ferrouranium = new PlateItem(MaterialNTM.ferrouranium);
    public static final Item plate_fiberglass = new PlateItem(MaterialNTM.fiberglass);
    public static final Item plate_firebrick = new PlateItem(MaterialNTM.firebrick);
    public static final Item plate_gh336 = new PlateItem(MaterialNTM.gh336);
    public static final Item plate_graphite = new PlateItem(MaterialNTM.graphite);
    public static final Item plate_hes = new PlateItem(MaterialNTM.hes);
    public static final Item plate_i131 = new PlateItem(MaterialNTM.i131);
    public static final Item plate_iodine = new PlateItem(MaterialNTM.iodine);
    public static final Item plate_lanthanium = new PlateItem(MaterialNTM.lanthanium);
    public static final Item plate_lead = new PlateItem(MaterialNTM.lead);
    public static final Item plate_les = new PlateItem(MaterialNTM.les);
    public static final Item plate_magnetized_tungsten = new PlateItem(MaterialNTM.magnetized_tungsten);
    public static final Item plate_meteorite = new PlateItem(MaterialNTM.meteorite);
    public static final Item plate_meteorite_forged = new PlateItem(MaterialNTM.meteorite_forged);
    public static final Item plate_mox_fuel = new PlateItem(MaterialNTM.mox_fuel);
    public static final Item plate_neodymium = new PlateItem(MaterialNTM.neodymium);
    public static final Item plate_neptunium = new PlateItem(MaterialNTM.neptunium);
    public static final Item plate_neptunium_fuel = new PlateItem(MaterialNTM.neptunium_fuel);
    public static final Item plate_niobium = new PlateItem(MaterialNTM.niobium);
    public static final Item plate_osmiridium = new PlateItem(MaterialNTM.osmiridium);
    public static final Item plate_pb209 = new PlateItem(MaterialNTM.pb209);
    public static final Item plate_phosphorus = new PlateItem(MaterialNTM.phosphorus);
    public static final Item plate_plutonium = new PlateItem(MaterialNTM.plutonium);
    public static final Item plate_plutonium_fuel = new PlateItem(MaterialNTM.plutonium_fuel);
    public static final Item plate_polonium = new PlateItem(MaterialNTM.polonium);
    public static final Item plate_polymer = new PlateItem(MaterialNTM.polymer);
    public static final Item plate_pu238 = new PlateItem(MaterialNTM.pu238);
    public static final Item plate_pu239 = new PlateItem(MaterialNTM.pu239);
    public static final Item plate_pu240 = new PlateItem(MaterialNTM.pu240);
    public static final Item plate_pu241 = new PlateItem(MaterialNTM.pu241);
    public static final Item plate_pu_mix = new PlateItem(MaterialNTM.pu_mix);
    public static final Item plate_ra226 = new PlateItem(MaterialNTM.ra226);
    public static final Item plate_radspice = new PlateItem(MaterialNTM.radspice);
    public static final Item plate_red_copper = new PlateItem(MaterialNTM.red_copper);
    public static final Item plate_reiium = new PlateItem(MaterialNTM.reiium);
    public static final Item plate_rubber = new PlateItem(MaterialNTM.rubber);
    public static final Item plate_saturnite = new PlateItem(MaterialNTM.saturnite);
    public static final Item plate_schrabidate = new PlateItem(MaterialNTM.schrabidate);
    public static final Item plate_schrabidium = new PlateItem(MaterialNTM.schrabidium);
    public static final Item plate_schrabidium_fuel = new PlateItem(MaterialNTM.schrabidium_fuel);
    public static final Item plate_schraranium = new PlateItem(MaterialNTM.schraranium);
    public static final Item plate_semtex = new PlateItem(MaterialNTM.semtex);
    public static final Item plate_smore = new PlateItem(MaterialNTM.smore);
    public static final Item plate_solinium = new PlateItem(MaterialNTM.solinium);
    public static final Item plate_sr90 = new PlateItem(MaterialNTM.sr90);
    public static final Item plate_starmetal = new PlateItem(MaterialNTM.starmetal);
    public static final Item plate_steel = new PlateItem(MaterialNTM.steel);
    public static final Item plate_steel_dusted = new PlateItem(MaterialNTM.steel_dusted);
    public static final Item plate_strontium = new PlateItem(MaterialNTM.strontium);
    public static final Item plate_tantalium = new PlateItem(MaterialNTM.tantalium);
    public static final Item plate_tcalloy = new PlateItem(MaterialNTM.tcalloy);
    public static final Item plate_technetium = new PlateItem(MaterialNTM.technetium);
    public static final Item plate_tennessine = new PlateItem(MaterialNTM.tennessine);
    public static final Item plate_th232 = new PlateItem(MaterialNTM.th232);
    public static final Item plate_thorium_fuel = new PlateItem(MaterialNTM.thorium_fuel);
    public static final Item plate_titanium = new PlateItem(MaterialNTM.titanium);
    public static final Item plate_tungsten = new PlateItem(MaterialNTM.tungsten);
    public static final Item plate_u233 = new PlateItem(MaterialNTM.u233);
    public static final Item plate_u235 = new PlateItem(MaterialNTM.u235);
    public static final Item plate_u238 = new PlateItem(MaterialNTM.u238);
    public static final Item plate_u238m2 = new PlateItem(MaterialNTM.u238m2);
    public static final Item plate_unobtainium = new PlateItem(MaterialNTM.unobtainium);
    public static final Item plate_uranium = new PlateItem(MaterialNTM.uranium);
    public static final Item plate_uranium_fuel = new PlateItem(MaterialNTM.uranium_fuel);
    public static final Item plate_verticium = new PlateItem(MaterialNTM.verticium);
    public static final Item plate_weidanium = new PlateItem(MaterialNTM.weidanium);
    public static final Item plate_zirconium = new PlateItem(MaterialNTM.zirconium);

}
