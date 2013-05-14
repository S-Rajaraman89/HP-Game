package finalHPGame.ShapeUpdater.HorcruxUpdater;

import org.newdawn.slick.geom.Rectangle;

import finalHPGame.Location.Location;
import finalHPGame.ShapeUpdater.ShapeUpdater;

public class RingUpdater implements ShapeUpdater {

	public RingUpdater() {}
	
	public void update(Rectangle s, int direction, Location myLoc) {
		s.setBounds(new Rectangle(myLoc.getX()+20,myLoc.getY()+40,23,25));

	}

}
