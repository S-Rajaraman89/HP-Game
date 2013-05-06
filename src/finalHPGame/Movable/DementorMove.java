package finalHPGame.Movable;

import finalHPGame.Characters.Enemy;
import finalHPGame.Characters.Magician;

public class DementorMove implements Movable {

	/**The Dementor moves directly (no bounds) towards the target.*/
	@Override
	public void moveCharacter(Magician target, Enemy self) {
		float targetX = target.getPositionX();
		float targetY = target.getPositionY();

		//TODO Dementor switches directions back and forth too quickly.
		if(targetX+10>self.getPositionX()){
			self.getAnimationHolder().setAnimation(self.getLocation().addX((float) .5));
		}
		else{
			self.getAnimationHolder().setAnimation(self.getLocation().addX((float) -.5));
		}


		if(targetY>self.getPositionY()){
			self.getAnimationHolder().setAnimation(self.getLocation().addY((float) .5));
		}
		else{
			self.getAnimationHolder().setAnimation(self.getLocation().addY((float) -.5));
		}
		self.updatePersonal();
	}
	
		
	}


