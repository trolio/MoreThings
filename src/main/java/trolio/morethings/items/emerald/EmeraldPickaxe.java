package trolio.morethings.items.emerald;

import net.minecraft.item.ItemPickaxe;
import trolio.morethings.util.handlers.CreativeTabHandler;

public class EmeraldPickaxe extends ItemPickaxe
{
	public EmeraldPickaxe (String name, ToolMaterial material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabHandler.tabTools);
	}
}
