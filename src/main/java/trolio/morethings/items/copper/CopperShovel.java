package trolio.morethings.items.copper;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemTool;
import trolio.morethings.util.handlers.CreativeTabHandler;

public class CopperShovel extends ItemTool
{
	private static final Set<Block> effectiveOn = Sets.newHashSet(Blocks.SAND, Blocks.GRAVEL, Blocks.DIRT, Blocks.GRASS);
	
	public CopperShovel (String name, ToolMaterial material)
	{
		super(material, effectiveOn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabHandler.tabTools);
	}
}
