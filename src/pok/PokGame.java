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
	private String bgImagePos = "res/bg.png";
	private boolean isActive = false;
	private boolean isStarted = false;
	private Image bgImage;
	private Hammer hammer;
	private HashMap<Entity, Renderable> renderables;
	private LinkedList<Entity> entities;
	private LinkedList<Entity> iterator;
	private int millis;
	private int deadTime = 0;
	private int birthTime = 0;
	private int score = 0;

	public PokGame(String title) {
		super(title);
		// TODO Auto-generated constructor stub
		entities = new LinkedList<Entity>();
		renderables = new HashMap<Entity, Renderable>();
	}

	@Override
	public void render(GameContainer container, Graphics game) throws SlickException {
		// TODO Auto-generated method stub
		bgImage.draw(0, 0);
		gameState(game);
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		// TODO Auto-generated method stub
		bgImage = new Image(bgImagePos);
		hammer = new Hammer(GAME_WIDTH / 2, GAME_HEIGHT / 2);
		millis = 0;
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		// TODO Auto-generated method stub]
		if (isActive && ((float) millis / 1000) <= 30) {
			millis += delta;
			deleteMole(delta);
			createMole();
		} else if (millis != 0) {
			isActive = false;
			isStarted = true;
		}
	}

	public void gameState(Graphics game) {
		if (!isActive && !isStarted) {
			game.drawString("Press to start.", 250, 230);
		} else if (isActive && !isStarted) {
			for (Entity entity : entities) {
				if (!renderables.containsKey(entity)) {
					renderables.put(entity, entity.getRenderable());
				}
				renderables.get(entity).render(game);
			}
			hammer.render();

			game.drawString("Score: " + score, 525, 35);
			game.drawString("Time: " + ((float) millis / 1000), 525, 15);
		} else if (isStarted) {
			game.drawString("Game Over", 280, 230);
			game.drawString("Score: " + score, 285, 265);
		}
	}

	public void createMole() {
		Iterator<Entity> iterator = entities.iterator();
		Random random = new Random();
		int randomTime = random.nextInt(1000) + 500;

		if (!iterator.hasNext() && millis - deadTime >= randomTime) {
			int index = random.nextInt(5);
			entities.add(new Mole(index));
			birthTime = millis;
			deadTime = 0;
		}

	}

	public void deleteMole(int delta) {
		Iterator<Entity> iterator = entities.iterator();

		while (iterator.hasNext()) {
			Entity entity = iterator.next();
			entity.update(delta);

			Random random = new Random();
			int rand = random.nextInt(500) + 350;

			if (entity.isDeletable() || (!iterator.hasNext() && millis - birthTime >= rand)) {
				iterator.remove();
				renderables.remove(entity);
				deadTime = millis;
				birthTime = 0;
				break;
			}
		}
	}

	private void handleCollision() {
		for (Entity entity : entities) {
			if (hammer.attack(entity.getCenterX(), entity.getCenterY())) {
				entity.gotHit();
				score++;
			}
		}
	}

	@Override
	public void mousePressed(int button, int x, int y) {
		if (isActive && !isStarted) {
			hammer.hit();
			handleCollision();
		} else if (!isStarted) {
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