package trolio.morethings.blocks.CombinationFurnace.slots;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotCombinationFurnaceOutput extends Slot
{
	private final EntityPlayer player;
	
	private int removeCount;
	
	public SlotCombinationFurnaceOutput (EntityPlayer player, IInventory inventory, int index, int x, int y)
	{
		super(inventory, index, x, y);
		this.player = player;
	}
	
	@Override
	public boolean isItemValid (ItemStack stack)
	{
		return false;
	}
	
	@Override
	public ItemStack onTake (EntityPlayer player, ItemStack stack)
	{
		onCrafting(stack);
		super.onTake(player, stack);
		return stack;
	}
	
	@Override
	public ItemStack decrStackSize (int amt)
	{
		if (getHasStack())
		{
			removeCount += Math.min(amt, getStack().getCount());
		}
		return super.decrStackSize(amt);
	}
}
