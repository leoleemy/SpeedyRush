import javafx.scene.image.Image;

public abstract class Entity {
	int xCoord;
	int yCoord;
	int width;
	int length;
	float speed;
	Image image;
	
	public abstract void move(float multiplier);
	
	public abstract void destroy();
	
}
