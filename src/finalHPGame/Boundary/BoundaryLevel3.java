package finalHPGame.Boundary;

import org.newdawn.slick.geom.Rectangle;

public class BoundaryLevel3 extends Boundary {
	
	public BoundaryLevel3(){
		super();
		//House
		restrictedBounds.add(new Rectangle(0,0,525,180));
		restrictedBounds.add(new Rectangle(525,0,525,160));
		restrictedBounds.add(new Rectangle(0,760,1050,40));
	
		//Corn field
		restrictedBounds.add(new Rectangle(200,380,50,200));
		restrictedBounds.add(new Rectangle(460,380,50,200));
		restrictedBounds.add(new Rectangle(690,380,50,200));
		//The water
		restrictedBounds.add(new Rectangle(0,760,1050,40));
		
		//Sides
		restrictedBounds.add(new Rectangle(0,0,1,800));
		restrictedBounds.add(new Rectangle(1049,0,1,800));
	}
	public boolean inBounds(float x, float y) {
		//Number 8
		if(x>=-32 && x<983 && y>=555 && y<=688){
			return true;
		}
		
		//number 3
		else if(x>=-32 && x<983 && y>=175 && y<=302){
			return true;
		}
		
		//number 1
		else if(x>=-32 && x<309 && y>=148.8 && y<=175){
			return true;
		}
		
		//number 2
		else if(x>=581.3 && x<987 && y>=140 && y<=175){
			return true;
		}
		
		//number 4
		else if(x>=-32 && x<150 && y>=302 && y<=555){
			return true;
		}
		
		//number 5
		else if(x>=218 && x<408 && y>=302 && y<=555){
			return true;
		}
		
		//number 6
		else if(x>=469 && x<632 && y>=302 && y<=555){
			return true;
		}
		
		//number 7
		else if(x>=706 && x<987 && y>=302 && y<=555){
			return true;
		}
		return false;
	}
}
