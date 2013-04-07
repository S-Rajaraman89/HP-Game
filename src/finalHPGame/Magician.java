package finalHPGame;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;



public class Magician extends Character {

	/* To Create Rectangle for Harry Potter:
   new Rectangle(hp.getPositionX()+40,hp.getPositionY()+20,20,55);	
	 */

	private boolean isInvisible;
	private float speed = .1f;
	private MagicBar bar;
	private HealthBar hp;

	private Circle power;

	// get the x, y, name, and the current level
	public Magician(float mypositionX, float mypositionY, String myname, int level)
			throws SlickException {
		super(mypositionX, mypositionY, myname, level);
		bar = new MagicBar();
		hp = new HealthBar();

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
		if(hp.getHealthBarX()==0){
			super.setisDead(true);
		}
	}

	public void drawPowerCircle(Graphics g){
		g.draw(power);
	}
	/*Overrides the draw method
	 * if magican is invisble, then his height and width is 1
	 * else he is normally drawn */
	public void draw(){
		if(!isInvisible){
			mainChar.draw(super.getPositionX(), super.getPositionY(), 100, 100);
		}
		else{
			mainChar.draw(super.getPositionX(), super.getPositionY(), 1, 1);
		}
	}

}
