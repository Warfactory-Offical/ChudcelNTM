package com.chud.ntm.manager;

import com.chud.ntm.config.GeneralConfig;
import com.chud.ntm.item.ModItems;
import com.chud.ntm.util.I18nUtil;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;

import java.util.*;

public class CustomLoreManager {

    public static void addCustomLore(ItemStack stack, List<String> list) {
        Item item = stack.getItem();

        if (!customLoreEntries.containsKey(item)) return;

        list.addAll(customLoreEntries.get(item));
    }

    static Map<Item, List<String>> customLoreEntries = new LinkedHashMap<>();

    private static void addCustomLoreEntry(Item item, String... lines) {
        customLoreEntries.put(item, new ArrayList<>(Arrays.asList(lines)));
    }

    private static void addCustomLoreEntry(Item[] items, String... lines) {
        for (Item item : items) {
            addCustomLoreEntry(item, lines);
        }
    }

    static {
        addCustomLoreEntry(ModItems.powder_asbestos, TextFormatting.ITALIC + "\"Sniffffffff- MHHHHHHMHHHHHHHHH\"");
//        addCustomLoreEntry(ModItems.bismuth_tool, "§eRight-click a Dud while having empty cells in inventory gives you antimatter cells.", "§8§oMight set off the Dud tho");
        addCustomLoreEntry(ModItems.ingot_fiberglass, "High in fiber, high in glass. Everything the body needs.");
        addCustomLoreEntry(ModItems.missile_soyuz_lander, "Doubles as a crappy lander!");
//        addCustomLoreEntry(ModItems.book_of_, "Denn wer den Walzer richtig tritt,", "der ist auch für den Abgang fit.");
        addCustomLoreEntry(ModItems.watch, "A small blue pocket watch.", "It's glass has a few cracks in it,", "and some shards are missing.", "It stopped ticking at 2:34.");
        addCustomLoreEntry(ModItems.reacher, "Holding this in main hand or off hand reduces radiation coming from items to its square-root.", "It also is useful to handle very hot or cold items.");
        addCustomLoreEntry(ModItems.ingot_asbestos, TextFormatting.ITALIC + "\"Filled with life, self-doubt and asbestos. That comes with the air.\"");
        addCustomLoreEntry(ModItems.entanglement_kit, "Teleporter crafting item.", "Enables dimension-shifting via", "beryllium-enhanced resource scanner.");
//        addCustomLoreEntry(ModItems.ams_focus_limiter, "Maximum performance for restriction field:", "Standard cooling, no energy bonus.");
//        addCustomLoreEntry(ModItems.ams_focus_booster, "Weaker restriction field and core energy injection:", "More heat generation, extra energy.");
        addCustomLoreEntry(ModItems.ams_muzzle, "...it emits an energy-beam thingy.");
        addCustomLoreEntry(ModItems.powder_poison, "Used in multi purpose bombs:", "Warning: Poisonous!");
        addCustomLoreEntry(ModItems.pellet_cluster, "Used in multi purpose bombs:", "Adds some extra boom!");
        addCustomLoreEntry(ModItems.powder_fire, "Used in multi purpose bombs:", "Incendiary bombs are fun!");
        addCustomLoreEntry(ModItems.pellet_gas, "Used in multi purpose bombs:", "*cough cough* Halp pls!");
        addCustomLoreEntry(ModItems.powder_tektite, "Collected via Geralds Miningfleet from §3outer space");
        addCustomLoreEntry(ModItems.igniter, "(Used by right-clicking the Prototype)", "It's a green metal handle with a", "bright red button and a small lid.", "At the bottom, the initials N.E. are", "engraved. Whoever N.E. was, he had", "a great taste in shades of green.");
        addCustomLoreEntry(ModItems.overfuse, "Say what?");
        addCustomLoreEntry(ModItems.tritium_deuterium_cake, "Not actual cake, but great", "universal fusion fuel!");
        addCustomLoreEntry(ModItems.flame_conspiracy, I18nUtil.resolveKey("desc.flameconspiracy"));
        addCustomLoreEntry(ModItems.flame_politics, I18nUtil.resolveKey("desc.flamepolitics"));
        addCustomLoreEntry(ModItems.flame_opinion, I18nUtil.resolveKey("desc.flameopinion"));
        addCustomLoreEntry(ModItems.mech_key, "It pulses with power.");
        addCustomLoreEntry(ModItems.ingot_lanthanium, "'Lanthanum'");
        addCustomLoreEntry(ModItems.billet_flashlead, "The lattice decays, causing antimatter-matter annihilation reactions, causing the release of pions, decaying into muons, catalyzing fusion of the nuclei, creating the new element. Please try to keep up.");
        addCustomLoreEntry(ModItems.euphemium_capacitor, "Permits passive dispersion of accumulated positive energy.");
//        addCustomLoreEntry(ModItems.iv_empty, I18nUtil.resolveKey("desc.ivempty"));
//        addCustomLoreEntry(ModItems.radaway, I18nUtil.resolveKey("desc.radamount", -250), I18nUtil.resolveKey("desc.radspeed", -25), I18nUtil.resolveKey("desc.duration", 10));
//        addCustomLoreEntry(ModItems.radaway_strong, I18nUtil.resolveKey("desc.radamount", -500), I18nUtil.resolveKey("desc.radspeed", -100), I18nUtil.resolveKey("desc.duration", 5));
//        addCustomLoreEntry(ModItems.radaway_flush, I18nUtil.resolveKey("desc.radamount", -1000), I18nUtil.resolveKey("desc.radspeed", -400), I18nUtil.resolveKey("desc.duration", 2.5));
        addCustomLoreEntry(ModItems.pin, "Can be used with a screwdriver to pick locks.");
        addCustomLoreEntry(ModItems.crystal_energy, "Densely packed energy powder.", "Not edible.");
//        addCustomLoreEntry(ModItems.pellet_coolant, "Required for cyclotron operation.", "Do NOT operate cyclotron without it!");
        addCustomLoreEntry(ModItems.fuse, "This item is needed for every large", "nuclear reactor, as it allows the", "reactor to generate electricity and", "use up it's fuel. Removing the fuse", "from a reactor will instantly shut", "it down.");
        addCustomLoreEntry(ModItems.gun_super_shotgun, "It's super broken!");
        addCustomLoreEntry(ModItems.burnt_bark, "A piece of bark from an exploded golden oak tree.");
        addCustomLoreEntry(ModItems.rod_lithium, "Turns into Tritium Rod");
        addCustomLoreEntry(ModItems.rod_dual_lithium, "Turns into Dual Tritium Rod");
        addCustomLoreEntry(ModItems.rod_quad_lithium, "Turns into Quad Tritium Rod");
        addCustomLoreEntry(ModItems.ingot_euphemium, "A very special and yet strange element.");
        addCustomLoreEntry(ModItems.powder_euphemium, "Pulverized pink.", "Tastes like strawberries.");
        addCustomLoreEntry(ModItems.nugget_euphemium, "A small piece of a pink metal.", "It's properties are still unknown,", "DEAL WITH IT carefully.");
        addCustomLoreEntry(ModItems.rod_quad_euphemium, "A quad fuel rod which contains a", "very small ammount of a strange new element.");
        addCustomLoreEntry(ModItems.nugget_mox_fuel, "Moxie says: " + TextFormatting.BOLD + "TAX EVASION.");
        addCustomLoreEntry(ModItems.billet_mox_fuel, TextFormatting.ITALIC + "Pocket-Moxie!");
        addCustomLoreEntry(ModItems.ingot_schraranium, GeneralConfig.enableBabyMode
                ? "Peer can go die, I'm not putting any retarded niko stuff in the mod."
                : "Made from uranium in a nuclear transmutator"
        );
        addCustomLoreEntry(ModItems.crystal_horn, true // TODO: MainRegistry.polaroidID == 11
                ? "An actual horn."
                : "Not an actual horn."
        );
        addCustomLoreEntry(ModItems.crystal_charred, true // TODO: MainRegistry.polaroidID == 11
                ? "Also a real horn. Weird, right?"
                : "High quality silicate, slightly burned."
        );
        addCustomLoreEntry(ModItems.key_red, true // TODO: MainRegistry.polaroidID == 11
                ? TextFormatting.DARK_RED + "" + TextFormatting.BOLD + "e"
                : "Explore the other side."
        );
        addCustomLoreEntry(ModItems.ingot_neptunium, true // TODO: MainRegistry.polaroidID == 11
                ? "Woo, scary!"
                : "That one's my favour"
        );
//        addCustomLoreEntry(ModItems.pellet_rtg, true // TODO: MainRegistry.polaroidID == 11
//                ? "Contains ~100% Pu238 oxide."
//                : "RTG fuel pellet for infinite energy!"
//        );
//        addCustomLoreEntry(ModItems.pellet_rtg_polonium, true // TODO: MainRegistry.polaroidID == 11
//                ? "Polonium 4 U and me."
//                : "Tastes nice in Tea"
//        );
        addCustomLoreEntry(ModItems.flame_pony, "Blue horse beats yellow horse, look it up!", I18nUtil.resolveKey("desc.flamepony"));
        addCustomLoreEntry(ModItems.ingot_combine_steel, "*insert Civil Protection reference here*");
        addCustomLoreEntry(new Item[] { ModItems.ingot_gh336, ModItems.billet_gh336, ModItems.nugget_gh336 }, "Seaborgium's colleague");
        addCustomLoreEntry(new Item[] { ModItems.ingot_tantalium, ModItems.nugget_tantalium, ModItems.gem_tantalium, ModItems.powder_tantalium }, "'Tantalum'");
        addCustomLoreEntry(new Item[] { ModItems.factory_core_titanium, ModItems.factory_core_advanced }, "Used in factories to make the speed change");
    }

}
