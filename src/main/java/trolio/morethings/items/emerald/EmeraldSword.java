package trolio.morethings.items.emerald;

import net.minecraft.item.ItemSword;
import trolio.morethings.util.handlers.CreativeTabHandler;

public class EmeraldSword extends ItemSword
{
	public EmeraldSword (String name, ToolMaterial material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabHandler.tabWeapons);
	}
}
