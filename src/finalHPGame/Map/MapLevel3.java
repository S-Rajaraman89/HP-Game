package finalHPGame.Map;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import finalHPGame.Location.Location;

public class MapLevel3 implements Map {
	private Image worldMap;
	public MapLevel3() throws SlickException{
		worldMap = new Image("res/HarryPotterHouse.jpg");
	}

	//TODO:Add flames if needed
	public boolean isinHarm(Location mainCharLoc) {
		return false;
	}

	public void drawMap() {
		worldMap.draw(0, 0);

	}

}
