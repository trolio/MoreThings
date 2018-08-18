package trolio.morethings.items.silver;

import net.minecraft.item.ItemHoe;
import trolio.morethings.util.handlers.CreativeTabHandler;

public class SilverHoe extends ItemHoe
{
	public SilverHoe (String name, ToolMaterial material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabHandler.tabTools);
	}
}
