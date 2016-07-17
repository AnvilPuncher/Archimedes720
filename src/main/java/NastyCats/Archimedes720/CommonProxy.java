package NastyCats.Archimedes720;

import net.minecraftforge.common.MinecraftForge;
import NastyCats.Archimedes720.gui.ASGuiHandler;
import NastyCats.Archimedes720.network.ASMessagePipeline;
import NastyCats.Archimedes720.network.MsgAssembleResult;
import NastyCats.Archimedes720.network.MsgChunkBlockUpdate;
import NastyCats.Archimedes720.network.MsgClientHelmAction;
import NastyCats.Archimedes720.network.MsgClientOpenGUI;
import NastyCats.Archimedes720.network.MsgClientRenameShip;
import NastyCats.Archimedes720.network.MsgClientShipAction;
import NastyCats.Archimedes720.network.MsgControlInput;
import NastyCats.Archimedes720.network.MsgFarInteract;
import NastyCats.Archimedes720.network.MsgRequestShipData;
import NastyCats.Archimedes720.network.MsgTileEntities;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class CommonProxy
{
	public CommonPlayerTicker	playerTicker;
	public CommonHookContainer	hookContainer;
	
	public CommonHookContainer getHookContainer()
	{
		return new CommonHookContainer();
	}
	
	public void registerPackets(ASMessagePipeline pipeline)
	{
		pipeline.registerPacket(MsgClientHelmAction.class);
		pipeline.registerPacket(MsgClientShipAction.class);
		pipeline.registerPacket(MsgClientRenameShip.class);
		pipeline.registerPacket(MsgClientOpenGUI.class);
		pipeline.registerPacket(MsgAssembleResult.class);
		pipeline.registerPacket(MsgChunkBlockUpdate.class);
		pipeline.registerPacket(MsgRequestShipData.class);
		pipeline.registerPacket(MsgTileEntities.class);
		pipeline.registerPacket(MsgControlInput.class);
		pipeline.registerPacket(MsgFarInteract.class);
	}
	
	public void registerKeyHandlers(ArchimedesConfig cfg)
	{
	}
	
	public void registerEventHandlers()
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(ArchimedesShipMod.instance, new ASGuiHandler());
		
		playerTicker = new CommonPlayerTicker();
		FMLCommonHandler.instance().bus().register(playerTicker);
		MinecraftForge.EVENT_BUS.register(hookContainer = getHookContainer());
	}
	
	public void registerRenderers()
	{
	}
	
}
