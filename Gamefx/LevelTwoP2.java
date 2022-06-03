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

public class LevelTwoP2
{
   public static Scene createLevelTwoP2() throws FileNotFoundException
   {
      //declaring buttons as rightButt, leftButt, downButt
      ImageView rightButt = new ImageView(new Image("/Images/General/rightButt.png"));
      rightButt.setPreserveRatio(true);
      rightButt.setFitWidth(50);
      rightButt.setFitHeight(50);
      rightButt.setX(1180);
      rightButt.setY(335);
      ImageView leftButt = new ImageView(new Image("/Images/General/leftButt.png"));
      leftButt.setPreserveRatio(true);
      leftButt.setFitWidth(50);
      leftButt.setFitHeight(50);
      leftButt.setX(50);
      leftButt.setY(335);
      
      ImageView downButt = new ImageView(new Image("/Images/General/downButt.png"));
      downButt.setPreserveRatio(true);
      downButt.setFitWidth(50);
      downButt.setFitHeight(50);
      downButt.setX(320);
      downButt.setY(520);
      
      //declaring images as front, right, back, left respecitvely
      ImageView front = new ImageView(new Image("/Images/Room2_2/room2_2_front.png"));
      front.setPreserveRatio(true);
      front.setFitWidth(1280);
      front.setFitHeight(720);
      ImageView right = new ImageView(new Image("/Images/Room2_2/room2_2_right.png"));
      right.setPreserveRatio(true);
      right.setFitWidth(1280);
      right.setFitHeight(720);
      ImageView back = new ImageView(new Image("/Images/Room2_2/room2_2_back.png"));
      back.setPreserveRatio(true);
      back.setFitWidth(1280);
      back.setFitHeight(720);
      ImageView left = new ImageView (new Image("/Images/Room2_2/room2_2_left.png"));
      left.setPreserveRatio(true);
      left.setFitWidth(1280);
      left.setFitHeight(720);
      
      //other screens/objects
      ImageView safe = new ImageView(new Image("/Images/Room2_2/room2_2_safe.png"));
      safe.setPreserveRatio(true);
      safe.setFitWidth(1280);
      safe.setFitHeight(720);
      
      ImageView safeBack = new ImageView(new Image("/Images/General/leftButt.png"));
      safeBack.setPreserveRatio(true);
      safeBack.setFitWidth(50);
      safeBack.setFitHeight(50);
      safeBack.setX(50);
      safeBack.setY(50);
      
      //scenes is an arrayList with all of our rooms
      ArrayList <ImageView> scenes = new ArrayList <ImageView>();
      scenes.add(front);
      scenes.add(right);
      scenes.add(back);
      scenes.add(left);
      Group root = new Group();
      root.getChildren().add(scenes.get(0));
      root.getChildren().add(rightButt);
      root.getChildren().add(leftButt);
      Scene scene = new Scene(root, Color.WHITE);
      
      //boolean variables
      AtomicReference<Boolean> inSafe = new AtomicReference<>(false);
      
      scene.setOnMouseClicked(
            new EventHandler<MouseEvent>() {
               @Override
               public void handle(MouseEvent event) {
                  int x = (int)event.getX();
                  int y = (int)event.getY();
                  System.out.println(x);
                  System.out.println(y);
                  int index = scenes.indexOf(root.getChildren().get(0));
                  //left button click
                  if (root.getChildren().indexOf(leftButt) != -1 && x >= 50 && x <= 100 && y >= 335 && y <= 385)
                  {
                     root.getChildren().remove(0);
                     if(index == 0)
                     {
                        index = 3;
                     }
                     else
                     {
                        index--;
                     }
                     root.getChildren().add(0, scenes.get(index));
                  }
                  //right button click
                  else if (root.getChildren().indexOf(rightButt) != -1 && x >= 1180 && x <= 1230 && y >= 335 && y <= 385)
                  {
                     root.getChildren().remove(0);
                     if(index == 3)
                     {
                        index = 0;
                     }
                     else
                     {
                        index++;
                     }
                     root.getChildren().add(0, scenes.get(index));
                  }
                  else if (index == 0 && !inSafe.get() && x >= 445 && x <= 800 && y >= 335 && y <= 680)
                  {
                     root.getChildren().remove(0);
                     root.getChildren().remove(rightButt);
                     root.getChildren().remove(leftButt);
                     scenes.set(scenes.indexOf(front),safe);
                     root.getChildren().add(0,scenes.get(index));
                     root.getChildren().add(safeBack);
                     inSafe.set(true);
                  }
                  else if (index == 0 && inSafe.get() && x >= 50 && x <= 100 && y >= 50 && y <= 100)
                  {
                     root.getChildren().remove(safe);
                     root.getChildren().remove(safeBack);
                     scenes.set(scenes.indexOf(safe),front);
                     root.getChildren().add(0,front);
                     root.getChildren().add(rightButt);
                     root.getChildren().add(leftButt);
                     inSafe.set(false);
                  }
               }
            });
      scene.setOnMouseMoved(
         new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               int x = (int)event.getX();
               int y = (int)event.getY();
               if (root.getChildren().indexOf(leftButt) != -1 && x >= 50 && x <= 100 && y >= 335 && y <= 385)
               {
                  scene.setCursor(Cursor.HAND);
               }
               else if (root.getChildren().indexOf(rightButt) != -1 && x >= 1180 && x <= 1230 && y >= 335 && y <= 385)
               {
                  scene.setCursor(Cursor.HAND);
               }
               else if (root.getChildren().indexOf(safeBack) != -1 && inSafe.get() && x >= 50 && x <= 100 && y >= 50 && y <= 100)
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