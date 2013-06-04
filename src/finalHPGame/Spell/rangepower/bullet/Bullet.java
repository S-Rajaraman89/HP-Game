package finalHPGame.Spell.rangepower.bullet;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import finalHPGame.Location.Location;
import finalHPGame.Spell.rangepower.bullet.movable.*;

	public class Bullet {
		
		private BulletMovable bulletmove;
		private Location loc;
		private float speed;
		private int timer;
		private Rectangle personal;
		
		private Image bullet;
		private float dx;
		private float dy;

		public Bullet(int direction, Location UserLocation, float speed){
			dx = 0;
			dy = 0;
			if(direction==12){
				bulletmove = new BulletMoveUp();
				dx = -12;
			}
			else if(direction==3){
				bulletmove = new BulletMoveRight();
				dx = -12;
			}
			else if(direction==6){
				bulletmove = new BulletMoveDown();
				dx=-12;
			}
			else if(direction==9){
				bulletmove = new BulletMoveLeft();
				dx = -13;
			}
			
			loc = UserLocation.getCopyOfLocation();
			timer = 0;
			personal = new Rectangle(loc.getX()+40,loc.getY()+40,10,10);
			this.speed = speed;
			try {
				bullet = new Image("res/Avad_bullet.png");
			} catch (SlickException e) {
				e.printStackTrace();
			}
		}

		public boolean update(int delta){
			timer += delta;
			if(timer >= 10)
			{	
				bulletmove.moveBullet(loc, speed);
				personal.setX(loc.getX()+45);
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
			g.drawImage(bullet,loc.getX()+dx,loc.getY()+dy);
		}
		public Rectangle getPersonal(){
			return personal;
		}
		
}
