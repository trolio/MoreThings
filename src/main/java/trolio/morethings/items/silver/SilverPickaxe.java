package trolio.morethings.items.silver;

import net.minecraft.item.ItemPickaxe;
import trolio.morethings.util.handlers.CreativeTabHandler;

public class SilverPickaxe extends ItemPickaxe
{
	public SilverPickaxe (String name, ToolMaterial material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabHandler.tabTools);
	}
}
