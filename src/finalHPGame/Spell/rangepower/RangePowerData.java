package finalHPGame.Spell.rangepower;

import java.util.ArrayList;

import org.newdawn.slick.Image;

import finalHPGame.Spell.rangepower.bullet.Bullet;
import finalHPGame.Spell.rangepower.bullet.bulletconstant.BulletConstant;
import finalHPGame.Spell.rangepower.bullet.movable.BulletMovable;

public class RangePowerData {

	protected ArrayList<Bullet> bullets = null;
	protected BulletConstant constants = null;
	protected int limit;
	protected Image bulletImage = null;
	protected BulletMovable movable = null;
	protected boolean isPlayable;
	
	public BulletMovable getBulletMovable(){
		return movable;
	}
	
	
	
	
	
	
	
}
