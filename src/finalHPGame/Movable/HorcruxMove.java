package finalHPGame.Movable;

import finalHPGame.Characters.Enemy;
import finalHPGame.Characters.Magician;

/**Moves the Horcrux in random locations*/
public class HorcruxMove implements Movable {

	public HorcruxMove() {}

	/**Changes the location until it gets a location that is valid*/
	@Override
	public void moveCharacter(Magician target, Enemy self) {
		
		float intX = 0;
		float intY =0;
		do{
		float randY= (float)(Math.random()*800);
		float randX= (float)(Math.random()*1050);
		 intX = self.getLocation().getX();
		 intY = self.getLocation().getY();
		int negativeX = (int)(Math.random()*3) -1;
		int negativeY = (int)(Math.random()*3) -1;
		self.getLocation().setX(randX*negativeX);
		self.getLocation().setY(randY*negativeY);
		self.updatePersonal();
		}while(intX==self.getLocation().getX()&&intY==self.getLocation().getY());
		
		
	}

}
