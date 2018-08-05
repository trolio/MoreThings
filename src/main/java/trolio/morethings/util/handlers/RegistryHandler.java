package trolio.morethings.util.handlers;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import trolio.morethings.init.ModBlocks;
import trolio.morethings.init.ModItems;
import trolio.morethings.util.IHasModel;

public class RegistryHandler 
{
	public static void Client()
	{
		RecipeHandler.registerSmeltingRecipe();
	}
	
	public static void Common()
	{
		ModItems.init();
		ModItems.register();
		
		ModBlocks.init();
		ModBlocks.register();
	}
}
