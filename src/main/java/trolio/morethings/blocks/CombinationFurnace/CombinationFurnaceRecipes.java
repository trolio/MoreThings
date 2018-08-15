package trolio.morethings.blocks.CombinationFurnace;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;

import net.minecraft.item.ItemStack;
import trolio.morethings.init.ModItems;

public class CombinationFurnaceRecipes 
{
	private static final CombinationFurnaceRecipes INSTANCE = new CombinationFurnaceRecipes();
	
	private final Table<ItemStack, ItemStack, ItemStack> smeltingList = HashBasedTable.<ItemStack, ItemStack, ItemStack>create();
	
	private final Map<ItemStack, Float> xpList = Maps.<ItemStack, Float>newHashMap();
	
	public static CombinationFurnaceRecipes getInstance()
	{
		return INSTANCE;
	}
	
	private CombinationFurnaceRecipes()
	{
		addCombinationRecipe(new ItemStack(ModItems.ingotSilver), new ItemStack(ModItems.ingotTin), new ItemStack(ModItems.ingotSteel), 5.0F);
	}
	
	public void addCombinationRecipe(ItemStack input1, ItemStack input2, ItemStack result, float xp)
	{
		if (getCombinationResult(input1, input2) != ItemStack.EMPTY)
		{
			return;
		}
		smeltingList.put(input1, input2, result);
		xpList.put(result, Float.valueOf(xp));
	}
	
	public ItemStack getCombinationResult (ItemStack input1, ItemStack input2)
	{
		for (Entry<ItemStack, Map<ItemStack, ItemStack>> entry : smeltingList.columnMap().entrySet())
		{
			if (compareItemStacks(input1, (ItemStack)entry.getKey()))
			{
				for (Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet())
				{
					if (compareItemStacks(input2, (ItemStack)ent.getKey()))
					{
						return (ItemStack)ent.getValue();
					}
				}
			}
		}
		return ItemStack.EMPTY;
	}
	
	private boolean compareItemStacks (ItemStack stack1, ItemStack stack2)
	{
		return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
	}
	
	public Table<ItemStack, ItemStack, ItemStack> getDualSmeltingList()
	{
		return smeltingList;
	}
	
	public float getCombinationXp (ItemStack stack)
	{
		for (Entry<ItemStack, Float> entry : xpList.entrySet())
		{
			if (compareItemStacks (stack, (ItemStack)entry.getKey()))
			{
				return ((Float)entry.getValue()).floatValue();
			}
		}
		return 0.0F;
	}
}
