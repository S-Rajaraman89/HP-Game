package finalHPGame.Boundary;

import org.newdawn.slick.geom.Rectangle;


public class BoundaryLevel2 extends Boundary {
	
	public BoundaryLevel2(){
		super();
		restrictedBounds.add(new Rectangle(0,0,1050,185));
		restrictedBounds.add(new Rectangle(0,730,1050,70));
		restrictedBounds.add(new Rectangle(0,0,1,800));
		restrictedBounds.add(new Rectangle(1049,0,1,800));
	}
	
	/**Checks the bounds for level 2
	 * @return returns if the location is in bounds*/
	public boolean inBounds(float x, float y) {
		if(((x>-20 && x<990) && (y<650 && y>130))){
			return true;
		}
		return false;
	}

}
