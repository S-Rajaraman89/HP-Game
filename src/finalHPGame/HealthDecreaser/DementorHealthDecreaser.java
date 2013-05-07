package finalHPGame.HealthDecreaser;

public class DementorHealthDecreaser implements HealthDecreaser {
	private int decreaser;
	public DementorHealthDecreaser(int level) {
		if(level==1){
			decreaser=2;
		}
	}
	
	public float getDecreaser() {
		return decreaser;
	}

}