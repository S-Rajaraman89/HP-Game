package finalHPGame.Boundary;

import org.newdawn.slick.geom.Rectangle;


public class BoundaryLevel1 extends Boundary {
		
	public BoundaryLevel1(){
		super();
		restrictedBounds.add(new Rectangle(0,410,290,390));
		restrictedBounds.add(new Rectangle(730,410,318,390));
		restrictedBounds.add(new Rectangle(0,0,1050,160));
		restrictedBounds.add(new Rectangle(0,795,1050,5));
	}

	/**Checks the bounds for level 1
	 * @return returns if the location is in bounds*/
	public boolean inBounds(float positionX, float positionY) {
		if((positionX<992 && positionX>-35 && positionY<338 && positionY>140)
				||(positionX<680 && positionX>247 && positionY<=688 && positionY>=336)){
			return true;
		}
		return false;
	}
}