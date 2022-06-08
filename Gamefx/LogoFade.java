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

public class LogoFade {  
 
   public static ImageView createFade () throws FileNotFoundException  {  
   
      ImageView normalIdeas = new ImageView(new Image("/Images/General/NormalIdeas.png"));
      normalIdeas.setPreserveRatio(true);
      normalIdeas.setFitWidth(1280);
      normalIdeas.setFitHeight(720);        
      FadeTransition fade = new FadeTransition();   
      fade.setDuration(Duration.millis(2500));  
      fade.setFromValue(0);  
      fade.setToValue(10);  
      fade.setCycleCount(2);  
      fade.setAutoReverse(true);  
      fade.setNode(normalIdeas);
      fade.play();
        
      return normalIdeas;
   }
   
   public static Scene fade () throws FileNotFoundException  {  
   
      ImageView logo = createFade();
          
      Group root = new Group();  
      root.getChildren().add(logo);  
      Scene scene = new Scene(root,1280,720,Color.BLACK);  
      return scene;
   }
   
   
}