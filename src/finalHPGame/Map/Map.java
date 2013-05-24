package finalHPGame.Map;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;

public interface Map {
public boolean isinHarm(Shape user);
public void drawMap();
public void render(GameContainer gc, StateBasedGame sbg, Graphics g);
public void update(int delta);
}
