package finalHPGame.Characters;

import org.newdawn.slick.SlickException;
import finalHPGame.Bar.HealthBar;
import finalHPGame.Bar.MagicBar;
import finalHPGame.Data.Data;
import finalHPGame.Spell.nonrange.*;



/**This is the playable character*/
public class Magician extends Character {
	
	private SpeedPower speed;
	private CirclePower circle;
	private InvisiblePower invisible;
	private MagicBar bar;
	private HealthBar hp;
	
	public Magician(Data data)throws SlickException {
		super(data);
		speed = new SpeedPower();
		circle = new CirclePower(this.getPositionX(), this.getPositionY());
		invisible = new InvisiblePower();
		bar = new MagicBar();
		hp = new HealthBar();
	}
	/**Returns the SpeedPower object*/
	public SpeedPower getSpeedPower(){
		return speed;
	}
	/**Returns the CirclePower object*/
	public CirclePower getCirclePower(){
		return circle;
	}
	/**Returns the InvisiblePower object*/
	public InvisiblePower getInvisiblePower(){
		return invisible;
	}

	/**Set isPowerOn true if there is energy left */
	public void setInvisibleTrue(float delta) {
		if(!(bar.getSpellBarX()<=0)){
			invisible.setPowerOn();
			bar.decreaseMagicBar(delta);
		}
		else{
			invisible.setPowerOff();
		}
	}

	/**Returns the speed from SpeedPower object*/
	public float getSpeed() {
		return speed.getSpeed();
	}

	/**Sets Speed true if there is energy*/
	public void setSpeedFast(float delta){
		if((bar.getSpellBarX()>0)){
			speed.setPowerOn();
			bar.decreaseMagicBar(delta);
		}
		else{
			speed.setPowerOff();
		}
	}

	/**Returns the magicbar of the magician*/
	public MagicBar getMagicBar(){
		return bar;
	}

	/**returns the healthbar of the magician*/
	public HealthBar getHealthBar(){
		return hp;
	}

	/**Decreases the health from the healthbar
	  And if the heatlh is 0, then isDead = true */
	public void decreaseHealth(float delta){
		hp.decreaseHealthBar(delta);
	}
	
	/**Sets isPowerOn true if there is energy*/
	public void powerCircleOn(int delta){
		//There must be energy is the energy bar
		if(!bar.isEmpty()){
			circle.setPowerOn();
			bar.decreaseMagicBar(delta);
		}
		else{
			circle.setPowerOff();
		}
		circle.updateCircle(delta, this);
	}

	/**Overrides the draw method
	 * if magician is invisible, then his height and width is 1
	 * else he is normally drawn */
	public void draw(){
		if(!invisible.isPowerOn()){
			super.draw();
		}
		else{
			super.getAnimationHolder().drawSmall(super.getLocation());
		}
	}

}
