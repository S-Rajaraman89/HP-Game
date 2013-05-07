package finalHPGame.Data.characters;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import finalHPGame.Data.Data;
import finalHPGame.HealthDecreaser.SpiderHealthDecreaser;
import finalHPGame.Location.Location;

/**
 *Holds the variables for the Spider
 */
public class SpiderData extends Data {
//TODO:Add Updater
//TODO: Add Personal
//TODO: Add Move
public SpiderData(float x, float y, int level) throws SlickException{
	myLoc = new Location(x,y,level);
	name = "spider";
	decreaser = new SpiderHealthDecreaser(level);
	init();
}

public void init() throws SlickException{
	int[] duration = {200,200,200};
	Image[] down = {new Image("res/spiderFinal.png"), 
			new Image("res/spiderFinal.png"), 
			new Image("res/spiderFinal.png")};
	movingDown = new Animation(down,duration,false);
	movingLeft = movingDown;
	movingRight = movingDown;
	movingUp = movingDown;
}
}
