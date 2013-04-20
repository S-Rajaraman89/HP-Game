package finalHPGame.Characters;

import org.newdawn.slick.SlickException;


public class Enemy extends Character {
	
	/*Notes:
	   To make a rectangle that will fit for a snake:
	   new Rectangle(a.getPositionX()+35,a.getPositionY()+5,25,80);
	   
		*/
	
	public Enemy(float x, float y, String n, int level) throws SlickException{
		super(x,y,n,level);
	}

	//moves the enemy object towards
	//the target which is the playable character
	public void moveToward(Character target, boolean isInvisible){
		if(isInvisible){
			
		}
		else{
			float targetX = target.getPositionX();
			float targetY = target.getPositionY();

			if(targetX>super.getPositionX()){
				super.setPositionX(10);
			}
			else{
				super.setPositionX(-10);
			}


			if(targetY>getPositionY()){
				super.setPositionY(10);
			}
			else{
				super.setPositionY(-10);
			}
		}
		super.updatePersonal();
		
	}
	
	
}
