package trolio.morethings.items.silver;

import net.minecraft.item.Item;
import trolio.morethings.util.handlers.CreativeTabHandler;

public class SilverIngot extends Item
{
	public SilverIngot (String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabHandler.tabMetals);
	}
}
