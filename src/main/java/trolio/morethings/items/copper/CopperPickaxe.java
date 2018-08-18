package trolio.morethings.items.copper;

import net.minecraft.item.ItemPickaxe;
import trolio.morethings.util.handlers.CreativeTabHandler;

public class CopperPickaxe extends ItemPickaxe
{
	public CopperPickaxe (String name, ToolMaterial material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabHandler.tabTools);
	}
}
