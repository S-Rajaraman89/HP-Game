package finalHPGame.Data.horcrux;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import finalHPGame.Data.Data;
import finalHPGame.Location.Location;
import finalHPGame.Movable.HorcruxMove;
import finalHPGame.ShapeUpdater.HorcruxUpdater.CupUpdater;

public class CupData extends Data {
	public CupData(float x, float y, int level) throws SlickException{
		myLoc = new Location(x,y,level);
		move = new HorcruxMove();
		name ="cup";
		personal = new Rectangle(myLoc.getX()+33,myLoc.getY()+15,35,60);
		updater = new CupUpdater();
		init();
	}
	public void init()throws SlickException{
		int[] duration = {200,200,200};
		Image[] left = {new Image("res/puffcup.png"), 
				new Image("res/puffcup.png"), 
				new Image("res/puffcup.png")};

		movingLeft = new Animation(left,duration,false);
		movingRight = movingLeft;
		movingDown= movingRight;
		movingUp = movingRight;
	}

}
