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

    public static final Item ingot_steel = new IngotItem(MaterialNTM.steel);
    public static final Item ingot_titanium = new IngotItem(MaterialNTM.titanium);
    public static final Item ingot_copper = new IngotItem(MaterialNTM.copper);
    public static final Item ingot_red_copper = new IngotItem(MaterialNTM.red_copper);
    public static final Item ingot_advanced_alloy = new IngotItem(MaterialNTM.advanced_alloy);
    public static final Item ingot_tungsten = new IngotItem(MaterialNTM.tungsten);
    public static final Item ingot_aluminium = new IngotItem(MaterialNTM.aluminium);
    public static final Item ingot_beryllium = new IngotItem(MaterialNTM.beryllium);
//    public static final Item ingot_lead = new ItemHazard("ingot_lead").addToxic(2).toItem().setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_asbestos = new ItemHazard("ingot_asbestos").addAsbestos(6).toItem().setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_magnetized_tungsten = new ItemHazard(ItemHazard.magt, "ingot_magnetized_tungsten").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_combine_steel = new ItemCustomLore("ingot_combine_steel").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_dura_steel = new ItemCustomLore("ingot_dura_steel").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_technetium = new ItemHazard("ingot_technetium").addRadiation(ItemHazard.tc99 * ItemHazard.ingot).toItem().setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_tcalloy = new ItemHazard(0.07F, "ingot_tcalloy").setCreativeTab(ChudNTM.partsTab);
    public static final Item ingot_cdalloy = new IngotItem(MaterialNTM.cdalloy);
//    public static final Item ingot_polymer = new ItemCustomLore("ingot_polymer").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_bakelite = new ItemCustomLore("ingot_bakelite").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_rubber = new ItemCustomLore("ingot_rubber").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_biorubber = new ItemCustomLore("ingot_biorubber").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_desh = new ItemCustomLore("ingot_desh").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_saturnite = new ItemCustomLore("ingot_saturnite").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_ferrouranium = new ItemHazard("ingot_ferrouranium").addRadiation(ItemHazard.u * 0.5F).toItem().setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_starmetal = new ItemCustomLore("ingot_starmetal").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_osmiridium = new ItemHazard("ingot_osmiridium").addDigamma(0.040F).toItem().setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_euphemium = new ItemCustomLore("ingot_euphemium").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_dineutronium = new ItemCustomLore("ingot_dineutronium").setCreativeTab(ChudNTM.partsTab);
    public static final Item ingot_cadmium = new IngotItem(MaterialNTM.cadmium);
//    public static final Item ingot_bismuth = new ItemCustomLore("ingot_bismuth").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_arsenic = new ItemHazard("ingot_arsenic").addToxic(16).toItem().setCreativeTab(ChudNTM.partsTab);
    public static final Item ingot_zirconium = new IngotItem(MaterialNTM.zirconium);
//    public static final Item ingot_th232 = new ItemHazard(ItemHazard.th232, "ingot_th232").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_uranium = new ItemHazard(ItemHazard.u, "ingot_uranium").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_u233 = new ItemHazard(ItemHazard.u233, "ingot_u233").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_u235 = new ItemHazard(ItemHazard.u235, "ingot_u235").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_u238 = new ItemHazard(ItemHazard.u238, "ingot_u238").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_u238m2 = new ItemUnstable(350, 200, "ingot_u238m2").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_plutonium = new ItemHazard(ItemHazard.pu, "ingot_plutonium").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_pu238 = new ItemHazard(ItemHazard.pu238, true, false, "ingot_pu238").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_pu239 = new ItemHazard(ItemHazard.pu239, "ingot_pu239").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_pu240 = new ItemHazard(ItemHazard.pu240, "ingot_pu240").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_pu241 = new ItemHazard("ingot_pu241").addRadiation(ItemHazard.pu241 * ItemHazard.ingot).toItem().setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_pu_mix = new ItemHazard(ItemHazard.purg * ItemHazard.ingot, "ingot_pu_mix").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_am241 = new ItemHazard("ingot_am241").addRadiation(ItemHazard.am241 * ItemHazard.ingot).toItem().setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_am242 = new ItemHazard("ingot_am242").addRadiation(ItemHazard.am242 * ItemHazard.ingot).toItem().setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_am_mix = new ItemHazard("ingot_am_mix").addRadiation(ItemHazard.amrg * ItemHazard.ingot).toItem().setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_schraranium = new ItemHazard(ItemHazard.sr, false, true, "ingot_schraranium").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_schrabidium = new ItemHazard(ItemHazard.sa326, false, true, "ingot_schrabidium").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_schrabidate = new ItemHazard(ItemHazard.sb, false, true, "ingot_schrabidate").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_solinium = new ItemHazard(ItemHazard.sa327, false, true, "ingot_solinium").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_thorium_fuel = new ItemHazard(ItemHazard.thf, "ingot_thorium_fuel").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_uranium_fuel = new ItemHazard(ItemHazard.uf, "ingot_uranium_fuel").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_mox_fuel = new ItemHazard(ItemHazard.mox, "ingot_mox_fuel").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_plutonium_fuel = new ItemHazard(ItemHazard.puf, "ingot_plutonium_fuel").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_neptunium_fuel = new ItemHazard(ItemHazard.npf, true, "ingot_neptunium_fuel").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_americium_fuel = new ItemHazard(ItemHazard.amf, "ingot_americium_fuel").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_les = new ItemHazard(ItemHazard.les, false, true, "ingot_les").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_schrabidium_fuel = new ItemHazard(ItemHazard.saf, false, true, "ingot_schrabidium_fuel").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_hes = new ItemHazard(ItemHazard.hes, false, true, "ingot_hes").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_neptunium = new ItemHazard(ItemHazard.np237, true, "ingot_neptunium").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_tennessine = new ItemHazard(120F, "ingot_tennessine").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_polonium = new ItemHazard(ItemHazard.po210, true, "ingot_polonium").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_phosphorus = new ItemHazard(0F, true, "ingot_phosphorus").setCreativeTab(ChudNTM.partsTab);
    public static final Item ingot_boron = new IngotItem(MaterialNTM.boron);
