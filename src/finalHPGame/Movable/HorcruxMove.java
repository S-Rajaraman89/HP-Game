package finalHPGame.Movable;

import finalHPGame.CharList;
import finalHPGame.Characters.Enemy;

/**Moves the Horcrux in random locations*/
public class HorcruxMove implements Movable {
	
	private int timer;
	
	public HorcruxMove() {
		timer =0;
	}

	/**Changes the location until it gets a location that is valid*/
	@Override
	public void moveCharacter(CharList list, Enemy self, int delta) {
		timer+=delta;
		if(timer>=1500){
			timer=0;
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

}
