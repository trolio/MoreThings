package trolio.morethings.items.steel;

import net.minecraft.item.Item;
import trolio.morethings.util.handlers.CreativeTabHandler;

public class SteelIngot extends Item
{
	public SteelIngot (String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabHandler.tabMetals);
	}
}
