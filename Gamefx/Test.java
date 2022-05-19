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

public class Test extends Application {

   public static void main (String [] args)
   {
      launch(args);
   }
   
   @Override
   public void start (Stage stage) throws Exception {
      //Stage stage = new Stage();
      Group root = new Group();
      Scene scene = new Scene(root, Color.BLACK);
      stage.setScene(scene);
      stage.setTitle("Identity Crisis Be Like");
      Image icon = new Image("logo.png");
      stage.getIcons().add(icon);
      stage.show();
   }
}