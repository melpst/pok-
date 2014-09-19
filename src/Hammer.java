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
		setXY(x, y);
		image = new Image("res/hammer.png");
		// image.setCenterOfRotation(WIDTH/2, HEIGHT/2);
	}

	public void setXY(float x, float y){
		this.x = x;
		this.y = y;
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

	public void move(float newx, float newy) {
		// TODO Auto-generated method stub
		setXY(newx-WIDTH/2, newy-HEIGHT/2);
	}

}