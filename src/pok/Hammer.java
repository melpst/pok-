package pok;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Hammer {
	private float x;
	private float y;
	public static final int WIDTH = 77;
	public static final int HEIGHT = 100;
	public static final int HIT_AREA_X = 100;
	public static final int HIT_AREA_Y = 70;
	private Image image;

	public Hammer(float x, float y) throws SlickException {
		image = null;
		move(x, y);
	}

	public void setXY(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public void render() {
		// TODO Auto-generated method stub
		if (image == null) {
			try {
				image = new Image("res/hammer.png");
			} catch (SlickException e) {
				e.printStackTrace();
			}
		}
		image.draw(x, y);

	}

	public void update() {
		// TODO Auto-generated method stub
		image.setCenterOfRotation(WIDTH / 2, HEIGHT / 2);
		move(x, y);
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
		setXY(newx - WIDTH / 2, newy - HEIGHT / 2);
	}

	public boolean attack(float moleX, float moleY) {
		// TODO Auto-generated method stub
		if (Math.abs((x + WIDTH / 2) - moleX) <= HIT_AREA_X) {
			if (Math.abs((y + HEIGHT / 4) - moleY) <= HIT_AREA_Y) {
				return true;
			}
		}
		return false;
	}

}