package finalHPGame.States;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.imageout.ImageOut;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.EmptyTransition;
import org.newdawn.slick.state.transition.FadeInTransition;
import finalHPGame.CharList;
import finalHPGame.Map.*;


public class Play extends BasicGameState {


	int level;
	static int playLevel=0;
	 
	public Play(int play1) throws SlickException {
		level = play1;
		playLevel++;
	}

	Map worldMap;
	int timer = 0;
	CharList list;
	int htimer = 0;


	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		if(level==1)worldMap = new MapLevel1();
		else if(level==2)worldMap = new MapLevel2();
		else if(level==3)worldMap= new MapLevel3();
		list = new CharList(level);
		
	}


	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g)
			throws SlickException {
		worldMap.drawMap();
		list.drawEveryone();
		list.getMainCharacter().getMagicBar().drawBar(g);
		list.getMainCharacter().getHealthBar().draw(g);
		list.getMainCharacter().drawPowerCircle(g);
		list.drawShapes(g);
		g.drawString("Health "+list.getMainCharacter().getHealthBar().getHealthBarX(), 30, 220);
	}


	public void update(GameContainer gc, StateBasedGame arg1, int delta)
			throws SlickException {
		//System.out.println(list.getMainCharacter().getHealthBar().getHealthBarX());
		
		if(list.getMainCharacter().getHealthBar().getHealthBarX()==0){
			playLevel--;
			arg1.enterState(200, new EmptyTransition(), new FadeInTransition(new Color(200,0,0),1000));
		}
		else if(list.getCharacterList().size()==1 && list.getHorcruxes().size()==0){
			arg1.enterState(300);
		}


		list.killEnemies(list.getMainCharacter().getPowerCircle(), list.getMainCharacter().isPowerOn());
		list.removeHorcruxes();
		
	/*	timer+=delta;
		if(timer>=10){
			list.moveEnemies(delta);
			timer=0;
		}
	*/
/*		htimer+=delta;
		if(htimer>=1500){
			list.moveHorcruxes();
			htimer=0;
		}*/
		

		Input input = gc.getInput();

		if(input.isKeyDown(Input.KEY_UP)&&!list.getMainCharacter().isPowerOn()){
			list.getMainCharacter().setPositionY(-delta*list.getMainCharacter().getSpeed());
			list.getMainCharacter().getAnimationHolder().getMainChar().setAutoUpdate(true);
		}

		if(input.isKeyDown(Input.KEY_DOWN)&&!list.getMainCharacter().isPowerOn()){
			list.getMainCharacter().setPositionY(delta*list.getMainCharacter().getSpeed());
			list.getMainCharacter().getAnimationHolder().getMainChar().setAutoUpdate(true);
		}

		if(input.isKeyDown(Input.KEY_LEFT)&&!list.getMainCharacter().isPowerOn()){
			list.getMainCharacter().setPositionX(-delta*list.getMainCharacter().getSpeed());
			list.getMainCharacter().getAnimationHolder().getMainChar().setAutoUpdate(true);
		}

		if(input.isKeyDown(Input.KEY_RIGHT)&&!list.getMainCharacter().isPowerOn()){
			list.getMainCharacter().setPositionX(delta*list.getMainCharacter().getSpeed());
			list.getMainCharacter().getAnimationHolder().getMainChar().setAutoUpdate(true);
		}
		
		//Cannot be invisible and use the powerCircle
		if(input.isKeyDown(Input.KEY_SPACE)&& !list.getMainCharacter().isPowerOn()){
			list.getMainCharacter().setInvisibleTrue(delta);
		}
		//Cannot be invisible and use the powerCircle
		if(input.isKeyDown(Input.KEY_F)&&!list.getMainCharacter().isInvisible()){
			list.getMainCharacter().powerCircleOn(delta);
		}

		if(!input.isKeyDown(Input.KEY_F)){
			list.getMainCharacter().powerCircleOff(delta);
		}

		if(!input.isKeyDown(Input.KEY_SPACE)){
			list.getMainCharacter().setInvisibleFalse();
		}

		//if the user is pressing down a,
		//then the speed of main character increases
		if(input.isKeyDown(Input.KEY_A)){
			list.getMainCharacter().setSpeedFast(delta);
		}

		//if the user is not pressing a,
		//the speed is back to normal
		if(!input.isKeyDown(Input.KEY_A)){
			list.getMainCharacter().setSpeedNormal();
		}

		//IF the user is not using any of the powers, then load the magicbar
		if(!input.isKeyDown(Input.KEY_A) 
				&& ! input.isKeyDown(Input.KEY_SPACE) 
				&& ! input.isKeyDown(Input.KEY_F)){
			list.getMainCharacter().getMagicBar().reviveMagicBar(delta);
		}

		//When the user press s, then it takes a screenshoot
		if (gc.getInput().isKeyPressed(Input.KEY_S)) {
			Image target = new Image(gc.getWidth(), gc.getHeight());
			gc.getGraphics().copyArea(target, 0, 0);
			ImageOut.write(target.getFlippedCopy(false, false), "screenshot.png", false);
			target.destroy();
		}
		
		if(!(input.isKeyDown(Input.KEY_DOWN)||input.isKeyDown(Input.KEY_LEFT)||
				input.isKeyDown(Input.KEY_UP)||
				input.isKeyDown(Input.KEY_RIGHT))){
			list.getMainCharacter().getAnimationHolder().getMainChar().setAutoUpdate(false);
		}

	}

	//returns level which is the ID of this GameState
	public static int getPlayLevel(){
		return playLevel;
	}

	//returns level which is the ID of this GameState
	@Override
	public int getID() {
		return level;
	}

}
