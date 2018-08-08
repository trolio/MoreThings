package trolio.morethings.blocks.ore;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import trolio.morethings.util.IMetaBlockName;
import trolio.morethings.util.handlers.CreativeTabHandler;
import trolio.morethings.util.handlers.EnumHandler;
import trolio.morethings.util.handlers.EnumHandler.OreType;

public class CopperOre extends Block implements IMetaBlockName
{
	public static final PropertyEnum TYPE = PropertyEnum.create("type", OreType.class);
	public CopperOre (String name, Material material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabHandler.tabBlocks);
	}
	
	@Override
	public int damageDropped(IBlockState state) 
	{
		return getMetaFromState(state);
	}
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) 
	{
		return new ItemStack(Item.getItemFromBlock(this), 1, getMetaFromState(state));
	}
	
	@Override
	protected BlockStateContainer createBlockState() 
	{
		return new BlockStateContainer(this, new IProperty[] { TYPE });
	}
	
	@Override
	public int getMetaFromState(IBlockState state) 
	{
		OreType type = (OreType) state.getValue(TYPE);
		return type.getID();
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) 
	{
		return this.getDefaultState().withProperty(TYPE, OreType.values()[meta]);
	}
	
	@Override
	public String getSpecialName(ItemStack stack) 
	{
		return OreType.values()[stack.getItemDamage()].getName();
	}
}
