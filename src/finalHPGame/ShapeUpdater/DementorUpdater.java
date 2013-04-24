package finalHPGame.ShapeUpdater;

import org.newdawn.slick.geom.Rectangle;
import finalHPGame.Location.Location;

public class DementorUpdater implements ShapeUpdater {

	public void update(Rectangle s, int direction, Location loc) {

		if(direction==12||direction==9){
			s.setBounds(new Rectangle(loc.getX()+30,loc.getY()+5,41,85));
		}

		else{
			s.setBounds(new Rectangle(loc.getX()+30,loc.getY()+5,41,85));
		}
	}

}
