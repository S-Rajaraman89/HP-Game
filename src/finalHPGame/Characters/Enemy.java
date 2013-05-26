package finalHPGame.Characters;

import org.newdawn.slick.SlickException;

import finalHPGame.CharList;
import finalHPGame.Constant.*;
import finalHPGame.Data.Data;
import finalHPGame.Movable.Movable;
import finalHPGame.Spell.Spell;
import finalHPGame.Spell.nonrange.*;
import finalHPGame.Spell.rangepower.RangePower;

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
	//TODO: add the draw method for the invisible power
/*	public void draw(){
		
	}*/
	
	public boolean hasInvisiblePower(){
		return (spells[0]!=null);
	}
	public boolean hasSpeedPower(){
		return (spells[1]!=null);
	}
	public boolean hasCirlePower(){
		return (spells[2]!=null);
	}
	public boolean hasRangePower(){
		return (spells[3]!=null);
	}
	public InvisiblePower getInvisiblePower(){
		return (InvisiblePower) spells[0];
	}
	public SpeedPower getSpeedPower(){
		return (SpeedPower) spells[1];
	}
	public CirclePower getCirclePower(){
		return (CirclePower) spells[2];
	}
	public RangePower getRangePower(){
		return (RangePower) spells[3];
	}
}