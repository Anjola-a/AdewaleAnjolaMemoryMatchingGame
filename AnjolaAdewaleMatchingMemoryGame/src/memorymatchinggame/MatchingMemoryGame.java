package memorymatchinggame;

/*
 * Adewale Anjola
 * Memory Matching Game
 * 
 * June 17, 2019
 * ICS3U
 * 
 * This program allows you to log into a game, once you are logged in, you play a matching game. 
 * The objective of this game is to match each pair of like pictures. The more pictures you match, the higher your score.
 */

import java.util.concurrent.TimeUnit;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.text.FontWeight;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.animation.AnimationTimer;

public class MatchingMemoryGame extends Application { // All my global variables are declared


	Scene scene, scene2,scene3;
	Button btn,but1,but2,but3,but4,but5,but6,but7,but8,but9,but10;
	TextField userTextField;
	final Text  actiontarget = new Text();;
	Label pw;
	PasswordField pwBox;
	Stage primaryStage;
	int points = 0;
	int choice=0;
	int butt6,butt1,butt2,butt3,butt4,butt5,butt10,butt7,butt8,butt9;
	boolean btn1;
	Button [] squares;
	int a = 0;
	int b = 0;
	int aIndex = 0;
	int bIndex = 0;
			
	int [] clicked = new int[10]; // Each element in choice, corresponds to a button. 
	//If a button is clicked, the value or the element corresponding to the button is changed. This values depends on the image behind the button.
	// once two buttons are paired, their 'clicked' values become -1
	// un-clicked button have 'clicked' values of 0

	public static void main(String args[]) {
		launch(args);
	}



	class game { // This class displays the game scene and all its components
		game () {
			
			// This organizes the scene, and places the components in their specified location
			Stage game=new Stage();
			GridPane grid = new GridPane();
			grid.setHgap(5);
			grid.setVgap(5);
			Text status = new Text("");
			status.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			Label wLabel = new Label ("Welcome to Anjola's matching game!");
			wLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 13));
			Label point = new Label (" ");
			
			but1 = new Button();			
			but2 = new Button();			
			but3 = new Button();			
			but4 = new Button();
			but5 = new Button();
			but6 = new Button();
			but7 = new Button();
			but8 = new Button();
			but9 = new Button();	
			but10 = new Button();
		
			grid.setStyle("-fx-background-color: #3390FF;");
			
			grid.add(wLabel, 3,0,2, 1);
			grid.add(point,7,6);
			grid.add(status, 7,5);
			grid.add(but1, 2,4);
			grid.add(but2, 3,4); 
			grid.add(but3, 4,4); 
			grid.add(but4, 2,5);
			grid.add(but5, 3,5);
			grid.add(but6, 4,5);
			grid.add(but7, 5,5);
			grid.add(but8, 5,4);
			grid.add(but9, 6,5);
			grid.add(but10, 6,4);
			
			
			
			// Each element is squares is equal to a button
			squares = new Button[10];
			squares[0]=but1;
			squares[1]=but2;
			squares[2]=but3;
			squares[3]=but4;
			squares[4]=but5;
			squares[5]=but6;
			squares[6]=but7;
			squares[7]=but8;
			squares[8]=but9;
			squares[9]=but10;
			scene= new Scene(grid, 700, 400);
			
			for (int i=0; i<squares.length; i++){ // set the size and background color of each button
				squares[i].setStyle("-fx-background-color: #F3FF33;");
				squares[i].setMinSize(100,100);
				
		
			}
			
