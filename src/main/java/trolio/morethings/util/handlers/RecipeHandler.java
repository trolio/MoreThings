package trolio.morethings.util.handlers;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import trolio.morethings.init.ModBlocks;
import trolio.morethings.init.ModItems;

public class RecipeHandler 
{
	public static void registerSmeltingRecipe()
	{
		GameRegistry.addSmelting(Blocks.OBSIDIAN, new ItemStack(ModItems.ingotObsidian), 5);
		GameRegistry.addSmelting(ModBlocks.oreCopper, new ItemStack(ModItems.ingotCopper), 3);
		GameRegistry.addSmelting(ModBlocks.oreTin, new ItemStack(ModItems.ingotTin), 3);
		GameRegistry.addSmelting(ModBlocks.oreSilver, new ItemStack(ModItems.ingotSilver), 3);
		
	}
}
