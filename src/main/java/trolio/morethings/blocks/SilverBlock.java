package trolio.morethings.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import trolio.morethings.util.handlers.CreativeTabHandler;

public class SilverBlock extends Block
{
	public SilverBlock (String name, Material material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabHandler.tabBlocks);
	}
}
