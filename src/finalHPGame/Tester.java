package finalHPGame;

import org.newdawn.slick.SlickException;

import finalHPGame.Location.Location;

public class Tester {
	public static void main(String[] args) throws SlickException {

		Location x = new Location(10,20,1);
		Location y = new Location (20,20, 1);
		System.out.println(x.getDistance(y));
	}

}
