package finalHPGame.Boundary;

public class BoundaryLevel2 implements Boundary {

	/**Checks the bounds for level 2
	 * @return returns if the location is in bounds*/
	public boolean inBounds(float x, float y) {
		if(((x>-20 && x<600) && (y<650 && y>140))){
			return true;
		}
		return false;
	}

}
