package trolio.morethings.blocks.slabs;

import trolio.morethings.blocks.GlassSlab;

public class WhiteGlassDoubleSlab extends GlassSlab
{
	public WhiteGlassDoubleSlab (String name)
	{
		super(name);
	}
	
	@Override
	public boolean isDouble()
	{
		return true;
	}
}
