package finalHPGame.Bar;



import org.newdawn.slick.Graphics;

public class MagicBar {

	
	private boolean isMagicEmpty = false;
	/**The current length of the bar*/
	private float spellBarX=65;
	private float spellTime;
	private float spellTimeRevive;

	public MagicBar(){
		spellTime=0;
		spellTimeRevive=0;
	}

	/**Reloads the MagicBar based on time*/
	public void reviveMagicBar(float delta){
		spellTimeRevive+=delta;
		if(spellTimeRevive>=2500){
			if(spellBarX<65){
				spellBarX+=13;
				spellTimeRevive = 0;
			}
		}
	}

	/**Decreases the MagicBar based on time*/
	public void decreaseMagicBar(float delta){
		spellTime+=delta;
		if (spellTime >= 1000 && !isMagicEmpty) {
			spellBarX-=13;
			spellTime=0;
		}
		if(spellBarX<=0){
			isMagicEmpty=true;
		}
		else{
			isMagicEmpty=false;
		}

	}
	/**Return true if the bar is full*/
	public boolean isFull(){
		return(spellBarX>=65);
	}
	/**Return true if the bar is empty*/
	public boolean isEmpty(){
		return(spellBarX<5);
	}


	/**Draws a red bar on the screen*/
	public void drawBar(Graphics g){
		org.newdawn.slick.Color r = new org.newdawn.slick.Color(255, 0, 0);
		g.setColor(r);
		g.fillRect(50, 600, spellBarX, 10);
	}

	/**Returns the length of the SpellBar*/
	public float getSpellBarX() {
		return spellBarX;
	}
}
