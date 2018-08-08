package trolio.morethings.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import trolio.morethings.blocks.CopperBlock;
import trolio.morethings.blocks.SilverBlock;
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
		registerBlock(oreCopper);
		registerBlock(oreTin);
		registerBlock(oreSilver);
	}
	
	public static void registerBlock (Block block)
	{
		ForgeRegistries.BLOCKS.register(block);
		ItemBlock item = new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		ForgeRegistries.ITEMS.register(item);
		
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}
	
	public static void registerBlock (Block block, ItemBlock itemblock)
	{
		ForgeRegistries.BLOCKS.register(block);
		itemblock.setRegistryName(block.getRegistryName());
		ForgeRegistries.ITEMS.register(itemblock);
		
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}
}
