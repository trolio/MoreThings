package trolio.morethings.items.obsidian;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemTool;
import net.minecraft.item.Item.ToolMaterial;
import trolio.morethings.Main;
import trolio.morethings.init.ModItems;
import trolio.morethings.util.handlers.CreativeTabHandler;

public class ObsidianAxe extends ItemTool
{
	private static final Set<Block> effectiveOn = Sets.newHashSet(Blocks.OAK_DOOR, Blocks.OAK_FENCE, Blocks.OAK_FENCE_GATE, Blocks.OAK_STAIRS, Blocks.LOG, Blocks.PLANKS, Blocks.CRAFTING_TABLE);
	
	public ObsidianAxe(String name, ToolMaterial material)
	{
		super(material, effectiveOn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabHandler.tabTools);
	}
}