			// When a specific button is pressed, the statements that correspond to the button are implemented
			but1.setOnAction(new EventHandler<ActionEvent> () { 
				@Override
				public void handle (ActionEvent e) {
					but1.setStyle("-fx-background-image:url('sqr.png');" +  "-fx-background-size: cover;");
					choice ++;
					clicked[0]=1;
				}
			  
			 });
			but2.setOnAction(new EventHandler<ActionEvent> () {			
				@Override
				public void handle (ActionEvent e) {
					but2.setStyle("-fx-background-image:url('str.png');" +  "-fx-background-size: cover;");
					choice ++;
					clicked[1]=3;
				}
			  
			 });
			but3.setOnAction(new EventHandler<ActionEvent> () {			
				@Override
				public void handle (ActionEvent e) {
					but3.setStyle("-fx-background-image:url('cyl.png');" +  "-fx-background-size: cover;");
					choice ++;
					
					clicked[2]=2;
				}
			  
			 });
			but4.setOnAction(new EventHandler<ActionEvent> () {			
				@Override
				public void handle (ActionEvent e) {
					but4.setStyle("-fx-background-image:url('str.png');" +  "-fx-background-size: cover;");
					choice ++;
					
					clicked[3]=3;
				}
			  
			 });
			but5.setOnAction(new EventHandler<ActionEvent> () {			
				@Override
				public void handle (ActionEvent e) {
					but5.setStyle("-fx-background-image:url('cyl.png');" +  "-fx-background-size: cover;");
					choice ++;
					clicked[4]=2;
					
				}
			  
			 });
			but6.setOnAction(new EventHandler<ActionEvent> () {			
				@Override
				public void handle (ActionEvent e) {
					
					but6.setStyle("-fx-background-image:url('str.png');" +  "-fx-background-size: cover;");
					choice ++;
					
					clicked[5]=3;
				}
			  
			 });
			but7.setOnAction(new EventHandler<ActionEvent> () {			
				@Override
				public void handle (ActionEvent e) {
					but7.setStyle("-fx-background-image:url('cyl.png');" +  "-fx-background-size: cover;");
					choice ++;
					clicked[6]=2;
					
				}
			  
			 });
			
			but8.setOnAction(new EventHandler<ActionEvent> () {			
				@Override
				public void handle (ActionEvent e) {
					but8.setStyle("-fx-background-image:url('sqr.png');" +  "-fx-background-size: cover;");
					choice ++;
					clicked[7]=1;
					
				}
			
			
			});
			but9.setOnAction(new EventHandler<ActionEvent> () {
				@Override
				public void handle (ActionEvent e) {
					but9.setStyle("-fx-background-image:url('cyl.png');" +  "-fx-background-size: cover;");
					choice ++;
					clicked[8]=2;
				}
			  
			 });
			but10.setOnAction(new EventHandler<ActionEvent> () {			
				@Override
				public void handle (ActionEvent e) {
					but10.setStyle("-fx-background-image:url('str.png');" +  "-fx-background-size: cover;");
					choice ++;
					clicked[9]=3;
					
				}
			  
			 });
			
			
			game.addEventFilter(MouseEvent.MOUSE_CLICKED, keyEvent -> {
				
				
				
				if (choice== 2) { // once two button are clicked, the unclicked ones are temporarily disabled. 
					//To ensure that those two are the only ones being compared.
					
					for (int i=0; i<squares.length; i++){
						squares[i].setDisable(true);
				
					}
					
					
					for (int i=0; i<clicked.length; i++){// loops through the clicked array to collect the value (picture) and position of the clicked buttons.
						if (clicked[i]>0) {
							if(a==0) {
								a=clicked[i];
								aIndex=i;
								
							}else {
								b=clicked[i];
								bIndex=i;
							}
						}
					}
					
					
					
					if (a==b) { // If the values for clicked are the same, they get a point, and their clicked values become -1
						status.setText("You get a point");
						points ++;
						point.setText("Score : " + points );
						
						clicked[bIndex]=-1;
						clicked[aIndex]=-1;

						
						for (int i=0; i<squares.length; i++){
							
							if (clicked[i]>=0) { // All buttons except the paired ones are re enabled.
								squares[i].setDisable(false);
							
							}
							
						}
						
						
					}else { // If the pictures do not match, the buttons are re enabled. They are also covered to conceal the pictures.
						status.setText("No match :(");
					
						for (int i=0; i<squares.length; i++){
							if (clicked[i]>=0) {
								
								squares[i].setDisable(false);
								
							}
						}
						
						// This animation timer delays the concealing of the unmatched buttons
						final long startNanoTime = System.nanoTime();
						new AnimationTimer(){
							
							public void handle(long currentNanoTime)
							{
								double t = (currentNanoTime-startNanoTime);
								

								if (t >1000000000*0.8){
									squares[aIndex].setStyle("-fx-background-color: #F3FF33;");
									squares[bIndex].setStyle("-fx-background-color: #F3FF33;");
									this.stop();
								}
							}
							
						}.start();
						
						
					// The buttons are reset to their unclicked values	
					clicked[bIndex]=0;
					clicked[aIndex]=0;
				}
					choice =0;
					a=0;
					b=0;
					
			}
		
				
					
		});
			
			

