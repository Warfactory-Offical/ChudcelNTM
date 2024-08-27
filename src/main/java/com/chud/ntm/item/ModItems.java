package com.chud.ntm.item;

import com.chud.ntm.ChudNTM;
import com.chud.ntm.item.enums.EMaterial;
import com.chud.ntm.item.enums.EShape;
import com.chud.ntm.item.meta.MetaItem;
import com.chud.ntm.item.templates.*;
import com.chud.ntm.item.tool.*;

import com.chud.ntm.manager.CreativeTabsManager;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.enchantment.Enchantment.Rarity;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.*;

public class ModItems {

    private static final Map<String, Item> ALL_ITEMS = new LinkedHashMap<>();

    public static void preInit() {
        populate();
        generateMetaItems();
        register();
    }

    public static Item get(String name) {
        return ALL_ITEMS.get(name);
    }

    private static void populate() {
        // items

        ALL_ITEMS.put("redstone_sword", new RedstoneSwordItem());
        ALL_ITEMS.put("antiknock", new CustomItem("antiknock", CreativeTabsManager.controlTab));
        ALL_ITEMS.put("part_beryllium", new CustomItem("part_beryllium", CreativeTabsManager.controlTab));
        ALL_ITEMS.put("part_copper", new CustomItem("part_copper", CreativeTabsManager.controlTab));
        ALL_ITEMS.put("redstone_depleted", new CustomItem("redstone_depleted", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("sulfur", new CustomItem("sulfur", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("niter", new CustomItem("niter", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("fluorite", new CustomItem("fluorite", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("scrap", new CustomItem("scrap", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("scrap_oil", new CustomItem("scrap_oil", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("dust", new CustomItem("dust", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("rod_empty", new CustomItem("rod_empty", CreativeTabsManager.controlTab));
        ALL_ITEMS.put("rod_dual_empty", new CustomItem("rod_dual_empty", CreativeTabsManager.controlTab));
        ALL_ITEMS.put("rod_quad_empty", new CustomItem("rod_quad_empty", CreativeTabsManager.controlTab));
        ALL_ITEMS.put("chlorine_pinwheel", new CustomItem("chlorine_pinwheel", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("ring_starmetal", new CustomItem("ring_starmetal", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("flywheel_beryllium", new CustomItem("flywheel_beryllium", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("component_limiter", new CustomItem("component_limiter", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("component_emitter", new CustomItem("component_emitter", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("ball_fireclay", new CustomItem("ball_fireclay", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("piston_pneumatic", new CustomItem("piston_pneumatic", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("piston_hydraulic", new CustomItem("piston_hydraulic", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("piston_electro", new CustomItem("piston_electro", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("neutron_reflector", new CustomItem("neutron_reflector", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("rtg_unit", new CustomItem("rtg_unit", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("thermo_unit_empty", new CustomItem("thermo_unit_empty", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("levitation_unit", new CustomItem("levitation_unit", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("pellet_buckshot", new CustomItem("pellet_buckshot", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("pellet_flechette", new CustomItem("pellet_flechette", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("pellet_chlorophyte", new CustomItem("pellet_chlorophyte", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("pellet_meteorite", new CustomItem("pellet_meteorite", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("pellet_canister", new CustomItem("pellet_canister", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("pellet_claws", new CustomItem("pellet_claws", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("cinnebar", new CustomItem("cinnebar", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("toothpicks", new CustomItem("toothpicks", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("ducttape", new CustomItem("ducttape", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("catalyst_clay", new CustomItem("catalyst_clay", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("motor", new CustomItem("motor", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("motor_desh", new CustomItem("motor_desh", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("photo_panel", new CustomItem("photo_panel", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("sat_base", new CustomItem("sat_base", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("thruster_nuclear", new CustomItem("thruster_nuclear", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("blade_titanium", new CustomItem("blade_titanium", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("turbine_titanium", new CustomItem("turbine_titanium", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("blade_tungsten", new CustomItem("blade_tungsten", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("turbine_tungsten", new CustomItem("turbine_tungsten", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("bolt_tungsten", new CustomItem("bolt_tungsten", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("board_copper", new CustomItem("board_copper", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("bolt_dura_steel", new CustomItem("bolt_dura_steel", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("pipes_steel", new CustomItem("pipes_steel", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("drill_titanium", new CustomItem("drill_titanium", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("bolt_compound", new CustomItem("bolt_compound", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("hazmat_cloth", new CustomItem("hazmat_cloth", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("hazmat_cloth_red", new CustomItem("hazmat_cloth_red", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("hazmat_cloth_grey", new CustomItem("hazmat_cloth_grey", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("asbestos_cloth", new CustomItem("asbestos_cloth", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("rag_damp", new CustomItem("rag_damp", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("rag_piss", new CustomItem("rag_piss", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("filter_coal", new CustomItem("filter_coal", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("magnet_circular", new CustomItem("magnet_circular", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("centrifuge_element", new CustomItem("centrifuge_element", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("reactor_core", new CustomItem("reactor_core", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("oil_tar", new CustomItem("oil_tar", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("rare_earth_chunk", new CustomItem("rare_earth_chunk", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("fragment_neodymium", new CustomItem("fragment_neodymium", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("fragment_cobalt", new CustomItem("fragment_cobalt", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("fragment_niobium", new CustomItem("fragment_niobium", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("fragment_cerium", new CustomItem("fragment_cerium", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("fragment_lanthanium", new CustomItem("fragment_lanthanium", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("fragment_actinium", new CustomItem("fragment_actinium", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("fragment_meteorite", new CustomItem("fragment_meteorite", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("fragment_boron", new CustomItem("fragment_boron", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("fragment_coltan", new CustomItem("fragment_coltan", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("bottle_empty", new CustomItem("bottle_empty", CreativeTabsManager.consumableTab));
        ALL_ITEMS.put("bottle2_empty", new CustomItem("bottle2_empty", CreativeTabsManager.consumableTab));
        ALL_ITEMS.put("cap_nuka", new CustomItem("cap_nuka", CreativeTabsManager.consumableTab));
        ALL_ITEMS.put("cap_quantum", new CustomItem("cap_quantum", CreativeTabsManager.consumableTab));
        ALL_ITEMS.put("cap_sparkle", new CustomItem("cap_sparkle", CreativeTabsManager.consumableTab));
        ALL_ITEMS.put("cap_rad", new CustomItem("cap_rad", CreativeTabsManager.consumableTab));
        ALL_ITEMS.put("cap_korl", new CustomItem("cap_korl", CreativeTabsManager.consumableTab));
        ALL_ITEMS.put("cap_fritz", new CustomItem("cap_fritz", CreativeTabsManager.consumableTab));
        ALL_ITEMS.put("cap_sunset", new CustomItem("cap_sunset", CreativeTabsManager.consumableTab));
        ALL_ITEMS.put("cap_star", new CustomItem("cap_star", CreativeTabsManager.consumableTab));
        ALL_ITEMS.put("ring_pull", new CustomItem("ring_pull", CreativeTabsManager.consumableTab));
        ALL_ITEMS.put("can_key", new CustomItem("can_key", CreativeTabsManager.consumableTab));
        ALL_ITEMS.put("can_empty", new CustomItem("can_empty", CreativeTabsManager.consumableTab));
        ALL_ITEMS.put("crystal_iron", new CustomItem("crystal_iron", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("crystal_gold", new CustomItem("crystal_gold", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("crystal_redstone", new CustomItem("crystal_redstone", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("crystal_lapis", new CustomItem("crystal_lapis", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("crystal_diamond", new CustomItem("crystal_diamond", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("crystal_titanium", new CustomItem("crystal_titanium", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("crystal_sulfur", new CustomItem("crystal_sulfur", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("crystal_niter", new CustomItem("crystal_niter", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("crystal_copper", new CustomItem("crystal_copper", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("crystal_tungsten", new CustomItem("crystal_tungsten", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("crystal_aluminium", new CustomItem("crystal_aluminium", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("crystal_fluorite", new CustomItem("crystal_fluorite", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("crystal_beryllium", new CustomItem("crystal_beryllium", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("crystal_rare", new CustomItem("crystal_rare", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("crystal_cinnebar", new CustomItem("crystal_cinnebar", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("crystal_cobalt", new CustomItem("crystal_cobalt", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("crystal_starmetal", new CustomItem("crystal_starmetal", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("deuterium_filter", new CustomItem("deuterium_filter", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("circuit_raw", new CustomItem("circuit_raw", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("circuit_aluminium", new CustomItem("circuit_aluminium", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("circuit_copper", new CustomItem("circuit_copper", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("circuit_red_copper", new CustomItem("circuit_red_copper", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("circuit_gold", new CustomItem("circuit_gold", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("circuit_bismuth_raw", new CustomItem("circuit_bismuth_raw", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("circuit_arsenic_raw", new CustomItem("circuit_arsenic_raw", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("circuit_tantalium_raw", new CustomItem("circuit_tantalium_raw", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("circuit_targeting_tier1", new CustomItem("circuit_targeting_tier1", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("circuit_targeting_tier2", new CustomItem("circuit_targeting_tier2", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("circuit_targeting_tier3", new CustomItem("circuit_targeting_tier3", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("circuit_targeting_tier4", new CustomItem("circuit_targeting_tier4", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("circuit_targeting_tier5", new CustomItem("circuit_targeting_tier5", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("circuit_targeting_tier6", new CustomItem("circuit_targeting_tier6", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("mechanism_revolver_1", new CustomItem("mechanism_revolver_1", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("mechanism_revolver_2", new CustomItem("mechanism_revolver_2", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("mechanism_rifle_1", new CustomItem("mechanism_rifle_1", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("mechanism_rifle_2", new CustomItem("mechanism_rifle_2", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("mechanism_launcher_1", new CustomItem("mechanism_launcher_1", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("mechanism_launcher_2", new CustomItem("mechanism_launcher_2", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("mechanism_special", new CustomItem("mechanism_special", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("primer_357", new CustomItem("primer_357", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("primer_44", new CustomItem("primer_44", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("primer_9", new CustomItem("primer_9", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("primer_50", new CustomItem("primer_50", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("primer_buckshot", new CustomItem("primer_buckshot", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("casing_357", new CustomItem("casing_357", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("casing_44", new CustomItem("casing_44", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("casing_9", new CustomItem("casing_9", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("casing_50", new CustomItem("casing_50", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("casing_buckshot", new CustomItem("casing_buckshot", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("coil_advanced_alloy", new CustomItem("coil_advanced_alloy", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("coil_advanced_torus", new CustomItem("coil_advanced_torus", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("coil_gold", new CustomItem("coil_gold", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("coil_gold_torus", new CustomItem("coil_gold_torus", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("coil_tungsten", new CustomItem("coil_tungsten", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("coil_copper", new CustomItem("coil_copper", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("coil_copper_torus", new CustomItem("coil_copper_torus", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("assembly_iron", new CustomItem("assembly_iron", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("assembly_steel", new CustomItem("assembly_steel", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("assembly_gold", new CustomItem("assembly_gold", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("assembly_schrabidium", new CustomItem("assembly_schrabidium", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("assembly_nightmare", new CustomItem("assembly_nightmare", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("assembly_desh", new CustomItem("assembly_desh", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("assembly_nopip", new CustomItem("assembly_nopip", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("assembly_smg", new CustomItem("assembly_smg", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("assembly_556", new CustomItem("assembly_556", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("assembly_uzi", new CustomItem("assembly_uzi", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("assembly_actionexpress", new CustomItem("assembly_actionexpress", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("assembly_calamity", new CustomItem("assembly_calamity", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("assembly_lacunae", new CustomItem("assembly_lacunae", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("assembly_nuke", new CustomItem("assembly_nuke", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("gun_revolver_iron_ammo", new CustomItem("gun_revolver_iron_ammo", CreativeTabsManager.weaponTab));
        ALL_ITEMS.put("gun_revolver_ammo", new CustomItem("gun_revolver_ammo", CreativeTabsManager.weaponTab));
        ALL_ITEMS.put("gun_revolver_gold_ammo", new CustomItem("gun_revolver_gold_ammo", CreativeTabsManager.weaponTab));
        ALL_ITEMS.put("gun_spark_ammo", new CustomItem("gun_spark_ammo", CreativeTabsManager.weaponTab));
        ALL_ITEMS.put("gun_euthanasia_ammo", new CustomItem("gun_euthanasia_ammo", CreativeTabsManager.weaponTab));
        ALL_ITEMS.put("gun_bf_ammo", new CustomItem("gun_bf_ammo", CreativeTabsManager.weaponTab));
        ALL_ITEMS.put("gun_stinger_ammo", new CustomItem("gun_stinger_ammo", CreativeTabsManager.weaponTab));
        ALL_ITEMS.put("gun_hp_ammo", new CustomItem("gun_hp_ammo", CreativeTabsManager.weaponTab));
        ALL_ITEMS.put("gun_defabricator_ammo", new CustomItem("gun_defabricator_ammo", CreativeTabsManager.weaponTab));
        ALL_ITEMS.put("gun_cryolator_ammo", new CustomItem("gun_cryolator_ammo", CreativeTabsManager.weaponTab));
        ALL_ITEMS.put("gun_jack_ammo", new CustomItem("gun_jack_ammo", CreativeTabsManager.weaponTab));
        ALL_ITEMS.put("gun_immolator_ammo", new CustomItem("gun_immolator_ammo", CreativeTabsManager.weaponTab));
        ALL_ITEMS.put("gun_osipr_ammo", new CustomItem("gun_osipr_ammo", CreativeTabsManager.weaponTab));
        ALL_ITEMS.put("gun_osipr_ammo2", new CustomItem("gun_osipr_ammo2", CreativeTabsManager.weaponTab));
        ALL_ITEMS.put("gun_emp_ammo", new CustomItem("gun_emp_ammo", CreativeTabsManager.weaponTab));
        ALL_ITEMS.put("folly_shell", new CustomItem("folly_shell", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("folly_bullet", new CustomItem("folly_bullet", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("folly_bullet_nuclear", new CustomItem("folly_bullet_nuclear", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("folly_bullet_du", new CustomItem("folly_bullet_du", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("particle_empty", new CustomItem("particle_empty", CreativeTabsManager.controlTab));
        ALL_ITEMS.put("capsule_empty", new CustomItem("capsule_empty", CreativeTabsManager.controlTab));
        ALL_ITEMS.put("gadget_explosive", new CustomItem("gadget_explosive", CreativeTabsManager.nukeTab));
        ALL_ITEMS.put("man_explosive", new CustomItem("man_explosive", CreativeTabsManager.nukeTab));
        ALL_ITEMS.put("warhead_generic_small", new CustomItem("warhead_generic_small", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("warhead_incendiary_small", new CustomItem("warhead_incendiary_small", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("warhead_cluster_small", new CustomItem("warhead_cluster_small", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("warhead_buster_small", new CustomItem("warhead_buster_small", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("warhead_generic_medium", new CustomItem("warhead_generic_medium", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("warhead_incendiary_medium", new CustomItem("warhead_incendiary_medium", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("warhead_cluster_medium", new CustomItem("warhead_cluster_medium", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("warhead_buster_medium", new CustomItem("warhead_buster_medium", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("warhead_generic_large", new CustomItem("warhead_generic_large", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("warhead_incendiary_large", new CustomItem("warhead_incendiary_large", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("warhead_cluster_large", new CustomItem("warhead_cluster_large", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("warhead_buster_large", new CustomItem("warhead_buster_large", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("warhead_n2", new CustomItem("warhead_n2", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("warhead_nuclear", new CustomItem("warhead_nuclear", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("warhead_mirvlet", new CustomItem("warhead_mirvlet", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("warhead_mirv", new CustomItem("warhead_mirv", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("warhead_volcano", new CustomItem("warhead_volcano", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("warhead_thermo_endo", new CustomItem("warhead_thermo_endo", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("warhead_thermo_exo", new CustomItem("warhead_thermo_exo", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("thruster_small", new CustomItem("thruster_small", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("thruster_medium", new CustomItem("thruster_medium", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("thruster_large", new CustomItem("thruster_large", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("cap_aluminium", new CustomItem("cap_aluminium", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("hull_small_steel", new CustomItem("hull_small_steel", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("hull_small_aluminium", new CustomItem("hull_small_aluminium", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("hull_big_steel", new CustomItem("hull_big_steel", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("hull_big_aluminium", new CustomItem("hull_big_aluminium", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("hull_big_titanium", new CustomItem("hull_big_titanium", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("fins_flat", new CustomItem("fins_flat", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("fins_small_steel", new CustomItem("fins_small_steel", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("fins_big_steel", new CustomItem("fins_big_steel", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("fins_tri_steel", new CustomItem("fins_tri_steel", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("fins_quad_titanium", new CustomItem("fins_quad_titanium", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("sphere_steel", new CustomItem("sphere_steel", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("pedestal_steel", new CustomItem("pedestal_steel", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("dysfunctional_reactor", new CustomItem("dysfunctional_reactor", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("rotor_steel", new CustomItem("rotor_steel", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("generator_steel", new CustomItem("generator_steel", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("sat_head_mapper", new CustomItem("sat_head_mapper", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("sat_head_scanner", new CustomItem("sat_head_scanner", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("sat_head_radar", new CustomItem("sat_head_radar", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("sat_head_laser", new CustomItem("sat_head_laser", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("sat_head_resonator", new CustomItem("sat_head_resonator", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("seg_10", new CustomItem("seg_10", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("seg_15", new CustomItem("seg_15", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("seg_20", new CustomItem("seg_20", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("fuel_tank_small", new CustomItem("fuel_tank_small", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("fuel_tank_medium", new CustomItem("fuel_tank_medium", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("fuel_tank_large", new CustomItem("fuel_tank_large", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("tank_steel", new CustomItem("tank_steel", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("chopper_head", new CustomItem("chopper_head", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("chopper_gun", new CustomItem("chopper_gun", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("chopper_torso", new CustomItem("chopper_torso", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("chopper_tail", new CustomItem("chopper_tail", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("chopper_wing", new CustomItem("chopper_wing", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("chopper_blades", new CustomItem("chopper_blades", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("combine_scrap", new CustomItem("combine_scrap", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("shimmer_head", new CustomItem("shimmer_head", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("shimmer_axe_head", new CustomItem("shimmer_axe_head", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("shimmer_handle", new CustomItem("shimmer_handle", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("telepad", new CustomItem("telepad", CreativeTabsManager.partsTab));
        ALL_ITEMS.put("ducc", new CustomItem("ducc", CreativeTabsManager.controlTab));
        ALL_ITEMS.put("syringe_empty", new CustomItem("syringe_empty", null).setFull3D().setCreativeTab(CreativeTabsManager.consumableTab));
        ALL_ITEMS.put("syringe_metal_empty", new CustomItem("syringe_metal_empty", null).setFull3D().setCreativeTab(CreativeTabsManager.consumableTab));
        ALL_ITEMS.put("arc_electrode_burnt", new CustomItem("arc_electrode_burnt", null).setMaxStackSize(1).setFull3D());
        ALL_ITEMS.put("piston_selenium", new CustomItem("piston_selenium", CreativeTabsManager.controlTab).setMaxStackSize(1));
        ALL_ITEMS.put("thermo_element", new CustomItem("thermo_element", null).setMaxStackSize(16).setCreativeTab(CreativeTabsManager.controlTab));
        ALL_ITEMS.put("fusion_core_infinite", new CustomItem("fusion_core_infinite", null).setMaxStackSize(1));
        ALL_ITEMS.put("rod_lead", new CustomItem("rod_lead", null).setMaxStackSize(1).setCreativeTab(CreativeTabsManager.controlTab).setContainerItem(get("rod_empty")));
        ALL_ITEMS.put("rod_dual_lead", new CustomItem("rod_dual_lead", null).setMaxStackSize(1).setCreativeTab(CreativeTabsManager.controlTab).setContainerItem(get("rod_dual_empty")));
        ALL_ITEMS.put("rod_quad_lead", new CustomItem("rod_quad_lead", null).setMaxStackSize(1).setCreativeTab(CreativeTabsManager.controlTab).setContainerItem(get("rod_quad_empty")));
        ALL_ITEMS.put("rod_cobalt", new CustomItem("rod_cobalt", null).setMaxStackSize(1).setCreativeTab(CreativeTabsManager.controlTab).setContainerItem(get("rod_empty")));
        ALL_ITEMS.put("rod_dual_cobalt", new CustomItem("rod_dual_cobalt", null).setMaxStackSize(1).setCreativeTab(CreativeTabsManager.controlTab).setContainerItem(get("rod_dual_empty")));
        ALL_ITEMS.put("rod_quad_cobalt", new CustomItem("rod_quad_cobalt", null).setMaxStackSize(1).setCreativeTab(CreativeTabsManager.controlTab).setContainerItem(get("rod_quad_empty")));
        ALL_ITEMS.put("magnet_dee", new CustomItem("magnet_dee", null));
        ALL_ITEMS.put("cyclotron_tower", new CustomItem("cyclotron_tower", null));
        ALL_ITEMS.put("centrifuge_tower", new CustomItem("centrifuge_tower", null));
        ALL_ITEMS.put("gun_revolver_nopip_ammo", new CustomItem("gun_revolver_nopip_ammo", null));
        ALL_ITEMS.put("gun_rpg_ammo", new CustomItem("gun_rpg_ammo", null));
        ALL_ITEMS.put("gun_dash_ammo", new CustomItem("gun_dash_ammo", null));
        ALL_ITEMS.put("gun_mp40_ammo", new CustomItem("gun_mp40_ammo", null));
        ALL_ITEMS.put("gun_uzi_ammo", new CustomItem("gun_uzi_ammo", null));
        ALL_ITEMS.put("gun_uboinik_ammo", new CustomItem("gun_uboinik_ammo", null));
        ALL_ITEMS.put("gun_lever_action_ammo", new CustomItem("gun_lever_action_ammo", null));
        ALL_ITEMS.put("gun_bolt_action_ammo", new CustomItem("gun_bolt_action_ammo", null));
        ALL_ITEMS.put("energy_ball", new CustomItem("energy_ball", null));
        ALL_ITEMS.put("rbmk_fuel_empty", new CustomItem("rbmk_fuel_empty", null).setMaxStackSize(1).setCreativeTab(CreativeTabsManager.controlTab));
        ALL_ITEMS.put("particle_hydrogen", new CustomItem("particle_hydrogen", CreativeTabsManager.controlTab).setContainerItem(get("particle_empty")));
        ALL_ITEMS.put("particle_copper", new CustomItem("particle_copper", CreativeTabsManager.controlTab).setContainerItem(get("particle_empty")));
        ALL_ITEMS.put("particle_lead", new CustomItem("particle_lead", CreativeTabsManager.controlTab).setContainerItem(get("particle_empty")));
        ALL_ITEMS.put("particle_aproton", new CustomItem("particle_aproton", CreativeTabsManager.controlTab).setContainerItem(get("particle_empty")));
        ALL_ITEMS.put("particle_aelectron", new CustomItem("particle_aelectron", CreativeTabsManager.controlTab).setContainerItem(get("particle_empty")));
        ALL_ITEMS.put("particle_muon", new CustomItem("particle_muon", CreativeTabsManager.controlTab).setContainerItem(get("particle_empty")));
        ALL_ITEMS.put("particle_amat", new CustomItem("particle_amat", CreativeTabsManager.controlTab).setContainerItem(get("particle_empty")));
        ALL_ITEMS.put("particle_aschrab", new CustomItem("particle_aschrab", CreativeTabsManager.controlTab).setContainerItem(get("particle_empty")));
        ALL_ITEMS.put("particle_higgs", new CustomItem("particle_higgs", CreativeTabsManager.controlTab).setContainerItem(get("particle_empty")));
        ALL_ITEMS.put("particle_tachyon", new CustomItem("particle_tachyon", CreativeTabsManager.controlTab).setContainerItem(get("particle_empty")));
        ALL_ITEMS.put("particle_dark", new CustomItem("particle_dark", CreativeTabsManager.controlTab).setContainerItem(get("particle_empty")));
        ALL_ITEMS.put("particle_strange", new CustomItem("particle_strange", CreativeTabsManager.controlTab).setContainerItem(get("particle_empty")));
        ALL_ITEMS.put("particle_sparkticle", new CustomItem("particle_sparkticle", CreativeTabsManager.controlTab).setContainerItem(get("particle_empty")));
        ALL_ITEMS.put("ams_catalyst_blank", new CustomItem("ams_catalyst_blank", CreativeTabsManager.controlTab).setMaxStackSize(1));
        ALL_ITEMS.put("missile_assembly", new CustomItem("missile_assembly", null).setMaxStackSize(1).setCreativeTab(CreativeTabsManager.partsTab));
        ALL_ITEMS.put("bob_metalworks", new CustomItem("bob_metalworks", null));
        ALL_ITEMS.put("bob_assembly", new CustomItem("bob_assembly", null));
        ALL_ITEMS.put("bob_chemistry", new CustomItem("bob_chemistry", null));
        ALL_ITEMS.put("bob_oil", new CustomItem("bob_oil", null));
        ALL_ITEMS.put("bob_nuclear", new CustomItem("bob_nuclear", null));
        ALL_ITEMS.put("digamma_see", new CustomItem("digamma_see", null));
        ALL_ITEMS.put("digamma_feel", new CustomItem("digamma_feel", null));
        ALL_ITEMS.put("digamma_know", new CustomItem("digamma_know", null));
        ALL_ITEMS.put("digamma_kauai_moho", new CustomItem("digamma_kauai_moho", null));
        ALL_ITEMS.put("digamma_up_on_top", new CustomItem("digamma_up_on_top", null));
        ALL_ITEMS.put("smoke1", new CustomItem("smoke1", null));
        ALL_ITEMS.put("smoke2", new CustomItem("smoke2", null));
        ALL_ITEMS.put("smoke3", new CustomItem("smoke3", null));
        ALL_ITEMS.put("smoke4", new CustomItem("smoke4", null));
        ALL_ITEMS.put("smoke5", new CustomItem("smoke5", null));
        ALL_ITEMS.put("smoke6", new CustomItem("smoke6", null));
        ALL_ITEMS.put("smoke7", new CustomItem("smoke7", null));
        ALL_ITEMS.put("smoke8", new CustomItem("smoke8", null));
        ALL_ITEMS.put("b_smoke1", new CustomItem("b_smoke1", null));
        ALL_ITEMS.put("b_smoke2", new CustomItem("b_smoke2", null));
        ALL_ITEMS.put("b_smoke3", new CustomItem("b_smoke3", null));
        ALL_ITEMS.put("b_smoke4", new CustomItem("b_smoke4", null));
        ALL_ITEMS.put("b_smoke5", new CustomItem("b_smoke5", null));
        ALL_ITEMS.put("b_smoke6", new CustomItem("b_smoke6", null));
        ALL_ITEMS.put("b_smoke7", new CustomItem("b_smoke7", null));
        ALL_ITEMS.put("b_smoke8", new CustomItem("b_smoke8", null));
        ALL_ITEMS.put("d_smoke1", new CustomItem("d_smoke1", null));
        ALL_ITEMS.put("d_smoke2", new CustomItem("d_smoke2", null));
        ALL_ITEMS.put("d_smoke3", new CustomItem("d_smoke3", null));
        ALL_ITEMS.put("d_smoke4", new CustomItem("d_smoke4", null));
        ALL_ITEMS.put("d_smoke5", new CustomItem("d_smoke5", null));
        ALL_ITEMS.put("d_smoke6", new CustomItem("d_smoke6", null));
        ALL_ITEMS.put("d_smoke7", new CustomItem("d_smoke7", null));
        ALL_ITEMS.put("d_smoke8", new CustomItem("d_smoke8", null));
        ALL_ITEMS.put("cloud1", new CustomItem("cloud1", null));
        ALL_ITEMS.put("cloud2", new CustomItem("cloud2", null));
        ALL_ITEMS.put("cloud3", new CustomItem("cloud3", null));
        ALL_ITEMS.put("cloud4", new CustomItem("cloud4", null));
        ALL_ITEMS.put("cloud5", new CustomItem("cloud5", null));
        ALL_ITEMS.put("cloud6", new CustomItem("cloud6", null));
        ALL_ITEMS.put("cloud7", new CustomItem("cloud7", null));
        ALL_ITEMS.put("cloud8", new CustomItem("cloud8", null));
        ALL_ITEMS.put("gasflame1", new CustomItem("gasflame1", null));
        ALL_ITEMS.put("gasflame2", new CustomItem("gasflame2", null));
        ALL_ITEMS.put("gasflame3", new CustomItem("gasflame3", null));
        ALL_ITEMS.put("gasflame4", new CustomItem("gasflame4", null));
        ALL_ITEMS.put("gasflame5", new CustomItem("gasflame5", null));
        ALL_ITEMS.put("gasflame6", new CustomItem("gasflame6", null));
        ALL_ITEMS.put("gasflame7", new CustomItem("gasflame7", null));
        ALL_ITEMS.put("gasflame8", new CustomItem("gasflame8", null));
        ALL_ITEMS.put("flame_1", new CustomItem("flame_1", null));
        ALL_ITEMS.put("flame_2", new CustomItem("flame_2", null));
        ALL_ITEMS.put("flame_3", new CustomItem("flame_3", null));
        ALL_ITEMS.put("flame_4", new CustomItem("flame_4", null));
        ALL_ITEMS.put("flame_5", new CustomItem("flame_5", null));
        ALL_ITEMS.put("flame_6", new CustomItem("flame_6", null));
        ALL_ITEMS.put("flame_7", new CustomItem("flame_7", null));
        ALL_ITEMS.put("flame_8", new CustomItem("flame_8", null));
        ALL_ITEMS.put("flame_9", new CustomItem("flame_9", null));
        ALL_ITEMS.put("flame_10", new CustomItem("flame_10", null));
        ALL_ITEMS.put("orange1", new CustomItem("orange1", null));
        ALL_ITEMS.put("orange2", new CustomItem("orange2", null));
        ALL_ITEMS.put("orange3", new CustomItem("orange3", null));
        ALL_ITEMS.put("orange4", new CustomItem("orange4", null));
        ALL_ITEMS.put("orange5", new CustomItem("orange5", null));
        ALL_ITEMS.put("orange6", new CustomItem("orange6", null));
        ALL_ITEMS.put("orange7", new CustomItem("orange7", null));
        ALL_ITEMS.put("orange8", new CustomItem("orange8", null));
        ALL_ITEMS.put("pc1", new CustomItem("pc1", null));
        ALL_ITEMS.put("pc2", new CustomItem("pc2", null));
        ALL_ITEMS.put("pc3", new CustomItem("pc3", null));
        ALL_ITEMS.put("pc4", new CustomItem("pc4", null));
        ALL_ITEMS.put("pc5", new CustomItem("pc5", null));
        ALL_ITEMS.put("pc6", new CustomItem("pc6", null));
        ALL_ITEMS.put("pc7", new CustomItem("pc7", null));
        ALL_ITEMS.put("pc8", new CustomItem("pc8", null));
        ALL_ITEMS.put("chlorine1", new CustomItem("chlorine1", null));
        ALL_ITEMS.put("chlorine2", new CustomItem("chlorine2", null));
        ALL_ITEMS.put("chlorine3", new CustomItem("chlorine3", null));
        ALL_ITEMS.put("chlorine4", new CustomItem("chlorine4", null));
        ALL_ITEMS.put("chlorine5", new CustomItem("chlorine5", null));
        ALL_ITEMS.put("chlorine6", new CustomItem("chlorine6", null));
        ALL_ITEMS.put("chlorine7", new CustomItem("chlorine7", null));
        ALL_ITEMS.put("chlorine8", new CustomItem("chlorine8", null));
        ALL_ITEMS.put("ln2_1", new CustomItem("ln2_1", null));
        ALL_ITEMS.put("ln2_2", new CustomItem("ln2_2", null));
        ALL_ITEMS.put("ln2_3", new CustomItem("ln2_3", null));
        ALL_ITEMS.put("ln2_4", new CustomItem("ln2_4", null));
        ALL_ITEMS.put("ln2_5", new CustomItem("ln2_5", null));
        ALL_ITEMS.put("ln2_6", new CustomItem("ln2_6", null));
        ALL_ITEMS.put("ln2_7", new CustomItem("ln2_7", null));
        ALL_ITEMS.put("ln2_8", new CustomItem("ln2_8", null));
        ALL_ITEMS.put("ln2_9", new CustomItem("ln2_9", null));
        ALL_ITEMS.put("ln2_10", new CustomItem("ln2_10", null));
        ALL_ITEMS.put("gas1", new CustomItem("gas1", null));
        ALL_ITEMS.put("gas2", new CustomItem("gas2", null));
        ALL_ITEMS.put("gas3", new CustomItem("gas3", null));
        ALL_ITEMS.put("gas4", new CustomItem("gas4", null));
        ALL_ITEMS.put("gas5", new CustomItem("gas5", null));
        ALL_ITEMS.put("gas6", new CustomItem("gas6", null));
        ALL_ITEMS.put("gas7", new CustomItem("gas7", null));
        ALL_ITEMS.put("gas8", new CustomItem("gas8", null));
        ALL_ITEMS.put("spill1", new CustomItem("spill1", null));
        ALL_ITEMS.put("spill2", new CustomItem("spill2", null));
        ALL_ITEMS.put("spill3", new CustomItem("spill3", null));
        ALL_ITEMS.put("spill4", new CustomItem("spill4", null));
        ALL_ITEMS.put("spill5", new CustomItem("spill5", null));
        ALL_ITEMS.put("spill6", new CustomItem("spill6", null));
        ALL_ITEMS.put("spill7", new CustomItem("spill7", null));
        ALL_ITEMS.put("spill8", new CustomItem("spill8", null));
        ALL_ITEMS.put("nothing", new CustomItem("nothing", null));
        ALL_ITEMS.put("discharge", new CustomItem("discharge", null));

        // ammo

        ALL_ITEMS.put("ammo_357_desh", new AmmoItem("ammo_357_desh"));
        ALL_ITEMS.put("ammo_4gauge_canister", new AmmoItem("ammo_4gauge_canister"));
        ALL_ITEMS.put("ammo_4gauge_claw", new AmmoItem("ammo_4gauge_claw"));
        ALL_ITEMS.put("ammo_4gauge_vampire", new AmmoItem("ammo_4gauge_vampire"));
        ALL_ITEMS.put("ammo_4gauge_void", new AmmoItem("ammo_4gauge_void"));
        ALL_ITEMS.put("ammo_5mm_chlorophyte", new AmmoItem("ammo_5mm_chlorophyte"));
        ALL_ITEMS.put("ammo_9mm_chlorophyte", new AmmoItem("ammo_9mm_chlorophyte"));
        ALL_ITEMS.put("ammo_556_chlorophyte", new AmmoItem("ammo_556_chlorophyte"));
        ALL_ITEMS.put("ammo_556_flechette_chlorophyte", new AmmoItem("ammo_556_flechette_chlorophyte"));
        ALL_ITEMS.put("ammo_50ae_chlorophyte", new AmmoItem("ammo_50ae_chlorophyte"));
        ALL_ITEMS.put("ammo_50bmg_chlorophyte", new AmmoItem("ammo_50bmg_chlorophyte"));
        ALL_ITEMS.put("ammo_50bmg_flechette", new AmmoItem("ammo_50bmg_flechette"));
        ALL_ITEMS.put("ammo_50bmg_flechette_am", new AmmoItem("ammo_50bmg_flechette_am"));
        ALL_ITEMS.put("ammo_50bmg_flechette_po", new AmmoItem("ammo_50bmg_flechette_po"));
        ALL_ITEMS.put("ammo_44_chlorophyte", new AmmoItem("ammo_44_chlorophyte"));
        ALL_ITEMS.put("ammo_22lr_chlorophyte", new AmmoItem("ammo_22lr_chlorophyte"));
        ALL_ITEMS.put("ammo_rocket_canister", new AmmoItem("ammo_rocket_canister"));
        ALL_ITEMS.put("ammo_20gauge", new AmmoItem("ammo_20gauge"));
        ALL_ITEMS.put("ammo_20gauge_slug", new AmmoItem("ammo_20gauge_slug"));
        ALL_ITEMS.put("ammo_20gauge_flechette", new AmmoItem("ammo_20gauge_flechette"));
        ALL_ITEMS.put("ammo_20gauge_incendiary", new AmmoItem("ammo_20gauge_incendiary"));
        ALL_ITEMS.put("ammo_20gauge_explosive", new AmmoItem("ammo_20gauge_explosive"));
        ALL_ITEMS.put("ammo_20gauge_caustic", new AmmoItem("ammo_20gauge_caustic"));
        ALL_ITEMS.put("ammo_20gauge_shock", new AmmoItem("ammo_20gauge_shock"));
        ALL_ITEMS.put("ammo_20gauge_wither", new AmmoItem("ammo_20gauge_wither"));
        ALL_ITEMS.put("ammo_20gauge_sleek", new AmmoItem("ammo_20gauge_sleek"));
        ALL_ITEMS.put("ammo_20gauge_shrapnel", new AmmoItem("ammo_20gauge_shrapnel"));
        ALL_ITEMS.put("ammo_4gauge", new AmmoItem("ammo_4gauge"));
        ALL_ITEMS.put("ammo_4gauge_slug", new AmmoItem("ammo_4gauge_slug"));
        ALL_ITEMS.put("ammo_4gauge_flechette", new AmmoItem("ammo_4gauge_flechette"));
        ALL_ITEMS.put("ammo_4gauge_flechette_phosphorus", new AmmoItem("ammo_4gauge_flechette_phosphorus"));
        ALL_ITEMS.put("ammo_4gauge_explosive", new AmmoItem("ammo_4gauge_explosive"));
        ALL_ITEMS.put("ammo_4gauge_semtex", new AmmoItem("ammo_4gauge_semtex"));
        ALL_ITEMS.put("ammo_4gauge_balefire", new AmmoItem("ammo_4gauge_balefire"));
        ALL_ITEMS.put("ammo_4gauge_kampf", new AmmoItem("ammo_4gauge_kampf"));
        ALL_ITEMS.put("ammo_4gauge_sleek", new AmmoItem("ammo_4gauge_sleek"));
        ALL_ITEMS.put("ammo_rocket", new AmmoItem("ammo_rocket"));
        ALL_ITEMS.put("ammo_rocket_he", new AmmoItem("ammo_rocket_he"));
        ALL_ITEMS.put("ammo_rocket_incendiary", new AmmoItem("ammo_rocket_incendiary"));
        ALL_ITEMS.put("ammo_rocket_phosphorus", new AmmoItem("ammo_rocket_phosphorus"));
        ALL_ITEMS.put("ammo_rocket_shrapnel", new AmmoItem("ammo_rocket_shrapnel"));
        ALL_ITEMS.put("ammo_rocket_emp", new AmmoItem("ammo_rocket_emp"));
        ALL_ITEMS.put("ammo_rocket_glare", new AmmoItem("ammo_rocket_glare"));
        ALL_ITEMS.put("ammo_rocket_toxic", new AmmoItem("ammo_rocket_toxic"));
        ALL_ITEMS.put("ammo_rocket_sleek", new AmmoItem("ammo_rocket_sleek"));
        ALL_ITEMS.put("ammo_rocket_nuclear", new AmmoItem("ammo_rocket_nuclear"));
        ALL_ITEMS.put("ammo_rocket_rpc", new AmmoItem("ammo_rocket_rpc"));
        ALL_ITEMS.put("ammo_grenade", new AmmoItem("ammo_grenade"));
        ALL_ITEMS.put("ammo_grenade_he", new AmmoItem("ammo_grenade_he"));
        ALL_ITEMS.put("ammo_grenade_incendiary", new AmmoItem("ammo_grenade_incendiary"));
        ALL_ITEMS.put("ammo_grenade_phosphorus", new AmmoItem("ammo_grenade_phosphorus"));
        ALL_ITEMS.put("ammo_grenade_toxic", new AmmoItem("ammo_grenade_toxic"));
        ALL_ITEMS.put("ammo_grenade_concussion", new AmmoItem("ammo_grenade_concussion"));
        ALL_ITEMS.put("ammo_grenade_finned", new AmmoItem("ammo_grenade_finned"));
        ALL_ITEMS.put("ammo_grenade_sleek", new AmmoItem("ammo_grenade_sleek"));
        ALL_ITEMS.put("ammo_grenade_nuclear", new AmmoItem("ammo_grenade_nuclear"));
        ALL_ITEMS.put("ammo_grenade_tracer", new AmmoItem("ammo_grenade_tracer"));
        ALL_ITEMS.put("ammo_grenade_kampf", new AmmoItem("ammo_grenade_kampf"));
        ALL_ITEMS.put("ammo_shell", new AmmoItem("ammo_shell"));
        ALL_ITEMS.put("ammo_shell_explosive", new AmmoItem("ammo_shell_explosive"));
        ALL_ITEMS.put("ammo_shell_apfsds_t", new AmmoItem("ammo_shell_apfsds_t"));
        ALL_ITEMS.put("ammo_shell_apfsds_du", new AmmoItem("ammo_shell_apfsds_du"));
        ALL_ITEMS.put("ammo_shell_w9", new AmmoItem("ammo_shell_w9"));
        ALL_ITEMS.put("ammo_dgk", new AmmoItem("ammo_dgk"));
        ALL_ITEMS.put("ammo_nuke", new AmmoItem("ammo_nuke"));
        ALL_ITEMS.put("ammo_nuke_low", new AmmoItem("ammo_nuke_low"));
        ALL_ITEMS.put("ammo_nuke_high", new AmmoItem("ammo_nuke_high"));
        ALL_ITEMS.put("ammo_nuke_tots", new AmmoItem("ammo_nuke_tots"));
        ALL_ITEMS.put("ammo_nuke_safe", new AmmoItem("ammo_nuke_safe"));
        ALL_ITEMS.put("ammo_nuke_pumpkin", new AmmoItem("ammo_nuke_pumpkin"));
        ALL_ITEMS.put("ammo_mirv", new AmmoItem("ammo_mirv"));
        ALL_ITEMS.put("ammo_mirv_low", new AmmoItem("ammo_mirv_low"));
        ALL_ITEMS.put("ammo_mirv_high", new AmmoItem("ammo_mirv_high"));
        ALL_ITEMS.put("ammo_mirv_safe", new AmmoItem("ammo_mirv_safe"));
        ALL_ITEMS.put("ammo_mirv_special", new AmmoItem("ammo_mirv_special"));
        ALL_ITEMS.put("ammo_fuel", new AmmoItem("ammo_fuel").setMaxStackSize(1));
        ALL_ITEMS.put("ammo_fuel_napalm", new AmmoItem("ammo_fuel_napalm").setMaxStackSize(1));
        ALL_ITEMS.put("ammo_fuel_phosphorus", new AmmoItem("ammo_fuel_phosphorus").setMaxStackSize(1));
        ALL_ITEMS.put("ammo_fuel_vaporizer", new AmmoItem("ammo_fuel_vaporizer").setMaxStackSize(1));
        ALL_ITEMS.put("ammo_fuel_gas", new AmmoItem("ammo_fuel_gas").setMaxStackSize(1));
        ALL_ITEMS.put("ammo_cell", new AmmoItem("ammo_cell").setMaxStackSize(16));
        ALL_ITEMS.put("ammo_dart", new AmmoItem("ammo_dart").setMaxStackSize(16));
        ALL_ITEMS.put("ammo_12gauge", new AmmoItem("ammo_12gauge"));
        ALL_ITEMS.put("ammo_12gauge_incendiary", new AmmoItem("ammo_12gauge_incendiary"));
        ALL_ITEMS.put("ammo_12gauge_shrapnel", new AmmoItem("ammo_12gauge_shrapnel"));
        ALL_ITEMS.put("ammo_12gauge_du", new AmmoItem("ammo_12gauge_du"));
        ALL_ITEMS.put("ammo_12gauge_sleek", new AmmoItem("ammo_12gauge_sleek"));
        ALL_ITEMS.put("ammo_12gauge_marauder", new AmmoItem("ammo_12gauge_marauder"));
        ALL_ITEMS.put("ammo_22lr", new AmmoItem("ammo_22lr"));
        ALL_ITEMS.put("ammo_22lr_ap", new AmmoItem("ammo_22lr_ap"));
        ALL_ITEMS.put("ammo_44", new AmmoItem("ammo_44"));
        ALL_ITEMS.put("ammo_44_ap", new AmmoItem("ammo_44_ap"));
        ALL_ITEMS.put("ammo_44_du", new AmmoItem("ammo_44_du"));
        ALL_ITEMS.put("ammo_44_phosphorus", new AmmoItem("ammo_44_phosphorus"));
        ALL_ITEMS.put("ammo_44_pip", new AmmoItem("ammo_44_pip"));
        ALL_ITEMS.put("ammo_44_bj", new AmmoItem("ammo_44_bj"));
        ALL_ITEMS.put("ammo_44_silver", new AmmoItem("ammo_44_silver"));
        ALL_ITEMS.put("ammo_44_rocket", new AmmoItem("ammo_44_rocket"));
        ALL_ITEMS.put("ammo_44_star", new AmmoItem("ammo_44_star"));
        ALL_ITEMS.put("ammo_9mm", new AmmoItem("ammo_9mm"));
        ALL_ITEMS.put("ammo_9mm_ap", new AmmoItem("ammo_9mm_ap"));
        ALL_ITEMS.put("ammo_9mm_du", new AmmoItem("ammo_9mm_du"));
        ALL_ITEMS.put("ammo_9mm_rocket", new AmmoItem("ammo_9mm_rocket"));
        ALL_ITEMS.put("ammo_556", new AmmoItem("ammo_556"));
        ALL_ITEMS.put("ammo_556_phosphorus", new AmmoItem("ammo_556_phosphorus"));
        ALL_ITEMS.put("ammo_556_ap", new AmmoItem("ammo_556_ap"));
        ALL_ITEMS.put("ammo_556_du", new AmmoItem("ammo_556_du"));
        ALL_ITEMS.put("ammo_556_star", new AmmoItem("ammo_556_star"));
        ALL_ITEMS.put("ammo_556_sleek", new AmmoItem("ammo_556_sleek"));
        ALL_ITEMS.put("ammo_556_tracer", new AmmoItem("ammo_556_tracer"));
        ALL_ITEMS.put("ammo_556_flechette", new AmmoItem("ammo_556_flechette"));
        ALL_ITEMS.put("ammo_556_flechette_incendiary", new AmmoItem("ammo_556_flechette_incendiary"));
        ALL_ITEMS.put("ammo_556_flechette_phosphorus", new AmmoItem("ammo_556_flechette_phosphorus"));
        ALL_ITEMS.put("ammo_556_flechette_du", new AmmoItem("ammo_556_flechette_du"));
        ALL_ITEMS.put("ammo_556_flechette_sleek", new AmmoItem("ammo_556_flechette_sleek"));
        ALL_ITEMS.put("ammo_556_k", new AmmoItem("ammo_556_k"));
        ALL_ITEMS.put("ammo_50bmg", new AmmoItem("ammo_50bmg"));
        ALL_ITEMS.put("ammo_50bmg_incendiary", new AmmoItem("ammo_50bmg_incendiary"));
        ALL_ITEMS.put("ammo_50bmg_phosphorus", new AmmoItem("ammo_50bmg_phosphorus"));
        ALL_ITEMS.put("ammo_50bmg_explosive", new AmmoItem("ammo_50bmg_explosive"));
        ALL_ITEMS.put("ammo_50bmg_du", new AmmoItem("ammo_50bmg_du"));
        ALL_ITEMS.put("ammo_50bmg_star", new AmmoItem("ammo_50bmg_star"));
        ALL_ITEMS.put("ammo_50bmg_sleek", new AmmoItem("ammo_50bmg_sleek"));
        ALL_ITEMS.put("ammo_75bolt", new AmmoItem("ammo_75bolt").setMaxStackSize(8));
        ALL_ITEMS.put("ammo_75bolt_incendiary", new AmmoItem("ammo_75bolt_incendiary").setMaxStackSize(8));
        ALL_ITEMS.put("ammo_75bolt_he", new AmmoItem("ammo_75bolt_he").setMaxStackSize(8));
        ALL_ITEMS.put("ammo_50bmg_ap", new AmmoItem("ammo_50bmg_ap"));
        ALL_ITEMS.put("ammo_5mm", new AmmoItem("ammo_5mm"));
        ALL_ITEMS.put("ammo_5mm_explosive", new AmmoItem("ammo_5mm_explosive"));
        ALL_ITEMS.put("ammo_5mm_du", new AmmoItem("ammo_5mm_du"));
        ALL_ITEMS.put("ammo_5mm_star", new AmmoItem("ammo_5mm_star"));
        ALL_ITEMS.put("ammo_50ae", new AmmoItem("ammo_50ae"));
        ALL_ITEMS.put("ammo_50ae_ap", new AmmoItem("ammo_50ae_ap"));
        ALL_ITEMS.put("ammo_50ae_du", new AmmoItem("ammo_50ae_du"));
        ALL_ITEMS.put("ammo_50ae_star", new AmmoItem("ammo_50ae_star"));
        ALL_ITEMS.put("ammo_folly", new AmmoItem("ammo_folly"));
        ALL_ITEMS.put("ammo_folly_nuclear", new AmmoItem("ammo_folly_nuclear"));
        ALL_ITEMS.put("ammo_folly_du", new AmmoItem("ammo_folly_du"));

        // Items with custom lore

        ALL_ITEMS.put("reacher", new CustomItem("reacher").setMaxStackSize(1).setFull3D().setCreativeTab(CreativeTabsManager.consumableTab));
        ALL_ITEMS.put("fuse", new CustomItem("fuse").setMaxStackSize(16).setCreativeTab(CreativeTabsManager.controlTab));
        ALL_ITEMS.put("euphemium_capacitor", new CustomItem("euphemium_capacitor").setMaxStackSize(1).setCreativeTab(CreativeTabsManager.controlTab));
        ALL_ITEMS.put("arc_electrode", new CustomItem("arc_electrode").setMaxDamage(250).setCreativeTab(CreativeTabsManager.controlTab).setMaxStackSize(1).setCreativeTab(CreativeTabsManager.controlTab).setFull3D());
        ALL_ITEMS.put("arc_electrode_desh", new CustomItem("arc_electrode_desh").setMaxStackSize(1).setCreativeTab(CreativeTabsManager.controlTab).setFull3D());
        ALL_ITEMS.put("overfuse", new CustomItem("overfuse").setMaxStackSize(1).setFull3D());
        ALL_ITEMS.put("factory_core_titanium", new CustomItem("factory_core_titanium").setMaxStackSize(1));
        ALL_ITEMS.put("factory_core_advanced", new CustomItem("factory_core_advanced").setMaxStackSize(1));
        ALL_ITEMS.put("canister_napalm", new CustomItem("canister_napalm").setCreativeTab(CreativeTabsManager.controlTab));
        ALL_ITEMS.put("igniter", new CustomItem("igniter").setMaxStackSize(1).setFull3D().setCreativeTab(CreativeTabsManager.nukeTab));
        ALL_ITEMS.put("gun_super_shotgun", new CustomItem("gun_super_shotgun").setMaxStackSize(1).setFull3D().setCreativeTab(CreativeTabsManager.weaponTab));
        ALL_ITEMS.put("tritium_deuterium_cake", new CustomItem("tritium_deuterium_cake").setCreativeTab(CreativeTabsManager.controlTab).setMaxStackSize(1));
        ALL_ITEMS.put("rod_water", new CustomItem("rod_water").setMaxStackSize(1).setCreativeTab(CreativeTabsManager.controlTab).setContainerItem(get("rod_empty")));
        ALL_ITEMS.put("rod_dual_water", new CustomItem("rod_dual_water").setMaxStackSize(1).setCreativeTab(CreativeTabsManager.controlTab).setContainerItem(get("rod_dual_empty")));
        ALL_ITEMS.put("rod_quad_water", new CustomItem("rod_quad_water").setMaxStackSize(1).setCreativeTab(CreativeTabsManager.controlTab).setContainerItem(get("rod_quad_empty")));
        ALL_ITEMS.put("rod_lithium", new CustomItem("rod_lithium").setMaxStackSize(1).setCreativeTab(CreativeTabsManager.controlTab).setContainerItem(get("rod_empty")));
        ALL_ITEMS.put("rod_dual_lithium", new CustomItem("rod_dual_lithium").setMaxStackSize(1).setCreativeTab(CreativeTabsManager.controlTab).setContainerItem(get("rod_dual_empty")));
        ALL_ITEMS.put("rod_quad_lithium", new CustomItem("rod_quad_lithium").setMaxStackSize(1).setCreativeTab(CreativeTabsManager.controlTab).setContainerItem(get("rod_quad_empty")));
        ALL_ITEMS.put("rod_quad_euphemium", new CustomItem("rod_quad_euphemium").setCreativeTab(CreativeTabsManager.controlTab).setMaxStackSize(1).setContainerItem(get("rod_quad_empty")));
        ALL_ITEMS.put("rod_euphemium", new CustomItem("rod_euphemium").setMaxStackSize(1).setCreativeTab(CreativeTabsManager.controlTab).setContainerItem(get("rod_empty")));
        ALL_ITEMS.put("rod_reiium", new CustomItem("rod_reiium").setMaxStackSize(1).setCreativeTab(CreativeTabsManager.controlTab).setContainerItem(get("rod_empty")));
        ALL_ITEMS.put("rod_weidanium", new CustomItem("rod_weidanium").setMaxStackSize(1).setCreativeTab(CreativeTabsManager.controlTab).setContainerItem(get("rod_empty")));
        ALL_ITEMS.put("rod_australium", new CustomItem("rod_australium").setMaxStackSize(1).setCreativeTab(CreativeTabsManager.controlTab).setContainerItem(get("rod_empty")));
        ALL_ITEMS.put("rod_verticium", new CustomItem("rod_verticium").setMaxStackSize(1).setCreativeTab(CreativeTabsManager.controlTab).setContainerItem(get("rod_empty")));
        ALL_ITEMS.put("rod_unobtainium", new CustomItem("rod_unobtainium").setMaxStackSize(1).setCreativeTab(CreativeTabsManager.controlTab).setContainerItem(get("rod_empty")));
        ALL_ITEMS.put("rod_daffergon", new CustomItem("rod_daffergon").setMaxStackSize(1).setCreativeTab(CreativeTabsManager.controlTab).setContainerItem(get("rod_empty")));
        ALL_ITEMS.put("magnetron", new CustomItem("magnetron").setCreativeTab(CreativeTabsManager.partsTab));
        ALL_ITEMS.put("pellet_cluster", new CustomItem("pellet_cluster").setCreativeTab(CreativeTabsManager.partsTab));
        ALL_ITEMS.put("pellet_gas", new CustomItem("pellet_gas").setCreativeTab(CreativeTabsManager.partsTab));
        ALL_ITEMS.put("coin_maskman", new CustomItem("coin_maskman").setRarity(Rarity.UNCOMMON).setCreativeTab(CreativeTabsManager.consumableTab));
        ALL_ITEMS.put("coin_creeper", new CustomItem("coin_creeper").setRarity(Rarity.UNCOMMON).setCreativeTab(CreativeTabsManager.consumableTab));
        ALL_ITEMS.put("coin_radiation", new CustomItem("coin_radiation").setRarity(Rarity.UNCOMMON).setCreativeTab(CreativeTabsManager.consumableTab));
        ALL_ITEMS.put("coin_worm", new CustomItem("coin_worm").setRarity(Rarity.UNCOMMON).setCreativeTab(CreativeTabsManager.consumableTab));
        ALL_ITEMS.put("coin_ufo", new CustomItem("coin_ufo").setRarity(Rarity.UNCOMMON).setCreativeTab(CreativeTabsManager.consumableTab));
        ALL_ITEMS.put("gem_tantalium", new CustomItem("gem_tantalium").setCreativeTab(CreativeTabsManager.partsTab));
        ALL_ITEMS.put("gem_volcanic", new CustomItem("gem_volcanic").setRarity(Rarity.UNCOMMON).setCreativeTab(CreativeTabsManager.partsTab));
        ALL_ITEMS.put("upgrade_template", new CustomItem("upgrade_template").setMaxStackSize(1).setCreativeTab(CreativeTabsManager.partsTab));
        ALL_ITEMS.put("circuit_schrabidium", new CustomItem("circuit_schrabidium").setCreativeTab(CreativeTabsManager.partsTab));
        ALL_ITEMS.put("circuit_bismuth", new CustomItem("circuit_bismuth").setRarity(Rarity.UNCOMMON).setCreativeTab(CreativeTabsManager.partsTab));
        ALL_ITEMS.put("circuit_arsenic", new CustomItem("circuit_arsenic").setRarity(Rarity.UNCOMMON).setCreativeTab(CreativeTabsManager.partsTab));
        ALL_ITEMS.put("circuit_tantalium", new CustomItem("circuit_tantalium").setRarity(Rarity.UNCOMMON).setCreativeTab(CreativeTabsManager.partsTab));
        ALL_ITEMS.put("gun_revolver_nightmare_ammo", new CustomItem("gun_revolver_nightmare_ammo").setCreativeTab(CreativeTabsManager.weaponTab));
        ALL_ITEMS.put("gun_revolver_nightmare2_ammo", new CustomItem("gun_revolver_nightmare2_ammo").setCreativeTab(CreativeTabsManager.weaponTab));
        ALL_ITEMS.put("gun_revolver_cursed_ammo", new CustomItem("gun_revolver_cursed_ammo").setCreativeTab(CreativeTabsManager.weaponTab));
        ALL_ITEMS.put("gun_revolver_pip_ammo", new CustomItem("gun_revolver_pip_ammo").setCreativeTab(null));
        ALL_ITEMS.put("ammo_566_gold", new CustomItem("gun_mp_ammo").setCreativeTab(CreativeTabsManager.weaponTab));
        ALL_ITEMS.put("gun_calamity_ammo", new CustomItem("gun_calamity_ammo").setCreativeTab(null));
        ALL_ITEMS.put("gun_lacunae_ammo", new CustomItem("gun_lacunae_ammo").setCreativeTab(null));
        ALL_ITEMS.put("charge_railgun", new CustomItem("charge_railgun").setMaxStackSize(1).setCreativeTab(CreativeTabsManager.weaponTab));
        ALL_ITEMS.put("rune_blank", new CustomItem("rune_blank").setCreativeTab(CreativeTabsManager.partsTab).setMaxStackSize(1));
        ALL_ITEMS.put("rune_isa", new CustomItem("rune_isa").setCreativeTab(CreativeTabsManager.partsTab).setMaxStackSize(1));
        ALL_ITEMS.put("rune_dagaz", new CustomItem("rune_dagaz").setCreativeTab(CreativeTabsManager.partsTab).setMaxStackSize(1));
        ALL_ITEMS.put("rune_hagalaz", new CustomItem("rune_hagalaz").setCreativeTab(CreativeTabsManager.partsTab).setMaxStackSize(1));
        ALL_ITEMS.put("rune_jera", new CustomItem("rune_jera").setCreativeTab(CreativeTabsManager.partsTab).setMaxStackSize(1));
        ALL_ITEMS.put("rune_thurisaz", new CustomItem("rune_thurisaz").setCreativeTab(CreativeTabsManager.partsTab).setMaxStackSize(1));
        ALL_ITEMS.put("crystal_energy", new CustomItem("crystal_energy").setCreativeTab(null).setMaxStackSize(1));
        ALL_ITEMS.put("key_red", new CustomItem("key_red").setMaxStackSize(1).setCreativeTab(CreativeTabsManager.consumableTab));
        ALL_ITEMS.put("pin", new CustomItem("pin").setMaxStackSize(8).setCreativeTab(CreativeTabsManager.consumableTab));
        ALL_ITEMS.put("mech_key", new CustomItem("mech_key").setMaxStackSize(1).setCreativeTab(CreativeTabsManager.consumableTab));
        ALL_ITEMS.put("ams_muzzle", new CustomItem("ams_muzzle").setMaxStackSize(1).setCreativeTab(CreativeTabsManager.controlTab));
        ALL_ITEMS.put("custom_tnt", new CustomItem("custom_tnt").setMaxStackSize(1).setCreativeTab(CreativeTabsManager.nukeTab));
        ALL_ITEMS.put("custom_nuke", new CustomItem("custom_nuke").setMaxStackSize(1).setCreativeTab(CreativeTabsManager.nukeTab));
        ALL_ITEMS.put("custom_hydro", new CustomItem("custom_hydro").setMaxStackSize(1).setCreativeTab(CreativeTabsManager.nukeTab));
        ALL_ITEMS.put("custom_amat", new CustomItem("custom_amat").setMaxStackSize(1).setCreativeTab(CreativeTabsManager.nukeTab));
        ALL_ITEMS.put("custom_dirty", new CustomItem("custom_dirty").setMaxStackSize(1).setCreativeTab(CreativeTabsManager.nukeTab));
        ALL_ITEMS.put("custom_schrab", new CustomItem("custom_schrab").setMaxStackSize(1).setCreativeTab(CreativeTabsManager.nukeTab));
        ALL_ITEMS.put("custom_sol", new CustomItem("custom_sol").setMaxStackSize(1).setCreativeTab(CreativeTabsManager.nukeTab));
        ALL_ITEMS.put("custom_euph", new CustomItem("custom_euph").setMaxStackSize(1).setCreativeTab(CreativeTabsManager.nukeTab));
        ALL_ITEMS.put("custom_fall", new CustomItem("custom_fall").setMaxStackSize(1).setCreativeTab(CreativeTabsManager.nukeTab));
        ALL_ITEMS.put("missile_soyuz_lander", new CustomItem("missile_soyuz_lander").setMaxStackSize(1).setCreativeTab(CreativeTabsManager.missileTab));
        ALL_ITEMS.put("missile_skin_camo", new CustomItem("missile_skin_camo").setMaxStackSize(1).setCreativeTab(CreativeTabsManager.missileTab));
        ALL_ITEMS.put("missile_skin_desert", new CustomItem("missile_skin_desert").setMaxStackSize(1).setCreativeTab(CreativeTabsManager.missileTab));
        ALL_ITEMS.put("missile_skin_flames", new CustomItem("missile_skin_flames").setMaxStackSize(1).setCreativeTab(CreativeTabsManager.missileTab));
        ALL_ITEMS.put("missile_skin_manly_pink", new CustomItem("missile_skin_manly_pink").setMaxStackSize(1).setCreativeTab(CreativeTabsManager.missileTab));
        ALL_ITEMS.put("missile_skin_orange_insulation", new CustomItem("missile_skin_orange_insulation").setMaxStackSize(1).setCreativeTab(CreativeTabsManager.missileTab));
        ALL_ITEMS.put("missile_skin_sleek", new CustomItem("missile_skin_sleek").setMaxStackSize(1).setCreativeTab(CreativeTabsManager.missileTab));
        ALL_ITEMS.put("missile_skin_soviet_glory", new CustomItem("missile_skin_soviet_glory").setMaxStackSize(1).setCreativeTab(CreativeTabsManager.missileTab));
        ALL_ITEMS.put("missile_skin_soviet_stank", new CustomItem("missile_skin_soviet_stank").setMaxStackSize(1).setCreativeTab(CreativeTabsManager.missileTab));
        ALL_ITEMS.put("missile_skin_metal", new CustomItem("missile_skin_metal").setMaxStackSize(1).setCreativeTab(CreativeTabsManager.missileTab));
        ALL_ITEMS.put("flame_pony", new CustomItem("flame_pony").setCreativeTab(CreativeTabsManager.partsTab));
        ALL_ITEMS.put("flame_conspiracy", new CustomItem("flame_conspiracy").setCreativeTab(CreativeTabsManager.partsTab));
        ALL_ITEMS.put("flame_politics", new CustomItem("flame_politics").setCreativeTab(CreativeTabsManager.partsTab));
        ALL_ITEMS.put("flame_opinion", new CustomItem("flame_opinion").setCreativeTab(CreativeTabsManager.partsTab));
        ALL_ITEMS.put("burnt_bark", new CustomItem("burnt_bark").setCreativeTab(CreativeTabsManager.consumableTab));
        ALL_ITEMS.put("book_secret", new CustomItem("book_secret").setCreativeTab(CreativeTabsManager.consumableTab));
        ALL_ITEMS.put("crystal_horn", new CustomItem("crystal_horn").setCreativeTab(CreativeTabsManager.partsTab));
        ALL_ITEMS.put("crystal_charred", new CustomItem("crystal_charred").setCreativeTab(CreativeTabsManager.partsTab));
        ALL_ITEMS.put("watch", new CustomItem("watch").setCreativeTab(CreativeTabsManager.consumableTab).setMaxStackSize(1));
        ALL_ITEMS.put("entanglement_kit", new CustomItem("entanglement_kit").setCreativeTab(CreativeTabsManager.partsTab));
        ALL_ITEMS.put("undefined", new CustomItem("undefined").setCreativeTab(CreativeTabsManager.partsTab));

    }

    private static void generateMetaItems() {

        ALL_ITEMS.put("ingot", new MetaItem(EShape.INGOT,
                EMaterial.steel,
                EMaterial.titanium,
                EMaterial.copper,
                EMaterial.red_copper,
                EMaterial.advanced_alloy,
                EMaterial.tungsten,
                EMaterial.aluminium,
                EMaterial.beryllium,
                EMaterial.lead,
                EMaterial.asbestos,
                EMaterial.magnetized_tungsten,
                EMaterial.combine_steel,
                EMaterial.dura_steel,
                EMaterial.technetium,
                EMaterial.tcalloy,
                EMaterial.cdalloy,
                EMaterial.polymer,
                EMaterial.bakelite,
                EMaterial.rubber,
                EMaterial.biorubber,
                EMaterial.desh,
                EMaterial.saturnite,
                EMaterial.ferrouranium,
                EMaterial.starmetal,
                EMaterial.osmiridium,
                EMaterial.euphemium,
                EMaterial.dineutronium,
                EMaterial.cadmium,
                EMaterial.bismuth,
                EMaterial.arsenic,
                EMaterial.zirconium,
                EMaterial.th232,
                EMaterial.uranium,
                EMaterial.u233,
                EMaterial.u235,
                EMaterial.u238,
                EMaterial.u238m2,
                EMaterial.plutonium,
                EMaterial.pu238,
                EMaterial.pu239,
                EMaterial.pu240,
                EMaterial.pu241,
                EMaterial.pu_mix,
                EMaterial.am241,
                EMaterial.am242,
                EMaterial.am_mix,
                EMaterial.schraranium,
                EMaterial.schrabidium,
                EMaterial.schrabidate,
                EMaterial.solinium,
                EMaterial.thorium_fuel,
                EMaterial.uranium_fuel,
                EMaterial.mox_fuel,
                EMaterial.plutonium_fuel,
                EMaterial.neptunium_fuel,
                EMaterial.americium_fuel,
                EMaterial.les,
                EMaterial.schrabidium_fuel,
                EMaterial.hes,
                EMaterial.neptunium,
                EMaterial.tennessine,
                EMaterial.polonium,
                EMaterial.phosphorus,
                EMaterial.boron,
                EMaterial.graphite,
                EMaterial.fiberglass,
                EMaterial.smore,
                EMaterial.niobium,
                EMaterial.actinium,
                EMaterial.neodymium,
                EMaterial.bromine,
                EMaterial.caesium,
                EMaterial.cerium,
                EMaterial.lanthanium,
                EMaterial.tantalium,
                EMaterial.astatine,
                EMaterial.firebrick,
                EMaterial.cobalt,
                EMaterial.co60,
                EMaterial.strontium,
                EMaterial.sr90,
                EMaterial.iodine,
                EMaterial.i131,
                EMaterial.au198,
                EMaterial.pb209,
                EMaterial.ra226,
                EMaterial.ac227,
                EMaterial.gh336,
                EMaterial.radspice,
                EMaterial.electronium,
                EMaterial.reiium,
                EMaterial.weidanium,
                EMaterial.australium,
                EMaterial.verticium,
                EMaterial.unobtainium,
                EMaterial.daffergon,
                EMaterial.steel_dusted,
                EMaterial.chainsteel,
                EMaterial.meteorite,
                EMaterial.meteorite_forged,
                EMaterial.semtex,
                EMaterial.c4
        ).setCreativeTab(CreativeTabsManager.partsTab));

        ALL_ITEMS.put("billet", new MetaItem(EShape.BILLET,
                EMaterial.th232,
                EMaterial.uranium,
                EMaterial.u233,
                EMaterial.u235,
                EMaterial.u238,
                EMaterial.plutonium,
                EMaterial.pu238,
                EMaterial.pu239,
                EMaterial.pu240,
                EMaterial.pu241,
                EMaterial.pu_mix,
                EMaterial.am241,
                EMaterial.am242,
                EMaterial.am_mix,
                EMaterial.neptunium,
                EMaterial.polonium,
                EMaterial.technetium,
                EMaterial.co60,
                EMaterial.sr90,
                EMaterial.au198,
                EMaterial.pb209,
                EMaterial.ra226,
                EMaterial.ac227,
                EMaterial.gh336,
                EMaterial.beryllium,
                EMaterial.bismuth,
                EMaterial.zirconium,
                EMaterial.zfb_bismuth,
                EMaterial.zfb_pu241,
                EMaterial.zfb_am_mix,
                EMaterial.schrabidium,
                EMaterial.solinium,
                EMaterial.thorium_fuel,
                EMaterial.uranium_fuel,
                EMaterial.mox_fuel,
                EMaterial.plutonium_fuel,
                EMaterial.neptunium_fuel,
                EMaterial.americium_fuel,
                EMaterial.les,
                EMaterial.schrabidium_fuel,
                EMaterial.hes,
                EMaterial.po210be,
                EMaterial.ra226be,
                EMaterial.pu238be,
                EMaterial.australium,
                EMaterial.australium_lesser,
                EMaterial.australium_greater,
                EMaterial.unobtainium,
                EMaterial.yharonite,
                EMaterial.balefire_gold,
                EMaterial.flashlead,
                EMaterial.nuclear_waste
        ).setCreativeTab(CreativeTabsManager.partsTab));

        ALL_ITEMS.put("nugget", new MetaItem(EShape.NUGGET,
                EMaterial.uranium,
                EMaterial.u233,
                EMaterial.u235,
                EMaterial.u238,
                EMaterial.u238m2,
                EMaterial.plutonium,
                EMaterial.pu238,
                EMaterial.pu239,
                EMaterial.pu240,
                EMaterial.th232,
                EMaterial.pu241,
                EMaterial.pu_mix,
                EMaterial.am241,
                EMaterial.am242,
                EMaterial.am_mix,
                EMaterial.technetium,
                EMaterial.neptunium,
                EMaterial.polonium,
                EMaterial.thorium_fuel,
                EMaterial.uranium_fuel,
                EMaterial.mox_fuel,
                EMaterial.plutonium_fuel,
                EMaterial.neptunium_fuel,
                EMaterial.americium_fuel,
                EMaterial.les,
                EMaterial.schrabidium_fuel,
                EMaterial.hes,
                EMaterial.lead,
                EMaterial.beryllium,
                EMaterial.cadmium,
                EMaterial.bismuth,
                EMaterial.arsenic,
                EMaterial.zirconium,
                EMaterial.tantalium,
                EMaterial.desh,
                EMaterial.osmiridium,
                EMaterial.schrabidium,
                EMaterial.solinium,
                EMaterial.euphemium,
                EMaterial.dineutronium,
                EMaterial.actinium,
                EMaterial.ac227,
                EMaterial.cobalt,
                EMaterial.co60,
                EMaterial.strontium,
                EMaterial.sr90,
                EMaterial.pb209,
                EMaterial.gh336,
                EMaterial.au198,
                EMaterial.ra226,
                EMaterial.radspice,
                EMaterial.reiium,
                EMaterial.weidanium,
                EMaterial.australium,
                EMaterial.australium_lesser,
                EMaterial.australium_greater,
                EMaterial.verticium,
                EMaterial.unobtainium,
                EMaterial.unobtainium_lesser,
                EMaterial.unobtainium_greater,
                EMaterial.daffergon,
                EMaterial.mercury
        ).setCreativeTab(CreativeTabsManager.partsTab));

        ALL_ITEMS.put("powder", new MetaItem(EShape.POWDER,
                EMaterial.iron,
                EMaterial.gold,
                EMaterial.diamond,
                EMaterial.emerald,
                EMaterial.lapis,
                EMaterial.titanium,
                EMaterial.tungsten,
                EMaterial.copper,
                EMaterial.beryllium,
                EMaterial.aluminium,
                EMaterial.lead,
                EMaterial.advanced_alloy,
                EMaterial.combine_steel,
                EMaterial.tcalloy,
                EMaterial.cdalloy,
                EMaterial.magnetized_tungsten,
                EMaterial.chlorophyte,
                EMaterial.red_copper,
                EMaterial.steel,
                EMaterial.lithium,
                EMaterial.quartz,
                EMaterial.borax,
                EMaterial.dura_steel,
                EMaterial.polymer,
                EMaterial.bakelite,
                EMaterial.lanthanium,
                EMaterial.actinium,
                EMaterial.boron,
                EMaterial.semtex_mix,
                EMaterial.desh,
                EMaterial.zirconium,
                EMaterial.lignite,
                EMaterial.asbestos,
                EMaterial.cadmium,
                EMaterial.bismuth,
                EMaterial.coal,
                EMaterial.yellowcake,
                EMaterial.thorium,
                EMaterial.uranium,
                EMaterial.plutonium,
                EMaterial.neptunium,
                EMaterial.polonium,
                EMaterial.schrabidium,
                EMaterial.schrabidate,
                EMaterial.euphemium,
                EMaterial.dineutronium,
                EMaterial.iodine,
                EMaterial.astatine,
                EMaterial.neodymium,
                EMaterial.caesium,
                EMaterial.reiium,
                EMaterial.weidanium,
                EMaterial.australium,
                EMaterial.verticium,
                EMaterial.unobtainium,
                EMaterial.daffergon,
                EMaterial.strontium,
                EMaterial.cobalt,
                EMaterial.bromine,
                EMaterial.niobium,
                EMaterial.tantalium,
                EMaterial.tennessine,
                EMaterial.cerium,
                EMaterial.ice,
                EMaterial.desh_mix,
                EMaterial.desh_ready,
                EMaterial.nitan_mix,
                EMaterial.spark_mix,
                EMaterial.fire,
                EMaterial.meteorite,
                EMaterial.tektite,
                EMaterial.paleogenite,
                EMaterial.impure_osmiridium,
                EMaterial.osmiridium,
                EMaterial.magic,
                EMaterial.cloud,
                EMaterial.balefire,
                EMaterial.coltan_ore,
                EMaterial.coltan,
                EMaterial.poison,
                EMaterial.thermite,
                EMaterial.power,
                EMaterial.co60,
                EMaterial.sr90,
                EMaterial.at209,
                EMaterial.pb209,
                EMaterial.i131,
                EMaterial.cs137,
                EMaterial.xe135,
                EMaterial.au198,
                EMaterial.ra226,
                EMaterial.ac227,
                EMaterial.radspice
        ).setCreativeTab(CreativeTabsManager.partsTab));

        ALL_ITEMS.put("powder_tiny", new MetaItem(EShape.POWDER_TINY,
                EMaterial.steel,
                EMaterial.lithium,
                EMaterial.lanthanium,
                EMaterial.actinium,
                EMaterial.boron,
                EMaterial.coal,
                EMaterial.iodine,
                EMaterial.neodymium,
                EMaterial.cobalt,
                EMaterial.niobium,
                EMaterial.cerium,
                EMaterial.meteorite,
                EMaterial.paleogenite,
                EMaterial.co60,
                EMaterial.sr90,
                EMaterial.at209,
                EMaterial.pb209,
                EMaterial.i131,
                EMaterial.cs137,
                EMaterial.xe135,
                EMaterial.au198,
                EMaterial.ac227,
                EMaterial.radspice
        ).setCreativeTab(CreativeTabsManager.partsTab));

        ALL_ITEMS.put("plate", new MetaItem(EShape.PLATE,
                EMaterial.iron,
                EMaterial.copper,
                EMaterial.titanium,
                EMaterial.aluminium,
                EMaterial.gold,
                EMaterial.lead,
                EMaterial.steel,
                EMaterial.advanced_alloy,
                EMaterial.combine_steel,
                EMaterial.paa,
                EMaterial.saturnite,
                EMaterial.schrabidium,
                EMaterial.dalekanium,
                EMaterial.mixed,
                EMaterial.kevlar,
                EMaterial.polymer,
                EMaterial.desh,
                EMaterial.euphemium,
                EMaterial.dineutronium,
                EMaterial.bismuth,
                EMaterial.dura_steel
        ).setCreativeTab(CreativeTabsManager.partsTab));

        ALL_ITEMS.put("wire", new MetaItem(EShape.WIRE,
                EMaterial.advanced_alloy,
                EMaterial.gold,
                EMaterial.red_copper,
                EMaterial.tungsten,
                EMaterial.aluminium,
                EMaterial.copper,
                EMaterial.schrabidium,
                EMaterial.magnetized_tungsten
        ).setCreativeTab(CreativeTabsManager.partsTab));

    }

    private static void registerItems(IForgeRegistry<Item> registry) {
        ALL_ITEMS.values().forEach(registry::register);
    }

    private static void registerModels() {
        ALL_ITEMS.values().forEach(item -> {
            if (item instanceof MetaItem metaItem) {
                metaItem.registerModels();
            } else {
                ModelLoader
                        .setCustomModelResourceLocation(item, 0,
                                new ModelResourceLocation(
                                        Objects.requireNonNull(item.getRegistryName()),
                                        "inventory"
                                )
                        );
            }
        });
    }

    private static void register() {
        registerItems(ForgeRegistries.ITEMS);
        registerModels();
    }


}
