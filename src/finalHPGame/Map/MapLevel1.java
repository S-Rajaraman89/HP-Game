package finalHPGame.Map;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.particles.ConfigurableEmitter;
import org.newdawn.slick.particles.ParticleIO;
import org.newdawn.slick.particles.ParticleSystem;
import org.newdawn.slick.state.StateBasedGame;

import finalHPGame.States.WinnerPage;

public class MapLevel1 implements Map {

	private Image worldMap;
	private ParticleSystem system;
	private ConfigurableEmitter mainFireBall;
	
	private boolean isMainFireOn;
	private	int timerRandom;
	private int timer;

	private int moveTimer = 0;

	public MapLevel1() throws SlickException {
		worldMap = new Image("res/chamberColor.jpg");
		system = new ParticleSystem(new Image("data/particle.png",false),1500);
		timerRandom = (int) (Math.random()*5000+ 5000);
		timer =0;
		try {	
			mainFireBall = ParticleIO.loadEmitter(WinnerPage.class.getResourceAsStream("resData/level1/mainFireBall.xml"));
			mainFireBall.setPosition(490, 200);
			mainFireBall.setEnabled(false);
			isMainFireOn = false;
			system.addEmitter(mainFireBall);

		} catch (Exception e) {
			System.out.println("Exception: " +e.getMessage());
			e.printStackTrace();
			System.exit(0);
		}
		system.setBlendingMode(ParticleSystem.BLEND_COMBINE);
	}


	public boolean isinHarm(Shape s) {
		if(isMainFireOn) return s.intersects(new Circle(mainFireBall.getX(),mainFireBall.getY(),30));
		return false;
	}

	public void drawMap() {
		worldMap.draw(0,0);
	}


	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
		system.render();
	}

	/*1. Activate the fireball
	 *2. Move the fireball based on time (delta), increase the size.
	 *3. If someone intersects and the fireball is active, damage them 
	 *4. delete the fireball after it (basically reset everything)
	 */

	public void update(int delta) {
		timer+=delta;
		if(timer>=timerRandom && !isMainFireOn){
			timer =0;
			timerRandom = (int) (Math.random()*5000+ 5000);
			activate();
		}
		if(isMainFireOn){
			move(delta);
		}
		if(mainFireBall.getY()>=690){
			reset();
		}
		system.update(delta);
	}
	
	public void activate(){
		isMainFireOn = true;
		mainFireBall.setEnabled(true);
	}
	
	public void move(int delta){
		moveTimer+=delta;
		if(moveTimer>=125){
			moveTimer=0;
			mainFireBall.setPosition(mainFireBall.getX(), mainFireBall.getY()+20);
		}
	}
	
	public void reset(){
		isMainFireOn = false;
		mainFireBall.setPosition(490, 200);
		mainFireBall.setEnabled(false);
	}

}
