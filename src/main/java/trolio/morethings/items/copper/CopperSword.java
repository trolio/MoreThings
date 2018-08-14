package trolio.morethings.items.copper;

import net.minecraft.item.ItemSword;
import trolio.morethings.util.handlers.CreativeTabHandler;

public class CopperSword extends ItemSword
{
	public CopperSword (String name, ToolMaterial material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabHandler.tabWeapons);
	}
}
