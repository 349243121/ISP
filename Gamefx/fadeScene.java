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

public class fadeScene {  
  
    public static Scene createFade () throws FileNotFoundException  {  

        Animation logo = LogoFade.createFade();
            
        Group root = new Group();  
        root.getChildren().addAll(logo);  
        Scene scene = new Scene(root,1280,720,Color.BLACK);  
        return scene;
    }
    
}