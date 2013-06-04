package finalHPGame.Movable;

import finalHPGame.CharList;
import finalHPGame.Characters.Enemy;
import finalHPGame.Characters.Magician;

public class SuperEnemyMove implements Movable {

	/* Things the enemy should be able to do
	 * Use spells when needed
	 * 	-Circle Power - when the playable is too close
	 *	-InvisiblePower - random time
	 *	-RangePower - when and if x and y are the same as the target, or if the target is near a certain range
	 *	-Slow Movement towards the player
	 *	-Health Bar
	 */
	public void moveCharacter(CharList list, Enemy self, int delta) {
		Magician main = list.getMainCharacter();
		if(self.getCirclePower().getPossibleCircle(self).intersects(main.getPersonalSpace())){
			this.useCirclePower(self, delta);
		}
		else{
			setCirclePowerOff(self);
		}
	}
	
	private void useCirclePower(Enemy self, int delta){
		if(!self.hasCirlePower()){
			return;
		}
		self.getCirclePower().setPowerOn();
		self.getCirclePower().updateCircle(delta, self);
	}
	private void setCirclePowerOff(Enemy self){
		if(!self.hasCirlePower()){
			return;
		}
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
	
	private void addBullet(CharList list, Enemy self){
		if(!self.hasRangePower()){
			return;
		}
		int direction = self.getLocation().directionOf(list.getMainCharacter().getLocation());
		self.getRangePower().addBullet(direction);
	}
}
