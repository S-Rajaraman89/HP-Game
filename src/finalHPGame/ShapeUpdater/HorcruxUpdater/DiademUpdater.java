package finalHPGame.ShapeUpdater.HorcruxUpdater;

import org.newdawn.slick.geom.Rectangle;

import finalHPGame.Location.Location;
import finalHPGame.ShapeUpdater.ShapeUpdater;

public class DiademUpdater implements ShapeUpdater {

	public void update(Rectangle s, int direction, Location myLoc) {
		s.setBounds(new Rectangle(myLoc.getX()+19,myLoc.getY()+39,63,45));
	}

}
