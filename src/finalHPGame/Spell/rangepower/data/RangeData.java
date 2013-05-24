package finalHPGame.Spell.rangepower.data;
import org.newdawn.slick.Image;
import finalHPGame.Spell.rangepower.bullet.bulletconstant.BulletConstant;

public class RangeData {

	protected BulletConstant constant = null;
	protected int limit;
	protected Image bulletImage = null;
	protected boolean isPlayable;
	
	public boolean isPlayable(){
		return isPlayable;
	}
	
	public BulletConstant getConstant() {
		return constant;
	}

	public Image getBulletImage() {
		return bulletImage;
	}
	
	public int getLimit(){
		return limit;
	}
}
