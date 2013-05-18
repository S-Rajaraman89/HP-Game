package finalHPGame.Location;

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
	public Location getCopyOfLocation(){
		return new Location(this.x,this.y, this.level);
	}
	
	public void replaceX(float newX){
		x=newX;
	}
	
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
			return 6;
		}
		else if(y<b.y){
			return 12;
		}
		return 0;
	}
	
}
