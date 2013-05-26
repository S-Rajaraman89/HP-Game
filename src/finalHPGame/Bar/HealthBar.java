package finalHPGame.Bar;

import org.newdawn.slick.Graphics;

/**Represents the HealthBar*/
public class HealthBar {
	/**Length of the bar. 0=dead*/
	private float healthBarX;
	private float speed = (float) 0.01;

	public HealthBar(){	
		healthBarX = 65;
	}

	public HealthBar(float x){
		healthBarX = x;
	}

	/**Draws the HealthBar in a green color*/
	public void drawBar(Graphics g){
		org.newdawn.slick.Color r = new org.newdawn.slick.Color(124, 252, 0);
		g.setColor(r);
		g.fillRect(50, 589, healthBarX, 10);
	}

	/**Decreases the HealthBar based on time*/
	public void decreaseHealthBar(float delta){
		if((healthBarX)>=0){
			healthBarX-=(delta*speed);
		}
		else if(healthBarX<0){
			healthBarX=0;
		}
	}
	/**@return the length of the bar*/
	public float getHealthBarX(){
		return healthBarX;
	}

	/**Add more length to health bar*/
	public void addHP(float hp){
		healthBarX+=hp;
	}

	public float getSpeedOfReduction(){
		return speed;
	}

	public void subHP(){
		if((healthBarX)>=0){
			healthBarX-=13;
		}
		if(healthBarX<=0){
			healthBarX=0;
		}
	}
}
