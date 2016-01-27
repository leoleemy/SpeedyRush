import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

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
		this.yCoord -= 1;  //moving downward

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
	
	public void respawn(Pane pane){
		
	}

}
