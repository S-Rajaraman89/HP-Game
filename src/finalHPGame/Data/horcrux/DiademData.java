package finalHPGame.Data.horcrux;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import finalHPGame.Data.Data;
import finalHPGame.Location.Location;
import finalHPGame.Movable.HorcruxMove;
import finalHPGame.ShapeUpdater.HorcruxUpdater.DiademUpdater;

public class DiademData extends Data {
	public DiademData(float x, float y, int level) throws SlickException{
		myLoc = new Location(x,y,level);
		name = "diadem";
		move = new HorcruxMove();
		personal = new Rectangle(myLoc.getX()+19,myLoc.getY()+39,63,45);
		updater = new DiademUpdater();
		init();
	}
	public void init() throws SlickException{
		int[] duration = {200,200,200};
		Image[] left = {new Image("res/Diadem.png"), 
				new Image("res/Diadem.png"), 
				new Image("res/Diadem.png")};

		movingLeft = new Animation(left,duration,false);
		movingRight = movingLeft;
		movingDown= movingRight;
		movingUp = movingRight;
	}
}
