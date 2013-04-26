package finalHPGame.ShapeUpdater;

import org.newdawn.slick.geom.Rectangle;
import finalHPGame.Location.Location;

public interface ShapeUpdater {
	/**Updates personal to match the Character*/
public void update(Rectangle s, int direction, Location loc);
}
