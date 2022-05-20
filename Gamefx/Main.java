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

public class Main extends Application {
   
   public void start (Stage stage) throws FileNotFoundException
   {
      Scene menu = createMenu();
      stage.setTitle("Going Bananas");
      Image icon = new Image("logo.png");
      stage.getIcons().add(icon);
      stage.setWidth(1920);
      stage.setHeight(1280);
      stage.setResizable(false);
      stage.setX(0);
      stage.setY(0);
      stage.setScene(menu);
      stage.show();
   }
   
   public Scene createMenu() throws FileNotFoundException
   {
      Image start = new Image(new FileInputStream("start.png")); 
      Image instr = new Image(new FileInputStream("instructions.png")); 
      Image quit = new Image(new FileInputStream("quit.png")); 
      ImageView a = new ImageView(start);
      ImageView b = new ImageView(instr);
      ImageView c = new ImageView(quit);
      a.setX(80);
      a.setY(580); 
      a.setPreserveRatio(true); 
      b.setX(80);
      b.setY(660); 
      b.setPreserveRatio(true); 
      c.setX(80);
      c.setY(740); 
      c.setPreserveRatio(true); 
      Group root = new Group(a);
      root.getChildren().add(b);
      root.getChildren().add(c);
      Scene scene = new Scene(root, Color.YELLOW);
      return scene;
   }
   public static void main (String [] args)
   {
      launch (args);
   }
   
}