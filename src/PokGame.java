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
	public static boolean isActive = false;
	private Image image;
	private Hammer hammer;
	private static float HAMMER_X;
	private static float HAMMER_Y;

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
		hammer = new Hammer(GAME_WIDTH / 2, GAME_HEIGHT / 2);
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(int button, int x, int y) {
		if (isActive) {
			hammer.hit();
		} else {
			isActive = true;
		}
	}

	@Override
	public void mouseReleased(int button, int x, int y) {
		// TODO Auto-generated method stub
		if (isActive) {
			hammer.release();
		}
	}

	@Override
	public void mouseMoved(int oldx, int oldy, int newx, int newy) {
		// TODO Auto-generated method stub
		if (isActive) {
			hammer.move((float) newx, (float) newy);
		}
	}

	public static void main(String[] args) {
		try {
			PokGame game = new PokGame("Pok!!");
			AppGameContainer appgc = new AppGameContainer(game);
			appgc.setDisplayMode(GAME_WIDTH, GAME_HEIGHT, false);
			appgc.setTargetFrameRate(60);
			appgc.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

}
