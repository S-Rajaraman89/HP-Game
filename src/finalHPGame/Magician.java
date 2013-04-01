package finalHPGame;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;


public class Magician extends Character {
	
/* To Create Rectangle for Harry Potter:
   new Rectangle(hp.getPositionX()+40,hp.getPositionY()+20,20,55);	
	*/
	
	private boolean isInvisible;
	//invisible
	private float speed = .1f;
	
	
	private MagicBar bar;
	private HealthBar hp;

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

	public float getSpeed() {
		return speed;
	}

	public void setSpeedNormal() {
		speed = .1f;
	}

	public void setSpeedFast(float delta){
		if((bar.getSpellBarX()>0)){
			speed = .2f;
			bar.decreaseMagicBar(delta);
		}
		else{
			speed = .1f;
		}
	}
	public MagicBar getMagicBar(){
		return bar;
	}
	public HealthBar getHealthBar(){
		return hp;
	}
	
	public void decreaseHealth(float delta){
		hp.decreaseHealthBar(delta);
		if(hp.getHealthBarX()==0){
			super.setisDead(true);
		}
	}

	public void draw(){
		if(!isInvisible){
			mainChar.draw(super.getPositionX(), super.getPositionY(), 100, 100);
		}
		else{
			mainChar.draw(super.getPositionX(), super.getPositionY(), 1, 1);
		}
	}
	
}
