package finalHPGame.Spell.rangepower.bullet.movable;

import finalHPGame.Location.Location;

public class BulletMoveRight implements BulletMovable {

	
	private int timer;
	@Override
	public void moveBullet(Location bulletLocation, float speed) {
		// TODO Auto-generated method stub
		
			bulletLocation.addX(speed);
	}

	@Override
	public boolean canMove(Location bulletsLocation, float speed) {
		// TODO Auto-generated method stub
		Location loc = bulletsLocation.getCopyOfLocation();
		loc.setX(speed);
		return loc.inBounds();
	}

}
