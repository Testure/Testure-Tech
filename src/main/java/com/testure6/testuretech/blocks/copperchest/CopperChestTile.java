package com.testure6.testuretech.blocks.copperchest;

import com.testure6.testuretech.blocks.TileEntityInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.wrapper.InvWrapper;

import javax.annotation.Nullable;

public class CopperChestTile extends LockableLootTileEntity {

    private NonNullList<ItemStack> contents = NonNullList.withSize(36, ItemStack.EMPTY);
    protected int playersUsing;
    private IItemHandlerModifiable items = createHandler();
    private LazyOptional<IItemHandlerModifiable> itemHandler = LazyOptional.of(() -> items);

    public CopperChestTile(TileEntityType<?> typeIn) {
        super(typeIn);
    }

    public CopperChestTile() {
        this(TileEntityInit.Copper_Chest.get());
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.contents;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> itemsIn) {
        this.contents = itemsIn;
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container.copper_chest");
    }

    @Override
    protected Container createMenu(int id, PlayerInventory player) {
        return new CopperChestContainer(id, player, this);
    }

    @Override
    public int getSizeInventory() {
        return 36;
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        if (!this.checkLootAndWrite(compound)) {
            ItemStackHelper.saveAllItems(compound, this.contents);
        }
        return compound;
    }

    @Override
    public void read(CompoundNBT compound) {
        super.read(compound);
        this.contents = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
        if (!this.checkLootAndRead(compound)) {
            ItemStackHelper.loadAllItems(compound, this.contents);
        }
    }

    private void playSound(SoundEvent sound, PlayerEntity player) {
        double dx = (double) this.pos.getX() + 0.5d;
        double dy = (double) this.pos.getY() + 0.5d;
        double dz = (double) this.pos.getZ() + 0.5d;
        this.world.playSound(player, dx, dy, dz, sound, SoundCategory.BLOCKS, 0.5f, this.world.rand.nextFloat() * 0.1f + 0.9f);
    }

    @Override
    public boolean receiveClientEvent(int id, int type) {
        if (id == 1) {
            this.playersUsing = type;
            return true;
        } else {
            return super.receiveClientEvent(id, type);
        }
    }

    @Override
    public void openInventory(PlayerEntity player) {
        if (!player.isSpectator()) {
            if (this.playersUsing < 0) {
                this.playersUsing = 0;
            }
            this.playersUsing++;
            this.playSound(SoundEvents.BLOCK_CHEST_OPEN, player);
            this.onOpenOrClose();
        }
    }

    @Override
    public void closeInventory(PlayerEntity player) {
        if (!player.isSpectator()) {
            this.playersUsing--;
            this.playSound(SoundEvents.BLOCK_CHEST_CLOSE, player);
            this.onOpenOrClose();
        }
    }

    protected void onOpenOrClose() {
        Block block = this.getBlockState().getBlock();
        if (block instanceof CopperChestBlock) {
            this.world.addBlockEvent(this.pos, block, 1, this.playersUsing);
            this.world.notifyNeighborsOfStateChange(this.pos, block);
        }
    }

    public int getPlayersUsing(IBlockReader reader, BlockPos pos) {
        BlockState state = reader.getBlockState(pos);
        if (state.hasTileEntity()) {
            TileEntity tile = reader.getTileEntity(pos);
            if (tile instanceof CopperChestTile) {
                return ((CopperChestTile) tile).playersUsing;
            }
        }
        return 0;
    }

    public static void swapContents(CopperChestTile tile, CopperChestTile otherTile) {
        NonNullList<ItemStack> list = tile.getItems();
        tile.setItems(otherTile.getItems());
        otherTile.setItems(list);
    }

    @Override
    public void updateContainingBlockInfo() {
        super.updateContainingBlockInfo();
        if (this.itemHandler != null) {
            this.itemHandler.invalidate();
            this.itemHandler = null;
        }
    }

    @Nullable
    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return itemHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void remove() {
        super.remove();
        if (itemHandler != null) {
            itemHandler.invalidate();
        }
    }

    private IItemHandlerModifiable createHandler() {
        return new InvWrapper(this);
    }

}