			game.setScene(scene);
			game.show();

		}
	}

	
	class Login{ // This class displays the login screen, which takes the user to the game screen if their password is correct
		Login(){
			
			
				
				Stage primaryStage = new Stage();
			
				primaryStage.setTitle("Log In");
				GridPane grid = new GridPane();
				grid.setHgap(5);
				grid.setVgap(5);
				
				Label info = new Label("");
				grid.add(info, 2, 5);
				
				Text scenetitle = new Text("Welcome");
				scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
				grid.add(scenetitle, 1,0,2,1);
				
				Label userName = new Label("User Name: "); 
				grid.add(userName, 1,1);
				
				userTextField = new TextField();
				grid.add(userTextField, 2, 1);
				
				pw = new Label("Password: ");
				grid.add(pw, 1, 2);
				
				pwBox = new PasswordField();
				grid.add(pwBox, 2, 2);



				Button btn1 = new Button("Instructions");
				grid.add(btn1, 3, 6);
				Button btn = new Button("Sign in");
				
				
				btn.setOnAction(new EventHandler<ActionEvent> () { // Once the sign in button is pressed, the users credentials are verified.
					@Override
					public void handle (ActionEvent e) {
						String u = userTextField.getText();
						String p = pwBox.getText();
					
					
					// If the entered password matches one of the following, the user is taken to the game stage
					if (u.equalsIgnoreCase("Anjola") && p.equalsIgnoreCase("123")) {
						new game();
					
					}else
						info.setText("Access Denied");
					
					
					}
					
					
			});
				
				

				

				btn1.setOnAction(eve -> new instructions()); // When the instructions button is pressed,
					// the instructions for the game is displayed

					
				// More stage organization
				HBox hbBtn = new HBox(10);
				hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
				hbBtn.getChildren().add(btn);
				grid.add(hbBtn, 1, 4);
				
				scene= new Scene(grid, 400, 200);
				primaryStage.setScene(scene);
				primaryStage.show();


		}
		
	}
	
	
	class instructions { // displays the instructions for the game and takes the player back to the log in screen when the 'back' button is clicked
		instructions () {
			Stage instructions=new Stage();
			GridPane grid = new GridPane();
			grid.setHgap(5);
			grid.setVgap(5);
			Label x= new Label ("Instructions\n ");
			x.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
			Label wLabel = new Label ("\n Click on each tile, to reveal the image behind it.\n Once the image is revealed click on another tile to compare \n the images. If the images are the same, you get a point! If not,\n you get to try again.");
			wLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL,12));
			Scene scene3= new Scene(grid, 400, 210);
			
			grid.add(x, 0, 0);
			grid.add(wLabel, 0, 1);
			instructions.setScene(scene3);
			instructions.show();
			
			Button btn1 = new Button("back");
			grid.add(btn1, 1, 6);
			btn1.setOnAction(eve->new Login());
					
				
	  }
	}
	
	
	
	@Override
	public void start (Stage primaryStage) throws Exception { // Where the program starts
		
		new Login();


}

}







