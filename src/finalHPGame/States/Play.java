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


public class Play extends BasicGameState {


	int level;
	static int playLevel;
	public Play(int play1) throws SlickException {
		level = play1;
		playLevel = level;
	}


	Image worldMap;

	//Enemy a;

	int timer = 0;
	CharList list;

	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {

		if(level==1)worldMap = new Image("res/chamberColor.jpg");
		if(level==2)worldMap = new Image("res/Quiddich.jpg");


		list = new CharList(level);
	}


	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g)
			throws SlickException {

		worldMap.draw(0,0);

		list.drawEveryone();
		list.getMainCharacter().getMagicBar().drawBar(g);
		list.getMainCharacter().getHealthBar().draw(g);
		list.getMainCharacter().drawPowerCircle(g);

	}


	public void update(GameContainer gc, StateBasedGame arg1, int delta)
			throws SlickException {

		if(list.getMainCharacter().getHealthBar().getHealthBarX()==0){
			arg1.enterState(200, new EmptyTransition(), new FadeInTransition(new Color(200,0,0),1000));

		}
		else if(list.getCharacterList().size()==1){
			arg1.enterState(300);
		}


		list.killEnemies(list.getMainCharacter().getPowerCircle(), list.getMainCharacter().isPowerOn());
		timer+=delta;
		if(timer>=250){
			list.moveEnemies(delta);
			timer=0;
		}


		Input input = gc.getInput();

		if(input.isKeyDown(Input.KEY_UP)&&!list.getMainCharacter().isPowerOn()){
			list.getMainCharacter().setPositionY(-delta*list.getMainCharacter().getSpeed());

		}

		if(input.isKeyDown(Input.KEY_DOWN)&&!list.getMainCharacter().isPowerOn()){
			list.getMainCharacter().setPositionY(delta*list.getMainCharacter().getSpeed());

		}

		if(input.isKeyDown(Input.KEY_LEFT)&&!list.getMainCharacter().isPowerOn()){
			list.getMainCharacter().setPositionX(-delta*list.getMainCharacter().getSpeed());

		}

		if(input.isKeyDown(Input.KEY_RIGHT)&&!list.getMainCharacter().isPowerOn()){
			list.getMainCharacter().setPositionX(delta*list.getMainCharacter().getSpeed());

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

	}

	//returns level which is the ID of this GameState
	public static int getPlayLevel(){
		return playLevel;
	}

	//returns level which is the ID of this GameState
	public int getID() {
		return level;
	}

}
