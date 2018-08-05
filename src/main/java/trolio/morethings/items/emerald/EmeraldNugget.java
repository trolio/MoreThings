package trolio.morethings.items.emerald;

import net.minecraft.item.Item;
import trolio.morethings.util.handlers.CreativeTabHandler;

public class EmeraldNugget extends Item
{
	public EmeraldNugget(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabHandler.tabMetals);
	}
}
