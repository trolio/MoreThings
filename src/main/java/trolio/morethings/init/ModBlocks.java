package trolio.morethings.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;
import trolio.morethings.blocks.CopperBlock;
import trolio.morethings.blocks.SilverBlock;
import trolio.morethings.blocks.SteelBlock;
import trolio.morethings.blocks.TinBlock;
import trolio.morethings.blocks.ore.CopperOre;
import trolio.morethings.blocks.ore.SilverOre;
import trolio.morethings.blocks.ore.TinOre;
import trolio.morethings.blocks.slabs.WhiteGlassDoubleSlab;
import trolio.morethings.blocks.slabs.WhiteGlassHalfSlab;

public class ModBlocks 
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	//slabs
	public static WhiteGlassHalfSlab slabWhiteGlassHalf;
	public static WhiteGlassDoubleSlab slabWhiteGlassDouble;
	
	public static Block blockCopper;
	public static Block blockTin;
	public static Block blockSilver;
	public static Block blockSteel;
	
	public static Block oreCopper;
	public static Block oreTin;
	public static Block oreSilver;
	
	public static void init()
	{
		slabWhiteGlassHalf = new WhiteGlassHalfSlab("slab_whiteglass_half");
		slabWhiteGlassDouble = new WhiteGlassDoubleSlab("slab_whiteglass_double");
		
		blockCopper = new CopperBlock("block_copper", Material.IRON);
		blockTin = new TinBlock("block_tin", Material.IRON);
		blockSilver = new SilverBlock("block_silver", Material.IRON);
		blockSteel = new SteelBlock ("block_steel", Material.IRON);
		
		oreCopper = new CopperOre("ore_copper", Material.IRON);
		oreTin = new TinOre("ore_tin", Material.IRON);
		oreSilver = new SilverOre("ore_silver", Material.IRON);
	}
	
	public static void register()
	{
		registerBlock(slabWhiteGlassHalf, new ItemSlab(slabWhiteGlassHalf, slabWhiteGlassHalf, slabWhiteGlassDouble));
		
		registerBlock(blockCopper);
		registerBlock(blockTin);
		registerBlock(blockSilver);
		registerBlock(blockSteel);
		
		registerBlock(oreCopper);
		registerBlock(oreTin);
		registerBlock(oreSilver);
	}
	
	private static void registerBlock (Block block)
	{
		registerBlock(block, new ItemBlock(block));
	}
	
	private static void registerBlock(Block block, ItemBlock item)
	{
		if(block.getRegistryName() == null)
		{
			throw new IllegalArgumentException ("A block being registered does not have a registry name and could be successfully registered.");
		}
		RegistrationHandler.Blocks.add(block);
		
		if (item != null)
		{
			item.setRegistryName(block.getRegistryName());
			RegistrationHandler.Items.add(item);
		}
	}
}
