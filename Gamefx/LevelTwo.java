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

   private static AtomicReference<Integer> status;
   
   public static int getStatus()
   {
      return status.get();
   }
   public static Scene createLevelTwo() throws FileNotFoundException
   {
      status = new AtomicReference<>(0);
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
      
      ImageView rightEmpty = new ImageView(new Image("/Images/Room2/room2_1_right_empty.png"));
      rightEmpty.setPreserveRatio(true);
      rightEmpty.setFitWidth(1280);
      rightEmpty.setFitHeight(720);
      
      ImageView plantKey = new ImageView(new Image("/Images/Room2/room2_1_front_plantKey.png"));
      plantKey.setPreserveRatio(true);
      plantKey.setFitWidth(1280);
      plantKey.setFitHeight(720);
      
      ImageView plantNoKey = new ImageView(new Image("/Images/Room2/room2_1_front_plantNoKey.png"));
      plantNoKey.setPreserveRatio(true);
      plantNoKey.setFitWidth(1280);
      plantNoKey.setFitHeight(720);
      
      ImageView ba1 = new ImageView(new Image("/Images/Room2/Dialogue/BA1.png"));
      ba1.setPreserveRatio(true);
      ba1.setFitWidth(1280);
      ba1.setFitHeight(720);
      ImageView ba2 = new ImageView(new Image("/Images/Room2/Dialogue/BA2.png"));
      ba2.setPreserveRatio(true);
      ba2.setFitWidth(1280);
      ba2.setFitHeight(720);
      ImageView ba3 = new ImageView(new Image("/Images/Room2/Dialogue/BA3.png"));
      ba3.setPreserveRatio(true);
      ba3.setFitWidth(1280);
      ba3.setFitHeight(720);
      ImageView mc1 = new ImageView(new Image("/Images/Room2/Dialogue/MC1.png"));
      mc1.setPreserveRatio(true);
      mc1.setFitWidth(1280);
      mc1.setFitHeight(720);
      ImageView mc2 = new ImageView(new Image("/Images/Room2/Dialogue/MC2.png"));
      mc2.setPreserveRatio(true);
      mc2.setFitWidth(1280);
      mc2.setFitHeight(720);
      ImageView ba4_2_1 = new ImageView(new Image("/Images/Room2/Dialogue/BA4.2.1.png"));
      ba4_2_1.setPreserveRatio(true);
      ba4_2_1.setFitWidth(1280);
      ba4_2_1.setFitHeight(720);
      ImageView ba4_2_2 = new ImageView(new Image("/Images/Room2/Dialogue/BA4.2.2.png"));
      ba4_2_2.setPreserveRatio(true);
      ba4_2_2.setFitWidth(1280);
      ba4_2_2.setFitHeight(720);
      ImageView ba4_2_3 = new ImageView(new Image("/Images/Room2/Dialogue/BA4.2.3.png"));
      ba4_2_3.setPreserveRatio(true);
      ba4_2_3.setFitWidth(1280);
      ba4_2_3.setFitHeight(720);
      ImageView ba4_2_4 = new ImageView(new Image("/Images/Room2/Dialogue/BA4.2.4.png"));
      ba4_2_4.setPreserveRatio(true);
      ba4_2_4.setFitWidth(1280);
      ba4_2_4.setFitHeight(720);
      ImageView ba4_1_1 = new ImageView(new Image("/Images/Room2/Dialogue/BA4.1.1.png"));
      ba4_1_1.setPreserveRatio(true);
      ba4_1_1.setFitWidth(1280);
      ba4_1_1.setFitHeight(720);
      ImageView ba4_1_2 = new ImageView(new Image("/Images/Room2/Dialogue/BA4.1.2.png"));
      ba4_1_2.setPreserveRatio(true);
      ba4_1_2.setFitWidth(1280);
      ba4_1_2.setFitHeight(720);
      ImageView ba4_1_3 = new ImageView(new Image("/Images/Room2/Dialogue/BA4.1.3.png"));
      ba4_1_3.setPreserveRatio(true);
      ba4_1_3.setFitWidth(1280);
      ba4_1_3.setFitHeight(720);
      ImageView ba4_1_4 = new ImageView(new Image("/Images/Room2/Dialogue/BA4.1.4.png"));
      ba4_1_4.setPreserveRatio(true);
      ba4_1_4.setFitWidth(1280);
      ba4_1_4.setFitHeight(720);
      ImageView crowbar_dialogue = new ImageView(new Image("/Images/Room2/Dialogue/crowbar.png"));
      crowbar_dialogue.setPreserveRatio(true);
      crowbar_dialogue.setFitWidth(1280);
      crowbar_dialogue.setFitHeight(720);
      ImageView bucket_dialogue = new ImageView(new Image("/Images/Room2/Dialogue/empty_bucket.png"));
      bucket_dialogue.setPreserveRatio(true);
      bucket_dialogue.setFitWidth(1280);
      bucket_dialogue.setFitHeight(720);
      ImageView filled_dialogue = new ImageView(new Image("/Images/Room2/Dialogue/filled_bucket.png"));
      filled_dialogue.setPreserveRatio(true);
      filled_dialogue.setFitWidth(1280);
      filled_dialogue.setFitHeight(720);
      ImageView objective = new ImageView(new Image("/Images/Room2/objective.png"));
      objective.setPreserveRatio(true);
      objective.setFitWidth(1280);
      objective.setFitHeight(720);
      ImageView objective2 = new ImageView(new Image("/Images/Room2/objective-2.png"));
      objective2.setPreserveRatio(true);
      objective2.setFitWidth(1280);
      objective2.setFitHeight(720);
      ImageView end = new ImageView(new Image("/Images/Room2/Dialogue/End.png"));
      end.setPreserveRatio(true);
      end.setFitWidth(1280);
      end.setFitHeight(720);
      ImageView doorOpen = new ImageView(new Image("/Images/Room2/room2_1_front_open.png"));
      doorOpen.setPreserveRatio(true);
      doorOpen.setFitWidth(1280);
      doorOpen.setFitHeight(720);
   
      //scenes is an arrayList with all of our rooms
      ArrayList <ImageView> scenes = new ArrayList <ImageView>();
      scenes.add(front);
      scenes.add(right);
      scenes.add(back);
      scenes.add(left);
      Group root = new Group();
      root.getChildren().add(scenes.get(0));
      root.getChildren().add(mc1);
      Scene scene = new Scene(root, Color.WHITE);
      
      //boolean variables
      AtomicReference<Boolean> crowbarGone = new AtomicReference<>(false);
      AtomicReference<Boolean> ventOpen = new AtomicReference<>(false);
      AtomicReference<Boolean> bucketGone = new AtomicReference<>(false);
      AtomicReference<Boolean> waterBucket = new AtomicReference<>(false);
      AtomicReference<Boolean> growPlant = new AtomicReference<>(false);
      AtomicReference<Boolean> keyGone = new AtomicReference<>(false);
      AtomicReference<Integer> dChoice = new AtomicReference<>(-1);
   
      
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
                  if (status.get() == 1 && root.getChildren().indexOf(leftButt) != -1 && x >= 50 && x <= 100 && y >= 335 && y <= 385)
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
                  else if (status.get() == 1 && root.getChildren().indexOf(rightButt) != -1 && x >= 1180 && x <= 1230 && y >= 335 && y <= 385)
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
                  
                  //first dialogue
                  else if (root.getChildren().indexOf(mc1) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                  {
                     root.getChildren().remove(mc1);
                     root.getChildren().add(mc2);
                  }
                  
                  else if (root.getChildren().indexOf(mc2) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                  {
                     root.getChildren().remove(mc2);
                     root.getChildren().add(rightButt);
                     root.getChildren().add(leftButt);
                     root.getChildren().add(objective);
                     status.set(1);
                  }
                  
                  else if (root.getChildren().indexOf(ba1) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                  {
                     root.getChildren().remove(ba1);
                     root.getChildren().add(ba2);
                  }
                  
                  else if (root.getChildren().indexOf(ba2) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                  {
                     root.getChildren().remove(0);
                     scenes.set(scenes.indexOf(rightBanana1),rightBanana2);
                     root.getChildren().add(0,scenes.get(index));
                     root.getChildren().remove(ba2);
                     root.getChildren().add(ba3);
                  }
                  else if (root.getChildren().indexOf(ba3) != -1)
                  {
                     if (x >= 910 && x <= 1250 && y >= 250 && y <= 350){
                        dChoice.set(1);
                        root.getChildren().add(ba4_1_1);
                        root.getChildren().remove(ba3);
                     }
                     else if (x >= 910 && x <= 1250 && y >= 350 && y <= 440){
                        dChoice.set(2);
                        root.getChildren().add(ba4_2_1);
                        root.getChildren().remove(ba3);
                     }
                  }
                  else if (dChoice.get() == 2)
                  {
                     if (x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                     {
                        if (root.getChildren().indexOf(ba4_2_1) != -1)
                        {
                           root.getChildren().remove(ba4_2_1);
                           root.getChildren().add(ba4_2_2);
                        }
                        else if (root.getChildren().indexOf(ba4_2_2) != -1)
                        {
                           root.getChildren().remove(ba4_2_2);
                           root.getChildren().add(ba4_2_3);
                           status.set(-1);
                        }
                        else if (root.getChildren().indexOf(ba4_2_3) != -1)
                        {
                           root.getChildren().remove(ba4_2_3);
                           root.getChildren().add(ba4_2_4);
                        }
                     }
                  }
                  else if (dChoice.get() == 1)
                  {
                     if (x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                     {
                        if (root.getChildren().indexOf(ba4_1_1) != -1)
                        {
                           root.getChildren().remove(ba4_1_1);
                           root.getChildren().add(ba4_1_2);
                        }
                        else if (root.getChildren().indexOf(ba4_1_2) != -1)
                        {
                           root.getChildren().remove(ba4_1_2);
                           root.getChildren().add(ba4_1_3);
                        }
                        else if (root.getChildren().indexOf(ba4_1_3) != -1)
                        {
                           root.getChildren().remove(ba4_1_3);
                           root.getChildren().add(ba4_1_4);
                        }
                        else if (root.getChildren().indexOf(ba4_1_4) != -1)
                        {
                           root.getChildren().remove(ba4_1_4);
                           root.getChildren().remove(0);
                           scenes.set(scenes.indexOf(rightBanana2),rightEmpty);
                           root.getChildren().add(0,scenes.get(index));
                           root.getChildren().add(objective2);
                           status.set(1);
                           dChoice.set(-1);
                        }
                     }
                  }
                  
                  else if (root.getChildren().indexOf(crowbar_dialogue) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                  {
                     root.getChildren().remove(crowbar_dialogue);
                  }
                  
                  else if (root.getChildren().indexOf(bucket_dialogue) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                  {
                     root.getChildren().remove(bucket_dialogue);
                     root.getChildren().add(ba1);
                     root.getChildren().remove(objective);
                     status.set(2);
                  }
                  
                  else if (root.getChildren().indexOf(filled_dialogue) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                  {
                     root.getChildren().remove(filled_dialogue);
                  }
                  
                  //click on the crowbar to take it
                  else if (!crowbarGone.get() && index == 2 && x >= 620 && x <= 720 && y >= 440 && y <= 490)
                  {
                     crowbarGone.set(true);
                     root.getChildren().remove(crowbar);
                     root.getChildren().add(crowbar_dialogue);
                  }
                  
                  //clicked on the open vent to grab the bucket
                  else if (ventOpen.get() && !bucketGone.get() && index == 1 && x >= 560 && x <= 720 && y >= 230 && y <= 395)
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
                  else if (keyGone.get() && index == 0 && x >= 715 && x <= 970 && y >= 115 && y <= 660)
                  {
                     root.getChildren().set(0, doorOpen);
                     status.set(100);
                     root.getChildren().add(end);
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
               else if (status.get() == 0 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
               {
                  scene.setCursor(Cursor.HAND);
               }
               else if (status.get() == 2 && root.getChildren().indexOf(ba3) == -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
               {
                  scene.setCursor(Cursor.HAND);
               }
               else if (status.get() == 2 && root.getChildren().indexOf(ba3) != -1 && x >= 910 && x <= 1250 && y >= 250 && y <= 440)
               {
                  scene.setCursor(Cursor.HAND);
               }
               else if (root.getChildren().indexOf(crowbar_dialogue) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
               {
                  scene.setCursor(Cursor.HAND);
               }
                  
               else if (root.getChildren().indexOf(bucket_dialogue) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
               {
                  scene.setCursor(Cursor.HAND);
               }
                  
               else if (root.getChildren().indexOf(filled_dialogue) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
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