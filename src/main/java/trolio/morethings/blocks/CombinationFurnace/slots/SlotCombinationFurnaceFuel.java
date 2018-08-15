package trolio.morethings.blocks.CombinationFurnace.slots;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import trolio.morethings.blocks.CombinationFurnace.TileEntityCombinationFurnace;

public class SlotCombinationFurnaceFuel extends Slot
{
	public SlotCombinationFurnaceFuel (IInventory inventory, int index, int x, int y)
	{
		super(inventory, index, x, y);
	}
	
	@Override
	public boolean isItemValid (ItemStack stack)
	{
		return TileEntityCombinationFurnace.isItemFuel(stack);
	}
	
	@Override
	public int getItemStackLimit (ItemStack stack)
	{
		return super.getItemStackLimit(stack);
	}
}
