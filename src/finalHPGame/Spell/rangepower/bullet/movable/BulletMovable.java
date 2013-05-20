package finalHPGame.Spell.rangepower.bullet.movable;

import finalHPGame.Location.Location;

public interface BulletMovable {
	/**Moves the bullet*/
	/*Updates the bullets Location by adding speed to the x or y
	 * ex. bulletsLocation.setX(speed)
	 * */
	public void moveBullet(Location bulletLocation, int speed);

	/**Can the bullet still move
	 * @return true if the bullet can move
	 * @return false if the bullet has hit it's bounds*/
	public boolean canMove(Location bulletsLocation, int speed);
}
