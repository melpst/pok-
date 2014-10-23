package pok;
public interface Entity {
	
	Renderable getRenderable();
	void update(int delta);
	boolean isDeletable();
	void gotHit();
	float getCenterX();
	float getCenterY();
}