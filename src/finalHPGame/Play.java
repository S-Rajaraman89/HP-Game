package finalHPGame;




import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.imageout.ImageOut;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Play extends BasicGameState {


	int level;
	public Play(int play1) throws SlickException {
		level = play1;
	}

	Magician hp;
	Image worldMap;

	Enemy a;

	int timer = 0;


	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {

		hp = new Magician(200,300,"hp",1);

		if(level==1)worldMap = new Image("res/chamberColor.jpg");
		if(level==2)worldMap = new Image("res/Quiddich.jpg");

		a = new Enemy(400,200,"snake",1);

	}


	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g)
			throws SlickException {

		worldMap.draw(0,0);

		hp.draw();
		hp.getHealthBar().draw(g);
		hp.getMagicBar().drawBar(g);

		/*org.newdawn.slick.Color r = new org.newdawn.slick.Color(255, 0, 0);
		g.setColor(r);*/

		hp.drawPowerCircle(g);


	}


	public void update(GameContainer gc, StateBasedGame arg1, int delta)
			throws SlickException {
		timer+=delta;
		if(timer>=500){
			System.out.println("is Power on: "+hp.isPowerOn());
			System.out.println("is invisible on: "+hp.isInvisble());
			timer=0;
		}

		Input input = gc.getInput();

		if(input.isKeyDown(Input.KEY_UP)){
			hp.setPositionY(-delta * hp.getSpeed());

		}

		if(input.isKeyDown(Input.KEY_DOWN)){
			hp.setPositionY(delta*hp.getSpeed());
		}

		if(input.isKeyDown(Input.KEY_LEFT)){
			hp.setPositionX(-delta*hp.getSpeed());
		}

		if(input.isKeyDown(Input.KEY_RIGHT)){
			hp.setPositionX(delta*hp.getSpeed());
		}

		if(input.isKeyDown(Input.KEY_SPACE)){
			hp.setInvisibleTrue(delta);
		}

		if(input.isKeyDown(Input.KEY_F)){
			hp.powerCircleOn(delta);
		}

		if(!input.isKeyDown(Input.KEY_F)){
			hp.powerCircleOff(delta);
		}

		if(!input.isKeyDown(Input.KEY_SPACE)){
			hp.setInvisibleFalse();
		}

		//if the user is pressing down a,
		//then the speed of main character increases
		if(input.isKeyDown(Input.KEY_A)){
			hp.setSpeedFast(delta);
		}

		//if the user is not pressing a,
		//the speed is back to normal
		if(!input.isKeyDown(Input.KEY_A)){
			hp.setSpeedNormal();
		}

		//IF the user is not using any of the powers, then load the magicbar
		if(! input.isKeyDown(Input.KEY_A) 
			&& ! input.isKeyDown(Input.KEY_SPACE) 
			&& ! input.isKeyDown(Input.KEY_F)){
			
					hp.getMagicBar().reviveMagicBar(delta);
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

	public int getID() {
		return level;
	}

}
