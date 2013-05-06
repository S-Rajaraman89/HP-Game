package finalHPGame.ShapeUpdater.CharacterUpdater;

import org.newdawn.slick.geom.Rectangle;

import finalHPGame.Location.Location;
import finalHPGame.ShapeUpdater.ShapeUpdater;

public class SnakeUpdater implements ShapeUpdater {

	/**Updates personal to match the Snake*/
	@Override
	public void update(Rectangle s, int direction, Location loc) {
	s.setBounds(new Rectangle(loc.getX()+40,loc.getY()+8,16,73));
	}

}
