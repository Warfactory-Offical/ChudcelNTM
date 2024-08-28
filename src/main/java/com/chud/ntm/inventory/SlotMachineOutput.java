package com.chud.ntm.inventory;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

public class SlotMachineOutput extends SlotItemHandler {

    public SlotMachineOutput(IItemHandler inventory, int i, int j, int k) {
        super(inventory, i, j, k);
    }

    @Override
    public boolean isItemValid(@NotNull ItemStack ignored) {
        return false;
    }

}
