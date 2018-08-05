package trolio.morethings.items.obsidian;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import trolio.morethings.Main;
import trolio.morethings.init.ModItems;
import trolio.morethings.util.IHasModel;
import trolio.morethings.util.handlers.CreativeTabHandler;

public class ObsidianIngot extends Item
{
	public ObsidianIngot(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabHandler.tabMetals);
	}
}
