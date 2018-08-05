package trolio.morethings.blocks.slabs;

import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import trolio.morethings.blocks.GlassSlab;

public class WhiteGlassHalfSlab extends GlassSlab
{	
	public WhiteGlassHalfSlab (String name)
	{
		super(name);
		
	}
	
	@Override
	public boolean isOpaqueCube (IBlockState state)
	{
		return false;
	}
	
	@Override
	public boolean isDouble()
	{
		return false;
	}
}
