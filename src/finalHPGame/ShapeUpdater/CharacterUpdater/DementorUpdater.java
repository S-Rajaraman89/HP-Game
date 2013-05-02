package finalHPGame.ShapeUpdater.CharacterUpdater;

import org.newdawn.slick.geom.Rectangle;
import finalHPGame.Location.Location;
import finalHPGame.ShapeUpdater.ShapeUpdater;

public class DementorUpdater implements ShapeUpdater {
	
	/**Updates personal to match the Dementor*/
	public void update(Rectangle s, int direction, Location loc) {

		if(direction==12||direction==9){
			s.setBounds(new Rectangle(loc.getX()+30,loc.getY()+5,41,85));
		}

		else{
			s.setBounds(new Rectangle(loc.getX()+30,loc.getY()+5,41,85));
		}
	}

}
