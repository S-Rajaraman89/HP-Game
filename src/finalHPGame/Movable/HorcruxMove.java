package finalHPGame.Movable;

import finalHPGame.Characters.Enemy;
import finalHPGame.Characters.Magician;

public class HorcruxMove implements Movable {

	public HorcruxMove() {

	}

	public void moveCharacter(Magician target, Enemy self) {
		do{
			float randY= (float)(Math.random()*800);
			float randX= (float)(Math.random()*1050);
			self.getLocation().addX(randX);
			self.getLocation().addX(randY);
		}
		while(!self.getLocation().inBounds());

	}

}
