import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

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
		xCoord = (250-width)*Math.random() + 70;
		yCoord = 40;
		EnemyView.setImage(EnemyImage[0]);
		EnemyView.setX(xCoord);
		EnemyView.setY(40);
		pane.getChildren().add(EnemyView);
		
	}

	@Override
	public void run() {
		checkCollision p = new checkCollision();
		checkPass pk = new checkPass();
		p.start();
		pk.start();
		while (this.yCoord <= 600){ 
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
	class checkPass extends Thread{
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
			}
		}
	}
	
	class checkCollision extends Thread{
		public void run(){
			while (yCoord <= 600){
				if((yCoord + height > Player.yCoord) && 
					(yCoord < Player.yCoord + Player.height) &&
					(xCoord < Player.xCoord + Player.width) &&
					(xCoord + width > Player.xCoord))
			{
				System.out.println("hit");
				Player.armor -= 10;
				GameWorld.txtArmor.setText("Armor: " + Player.armor);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		}
			
			
		}
		
	}
		
	}

