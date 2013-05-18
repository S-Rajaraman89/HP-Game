package finalHPGame.Characters;

import org.newdawn.slick.SlickException;

import finalHPGame.CharList;
import finalHPGame.Constant.*;
import finalHPGame.Data.Data;
import finalHPGame.Movable.Movable;



public class Enemy extends Character {
	
	Movable move;
	Constant constant;
	
	public Enemy(Data data) throws SlickException{
		super(data);
			move = data.getMovable();
			constant = data.getConstant();
	}

	/**Moves the enemy object towards
	  * the any Magician target
	  */

	public void moveToward(CharList list, int delta){
		move.moveCharacter(list, this,delta);
	}
	
	public Constant getConstant(){
		return constant;
	}
	
	
}
