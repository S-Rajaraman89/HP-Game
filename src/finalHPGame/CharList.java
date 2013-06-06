package finalHPGame;

import java.util.ArrayList;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Shape;
import finalHPGame.Characters.*;
import finalHPGame.Characters.Character;
import finalHPGame.Data.characters.*;
import finalHPGame.Data.horcrux.*;

/**Contains the Characters in the game*/
public class CharList {
	/**Contains the Characters*/
	private ArrayList<Character> characters;
	private ArrayList<Character> horcruxes;


	/**The Character in the list is based on the level*/
	public CharList(int level) throws SlickException{
		characters = new ArrayList<Character>();
		horcruxes = new ArrayList<Character>();

		//add the characters we would have in level one.
		if(level==1){

			/*The first character is always the playable character
			  in this level it is Harry*/

			characters.add(new Magician(new HarryData(300,140,level),this));
			characters.add(new Enemy(new SpiderData(300,400,level,this)));
			horcruxes.add(new Enemy(new CupData(200,200,level)));
			horcruxes.add(new Enemy(new JournalData(299,303,level)));

			for(int x = 1; x<10; x++){
				// to make sure the objects don't 
				//have the same x and y coordinates to begin with.
				float randx = (float)Math.random()*200;
				float randy = (float)Math.random()*300;
				characters.add(new Enemy(new SnakeData(250+randx,300+randy,level)));
			}
		}
		else if(level==2){
			characters.add(new Magician(new RonData(25,300,level), this));
			characters.add(new Enemy(new DementorData(450,400,level)));
			characters.add(new Enemy(new DementorData(300,230,level)));
			characters.add(new Enemy(new DementorData(680,259,level)));
			characters.add(new Enemy(new SpiderData(300,320,level,this)));
			characters.add(new Enemy(new SpiderData(700,400,level,this)));
			characters.add(new Enemy(new SpiderData(600,400,level,this)));
			horcruxes.add(new Enemy(new RingData(299,303,level)));
			horcruxes.add(new Enemy(new LocketData(200,200,level)));
			
		}
		else if(level==3){
			characters.add(new Magician(new HarryData(140,300,level),this));
			characters.add(new Enemy(new DementorData(300,400,level)));
			characters.add(new Enemy(new SpiderData(300,300,level,this)));
			characters.add(new Enemy(new SpiderData(700,400,level,this)));
			characters.add(new Enemy(new SpiderData(250,400,level,this)));
			characters.add(new Enemy(new SpiderData(250,300,level,this)));
			characters.add(new Enemy(new SpiderData(700,400,level,this)));
			characters.add(new Enemy(new SpiderData(600,400,level,this)));
			horcruxes.add(new Enemy(new CupData(299,303,level)));
		}
	}

	/**Draws every character in the list*/
	public void drawEveryone(){
		for(Character c: characters){
			c.draw();
		}
		for(Character c: horcruxes){
			c.draw();
		}
	}

	/**Moves the Horcruxes*/
	public void moveHorcruxes(int delta){
		for(Character c: horcruxes){
			if(c instanceof Enemy){
				((Enemy) c).moveToward(this,delta);
			}
		}
	}
	/**Returns the Horcruxes List*/
	public ArrayList<Character> getHorcruxes(){
		return horcruxes;
	}

	/**If the mainCharacter intersects the horcrux, then remove it*/
	public void removeHorcruxes(){
		for(int x=0; x<horcruxes.size();x++){
			if(horcruxes.get(x).getPersonalSpace().intersects(this.getMainCharacter().getPersonalSpace())){
				horcruxes.remove(x);
			}
		}
	}

	/**Prints every character in the list*/
	public void printEveryone(){
		for(Character c: characters){
			System.out.println(c);
		}
	}

	/**Gets the list of characters*/
	public ArrayList<Character> getCharacterList(){
		return characters;
	}

	/**gets the main character in the list*/
	public Magician getMainCharacter(){
		return (Magician) characters.get(0);
	}

	/**The enemies will be removed if considered "killed"*/
	/*Killed = If the user is pressing F and the enemy intersects with
	the circle spell.*/
	public void killEnemies(){
		boolean isUsing = this.getMainCharacter().getCirclePower().isPowerOn();
		Shape spellBound = this.getMainCharacter().getCirclePower().getPowerCircle();
		if(isUsing){
			//Get all the enemies in the list
			for(int x = 0; x<characters.size();x++){
				if(characters.get(x) instanceof Enemy){
					//if the enemy intersects, then remove it.
					if(spellBound.intersects(characters.get(x).getPersonalSpace())){
						if(characters.get(x).getName().equalsIgnoreCase("snake")){
							characters.remove(x);
							--x;
						}
					}
				}
			}
		}
	}


	/**Calls the move method by all Enemies
	 * @param delta - how long the main character has moved
	 */
	public void moveEnemies(int delta){
		for(Character c: characters){
			if(c instanceof Enemy){
				((Enemy) c).moveToward(this, delta);	
				float decreaser = (float) ((Enemy) c).getConstant().getDecreaser();

				if( ((Enemy) c).getPersonalSpace().intersects(this.getMainCharacter().getPersonalSpace())){

					getMainCharacter().decreaseHealth(delta*decreaser);

				}
			}
		}
	}

	/**Draws the personalShape on each Character*/
	public void drawShapes(Graphics g){
		for(Character c: characters){
			c.drawPersonal(g);
		}
		for(Character c: horcruxes){
			c.drawPersonal(g);
		}
	}

	public void updateAllBullet(int delta){
		getMainCharacter().getRangePower().updateBullet(delta);
		for(int x = 1; x<characters.size();x++){
			Character e = characters.get(x);
			if(e instanceof Enemy && ((Enemy) e).hasRangePower()){
				((Enemy) e).getRangePower().updateBullet(delta);
			}
		}
	}

	public void drawPowers(Graphics g){
		getMainCharacter().getRangePower().draw(g);
		for(int x = 1; x<characters.size();x++){
			Character e = characters.get(x);
			if(e instanceof Enemy){
				Enemy current = (Enemy)e;
				if(current.hasRangePower()){
					current.getRangePower().draw(g);
				}

				if(current.hasInvisiblePower()){
					current.draw();
				}

				if(current.hasCirlePower()){
					current.getCirclePower().drawPowerCircle(g);
				}
			}
		}
	}
}
