package trolio.morethings.items.copper;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemTool;
import trolio.morethings.util.handlers.CreativeTabHandler;

public class CopperAxe extends ItemTool
{
	private static final Set<Block> effectiveOn = Sets.newHashSet(Blocks.OAK_DOOR, Blocks.OAK_FENCE, Blocks.OAK_FENCE_GATE, Blocks.OAK_STAIRS, Blocks.LOG, Blocks.PLANKS, Blocks.CRAFTING_TABLE);
	
	public CopperAxe(String name, ToolMaterial material)
	{
		super (material, effectiveOn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabHandler.tabTools);
	}
}
