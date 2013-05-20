package finalHPGame.Spell.rangepower.bullet.movable;

import finalHPGame.Location.Location;

public class BulletMoveRight implements BulletMovable {

	
	private int timer;
	@Override
	public void moveBullet(Location bulletLocation, int speed) {
		// TODO Auto-generated method stub
		timer = 0;
		if(timer>=5)
		{
			timer = 0;
			bulletLocation.addX(speed);
		}
		
		
	}

	@Override
	public boolean canMove(Location bulletsLocation, int speed) {
		// TODO Auto-generated method stub
		return false;
	}

}
