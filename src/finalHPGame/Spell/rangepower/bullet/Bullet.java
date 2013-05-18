package finalHPGame.Spell.rangepower.bullet;

import org.newdawn.slick.Image;
import finalHPGame.Location.Location;
import finalHPGame.Spell.rangepower.bullet.movable.*;

public class Bullet {
BulletMovable bulletmove;
Location loc;
float speed;
Image image;
int timer;

public Bullet(int direction, Location UserLocation, float speed, Image i){
	if(direction==12) bulletmove = new BulletMoveUp();
	else if(direction==3) bulletmove = new BulletMoveRight();
	else if(direction==6) bulletmove = new BulletMoveDown();
	else if(direction==9) bulletmove = new BulletMoveLeft();
	
	loc = UserLocation.getCopyOfLocation();
	
	timer = 0;
	image = i;
	image.draw(loc.getX(), loc.getY());
}

public boolean update(int delta){
return false;	
}
}
