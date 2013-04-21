package finalHPGame.Characters;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

import finalHPGame.Bar.HealthBar;
import finalHPGame.Bar.MagicBar;



public class Magician extends Character {

	/* To Create Rectangle for Harry Potter:
   new Rectangle(hp.getPositionX()+40,hp.getPositionY()+20,20,55);	
	 */

	private boolean isInvisible;

	private float speed = .1f;
	private MagicBar bar;
	private HealthBar hp;

	private boolean isPowerOn;
	private Circle power;
	private int powerRadius;

	// get the x, y, name, and the current level
	public Magician(float mypositionX, float mypositionY, String myname, int level)
			throws SlickException {
		super(mypositionX, mypositionY, myname, level);
		bar = new MagicBar();
		hp = new HealthBar();
		powerRadius = 1;
		isPowerOn = false;
		power = new Circle(getPositionX()+60,getPositionY()+40,powerRadius);

	}

	//Returns invisible
	public boolean isInvisble() {
		return isInvisible;
	}
	//sets invisible false
	public void setInvisibleFalse(){
		isInvisible = false;
	}

	//sets invisible true
	//if there is 'energy' left in
	//the magicbar
	public void setInvisibleTrue(float delta) {
		if(!(bar.getSpellBarX()<=0)){
			isInvisible = true;
			bar.decreaseMagicBar(delta);
		}
		else{
			isInvisible = false;
		}
	}

	//Gets the current speed of the Magician
	public float getSpeed() {
		return speed;
	}

	//Sets the speed to a normal rate
	public void setSpeedNormal() {
		speed = .1f;
	}

	/*Sets the speed fast if conditions are met
	  The delta is to decrease the magicbar*/
	public void setSpeedFast(float delta){
		/*If there is energy in the magic bar,
		  then increase the speed and decrease the magicbar*/
		if((bar.getSpellBarX()>0)){
			speed = .2f;
			bar.decreaseMagicBar(delta);
		}
		else{
			speed = .1f;
		}
	}

	//Returns the magicbar of the magician
	public MagicBar getMagicBar(){
		return bar;
	}

	//returns the healthbar of the magician
	public HealthBar getHealthBar(){
		return hp;
	}

	/*Decreases the health from the healthbar
	  And if the heatlh is 0, then isDead = true */
	public void decreaseHealth(float delta){
		hp.decreaseHealthBar(delta);
	}

	//Changes isPowerOn based on few conditions
	public void powerCircleOn(int delta){
		//There must be energy is the energy bar
		if(!bar.isEmpty()){
			isPowerOn = true;
		}
		else{
			isPowerOn = false;
		}
		//updates the circle based on isPowerOn
		updateCircle(delta);
	}

	//returns the value of isPowerOn
	public boolean isPowerOn(){
		return isPowerOn;
	}
	//isPowerOn is set to false
	public void powerCircleOff(int delta){
		isPowerOn = false;
		//updates the circle based on isPowerOn
		updateCircle(delta);
	}

	//Updates the circle based on delta and isPoweron
	public void updateCircle(int delta){
		//if isPowerOn is true
		if(isPowerOn){
			//restricts the size of the circle
			if(powerRadius<=60){
				powerRadius+=delta;
			}
			power.setCenterX(getPositionX()+50);
			power.setCenterY(getPositionY()+40);
			power.setRadius(powerRadius);
			bar.decreaseMagicBar(delta);
		}
		else{
			//if isPowerOn is false, then the circle moves to (0,0)
			//with size 1
			powerRadius = 1;
			power.setCenterX(0);
			power.setCenterY(0);
			power.setRadius(powerRadius);
		}

	}
	
	public Shape getPowerCircle(){
		return power;
	}
	
	//Draws the circle power up
	public void drawPowerCircle(Graphics g){
		org.newdawn.slick.Color r = new org.newdawn.slick.Color(0, 0, 100);
		g.setColor(r);
		g.draw(power);
	}


	/*Overrides the draw method
	 * if magican is invisble, then his height and width is 1
	 * else he is normally drawn */
	public void draw(){
		if(!isInvisible){
			super.draw();
		}
		else{
			super.getAnimationHolder().drawSmall(super.getLocation());
		}
	}

}
