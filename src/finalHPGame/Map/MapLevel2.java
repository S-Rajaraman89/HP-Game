package finalHPGame.Map;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.particles.ConfigurableEmitter;
import org.newdawn.slick.particles.ParticleIO;
import org.newdawn.slick.particles.ParticleSystem;
import org.newdawn.slick.state.StateBasedGame;
import finalHPGame.States.WinnerPage;

public class MapLevel2 implements Map {

	Image worldMap;
	ParticleSystem system;

	public MapLevel2() throws SlickException {
		worldMap = new Image("res/Quiddich.jpg");
		system = new ParticleSystem(new Image("data/particle.png",false),1500);
		try {	
			ConfigurableEmitter emitter = ParticleIO.loadEmitter(WinnerPage.class.getResourceAsStream("resData/Level2.xml"));
			emitter.setPosition(300, 430);
			system.addEmitter(emitter);

			emitter = ParticleIO.loadEmitter(WinnerPage.class.getResourceAsStream("resData/Level2.xml"));
			emitter.setPosition(500, 700);
			system.addEmitter(emitter);

		} catch (Exception e) {
			System.out.println("Exception: " +e.getMessage());
			e.printStackTrace();
			System.exit(0);
		}
		system.setBlendingMode(ParticleSystem.BLEND_COMBINE);
	}

	public boolean isinHarm(Shape s) {
		return s.intersects(new Rectangle(240,180,90,165));
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g){
		system.render();
	}
	
	public void update(int delta){
		system.update(delta);
	}

	public void drawMap() {
		worldMap.draw(0,0);
	}

}
