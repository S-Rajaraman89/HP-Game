package finalHPGame;




import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.imageout.ImageOut;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Play extends BasicGameState {


	int level;
	public Play(int play1) throws SlickException {
		level = play1;
	}

	CharList list;
	Image worldMap;
	float moveEnemyTimer=0;


	/*Circle power = null;
	int circleExpanding=30;

	Enemy a;*/


	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {

		list = new CharList(level);
		if(level==1)worldMap = new Image("res/chamberColor.jpg");
		if(level==2)worldMap = new Image("res/Quiddich.jpg");

		//a = new Enemy(300,200,"snake",1);

	}


	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g)
			throws SlickException {

		worldMap.draw(0,0);
		list.drawEveryone();
		list.getMainCharacter().getMagicBar().drawBar(g);
		list.getMainCharacter().getHealthBar().draw(g);
		//	a.draw();

		org.newdawn.slick.Color r = new org.newdawn.slick.Color(255, 0, 0);
		g.setColor(r);
		g.drawString("Harry X "+list.getMainCharacter().getPositionX()+"\n Harry Y: "+list.getMainCharacter().getPositionY(), 50, 170);
		/*
		power = new Circle(list.getMainCharacter().getPositionX()+50,list.getMainCharacter().getPositionY()+50,circleExpanding);
		if(power!=null) g.draw(power);
		Rectangle rr = new Rectangle(a.getPositionX()+35,a.getPositionY()+5,25,80);
		g.draw(rr);
		System.out.println(intersectswithCircle(rr));*/
	}

	/*	public boolean intersectswithCircle(Shape s){
		return power.intersects(s);
	}*/

	public void update(GameContainer gc, StateBasedGame arg1, int delta)
			throws SlickException {


		moveEnemyTimer+=delta;
		if(moveEnemyTimer>500){
			//a.moveToward(list.getMainCharacter(), false);
			list.moveEnemies(delta);

			moveEnemyTimer=0;
		}

		Input input = gc.getInput();

		if(input.isKeyDown(Input.KEY_UP)){
			list.characters.get(0).setPositionY(-delta * list.getMainCharacter().getSpeed());
		}

		if(input.isKeyDown(Input.KEY_DOWN)){
			list.characters.get(0).setPositionY(delta*list.getMainCharacter().getSpeed());
		}

		if(input.isKeyDown(Input.KEY_LEFT)){
			list.characters.get(0).setPositionX(-delta*list.getMainCharacter().getSpeed());
		}

		if(input.isKeyDown(Input.KEY_RIGHT)){
			list.characters.get(0).setPositionX(delta*list.getMainCharacter().getSpeed());
		}

		if(input.isKeyDown(Input.KEY_SPACE)){
			list.getMainCharacter().setInvisibleTrue(delta);
		}

		/*	if(input.isKeyDown(Input.KEY_F)){
			circleExpanding+=delta;
		}*/
		/*
		if(!input.isKeyDown(Input.KEY_F)){
			drawCircle(-circleExpanding);
			power = null;
		}*/

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
		if(!input.isKeyDown(Input.KEY_A)&&!input.isKeyDown(Input.KEY_SPACE)){
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

	public int getID() {
		return level;
	}

}
