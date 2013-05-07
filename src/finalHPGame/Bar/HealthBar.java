package finalHPGame.Bar;

import org.newdawn.slick.Graphics;

/**Represents the HealthBar*/
public class HealthBar {
	/**Length of the bar. 0=dead*/
	private float healthBarX = 65;

	public HealthBar(){	}

	/**Draws the HealthBar in a green color*/
	public void draw(Graphics g){
		org.newdawn.slick.Color r = new org.newdawn.slick.Color(124, 252, 0);
		g.setColor(r);
		g.fillRect(50, 589, healthBarX, 10);
	}
	
	/**Decreases the HealthBar based on time*/
	public void decreaseHealthBar(float delta){
		if((healthBarX)>=0){
			healthBarX-=(delta*.010);
		}
		else if(healthBarX<0){
			healthBarX=0;
		}
	}
	/**@return the length of the bar*/
	public float getHealthBarX(){
		return healthBarX;
	}

}
