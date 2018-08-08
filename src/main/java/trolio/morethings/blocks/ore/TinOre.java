package trolio.morethings.blocks.ore;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import trolio.morethings.util.handlers.CreativeTabHandler;

public class TinOre extends Block
{
	public TinOre (String name, Material material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabHandler.tabBlocks);
		setHardness(20);
		setResistance(10);
	}
}
