package finalHPGame.ShapeUpdater.CharacterUpdater;

import org.newdawn.slick.geom.Rectangle;

import finalHPGame.Location.Location;
import finalHPGame.ShapeUpdater.ShapeUpdater;

public class RonUpdater implements ShapeUpdater {

	public RonUpdater() {
	}

	public void update(Rectangle s, int direction, Location loc) {
		
		s.setBounds(new Rectangle(loc.getX()+40,loc.getY()+20,20,59));

	}

}
