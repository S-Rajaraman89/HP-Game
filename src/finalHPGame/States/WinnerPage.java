package finalHPGame.States;


import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.particles.ConfigurableEmitter;
import org.newdawn.slick.particles.ParticleIO;
import org.newdawn.slick.particles.ParticleSystem;
import org.newdawn.slick.state.*;

public class WinnerPage extends BasicGameState{
   
   
   Image nextLevel;
   Image winningPic;
   Image menuReturn;
   int posX;
   int posY;
   ParticleSystem system;
   
   public WinnerPage(int winner){
   }
   
   @Override
public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
      winningPic= new Image("res/winningPic.jpg");
	  nextLevel = new Image("res/nextLevel.png");
	  menuReturn= new Image("res/menuReturn.png");
  
	  
	  system = new ParticleSystem(new Image("data/particle.png",false),1500);
	 try {	
			ConfigurableEmitter emitter = ParticleIO.loadEmitter(WinnerPage.class.getResourceAsStream("data/torch.xml"));
			emitter.setPosition(130, 430);
			system.addEmitter(emitter);
			
			emitter = ParticleIO.loadEmitter(WinnerPage.class.getResourceAsStream("data/torch.xml"));
			emitter.setPosition(965, 430);
			system.addEmitter(emitter);
		} catch (Exception e) {
			System.out.println("Exception: " +e.getMessage());
			e.printStackTrace();
			System.exit(0);
		}
	  system.setBlendingMode(ParticleSystem.BLEND_ADDITIVE);
      
   }
   
   @Override
public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
      winningPic.draw(0,0,1050,800);
	   g.drawString("Instructions:", 100, 50);
      nextLevel.draw(750,600);
      menuReturn.draw(100,600);
     
      g.drawString("x "+ posX+ "  y"+ posY,50,200);
      system.render();
      
   }
   
   @Override
public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
	   system.update(delta);
       posX = Mouse.getX();
       posY = Mouse.getY();
      
      //play now button
       
    if((posX>750 && posX<950)&&(posY>115 && posY<155)){
       if(Mouse.isButtonDown(0)){
        	System.out.println("clicked");
        	sbg.getState(2).init(gc, sbg);
        	sbg.enterState(2);
         }
    }
       else if((posX>100 && posX<302)&&(posY>115 && posY<155)){
           if(Mouse.isButtonDown(0)){
            	System.out.println("clicked");
            	sbg.getState(0).init(gc, sbg);
            	sbg.enterState(0);
             }
       }

   }
   
   @Override
public int getID(){
      return 300;
   }
}