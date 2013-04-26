package finalHPGame.Boundary;

public class BoundaryLevel1 implements Boundary {

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