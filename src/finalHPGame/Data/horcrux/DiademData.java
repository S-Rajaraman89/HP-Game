package finalHPGame.Data.horcrux;

import finalHPGame.Data.Data;
import finalHPGame.Location.Location;
import finalHPGame.Movable.HorcruxMove;

public class DiademData extends Data {

	//TODO: Add ShapeUpdater
	//TODO: Add Animations
	//TODO: Add Personal
	public DiademData(float x, float y, int level){
		myLoc = new Location(x,y,level);
		name = "diadem";
		move = new HorcruxMove();
		init();
	}
	public void init(){

	}
}
