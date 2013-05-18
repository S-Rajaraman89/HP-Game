package finalHPGame.ShapeUpdater.CharacterUpdater;

import org.newdawn.slick.geom.Rectangle;

import finalHPGame.Location.Location;
import finalHPGame.ShapeUpdater.ShapeUpdater;

public class SpiderUpdater implements ShapeUpdater {

	
	public void update(Rectangle s, int direction, Location myLoc) {
		s.setBounds(new Rectangle(myLoc.getX()+35,myLoc.getY()+30,35,30));
	}



}
