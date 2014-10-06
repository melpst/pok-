import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class GoodMoleImage implements Renderable {
  GoodMole gm;
  Image image;
 
  public GoodMoleImage(GoodMole gm) {
    this.gm = gm;
    try {
      image = new Image("res/goodmole.png");
    } catch (SlickException e) {
      e.printStackTrace();
    }    
  }
 
  public void render(Graphics g) {
    image.draw(gm.getX(), gm.getY());
  }
 
  
  
}