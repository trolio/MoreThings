package trolio.morethings.init;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import trolio.morethings.items.DiamondNugget;
import trolio.morethings.items.copper.CopperIngot;
import trolio.morethings.items.emerald.EmeraldArmor;
import trolio.morethings.items.emerald.EmeraldAxe;
import trolio.morethings.items.emerald.EmeraldHoe;
import trolio.morethings.items.emerald.EmeraldNugget;
import trolio.morethings.items.emerald.EmeraldPickaxe;
import trolio.morethings.items.emerald.EmeraldShovel;
import trolio.morethings.items.emerald.EmeraldSword;
import trolio.morethings.items.obsidian.ObsidianArmor;
import trolio.morethings.items.obsidian.ObsidianAxe;
import trolio.morethings.items.obsidian.ObsidianHoe;
import trolio.morethings.items.obsidian.ObsidianIngot;
import trolio.morethings.items.obsidian.ObsidianNugget;
import trolio.morethings.items.obsidian.ObsidianPickaxe;
import trolio.morethings.items.obsidian.ObsidianShovel;
import trolio.morethings.items.obsidian.ObsidianSword;
import trolio.morethings.items.silver.SilverIngot;
import trolio.morethings.items.steel.SteelIngot;
import trolio.morethings.items.tin.TinIngot;
import trolio.morethings.util.Reference;
import trolio.morethings.util.handlers.RegistryHandler;

public class ModItems 
{
	//items
	public static Item nuggetDiamond;
	public static Item ingotObsidian;
	public static Item nuggetObsidian;
	public static Item nuggetEmerald;
	public static Item ingotCopper;
	public static Item ingotTin;
	public static Item ingotSilver;
	public static Item ingotSteel;
	
	//weapons
	public static Item swordObsidian;
	public static Item swordEmerald;
	
	//tools
	public static Item pickaxeObsidian;
	public static Item shovelObsidian;
	public static Item axeObsidian;
	public static Item hoeObsidian;
	
	public static Item pickaxeEmerald;
	public static Item shovelEmerald;
	public static Item axeEmerald;
	public static Item hoeEmerald;
	
	//armor
	public static Item helmetObsidian;
	public static Item chestplateObsidian;
	public static Item leggingsObsidian;
	public static Item bootsObsidian;
	
	public static Item helmetEmerald;
	public static Item chestplateEmerald;
	public static Item leggingsEmerald;
	public static Item bootsEmerald;
	
	//tool materials
	public static ToolMaterial toolObsidian = EnumHelper.addToolMaterial("tool_obsidian", 3, 3122, 12.0F, 6.0F, 15);
	public static ToolMaterial toolEmerald = EnumHelper.addToolMaterial("tool_emerald", 3, 2500, 11.0F, 4.0F, 15);
	
	//armor materials
	public static final ArmorMaterial armorObsidian = EnumHelper.addArmorMaterial("armor_obsidian", Reference.MODID + ":obsidian", 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);	
	public static final ArmorMaterial armorEmerald = EnumHelper.addArmorMaterial("armor_emerald", Reference.MODID + ":emerald", 22, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);
	
	public static void init()
	{
		nuggetDiamond = new DiamondNugget("nugget_diamond");
		ingotObsidian = new ObsidianIngot("ingot_obsidian");
		nuggetObsidian = new ObsidianNugget("nugget_obsidian");
		nuggetEmerald = new EmeraldNugget("nugget_emerald");
		ingotCopper = new CopperIngot("ingot_copper");
		ingotTin = new TinIngot("ingot_tin");
		ingotSilver = new SilverIngot("ingot_silver");
		ingotSteel = new SteelIngot("ingot_steel");
		
		swordObsidian = new ObsidianSword("sword_obsidian", toolObsidian);
		swordEmerald = new EmeraldSword("sword_emerald", toolEmerald);
		
		pickaxeObsidian = new ObsidianPickaxe("pickaxe_obsidian", toolObsidian);
		shovelObsidian = new ObsidianShovel("shovel_obsidian", toolObsidian);
		axeObsidian = new ObsidianAxe("axe_obsidian", toolObsidian);
		hoeObsidian = new ObsidianHoe("hoe_obsidian", toolObsidian);
		
		pickaxeEmerald = new EmeraldPickaxe("pickaxe_emerald", toolEmerald);
		shovelEmerald = new EmeraldShovel("shovel_emerald", toolEmerald);
		axeEmerald = new EmeraldAxe("axe_emerald", toolEmerald);
		hoeEmerald = new EmeraldHoe("hoe_emerald", toolEmerald);
		
		helmetObsidian = new ObsidianArmor("helmet_obsidian", armorObsidian, 1, EntityEquipmentSlot.HEAD);
		chestplateObsidian = new ObsidianArmor("chestplate_obsidian", armorObsidian, 1, EntityEquipmentSlot.CHEST);
		leggingsObsidian = new ObsidianArmor("leggings_obsidian", armorObsidian, 1, EntityEquipmentSlot.LEGS);
		bootsObsidian = new ObsidianArmor("boots_obsidian", armorObsidian, 1, EntityEquipmentSlot.FEET);		
		
		helmetEmerald = new EmeraldArmor("helmet_emerald", armorEmerald, 1, EntityEquipmentSlot.HEAD);
		chestplateEmerald = new EmeraldArmor("chestplate_emerald", armorEmerald, 1, EntityEquipmentSlot.CHEST);
		leggingsEmerald = new EmeraldArmor("leggings_emerald", armorEmerald, 1, EntityEquipmentSlot.LEGS);
		bootsEmerald = new EmeraldArmor("boots_emerald", armorEmerald, 1, EntityEquipmentSlot.FEET);
		
	}
	
	public static void register()
	{
		registerItem(nuggetDiamond);
		registerItem(ingotObsidian);
		registerItem(swordObsidian);
		registerItem(pickaxeObsidian);
		registerItem(shovelObsidian);
		registerItem(axeObsidian);
		registerItem(hoeObsidian);
		registerItem(helmetObsidian);
		registerItem(chestplateObsidian);
		registerItem(leggingsObsidian);
		registerItem(bootsObsidian);
		registerItem(nuggetObsidian);
		registerItem(nuggetEmerald);
		registerItem(swordEmerald);
		registerItem(pickaxeEmerald);
		registerItem(shovelEmerald);
		registerItem(axeEmerald);
		registerItem(hoeEmerald);
		registerItem(helmetEmerald);
		registerItem(chestplateEmerald);
		registerItem(leggingsEmerald);
		registerItem(bootsEmerald);
		registerItem(ingotCopper);
		registerItem(ingotTin);
		registerItem(ingotSilver);
		registerItem(ingotSteel);
	}
	
	private static void registerItem (Item item)
	{
		RegistrationHandler.Items.add(item);
	}
}