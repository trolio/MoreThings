package trolio.morethings.util.handlers;

import java.util.LinkedList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import trolio.morethings.init.ModBlocks;
import trolio.morethings.init.ModItems;
import trolio.morethings.util.Reference;

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
