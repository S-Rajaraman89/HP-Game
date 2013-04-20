package finalHPGame.AnimationHandler;

import java.util.Hashtable;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import finalHPGame.Location.Location;

public class AnimationHandler {

	private int direction;
	private Hashtable<Integer, Animation> animationHolder;
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

		else if (name.toLowerCase().equals("spider") || name.toLowerCase().equals("spiders")){
		}

		else if (name.toLowerCase().equals("dementor") || name.toLowerCase().equals("dementors")){
		}

		else if(name.toLowerCase().equals("ron")){

			Image[] left = {new Image("res/RonDefault.png"), 
					new Image("res/RonDefault.png"), 
					new Image("res/RonDefault.png")};

			Image[] right = {new Image("res/RonDefault.png"), 
					new Image("res/RonDefault.png"), 
					new Image("res/RonDefault.png")};

			Image[] up = {new Image("res/RonDefault.png"),
					new Image("res/RonDefault.png"),
					new Image("res/RonDefault.png")};
			Image[] down = {new Image("res/RonDefault.png"),
					new Image("res/RonDefault.png"), 
					new Image("res/RonDefault.png")};
			movingLeft = new Animation(left,duration,false);
			movingRight = new Animation(right,duration,false);
			movingDown=new Animation(down,duration,false);
			movingUp = new Animation(up,duration,false);
			mainChar = new Animation(down,duration,false);

		}
		animationHolder.put(12, movingUp);
		animationHolder.put(3, movingRight);
		animationHolder.put(6, movingDown);
		animationHolder.put(9, movingLeft);
		mainChar = movingDown;
	}
	
	public void draw(Location loc){
		mainChar.draw(loc.getX(),loc.getY(), 100, 100);
	}
	
	public void drawSmall(Location loc){
		mainChar.draw(loc.getX(),loc.getY(), 1, 1);
	}
	
	public void setAnimation(int newdirection){
		mainChar = animationHolder.get(newdirection);
		this.direction = newdirection;
	}
	
	public int getDirection(){
		return direction;
	}
}
