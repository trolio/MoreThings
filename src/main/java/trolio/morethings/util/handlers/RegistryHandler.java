package trolio.morethings.util.handlers;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import trolio.morethings.Main;
import trolio.morethings.init.ModBlocks;
import trolio.morethings.init.ModItems;

public class RegistryHandler 
{
	public static void Client()
	{
		RecipeHandler.registerSmeltingRecipe();
		NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
	}
	
	public static void Common()
	{
		ModItems.init();
		ModItems.register();
		
		ModBlocks.init();
		ModBlocks.register();
	}	
}
