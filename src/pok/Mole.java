package pok;

public class Mole implements Entity {
	private static final float WIDTH = 150;
	private static final float HEIGHT = 107;
	private int[] moleX = { 125, 250, 340 };
	private int[] moleY = { 280, 150, 400 };
	private float x;
	private float y;
	private boolean isDead;

	// private String type;

	public Mole(int index) {
		// TODO Auto-generated constructor stub
		index = 1;
		this.x = moleX[index];
		this.y = moleY[index];
		this.isDead = false;
	}

	public float getX() {
		// TODO Auto-generated method stub
		return x;
	}

	public float getY() {
		// TODO Auto-generated method stub
		return y;
	}

	public float getCenterX() {
		// TODO Auto-generated method stub
		return x + (WIDTH / 2);
	}

	public float getCenterY() {
		// TODO Auto-generated method stub
		return y + (HEIGHT / 2);
	}

	public Renderable getRenderable() {
		return new MoleImage(this, "res/badmole.png");
	}

	public void gotHit() {
		this.isDead = true;
	}

	@Override
	public void update(int delta) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isDeletable() {
		// TODO Auto-generated method stub
		return isDead;
	}

}
