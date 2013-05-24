package finalHPGame.Spell.rangepower;

import java.util.ArrayList;
import org.newdawn.slick.Graphics;
import finalHPGame.CharList;
import finalHPGame.Location.Location;
import finalHPGame.Spell.Spell;
import finalHPGame.Spell.rangepower.bullet.Bullet;
import finalHPGame.Spell.rangepower.bullet.bulletconstant.BulletConstant;
import finalHPGame.Characters.Character;

public class RangePower implements Spell {


	int limit;
	Location userLocation;
	ArrayList<Character> targets;
	ArrayList<Bullet> bullet;
	boolean isTargetPlayable;
	BulletConstant bulletConstant;
	Character User;
	float speed;



	public RangePower(CharList list, Character User, float speed)
	{
		bullet = new ArrayList<Bullet>();
		targets = list.getCharacterList();
		this.userLocation = User.getLocation();
		this.speed = speed;
		
	}

	public boolean isPlayable() //Check if target is magician or anything else
	{
		return isTargetPlayable;

	}

	public void addBullet(int direction) //add to arraylist
	{
		Bullet b = new Bullet(direction, userLocation.getCopyOfLocation(), speed);
		bullet.add(b);	
	}
	
	/* 1. Add the bullet to the bulletlist
	 * 2. Update the bullets in the list
	 * 		In the Bullet class:
	 * 			-Move the bullet
	 * 			-Check and return for boundaries
	 * 		In the RangePower:
	 * 		-If the bullet hits the a boundary, delete it
	 * 		-If the bullet hits the a target, delete the character and delete the bullet
	 * 
	 */
	public void updateBullet(int delta) //go through arraylist bullets & targets and update
	{
		for(int x = 0; x<bullet.size();x++){
			Bullet currentbullet = bullet.get(x);
			
			if(currentbullet.update(delta)){
				for(int i=1; i<targets.size();i++){
					Character enemy = targets.get(i);
					
					if(enemy.getPersonalSpace().intersects(currentbullet.getPersonal())){
						targets.remove(i);
						--i;
						bullet.remove(x);
						--x;
						break;
					}
				}
			}		
			else{
				bullet.remove(x);
				--x;
			}
			
		}
		
	}

	public void draw(Graphics g){
		for(Bullet current: bullet){
			current.draw(g);
		}
	}
}
