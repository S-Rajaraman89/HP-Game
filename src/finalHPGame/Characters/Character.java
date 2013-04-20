package finalHPGame.Characters;



import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;
import finalHPGame.AnimationHandler.AnimationHandler;
import finalHPGame.Location.Location;



public class Character {


	private Location loc;
	private AnimationHandler anim;
	
	private String name;
	

	//the shape that outlines the character
	private Shape personal;
	


	public Character(float mypositionX, float mypositionY,String myname, int currentlevel) 
			throws SlickException{
		//names that can be used now are : harry, harry potter, hp

		anim = new AnimationHandler(myname);
		loc = new Location(mypositionX, mypositionY, currentlevel);
		
		name = myname.toLowerCase();

		/*if the names equals to harry etc. then the animations variables will be set 
		for him.*/
		if(name.toLowerCase().equals("harry")||name.toLowerCase().equals("hp")){
			personal= new Rectangle(getPositionX()+40,getPositionY()+20,20,55);
		}

		else if (name.toLowerCase().equals("snake") || name.toLowerCase().equals("snakes")){
			personal= new Rectangle(getPositionX()+40,getPositionY()+8,16,73);
		}

		else if (name.toLowerCase().equals("spider") || name.toLowerCase().equals("spiders")){
		}

		else if (name.toLowerCase().equals("dementor") || name.toLowerCase().equals("dementors")){
		}

		else if(name.toLowerCase().equals("ron")){

		}

	}


	//Returns the personal shape
	public Shape getPersonalSpace(){
		return personal;
	}

	//gets positionX (buckyPostionX)
	public float getPositionX() {
		return loc.getX();
	}


	//changes direction based on value of deltaX
	//checks for collision
	public void setPositionX(float deltaX) {
		anim.setAnimation(loc.setX(deltaX));
		updatePersonal();
	}


	//gets positionX (buckyPostionX)
	public float getPositionY() {
		return loc.getY();
	}

	//changes direction based on value of deltaY
	//checks for collision
	public void setPositionY(float deltaY) {
		anim.setAnimation(loc.setY(deltaY));
		updatePersonal();
	}

	//returns the name of the Character
	public String getName(){
		return name;
	}
	
	public AnimationHandler getAnimationHolder(){
		return anim;
	}
	
	public Location getLocation(){
		return loc;
	}

	//Character is drawn
	public void draw(){
		anim.draw(loc);
	}

	//returns the id of the Character
	public String toString(){
		return "Name: "+name
				+"/nX: "+loc.getX()
				+"/nY:"+loc.getY();
	}


	//Draws a red outline of the personal shape
	public void drawPersonal(Graphics g){
		org.newdawn.slick.Color r = new org.newdawn.slick.Color(255, 0, 0);
		g.setColor(r);
		updatePersonal();
		g.draw(personal);
	}

	//Updates the rectangle
	public void updatePersonal(){
		//Checks if the character is harry
		if(name.equals("harry potter")||name.equals("hp")){
			//Checks the direction harry is in
			if(anim.getDirection()==3||anim.getDirection()==6){
				//updates rectangle
				personal= new Rectangle(getPositionX()+40,getPositionY()+20,20,55);
			}
			else{
				personal = new Rectangle(getPositionX()+33,getPositionY()+20,20,55);
			}
		}
		//if not harry, it is a snake
		else if(name.equals("snake")){
			//update rectangle
			personal= new Rectangle(getPositionX()+40,getPositionY()+8,16,73);
		}
	}
}