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
      int currentRoomIndex = 0;
      scene.setOnMouseClicked(
            new EventHandler<MouseEvent>() {
               @Override
               public void handle(MouseEvent event) {
                  int x = (int)event.getX();
                  int y = (int)event.getY();
                  if(x >= 50 && x <= 100 && y >= 335 && y <= 385)
                  {
                     int index = scenes.indexOf(root.getChildren().get(0));
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
                  else if (x >= 1180 && x <= 1230 && y >= 335 && y <= 385)
                  {
                     int index = scenes.indexOf(root.getChildren().get(0));
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

               }
            });
      scene.setOnMouseMoved(
         new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               int x = (int)event.getX();
               int y = (int)event.getY();
               if(x >= 50 && x <= 100 && y >= 335 && y <= 385)
               {
                  scene.setCursor(Cursor.HAND);
               }
               else if (x >= 1180 && x <= 1230 && y >= 335 && y <= 385)
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