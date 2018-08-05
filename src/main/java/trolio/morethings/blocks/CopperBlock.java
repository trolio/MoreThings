package trolio.morethings.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import trolio.morethings.util.handlers.CreativeTabHandler;

public class CopperBlock extends Block
{
	public CopperBlock (String name)
	{
		super(Material.IRON);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabHandler.tabBlocks);
	}
}
