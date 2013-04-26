package finalHPGame.Movable;

import finalHPGame.Characters.Enemy;
import finalHPGame.Characters.Magician;

public interface Movable {
	/**Moves the object on the screen
	 * @param target - the main character. Usually moving towards it
	 * @param self - the object that is using this class. Usually it's 'this'*/
	public void moveCharacter(Magician target, Enemy self);
}
