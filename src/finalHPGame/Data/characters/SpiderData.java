package finalHPGame.Data.characters;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import finalHPGame.CharList;
import finalHPGame.Constant.SpiderConstant;
import finalHPGame.Data.Data;
import finalHPGame.Location.Location;
import finalHPGame.Movable.SpiderMove;
import finalHPGame.ShapeUpdater.CharacterUpdater.SpiderUpdater;
import finalHPGame.Spell.rangepower.RangePower;

/**
 *Holds the variables for the Spider
 */
public class SpiderData extends Data {

	public SpiderData(float x, float y, int level, CharList list) throws SlickException{
		super();
		myLoc = new Location(x,y,level);
		name = "spider";
		constant = new SpiderConstant(level);
		move = new SpiderMove();
		updater = new SpiderUpdater();
		init();
		personal = new Rectangle(myLoc.getX()+35,myLoc.getY()+30,35,30);
		spells[3] = new RangePower(list, this.myLoc, constant.getSpeed(), false);
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
