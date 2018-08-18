package trolio.morethings.util.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import trolio.morethings.blocks.machines.ContainerSinteringFurnace;
import trolio.morethings.blocks.machines.GuiSinteringFurnace;
import trolio.morethings.blocks.machines.TileEntitySinteringFurnace;
import trolio.morethings.util.Reference;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement (int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if (ID == Reference.GUI_SINTERING_FURNACE)
		{
			return new ContainerSinteringFurnace(player.inventory, (TileEntitySinteringFurnace)world.getTileEntity(new BlockPos(x, y, z)));
		}
		return null;
	}
	
	@Override
	public Object getClientGuiElement (int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if (ID == Reference.GUI_SINTERING_FURNACE)
		{
			return new GuiSinteringFurnace (player.inventory, (TileEntitySinteringFurnace)world.getTileEntity(new BlockPos(x, y, z)));
		}
		return null;
	}
}
