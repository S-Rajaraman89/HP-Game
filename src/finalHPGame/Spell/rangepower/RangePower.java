package finalHPGame.Spell.rangepower;

import java.util.ArrayList;

import org.newdawn.slick.Image;

import finalHPGame.CharList;
import finalHPGame.Location.Location;
import finalHPGame.Spell.Spell;
import finalHPGame.Spell.rangepower.bullet.Bullet;
import finalHPGame.Spell.rangepower.bullet.bulletconstant.BulletConstant;
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
	float speed;
	
	
	
	public RangePower(CharList list, Character User, float speed, Image image)
	{
		targets = list.getCharacterList();
		this.userLocation = User.getLocation();
		this.speed = speed;
		this.image = image;
	}
	
	public boolean isPlayable() //Check if target is magician or anything else
	{
		return isTargetPlayable;
			
	}
	
	public void addBullet(int direction) //add to arraylist
	{
		Bullet b = new Bullet(direction, userLocation.getCopyOfLocation(), speed, image);
		bullet.add(b);
		
		
	}
	
	public void updateBullet(int delta) //go through arraylist bullets & targets and update
	{
		for(int i = 0; i<bullet.size(); i++)
		{
			if(bullet.get(i).getMovable().canMove(bullet.get(i).getLocation(), speed)){
				for(int j = 0; j<targets.size(); j++){
					if(bullet.get(i).getLocation()!=targets.get(j).getLocation() ){
						bullet.get(i).update(delta);
					}
					else 
						targets.remove(j);
						j--;
				}
			}
			else
				bullet.remove(i);
				i--;
				
		}
	}
	
	
	
	
}
