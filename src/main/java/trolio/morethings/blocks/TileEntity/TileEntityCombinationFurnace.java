package trolio.morethings.blocks.TileEntity;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import trolio.morethings.blocks.CombinationFurnace;

public class TileEntityCombinationFurnace extends TileEntity implements IInventory, ITickable
{
	private NonNullList<ItemStack> inventory = NonNullList.<ItemStack>withSize(4, ItemStack.EMPTY);
	
	private String customName;
	
	private int burnTime;
	private int currentBurnTime;
	private int cookTime;
	private int totalCookTime;
	
	@Override
	public String getName()
	{
		return hasCustomName() ? customName : "container.furnace_combination";
	}
	
	@Override
	public boolean hasCustomName()
	{
		return customName !=null && !customName.isEmpty();
	}
	
	public void setCustomName (String customName)
	{
		this.customName = customName;
	}
	
	@Override
	public ITextComponent getDisplayName()
	{
		return hasCustomName() ? new TextComponentString(getName()) : new TextComponentTranslation(getName());
	}
	
	@Override
	public int getSizeInventory()
	{
		return inventory.size();
	}
	
	@Override
	public boolean isEmpty()
	{
		for (ItemStack stack : inventory)
		{
			if (!stack.isEmpty())
			{
				return false;
			}
		}
		return true;
	}
	
	@Override
	public ItemStack getStackInSlot (int index)
	{
		return (ItemStack)inventory.get(index);
	}
	
	@Override
	public ItemStack decrStackSize (int index, int count)
	{
		return ItemStackHelper.getAndSplit(inventory, index, count);
	}
	
	@Override
	public ItemStack removeStackFromSlot (int index)
	{
		return ItemStackHelper.getAndRemove(inventory, index);
	}
	
	@Override
	public void setInventorySlotContents (int index, ItemStack stack)
	{
		ItemStack itemStack = (ItemStack)inventory.get(index);
		boolean flag = !stack.isEmpty() && stack.isItemEqual(itemStack) && ItemStack.areItemStackTagsEqual(stack, itemStack);
		inventory.set(index, stack);
		
		if (stack.getCount() > getInventoryStackLimit())
		{
			stack.setCount(getInventoryStackLimit());
		}
		
		if (index == 0 && index + 1 == 1 && !flag)
		{
			ItemStack stack1 = (ItemStack)inventory.get(index + 1);
			totalCookTime = getCookTime (stack, stack1);
			cookTime = 0;
			markDirty();
		}
	}
	
	@Override
	public void readFromNBT (NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		inventory = NonNullList.<ItemStack>withSize(getSizeInventory(), ItemStack.EMPTY);
		ItemStackHelper.loadAllItems(compound, inventory);
		burnTime = compound.getInteger("BurnTime");
		cookTime = compound.getInteger("CookTime");
		totalCookTime = compound.getInteger("CookTimeTotal");
		currentBurnTime = getItemBurnTime((ItemStack)inventory.get(2));
		
		if (compound.hasKey("customName", 8))
		{
			setCustomName(compound.getString("CustomName"));
		}
	}
	
	@Override
	public NBTTagCompound writeToNBT (NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setInteger("BurnTime", (short)burnTime);
		compound.setInteger("CookTime", (short)cookTime);
		compound.setInteger("CookTimeTotal", (short)totalCookTime);
		ItemStackHelper.saveAllItems(compound, inventory);
		
		if (hasCustomName())
		{
			compound.setString("CustomName", customName);
		}
		return compound;
	}
	
	@Override
	public int getInventoryStackLimit()
	{
		return 64;
	}

	public boolean isBurning()
	{
		return burnTime > 0;
	}
	
	@SideOnly(Side.CLIENT)
	public static boolean isBurning (IInventory inventory)
	{
		return inventory.getField(0) > 0;
	}
	
	public void update ()
	{
		boolean flag = isBurning();
		boolean flag1 = false;
		
		if (isBurning())
		{
			--burnTime;
		}
		
		if (world.isRemote) 
		{
			ItemStack stack = (ItemStack)inventory.get(2);
			
			if(isBurning() || !stack.isEmpty() && !((((ItemStack)inventory.get(0)).isEmpty()) || ((ItemStack)inventory.get(1)).isEmpty())) 
			{
				if(!isBurning() && canSmelt()) 
				{
					burnTime = getItemBurnTime(stack);
					currentBurnTime = burnTime;
					
					if(isBurning()) 
					{
						flag1 = true;
						
						if(!stack.isEmpty()) 
						{
							Item item = stack.getItem();
							stack.shrink(1);
							
							if(stack.isEmpty()) 
							{
								ItemStack item1 = item.getContainerItem(stack);
								inventory.set(2, item1);
							}
						}
					}
				} 
				if(isBurning() && canSmelt()) 
				{
					++cookTime;
					
					if(cookTime == totalCookTime) 
					{
						cookTime = 0;
						totalCookTime = getCookTime((ItemStack)inventory.get(0), (ItemStack)inventory.get(1));
						smeltItem();
						flag1 = true;
					}
				} 
				else
				{
					cookTime = 0;
				}
			} 
			else if(!isBurning() && cookTime > 0) 
			{
				cookTime = MathHelper.clamp(cookTime - 2, 0, totalCookTime);
			}
			
			if (flag != isBurning())
			{
				flag1 = true;
				CombinationFurnace.setState(isBurning(), world, pos);
			}
		}
		
		if (flag1)
		{
			markDirty();
		}
	}
	
	public int getCookTime (ItemStack input1, ItemStack input2)
	{
		return 200;
	}
	
}
