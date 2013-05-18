package finalHPGame.Constant;

public class SpiderConstant extends Constant {
	public SpiderConstant(int level){
		this.level = level;
		decreaser = new float []{(float) 1.5,(float) 2.0,(float) 3.0};
		speed = new float []{(float) 30,(float) 20,(float) 30};
	}
}
