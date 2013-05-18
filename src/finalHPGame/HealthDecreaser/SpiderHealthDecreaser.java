package finalHPGame.HealthDecreaser;

public class SpiderHealthDecreaser implements HealthDecreaser {
	private float[]decreaser;
	private int level;
	
	public SpiderHealthDecreaser(int level){
		//TODO: fix the decreaser.
		decreaser = new float []{(float) 0.34,(float) 3.2,(float) 2.3};
		this.level = level;
	}

	public float getDecreaser() {
		return decreaser[level];
	}

}
