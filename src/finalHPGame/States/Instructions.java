package finalHPGame.States;


import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import java.awt.Font;

public class Instructions extends BasicGameState{


	Image ready;
	Image bathroom;
	int posX;
	int posY;
	TrueTypeFont font;
	public Instructions(int state){
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		bathroom= new Image("res/bathroom.jpg");
		ready = new Image("res/playNow.png");
		//exitGame = new Image("res/exitGame.png");

	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		bathroom.draw(0,0,1050,800);

		Font f = new Font ("Garamond", Font.BOLD , 30);
		font= new TrueTypeFont(f,false);
		font.drawString(150,50,"Lord Voldemort is considered the most powerful dark wizard of all", Color.white);
		font.drawString(100, 100," time. In order to obtain morality, he has hidden fragments of his soul ");
		font.drawString(100,150, "in objects referred to Horcruxes.", Color.white);
		font.drawString(150, 250, "The only way for Harry to kill Lord Voldemort for good is to destroy", Color.white);
		font.drawString(100, 300, "all seven horcruxes. But, that's not as easy as it seems. There are always",Color.white);
		font.drawString(100, 350, "dark creatures ready to battle. Thankfully, Harry has his wizarding",Color.white);
		font.drawString(100,400,"friends and magic powers to help.", Color.white);
		ready.draw(750,600);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		posX = Mouse.getX();
		posY = Mouse.getY();

		//play now button
		if((posX> gc.getWidth()-300 && posX<gc.getWidth()-100)&&(posY> gc.getHeight()-641 && posY< gc.getHeight()-601)){
			if(Mouse.isButtonDown(0)){
				sbg.getState(1).init(gc, sbg);
				sbg.enterState(1);
			}
		}
		/* //exit game
	      if((posX>100 && posX<311)&&(posY>109 && posY<160)){
	         if(Mouse.isButtonDown(0)){
	            System.exit(0);
	         }
	      }*/
	}

	public int getID(){
		return 100;
	}

}
