package finalHPGame.Characters;

import org.newdawn.slick.SlickException;

import finalHPGame.CharList;
import finalHPGame.Constant.*;
import finalHPGame.Data.Data;
import finalHPGame.Movable.Movable;
import finalHPGame.Spell.Spell;

public class Enemy extends Character {

	Movable move;
	Constant constant;
	Spell[]spells;
	
	public Enemy(Data data) throws SlickException{
		super(data);
		move = data.getMovable();
		constant = data.getConstant();
		spells = data.getSpells();
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
	
	public Spell[] getSpells(){
		return spells;
	}
	//TODO: add the draw method, same as magician
/*	public void draw(){
		
	}*/
}