package finalHPGame.Characters;

import org.newdawn.slick.SlickException;
import finalHPGame.Movable.DementorMove;
import finalHPGame.Movable.Movable;
import finalHPGame.Movable.SnakeMove;


public class Enemy extends Character {
	
	Movable move;
	
	public Enemy(float x, float y, String n, int level) throws SlickException{
		super(x,y,n,level);
		if(n.equalsIgnoreCase("snake")){
			move = new SnakeMove();
		}
		else if(n.equalsIgnoreCase("d")){
			move = new DementorMove();
		}
	}

	//moves the enemy object towards
	//the target which is the playable character
	public void moveToward(Magician target){
		move.moveCharacter(target, this);
	}
	
	
}
