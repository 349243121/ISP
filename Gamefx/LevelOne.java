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

public class LevelOne
{
   
   public static Scene createLevelOne() throws FileNotFoundException
   {
      int currentRoomIndex = 0;
      ImageView front = new ImageView(new Image("/Images/Room1/room1_front.png"));
      front.setPreserveRatio(true);
      front.setFitWidth(1280);
      front.setFitHeight(720);
      ImageView right = new ImageView(new Image("/Images/Room1/room1_right.png"));
      right.setPreserveRatio(true);
      right.setFitWidth(1280);
      right.setFitHeight(720);
      ImageView back = new ImageView(new Image("/Images/Room1/room1_back.png"));
      back.setPreserveRatio(true);
      back.setFitWidth(1280);
      back.setFitHeight(720);
      ImageView left = new ImageView (new Image("/Images/Room1/room1_left.png"));
      left.setPreserveRatio(true);
      left.setFitWidth(1280);
      left.setFitHeight(720);
      ImageView [] scenes = new ImageView[4];
      scenes[0] = front;
      scenes[1] = right;
      scenes[2] = back;
      scenes[3] = left;
      Group root = new Group();
      //root.getChildren().add(scenes[0]);
      //root.getChildren().add(scenes[1]);
      root.getChildren().add(scenes[2]);
      //root.getChildren().add(scenes[3]);
      //root.getChildren().add(left);
      Scene scene = new Scene(root, Color.WHITE);
      scene.setOnMouseClicked(
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