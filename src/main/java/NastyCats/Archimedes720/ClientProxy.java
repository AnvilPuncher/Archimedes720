package NastyCats.Archimedes720;

import NastyCats.Archimedes720.blockitem.BlockGauge;
import NastyCats.Archimedes720.blockitem.BlockSeat;
import NastyCats.Archimedes720.blockitem.TileEntityGauge;
import NastyCats.Archimedes720.control.ShipKeyHandler;
import NastyCats.Archimedes720.entity.EntityParachute;
import NastyCats.Archimedes720.entity.EntityShip;
import NastyCats.Archimedes720.render.RenderBlockGauge;
import NastyCats.Archimedes720.render.RenderBlockSeat;
import NastyCats.Archimedes720.render.RenderParachute;
import NastyCats.Archimedes720.render.RenderShip;
import NastyCats.Archimedes720.render.TileEntityGaugeRenderer;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;

public class ClientProxy extends CommonProxy
{
	public ShipKeyHandler	shipKeyHandler;
	
	@Override
	public ClientHookContainer getHookContainer()
	{
		return new ClientHookContainer();
	}
	
	@Override
	public void registerKeyHandlers(ArchimedesConfig cfg)
	{
		shipKeyHandler = new ShipKeyHandler(cfg);
		FMLCommonHandler.instance().bus().register(shipKeyHandler);
	}
	
	@Override
	public void registerRenderers()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityShip.class, new RenderShip());
		RenderingRegistry.registerEntityRenderingHandler(EntityParachute.class, new RenderParachute());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGauge.class, new TileEntityGaugeRenderer());
		//ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHelm.class, new TileEntityHelmRenderer());
		BlockGauge.gaugeBlockRenderID = RenderingRegistry.getNextAvailableRenderId();
		BlockSeat.seatBlockRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(BlockSeat.seatBlockRenderID, new RenderBlockSeat());
		RenderingRegistry.registerBlockHandler(BlockGauge.gaugeBlockRenderID, new RenderBlockGauge());
	}
}
