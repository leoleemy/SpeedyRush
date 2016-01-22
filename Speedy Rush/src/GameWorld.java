import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class GameWorld{
	Scene gameScene;
	GameWorld(Game game){
		Pane gameWorldPane = new Pane();
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
		
		gameWorldPane.getChildren().add(levelBox);
		gameWorldPane.getChildren().add(playerInfoBox);
		gameWorldPane.getChildren().add(txtLevel);
		gameWorldPane.getChildren().add(txtScore);
		gameWorldPane.getChildren().add(txtArmor);	
	}

	
	
}
