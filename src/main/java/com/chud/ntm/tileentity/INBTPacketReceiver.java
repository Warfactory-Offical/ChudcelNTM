package com.chud.ntm.tileentity;

import com.chud.ntm.packet.NBTPacket;
import com.chud.ntm.packet.PacketDispatcher;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;

public interface INBTPacketReceiver {

    void networkUnpack(NBTTagCompound nbt);

    static void networkPack(TileEntity that, NBTTagCompound data, int range) {
        BlockPos pos = that.getPos();
        PacketDispatcher.wrapper.sendToAllAround(new NBTPacket(data, pos), new TargetPoint(that.getWorld().provider.getDimension(), pos.getX(), pos.getY(), pos.getZ(), range));
    }

}