package com.chud.ntm.item;

import com.chud.ntm.ChudNTM;
import com.chud.ntm.item.enums.MaterialNTM;
import com.chud.ntm.item.templates.IngotItem;
import com.chud.ntm.item.tool.*;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.lang.reflect.Field;
import java.util.function.Consumer;

import static com.chud.ntm.RefStrings.*;

@EventBusSubscriber(modid=MODID)
public class ModItems {

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

    // functions

    private static void forEachItem(Consumer<Item> action) {
        Field[] fields = ModItems.class.getFields();

        for (Field field : fields) {
            if (field.getType() == Item.class) {
                field.setAccessible(true);
                try {
                    Item item = (Item) field.get(null);
                    if (item != null) {
                        action.accept(item);
                    } else {
                        throw new RuntimeException();
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        forEachItem(item -> {
            event.getRegistry().register(item);
            ChudNTM.LOGGER.info("Registered item: {}", item.getRegistryName());
        });
    }

    private static void registerRender(Item item) {
        ModelLoader
                .setCustomModelResourceLocation(item, 0,
                        new ModelResourceLocation(
                            item.getRegistryName(),
                            "inventory"
                        )
                );
    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {
        forEachItem(item -> {
            registerRender(item);
            ChudNTM.LOGGER.info("Registered render for item: {}", item.getRegistryName());
        });
    }

}
