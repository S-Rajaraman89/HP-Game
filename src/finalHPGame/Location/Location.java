package finalHPGame.Location;

import org.newdawn.slick.geom.Shape;

import finalHPGame.Boundary.Boundary;
import finalHPGame.Boundary.BoundaryLevel1;
import finalHPGame.Boundary.BoundaryLevel2;
import finalHPGame.Boundary.BoundaryLevel3;
/**Holds the X,Y coordinate. Optional bounds checker*/
public class Location {
	private float x;
	private float y;
	private Boundary bounds;
	private int level;

	/**Use this when checking bounds does not matter*/
	public Location(float myx, float myy){
		x = myx;
		y = myy;
	}
	/**level allows for bounds checking*/
	public Location(float myx, float myy, int level){
		x=myx;
		y=myy;

		if(level==1){
			bounds = new BoundaryLevel1();
		}
		else if(level==2){
			bounds = new BoundaryLevel2();
		}
		else if(level==3){
			bounds = new BoundaryLevel3();
		}
		this.level = level;
	}
	
	/**Get the x coordinate 
	 * @return The current X coordinate*/
	public float getX() {
		return x;
	}
	
	/**Get the y coordinate 
	 * @return The current Y coordinate
	 * */
	public float getY() {
		return y;
	}
	/**Adds deltaX to the X coordinate. DOES NOT CHECK BOUNDS
	 * @return The direction the Character should be facing*/
	public int addX(float deltaX){
		x+=deltaX;
		return (deltaX>0) ? 3:9;
	}
	
	/**Adds deltaY to the Y coordinate. DOES NOT CHECK BOUNDS
	 * @return The direction the Character should be facing*/
	public int addY(float deltaY){
		y+=deltaY;
		return (deltaY>0) ? 6:12;
	}
	
	/**Adds deltaX to the X coordinate if the new coordinate is in bounds.
	 * @return The direction the Character should be facing*/
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
	
	/**Adds deltaY to the Y coordinate if the new coordinate is in bounds.
	 * @return The direction the Character should be facing*/
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
	
	/**Checks if the location is in bounds
	 * @return boolean - is the character in bounds*/
	public boolean inBounds(){
		return bounds.inBounds(x, y);
	}
	
	public int getLevel(){
		return level;
	}
	
	/**Gets the Boundary of the current level*/
	public Boundary getBounds(){
		return bounds;
	}
	/**Return a new object of Location with same values*/
	public Location getCopyOfLocation(){
		return new Location(this.x,this.y, this.level);
	}
	/**Replaces the x coordinate*/
	public void replaceX(float newX){
		x=newX;
	}
	/**Replaces the y coordinate*/
	public void replaceY(float newY){
		y = newY;
	}
	
	public boolean equals(Object o){
		Location temp = (Location) o;
		return (temp.getX()==x && temp.getY()==y);
	}
	
	public String toString(){
		return "X: "+ x +" Y: "+y;
	}
	
	/**Returns which direction is the b based on this Location*/
	//Is b left, right, up down of Current location?
	public int directionOf(Location b){
		if(x<b.x){
			return 3;
		}
		else if(x>b.x){
			return 9;
		}
		else if(y>b.y){
			return 12;
		}
		else if(y<b.y){
			return 6;
		}
		return 0;
	}
	
	/**Gets the distance between this location and b*/
	public float getDistance(Location b){
		double xval = Math.pow((float)x-b.x, 2);
		double yval = Math.pow((float)y-b.y, 2);
			return Math.abs((float) Math.sqrt(xval+yval));
	}
	
	/**Returns true if the location is contained in Shape*/
	public boolean contains(Shape s){
		return s.contains(x, y);
	}
	public boolean inBounds(Shape s){
		return bounds.inBounds(s);
	}
	
}
