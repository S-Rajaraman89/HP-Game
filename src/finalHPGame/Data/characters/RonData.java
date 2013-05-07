package finalHPGame.Data.characters;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import finalHPGame.Data.Data;
import finalHPGame.Location.Location;
import finalHPGame.ShapeUpdater.CharacterUpdater.RonUpdater;

/**
 * Holds variables for Ron
 */
public class RonData extends Data {
	
	public RonData(float x, float y, int level) throws SlickException{
		updater = new RonUpdater();
		personal= new Rectangle(40,20,20,55);
		myLoc = new Location(x,y,level);
		init();
		name = "Ron";
	}
	public void init() throws SlickException{
		int[] duration = {200,200,200};
		Image[] left = {new Image("res/ron_left.png"), 
				new Image("res/ron_left.png"), 
				new Image("res/ron_left.png")};

		Image[] right = {new Image("res/ron_right.png"), 
				new Image("res/ron_right.png"), 
				new Image("res/ron_right.png")};

		Image[] down = {new Image("res/RonDefault.png"),
				new Image("res/RonDefault.png"),
				new Image("res/RonDefault.png")};
		
		Image[] up = {new Image("res/ron_back.png"),
				new Image("res/ron_back.png"), 
				new Image("res/ron_back.png")};

		movingLeft = new Animation(left,duration,false);
		movingRight = new Animation(right,duration,false);
		movingDown=new Animation(down,duration,false);
		movingUp = new Animation(up,duration,false);
	}
}
