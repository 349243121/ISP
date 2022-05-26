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

public class LevelOne
{
   
   public static Scene createLevelOne() throws FileNotFoundException
   {
      ImageView rightButt = new ImageView(new Image("/Images/General/rightButt.png"));
      rightButt.setPreserveRatio(true);
      rightButt.setFitWidth(50);
      rightButt.setFitHeight(50);
      rightButt.setX(1180);
      rightButt.setY(335);
      //penis
      ImageView leftButt = new ImageView(new Image("/Images/General/leftButt.png"));
      leftButt.setPreserveRatio(true);
      leftButt.setFitWidth(50);
      leftButt.setFitHeight(50);
      leftButt.setX(50);
      leftButt.setY(335);
      
      
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
      ImageView key = new ImageView(new Image("/Images/Room1/room1_keyFar.png"));
      key.setPreserveRatio(true);
      key.setFitWidth(1280);
      key.setFitHeight(720);
      ImageView mc1 = new ImageView(new Image("/Images/Room1/Dialogue/MC1.png"));
      mc1.setPreserveRatio(true);
      mc1.setFitWidth(1280);
      mc1.setFitHeight(720);
      ImageView ba1 = new ImageView(new Image("/Images/Room1/Dialogue/BA1.png"));
      ba1.setPreserveRatio(true);
      ba1.setFitWidth(1280);
      ba1.setFitHeight(720);
      ImageView keyD = new ImageView(new Image("/Images/Room1/Dialogue/key.png"));
      keyD.setPreserveRatio(true);
      keyD.setFitWidth(1280);
      keyD.setFitHeight(720);

      ArrayList <ImageView> scenes = new ArrayList <ImageView>();
      scenes.add(front);
      scenes.add(right);
      scenes.add(back);
      scenes.add(left);
      Group root = new Group();
      root.getChildren().add(scenes.get(0));
      root.getChildren().add(mc1);
      Scene scene = new Scene(root, Color.WHITE);
      AtomicReference<Boolean> keyGone = new AtomicReference<>(false);
      scene.setOnMouseClicked(
            new EventHandler<MouseEvent>() {
               @Override
               public void handle(MouseEvent event) {
                  int x = (int)event.getX();
                  int y = (int)event.getY();
                  System.out.println(x);
                  System.out.println(y);
                  int index = scenes.indexOf(root.getChildren().get(0));
                  if (x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                  {
                     if (root.getChildren().indexOf(mc1) != -1)
                     {
                        root.getChildren().remove(mc1);
                        root.getChildren().add(rightButt);
                        root.getChildren().add(leftButt);
                     }
                     if (root.getChildren().indexOf(keyD) != -1)
                     {
                        root.getChildren().remove(keyD);
                     }

                  }
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
                     if (index == 2 && !keyGone.get()){
                        root.getChildren().add(key);
                     }
                     else if (root.getChildren().indexOf(key) != -1)
                        root.getChildren().remove(key);

                  }
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
                     if (index == 2 && !keyGone.get()){
                        root.getChildren().add(key);
                        }
                     else if (root.getChildren().indexOf(key) != -1)
                        root.getChildren().remove(key);
                  }
                  else if (!keyGone.get() && index == 2 && x >= 616 && x <= 689 && y >= 487 && y <= 510)
                  {
                     keyGone.set(true);
                     root.getChildren().remove(key);
                     root.getChildren().add(keyD);
                  }
               }
            });
      scene.setOnMouseMoved(
         new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               int x = (int)event.getX();
               int y = (int)event.getY();
               if (x >= 30 && x <= 1245 && y >= 440 && y <= 630)
               {
                  if (root.getChildren().indexOf(mc1) != -1)
                  {
                     scene.setCursor(Cursor.HAND);
                  }
                  if (root.getChildren().indexOf(keyD) != -1)
                  {
                     scene.setCursor(Cursor.HAND);
                  }
               }
               else if (root.getChildren().indexOf(leftButt) != -1 && x >= 50 && x <= 100 && y >= 335 && y <= 385)
               {
                  scene.setCursor(Cursor.HAND);
               }
               else if (root.getChildren().indexOf(rightButt) != -1 && x >= 1180 && x <= 1230 && y >= 335 && y <= 385)
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