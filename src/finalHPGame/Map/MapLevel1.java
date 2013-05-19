package finalHPGame.Map;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;

public class MapLevel1 implements Map {

	Image worldMap;
	
	public MapLevel1() throws SlickException {
		worldMap = new Image("res/chamberColor.jpg");
	}


	public boolean isinHarm(Shape s) {
    return false;
	}

	public void drawMap() {
		worldMap.draw(0,0);
	}


	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
		// TODO Auto-generated method stub
		
	}


	public void update(int delta) {
		// TODO Auto-generated method stub
		
	}

}
