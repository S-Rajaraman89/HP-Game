package finalHPGame.ShapeUpdater.HorcruxUpdater;

import org.newdawn.slick.geom.Rectangle;

import finalHPGame.Location.Location;
import finalHPGame.ShapeUpdater.ShapeUpdater;

public class JournalUpdater implements ShapeUpdater {

	public JournalUpdater() {
	}

	/***/
	public void update(Rectangle s, int direction, Location loc) {
	 s.setBounds(new Rectangle(loc.getX()+25,loc.getY()+10,35,60));
	}
}
