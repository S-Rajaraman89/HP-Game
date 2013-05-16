package finalHPGame.ShapeUpdater.HorcruxUpdater;

import org.newdawn.slick.geom.Rectangle;

import finalHPGame.Location.Location;
import finalHPGame.ShapeUpdater.ShapeUpdater;

public class DiademUpdater implements ShapeUpdater {

	public void update(Rectangle s, int direction, Location myLoc) {
		// TODO Auto-generated method stub
		s.setBounds(new Rectangle(myLoc.getX()+25,myLoc.getY()+15,35,60));
	}

}
