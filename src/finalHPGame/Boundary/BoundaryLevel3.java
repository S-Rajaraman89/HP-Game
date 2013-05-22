package finalHPGame.Boundary;

public class BoundaryLevel3 implements Boundary {
	public BoundaryLevel3(){

	}
	public boolean inBounds(float x, float y) {
		//Number 8
		if(x>=-32 && x<983 && y>=555 && y<=688){
			System.out.println("In 8th Rectangle");
			return true;
		}
		
		//number 3
		else if(x>=-32 && x<983 && y>=175 && y<=302){
			System.out.println("In 3th Rectangle");
			return true;
		}
		
		//number 1
		else if(x>=-32 && x<309 && y>=148.8 && y<=175){
			System.out.println("In 1th Rectangle");
			return true;
		}
		
		//number 2
		else if(x>=581.3 && x<987 && y>=140 && y<=175){
			System.out.println("In 2th Rectangle");
			return true;
		}
		
		//number 4
		else if(x>=-32 && x<150 && y>=302 && y<=555){
			System.out.println("In 4th Rectangle");
			return true;
		}
		
		//number 5
		else if(x>=218 && x<408 && y>=302 && y<=555){
			System.out.println("In 5th Rectangle");
			return true;
		}
		
		//number 6
		else if(x>=469 && x<632 && y>=302 && y<=555){
			System.out.println("In 6th Rectangle");
			return true;
		}
		
		//number 7
		else if(x>=706 && x<987 && y>=302 && y<=555){
			System.out.println("In 7th Rectangle");
			return true;
		}
		
		return false;
	}

}
