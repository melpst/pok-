package pok;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class MoleImage implements Renderable {
	Mole mole;
	Image image;

	public MoleImage(Mole mole, String imagePosition) {
		this.mole = mole;
		try {
			image = new Image(imagePosition);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public void render(Graphics g) {
		image.draw(mole.getX(), mole.getY());
	}

}