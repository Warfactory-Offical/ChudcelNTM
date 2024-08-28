package com.chud.api.ntm;

import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.IOException;

public interface ILoadedTile {

    boolean isLoaded();

    interface IGUIProvider {

        Container provideContainer(int ID, EntityPlayer player, World world, int x, int y, int z);

        @SideOnly(Side.CLIENT)
        GuiScreen provideGUI(int ID, EntityPlayer player, World world, int x, int y, int z);

    }

    interface IConfigurableMachine {

        String getConfigName();

        void readIfPresent(JsonObject obj);

        void writeConfig(JsonWriter writer) throws IOException;

        static boolean grab(JsonObject obj, String name, boolean def) {
            return obj.has(name) ? obj.get(name).getAsBoolean() : def;
        }

        static int grab(JsonObject obj, String name, int def) {
            return obj.has(name) ? obj.get(name).getAsInt() : def;
        }

        static long grab(JsonObject obj, String name, long def) {
            return obj.has(name) ? obj.get(name).getAsLong() : def;
        }

        static double grab(JsonObject obj, String name, double def) {
            return obj.has(name) ? obj.get(name).getAsDouble() : def;
        }
    }
}