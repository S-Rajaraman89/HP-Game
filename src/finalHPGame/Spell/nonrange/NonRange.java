package finalHPGame.Spell.nonrange;

import finalHPGame.Spell.Spell;

public abstract class NonRange implements Spell {
	
	protected boolean isPowerOn;
	
	public NonRange(){
		isPowerOn = false;
	}
	
	public boolean isPowerOn(){
		return isPowerOn;
	}
	
	public void setPowerOn(){
		isPowerOn = true;
	}
	
	public void setPowerOff(){
		isPowerOn = false;
	}	
}
