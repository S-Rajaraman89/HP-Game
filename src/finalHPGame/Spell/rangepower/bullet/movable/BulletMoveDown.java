package finalHPGame.Spell.rangepower.bullet.movable;

import finalHPGame.Location.Location;

public class BulletMoveDown implements BulletMovable {
		
	public void moveBullet(Location bulletLocation, float speed) {
		bulletLocation.replaceY(bulletLocation.getY()+speed);
	}

	public boolean canMove(Location bulletsLocation, float speed) {
		Location loc = bulletsLocation.getCopyOfLocation();
		loc.setY(speed);
		return loc.inBounds();
	}

}
