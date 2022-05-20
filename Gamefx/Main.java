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

public class Main extends Application {
   
   public void start (Stage stage) throws FileNotFoundException
   {
      Scene menu = createMenu();
      stage.setTitle("Going Bananas");
      Image icon = new Image("logo.png");
      stage.getIcons().add(icon);
      stage.setWidth(1280);
      stage.setHeight(720);
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
      Image startG = new Image(new FileInputStream("start_g.png"));
      ImageView a = new ImageView(start);
      ImageView b = new ImageView(instr);
      ImageView c = new ImageView(quit);
      ImageView d = new ImageView (startG);
      a.setX(80);
      a.setY(420); 
      a.setPreserveRatio(true); 
      d.setX(80);
      d.setY(420); 
      d.setPreserveRatio(true); 
      b.setX(80);
      b.setY(480); 
      b.setPreserveRatio(true); 
      c.setX(80);
      c.setY(540); 
      c.setPreserveRatio(true); 
      Group root = new Group();
      root.getChildren().add(a);
      root.getChildren().add(b);
      root.getChildren().add(c);
      Scene scene = new Scene(root, Color.WHITE);
      scene.setOnMouseMoved(new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent event) {
          int x = (int)event.getX();
          int y = (int)event.getY();
          if (x >= 90 && x <= 170 && y >= 570 && y <= 595)
            System.out.println("Quit");
          else if (x >= 90 && x <= 250 && y >= 510 && y <= 535)
            System.out.println("Instructions");
          else if (x >= 90 && x <= 195 && y >= 450 && y <= 475 && !root.getChildren().contains(d))
          {
            root.getChildren().add(d); 
          }
          else
          {
            if (root.getChildren().contains(d))
            {
               root.getChildren().remove(d); 
            }
            if (!root.getChildren().contains(b))
            {
               root.getChildren().add(b); 
            }
            if (!root.getChildren().contains(c))
            {
               root.getChildren().add(c); 
            }
          }
          }
      });
      scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent event) {
          int x = (int)event.getX();
          int y = (int)event.getY();
          if (x >= 90 && x <= 170 && y >= 570 && y <= 595)
            System.out.println("Quit");
          else if (x >= 90 && x <= 250 && y >= 510 && y <= 535)
            System.out.println("Instructions");
          else if (x >= 90 && x <= 195 && y >= 450 && y <= 475)
            System.out.println("Start");
          }
      });

      return scene;
   }
   public static void main (String [] args)
   {
      launch (args);
   }
   
}