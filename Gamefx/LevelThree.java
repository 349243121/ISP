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
   
   /**
    * This is the createLevelThree method of the levelTwoThree class. It will initalize the scene and add elements to the group root, which will be used to initalize the scene. 
    * It will also handle any user input (click/hover).
    * @return The scene that gets created.
    * @throws FileNotFoundException To ignore file not found exception.
    */
   public static Scene createLevelThree() throws FileNotFoundException
   {
   
      //Background Images
      ImageView voidRoom = new ImageView(new Image("/Images/Room3/room3_void.png"));
      voidRoom.setPreserveRatio(true);
      voidRoom.setFitWidth(1280);
      voidRoom.setFitHeight(720);
      
      ImageView ps5 = new ImageView(new Image("/Images/Room3/room3_ps5.png"));
      ps5.setPreserveRatio(true);
      ps5.setFitWidth(1280);
      ps5.setFitHeight(720);
      
      ImageView painting = new ImageView(new Image("/Images/Room3/room3_painting.png"));
      painting.setPreserveRatio(true);
      painting.setFitWidth(1280);
      painting.setFitHeight(720);
      
      ImageView guitar = new ImageView(new Image("/Images/Room3/room3_guitar.png"));
      guitar.setPreserveRatio(true);
      guitar.setFitWidth(1280);
      guitar.setFitHeight(720);
      
      ImageView happy = new ImageView(new Image("/Images/Room3/room3_happy.png"));
      happy.setPreserveRatio(true);
      happy.setFitWidth(1280);
      happy.setFitHeight(720);
      
      //Dialogue
      ImageView ba1 = new ImageView(new Image("/Images/Room3/Dialogue/BA1.png"));
      ba1.setPreserveRatio(true);
      ba1.setFitWidth(1280);
      ba1.setFitHeight(720);

      ImageView ba2 = new ImageView(new Image("/Images/Room3/Dialogue/BA2.png"));
      ba2.setPreserveRatio(true);
      ba2.setFitWidth(1280);
      ba2.setFitHeight(720);

      ImageView ba3 = new ImageView(new Image("/Images/Room3/Dialogue/BA3.png"));
      ba3.setPreserveRatio(true);
      ba3.setFitWidth(1280);
      ba3.setFitHeight(720);
      
      ImageView ba4 = new ImageView(new Image("/Images/Room3/Dialogue/BA4.png"));
      ba4.setPreserveRatio(true);
      ba4.setFitWidth(1280);
      ba4.setFitHeight(720);

      ImageView ba4_1_1 = new ImageView(new Image("/Images/Room3/Dialogue/BA4-1-1.png"));
      ba4_1_1.setPreserveRatio(true);
      ba4_1_1.setFitWidth(1280);
      ba4_1_1.setFitHeight(720);
      
      ImageView ba4_1_2 = new ImageView(new Image("/Images/Room3/Dialogue/BA4-1-2.png"));
      ba4_1_2.setPreserveRatio(true);
      ba4_1_2.setFitWidth(1280);
      ba4_1_2.setFitHeight(720);
      
      ImageView ba5 = new ImageView(new Image("/Images/Room3/Dialogue/BA5.png"));
      ba5.setPreserveRatio(true);
      ba5.setFitWidth(1280);
      ba5.setFitHeight(720);
      
      ImageView ba6 = new ImageView(new Image("/Images/Room3/Dialogue/BA6.png"));
      ba6.setPreserveRatio(true);
      ba6.setFitWidth(1280);
      ba6.setFitHeight(720);
      
      ImageView ba6C = new ImageView(new Image("/Images/Room3/Dialogue/BA6_Choices.png"));
      ba6C.setPreserveRatio(true);
      ba6C.setFitWidth(1280);
      ba6C.setFitHeight(720);
      
      ImageView ba7_1 = new ImageView(new Image("/Images/Room3/Dialogue/BA7-1.png"));
      ba7_1.setPreserveRatio(true);
      ba7_1.setFitWidth(1280);
      ba7_1.setFitHeight(720);
      
      ImageView ba7_2 = new ImageView(new Image("/Images/Room3/Dialogue/BA7-2.png"));
      ba7_2.setPreserveRatio(true);
      ba7_2.setFitWidth(1280);
      ba7_2.setFitHeight(720);
      
      Group root = new Group();
      root.getChildren().add(voidRoom);
      root.getChildren().add(ba1);
      Scene scene = new Scene(root, Color.WHITE);

      
      scene.setOnMouseClicked(
            new EventHandler<MouseEvent>() {
               @Override
               public void handle(MouseEvent event) {
                  int x = (int)event.getX();
                  int y = (int)event.getY();
                  //For normal dialogue
                  if (root.getChildren().indexOf(ba1) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                  {
                     root.getChildren().remove(ba1);
                     root.getChildren().add(ba2);
                  }
                  if (root.getChildren().indexOf(ba2) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                  {
                     root.getChildren().remove(ba2);
                     root.getChildren().add(ba3);
                  }
                  //For choosing dialogue
                  if (root.getChildren().indexOf(ba3) != -1)
                  {
                     if (x >= 910 && x <= 1250 && y >= 250 && y <= 350){
                        root.getChildren().add(ba4);
                        root.getChildren().remove(ba3);
                     }
                     else if (x >= 910 && x <= 1250 && y >= 350 && y <= 440){
                        root.getChildren().add(ba4_1_1);
                        root.getChildren().remove(ba4_1_2);
                     }    
                  }
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