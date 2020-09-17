package com.testure6.testuretech.blocks.copperchest;

import com.testure6.testuretech.blocks.BlockInit;
import com.testure6.testuretech.blocks.ContainerInit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

import java.util.Objects;

public class CopperChestContainer extends Container {

    public final CopperChestTile tileEntity;
    private final IWorldPosCallable canInteractWithCallable;

    public CopperChestContainer(final int windowId, final PlayerInventory player, final CopperChestTile tile) {
        super(ContainerInit.Copper_Chest.get(), windowId);
        this.tileEntity = tile;
        this.canInteractWithCallable = IWorldPosCallable.of(tile.getWorld(), tile.getPos());

        int startX = 8;
        int startY = 18;
        int slotSizePlus2 = 18;

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 9; col++) {
                this.addSlot(new Slot(tile, (row * 9) + col, startX + (col * slotSizePlus2), startY + (row * slotSizePlus2)));
            }
        }

        int startPlayerInvY = startY * 5 + 12;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                this.addSlot(new Slot(player, 9 + (row * 9) + col, startX + (col * slotSizePlus2), startPlayerInvY + (row * slotSizePlus2)));
            }
        }

        int hotBarY = startPlayerInvY + (startPlayerInvY/2) + 7;

        for (int col = 0; col < 9; col++) {
            this.addSlot(new Slot(player, col, startX + (col * slotSizePlus2), hotBarY));
        }
    }

    public CopperChestContainer(final int windowId, final PlayerInventory playerInventory, final PacketBuffer data) {
        this(windowId, playerInventory, getTileEntity(playerInventory, data));
    }

    private static CopperChestTile getTileEntity(final PlayerInventory playerInventory, final PacketBuffer data) {
        Objects.requireNonNull(playerInventory, "playerInventory can't be null");
        Objects.requireNonNull(data, "data can't be null");
        final TileEntity tileAtPos = playerInventory.player.world.getTileEntity(data.readBlockPos());
        if (tileAtPos instanceof CopperChestTile) {
            return (CopperChestTile) tileAtPos;
        }
        throw new IllegalStateException("Tile Entity is not correct! " + tileAtPos);
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return isWithinUsableDistance(canInteractWithCallable, playerIn, BlockInit.Copper_Chest.get());
    }

    @Override
    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemStack1 = slot.getStack();
            itemStack = itemStack1.copy();
            if (index < 36) {
                if (!this.mergeItemStack(itemStack1, 36, this.inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemStack1, 0, 36, false)) {
                return ItemStack.EMPTY;
            }
            if (itemStack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
        }
        return itemStack;
    }
}
