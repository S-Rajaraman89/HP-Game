package finalHPGame.Data.horcrux;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import finalHPGame.Data.Data;
import finalHPGame.Location.Location;
import finalHPGame.Movable.HorcruxMove;
import finalHPGame.ShapeUpdater.HorcruxUpdater.JournalUpdater;

/**
 *Holds the variables for Journal
 */
public class JournalData extends Data {
public JournalData(float x, float y, int level) throws SlickException{
	updater = new JournalUpdater();
	move = new HorcruxMove();
	myLoc = new Location(x,y,level);
	personal = new Rectangle(myLoc.getX()+25,myLoc.getY()+15,35,60);
	name= "journal";
	init();
}
	public void init() throws SlickException{
		int[] duration = {200,200,200};
		Image[] left = {new Image("res/Diary.png"), 
				new Image("res/Diary.png"), 
				new Image("res/Diary.png")};

		movingLeft = new Animation(left,duration,false);
		movingRight = movingLeft;
		movingDown= movingRight;
		movingUp = movingRight;
	}
}
