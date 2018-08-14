package trolio.morethings.util.handlers;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import trolio.morethings.init.ModBlocks;
import trolio.morethings.init.ModItems;

public class CreativeTabHandler 
{
	public static CreativeTabs tabMetals = new CreativeTabs ("mt_metals")
	{
		public ItemStack getTabIconItem()
		{
			return new ItemStack (ModItems.ingotObsidian);
		}
	};
	
	public static CreativeTabs tabWeapons = new CreativeTabs ("mt_weapons")
	{
		public ItemStack getTabIconItem()
		{
			return new ItemStack (ModItems.swordObsidian);
		}
	};

	public static CreativeTabs tabTools = new CreativeTabs ("mt_tools")
	{
		public ItemStack getTabIconItem()
		{
			return new ItemStack (ModItems.pickaxeObsidian);
		}
	};
	
	public static CreativeTabs tabArmor = new CreativeTabs ("mt_armor")
	{
		public ItemStack getTabIconItem()
		{
			return new ItemStack(ModItems.chestplateObsidian);
		}
	};
	
	public static CreativeTabs tabBlocks = new CreativeTabs ("mt_blocks")
	{
		public ItemStack getTabIconItem()
		{
			return new ItemStack(ModBlocks.oreCopper);
		}
	};

}
