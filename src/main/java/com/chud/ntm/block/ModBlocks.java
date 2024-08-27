package com.chud.ntm.block;

import com.chud.ntm.ChudNTM;
import com.chud.ntm.manager.CreativeTabsManager;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ModBlocks {

    private static final List<Block> ALL_BLOCKS = new ArrayList<>();

    static {
        Field[] fields = ModBlocks.class.getFields();

        for (Field field : fields) {
            if (field.getType() == Block.class) {
                field.setAccessible(true);
                try {
                    Block block = (Block) field.get(null);
                    ALL_BLOCKS.add(block);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void registerBlocks(IForgeRegistry<Block> registry) {
        ChudNTM.LOGGER.info("registerBlocks");
        ALL_BLOCKS.forEach(block -> {
            ChudNTM.LOGGER.info("block.getRegistryName(): {}", Objects.requireNonNull(block.getRegistryName()).getPath());
            registry.register(block);
        });
    }

    public static void registerBlockItems(IForgeRegistry<Item> registry) {
        ALL_BLOCKS.forEach(block -> {
            // TODO
        });
    }

    public static final Block fatduck = new BlockBase(Material.IRON, "fatduck");
    public static final Block crystal_hardened = new BlockBase(Material.IRON, "crystal_hardened").setHardness(15.0F).setResistance(Float.POSITIVE_INFINITY).setCreativeTab(null);
    public static final Block asphalt = new BlockBase(Material.ROCK, "asphalt").setCreativeTab(CreativeTabsManager.blockTab).setHardness(15.0F).setResistance(100.0F);
    public static final Block reinforced_stone = new BlockBase(Material.ROCK, "reinforced_stone").setCreativeTab(CreativeTabsManager.blockTab).setHardness(15.0F).setResistance(3000.0F);
    public static final Block brick_concrete_cracked = new BlockBase(Material.ROCK, "brick_concrete_cracked").setCreativeTab(CreativeTabsManager.blockTab).setHardness(15.0F).setResistance(2000.0F);
    public static final Block brick_concrete_broken = new BlockBase(Material.ROCK, "brick_concrete_broken").setCreativeTab(CreativeTabsManager.blockTab).setHardness(15.0F).setResistance(1500.0F);
    public static final Block brick_light = new BlockBase(Material.ROCK, "brick_light").setCreativeTab(CreativeTabsManager.blockTab).setLightOpacity(15).setHardness(15.0F).setResistance(1000.0F);
    public static final Block reinforced_sand = new BlockBase(Material.ROCK, "reinforced_sand").setCreativeTab(CreativeTabsManager.blockTab).setLightOpacity(15).setHardness(15.0F).setResistance(400.0F);
    public static final Block brick_obsidian = new BlockBase(Material.ROCK, "brick_obsidian").setCreativeTab(CreativeTabsManager.blockTab).setLightOpacity(15).setHardness(15.0F).setResistance(8000.0F);
    public static final Block cmb_brick = new BlockBase(Material.ROCK, "cmb_brick").setCreativeTab(CreativeTabsManager.blockTab).setHardness(25.0F).setResistance(6000.0F);
    public static final Block concrete = new BlockBase(Material.ROCK, "concrete").setCreativeTab(CreativeTabsManager.blockTab).setHardness(15.0F).setResistance(4000.0F);
    public static final Block concrete_smooth = new BlockBase(Material.ROCK, "concrete_smooth").setCreativeTab(CreativeTabsManager.blockTab).setHardness(15.0F).setResistance(4000.0F);
    public static final Block concrete_white = new BlockBase(Material.ROCK, "concrete_white").setCreativeTab(CreativeTabsManager.blockTab).setHardness(15.0F).setResistance(4000.0F);
    public static final Block concrete_orange = new BlockBase(Material.ROCK, "concrete_orange").setCreativeTab(CreativeTabsManager.blockTab).setHardness(15.0F).setResistance(4000.0F);
    public static final Block concrete_magenta = new BlockBase(Material.ROCK, "concrete_magenta").setCreativeTab(CreativeTabsManager.blockTab).setHardness(15.0F).setResistance(4000.0F);
    public static final Block concrete_light_blue = new BlockBase(Material.ROCK, "concrete_light_blue").setCreativeTab(CreativeTabsManager.blockTab).setHardness(15.0F).setResistance(4000.0F);
    public static final Block concrete_yellow = new BlockBase(Material.ROCK, "concrete_yellow").setCreativeTab(CreativeTabsManager.blockTab).setHardness(15.0F).setResistance(4000.0F);
    public static final Block concrete_lime = new BlockBase(Material.ROCK, "concrete_lime").setCreativeTab(CreativeTabsManager.blockTab).setHardness(15.0F).setResistance(4000.0F);
    public static final Block concrete_pink = new BlockBase(Material.ROCK, "concrete_pink").setCreativeTab(CreativeTabsManager.blockTab).setHardness(15.0F).setResistance(4000.0F);
    public static final Block concrete_gray = new BlockBase(Material.ROCK, "concrete_gray").setCreativeTab(CreativeTabsManager.blockTab).setHardness(15.0F).setResistance(4000.0F);
    public static final Block concrete_silver = new BlockBase(Material.ROCK, "concrete_silver").setCreativeTab(CreativeTabsManager.blockTab).setHardness(15.0F).setResistance(4000.0F);
    public static final Block concrete_cyan = new BlockBase(Material.ROCK, "concrete_cyan").setCreativeTab(CreativeTabsManager.blockTab).setHardness(15.0F).setResistance(4000.0F);
    public static final Block concrete_purple = new BlockBase(Material.ROCK, "concrete_purple").setCreativeTab(CreativeTabsManager.blockTab).setHardness(15.0F).setResistance(4000.0F);
    public static final Block concrete_blue = new BlockBase(Material.ROCK, "concrete_blue").setCreativeTab(CreativeTabsManager.blockTab).setHardness(15.0F).setResistance(4000.0F);
    public static final Block concrete_brown = new BlockBase(Material.ROCK, "concrete_brown").setCreativeTab(CreativeTabsManager.blockTab).setHardness(15.0F).setResistance(4000.0F);
    public static final Block concrete_green = new BlockBase(Material.ROCK, "concrete_green").setCreativeTab(CreativeTabsManager.blockTab).setHardness(15.0F).setResistance(4000.0F);
    public static final Block concrete_red = new BlockBase(Material.ROCK, "concrete_red").setCreativeTab(CreativeTabsManager.blockTab).setHardness(15.0F).setResistance(4000.0F);
    public static final Block concrete_black = new BlockBase(Material.ROCK, "concrete_black").setCreativeTab(CreativeTabsManager.blockTab).setHardness(15.0F).setResistance(4000.0F);
    public static final Block concrete_hazard = new BlockBase(Material.ROCK, "concrete_hazard").setCreativeTab(CreativeTabsManager.blockTab).setHardness(15.0F).setResistance(4000.0F);
    public static final Block ore_bedrock_oil = new BlockBase(Material.ROCK, "ore_bedrock_oil").setCreativeTab(CreativeTabsManager.resourceTab).setBlockUnbreakable().setResistance(3_600_000);
    public static final Block ore_oil_empty = new BlockBase(Material.ROCK, "ore_oil_empty").setCreativeTab(CreativeTabsManager.resourceTab).setHardness(5.0F).setResistance(10.0F);
    public static final Block stone_gneiss = new BlockBase(Material.ROCK, "stone_gneiss").setCreativeTab(CreativeTabsManager.resourceTab).setHardness(1.5F).setResistance(10.0F);
    public static final Block meteor_polished = new BlockBase(Material.ROCK, "meteor_polished").setCreativeTab(CreativeTabsManager.blockTab).setHardness(15.0F).setResistance(900.0F);
    public static final Block meteor_brick = new BlockBase(Material.ROCK, "meteor_brick").setCreativeTab(CreativeTabsManager.blockTab).setHardness(15.0F).setResistance(900.0F);
    public static final Block meteor_brick_mossy = new BlockBase(Material.ROCK, "meteor_brick_mossy").setCreativeTab(CreativeTabsManager.blockTab).setHardness(15.0F).setResistance(900.0F);
    public static final Block meteor_brick_cracked = new BlockBase(Material.ROCK, "meteor_brick_cracked").setCreativeTab(CreativeTabsManager.blockTab).setHardness(15.0F).setResistance(900.0F);
    public static final Block meteor_brick_chiseled = new BlockBase(Material.ROCK, "meteor_brick_chiseled").setCreativeTab(CreativeTabsManager.blockTab).setHardness(15.0F).setResistance(900.0F);
    public static final Block meteor_battery = new BlockBase(Material.ROCK, "meteor_battery").setCreativeTab(CreativeTabsManager.blockTab).setHardness(15.0F).setResistance(900.0F);
    public static final Block brick_jungle = new BlockBase(Material.ROCK, "brick_jungle").setCreativeTab(CreativeTabsManager.blockTab).setHardness(15.0F).setResistance(900.0F);
    public static final Block brick_jungle_cracked = new BlockBase(Material.ROCK, "brick_jungle_cracked").setCreativeTab(CreativeTabsManager.blockTab).setHardness(15.0F).setResistance(900.0F);
    public static final Block brick_dungeon = new BlockBase(Material.ROCK, "brick_dungeon").setCreativeTab(CreativeTabsManager.blockTab).setHardness(15.0F).setResistance(900.0F);
    public static final Block brick_dungeon_flat = new BlockBase(Material.ROCK, "brick_dungeon_flat").setCreativeTab(CreativeTabsManager.blockTab).setHardness(15.0F).setResistance(900.0F);
    public static final Block brick_dungeon_tile = new BlockBase(Material.ROCK, "brick_dungeon_tile").setCreativeTab(CreativeTabsManager.blockTab).setHardness(15.0F).setResistance(900.0F);
    public static final Block brick_dungeon_circle = new BlockBase(Material.ROCK, "brick_dungeon_circle").setCreativeTab(CreativeTabsManager.blockTab).setHardness(15.0F).setResistance(900.0F);
    public static final Block block_niter = new BlockBase(Material.IRON, "block_niter").setHardness(5.0F).setResistance(10.0F).setCreativeTab(CreativeTabsManager.blockTab);
    public static final Block block_sulfur = new BlockBase(Material.IRON, "block_sulfur").setHardness(5.0F).setResistance(10.0F).setCreativeTab(CreativeTabsManager.blockTab);
    public static final Block block_titanium = new BlockBase(Material.IRON, "block_titanium").setSoundType(SoundType.METAL).setCreativeTab(CreativeTabsManager.blockTab).setHardness(5.0F).setResistance(10.0F);
    public static final Block block_copper = new BlockBase(Material.IRON, "block_copper").setSoundType(SoundType.METAL).setCreativeTab(CreativeTabsManager.blockTab).setHardness(5.0F).setResistance(10.0F);
    public static final Block block_red_copper = new BlockBase(Material.IRON, "block_red_copper").setSoundType(SoundType.METAL).setCreativeTab(CreativeTabsManager.blockTab).setHardness(5.0F).setResistance(10.0F);
    public static final Block block_advanced_alloy = new BlockBase(Material.IRON, "block_advanced_alloy").setSoundType(SoundType.METAL).setCreativeTab(CreativeTabsManager.blockTab).setHardness(5.0F).setResistance(10.0F);
    public static final Block block_tungsten = new BlockBase(Material.IRON, "block_tungsten").setSoundType(SoundType.METAL).setCreativeTab(CreativeTabsManager.blockTab).setHardness(5.0F).setResistance(10.0F);
    public static final Block block_aluminium = new BlockBase(Material.IRON, "block_aluminium").setSoundType(SoundType.METAL).setCreativeTab(CreativeTabsManager.blockTab).setHardness(5.0F).setResistance(10.0F);
    public static final Block block_fluorite = new BlockBase(Material.IRON, "block_fluorite").setCreativeTab(CreativeTabsManager.blockTab).setHardness(5.0F).setResistance(10.0F);
    public static final Block block_steel = new BlockBase(Material.IRON, "block_steel").setSoundType(SoundType.METAL).setCreativeTab(CreativeTabsManager.blockTab).setHardness(5.0F).setResistance(10.0F);
    public static final Block block_beryllium = new BlockBase(Material.IRON, "block_beryllium").setSoundType(SoundType.METAL).setCreativeTab(CreativeTabsManager.blockTab).setHardness(5.0F).setResistance(10.0F);
    public static final Block block_euphemium = new BlockBase(Material.IRON, "block_euphemium").setSoundType(SoundType.METAL).setCreativeTab(CreativeTabsManager.blockTab).setHardness(5.0F).setResistance(60000.0F);
    public static final Block block_dineutronium = new BlockBase(Material.IRON, "block_dineutronium").setSoundType(SoundType.METAL).setCreativeTab(CreativeTabsManager.blockTab).setHardness(5.0F).setResistance(120000.0F);
    public static final Block block_combine_steel = new BlockBase(Material.IRON, "block_combine_steel").setSoundType(SoundType.METAL).setCreativeTab(CreativeTabsManager.blockTab).setHardness(5.0F).setResistance(600.0F);
    public static final Block block_desh = new BlockBase(Material.IRON, "block_desh").setSoundType(SoundType.METAL).setCreativeTab(CreativeTabsManager.blockTab).setHardness(5.0F).setResistance(600.0F);
    public static final Block block_dura_steel = new BlockBase(Material.IRON, "block_dura_steel").setSoundType(SoundType.METAL).setCreativeTab(CreativeTabsManager.blockTab).setHardness(5.0F).setResistance(600.0F);
    public static final Block block_saturnite = new BlockBase(Material.IRON, "block_saturnite").setSoundType(SoundType.METAL).setCreativeTab(CreativeTabsManager.blockTab).setHardness(6.0F).setResistance(800.0F);
    public static final Block tektite = new BlockBase(Material.ROCK, "tektite").setSoundType(SoundType.STONE).setHardness(1.5F).setResistance(10F).setCreativeTab(CreativeTabsManager.resourceTab);
    public static final Block ore_tektite_osmiridium = new BlockBase(Material.ROCK, "ore_tektite_osmiridium").setSoundType(SoundType.STONE).setHardness(2.5F).setResistance(20F).setCreativeTab(CreativeTabsManager.resourceTab);
    public static final Block deco_titanium = new BlockBase(Material.IRON, "deco_titanium").setCreativeTab(CreativeTabsManager.blockTab).setHardness(5.0F).setResistance(10.0F);
    public static final Block deco_red_copper = new BlockBase(Material.IRON, "deco_red_copper").setCreativeTab(CreativeTabsManager.blockTab).setHardness(5.0F).setResistance(10.0F);
    public static final Block deco_tungsten = new BlockBase(Material.IRON, "deco_tungsten").setCreativeTab(CreativeTabsManager.blockTab).setHardness(5.0F).setResistance(10.0F);
    public static final Block deco_aluminium = new BlockBase(Material.IRON, "deco_aluminium").setCreativeTab(CreativeTabsManager.blockTab).setHardness(5.0F).setResistance(10.0F);
    public static final Block deco_steel = new BlockBase(Material.IRON, "deco_steel").setCreativeTab(CreativeTabsManager.blockTab).setHardness(5.0F).setResistance(10.0F);
    public static final Block deco_lead = new BlockBase(Material.IRON, "deco_lead").setCreativeTab(CreativeTabsManager.blockTab).setHardness(5.0F).setResistance(10.0F);
    public static final Block deco_beryllium = new BlockBase(Material.IRON, "deco_beryllium").setCreativeTab(CreativeTabsManager.blockTab).setHardness(5.0F).setResistance(10.0F);
    public static final Block stone_cracked = new BlockBase(Material.ROCK, "stone_cracked").setHardness(5.0F).setCreativeTab(CreativeTabsManager.resourceTab);
    public static final Block block_smore = new BlockBase(Material.ROCK, "block_smore").setCreativeTab(CreativeTabsManager.blockTab).setHardness(15.0F).setResistance(900.0F);
    public static final Block block_starmetal = new BlockBase(Material.IRON, "block_starmetal").setSoundType(SoundType.METAL).setCreativeTab(CreativeTabsManager.blockTab).setHardness(5.0F).setResistance(600.0F);
    public static final Block block_cobalt = new BlockBase(Material.IRON, "block_cobalt").setCreativeTab(CreativeTabsManager.blockTab).setHardness(5.0F).setResistance(10.0F);
    public static final Block block_foam = new BlockBase(Material.CRAFTED_SNOW, "block_foam").setSoundType(SoundType.SNOW).setCreativeTab(CreativeTabsManager.blockTab).setHardness(0.5F).setResistance(0.0F);
    public static final Block basalt = new BlockBase(Material.ROCK, "basalt").setCreativeTab(CreativeTabsManager.resourceTab).setHardness(5.0F).setResistance(10.0F);
    public static final Block basalt_smooth = new BlockBase(Material.ROCK, "basalt_smooth").setCreativeTab(CreativeTabsManager.resourceTab).setHardness(5.0F).setResistance(10.0F);
    public static final Block basalt_brick = new BlockBase(Material.ROCK, "basalt_brick").setCreativeTab(CreativeTabsManager.resourceTab).setHardness(5.0F).setResistance(10.0F);
    public static final Block basalt_polished = new BlockBase(Material.ROCK, "basalt_polished").setCreativeTab(CreativeTabsManager.resourceTab).setHardness(5.0F).setResistance(10.0F);
    public static final Block basalt_tiles = new BlockBase(Material.ROCK, "basalt_tiles").setCreativeTab(CreativeTabsManager.resourceTab).setHardness(5.0F).setResistance(10.0F);
    public static final Block seal_frame = new BlockBase(Material.IRON, "seal_frame").setHardness(10.0F).setResistance(100.0F).setCreativeTab(CreativeTabsManager.machineTab);
//    public static final Block rbmk_loader = new BlockBaseVisualFluidConnectable(Material.IRON, "rbmk_loader").setHardness(15.0F).setResistance(100.0F).setCreativeTab(CreativeTabsManager.machineTab).setHardness(50.0F).setResistance(60.0F);
    public static final Block muffler = new BlockBase(Material.CLOTH, "muffler").setSoundType(SoundType.CLOTH).setHardness(0.8F).setCreativeTab(CreativeTabsManager.blockTab);
    public static final Block struct_launcher = new BlockBase(Material.IRON, "struct_launcher").setHardness(5.0F).setResistance(10.0F).setCreativeTab(CreativeTabsManager.missileTab);
    public static final Block struct_scaffold = new BlockBase(Material.IRON, "struct_scaffold").setHardness(5.0F).setResistance(10.0F).setCreativeTab(CreativeTabsManager.missileTab);
    public static final Block factory_titanium_hull = new BlockBase(Material.IRON, "factory_titanium_hull").setHardness(5.0F).setResistance(10.0F).setCreativeTab(CreativeTabsManager.machineTab);
    public static final Block factory_advanced_hull = new BlockBase(Material.IRON, "factory_advanced_hull").setHardness(5.0F).setResistance(10.0F).setCreativeTab(CreativeTabsManager.machineTab);
    public static final Block fusion_hatch = new BlockBase(Material.IRON, "fusion_hatch").setHardness(5.0F).setResistance(10.0F).setCreativeTab(CreativeTabsManager.machineTab);
    public static final Block fusion_core = new BlockBase(Material.IRON, "fusion_core_block").setHardness(5.0F).setResistance(10.0F).setCreativeTab(CreativeTabsManager.machineTab);
    public static final Block watz_cooler = new BlockBase(Material.IRON, "watz_cooler").setHardness(5.0F).setResistance(10.0F).setCreativeTab(CreativeTabsManager.machineTab);
    public static final Block watz_end = new BlockBase(Material.IRON, "watz_end").setHardness(5.0F).setResistance(10.0F).setCreativeTab(CreativeTabsManager.machineTab);
    public static final Block fwatz_scaffold = new BlockBase(Material.IRON, "fwatz_scaffold").setHardness(5.0F).setResistance(10.0F).setCreativeTab(CreativeTabsManager.machineTab);
    public static final Block fwatz_computer = new BlockBase(Material.IRON, "fwatz_computer").setHardness(5.0F).setResistance(10.0F).setCreativeTab(CreativeTabsManager.machineTab);
    public static final Block pink_planks = new BlockBase(Material.WOOD, "pink_planks").setSoundType(SoundType.WOOD).setCreativeTab(null);

}
