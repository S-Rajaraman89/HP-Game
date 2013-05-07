package finalHPGame.HealthDecreaser;

public class SpiderHealthDecreaser implements HealthDecreaser {
	private float[]decreaser;
	private int level;
	
	public SpiderHealthDecreaser(int level){
		//TODO: fix the decreaser.
		decreaser = new float []{1,3,4};
		this.level = level;
	}

	public float getDecreaser() {
		return decreaser[level];
	}

}
