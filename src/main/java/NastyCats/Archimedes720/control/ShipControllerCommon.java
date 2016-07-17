package NastyCats.Archimedes720.control;

import net.minecraft.entity.player.EntityPlayer;
import NastyCats.Archimedes720.entity.EntityShip;

public class ShipControllerCommon
{
	private int	shipControl	= 0;
	
	public void updateControl(EntityShip ship, EntityPlayer player, int i)
	{
		shipControl = i;
	}
	
	public int getShipControl()
	{
		return shipControl;
	}
}
