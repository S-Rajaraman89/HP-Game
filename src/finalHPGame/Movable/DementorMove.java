package finalHPGame.Movable;

import org.newdawn.slick.geom.Rectangle;

import finalHPGame.Characters.Enemy;
import finalHPGame.Characters.Magician;

public class DementorMove implements Movable {

	/**The Dementor moves directly (no bounds) towards the target.*/
	public void moveCharacter(Magician target, Enemy self) {
		float targetX = target.getPositionX();
		float targetY = target.getPositionY();
		Rectangle selfShape = (Rectangle) self.getPersonalSpace();
		Rectangle targetShape = (Rectangle) target.getPersonalSpace();
		
		if(!selfShape.intersects(targetShape) 
				|| Math.abs(selfShape.getCenterX()-targetShape.getCenterX())>6
				||Math.abs(selfShape.getCenterY()-targetShape.getCenterY())>6){
			
			if(Math.abs(targetY-self.getPositionY())<=2){
			}
			else if(targetX>self.getPositionX()){
				self.getAnimationHolder().setAnimation(self.getLocation().addX((float) .77));
			}
			else{
				self.getAnimationHolder().setAnimation(self.getLocation().addX((float) -.77));
			}


			if(Math.abs(targetY-self.getPositionY())<=8){
			}
			else if(targetY>self.getPositionY()){
				self.getAnimationHolder().setAnimation(self.getLocation().addY((float) .77));
			}
			else{
				self.getAnimationHolder().setAnimation(self.getLocation().addY((float) -.77));
			}
			self.updatePersonal();
		}
	}


}


