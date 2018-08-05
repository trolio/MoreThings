package trolio.morethings.items.obsidian;

import net.minecraft.item.ItemPickaxe;
import trolio.morethings.Main;
import trolio.morethings.init.ModItems;
import trolio.morethings.util.IHasModel;
import trolio.morethings.util.handlers.CreativeTabHandler;

public class ObsidianPickaxe extends ItemPickaxe
{
	public ObsidianPickaxe(String name, ToolMaterial material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabHandler.tabTools);
	}
}
