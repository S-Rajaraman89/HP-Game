package finalHPGame.Spell.nonrange;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;
import finalHPGame.Characters.Character;

public class CirclePower extends NonRange {
	
	private Circle power;
	private int powerRadius;
	private int timer;
	
	public CirclePower(float x, float y){
		super();
		powerRadius = 40;
		power = new Circle(0,0,0);
		timer = 0;
		
	}
	public Shape getPowerCircle(){
		return power;
	}
	
	/**Draws the circle*/
	public void drawPowerCircle(Graphics g){
		org.newdawn.slick.Color r = new org.newdawn.slick.Color(0, 0, 100);
		g.setColor(r);
		g.draw(power);
	}
	
	/**Updates the circle based on delta and isPowerOn*/
	public void updateCircle(int delta, Character self){
		if(super.isPowerOn){
			power.setCenterX(self.getPositionX()+50);
			power.setCenterY(self.getPositionY()+40);
			power.setRadius(powerRadius);
			
			timer+=delta;
			if(powerRadius>=1 && timer>=500){
				powerRadius-=10;
				timer = 0;
			}
			
			power.setRadius(powerRadius);
		}
		
		else{
			reset();
		}

	}
	public void reset(){
		powerRadius = 40;
		timer = 0;
		power.setCenterX(0);
		power.setCenterY(0);
		power.setRadius(0);
	}
	/**Sets isPowerOn false. Updates the*/
	public void setPowerOff(){
		this.isPowerOn=false;
		reset();
	}
	
}
