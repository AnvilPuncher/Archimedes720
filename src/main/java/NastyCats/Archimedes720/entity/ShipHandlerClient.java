package NastyCats.Archimedes720.entity;

import net.minecraft.entity.player.EntityPlayer;
import NastyCats.Archimedes720.ArchimedesShipMod;
import NastyCats.Archimedes720.network.MsgFarInteract;

public class ShipHandlerClient extends ShipHandlerCommon
{
	public ShipHandlerClient(EntityShip entityship)
	{
		super(entityship);
	}
	
	@Override
	public boolean interact(EntityPlayer player)
	{
		if (player.getDistanceSqToEntity(ship) >= 36D)
		{
			MsgFarInteract msg = new MsgFarInteract(ship);
			ArchimedesShipMod.instance.pipeline.sendToServer(msg);
		}
		
		return super.interact(player);
	}
	
	@Override
	public void onChunkUpdate()
	{
		super.onChunkUpdate();
	}
}
