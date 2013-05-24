package finalHPGame.Map;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.*;
import org.newdawn.slick.particles.ConfigurableEmitter;
import org.newdawn.slick.particles.ParticleIO;
import org.newdawn.slick.particles.ParticleSystem;
import org.newdawn.slick.state.StateBasedGame;
import finalHPGame.States.WinnerPage;

public class MapLevel2 implements Map {

	private Image worldMap;
	private	ParticleSystem system;
	private ConfigurableEmitter emitter1;
	private ConfigurableEmitter emitter2;
	private ConfigurableEmitter emitter3;
	private ConfigurableEmitter emitter4;
	private int timer;
	private int randLimit;

	public MapLevel2() throws SlickException {
		timer =0;
		randLimit = (int)(Math.random()*6000) + 10000;
		System.out.println(randLimit);
		worldMap = new Image("res/Quiddich.jpg");
		system = new ParticleSystem(new Image("data/particle.png",false),1500);
		try {	
		 emitter1 = ParticleIO.loadEmitter(WinnerPage.class.getResourceAsStream("resData/level2/Level2.xml"));
			emitter1.setPosition(300, 200);
			system.addEmitter(emitter1);

			emitter2 = ParticleIO.loadEmitter(WinnerPage.class.getResourceAsStream("resData/level2/Level2.xml"));
			emitter2.setPosition(500, 700);
			system.addEmitter(emitter2);
			
			emitter3 = ParticleIO.loadEmitter(WinnerPage.class.getResourceAsStream("resData/level2/Level2.xml"));
			emitter3.setPosition(600, 500);
			system.addEmitter(emitter3);
			
			emitter4 = ParticleIO.loadEmitter(WinnerPage.class.getResourceAsStream("resData/level2/Level2.xml"));
			emitter4.setPosition(250, 400);
			system.addEmitter(emitter4);

		} catch (Exception e) {
			System.out.println("Exception: " +e.getMessage());
			e.printStackTrace();
			System.exit(0);
		}
		system.setBlendingMode(ParticleSystem.BLEND_COMBINE);
	}

	public boolean isinHarm(Shape s) {
		return s.intersects(new Circle(emitter1.getX(),emitter1.getY(),30))
				|| s.intersects(new Circle(emitter2.getX(),emitter2.getY(),30))
				|| s.intersects(new Circle(emitter3.getX(),emitter3.getY(),30))
				|| s.intersects(new Circle(emitter4.getX(),emitter4.getY(),30));
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g){
		system.render();
	}
	
	public void update(int delta){
		timer+=delta;
		if(timer>=randLimit){
			timer = 0;
			randLimit = (int)(Math.random()*4000) + 5000;
			int rand = (int)(Math.random()*4) +1;
			if(rand==1)this.changeLocation(emitter1);
			else if(rand==2) this.changeLocation(emitter2);
			else if(rand==3) this.changeLocation(emitter3);
			else if(rand==4) this.changeLocation(emitter4);
			else if(rand==5){
				this.changeLocation(emitter1);
				this.changeLocation(emitter2);
				this.changeLocation(emitter3);
				this.changeLocation(emitter4);
			}
		}
		system.update(delta);
	}

	public void drawMap() {
		worldMap.draw(0,0);
	}
	/**Randomly changes the position of Emitter*/
	public void changeLocation(ConfigurableEmitter e){
		float x = (float) (Math.random()*500)+100;
		float y = (float) (Math.random()*200)+370;
		System.out.println("X: "+x+" Y: "+y);
		e.setPosition(x, y);
	}

}
