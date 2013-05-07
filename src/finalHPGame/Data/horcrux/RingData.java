package finalHPGame.Data.horcrux;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import finalHPGame.Data.Data;
import finalHPGame.Location.Location;
import finalHPGame.Movable.HorcruxMove;
import finalHPGame.ShapeUpdater.HorcruxUpdater.RingUpdater;

/**
 *Holds the data for ring
 */
public class RingData extends Data {
	public RingData(float x, float y, int level) throws SlickException{
		updater = new RingUpdater();
		move = new HorcruxMove();
		//TODO:Add personal
		init();
		myLoc = new Location(x,y,level);
		name = "ring";
	}
	public void init() throws SlickException{
		int[] duration = {200,200,200};
		Image[] left = {new Image("res/DauntRing.png"), 
				new Image("res/DauntRing.png"), 
				new Image("res/DauntRing.png")};

		movingLeft = new Animation(left,duration,false);
		movingRight = movingLeft;
		movingDown= movingRight;
		movingUp = movingRight;
	}
}
