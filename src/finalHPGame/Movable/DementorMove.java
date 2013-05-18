package finalHPGame.Movable;

import org.newdawn.slick.geom.Rectangle;

import finalHPGame.CharList;
import finalHPGame.Characters.Enemy;
import finalHPGame.Characters.Magician;

public class DementorMove implements Movable {

	private int timer;

	public DementorMove(){
		timer = 0;
	}
	/**The Dementor moves directly (no bounds) towards the target.*/
	public void moveCharacter(CharList list, Enemy self, int delta) {
		timer+=delta;
		if(timer>=10){
			timer =0;
			Magician target = list.getMainCharacter();
			float targetX = target.getPositionX();
			float targetY = target.getPositionY();
			Rectangle selfShape = (Rectangle) self.getPersonalSpace();
			Rectangle targetShape = (Rectangle) target.getPersonalSpace();

			if((!selfShape.intersects(targetShape) 
					|| Math.abs(selfShape.getCenterX()-targetShape.getCenterX())>6
					||Math.abs(selfShape.getCenterY()-targetShape.getCenterY())>6) && !target.isPowerOn()){

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
		//TODO: Move the dementor away from the the target when isPowerOn()
		/*
		 * Move away in a direction away from the target in a straight line
		 * Check if the thing is not intersects
		 */
	}
}


