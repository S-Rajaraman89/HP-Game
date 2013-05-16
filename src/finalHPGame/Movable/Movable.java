package finalHPGame.Movable;

import finalHPGame.CharList;
import finalHPGame.Characters.Enemy;

public interface Movable {
	/**Moves the object on the screen
	 * @param target - the main character. Usually moving towards it
	 * @param self - the object that is using this class. Usually it's 'this'*/
	public void moveCharacter(CharList list, Enemy self, int delta);
}