//    public static final Item ingot_graphite = new ItemFuel("ingot_graphite", 1600).setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_fiberglass = new ItemCustomLore("ingot_fiberglass").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_smore = new ItemFoodBase(10, 20F, false, "ingot_smore").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_niobium = new ItemCustomLore("ingot_niobium").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_actinium = new ItemCustomLore("ingot_actinium").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_neodymium = new ItemCustomLore("ingot_neodymium").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_bromine = new ItemCustomLore("ingot_bromine").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_caesium = new ItemHazard(0.0F, true, "ingot_caesium").addHydroReactivity().toItem().setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_cerium = new ItemCustomLore("ingot_cerium").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_lanthanium = new ItemCustomLore("ingot_lanthanium").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_tantalium = new ItemCustomLore("ingot_tantalium").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_astatine = new ItemCustomLore("ingot_astatine").setCreativeTab(ChudNTM.partsTab);
    public static final Item ingot_firebrick = new IngotItem(MaterialNTM.firebrick);
//    public static final Item ingot_cobalt = new ItemCustomLore("ingot_cobalt").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_co60 = new ItemHazard(ItemHazard.co60, "ingot_co60").addFire(5).toItem().setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_strontium = new ItemHazard("ingot_strontium").addHydroReactivity().toItem().setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_sr90 = new ItemHazard(ItemHazard.sr90, true, "ingot_sr90").addHydroReactivity().toItem().setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_iodine = new ItemCustomLore("ingot_iodine").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_i131 = new ItemHazard(ItemHazard.i131, "ingot_i131").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_au198 = new ItemHazard("ingot_au198").addRadiation(ItemHazard.au198 * ItemHazard.ingot).addFire(15).toItem().setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_pb209 = new ItemHazard(ItemHazard.pb209, true, true, "ingot_pb209").addToxic(2).toItem().setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_ra226 = new ItemHazard(ItemHazard.ra226, "ingot_ra226").addHydroReactivity().toItem().setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_ac227 = new ItemHazard(ItemHazard.ac227, "ingot_ac227").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_gh336 = new ItemHazard(ItemHazard.gh336, "ingot_gh336").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_radspice = new ItemHazard(ItemHazard.radspice, "ingot_radspice").addFire(15).addToxic(2).addBlinding().addHydroReactivity().toItem().setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_electronium = new ItemUnstable(30, 6000, "ingot_electronium").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_reiium = new ItemCustomLore("ingot_reiium").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_weidanium = new ItemCustomLore("ingot_weidanium").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_australium = new ItemCustomLore("ingot_australium").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_verticium = new ItemCustomLore("ingot_verticium").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_unobtainium = new ItemCustomLore("ingot_unobtainium").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_daffergon = new ItemCustomLore("ingot_daffergon").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_steel_dusted = new ItemHotDusted(200, "ingot_steel_dusted").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_chainsteel = new ItemHot(100, "ingot_chainsteel").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_meteorite = new ItemHot(200, "ingot_meteorite").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_meteorite_forged = new ItemHot(200, "ingot_meteorite_forged").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_semtex = new ItemLemon(4, 5, true, "ingot_semtex").setCreativeTab(ChudNTM.partsTab);
//    public static final Item ingot_c4 = new ItemFuel("ingot_c4", 1600).setCreativeTab(ChudNTM.partsTab);

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
