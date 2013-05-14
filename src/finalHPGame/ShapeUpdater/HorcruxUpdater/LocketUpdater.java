package finalHPGame.ShapeUpdater.HorcruxUpdater;

import org.newdawn.slick.geom.Rectangle;

import finalHPGame.Location.Location;
import finalHPGame.ShapeUpdater.ShapeUpdater;

public class LocketUpdater implements ShapeUpdater {

	public void update(Rectangle s, int direction, Location myLoc) {
		s.setBounds(new Rectangle(myLoc.getX()+29,myLoc.getY()+10,19,70));

	}

}
