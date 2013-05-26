package finalHPGame.Spell.rangepower.bullet.movable;

import finalHPGame.Location.Location;

public class BulletMoveRight implements BulletMovable {

	public void moveBullet(Location bulletLocation, float speed) {
		bulletLocation.replaceX(bulletLocation.getX()+speed);
	}
}
