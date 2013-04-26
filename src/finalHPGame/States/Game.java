package finalHPGame.States;



import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame{
   
   public static final String gamename = "Harry Potter";
   public static final int menu = 0;
   public static final int play = 1;
   public static final int play2=2;
   public static final int inst=100;
   public static final int loser=200;
   public static final int winner=300;

   /**Creates and adds the states to the list*/
   public Game(String gamename) throws SlickException{
      super(gamename);
      this.addState(new Menu(menu));
      this.addState(new Play(play));
      this.addState(new Instructions(inst));
      this.addState(new LoserPage(loser));
      this.addState(new WinnerPage(winner));
      this.addState(new Play(play2));
   }
   /**Initializes each state and enters one of them*/
   public void initStatesList(GameContainer gc) throws SlickException{
	      this.getState(menu).init(gc, this);
	      this.getState(inst).init(gc, this);
	      this.getState(play).init(gc, this);
	      this.getState(loser).init(gc, this);
	      this.getState(winner).init(gc, this);
	      this.getState(play2).init(gc,this);
	      this.enterState(play);
   }
   
   /**Creates the display*/
   public static void main(String[] args) {
      AppGameContainer appgc;
      try{
         appgc = new AppGameContainer(new Game(gamename));
         appgc.setDisplayMode(1050, 800, false);
         appgc.start();
      }catch(SlickException e){
         e.printStackTrace();
      }
   }

}