import javafx.animation.*;  
import javafx.animation.SequentialTransition;  
import javafx.application.Application;  
import javafx.scene.Group;  
import javafx.scene.Scene;  
import javafx.scene.paint.Color;  
import javafx.scene.shape.Circle;  
import javafx.stage.Stage;  
import javafx.util.Duration;  
import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;  
import javafx.stage.Stage;  
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.Cursor;
import java.util.*;
import java.util.concurrent.atomic.*;
import javafx.scene.input.KeyCode;
import java.lang.Thread;
import javafx.event.ActionEvent;
/**
 * This is the Main class of the game.
 *
 * <p>
 * Version 1 - 1 hour
 * <br>
 * Created the framework and initalized the stage.
 * <br>
 * Version 2 - 1 hour
 * <br>
 * Added instructions and level one to the menu directories. 
 * <br>
 * Version 3 - 4 hours
 * Revamped the structure of the class to allow re-starting and re-initalizing scenes.
 * </p>
 *
 * @author Ethan Zhu
 * @version 03.00.00
 */
 
public class Main extends Application {
   
   /**This is the variable that will determine the choice of the user in the main menu.*/
   private int menuChoice = 0;
   /**This is the variable that stores the scene created by LevelOne.*/
   private Scene lvl1;
   /**This is the variable that stores the scene created by LevelTwo.*/
   private Scene lvl2;
   /**This is the variable that stores the scene created by LevelThree.*/
   private Scene lvl3;
   /**This is the variable that stores the scene created by LevelTwoP2.*/
   private Scene lvl22;
   /**This is the variable that stores the scene created by Instructions.*/
   private Scene instructions;
   /**This is the variable that stores the scene created by Menu.*/
   private Scene menu;
   
   private Scene fadeScene;
   
   private Boolean firstRun = true;
   
   /**
    * This is the method that will start the game, including initializing the stage and initializing the scenes.
    * It will also handle any key-presses that will result in a change of scenes.
    * @param stage The stage of the game.
    * @throws FileNotFoundException To ignore file not found exception.
    */
   public void startGame(Stage stage) throws FileNotFoundException
   {
      
      lvl1 = LevelOne.createLevelOne();
      lvl2 = LevelTwo.createLevelTwo();
      lvl22 = LevelTwoP2.createLevelTwoP2();
      lvl3 = LevelThree.createLevelThree();
      instructions = Instructions.createInstructions();
      menu = Menu.createMenu();
      stage.setScene(menu);
   
      menu.setOnMouseClicked(
            new EventHandler<MouseEvent>() {
               @Override
               public void handle(MouseEvent event) {
                  int x = (int)event.getX();
                  int y = (int)event.getY();
                  //System.out.println(x + ", " + y); //helper. will be removed
                  if (x >= 90 && x <= 195 && y >= 430 && y <= 455)
                  {
                     stage.setScene(lvl3);
                  }
                  else if (x >= 90 && x <= 350 && y >= 485 && y <= 515)
                  {
                     stage.setScene (instructions);
                  }
                  else if (x >= 90 && x <= 170 && y >= 550 && y <= 575)
                     Platform.exit();
               }
            });
      instructions.setOnMouseClicked(
            new EventHandler<MouseEvent>() {
               @Override
               public void handle(MouseEvent event) {
                  int x = (int)event.getX();
                  int y = (int)event.getY();
                  if (x >= 50 && y >= 50 && x <= 90 && y <= 100)
                  {
                     stage.setScene (menu);
                  }
               }
            });
      lvl1.setOnKeyPressed(
         e -> {
            if (e.getCode() == KeyCode.SPACE && LevelOne.getWin()) {
               stage.setScene(lvl2);
            }
         });
      lvl2.setOnKeyPressed(
         e -> {
            try
            {
               if (e.getCode() == KeyCode.SPACE && LevelTwo.getStatus() == -1) {
               System.out.println("pls");
                  restart (stage);
               }
               if (e.getCode() == KeyCode.SPACE && LevelTwo.getStatus() == 100) {
                  stage.setScene(lvl22);
               }
            }
            catch (FileNotFoundException f)
            {
            
            }
         });
      lvl22.setOnKeyPressed(
         e -> {
            if (e.getCode() == KeyCode.SPACE && LevelTwoP2.getWin()) {
               stage.setScene(lvl3);
            }
         });
      lvl3.setOnKeyPressed(
         e -> {
            if (e.getCode() == KeyCode.SPACE && LevelThree.getWin() == 1) {
            System.out.println("no");
               try
               {
                  restart (stage);
               }
               catch (FileNotFoundException f)
               {
               
               }
            }
         });
   
   }
   
   /**
    * This is the method that will be called to re-initialize the stage's scenes.
    * @param stage The stage of the game
    * @throws FileNotFoundException To ignore file not found exception.
    */
   public void restart (Stage stage) throws FileNotFoundException
   {
      startGame (stage);
   }
   
   /**
   * This is the start method, which is inherited from Application class.
   * It will be used to run the program and initalize the stage.
   * @param stage The stage that will be used.
   * @throws FileNotFoundException To ignore file not found exception.
   */
   @Override
   public void start(Stage stage) throws FileNotFoundException
   {
      stage.setTitle("Going Bananas");
      Image icon = new Image("/Images/General/logo.png");
      stage.setX(0);
      stage.setY(0);
      stage.getIcons().add(icon);
      stage.setWidth(1280);
      stage.setHeight(720);
      stage.setResizable(false);
      stage.setX(0);
      stage.setY(0);
      
      ImageView normalIdeas = new ImageView(new Image("/Images/General/NormalIdeas.png"));
      normalIdeas.setPreserveRatio(true);
      normalIdeas.setFitWidth(960);
      normalIdeas.setFitHeight(540);        
      normalIdeas.setX(350);
      normalIdeas.setY(70);
      ImageView splashLogo = new ImageView(new Image("/Images/General/SplashLogo.png"));
      splashLogo.setPreserveRatio(true);
      splashLogo.setFitWidth(1280);
      splashLogo.setFitHeight(720);  
      FadeTransition fade1 = new FadeTransition();   
      fade1.setDuration(Duration.millis(2500));  
      fade1.setFromValue(0);  
      fade1.setToValue(10);  
      fade1.setCycleCount(2);  
      fade1.setAutoReverse(true);  
      fade1.setNode(normalIdeas);
      fade1.play();
      FadeTransition fade2 = new FadeTransition();
      fade2.setDuration(Duration.millis(2500));  
      fade2.setFromValue(0);  
      fade2.setToValue(10);  
      fade2.setCycleCount(2);
      fade2.setAutoReverse(true);  
      fade2.setNode(splashLogo);
      Group root = new Group();  
      root.getChildren().addAll(normalIdeas);  
      fade1.setOnFinished(
         new EventHandler<ActionEvent>() {
         
            @Override
            public void handle(ActionEvent event) {
               fade2.play();
               root.getChildren().addAll(splashLogo);
            }
         });
   
      fade2.setOnFinished(
         new EventHandler<ActionEvent>() {
         
            @Override
            public void handle(ActionEvent event) {
               try{
                  startGame(stage);
                  //replace with second splash screen
               }
               catch(FileNotFoundException e){}
            }
         });
      
      Scene scene = new Scene(root,1280,720,Color.BLACK);  
      stage.setScene(scene);
      
      startGame(stage);
      stage.show();
   }
     
   /**
   * The main method, which is unused.
   * @param args Unused.
   */
   public static void main (String [] args)
   {
      launch (args);
   }
   
}