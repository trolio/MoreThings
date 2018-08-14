package trolio.morethings.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import trolio.morethings.Main;
import trolio.morethings.init.ModBlocks;
import trolio.morethings.init.ModItems;
import trolio.morethings.util.handlers.CreativeTabHandler;

public abstract class GlassSlab extends BlockSlab
{
	public GlassSlab (String name)
	{
		super(Material.GLASS);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabHandler.tabBlocks);
		
		
		IBlockState state = this.blockState.getBaseState();
		
		if (!this.isDouble())
		{
			state = state.withProperty(HALF, EnumBlockHalf.BOTTOM);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.TRANSLUCENT;
	}
	
	@Override
	public boolean shouldSideBeRendered (IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
	{
		return true;
	}
	
	@Override
	public boolean doesSideBlockRendering (IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face)
	{
		return false;
	}
	
	@Override
	public int getLightOpacity (IBlockState state)
	{
		return 0;
	}
	
	@Override
	public boolean isOpaqueCube (IBlockState state)
	{
		return false;
	}
	
	@Override
	public boolean isFullCube (IBlockState state)
	{
		return false;
	}
	
	@Override
	public String getUnlocalizedName (int meta)
	{
		return this.getUnlocalizedName();
	}
	
	@Override
	public IProperty<?> getVariantProperty()
	{
		return HALF;
	}
	
	@Override
	public Comparable<?> getTypeForItem (ItemStack stack)
	{
		return EnumBlockHalf.BOTTOM;
	}
	
	@Override
	public int damageDropped (IBlockState state)
	{
		return 0;
	}
	
	@Override
	public IBlockState getStateFromMeta (int meta)
	{
		if (!this.isDouble())
		{
			return this.getDefaultState().withProperty(HALF, EnumBlockHalf.values()[meta % EnumBlockHalf.values().length]);
		}
		return this.getDefaultState();
	}
	
	@Override
	public int getMetaFromState (IBlockState state)
	{
		if (!this.isDouble())
		{
			return 0;
		}
		return ((EnumBlockHalf)state.getValue(HALF)).ordinal() + 1;
	}
	
	@Override
	public Item getItemDropped (IBlockState state, Random rand, int fortune)
	{
		return Item.getItemFromBlock(ModBlocks.slabWhiteGlassHalf);
	}
	
	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] { HALF });
	}
}
