package finalHPGame.Spell.rangepower;

import java.util.ArrayList;

import org.newdawn.slick.Image;

import finalHPGame.CharList;
import finalHPGame.Location.Location;
import finalHPGame.Spell.Spell;
import finalHPGame.Spell.rangepower.bullet.Bullet;
import finalHPGame.Spell.rangepower.bullet.bulletconstant.BulletConstant;
import finalHPGame.Spell.rangepower.data.RangeData;
import finalHPGame.Characters.Character;

public class RangePower implements Spell {

	
	int limit;
	Image image;
	Location userLocation;
	ArrayList<Character> targets;
	ArrayList<Bullet> bullet;
	boolean isTargetPlayable;
	BulletConstant bulletConstant;
	Character User;
	
	
	
	public RangePower(RangeData data, CharList list, Character User)
	{
		targets = list.getCharacterList();
		this.userLocation = User.getLocation();
		
		
	}
	
	public boolean isPlayable() //Check if target is magician or anything else
	{
		return isTargetPlayable;
			
	}
	
	public void addBullet()
	{
		
	}
	
	public void updateBullet(int delta)
	{
		
	}
	
	
}
