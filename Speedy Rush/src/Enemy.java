import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Enemy extends Entity implements Runnable{
	double xCoord;
	double yCoord;
	int width = 50;
	int height = 100;
	Image[] EnemyImage = {new Image("/img/EnemyCar01.jpg")};
	ImageView EnemyView = new ImageView(EnemyImage[0]);
	float speed;
	float respawnSpeed;
	int score;
	boolean passed;

	@Override
	public void move(float multiplier) {
		// TODO Auto-generated method stub
		this.yCoord += 1;  //moving downward
		this.EnemyView.setY(yCoord);

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		//this. = null;
		 
		

	}
	
	public void respawn(Pane pane){
		xCoord = 400*Math.random() + 70;
		yCoord = 40;
		EnemyView.setImage(EnemyImage[0]);
		EnemyView.setX(xCoord);
		EnemyView.setY(40);
		pane.getChildren().add(EnemyView);
		
	}

	@Override
	public void run() {
		checkCollision p = new checkCollision();
		p.start();
		while (this.yCoord <= 300){ //yCoord = 600 final
			try {
				this.move(0);  //moving downward
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	this.destroy();	
		
	}
	
	class checkCollision extends Thread{
		public void run(){
			while (yCoord <= 600){
			if (passed == false){
				System.out.println(false);
				if (yCoord > Player.yCoord) {
					passed = true;
					GameWorld.addScore();
					Thread.interrupted();
				}
			}
			//if(xCoord + )
			
		}
			
			
		}
		
	}
		
	}

