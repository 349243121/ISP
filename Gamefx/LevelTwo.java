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
//class for level 2
public class LevelTwo
{
   public static Scene createLevelTwo() throws FileNotFoundException
   {
      //declaring buttons as rightButt, leftButt, downButt
      ImageView rightButt = new ImageView(new Image("/Images/General/rightButt.png"));
      rightButt.setPreserveRatio(true);
      rightButt.setFitWidth(50);
      rightButt.setFitHeight(50);
      rightButt.setX(1180);
      rightButt.setY(335);
      //balls
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
      ImageView front = new ImageView(new Image("/Images/Room2/room2_1_front.png"));
      front.setPreserveRatio(true);
      front.setFitWidth(1280);
      front.setFitHeight(720);
      ImageView right = new ImageView(new Image("/Images/Room2/room2_1_right_closed.png"));
      right.setPreserveRatio(true);
      right.setFitWidth(1280);
      right.setFitHeight(720);
      ImageView back = new ImageView(new Image("/Images/Room2/room2_1_back.png"));
      back.setPreserveRatio(true);
      back.setFitWidth(1280);
      back.setFitHeight(720);
      ImageView left = new ImageView (new Image("/Images/Room2/room2_1_left.png"));
      left.setPreserveRatio(true);
      left.setFitWidth(1280);
      left.setFitHeight(720);

      //other screens/objects
      ImageView crowbar = new ImageView(new Image("/Images/Room2/room2_1_crowbar.png"));
      crowbar.setPreserveRatio(true);
      crowbar.setFitWidth(1280);
      crowbar.setFitHeight(720);
      
      ImageView rightOpen = new ImageView(new Image("/Images/Room2/room2_1_right_open.png"));
      rightOpen.setPreserveRatio(true);
      rightOpen.setFitWidth(1280);
      rightOpen.setFitHeight(720);
      
      ImageView rightBanana1 = new ImageView(new Image("/Images/Room2/room2_1_right_banana1.png"));
      rightBanana1.setPreserveRatio(true);
      rightBanana1.setFitWidth(1280);
      rightBanana1.setFitHeight(720);
      
      ImageView rightBanana2 = new ImageView(new Image("/Images/Room2/room2_1_right_banana2.png"));
      rightBanana2.setPreserveRatio(true);
      rightBanana2.setFitWidth(1280);
      rightBanana2.setFitHeight(720);
      
      ImageView plantKey = new ImageView(new Image("/Images/Room2/room2_1_front_plantKey.png"));
      plantKey.setPreserveRatio(true);
      plantKey.setFitWidth(1280);
      plantKey.setFitHeight(720);
      
      ImageView plantNoKey = new ImageView(new Image("/Images/Room2/room2_1_front_plantNoKey.png"));
      plantNoKey.setPreserveRatio(true);
      plantNoKey.setFitWidth(1280);
      plantNoKey.setFitHeight(720);
      
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
      AtomicReference<Boolean> crowbarGone = new AtomicReference<>(false);
      AtomicReference<Boolean> ventOpen = new AtomicReference<>(false);
      AtomicReference<Boolean> bucketGone = new AtomicReference<>(false);
      
      AtomicReference<Boolean> waterBucket = new AtomicReference<>(false);
      
      AtomicReference<Boolean> growPlant = new AtomicReference<>(false);
      AtomicReference<Boolean> keyGone = new AtomicReference<>(false);
      
      scene.setOnMouseClicked(
            new EventHandler<MouseEvent>() {
               @Override
               public void handle(MouseEvent event) {
                  int x = (int)event.getX();
                  int y = (int)event.getY();
                  //System.out.println(x);
                  //System.out.println(y);
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
                     if (index == 2 && !crowbarGone.get()){
                        root.getChildren().add(crowbar);
                     }
                     else if (root.getChildren().indexOf(crowbar) != -1)
                        root.getChildren().remove(crowbar);
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
                     if (index == 2 && !crowbarGone.get()){
                        root.getChildren().add(crowbar);
                     }
                     else if (root.getChildren().indexOf(crowbar) != -1)
                        root.getChildren().remove(crowbar);
                  }
                  //click on the crowbar to take it
                  else if (!crowbarGone.get() && index == 2 && x >= 620 && x <= 720 && y >= 440 && y <= 490)
                  {
                     crowbarGone.set(true);
                     root.getChildren().remove(crowbar);
                  }
                  
                  //clicked on the open vent to grab the bucket
                  else if (ventOpen.get() && index == 1 && x >= 560 && x <= 720 && y >= 230 && y <= 395)
                  {
                     root.getChildren().remove(0);
                     scenes.set(scenes.indexOf(rightOpen),rightBanana1);
                     root.getChildren().add(0,scenes.get(index));
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
                  else if (bucketGone.get() && index == 3 && x >= 765 && x <= 1055 && y >= 380 && y <= 455)
                  {
                     waterBucket.set(true);
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
               else
               {
                  scene.setCursor(Cursor.DEFAULT);
               }
            }
         });
      return scene;
            
   }
}