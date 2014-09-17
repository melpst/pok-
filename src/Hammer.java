import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Hammer {
	private float x;
	private float y;
	private boolean isStarted = false;
	public static final int WIDTH = 11;
	public static final int HEIGHT = 80;
	private Image image;

	public Hammer(float x, float y) throws SlickException {
		this.x = x;
		this.y = y;
		image = new Image("res/hammer.png");
		// image.setCenterOfRotation(WIDTH/2, HEIGHT/2);
	}

	public void render() {
		// TODO Auto-generated method stub
		image.draw(x, y);
	}

	public void update() {
		// TODO Auto-generated method stub

	}

	public void hit() {
		image.setRotation(315);
	}

	public void release() {
		// TODO Auto-generated method stub
		image.setRotation(0);
	}

}