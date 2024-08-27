package com.chud.ntm.manager;

import com.chud.ntm.ChudNTM;
import com.chud.ntm.item.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.oredict.ShapedOreRecipe;
import org.jetbrains.annotations.NotNull;

import static com.chud.ntm.RefStrings.MODID;

public class CraftingManager {

    private static RegistryEvent.Register<IRecipe> CRAFTING_REGISTRY = null;

    public static void register(@NotNull RegistryEvent.Register<IRecipe> registry) {
        CRAFTING_REGISTRY = registry;
        addAllRecipes();
        CRAFTING_REGISTRY = null;
    }

    private static ResourceLocation getRecipeName(ItemStack output) {
        ResourceLocation loc = new ResourceLocation(MODID, output.getItem().getRegistryName().getPath());
        int i = 0;
        ResourceLocation r_loc = loc;
        while(net.minecraft.item.crafting.CraftingManager.REGISTRY.containsKey(r_loc)) {
            i++;
            r_loc = new ResourceLocation(MODID, loc.getPath() + "_" + i);
        }
        return r_loc;
    }

    private static void addRecipeAuto(ItemStack output, Object... args) {
        boolean shouldUseOD = false;
        boolean patternEnded = false;

        for (Object arg : args) {
            if (arg instanceof String) {
                if (patternEnded) {
                    shouldUseOD = true;
                    break;
                }
            } else {
                patternEnded = true;
            }
        }

        final ResourceLocation loc = getRecipeName(output);
        final IRecipe recipe;

        if (shouldUseOD) {
            recipe = new ShapedOreRecipe(loc, output, args);
        } else {
            CraftingHelper.ShapedPrimer primer = CraftingHelper.parseShaped(args);
            recipe = new ShapedRecipes(output.getItem().getRegistryName().toString(), primer.width, primer.height, primer.input, output);
        }

        recipe.setRegistryName(loc);
        CRAFTING_REGISTRY.getRegistry().register(recipe);
    }

    private static void addAllRecipes() {
        addRecipeAuto(new ItemStack(ModItems.get("redstone_sword"), 1), new Object[] { "R", "R", "S", 'R', Blocks.REDSTONE_BLOCK, 'S', Items.STICK });
    }

}
