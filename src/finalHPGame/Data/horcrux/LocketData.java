package finalHPGame.Data.horcrux;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import finalHPGame.Data.Data;
import finalHPGame.Location.Location;
import finalHPGame.Movable.HorcruxMove;
import finalHPGame.ShapeUpdater.HorcruxUpdater.LocketUpdater;

public class LocketData extends Data {

	public LocketData(float x, float y, int level) throws SlickException{
		myLoc = new Location(x,y,level);
		name = "diadem";
		move = new HorcruxMove();
		personal = new Rectangle(myLoc.getX()+29,myLoc.getY()+10,19,70);
		updater = new LocketUpdater();
		init();
	}
	
	public void init() throws SlickException{
		int[] duration = {200,200,200};
		Image[] left = {new Image("res/locket.png"), 
				new Image("res/locket.png"), 
				new Image("res/locket.png")};

		movingLeft = new Animation(left,duration,false);
		movingRight = movingLeft;
		movingDown= movingRight;
		movingUp = movingRight;

	}
}
