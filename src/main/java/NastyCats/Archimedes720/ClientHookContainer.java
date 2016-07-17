package NastyCats.Archimedes720;

import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import NastyCats.Archimedes720.entity.EntityShip;
import NastyCats.Archimedes720.network.MsgRequestShipData;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientHookContainer extends CommonHookContainer
{
	@SubscribeEvent
	public void onEntitySpawn(EntityJoinWorldEvent event)
	{
		if (event.world.isRemote && event.entity instanceof EntityShip)
		{
			if (((EntityShip) event.entity).getShipChunk().chunkTileEntityMap.isEmpty())
			{
				return;
			}
			
			MsgRequestShipData msg = new MsgRequestShipData((EntityShip) event.entity);
			ArchimedesShipMod.instance.pipeline.sendToServer(msg);
		}
	}
}
