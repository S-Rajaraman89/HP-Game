package finalHPGame.Spell.rangepower.bullet.bulletconstant;

public class BulletConstant {
	protected float [] decreaser;
	protected int level;
	protected float[] speed;
	
	public BulletConstant(int level){
		this.level = level;
	}
	
	public float getDecreaser(){
		return decreaser[level];
	}
	
	public float getSpeed(){
		return speed[level];
	}
}
