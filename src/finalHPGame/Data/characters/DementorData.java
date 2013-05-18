package finalHPGame.Data.characters;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import finalHPGame.Constant.DementorConstant;
import finalHPGame.Data.Data;
import finalHPGame.Location.Location;
import finalHPGame.Movable.DementorMove;
import finalHPGame.ShapeUpdater.CharacterUpdater.DementorUpdater;

/**
 *Holds the variables needed to init Dementor
 */
public class DementorData extends Data {

	public DementorData(float x, float y,int level) throws SlickException{
		super.move = new DementorMove();
		super.updater = new DementorUpdater();
		super.personal = new Rectangle(30,5,41,85);
		super.constant = new DementorConstant(level);
		super.myLoc = new Location(x,y,level);
		super.name = "Dementor";
		init();
	}

	public void init() throws SlickException{
		int[] duration = {200,200,200};
		Image[] left = {new Image("res/dem_left.png"), 
				new Image("res/dem_left.png"), 
				new Image("res/dem_left.png")};

		Image[] right = {new Image("res/dem_right.png"), 
				new Image("res/dem_right.png"), 
				new Image("res/dem_right.png")};

		Image[] up = {new Image("res/dem_up.png"),
				new Image("res/dem_up.png"),
				new Image("res/dem_up.png")};

		Image[] down = {new Image("res/dem_down.png"),
				new Image("res/dem_down.png"), 
				new Image("res/dem_down.png")};

		super.movingLeft = new Animation(left,duration,false);
		super.movingRight = new Animation(right,duration,false);
		super.movingDown=new Animation(down,duration,false);
		super.movingUp = new Animation(up,duration,false);
	}
}
