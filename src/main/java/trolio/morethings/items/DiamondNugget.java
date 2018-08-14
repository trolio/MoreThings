package trolio.morethings.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import trolio.morethings.Main;
import trolio.morethings.init.ModItems;
import trolio.morethings.util.handlers.CreativeTabHandler;

public class DiamondNugget extends Item
{
	public DiamondNugget(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabHandler.tabMetals);
	}
}
