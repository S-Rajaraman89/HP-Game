package finalHPGame.Map;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import finalHPGame.Location.Location;

public class MapLevel2 implements Map {

	Image worldMap;
	
	public MapLevel2() throws SlickException {
		worldMap = new Image("res/Quiddich.jpg");
	}

	//TODO: add where the flames are at
	public boolean isinHarm(Location loc) {
		return false;
	}


	public void drawMap() {
		worldMap.draw(0, 0);
	}

}
