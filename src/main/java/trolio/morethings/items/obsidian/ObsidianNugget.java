package trolio.morethings.items.obsidian;

import net.minecraft.item.Item;
import trolio.morethings.util.handlers.CreativeTabHandler;

public class ObsidianNugget extends Item
{
	public ObsidianNugget(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabHandler.tabMetals);
	}
}
