package finalHPGame.Constant;

public class DementorConstant extends Constant {

	public DementorConstant(int level){
		//TODO: Fix the variables
		decreaser = new float []{(float) 1,(float) 1.2,(float) 1.7};
		speed = new float []{(float) .4,(float) .7,(float) .9};
		this.level = level;
	}
}
