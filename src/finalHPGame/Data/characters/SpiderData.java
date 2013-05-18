package finalHPGame.Data.characters;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import finalHPGame.Data.Data;
import finalHPGame.HealthDecreaser.SpiderHealthDecreaser;
import finalHPGame.Location.Location;
import finalHPGame.Movable.SpiderMove;
import finalHPGame.ShapeUpdater.CharacterUpdater.SpiderUpdater;

/**
 *Holds the variables for the Spider
 */
public class SpiderData extends Data {
//TODO:Add Updater
//TODO: Add Personal
public SpiderData(float x, float y, int level) throws SlickException{
	myLoc = new Location(x,y,level);
	name = "spider";
	decreaser = new SpiderHealthDecreaser(level);
	move = new SpiderMove();
	updater = new SpiderUpdater();
	init();
	personal = new Rectangle(myLoc.getX()+35,myLoc.getY()+30,35,30);
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
