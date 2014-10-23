package pok;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class PokGame extends BasicGame {

	private static final int GAME_HEIGHT = 480;
	private static final int GAME_WIDTH = 640;
	private String position = "res/bg.png";
	private boolean isActive = false;
	private Image image;
	private Hammer hammer;
	private HashMap<Entity, Renderable> renderables;
	private LinkedList<Entity> entities;
	private LinkedList<Entity> iterator;

	public PokGame(String title) {
		super(title);
		// TODO Auto-generated constructor stub
		entities = new LinkedList<Entity>();
		renderables = new HashMap<Entity, Renderable>();
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		image.draw(0, 0);
		for (Entity entity : entities) {
			if (!renderables.containsKey(entity)) {
				renderables.put(entity, entity.getRenderable());
			}
			renderables.get(entity).render(g);
		}
		hammer.render();

	}

	@Override
	public void init(GameContainer container) throws SlickException {
		// TODO Auto-generated method stub
		image = new Image(position);
		hammer = new Hammer(GAME_WIDTH / 2, GAME_HEIGHT / 2);
		createMole();
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		// TODO Auto-generated method stub]
		deleteMole(delta);

	}

	public void createMole() {
		Random random = new Random();
		int index = random.nextInt(2);
		entities.add(new Mole(index));
	}

	public void deleteMole(int delta) {
		Iterator<Entity> iterator = entities.iterator();
		while (iterator.hasNext()) {
			Entity entity = iterator.next();
			entity.update(delta);
			if (entity.isDeletable()) {
				iterator.remove();
				renderables.remove(entity);
				createMole();
				break;
			}
		}
	}

	private void handleCollision() {
		for (Entity entity : entities) {
			if (hammer.attack(entity.getCenterX(), entity.getCenterY())) {
				System.out.println("ATTACK");
				entity.gotHit();
			}
		}

	}

	@Override
	public void mousePressed(int button, int x, int y) {
		if (isActive) {
			hammer.hit();
			handleCollision();
		} else {
			isActive = true;
			hammer.move(x, y);
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
