package finalHPGame.Constant;

public class SnakeConstant extends Constant {
	public SnakeConstant(int level){
		decreaser = new float []{(float) 0.34,(float) 3.2,(float) 2.3};
		speed = new float []{(float) 0.34,(float) 3.2,(float) 2.3};
		this.level = level;
	}
}
