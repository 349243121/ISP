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
 * </p>
 *
 * @author Ethan Zhu
 * @version 02.00.00
 */
 
public class Main extends Application {
   
   /**This is the variable that will determine the choice of the user in the main menu.*/
   private int menuChoice = 0;
   private Scene lvl1;
   private Scene lvl2;
   private Scene instructions;
   private Scene menu;
   
   public void startGame(Stage stage) throws FileNotFoundException
   {
      stage.setTitle("Going Bananas");
      Image icon = new Image("/Images/General/logo.png");
      stage.getIcons().add(icon);
      stage.setWidth(1280);
      stage.setHeight(720);
      stage.setResizable(false);
      stage.setX(0);
      stage.setY(0);
      lvl1 = LevelOne.createLevelOne();
      lvl2 = LevelTwo.createLevelTwo();
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
                     stage.setScene(lvl2);
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
                  restart (stage);
               }
               if (e.getCode() == KeyCode.SPACE && LevelTwo.getStatus() == 100) {
                  stage.setScene(lvl1);
               }
            }
            catch (FileNotFoundException f)
            {
            
            }
         });
      stage.show();
   
   }
   
   public void restart (Stage stage) throws FileNotFoundException
   {
      startGame (stage);
   }
   
   @Override
   public void start(Stage primaryStage) throws FileNotFoundException
   {
      startGame(primaryStage);
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