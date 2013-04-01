package finalHPGame;



import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;



public class Character {

	private float positionX;
	private float positionY;
	private String name;
	private int level;

	private Shape personalSpace;


	Animation mainChar, movingLeft, movingRight, movingDown, movingUp;
	int[] duration = {200,200,200}; //duration or length of the frame
	private boolean isDead;


	public Character(float mypositionX, float mypositionY,String myname, int currentlevel) throws SlickException{
		//names that can be used now are : harry, harry potter, hp
		positionX=mypositionX;
		positionY=mypositionY;
		isDead =false;
		name = myname.toLowerCase();
		level = currentlevel;

		/*if the names equals to harry etc. then the animations variables will be set 
		for him.*/
		if(name.toLowerCase().equals("harry")||name.toLowerCase().equals("harry potter")||name.toLowerCase().equals("hp")){
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
			personalSpace =  new Rectangle(positionX+40,positionY+20,20,55);
		}

		else if (name.toLowerCase().equals("snake") || name.toLowerCase().equals("snakes")){
			Image[] down = {new Image("res/Basilisk.png"), new Image("res/Basilisk.png"), new Image("res/Basilisk.png")};
			movingDown = new Animation(down,duration,false);
			movingLeft = movingDown;
			movingRight = movingDown;
			movingUp = movingDown;
			mainChar = movingDown;
			personalSpace =  new Rectangle(positionX+35,positionY+5,25,80);
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

	}

	//Makes the mainChar null
	public void delete(){
		mainChar=null;
	}

	public Shape getPersonalSpace(){
		return personalSpace;
	}

	//is the character dead?
	public boolean getisDead(){
		return isDead;
	}

	//Sets the dead status to true/false
	public void setisDead(boolean dead){
		isDead=dead;
	}

	//gets positionX (buckyPostionX)
	public float getPositionX() {
		return positionX;
	}


	//changes direction based on value of deltaX
	//checks for collision
	public boolean setPositionX(float deltaX) {
		//sets the animation direction: left or right
		if(deltaX<0){
			mainChar = movingLeft;
		}
		else{
			mainChar = movingRight;
		}
		//add the deltaX to the positionX
		positionX += deltaX;

		/*if the new position collides with boundaries
		then it reverts back to previous location.*/
		if(isCollide()){
			positionX-=deltaX;
			return false;
		}
		return true;
	}


	//gets positionX (buckyPostionX)
	public float getPositionY() {
		return positionY;
	}

	//changes direction based on value of deltaY
	//checks for collision
	public boolean setPositionY(float deltaY) {
		//sets animation direction: up or down
		if(deltaY<0){
			mainChar = movingUp;
		}
		else{
			mainChar = movingDown;
		}
		//adds to the positionY
		positionY+=deltaY;

		/*if the new position collides with boundaries
		then it reverts back to previous location.*/
		if(isCollide()){
			positionY-=deltaY;
			return false;
		}
		return true;
	}


	public String getName(){
		return name;
	}

	//Based on postionX and positionY,
	//is the character colliding with something
	public boolean isCollide(){
		if(level==1){
			if((positionX<992 && positionX>-35 && positionY<338 && positionY>140)
					||(positionX<680 && positionX>247 && positionY<=688 && positionY>=336)){
				return false;
			}
		}
		if(level==2){
			return false;
		}
		return true;
	}

	public void draw(float x, float y){
		mainChar.draw(x, y, 100, 100);
	}

	public void draw(){
		mainChar.draw(positionX, positionY, 100, 100);
	}

	public String toString(){
		return "Name: "+name
				+"/nX: "+positionX
				+"/nY:"+positionY;
	}
}