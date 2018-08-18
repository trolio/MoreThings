package trolio.morethings.util.handlers;

import net.minecraftforge.fml.common.registry.GameRegistry;
import trolio.morethings.blocks.machines.TileEntitySinteringFurnace;

public class TileEntityHandler 
{
	public static void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntitySinteringFurnace.class, "sintering_furnace");
	}
}
