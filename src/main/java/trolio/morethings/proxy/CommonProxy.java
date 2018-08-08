package trolio.morethings.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import trolio.morethings.util.handlers.RegistryHandler;
import trolio.morethings.worldgen.OreGen;

public class CommonProxy 
{
	public void preInit(FMLPreInitializationEvent event)
	{
		RegistryHandler.Common();
		GameRegistry.registerWorldGenerator(new OreGen(), 0);
	}
	
	public void init(FMLInitializationEvent event)
	{
		
	}
	
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
}
