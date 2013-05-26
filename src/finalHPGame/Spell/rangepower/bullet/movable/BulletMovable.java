package finalHPGame.Spell.rangepower.bullet.movable;

import finalHPGame.Location.Location;

public interface BulletMovable {
	/**Moves the bullet*/
	/*Updates the bullets Location by adding speed to the x or y
	 * ex. bulletsLocation.setX(speed)
	 * */
	public void moveBullet(Location bulletLocation, float speed);
}
