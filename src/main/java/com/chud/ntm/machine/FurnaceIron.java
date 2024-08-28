package com.chud.ntm.machine;

import java.util.List;

import com.chud.api.ntm.ILoadedTile;
import com.chud.ntm.RefStrings;
import com.chud.ntm.block.BlockDummyable;
import com.chud.ntm.inventory.gui.GuiInfoContainer;
import com.chud.ntm.item.machine.ItemMachineUpgrade;
import com.chud.ntm.lib.ForgeDirection;
import com.chud.ntm.lib.ITooltipProvider;
import com.chud.ntm.manager.ResourceManager;
import com.chud.ntm.modules.ModuleBurnTime;
import com.chud.ntm.tileentity.TileEntityMachineBase;
import com.chud.ntm.tileentity.TileEntityProxyCombo;
import com.chud.ntm.inventory.SlotMachineOutput;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.*;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraft.util.math.BlockPos;
import net.minecraft.client.util.ITooltipFlag;

import org.lwjgl.opengl.GL11;

public final class FurnaceIron {

    public static class Container extends net.minecraft.inventory.Container {

        protected FurnaceIron.TileEntity furnace;

        public Container(InventoryPlayer invPlayer, FurnaceIron.TileEntity furnace) {
            this.furnace = furnace;

            //input
            this.addSlotToContainer(new SlotItemHandler(furnace.inventory, 0, 53, 17));
            //fuel
            this.addSlotToContainer(new SlotItemHandler(furnace.inventory, 1, 53, 53));
            this.addSlotToContainer(new SlotItemHandler(furnace.inventory, 2, 71, 53));
            //output
            this.addSlotToContainer(new SlotMachineOutput(furnace.inventory, 3, 125, 35));
            //upgrade
            this.addSlotToContainer(new SlotItemHandler(furnace.inventory, 4, 17, 35));

            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 9; j++) {
                    this.addSlotToContainer(new Slot(invPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
                }
            }

            for(int i = 0; i < 9; i++) {
                this.addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 142));
            }
        }

        @Override
        public ItemStack transferStackInSlot(EntityPlayer player, int index) {
            ItemStack stack = ItemStack.EMPTY;
            Slot slot = this.inventorySlots.get(index);

            if(slot != null && slot.getHasStack()) {
                ItemStack originalStack = slot.getStack();
                stack = originalStack.copy();

                if(index <= 5) {
                    if(!this.mergeItemStack(originalStack, 6, this.inventorySlots.size(), true)) {
                        return ItemStack.EMPTY;
                    }

                    slot.onSlotChange(originalStack, stack);

                } else if(!this.mergeItemStack(originalStack, 0, 3, false)) {
                    return ItemStack.EMPTY;
                }

                if(originalStack.getCount() == 0) {
                    slot.putStack(ItemStack.EMPTY);
                } else {
                    slot.onSlotChanged();
                }
            }

            return stack;
        }

        @Override
        public boolean canInteractWith(EntityPlayer player) {
            return furnace.isUseableByPlayer(player);
        }
    }

    public static class GUI extends GuiInfoContainer {

        private static ResourceLocation texture = new ResourceLocation(RefStrings.MODID + ":textures/gui/processing/gui_furnace_iron.png");
        private FurnaceIron.TileEntity furnace;

        public GUI(InventoryPlayer invPlayer, FurnaceIron.TileEntity tedf) {
            super(new Container(invPlayer, tedf));
            furnace = tedf;

            this.xSize = 176;
            this.ySize = 166;
        }

        @Override
        public void drawScreen(int x, int y, float interp) {
            super.drawScreen(x, y, interp);

            this.drawCustomInfoStat(x, y, guiLeft + 52, guiTop + 35, 71, 7, x, y, new String[] { (furnace.progress * 100 / Math.max(furnace.processingTime, 1)) + "%" });
            this.drawCustomInfoStat(x, y, guiLeft + 52, guiTop + 44, 71, 7, x, y, new String[] { (furnace.burnTime / 20) + "s" });
            super.renderHoveredToolTip(x, y);
        }

        @Override
        protected void drawGuiContainerForegroundLayer(int i, int j) {
            String name = this.furnace.hasCustomInventoryName() ? this.furnace.getInventoryName() : I18n.format(this.furnace.getInventoryName());

            this.fontRenderer.drawString(name, this.xSize / 2 - this.fontRenderer.getStringWidth(name) / 2, 6, 4210752);
            this.fontRenderer.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
        }

        @Override
        protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
            super.drawDefaultBackground();
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
            drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

            int i = furnace.progress * 70 / Math.max(furnace.processingTime, 1);
            drawTexturedModalRect(guiLeft + 53, guiTop + 36, 176, 18, i, 5);

            int j = furnace.burnTime * 70 / Math.max(furnace.maxBurnTime, 1);
            drawTexturedModalRect(guiLeft + 53, guiTop + 45, 176, 23, j, 5);

            if(furnace.canSmelt())
                drawTexturedModalRect(guiLeft + 70, guiTop + 16, 176, 0, 18, 18);
        }
    }

    public static class TileEntity extends TileEntityMachineBase implements ILoadedTile.IGUIProvider, ITickable {

        public int maxBurnTime;
        public int burnTime;
        public boolean wasOn = false;

        public int progress;
        public int processingTime;
        public static final int baseTime = 200;

        public ModuleBurnTime burnModule;

        public TileEntity() {
            super(5);

            burnModule = new ModuleBurnTime()
                    .setLigniteTimeMod(1.25)
                    .setCoalTimeMod(1.25)
                    .setCokeTimeMod(1.5)
                    .setSolidTimeMod(2)
                    .setRocketTimeMod(2)
                    .setBalefireTimeMod(2);
        }

        @Override
        public String getName() {
            return "container.furnaceIron";
        }

        @Override
        public void update() {

            if(!world.isRemote) {

                this.processingTime = baseTime - 15 * ItemMachineUpgrade.getSpeed(inventory.getStackInSlot(4));

                wasOn = false;

                if(burnTime <= 0) {

                    for(int i = 1; i < 3; i++) {
                        ItemStack input = inventory.getStackInSlot(i);
                        if(input != null) {

                            int fuel = burnModule.getBurnTime(input);

                            if(fuel > 0) {
                                this.maxBurnTime = this.burnTime = fuel;
                                input.shrink(1);
                                break;
                            }
                        }
                    }
                }

                if(canSmelt()) {
                    wasOn = true;
                    this.progress++;
                    this.burnTime--;

                    if(this.progress % 15 == 0) {
                        world.playSound(null, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0F, 0.5F + world.rand.nextFloat() * 0.5F);
                    }

                    if(this.progress >= this.processingTime) {
                        ItemStack outputs = inventory.getStackInSlot(3);
                        ItemStack result = FurnaceRecipes.instance().getSmeltingResult(inventory.getStackInSlot(0));
                        ItemStack copy = outputs;

                        if(outputs == ItemStack.EMPTY) {
                            copy  = result.copy();
                            inventory.setStackInSlot(3, copy);
                        } else {
                            outputs.setCount(copy.getCount() + result.getCount());
                        }

                        inventory.getStackInSlot(0).shrink(1);

                        this.progress = 0;
                        this.markDirty();
                    }
                } else {
                    this.progress = 0;
                }

                NBTTagCompound data = new NBTTagCompound();
                data.setInteger("maxBurnTime", this.maxBurnTime);
                data.setInteger("burnTime", this.burnTime);
                data.setInteger("progress", this.progress);
                data.setInteger("processingTime", this.processingTime);
                data.setBoolean("wasOn", this.wasOn);
                this.networkPack(data, 50);
            } else {

                if(this.progress > 0) {
                    ForgeDirection dir = ForgeDirection.getOrientation(this.getBlockMetadata() - 10);
                    ForgeDirection rot = dir.getRotation(ForgeDirection.UP);

                    double offset = this.progress % 2 == 0 ? 1 : 0.5;
                    world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, pos.getX() + 0.5 - dir.offsetX * offset - rot.offsetX * 0.1875, pos.getY() + 2, pos.getZ() + 0.5 - dir.offsetZ * offset - rot.offsetZ * 0.1875, 0.0, 0.01, 0.0);

                    if(this.progress % 5 == 0) {
                        world.spawnParticle(EnumParticleTypes.FLAME, pos.getX() + 0.5 + dir.offsetX * 0.25 + rot.offsetX * world.rand.nextDouble(), pos.getY() + 0.25 +world.rand.nextDouble() * 0.25, pos.getZ() + 0.5 + dir.offsetZ * 0.25 + rot.offsetZ * world.rand.nextDouble(), 0.0, 0.0, 0.0);
                    }
                }
            }
        }

        @Override
        public void networkUnpack(NBTTagCompound nbt) {
            this.maxBurnTime = nbt.getInteger("maxBurnTime");
            this.burnTime = nbt.getInteger("burnTime");
            this.progress = nbt.getInteger("progress");
            this.processingTime = nbt.getInteger("processingTime");
            this.wasOn = nbt.getBoolean("wasOn");
        }

        public boolean canSmelt() {

            if(this.burnTime <= 0) return false;
            if(inventory.getStackInSlot(0).isEmpty()) return false;

            ItemStack result = FurnaceRecipes.instance().getSmeltingResult(inventory.getStackInSlot(0));

            if(result == null || result.isEmpty()) return false;
            if(inventory.getStackInSlot(3).isEmpty()) return true;

            if(!result.isItemEqual(inventory.getStackInSlot(3))) return false;
            if(inventory.getStackInSlot(3).getCount() < inventory.getSlotLimit(3) && inventory.getStackInSlot(3).getCount() < inventory.getStackInSlot(3).getMaxStackSize()) {
                return true;
            }else{
                return inventory.getStackInSlot(3).getCount() < result.getMaxStackSize();
            }
        }

        @Override
        public int[] getAccessibleSlotsFromSide(EnumFacing e) {
            return new int[] { 0, 1, 2, 3 };
        }

        @Override
        public boolean isItemValidForSlot(int i, ItemStack itemStack) {

            if(i == 0)
                return FurnaceRecipes.instance().getSmeltingResult(itemStack) != null;

            if(i < 3)
                return burnModule.getBurnTime(itemStack) > 0;

            return false;
        }

        @Override
        public boolean canExtractItem(int i, ItemStack itemStack, int j) {
            return i == 3;
        }

        @Override
        public void readFromNBT(NBTTagCompound nbt) {
            super.readFromNBT(nbt);

            this.maxBurnTime = nbt.getInteger("maxBurnTime");
            this.burnTime = nbt.getInteger("burnTime");
            this.progress = nbt.getInteger("progress");
        }

        @Override
        public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
            super.writeToNBT(nbt);

            nbt.setInteger("maxBurnTime", maxBurnTime);
            nbt.setInteger("burnTime", burnTime);
            nbt.setInteger("progress", progress);
            return nbt;
        }

        @Override
        public Container provideContainer(int ID, EntityPlayer player, World world, int x, int y, int z) {
            return new Container(player.inventory, this);
        }

        @Override
        @SideOnly(Side.CLIENT)
        public GuiScreen provideGUI(int ID, EntityPlayer player, World world, int x, int y, int z) {
            return new FurnaceIron.GUI(player.inventory, this);
        }

        AxisAlignedBB bb = null;

        @Override
        public AxisAlignedBB getRenderBoundingBox() {

            if (bb == null) {
                bb = new AxisAlignedBB(pos.getX() - 1, pos.getY(), pos.getZ() - 1, pos.getX() + 2, pos.getY() + 3, pos.getZ() + 2);
            }

            return bb;
        }

        @Override
        @SideOnly(Side.CLIENT)
        public double getMaxRenderDistanceSquared() {
            return 65536.0D;
        }

    }

    public static class Block extends BlockDummyable implements ITooltipProvider {

        public Block(Material mat, String s) {
            super(Material.IRON, s);
        }

        @Override
        public net.minecraft.tileentity.TileEntity createNewTileEntity(World world, int meta) {
            if(meta >= 12) return new FurnaceIron.TileEntity();
            return new TileEntityProxyCombo(true, false, false);
        }

        @Override
        public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
            return standardOpenBehavior(world, pos.getX(), pos.getY(), pos.getZ(), player, 0);
        }

        @Override
        public int[] getDimensions() {
            return new int[] {1, 0, 1, 0, 1, 0};
        }

        @Override
        public int getOffset() {
            return 0;
        }

        @Override
        public void addInformation(ItemStack stack, World worldIn, List<String> list, ITooltipFlag flagIn) {
            this.addStandardInfo(list);
            super.addInformation(stack, worldIn, list, flagIn);
        }

    }

    public static class Renderer extends TileEntitySpecialRenderer<TileEntity> {

        @Override
        public void render(FurnaceIron.TileEntity tileEntity, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
            GL11.glPushMatrix();
            GL11.glTranslated(x + 0.5D, y, z + 0.5D);
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glEnable(GL11.GL_CULL_FACE);

            switch(tileEntity.getBlockMetadata() - BlockDummyable.offset) {
                case 3: GL11.glRotatef(0, 0F, 1F, 0F); break;
                case 5: GL11.glRotatef(90, 0F, 1F, 0F); break;
                case 2: GL11.glRotatef(180, 0F, 1F, 0F); break;
                case 4: GL11.glRotatef(270, 0F, 1F, 0F); break;
            }

            GL11.glTranslated(-0.5D, 0, -0.5D);

            // TODO
            bindTexture(ResourceManager.furnace_iron_tex);
            ResourceManager.furnace_iron.renderPart("Main");

            if(tileEntity.wasOn) {
                GL11.glPushMatrix();
                GL11.glPushAttrib(GL11.GL_LIGHTING_BIT);

                GL11.glDisable(GL11.GL_LIGHTING);
                GL11.glDisable(GL11.GL_CULL_FACE);
                OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240F, 240F);
                ResourceManager.furnace_iron.renderPart("On");
                GL11.glEnable(GL11.GL_LIGHTING);

                GL11.glPopAttrib();
                GL11.glPopMatrix();
            } else {
                ResourceManager.furnace_iron.renderPart("Off");
            }

            GL11.glPopMatrix();
        }
    }

}
