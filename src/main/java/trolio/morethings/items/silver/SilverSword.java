package trolio.morethings.items.silver;

import net.minecraft.item.ItemSword;
import trolio.morethings.util.handlers.CreativeTabHandler;

public class SilverSword extends ItemSword
{
	public SilverSword (String name, ToolMaterial material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabHandler.tabWeapons);
	}
}
