import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Game extends Application {
	
	//for prepare the graphics
	public void start(Stage titleStage){
		
		titleStage.setTitle("Speedy Rush");
		
		Pane root = new Pane();
		Group root2 = new Group();
		Scene titleScene = new Scene(root,400,600);
		Font myFont = new Font("Consolas",18);
		

		/**	
		Button btn3 = new Button();
		btn3.setText("Back");
		root2.getChildren().add(btn3);
		
		btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	titleScene.setRoot(root);
            	titleStage.setScene(titleScene);
            	
            }
        });
		**/
		
		
		Button btnStart = new Button();
		btnStart.setFont(myFont);
		btnStart.setText("Start Game");
		
		btnStart.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	            	titleScene.setRoot(root2);
	            	titleStage.setScene(titleScene);
	            	
	            }
	        });
		
		
		Button btnScoreBoard = new Button();
		btnScoreBoard.setFont(myFont);
		btnScoreBoard.setText("Highscore");
		btnScoreBoard.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	                System.out.println("Hello World!");
	            }
	        });
		
		btnStart.setMaxWidth(Double.MAX_VALUE);
		btnScoreBoard.setMaxWidth(Double.MAX_VALUE);
		
		VBox menuButtons = new VBox(2);
		menuButtons.setPrefHeight(150);
		menuButtons.setPrefWidth(200);
		menuButtons.setSpacing(30);
		menuButtons.setLayoutX(100);
		menuButtons.setLayoutY(320);
        menuButtons.getChildren().add(btnStart);
        menuButtons.getChildren().add(btnScoreBoard);
        
                        
        
        Text gameTitle = new Text("Speedy Rush");
        gameTitle.setFont(new Font("Consolas",46));
        gameTitle.setLayoutX(65);
        gameTitle.setLayoutY(80);
        
        Text gameCredit = new Text("Created by ISOM3320 Group 2 (2015-16 Winter)");
        gameCredit.setFont(new Font("Consolas",13));
        gameCredit.setLayoutX(45);
        gameCredit.setLayoutY(580);
        
        Rectangle BackgroundTitle = new Rectangle(400,80);
        BackgroundTitle.setFill(Color.web("#ffffff",0.9));
        BackgroundTitle.setLayoutX(0);
        BackgroundTitle.setLayoutY(27);
        
        Rectangle BackgroundCredit = new Rectangle(400,30);
        BackgroundCredit.setFill(Color.web("#ffffff",0.9));
        BackgroundCredit.setLayoutX(0);
        BackgroundCredit.setLayoutY(560);
        
        Rectangle backgroundRoad = new Rectangle(250,600);
        backgroundRoad.setStroke(Color.BLACK);
        backgroundRoad.setFill(Color.web("#f2f2f2"));
        backgroundRoad.setLayoutX(75);
        backgroundRoad.setLayoutY(0);
        
        
        root.getChildren().add(backgroundRoad);
        
        roadAnimation(titleScene);
         
        root.getChildren().add(BackgroundTitle);
        root.getChildren().add(BackgroundCredit);
        
        root.getChildren().add(gameTitle);
        root.getChildren().add(menuButtons);
        root.getChildren().add(gameCredit);
        
        
 
        
        
        
        
        titleStage.setScene(titleScene);
        
		titleStage.show();
	}
	public static void main (String[] args){
		launch(args);
	}
	
	public void roadAnimation(Scene scene){
		
		final Pane root = (Pane) scene.getRoot();
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
	
		
		/**
		TranslateTransition[] tt = new TranslateTransition[8];
		
		for (int i = 0; i<8; i++){
			tt[i] = new TranslateTransition(Duration.millis(1000),yellowLines[i]); 
			tt[i].setByY(100);
			tt[i].setCycleCount(Animation.INDEFINITE);
			tt[i].setAutoReverse(false);
		}
		
		ParallelTransition pt = new ParallelTransition(tt);
		

		pt.play();
		**/
		
		
		
		
	}

}
