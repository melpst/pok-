import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class PokGame extends BasicGame {

	private static final int GAME_HEIGHT = 480;
	private static final int GAME_WIDTH = 640;
	private static String position = "res/bg.jpg";
	private Image image;
	private Hammer hammer;

	public PokGame(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		image.draw(0, 0);
		hammer.render();
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		// TODO Auto-generated method stub
		image = new Image(position);
		hammer = new Hammer(200, 200);
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(int button, int x, int y) {
		hammer.hit();
	}

	@Override
	public void mouseReleased(int button, int x, int y) {
		// TODO Auto-generated method stub
		hammer.release();
	}

	public static void main(String[] args) {
		try {
			PokGame game = new PokGame("Pok!!");
			AppGameContainer appgc = new AppGameContainer(game);
			appgc.setDisplayMode(GAME_WIDTH, GAME_HEIGHT, false);
			// appgc.setTargetFrameRate(60);
			appgc.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

}
