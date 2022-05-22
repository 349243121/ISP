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

public class Menu
{
   
   public static Scene createMenu() throws FileNotFoundException
   {
      Image start = new Image("/Images/Menu/start.png");
      Image instr = new Image("/Images/Menu/instructions.png"); 
      Image quit = new Image("/Images/Menu/quit.png"); 
      Image startG = new Image("/Images/Menu/start_g.png");
      Image instrG = new Image("/Images/Menu/instructions_g.png");
      Image quitG = new Image("/Images/Menu/quit_g.png");
      ImageView a = new ImageView(start);
      ImageView b = new ImageView(instr);
      ImageView c = new ImageView(quit);
      ImageView d = new ImageView (startG);
      ImageView e = new ImageView (instrG);
      ImageView f = new ImageView (quitG);
      a.setX(80);
      a.setY(420); 
      a.setPreserveRatio(true); 
      d.setX(80);
      d.setY(422); 
      d.setPreserveRatio(true); 
      b.setX(80);
      b.setY(480); 
      b.setPreserveRatio(true); 
      e.setX(80);
      e.setY(482); 
      e.setPreserveRatio(true); 
      c.setX(80);
      c.setY(540); 
      c.setPreserveRatio(true); 
      f.setX(80);
      f.setY(540); 
      f.setPreserveRatio(true); 
      Group root = new Group();
      root.getChildren().add(a);
      root.getChildren().add(b);
      root.getChildren().add(c);
      Scene scene = new Scene(root, Color.WHITE);
      scene.setOnMouseMoved(
         new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               int x = (int)event.getX();
               int y = (int)event.getY();
               if (x >= 90 && x <= 170 && y >= 550 && y <= 575)
               {
                  scene.setCursor(Cursor.HAND);
                  if (!root.getChildren().contains(f))
                     root.getChildren().add(f); 
               }
               else if (x >= 90 && x <= 350 && y >= 485 && y <= 515)
               {
                  scene.setCursor(Cursor.HAND);
                  if (!root.getChildren().contains(e))
                     root.getChildren().add(e); 
               }
               else if (x >= 90 && x <= 195 && y >= 430 && y <= 455)
               {
                  scene.setCursor(Cursor.HAND);
                  if (!root.getChildren().contains(d))
                     root.getChildren().add(d); 
               }
               else
               {
                  if (root.getChildren().contains(d))
                  {
                     root.getChildren().remove(d); 
                  }
                  if (root.getChildren().contains(e))
                  {
                     root.getChildren().remove(e); 
                  }
                  if (root.getChildren().contains(f))
                  {
                     root.getChildren().remove(f);  
                  }
               }
            }
         });
      return scene;
   }

}