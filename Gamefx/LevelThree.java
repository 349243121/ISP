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
import javafx.animation.*;
import javafx.util.Duration;


public class LevelThree
{
   private static AtomicReference <Boolean> won = new AtomicReference<>(false);
   
   public static Boolean getWin()
   {
      return won.get();
   }
   
   /**
    * This is the createLevelThree method of the levelTwoThree class. It will initalize the scene and add elements to the group root, which will be used to initalize the scene. 
    * It will also handle any user input (click/hover).
    * @return The scene that gets created.
    * @throws FileNotFoundException To ignore file not found exception.
    */
   public static Scene createLevelThree() throws FileNotFoundException
   {
      ImageView one = new ImageView (new Image("/Images/Room3/room3_1.png"));
      one.setPreserveRatio(true);
      one.setFitWidth(50);
      one.setFitHeight(50);
      one.setX(1280);
      one.setY(720);

      
      Group root = new Group();
      root.getChildren().add(scenes.get(0));
      root.getChildren().add(rightButt);
      root.getChildren().add(leftButt);
      root.getChildren().add(objective);
      Scene scene = new Scene(root, Color.WHITE);
      
      //boolean variables
      AtomicReference<Boolean> inSafe = new AtomicReference<>(false);
      AtomicReference<Boolean> safeOpen = new AtomicReference<>(false);
      AtomicReference<String> code = new AtomicReference<>("");
      AtomicReference<Boolean> inDialogue = new AtomicReference<>(false);
      
      scene.setOnMouseClicked(
            new EventHandler<MouseEvent>() {
               @Override
               public void handle(MouseEvent event) {
                  int x = (int)event.getX();
                  int y = (int)event.getY();
               }
               
            });
      scene.setOnMouseMoved(
         new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               int x = (int)event.getX();
               int y = (int)event.getY();
            }
         });
      return scene;
            
   
   }

}