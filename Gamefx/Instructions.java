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

public class Instructions
{
   
   public static Scene createInstructions() throws FileNotFoundException
   {
      int currentRoomIndex = 0;
      Image front = new Image("/Images/Room1/room1_front.png");
      Image right = new Image("/Images/Room1/room1_right.png");
      Image back = new Image("/Images/Room1/room1_back.png"); 
      Image left = new Image("/Images/Room1/room1_left.png");
      ImageView a = new ImageView(front);
      a.setPreserveRatio(true);
      a.setFitWidth(1280);
      a.setFitHeight(720);
      ImageView b = new ImageView(right);
      b.setPreserveRatio(true);
      b.setFitWidth(1280);
      b.setFitHeight(720);
      ImageView c = new ImageView(back);
      c.setPreserveRatio(true);
      c.setFitWidth(1280);
      c.setFitHeight(720);
      ImageView d = new ImageView (left);
      d.setPreserveRatio(true);
      d.setFitWidth(1280);
      d.setFitHeight(720);
      ImageView [] scenes = new ImageView[4];
      scenes[0] = a;
      scenes[1] = b;
      scenes[2] = c;
      scenes[3] = d;
      Group root = new Group();
      root.getChildren().add(scenes[0]);
      //root.getChildren().add(scenes[1]);
      //root.getChildren().add(scenes[2]);
      //root.getChildren().add(scenes[3]);
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