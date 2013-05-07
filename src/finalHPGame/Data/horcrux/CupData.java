package finalHPGame.Data.horcrux;

import finalHPGame.Data.Data;
import finalHPGame.Location.Location;
import finalHPGame.Movable.HorcruxMove;

public class CupData extends Data {
	//TODO: Add ShapeUpdater
	//TODO: Add Animations
	//TODO: Add Personal
	public CupData(float x, float y, int level){
		myLoc = new Location(x,y,level);
		move = new HorcruxMove();
		name ="cup";
		init();
	}
	public void init(){
		
	}

}
