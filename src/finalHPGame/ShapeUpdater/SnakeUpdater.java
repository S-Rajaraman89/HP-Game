package finalHPGame.ShapeUpdater;

import org.newdawn.slick.geom.Rectangle;

import finalHPGame.Location.Location;

public class SnakeUpdater implements ShapeUpdater {


	public void update(Rectangle s, int direction, Location loc) {
	s.setBounds(new Rectangle(loc.getX()+40,loc.getY()+8,16,73));
	}

}
