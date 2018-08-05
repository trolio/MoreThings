package trolio.morethings.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import trolio.morethings.util.handlers.CreativeTabHandler;

public class TinBlock extends Block
{
	public TinBlock (String name, Material material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabHandler.tabBlocks);
	}
}
