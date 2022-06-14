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

/**
 * This is the Menu class of the game.
 *
 * <p>
 * Version 1 - 4 hours
 * <br>
 * Created and initialized the scene.
 * <br>
 * Added button and hover interactions.
 * <br>
 * Version 2 - 0.1 hour
 * <br>
 * Changed the way the images were imported. 
 * </p>
 *
 * @author Ethan Zhu
 * @version 02.00.00
 */
public class Menu
{
   /**
    * This is the createMenu method of the Menu class. It will initialize the scene and add elements to the group root, which will be used to initalize the scene. 
    * It will also handle any user input (click/hover).
    * @return The scene that gets created.
    * @throws FileNotFoundException To ignore file not found exception.
    */
   public static Scene createMenu() throws FileNotFoundException
   {
      Boolean won = (LevelThree.getWin()==-1);
      ImageView start = new ImageView(new Image("/Images/Menu/start.png"));
      ImageView instr = new ImageView(new Image("/Images/Menu/instructions.png"));
      ImageView quit = new ImageView(new Image("/Images/Menu/quit.png"));
      ImageView startG = new ImageView (new Image("/Images/Menu/start_g.png"));
      ImageView instrG = new ImageView (new Image("/Images/Menu/instructions_g.png"));
      ImageView quitG = new ImageView (new Image("/Images/Menu/quit_g.png"));
      ImageView winMenu = new ImageView (new Image("/Images/Menu/mainMenu_win.png"));
      ImageView loseMenu = new ImageView (new Image("/Images/Menu/mainMenu_lose.png"));
      start.setX(80);
      start.setY(420); 
      start.setPreserveRatio(true); 
      startG.setX(80);
      startG.setY(422); 
      startG.setPreserveRatio(true); 
      instr.setX(80);
      instr.setY(480); 
      instr.setPreserveRatio(true); 
      instrG.setX(80);
      instrG.setY(482); 
      instrG.setPreserveRatio(true); 
      quit.setX(80);
      quit.setY(540); 
      quit.setPreserveRatio(true); 
      quitG.setX(80);
      quitG.setY(540); 
      quitG.setPreserveRatio(true); 
      Group root = new Group();
      if (won)
         root.getChildren().add(winMenu);
      else
         root.getChildren().add(loseMenu);
      root.getChildren().add(start);
      root.getChildren().add(instr);
      root.getChildren().add(quit);
      Scene scene = new Scene(root, Color.WHITE);
      scene.setOnMouseMoved(
         new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               int x = (int)event.getX();
               int y = (int)event.getY();
               if (x >= 90 && x <= 195 && y >= 430 && y <= 455)
               {
                  scene.setCursor(Cursor.HAND);
                  if (!root.getChildren().contains(startG))
                     root.getChildren().add(startG); 
               }
               else if (x >= 90 && x <= 350 && y >= 485 && y <= 515)
               {
                  scene.setCursor(Cursor.HAND);
                  if (!root.getChildren().contains(instrG))
                     root.getChildren().add(instrG); 
               }
               else if (x >= 90 && x <= 170 && y >= 550 && y <= 575)
               {
                  scene.setCursor(Cursor.HAND);
                  if (!root.getChildren().contains(quitG))
                     root.getChildren().add(quitG); 
               }
               else
               {
                  if (root.getChildren().contains(startG))
                  {
                     root.getChildren().remove(startG); 
                  }
                  if (root.getChildren().contains(instrG))
                  {
                     root.getChildren().remove(instrG); 
                  }
                  if (root.getChildren().contains(quitG))
                  {
                     root.getChildren().remove(quitG);  
                  }
                  scene.setCursor(Cursor.DEFAULT);
               }
            }
         });
      return scene;
   }

}