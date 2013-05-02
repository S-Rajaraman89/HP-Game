package finalHPGame.Characters;



import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;

import finalHPGame.AnimationHandler.AnimationHandler;
import finalHPGame.Location.Location;
import finalHPGame.ShapeUpdater.*;
import finalHPGame.ShapeUpdater.CharacterUpdater.DementorUpdater;
import finalHPGame.ShapeUpdater.CharacterUpdater.HarryPotterUpdater;
import finalHPGame.ShapeUpdater.CharacterUpdater.SnakeUpdater;
import finalHPGame.ShapeUpdater.HorcruxUpdater.JournalUpdater;


/**The most basic version of a object that has Locations and Animations*/
public class Character {

	/**Contains and changes the (x,y)*/
	private Location loc;
	/**Contains and changes the animations*/
	private AnimationHandler anim;
	/**The name of the Character*/
	private String name;
	/**The Rectangle that surrounds animations*/
	private Rectangle personal;
	/**Updates the personal*/
	ShapeUpdater updater;

	public Character(float mypositionX, float mypositionY,String myname, int currentlevel) 
			throws SlickException{

		anim = new AnimationHandler(myname);
		loc = new Location(mypositionX, mypositionY, currentlevel);

		name = myname.toLowerCase();

		/*if the names equals to harry etc. then the animations variables will be set 
		for him.*/
		if(name.toLowerCase().equals("harry")||name.toLowerCase().equals("hp")){
			personal= new Rectangle(getPositionX()+40,getPositionY()+20,20,55);
			updater = new HarryPotterUpdater();
		}

		else if (name.toLowerCase().equals("snake") || name.toLowerCase().equals("snakes")){
			personal= new Rectangle(getPositionX()+40,getPositionY()+8,16,73);
			updater = new SnakeUpdater();
		}

		else if (name.toLowerCase().equals("spider") || name.toLowerCase().equals("spiders")){}

		else if (name.toLowerCase().equals("d") || name.toLowerCase().equals("dementor")){
			personal = new Rectangle(loc.getX()+30,loc.getY()+5,41,85);
			updater = new DementorUpdater();
		}

		else if(name.toLowerCase().equals("ron")){}
		
		else if(name.equalsIgnoreCase("hjournal")){
			updater = new JournalUpdater();
			personal =  new Rectangle(loc.getX(),loc.getY(),20,55);
		}
		//TODO: Find the rectangle that surrounds this
		else if(name.equalsIgnoreCase("hring")){}

	}

	/**Get the personal variable*/
	public Shape getPersonalSpace(){
		return personal;
	}

	/**Get the x coordinate*/
	public float getPositionX() {
		return loc.getX();
	}

	/**Changes the x coordinate, the direction
	 * the picture is facing, updates the
	 * personal shape
	 * @param deltaX - the change in X*/
	public void setPositionX(float deltaX) {
		anim.setAnimation(loc.setX(deltaX));
		updatePersonal();
	}
	/**Changes the x coordinate, does not care about bounds,
	 * updates the personal shape*/
	public void addPositionX(float deltaX){
		anim.setAnimation(loc.addX(deltaX));
		updatePersonal();
	}

	/**Get the y coordinate*/
	public float getPositionY() {
		return loc.getY();
	}


	/** Changes the y coordinate, the direction
	 * the picture is facing, updates the 
	 * personal shape
	 * @param deltaY - the change in Y*/
	public void setPositionY(float deltaY) {
		anim.setAnimation(loc.setY(deltaY));
		updatePersonal();
	}
	/**Changes the y coordinate, does not care about bounds,
	 * updates the personal shape*/
	public void addPositionY(float deltaY){
		anim.setAnimation(loc.addY(deltaY));
		updatePersonal();
	}


	/**Returns the name of the Character */
	public String getName(){
		return name;
	}
	/**Returns the AnimationHandler of the Character
	 * @return AnimationHandler
	 * */
	public AnimationHandler getAnimationHolder(){
		return anim;
	}

	/**Returns the Location of the Character
	 * @return Location
	 * */
	public Location getLocation(){
		return loc;
	}

	/**Draws the animation
	 * @see AnimationHandler.draw(Location loc)*/
	public void draw(){
		anim.draw(loc);
	}

	/**Prints the Name, X-coordinate and Y-coordinate*/
	public String toString(){
		return "Name: "+name
				+"/nX: "+loc.getX()
				+"/nY:"+loc.getY();
	}

	/**Draws a red outline of the personal shape*/
	public void drawPersonal(Graphics g){
		//Create a red color
		org.newdawn.slick.Color r = new org.newdawn.slick.Color(255, 0, 0);
		//Set the graphics to the red color
		g.setColor(r);
		updatePersonal();
		//draw the shape
		g.draw(personal);
	}
	
	/**Calls the updater's update method
	 * @see ShapeUpdater's update*/
	public void updatePersonal(){
		updater.update(personal, anim.getDirection(), loc);
	}
}