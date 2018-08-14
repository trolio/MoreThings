package trolio.morethings.items.obsidian;

import net.minecraft.item.ItemHoe;
import trolio.morethings.Main;
import trolio.morethings.init.ModItems;
import trolio.morethings.util.handlers.CreativeTabHandler;

public class ObsidianHoe extends ItemHoe
{

	public ObsidianHoe(String name, ToolMaterial material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabHandler.tabTools);
	}

}
