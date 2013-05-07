package finalHPGame.HealthDecreaser;

public class SnakeHealthDecreaser implements HealthDecreaser {
	
	private float decreaser;
	public SnakeHealthDecreaser(int level) {
		if(level==1) decreaser=(float) 1.5;
	}


	public float getDecreaser() {
		return decreaser;
	}

}
