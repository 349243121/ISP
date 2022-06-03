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
                  /*                  
                  //click on the crowbar to take it
                  else if (!crowbarGone.get() && index == 2 && x >= 620 && x <= 720 && y >= 440 && y <= 490)
                  {
                     crowbarGone.set(true);
                     root.getChildren().remove(crowbar);
                     root.getChildren().add(crowbar_dialogue);
                  }
                  
                  //clicked on the open vent to grab the bucket
                  else if (ventOpen.get() && index == 1 && x >= 560 && x <= 720 && y >= 230 && y <= 395)
                  {
                     root.getChildren().remove(0);
                     scenes.set(scenes.indexOf(rightOpen),rightBanana1);
                     root.getChildren().add(0,scenes.get(index));
                     root.getChildren().add(bucket_dialogue);
                     bucketGone.set(true);
                  }
                  
                  
                  //clicking on the closed vent to open it
                  else if (crowbarGone.get() && index == 1 && x >= 560 && x <= 720 && y >= 230 && y <= 395)
                  {
                     root.getChildren().remove(0);
                     scenes.set(scenes.indexOf(right),rightOpen);
                     root.getChildren().add(0,scenes.get(index));
                     ventOpen.set(true);
                  }
                  //clicked tap and filled bucket with water
                  else if (bucketGone.get() && !waterBucket.get() && index == 3 && x >= 840 && x <= 890 && y >= 350 && y <= 410)
                  {
                     waterBucket.set(true);
                     root.getChildren().add(filled_dialogue);
                  }
                  //if you click on the door after getting the key, this is where you code the thing after winning
                  else if (keyGone.get() && index == 0 && x >= 718 && x <= 972 && y >= 113 && y <= 658)
                  {
                     System.out.println("You win!");
                  }
                  //click on key after growing plant to grab key
                  else if (growPlant.get() && index == 0 && x >= 478 && x <= 502 && y >= 420 && y <= 500)
                  {
                     root.getChildren().remove(0);
                     scenes.set(scenes.indexOf(plantKey),plantNoKey);
                     root.getChildren().add(0,scenes.get(index));
                     keyGone.set(true);
                  }
                  //click on pot to grow plant, add the grab key above this line
                  else if (waterBucket.get() && index == 0 && x >= 340 && x <= 445 && y >= 600 && y <= 680)
                  {
                     root.getChildren().remove(0);
                     scenes.set(scenes.indexOf(front),plantKey);
                     root.getChildren().add(0,scenes.get(index));
                     growPlant.set(true);
                  }*/
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
               else
               {
                  scene.setCursor(Cursor.DEFAULT);
               }
            }
         });
      return scene;
            

   }

}