import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class Player extends Entity {
	int xCoord = 180;
	int yCoord = 470;
	int width = 40;
	int height = 80;
	static int carIndex = 0;
	Image[] playerImage = {new Image("/img/playerCar01.jpg"), new Image("/img/playerCar02.jpg")};
	ImageView playerView = new ImageView(playerImage[carIndex]);
	float speed;
	
	
	public void move(MouseEvent e) {
		// TODO Auto-generated method stub
			if ((e.getY() + 80 > 600)&&(e.getX() < 75)){
				playerView.setX(75);
				playerView.setY(600-80);
			}
			
			else if ((e.getY() + 80 > 600)&&(e.getX() + 40 > 325)){
				playerView.setX(325-40);
				playerView.setY(600-80);
			}
			
			else if (e.getX() < 75){
				playerView.setX(75);
				playerView.setY(e.getY());
			}
			else if (e.getX() + 40 > 325){
				playerView.setX(325-40);
				playerView.setY(e.getY());
			}	
			else if (e.getY() < 0){
				playerView.setX(e.getX());
				playerView.setY(0);
			}
			else if (e.getY() + 80 > 600){
				playerView.setX(e.getX());
				playerView.setY(600-80);
			}
			
			else {
				playerView.setX(e.getX());
				playerView.setY(e.getY());
			}
			
			
		}

	

	@Override
	public void destroy() {

	}
	
	public void create(Pane pane){
		playerView.setImage(playerImage[carIndex]);
		playerView.setX(180);
		playerView.setY(470);
		pane.getChildren().add(playerView);
	}

	public void changeCar(){
		if(carIndex > 1){
			carIndex = 0;
		}
		else if (carIndex < 0){
			carIndex = playerImage.length - 1;
		}
		playerView.setImage(playerImage[carIndex]);
	}


	@Override
	public void move(float multiplier) {
		// TODO Auto-generated method stub
		
	}
	
	

}
