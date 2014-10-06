public interface Entity {
	
	Renderable getRenderable();
	void update(int delta);
	boolean isDeletable();

}