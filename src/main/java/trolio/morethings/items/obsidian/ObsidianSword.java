package trolio.morethings.items.obsidian;

import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import trolio.morethings.Main;
import trolio.morethings.init.ModItems;
import trolio.morethings.util.IHasModel;
import trolio.morethings.util.handlers.CreativeTabHandler;

public class ObsidianSword extends ItemSword
{
	public ObsidianSword(String name, ToolMaterial material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabHandler.tabWeapons);
	}
}
