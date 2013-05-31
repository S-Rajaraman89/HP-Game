package finalHPGame.Movable;

import finalHPGame.CharList;
import finalHPGame.Characters.Enemy;

public class SuperEnemyMove implements Movable {

	/* Things the enemy should be able to do
	 * Use spells when needed
	 * 	-Circle Power - when the playable is too close
	 *	-InvisiblePower - random time
	 *	-RangePower - when and if x and y are the same as the target, or if the target is near a certain range
	 */
	public void moveCharacter(CharList list, Enemy self, int delta) {
	
	}
	
	private void useCirclePower(Enemy self, int delta){
		if(!self.hasCirlePower()){
			return;
		}
		self.getCirclePower().setPowerOn();
		self.getCirclePower().updateCircle(delta, self);
	}
	private void setCirclePowerOff(Enemy self){
		self.getCirclePower().setPowerOff();
	}
	
	private void useInvisiblePower(Enemy self, int delta){
		if(!self.hasInvisiblePower()){
			return;
		}
		self.getCirclePower().setPowerOn();
		self.getCirclePower().updateCircle(delta, self);
	}
	private void setInvisibleOff(Enemy self){
		self.getCirclePower().setPowerOff();
	}
}
