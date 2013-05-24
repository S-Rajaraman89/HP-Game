package finalHPGame.Boundary;

import java.util.ArrayList;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;

public abstract class Boundary {
	
    ArrayList<Shape> restrictedBounds;
	public Boundary(){
		restrictedBounds = new ArrayList<Shape>();
	}
	
	public abstract boolean inBounds(float x, float y);
	
	public boolean inBounds(Shape personal){
		for(Shape t: restrictedBounds){
			if(t.intersects(personal)){
				return false;
			}
		}
		return true;
	}
	
	public void drawRestrictedBounds(Graphics g){
		for(Shape s: restrictedBounds){
			g.draw(s);
		}
	}
}
