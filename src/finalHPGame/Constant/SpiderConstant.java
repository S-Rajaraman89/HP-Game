package finalHPGame.Constant;

public class SpiderConstant extends Constant {
	public SpiderConstant(int level){
		this.level = (level-1);
		decreaser = new float []{(float) 1.5,(float) 2.0,(float) 3.0};
		speed = new float []{(float) 2,(float) 3,(float) 4};
	}
}
