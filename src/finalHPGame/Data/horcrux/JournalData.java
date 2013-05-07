package finalHPGame.Data.horcrux;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import finalHPGame.Data.Data;
import finalHPGame.Location.Location;
import finalHPGame.Movable.HorcruxMove;
import finalHPGame.ShapeUpdater.HorcruxUpdater.JournalUpdater;

/**
 *Holds the variables for Journal
 */
public class JournalData extends Data {
public JournalData(float x, float y, int level){
	updater = new JournalUpdater();
	move = new HorcruxMove();
	//TODO: add personal
	myLoc = new Location(x,y,level);
	name= "journal";
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
