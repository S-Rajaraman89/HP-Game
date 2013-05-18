package finalHPGame;

import org.newdawn.slick.SlickException;

import finalHPGame.Location.Location;

public class Tester {
	public static void main(String[] args) throws SlickException {

		Location x = new Location(10,20,1);
		final Location y = x;
		System.out.println(x);
		System.out.println(y);
		x.replaceX(50);
		
		System.out.println(x);
		System.out.println(y);
		y.replaceX(23);

		System.out.println(x);
		System.out.println(y);
	}

}
