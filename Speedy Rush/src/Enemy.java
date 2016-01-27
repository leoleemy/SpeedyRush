import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Enemy extends Entity {
	int xCoord = 180;
	int yCoord = 100;
	int width = 50;
	int height = 100;
	Image[] EnemyImage;
	ImageView EnemyView;
	float speed;
	float respawnSpeed;
	int score;
	boolean passed;

	@Override
	public void move(float multiplier) {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
