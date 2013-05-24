package finalHPGame.Spell.rangepower.bullet;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

import finalHPGame.Location.Location;
import finalHPGame.Spell.rangepower.bullet.movable.*;

	public class Bullet {
		
		private BulletMovable bulletmove;
		private Location loc;
		private float speed;
		private int timer;
		private Rectangle personal;

		public Bullet(int direction, Location UserLocation, float speed){
			if(direction==12) bulletmove = new BulletMoveUp();
			else if(direction==3) bulletmove = new BulletMoveRight();
			else if(direction==6) bulletmove = new BulletMoveDown();
			else if(direction==9) bulletmove = new BulletMoveLeft();
			loc = UserLocation.getCopyOfLocation();
			timer = 0;
			personal = new Rectangle(loc.getX()+40,loc.getY()+40,10,10);
			this.speed = speed;
		}

		public boolean update(int delta){
			timer += delta;
			if(timer >= 10)
			{	
				bulletmove.moveBullet(loc, speed);
				personal.setX(loc.getX()+40);
				personal.setY(loc.getY()+40);
				timer=0;
			}
			return loc.inBounds(personal);
		}
		
		public BulletMovable getMovable()
		{
			return bulletmove;
		}
		
		public Location getLocation()
		{
			return loc;
		}
		
		public void draw(Graphics g){
			g.draw(personal);
		}
		public Rectangle getPersonal(){
			return personal;
		}
		
}
