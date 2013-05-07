package finalHPGame.Data.characters;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import finalHPGame.Data.Data;
import finalHPGame.Location.Location;
import finalHPGame.ShapeUpdater.CharacterUpdater.HarryPotterUpdater;

/**
 * Holds the variables for Harry
 *
 */
public class HarryPotterData extends Data {

	public HarryPotterData(float x, float y, int level) throws SlickException{
		updater = new HarryPotterUpdater();
		personal= new Rectangle(40,20,20,55);
		myLoc = new Location(x,y,level);
		init();
		name = "Harry Potter";
	}
	
	public void init() throws SlickException{
		int[] duration = {200,200,200};
		Image[] left = {new Image("res/HarryLeft.png"), 
				new Image("res/HarryLeft_1.png"), 
				new Image("res/HarryLeft_2.png")};

		Image[] right = {new Image("res/HarryRight.png"), 
				new Image("res/HarryRight_1.png"), 
				new Image("res/HarryRight_2.png")};

		Image[] up = {new Image("res/HarryBackv.png"),
				new Image("res/HarryBack_1v.png"),
				new Image("res/HarryBack_2v.png")};
		Image[] down = {new Image("res/HarryDefault.png"),
				new Image("res/HarryForward_1.png"), 
				new Image("res/HarryForward_2.png")};

		movingLeft = new Animation(left,duration,false);
		movingRight = new Animation(right,duration,false);
		movingDown=new Animation(down,duration,false);
		movingUp = new Animation(up,duration,false);
	}
	
}
