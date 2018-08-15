package trolio.morethings.blocks.CombinationFurnace;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import trolio.morethings.blocks.CombinationFurnace.slots.SlotCombinationFurnaceFuel;
import trolio.morethings.blocks.CombinationFurnace.slots.SlotCombinationFurnaceOutput;

public class ContainerCombinationFurnace  extends Container
{
	private final TileEntityCombinationFurnace tileEntity;
	private int cookTime, totalCookTime, burnTime, currentBurnTime;
	
	public ContainerCombinationFurnace(InventoryPlayer player, TileEntityCombinationFurnace tileEntity) 
	{
		this.tileEntity = tileEntity;
		
		addSlotToContainer(new Slot(tileEntity, 0, 26, 11));
		addSlotToContainer(new Slot(tileEntity, 1, 26, 59));
		addSlotToContainer(new SlotCombinationFurnaceFuel(tileEntity, 2, 7, 35));
		addSlotToContainer(new SlotCombinationFurnaceOutput(player.player, tileEntity, 3, 81, 36));
		
		for(int y = 0; y < 3; y++)
		{
			for(int x = 0; x < 9; x++)
			{
				addSlotToContainer(new Slot(player, x + y*9 + 9, 8 + x*18, 84 + y*18));
			}
		}
		
		for(int x = 0; x < 9; x++)
		{
			addSlotToContainer(new Slot(player, x, 8 + x * 18, 142));
		}
	}
	
	@Override
	public void addListener(IContainerListener listener) 
	{
		super.addListener(listener);
		listener.sendAllWindowProperties(this, tileEntity);
	}
	
	@Override
	public void detectAndSendChanges() 
	{
		super.detectAndSendChanges();
		
		for(int i = 0; i < listeners.size(); ++i) 
		{
			IContainerListener listener = (IContainerListener)listeners.get(i);
			
			if(cookTime != tileEntity.getField(2))
			{
				listener.sendWindowProperty(this, 2, tileEntity.getField(2));
			}
			
			if(burnTime != tileEntity.getField(0))
			{
				listener.sendWindowProperty(this, 0, tileEntity.getField(0));
			}
			
			if(currentBurnTime != tileEntity.getField(1))
			{
				listener.sendWindowProperty(this, 1, tileEntity.getField(1));
			}
			if(totalCookTime != tileEntity.getField(3))
			{
				listener.sendWindowProperty(this, 3, tileEntity.getField(3));
			}
		}
		
		cookTime = tileEntity.getField(2);
		burnTime = tileEntity.getField(0);
		currentBurnTime = tileEntity.getField(1);
		totalCookTime = tileEntity.getField(3);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int id, int data) 
	{
		tileEntity.setField(id, data);
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) 
	{
		return tileEntity.isUsableByPlayer(player);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int index) 
	{
		ItemStack stack = ItemStack.EMPTY;
		Slot slot = (Slot)inventorySlots.get(index);
		
		if(slot != null && slot.getHasStack()) 
		{
			ItemStack stack1 = slot.getStack();
			stack = stack1.copy();
			
			if(index == 3) 
			{
				if(!mergeItemStack(stack1, 4, 40, true))
				{
					return ItemStack.EMPTY;
				}
				slot.onSlotChange(stack1, stack);
			}
			else if(index != 2 && index != 1 && index != 0) 
			{		
				Slot slot1 = (Slot)inventorySlots.get(index + 1);
				
				if(!CombinationFurnaceRecipes.getInstance().getCombinationResult(stack1, slot1.getStack()).isEmpty())
				{
					if(!mergeItemStack(stack1, 0, 2, false)) 
					{
						return ItemStack.EMPTY;
					}
					else if(TileEntityCombinationFurnace.isItemFuel(stack1))
					{
						if(!mergeItemStack(stack1, 2, 3, false))
						{
							return ItemStack.EMPTY;
						}
					}
					else if(TileEntityCombinationFurnace.isItemFuel(stack1))
					{
						if(!mergeItemStack(stack1, 2, 3, false))
						{
							return ItemStack.EMPTY;
						}
					}
					else if(TileEntityCombinationFurnace.isItemFuel(stack1))
					{
						if(!mergeItemStack(stack1, 2, 3, false))
						{
							return ItemStack.EMPTY;
						}
					}
					else if(index >= 4 && index < 31)
					{
						if(!mergeItemStack(stack1, 31, 40, false))
						{
							return ItemStack.EMPTY;
						}
					}
					else if(index >= 31 && index < 40 && !mergeItemStack(stack1, 4, 31, false))
					{
						return ItemStack.EMPTY;
					}
				}
			} 
			else if(!mergeItemStack(stack1, 4, 40, false)) 
			{
				return ItemStack.EMPTY;
			}
			if(stack1.isEmpty())
			{
				slot.putStack(ItemStack.EMPTY);
			}
			else
			{
				slot.onSlotChanged();

			}
			if(stack1.getCount() == stack.getCount())
			{
				return ItemStack.EMPTY;
			}
			slot.onTake(player, stack1);
		}
		return stack;
	}
}
