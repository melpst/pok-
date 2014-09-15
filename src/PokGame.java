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
	private static boolean isPressed = false;
	private static String position = "res/bg.jpg";
	private Image image;
	
	public PokGame(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		if(isPressed){
			position = "res/bg2.jpg";
			image = new Image(position);
		}
		image.draw(0, 0);
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		// TODO Auto-generated method stub
		image = new Image(position);
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		// TODO Auto-generated method stub

	}
	
	
	@Override
	public void keyPressed(int key, char c) {
		if (key == Input.KEY_SPACE) {
			isPressed = true;
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
