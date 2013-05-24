package finalHPGame.Spell.nonrange;
/**Part of nonrange spells*/
public class SpeedPower extends NonRange {
	private float speed;
	public SpeedPower(){
		super();
		speed = .1f;
	}
	public float getSpeed(){
		return speed;
	}
 public void setPowerOn(){
	 speed = .2f;
	 isPowerOn = true;
 }
 public void setPowerOff(){
	 speed = .1f;
	 isPowerOn = false;
 }
	
}
