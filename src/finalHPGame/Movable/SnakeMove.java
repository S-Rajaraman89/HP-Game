package finalHPGame.Movable;

import finalHPGame.Characters.Enemy;
import finalHPGame.Characters.Magician;

public class SnakeMove implements Movable {

	/**Decides and calls which directions to move the Character*/
	@Override
	public void moveCharacter(Magician target, Enemy self) {
		if(target.isInvisible()){

		}
		else{
			float targetX = target.getPositionX();
			float targetY = target.getPositionY();
			float moveX = (float) ((Math.random()*10)+1);
			float moveY = (float) ((Math.random()*10)+1);
			int random = (int)(Math.random()*3)+1;
			if(random==1){
				this.moveX(targetX, self, moveX);
			}
			else if(random==2){
				this.moveY(targetY, self, moveY);
			}
			else{
				this.moveX(targetX, self, moveX);
				this.moveY(targetY, self, moveY);
			}
		}
			
		
		self.updatePersonal();

	}
	
	/**Moves the Character only on the y axis*/
	public void moveY(float targetY, Enemy self, float moveY){
		if(targetY>self.getPositionY()){
			self.setPositionY(moveY);
		}
		else{
			self.setPositionY(-moveY);
		}
	}
	
	/**Moves the Character only on the x axis*/
	public void moveX(float targetX, Enemy self, float moveX){
		if(targetX>self.getPositionX()){
			self.setPositionX(moveX);
		}
		else{
			self.setPositionX(-moveX);
		}
	}

}
