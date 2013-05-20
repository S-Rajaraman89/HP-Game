package finalHPGame.Spell.rangepower.bullet.movable;

import finalHPGame.Location.Location;

public class BulletMoveDown implements BulletMovable {

	private int timer;
	
	
	public void moveBullet(Location bulletLocation, int speed) {
		// TODO Auto-generated method stub
		
		
		timer = 0;
		if(timer>=5)
		{
			timer = 0;
			bulletLocation.addY(speed);
		}
			
		
		
		
	
		
	}

	public boolean canMove(Location bulletsLocation, int speed) {
		// TODO Auto-generated method stub
		return false;
	}

}
