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
			timer += delta;
			if(timer >= 1500)
			{	
				if(bulletmove.canMove(loc, speed))
					bulletmove.moveBullet(loc, speed);
					
					return true;
			}
			return false;
		}
		public Image getImage()
		{
			return image;
		}
		
		public void setImage(Image i)
		{
			i = image;
		}
		
		public BulletMovable getMovable()
		{
			return bulletmove;
		}
		
		public Location getLocation()
		{
			return loc;
		}
		
}
