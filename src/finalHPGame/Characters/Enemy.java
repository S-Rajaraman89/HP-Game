package finalHPGame.Characters;

import org.newdawn.slick.SlickException;

import finalHPGame.Data.Data;
import finalHPGame.HealthDecreaser.*;
import finalHPGame.Movable.Movable;



public class Enemy extends Character {
	
	Movable move;
	HealthDecreaser decreaser;
	
	public Enemy(Data data) throws SlickException{
		super(data);
			move = data.getMovable();
			decreaser = data.getHealthDecreaser();	
	}

	/**Moves the enemy object towards
	  * the any Magician target
	  */

	public void moveToward(Magician target){
		move.moveCharacter(target, this);
	}
	
	public HealthDecreaser getHealthDecreaser(){
		return decreaser;
	}
	
	
}
