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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;

/**
 * This is the levelOne class of the game.
 *
 * <p>
 * Version 1 - 6 hours
 * <br>
 * Created the scene and added the four different backgrounds
 * <br>
 * Implemented chest and key interaction
 * <br>
 * Partially added dialogue
 * </p>
 *
 * @author Leo Liu and Ethan Zhu
 * @version 02.00.04
 */
public class LevelOne
{
   /**Variable to determine if the user has beaten this level.*/
   private static AtomicReference<Boolean> beaten;
   
   public static Boolean getWin()
   {
      return beaten.get();
   }  
   /**
    * This is the createLevelOne method of the levelOne class. It will initalize the scene and add elements to the group root, which will be used to initalize the scene. 
    * It will also handle any user input (click/hover).
    * @return The scene that gets created.
    * @throws FileNotFoundException To ignore file not found exception.
    */
   public static Scene createLevelOne() throws FileNotFoundException
   {
       beaten = new AtomicReference<>(false);
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
      ImageView downButtDoor = new ImageView(new Image("/Images/General/downButt.png"));
      downButtDoor.setPreserveRatio(true);
      downButtDoor.setFitWidth(50);
      downButtDoor.setFitHeight(50);
      downButtDoor.setX(635);
      downButtDoor.setY(520);
      
      ImageView front = new ImageView(new Image("/Images/Room1/room1_front.png"));
      front.setPreserveRatio(true);
      front.setFitWidth(1280);
      front.setFitHeight(720);
      ImageView frontOpen = new ImageView(new Image("/Images/Room1/room1_front_open.png"));
      frontOpen.setPreserveRatio(true);
      frontOpen.setFitWidth(1280);
      frontOpen.setFitHeight(720);
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
      ImageView ba2 = new ImageView(new Image("/Images/Room1/Dialogue/BA2.png"));
      ba2.setPreserveRatio(true);
      ba2.setFitWidth(1280);
      ba2.setFitHeight(720);      
      ImageView ba3 = new ImageView(new Image("/Images/Room1/Dialogue/BA3.png"));
      ba3.setPreserveRatio(true);
      ba3.setFitWidth(1280);
      ba3.setFitHeight(720); 
      ImageView ba4 = new ImageView(new Image("/Images/Room1/Dialogue/BA4.png"));
      ba4.setPreserveRatio(true);
      ba4.setFitWidth(1280);
      ba4.setFitHeight(720); 
      ImageView ba5 = new ImageView(new Image("/Images/Room1/Dialogue/BA5.png"));
      ba5.setPreserveRatio(true);
      ba5.setFitWidth(1280);
      ba5.setFitHeight(720); 
      ImageView ba6 = new ImageView(new Image("/Images/Room1/Dialogue/BA6.png"));
      ba6.setPreserveRatio(true);
      ba6.setFitWidth(1280);
      ba6.setFitHeight(720); 
      ImageView keyD = new ImageView(new Image("/Images/Room1/Dialogue/key.png"));
      keyD.setPreserveRatio(true);
      keyD.setFitWidth(1280);
      keyD.setFitHeight(720);
      ImageView topDownBanana = new ImageView(new Image("/Images/Room1/topDown_banana.png"));
      topDownBanana.setPreserveRatio(true);
      topDownBanana.setFitWidth(1280);
      topDownBanana.setFitHeight(720);
      ImageView topDown = new ImageView(new Image("/Images/Room1/topDown_banana_empty.png"));
      topDown.setPreserveRatio(true);
      topDown.setFitWidth(1280);
      topDown.setFitHeight(720);
      ImageView door = new ImageView(new Image("/Images/Room1/room1_door.png"));
      door.setPreserveRatio(true);
      door.setFitWidth(1280);
      door.setFitHeight(720);
      ImageView openDoor = new ImageView(new Image("/Images/Room1/room1_door_open.png"));
      openDoor.setPreserveRatio(true);
      openDoor.setFitWidth(1280);
      openDoor.setFitHeight(720);      
      ImageView end = new ImageView(new Image("/Images/Room1/Dialogue/end.png"));
      end.setPreserveRatio(true);
      end.setFitWidth(1280);
      end.setFitHeight(720);  
      ImageView obj1 = new ImageView(new Image("/Images/Room1/OBJ1.png"));
      obj1.setPreserveRatio(true);
      obj1.setFitWidth(1280);
      obj1.setFitHeight(720);
       
      ArrayList <ImageView> scenes = new ArrayList <ImageView>();
      scenes.add(front);
      scenes.add(right);
      scenes.add(back);
      scenes.add(left);
      ArrayList <ImageView> baDialogue = new ArrayList <ImageView>();
      baDialogue.add(ba1);
      baDialogue.add(ba2);
      baDialogue.add(ba3);
      baDialogue.add(ba4);
      baDialogue.add(ba5);
      baDialogue.add(ba6);
      Group root = new Group();
      root.getChildren().add(scenes.get(0));
      root.getChildren().add(mc1);
      Scene scene = new Scene(root, Color.WHITE);
      
      AtomicReference<Boolean> keyGone = new AtomicReference<>(false);
      AtomicReference<Boolean> chestOpen = new AtomicReference<>(false);
      AtomicReference<Integer> bananaDialogueIndex = new AtomicReference<>(0);
      
      scene.setOnMouseClicked(
            new EventHandler<MouseEvent>() {
               @Override
               public void handle(MouseEvent event) {
                  int x = (int)event.getX();
                  int y = (int)event.getY();
                  //System.out.println(x);
                  //System.out.println(y);
                  int index = scenes.indexOf(root.getChildren().get(0));
               
                  if (root.getChildren().indexOf(mc1) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                  {
                     root.getChildren().remove(mc1);
                     root.getChildren().add(rightButt);
                     root.getChildren().add(leftButt);
                     root.getChildren().add(obj1);
                  }
                  if (root.getChildren().indexOf(keyD) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                  {
                     root.getChildren().remove(keyD);
                  }
                  
                  
                  if (root.getChildren().indexOf(leftButt) != -1 && x >= 50 && x <= 100 && y >= 335 && y <= 385 && !chestOpen.get())
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
                  else if (root.getChildren().indexOf(rightButt) != -1 && x >= 1180 && x <= 1230 && y >= 335 && y <= 385 && !chestOpen.get())
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
                  else if (keyGone.get() && index == 0 && x >= 140 && x <= 520 && y >= 520 && y <= 680)
                  {
                     root.getChildren().set(root.getChildren().indexOf(front),frontOpen);
                     chestOpen.set(true);
                     root.getChildren().remove(rightButt);
                     root.getChildren().remove(leftButt);
                     root.getChildren().add(downButt);
                  }
                  else if (root.getChildren().indexOf(frontOpen) != -1 && chestOpen.get() && x >= 320 && x <= 365 && y >= 520 && y <= 560)
                  {
                     root.getChildren().remove(downButt);
                     root.getChildren().remove(obj1);
                     root.getChildren().set (0, topDownBanana);
                     root.getChildren().add(baDialogue.get(bananaDialogueIndex.get()));
                     bananaDialogueIndex.set(bananaDialogueIndex.get()+1);
                  }
                  else if (root.getChildren().indexOf(topDownBanana) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                  {
                     if (bananaDialogueIndex.get() < 6)
                     {
                        root.getChildren().remove(baDialogue.get(bananaDialogueIndex.get()-1));
                        root.getChildren().add(baDialogue.get(bananaDialogueIndex.get()));
                        bananaDialogueIndex.set(bananaDialogueIndex.get()+1);
                     }
                     else
                     {
                        root.getChildren().remove(baDialogue.get(bananaDialogueIndex.get()-1));
                        root.getChildren().remove(topDownBanana);
                        root.getChildren().add(topDown);
                        root.getChildren().add(downButtDoor);
                        
                     }
                  }
                  else if (root.getChildren().indexOf(topDown) != -1 && x >= 640 && x <= 680 && y >= 520 && y <= 560)
                  {
                     root.getChildren().remove(downButtDoor);
                     root.getChildren().set (0, door);
                  }
                  else if (root.getChildren().indexOf(door) != -1 && x >= 700 && x <= 965 && y >= 110 && y <= 630)
                  {  
                     root.getChildren().set(0, openDoor);
                     beaten.set(true);
                     root.getChildren().add(end);
                  }
               }
            });
      scene.setOnMouseMoved(
         new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               int x = (int)event.getX();
               int y = (int)event.getY();
               if (x >= 30 && x <= 1245 && y >= 440 && y <= 630 && root.getChildren().indexOf(mc1) != -1)
               {
                  scene.setCursor(Cursor.HAND);
               }
               else if (x >= 30 && x <= 1245 && y >= 440 && y <= 630 && root.getChildren().indexOf(keyD) != -1)
               {
                  scene.setCursor(Cursor.HAND);
               }
               else if (x >= 30 && x <= 1245 && y >= 440 && y <= 630 && root.getChildren().indexOf(topDownBanana) != -1)
               {
                  scene.setCursor(Cursor.HAND);
               }
               else if (root.getChildren().indexOf(leftButt) != -1 && x >= 50 && x <= 100 && y >= 335 && y <= 385 && !chestOpen.get())
               {
                  scene.setCursor(Cursor.HAND);
               }
               else if (root.getChildren().indexOf(rightButt) != -1 && x >= 1180 && x <= 1230 && y >= 335 && y <= 385 && !chestOpen.get())
               {
                  scene.setCursor(Cursor.HAND);
               }
               else if (root.getChildren().indexOf(frontOpen) != -1 && chestOpen.get() && x >= 320 && x <= 365 && y >= 520 && y <= 560)
               {
                  scene.setCursor(Cursor.HAND);
               }
               else if (root.getChildren().indexOf(topDown) != -1 && x >= 640 && x <= 680 && y >= 520 && y <= 560)
               {
                  scene.setCursor(Cursor.HAND);
               }
               else
               {
                  scene.setCursor(Cursor.DEFAULT);
               }            
            }
         });
         
      scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.SPACE && getWin())
                {
                  for (int i = 0; i < root.getChildren().size(); i++)
                  {
                     root.getChildren().remove(i);
                  }
                  beaten.set(false);
                  keyGone.set(false);
                  chestOpen.set(false);
                  bananaDialogueIndex.set(0);
                  root.getChildren().add(scenes.get(0));
                  root.getChildren().add(mc1);
                }
            }
        });
           
      return scene;
   }
}