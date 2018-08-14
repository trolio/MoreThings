package trolio.morethings.items.obsidian;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemTool;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.item.Item.ToolMaterial;
import trolio.morethings.Main;
import trolio.morethings.init.ModItems;
import trolio.morethings.util.handlers.CreativeTabHandler;

public class ObsidianShovel extends ItemTool
{
	
	private static final Set<Block> effectiveOn = Sets.newHashSet(Blocks.SAND, Blocks.GRAVEL, Blocks.DIRT, Blocks.GRASS);
	
	public ObsidianShovel(String name, ToolMaterial material)
	{
		super(material, effectiveOn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabHandler.tabTools);
	}
}
