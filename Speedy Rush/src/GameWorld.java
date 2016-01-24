import javax.imageio.ImageIO;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class GameWorld implements Runnable{
	Scene gameScene;
	Player player = new Player();
	Pane gameWorldPane;
	Pane roadPane;
	
	
	GameWorld(Game game){
		gameWorldPane = new Pane();
		roadPane = new Pane();
		
		gameScene = new Scene(gameWorldPane,400,600);
		Font gameFont = new Font("Consolas",21);
		
		Rectangle levelBox = new Rectangle(125,40);
		levelBox.setFill(Color.web("#ffffff",0.9));
		levelBox.setLayoutX(0);
		levelBox.setLayoutY(0);
		
		Rectangle playerInfoBox = new Rectangle(190,70);
		playerInfoBox.setFill(Color.web("#ffffff",0.9));
		playerInfoBox.setLayoutX(210);
		playerInfoBox.setLayoutY(0);
		
		Text txtLevel = new Text("Level ");
		txtLevel.setFont(gameFont);
		txtLevel.setLayoutX(10);
		txtLevel.setLayoutY(25);
        
        Text txtScore = new Text("Score:");
        txtScore.setFont(gameFont);
        txtScore.setLayoutX(220);
        txtScore.setLayoutY(30);
        
        Text txtArmor = new Text("Armor:");
        txtArmor.setFont(gameFont);
        txtArmor.setLayoutX(220);
        txtArmor.setLayoutY(60);
		
        roadStartAnimation(gameScene);
        gameWorldPane.getChildren().add(roadPane);
        
		gameWorldPane.getChildren().add(levelBox);
		gameWorldPane.getChildren().add(playerInfoBox);
		gameWorldPane.getChildren().add(txtLevel);
		gameWorldPane.getChildren().add(txtScore);
		gameWorldPane.getChildren().add(txtArmor);	
				
	}

	public void roadStartAnimation(Scene scene){
		 final Pane root = (Pane) scene.getRoot();
		 
		 Rectangle backgroundRoad = new Rectangle(250,600);
	     backgroundRoad.setStroke(Color.BLACK);
	     backgroundRoad.setFill(Color.web("#f2f2f2"));
	     backgroundRoad.setLayoutX(75);
         backgroundRoad.setLayoutY(0);
		 
         root.getChildren().add(backgroundRoad);
         
		 Rectangle[] yellowLines = new Rectangle[8];
		 

		for (int i = 0; i<8; i++){
			yellowLines[i] = new Rectangle(10,75);
			yellowLines[i].setStroke(Color.BLACK);
	        yellowLines[i].setArcHeight(5);
	        yellowLines[i].setArcWidth(5);
	        yellowLines[i].setFill(Color.web("#ffff00"));
	        yellowLines[i].setLayoutX(195);
	        yellowLines[i].setLayoutY(-90 + i*100);
	        root.getChildren().add(yellowLines[i]);
		}
		
		Timeline tl = new Timeline();
		KeyValue[] linesY = new KeyValue[8];
		KeyValue[] linesNewY = new KeyValue[8];
		
		for (int i = 0; i<8; i++){
			linesY[i] = new KeyValue(yellowLines[i].layoutYProperty(), yellowLines[i].getLayoutY());
		}
		for (int i = 0; i<8; i++){
			linesNewY[i] = new KeyValue(yellowLines[i].layoutYProperty(), yellowLines[i].getLayoutY()+100);
		}
		
		
		KeyFrame kf1 = new KeyFrame(Duration.millis(0),linesY);
		KeyFrame kf2 = new KeyFrame(Duration.millis(2000),linesNewY);
		
		tl.getKeyFrames().addAll(kf1,kf2);
		tl.setCycleCount(Animation.INDEFINITE);
		tl.play();	
	}
	
	public void initGame(){	
	     player.create(roadPane);
	     gameScene.setOnMouseMoved(
					new EventHandler<MouseEvent>(){
						public void handle(MouseEvent e){
							player.move(e);	
						}
					});
	}
	
	public void playerCreated(Scene scene){
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		
	}
	
}
