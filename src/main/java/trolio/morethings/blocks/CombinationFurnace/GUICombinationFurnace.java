package trolio.morethings.blocks.CombinationFurnace;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import trolio.morethings.util.Reference;

public class GUICombinationFurnace extends GuiContainer
{
	private static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/gui/furnace_combination");
	
	private final InventoryPlayer player;
	private final TileEntityCombinationFurnace tileEntity;
	
	public GUICombinationFurnace(InventoryPlayer player, TileEntityCombinationFurnace tileEntity) 
	{
		super(new ContainerCombinationFurnace(player, tileEntity));
		this.player = player;
		this.tileEntity = tileEntity;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) 
	{
		String tileName = tileEntity.getDisplayName().getUnformattedText();
		fontRenderer.drawString(tileName, (xSize / 2 - fontRenderer.getStringWidth(tileName) / 2) + 3, 8, 4210752);
		fontRenderer.drawString(player.getDisplayName().getUnformattedText(), 122, ySize - 96 + 2, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer (float partialTicks, int mouseX, int mouseY)
	{
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		
		mc.getTextureManager().bindTexture(TEXTURES);
		
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		if (TileEntityCombinationFurnace.isBurning(tileEntity))
		{
			int k = getBurnLeftScaled(13);
			drawTexturedModalRect(guiLeft + 8, guiTop + 54 + 12 - k, 176, 12 - k, 14, k + 1);
		}
		
		int l = getCookProgressScaled(24);
		drawTexturedModalRect(guiLeft + 44, guiTop + 36, 176, 14, l + 1, 16);
	}
	
	private int getBurnLeftScaled(int pixels)
	{
		int i = tileEntity.getField(1);
		
		if (i == 0)
		{
			i = 200;
		}
		return tileEntity.getField(0) * pixels / i;
	}
	
	private int getCookProgressScaled (int pixels)
	{
		int i = tileEntity.getField(2);
		int j = tileEntity.getField(3);
		return j != 0 && i != 0 ? i * pixels / j : 0;
	}
}
