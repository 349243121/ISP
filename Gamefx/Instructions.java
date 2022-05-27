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
      ImageView screen = new ImageView(new Image("/Images/Menu/instructions_screen2.0.png"));
      screen.setPreserveRatio(true);
      ImageView back = new ImageView(new Image("/Images/General/leftButt.png"));
      back.setPreserveRatio(true);
      back.setFitWidth(50);
      back.setFitHeight(50);
      back.setX(50);
      back.setY(50);

      Group root = new Group();
      root.getChildren().add(screen);
      root.getChildren().add(back);
      Scene scene = new Scene(root, Color.WHITE);
      scene.setOnMouseMoved(
         new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               int x = (int)event.getX();
               int y = (int)event.getY();
               if (x >= 50 && x <= 90 && y >= 50 && y <= 100)
               {
                  scene.setCursor(Cursor.HAND);
               }
               else
               {
                  scene.setCursor(Cursor.DEFAULT);
               }
            }
         });

      return scene;
   }
}