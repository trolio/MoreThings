package trolio.morethings.items.copper;

import net.minecraft.item.Item;
import trolio.morethings.util.handlers.CreativeTabHandler;

public class CopperIngot extends Item
{
	public CopperIngot(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabHandler.tabMetals);
	}
}
