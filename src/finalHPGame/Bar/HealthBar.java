package finalHPGame.Bar;

import org.newdawn.slick.Graphics;

public class HealthBar {
	private float healthBarX = 65;

	public HealthBar(){

	}

	public void draw(Graphics g){
		org.newdawn.slick.Color r = new org.newdawn.slick.Color(124, 252, 0);
		g.setColor(r);
		g.fillRect(50, 589, healthBarX, 10);
	}

	public void decreaseHealthBar(float delta){
		if((healthBarX-delta)>=0){
			healthBarX-=delta;
		}
		else if(healthBarX-delta<0){
			healthBarX=0;
		}
	}
	public float getHealthBarX(){
		return healthBarX;
	}

}
