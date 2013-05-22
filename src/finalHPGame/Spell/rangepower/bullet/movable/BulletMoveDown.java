package finalHPGame.Spell.rangepower.bullet.movable;

import finalHPGame.Location.Location;

public class BulletMoveDown implements BulletMovable {

	private int timer;
	
	
	public void moveBullet(Location bulletLocation, float speed) {
		// TODO Auto-generated method stub
		bulletLocation.addY(speed);
	}

	public boolean canMove(Location bulletsLocation, float speed) {
		// TODO Auto-generated method stub
		Location loc = bulletsLocation.getCopyOfLocation();
		loc.setY(speed);
		return loc.inBounds();
	}

}
