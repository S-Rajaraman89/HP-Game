package finalHPGame.States;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class LoserPage extends BasicGameState{


	Image ready;
	Image bathroom;
	Image menuReturn;
	int posX;
	int posY;

	public LoserPage(int loser){
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		bathroom= new Image("res/bathroom.jpg");
		ready = new Image("res/replayLevel.png");
		menuReturn= new Image("res/menuReturn.png");      
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		bathroom.draw(0,0,1050,800);
		g.drawString("Instructions:", 100, 50);
		ready.draw(750,600);
		menuReturn.draw(100,600);
		g.drawString("x "+ posX+ "  y"+ posY,50,200);


	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		posX = Mouse.getX();
		posY = Mouse.getY();

		//play now button

		if((posX> gc.getWidth()-300 && posX<gc.getWidth()-100)&&(posY> gc.getHeight()-641 && posY<gc.getHeight()-601)){
			if(Mouse.isButtonDown(0)){
				System.out.println("clicked");
				
				if(Play.playLevel==1){
					sbg.getState(1).init(gc, sbg);
					sbg.enterState(1);
				}
				if(Play.playLevel==2){
					sbg.getState(2).init(gc, sbg);
					sbg.enterState(2);
				}
			}
		}
		else if((posX> gc.getWidth()-950 && posX<gc.getWidth()-750)&&(posY> gc.getHeight()-641 && posY< gc.getHeight()-601)){
			if(Mouse.isButtonDown(0)){
				System.out.println("clicked");
				sbg.getState(0).init(gc, sbg);
				sbg.enterState(0);
			}
		}


	}


	public int getID(){
		return 200;
	}
}