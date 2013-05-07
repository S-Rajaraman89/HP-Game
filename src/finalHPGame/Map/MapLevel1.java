package finalHPGame.Map;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import finalHPGame.Location.Location;

public class MapLevel1 implements Map {

	Image worldMap;
	public MapLevel1() throws SlickException {
		worldMap = new Image("res/chamberColor.jpg");
	}


	public boolean isinHarm(Location loc) {
    return false;
	}

	public void drawMap() {
		worldMap.draw(0, 0);
	}

}
