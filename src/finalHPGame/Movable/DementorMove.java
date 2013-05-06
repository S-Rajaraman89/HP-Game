package finalHPGame.Movable;

import finalHPGame.Characters.Enemy;
import finalHPGame.Characters.Magician;

public class DementorMove implements Movable {

	/**The Dementor moves directly (no bounds) towards the target.*/
	@Override
	public void moveCharacter(Magician target, Enemy self) {
		float targetX = target.getPositionX();
		float targetY = target.getPositionY();

		//TODO change it so that the Dementor just moves one way
		if(targetX+10>self.getPositionX()){
			self.getAnimationHolder().setAnimation(self.getLocation().addX(5));
		}
		else{
			self.getAnimationHolder().setAnimation(self.getLocation().addX(-5));
		}


		if(targetY>self.getPositionY()){
			self.getAnimationHolder().setAnimation(self.getLocation().addY(5));
		}
		else{
			self.getAnimationHolder().setAnimation(self.getLocation().addY(-5));
		}
		self.updatePersonal();
	}
	
		
	}


