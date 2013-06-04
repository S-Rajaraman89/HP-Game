package finalHPGame.Spell.rangepower;

import java.util.ArrayList;
import org.newdawn.slick.Graphics;
import finalHPGame.CharList;
import finalHPGame.Location.Location;
import finalHPGame.Spell.Spell;
import finalHPGame.Spell.rangepower.bullet.Bullet;
import finalHPGame.Characters.Character;
import finalHPGame.Characters.Magician;

public class RangePower implements Spell {


	Location userLocation;
	ArrayList<Character> targets;
	ArrayList<Bullet> bullet;
	private boolean isPlayable;
	private float speed;
	private int startingIndex;
	private int finishingIndex;

	public RangePower(CharList list, Location userLocation, float speed, boolean playable)
	{
		bullet = new ArrayList<Bullet>();
		targets = list.getCharacterList();
		this.userLocation = userLocation;
		this.speed = speed;
		this.isPlayable = playable;
	}

	public boolean isPlayable() //Check if target is magician or anything else
	{
		return isPlayable;
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
		setIndex();	
		for(int x = 0; x<bullet.size();x++){
			Bullet currentbullet = bullet.get(x);

			if(currentbullet.update(delta)){
				if(targets.size()>1){
					for(int i=startingIndex; i<finishingIndex;i++){
						Character enemy = targets.get(i);


						if(enemy.getPersonalSpace().intersects(currentbullet.getPersonal())){
							bullet.remove(x);
							--x;

							if(isPlayable){
								if(enemy.getName().equals("spider")|| enemy.getName().equalsIgnoreCase("dementor")){
								targets.remove(i);
								--i;
								}
							}
							else{
								((Magician) targets.get(0)).getHealthBar().subHP();
							}
							break;
						}
						this.setIndex();
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
	public void setIndex(){
		if(isPlayable){
			startingIndex = 1;
			finishingIndex = targets.size();
		}
		else{
			startingIndex = 0;
			finishingIndex = 1;
		}
	}
}
