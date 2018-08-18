package trolio.morethings.items.copper;

import net.minecraft.item.ItemHoe;
import trolio.morethings.util.handlers.CreativeTabHandler;

public class CopperHoe extends ItemHoe
{
	public CopperHoe (String name, ToolMaterial material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabHandler.tabTools);
	}
}
