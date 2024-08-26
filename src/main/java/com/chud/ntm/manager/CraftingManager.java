package com.chud.ntm.manager;

import com.chud.ntm.ChudNTM;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.chud.ntm.item.ModItems;

import static com.chud.ntm.RefStrings.*;

@EventBusSubscriber(modid=MODID)
public class CraftingManager {

    private static RegistryEvent.Register<IRecipe> CRAFTING_REGISTRY = null;

    @SubscribeEvent
    public static void craftingRegister(RegistryEvent.Register<IRecipe> e){
        CRAFTING_REGISTRY = e;

        addAllRecipes();
    }

    public static ResourceLocation getRecipeName(ItemStack output) {
        ResourceLocation loc = new ResourceLocation(MODID, output.getItem().getRegistryName().getPath());
        int i = 0;
        ResourceLocation r_loc = loc;
        while(net.minecraft.item.crafting.CraftingManager.REGISTRY.containsKey(r_loc)) {
            i++;
            r_loc = new ResourceLocation(MODID, loc.getPath() + "_" + i);
        }
        return r_loc;
    }

    public static void addRecipeAuto(ItemStack output, Object... args) {
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

        ChudNTM.LOGGER.info("Added recipe for {}", loc);
    }

    public static void addAllRecipes() {
        addRecipeAuto(new ItemStack(ModItems.REDSTONE_SWORD, 1), new Object[] { "R", "R", "S", 'R', Blocks.REDSTONE_BLOCK, 'S', Items.STICK });
    }

}
