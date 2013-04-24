package finalHPGame.Movable;

import finalHPGame.Characters.Enemy;
import finalHPGame.Characters.Magician;

public class DementorMove implements Movable {


	public void moveCharacter(Magician target, Enemy self) {
		float targetX = target.getPositionX();
		float targetY = target.getPositionY();

		if(targetX>self.getPositionX()){
			self.setPositionX(10);
		}
		else{
			self.setPositionX(-10);
		}


		if(targetY>self.getPositionY()){
			self.setPositionY(10);
		}
		else{
			self.setPositionY(-10);
		}
		self.updatePersonal();
	}
	
		
	}


