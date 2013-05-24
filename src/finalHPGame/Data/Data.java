package finalHPGame.Data;

import org.newdawn.slick.Animation;
import org.newdawn.slick.geom.Rectangle;

import finalHPGame.Constant.Constant;
import finalHPGame.Location.Location;
import finalHPGame.Movable.Movable;
import finalHPGame.ShapeUpdater.ShapeUpdater;
//Create a class that extends Data
//If the class is meant for Horcrux, init Animations, ShapeUpdater, Movable, personal
//If the class is meant for an Enemy, init Animation, ShapeUpdater, Movable, Personal, HealthDecreaser
//If the class is meant for Playable Charcter, init Animation, ShapeUpdater, Personal
import finalHPGame.Spell.Spell;

/**Holds the data for each character*/
public class Data {

	protected Movable move=null;
	protected ShapeUpdater updater=null;
	protected Rectangle personal=null;
	protected Constant constant=null;
	protected Animation movingUp=null;
	protected Animation movingDown=null;
	protected Animation movingLeft=null;
	protected Animation movingRight=null;
	protected Location myLoc = null;
	protected String name = null;
	protected Spell[] spells =null;

	public Movable getMovable(){
		return move;
	}
	public ShapeUpdater getShapeUpdater(){
		return updater;
	}
	public Rectangle getRectangle(){
		return personal;
	}
	public Constant getConstant(){
		return constant;
	}
	public Animation getMovingUp(){
		return movingUp;
	}
	public Animation getMovingDown(){
		return movingDown;
	}
	public Animation getMovingRight(){
		return movingRight;
	}
	public Animation getMovingLeft(){
		return movingLeft;
	}
	public Location getLocation(){
		return myLoc;
	}
	public String getName(){
		return name;
	}
	public String toString(){
		return"";
	}
	public Spell[] getSpells(){
		return spells;
	}
	public void setMove(Movable move) {
		this.move = move;
	}
	public void setShapeUpdater(ShapeUpdater updater) {
		this.updater = updater;
	}
	public void setPersonal(Rectangle personal) {
		this.personal = personal;
	}
	public void setConstant(Constant constant) {
		this.constant = constant;
	}
	public void setMovingUp(Animation movingUp) {
		this.movingUp = movingUp;
	}
	public void setMovingDown(Animation movingDown) {
		this.movingDown = movingDown;
	}
	public void setMovingLeft(Animation movingLeft) {
		this.movingLeft = movingLeft;
	}
	public void setMovingRight(Animation movingRight) {
		this.movingRight = movingRight;
	}
	public void setMyLoc(Location myLoc) {
		this.myLoc = myLoc;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSpells(Spell[] spells){
		this.spells = spells;
	}
}
