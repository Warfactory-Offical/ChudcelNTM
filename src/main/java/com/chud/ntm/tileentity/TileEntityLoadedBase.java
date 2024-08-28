package com.chud.ntm.tileentity;

import com.chud.api.ntm.ILoadedTile;

import net.minecraft.tileentity.TileEntity;

public class TileEntityLoadedBase extends TileEntity implements ILoadedTile {

    public boolean isLoaded = true;

    @Override
    public boolean isLoaded() {
        return isLoaded;
    }

    @Override
    public void onChunkUnload() {
        super.onChunkUnload();
        this.isLoaded = false;
    }

}