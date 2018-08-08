package trolio.morethings.blocks.ore;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import trolio.morethings.util.handlers.CreativeTabHandler;

public class SilverOre extends Block
{
	public SilverOre (String name, Material material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabHandler.tabBlocks);
		setHardness(2);
		setResistance(2);
	}
}
