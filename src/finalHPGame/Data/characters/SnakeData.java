package finalHPGame.Data.characters;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import finalHPGame.Constant.SnakeConstant;
import finalHPGame.Data.Data;
import finalHPGame.Location.Location;
import finalHPGame.Movable.SnakeMove;
import finalHPGame.ShapeUpdater.CharacterUpdater.SnakeUpdater;

/**
 *Holds variables for the snake
 */
public class SnakeData extends Data {

	public SnakeData(float x, float y,int level) throws SlickException{
		move = new SnakeMove();
		updater = new SnakeUpdater();
		constant = new SnakeConstant(level);
		personal= new Rectangle(40,8,16,73);
		myLoc = new Location(x,y,level);
		name = "snake";
		init();
	}

	public void init() throws SlickException{
		int[] duration = {200,200,200};
		Image[] down = {new Image("res/Basilisk.png"), 
				new Image("res/Basilisk.png"), 
				new Image("res/Basilisk.png")};
		movingDown = new Animation(down,duration,false);
		movingLeft = movingDown;
		movingRight = movingDown;
		movingUp = movingDown;
	}
}
