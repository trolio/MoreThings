package trolio.morethings.items.emerald;

import net.minecraft.item.ItemHoe;
import trolio.morethings.util.handlers.CreativeTabHandler;

public class EmeraldHoe extends ItemHoe
{
	public EmeraldHoe (String name, ToolMaterial material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabHandler.tabTools);
	}
}
