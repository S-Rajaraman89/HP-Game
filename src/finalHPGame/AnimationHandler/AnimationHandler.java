package finalHPGame.AnimationHandler;

import java.util.HashMap;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;

import finalHPGame.Data.Data;
import finalHPGame.Location.Location;

/**Contains the animations for displayed objects*/
public class AnimationHandler {

	/**The direction the character is facing. 12-up, 6-down*/
	private int direction;
	/**Contains the specific integers with has specific animations*/
	private HashMap<Integer, Animation> animationHolder;
	/**The current animation*/
	private Animation mainChar;

	public AnimationHandler(Data data) throws SlickException{
		animationHolder = new HashMap<Integer, Animation>();
		direction = 6;
		animationHolder.put(12, data.getMovingUp());
		animationHolder.put(3, data.getMovingRight());
		animationHolder.put(6, data.getMovingDown());
		animationHolder.put(9, data.getMovingLeft());
		mainChar = data.getMovingDown();
	}
	
	/**Draws the mainChar with given Location, default height and width
	 * are 100*/
	public void draw(Location loc){
		mainChar.draw(loc.getX(),loc.getY(), 100, 100);
	}

	/**Draws the mainChar with given Location, default height and width
	 * are 1*/
	public void drawSmall(Location loc){
		mainChar.draw(loc.getX(),loc.getY(), 1, 1);
	}
	/**Sets the mainChar to a new animation based on given direction*/
	public void setAnimation(int newdirection){
		mainChar = animationHolder.get(newdirection);
		this.direction = newdirection;
	}
	/**@return The current direction of the animation*/
	public int getDirection(){
		return direction;
	}
	/**Returns the current animation*/
	public Animation getMainChar(){
		return mainChar;
	}
}
