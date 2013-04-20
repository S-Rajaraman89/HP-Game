package finalHPGame.Location;

import finalHPGame.Boundary.Boundary;
import finalHPGame.Boundary.BoundaryLevel1;
import finalHPGame.Boundary.BoundaryLevel2;

public class Location {
	private float x;
	private float y;
	private Boundary bounds;

	public Location(float myx, float myy, int level){
		x=myx;
		y=myy;

		if(level==1){
			bounds = new BoundaryLevel1();
		}
		else if(level==2){
			bounds = new BoundaryLevel2();
		}
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public int setX(float deltax) {
		int direction = 3;
		if(deltax<0){
			direction=9;
		}

		if(bounds.inBounds(x+deltax, y)){
			x+=deltax;
		}
		return direction;
	}

	public int setY(float deltay) {
		int direction = 6;
		if(deltay<0){
			direction=12;
		}

		if(bounds.inBounds(x, y+deltay)){
			y+=deltay;
		}
		return direction;
	}


}
