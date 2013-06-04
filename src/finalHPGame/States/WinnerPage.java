package finalHPGame.States;


import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.particles.ConfigurableEmitter;
import org.newdawn.slick.particles.ParticleIO;
import org.newdawn.slick.particles.ParticleSystem;
import org.newdawn.slick.state.*;

public class WinnerPage extends BasicGameState{


	Image nextLevel;
	Image winningPic;
	Image menuReturn;
	int posX;
	int posY;
	ParticleSystem system;

	public WinnerPage(int winner){
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		winningPic= new Image("res/winningPic.jpg");
		nextLevel = new Image("res/nextLevel.png");
		menuReturn= new Image("res/menuReturn.png");
		system = new ParticleSystem(new Image("data/particle.png",false),1500);
		try {	
			ConfigurableEmitter emitter = ParticleIO.loadEmitter(WinnerPage.class.getResourceAsStream("resData/torch.xml"));
			emitter.setPosition(130, 430);
			system.addEmitter(emitter);

			emitter = ParticleIO.loadEmitter(WinnerPage.class.getResourceAsStream("resData/torch.xml"));
			emitter.setPosition(965, 430);
			system.addEmitter(emitter);

		} catch (Exception e) {
			System.out.println("Exception: " +e.getMessage());
			e.printStackTrace();
			System.exit(0);
		}
		system.setBlendingMode(ParticleSystem.BLEND_ADDITIVE);

	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		winningPic.draw(0,0,1050,800);
		nextLevel.draw(750,600);
		menuReturn.draw(100,600);
		system.render();

	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		system.update(delta);
		posX = Mouse.getX();
		posY = Mouse.getY();
		if(Play.playLevel==4){
			nextLevel = new Image("res/exitGame.png");
		}

		if((posX> gc.getWidth()-300 && posX< gc.getWidth()-100)&&(posY>gc.getHeight()-641 && posY< gc.getHeight()-601)){
			if(Mouse.isButtonDown(0)){
				if(Play.playLevel==4){
					System.exit(0);
				}
				sbg.getState(Play.playLevel).init(gc, sbg);
				sbg.enterState(Play.playLevel);
			}
		}
		else if((posX>gc.getWidth()-950 && posX< gc.getWidth()-750)&&(posY>gc.getHeight()-641 && posY<gc.getHeight()-601)){
			if(Mouse.isButtonDown(0)){
				sbg.getState(0).init(gc, sbg);
				sbg.enterState(0);
			}
		}

	}

	public int getID(){
		return 300;
	}
}