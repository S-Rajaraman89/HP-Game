package finalHPGame.AnimationHandler;

import java.util.Hashtable;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import finalHPGame.Location.Location;

/**Contains the animations for displayed objects*/
public class AnimationHandler {

	/**The direction the character is facing. 12-up, 6-down*/
	private int direction;
	/**Contains the specific integers with has specific animations*/
	private Hashtable<Integer, Animation> animationHolder;
	/**The current animation*/
	private Animation mainChar;

	public AnimationHandler(String name) throws SlickException{
		animationHolder = new Hashtable<Integer, Animation>();
		direction = 6;
		mainChar = null;

		Animation movingLeft=null, movingRight=null, movingDown=null, movingUp=null;
		int[] duration = {200,200,200};

		if(name.toLowerCase().equals("harry")||name.toLowerCase().equals("hp")){
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
			mainChar = new Animation(down,duration,false);
		}

		else if (name.toLowerCase().equals("snake") || name.toLowerCase().equals("snakes")){
			Image[] down = {new Image("res/Basilisk.png"), 
					new Image("res/Basilisk.png"), 
					new Image("res/Basilisk.png")};
			movingDown = new Animation(down,duration,false);
			movingLeft = movingDown;
			movingRight = movingDown;
			movingUp = movingDown;
			mainChar = movingDown;

		}
		else if (name.toLowerCase().equals("hring")){
			Image[] down= {new Image("res/DauntRing.png"), 
					new Image("res/DauntRing.png"),
					new Image("res/DauntRing.png")};

			movingDown=new Animation(down, duration, false);
			movingLeft=movingDown;
			movingRight=movingDown;
			movingUp= movingDown;
			mainChar=movingDown;
		}
		else if(name.equalsIgnoreCase("hjournal")){
			Image[] down= {new Image("res/Diary.png"), 
					new Image("res/Diary.png"),
					new Image("res/Diary.png")};

			movingDown=new Animation(down, duration, false);
			movingLeft=movingDown;
			movingRight=movingDown;
			movingUp= movingDown;
			mainChar=movingDown;
		}

		else if (name.toLowerCase().equals("spider") || name.toLowerCase().equals("spiders")){
		}

		else if (name.toLowerCase().equals("dementor") || name.toLowerCase().equals("dementors")||name.equalsIgnoreCase("d")){
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

			movingLeft = new Animation(left,duration,false);
			movingRight = new Animation(right,duration,false);
			movingDown=new Animation(down,duration,false);
			movingUp = new Animation(up,duration,false);
			mainChar = new Animation(down,duration,false);
		}

		else if(name.toLowerCase().equals("ron")){

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
		animationHolder.put(12, movingUp);
		animationHolder.put(3, movingRight);
		animationHolder.put(6, movingDown);
		animationHolder.put(9, movingLeft);
		mainChar = movingDown;
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
