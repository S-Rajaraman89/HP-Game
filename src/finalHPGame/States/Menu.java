package finalHPGame.States;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;



public class Menu extends BasicGameState{


	Image playNow;
	Image exitGame;
	Image hogwarts3;


	public Menu(int state){
	}


	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		hogwarts3= new Image("res/hogwarts.jpg");
		playNow = new Image("res/playNow.png");
		exitGame = new Image("res/exitGame.png");


	}


	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		hogwarts3.draw(0,0,1050,800);
		g.drawString("Harry Potter!", 100, 50);
		playNow.draw(75,100);
		exitGame.draw(75,200);
		g.drawString("X: "+Mouse.getX()+"\nY: "+Mouse.getY(), 50, 400);
	}


	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{

		int posX = Mouse.getX();
		int posY = Mouse.getY();
		//play now button
		if((posX > gc.getWidth()-975 && posX<gc.getWidth()-775)&&(posY>gc.getHeight()-141 && posY<gc.getHeight()-101)){
			if(Mouse.isButtonDown(0)){
				sbg.enterState(100);
			}
		}
		//exit game
		if((posX>gc.getWidth()-975 && posX<gc.getWidth()-775)&&(posY>gc.getHeight()-241 && posY<gc.getHeight()-201)){
			if(Mouse.isButtonDown(0)){
				System.exit(0);
			}
		}
	}


	@Override
	public int getID(){
		return 0;
	}






}
