package trolio.morethings.items.tin;

import net.minecraft.item.Item;
import trolio.morethings.util.handlers.CreativeTabHandler;

public class TinIngot extends Item
{
	public TinIngot (String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabHandler.tabMetals);
	}
}
