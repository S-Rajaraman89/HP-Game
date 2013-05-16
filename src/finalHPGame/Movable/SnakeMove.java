package finalHPGame.Movable;

import finalHPGame.CharList;
import finalHPGame.Characters.Enemy;
import finalHPGame.Characters.Magician;

public class SnakeMove implements Movable {

	/**Decides and calls which directions to move the Character*/
	public void moveCharacter(CharList list, Enemy self, int delta) {
		Magician target = list.getMainCharacter();
		if(target.isInvisible()){

		}
		else{
			float targetX = target.getPositionX();
			float targetY = target.getPositionY();
			float moveX = (float) ((Math.random()*0.5)+1);
			float moveY = (float) ((Math.random()*0.5)+1);
			int random = (int)(Math.random()*3)+1;
			int randomnNegativeX = (int)(Math.random()*5);
			int randomnNegativeY = (int)(Math.random()*5);
			
			if(random==1){
				this.moveX(targetX, self, moveX,randomnNegativeX);
			}
			else if(random==2){
				this.moveY(targetY, self, moveY,randomnNegativeY);
			}
			else{
				this.moveX(targetX, self, moveX,randomnNegativeX);
				this.moveY(targetY, self, moveY,randomnNegativeY);
			}
		}
			
		
		self.updatePersonal();

	}
	
	/**Moves the Character only on the y axis*/
	public void moveY(float targetY, Enemy self, float moveY,int negativeY){
		int negative = 1;
		if(negativeY<=1) negative = -1;
		
		if(targetY>self.getPositionY()){
			self.setPositionY(moveY*negative);
		}
		else{
			self.setPositionY(-moveY*negative);
		}
	}
	
	/**Moves the Character only on the x axis*/
	public void moveX(float targetX, Enemy self, float moveX,int negativeX){
		int negative = 1;
		if(negativeX<=1) negative = -1;
		
		if(targetX>self.getPositionX()){
			self.setPositionX(moveX*negative);
		}
		else{
			self.setPositionX(-moveX*negative);
		}
	}

}
