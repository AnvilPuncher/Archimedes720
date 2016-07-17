package NastyCats.Archimedes720.control;

import net.minecraft.entity.player.EntityPlayer;
import NastyCats.Archimedes720.ArchimedesShipMod;
import NastyCats.Archimedes720.entity.EntityShip;
import NastyCats.Archimedes720.network.MsgControlInput;

public class ShipControllerClient extends ShipControllerCommon
{
	@Override
	public void updateControl(EntityShip ship, EntityPlayer player, int i)
	{
		super.updateControl(ship, player, i);
		MsgControlInput msg = new MsgControlInput(ship, i);
		ArchimedesShipMod.instance.pipeline.sendToServer(msg);
	}
}
