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

/**
 * This is the levelTwoP2 class of the game.
 *
 * <p>
 * Version 1 - 2 hours
 * <br>
 * Implemented the structure and left-right buttons.
 * </p>
 *
 * @author Leo Liu
 * @version 01.00.00
 */

public class LevelTwoP2
{
   private static AtomicReference <Boolean> won = new AtomicReference<>(false);
   
   public static Boolean getWin()
   {
      return won.get();
   }
   /**
    * This is the createLevelTwoP2 method of the levelTwoP2 class. It will initalize the scene and add elements to the group root, which will be used to initalize the scene. 
    * It will also handle any user input (click/hover).
    * @return The scene that gets created.
    * @throws FileNotFoundException To ignore file not found exception.
    */
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
      
      ImageView frontBanana1 = new ImageView(new Image("/Images/Room2_2/room2_2_front_banana1.png"));
      frontBanana1.setPreserveRatio(true);
      frontBanana1.setFitWidth(1280);
      frontBanana1.setFitHeight(720);
      
      ImageView frontBanana2 = new ImageView(new Image("/Images/Room2_2/room2_2_front_banana2.png"));
      frontBanana2.setPreserveRatio(true);
      frontBanana2.setFitWidth(1280);
      frontBanana2.setFitHeight(720);
      
      ImageView correctKey = new ImageView(new Image("/Images/Room2_2/Dialogue/correctKey.png"));
      correctKey.setPreserveRatio(true);
      correctKey.setFitWidth(1280);
      correctKey.setFitHeight(720);
      
      ImageView wrongKey = new ImageView(new Image("/Images/Room2_2/Dialogue/wrongKey.png"));
      wrongKey.setPreserveRatio(true);
      wrongKey.setFitWidth(1280);
      wrongKey.setFitHeight(720);
      
      ImageView ba1 = new ImageView(new Image("/Images/Room2_2/Dialogue/BA1.png"));
      ba1.setPreserveRatio(true);
      ba1.setFitWidth(1280);
      ba1.setFitHeight(720);
      
      ImageView ba2 = new ImageView(new Image("/Images/Room2_2/Dialogue/BA2.png"));
      ba2.setPreserveRatio(true);
      ba2.setFitWidth(1280);
      ba2.setFitHeight(720);
      
      ImageView ba3 = new ImageView(new Image("/Images/Room2_2/Dialogue/BA3.png"));
      ba3.setPreserveRatio(true);
      ba3.setFitWidth(1280);
      ba3.setFitHeight(720);
      
      ImageView ba4 = new ImageView(new Image("/Images/Room2_2/Dialogue/BA4.png"));
      ba4.setPreserveRatio(true);
      ba4.setFitWidth(1280);
      ba4.setFitHeight(720);
      
      ImageView ba5 = new ImageView(new Image("/Images/Room2_2/Dialogue/BA5.png"));
      ba5.setPreserveRatio(true);
      ba5.setFitWidth(1280);
      ba5.setFitHeight(720);
      
      ImageView ba6 = new ImageView(new Image("/Images/Room2_2/Dialogue/BA6.png"));
      ba6.setPreserveRatio(true);
      ba6.setFitWidth(1280);
      ba6.setFitHeight(720);
      
      ImageView ba7 = new ImageView(new Image("/Images/Room2_2/Dialogue/BA7.png"));
      ba7.setPreserveRatio(true);
      ba7.setFitWidth(1280);
      ba7.setFitHeight(720);
      
      ImageView ba8 = new ImageView(new Image("/Images/Room2_2/Dialogue/BA8.png"));
      ba8.setPreserveRatio(true);
      ba8.setFitWidth(1280);
      ba8.setFitHeight(720);
      
      ImageView panic1 = new ImageView(new Image("/Images/Room2_2/Panic/room2_2_panic1.png"));
      panic1.setPreserveRatio(true);
      panic1.setFitWidth(1280);
      panic1.setFitHeight(720);
      
      ImageView panic2 = new ImageView(new Image("/Images/Room2_2/Panic/room2_2_panic2.png"));
      panic2.setPreserveRatio(true);
      panic2.setFitWidth(1280);
      panic2.setFitHeight(720);
      
      ImageView panic3 = new ImageView(new Image("/Images/Room2_2/Panic/room2_2_panic3.png"));
      panic3.setPreserveRatio(true);
      panic3.setFitWidth(1280);
      panic3.setFitHeight(720);
      
      ImageView panic4 = new ImageView(new Image("/Images/Room2_2/Panic/room2_2_panic4.png"));
      panic4.setPreserveRatio(true);
      panic4.setFitWidth(1280);
      panic4.setFitHeight(720);
      
      ImageView panic5 = new ImageView(new Image("/Images/Room2_2/Panic/room2_2_panic5.png"));
      panic5.setPreserveRatio(true);
      panic5.setFitWidth(1280);
      panic5.setFitHeight(720);
      
      ImageView beaten = new ImageView(new Image("/Images/Room2_2/Dialogue/beaten.png"));
      beaten.setPreserveRatio(true);
      beaten.setFitWidth(1280);
      beaten.setFitHeight(720);
      
      ImageView objective = new ImageView(new Image("/Images/Room2/objective-2.png"));
      objective.setPreserveRatio(true);
      objective.setFitWidth(1280);
      objective.setFitHeight(720);
      
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
      root.getChildren().add(objective);
      Scene scene = new Scene(root, Color.WHITE);
      
      //boolean variables
      AtomicReference<Boolean> inSafe = new AtomicReference<>(false);
      AtomicReference<Boolean> safeOpen = new AtomicReference<>(false);
      AtomicReference<String> code = new AtomicReference<>("");
      AtomicReference<Boolean> inDialogue = new AtomicReference<>(false);
      
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
                  else if (index == 0 && root.getChildren().indexOf(correctKey) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                  {
                     root.getChildren().remove(correctKey);
                     root.getChildren().remove(objective);
                     root.getChildren().add(ba1);
                     inDialogue.set(true);
                  }
                  else if (root.getChildren().indexOf(ba1) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                  {
                     root.getChildren().remove(ba1);
                     root.getChildren().set(root.getChildren().indexOf(frontBanana1), frontBanana2);
                     root.getChildren().add(ba2);
                  }
                  else if (root.getChildren().indexOf(ba2) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                  {
                     root.getChildren().remove(ba2);
                     root.getChildren().add(ba3);
                     //root.getChildren().set(root.getChildren().indexOf(frontBanana1), frontBanana2);
                  }
                  else if (root.getChildren().indexOf(ba3) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                  {
                     root.getChildren().remove(ba3);
                     root.getChildren().set(root.getChildren().indexOf(frontBanana2), panic1);
                     root.getChildren().add(ba4);
                  }
                  else if (root.getChildren().indexOf(ba4) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                  {
                     root.getChildren().remove(ba4);
                     root.getChildren().set(root.getChildren().indexOf(panic1), panic2);
                     root.getChildren().add(ba5);
                  }
                  else if (root.getChildren().indexOf(ba5) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                  {
                     root.getChildren().remove(ba5);
                     root.getChildren().set(root.getChildren().indexOf(panic2), panic3);
                     root.getChildren().add(ba6);
                  }
                  else if (root.getChildren().indexOf(ba6) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                  {
                     root.getChildren().remove(ba6);
                     root.getChildren().set(root.getChildren().indexOf(panic3), panic4);
                     root.getChildren().add(ba7);
                  }
                  else if (root.getChildren().indexOf(ba7) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                  {
                     root.getChildren().remove(ba7);
                     root.getChildren().set(root.getChildren().indexOf(panic4), panic5);
                     root.getChildren().add(ba8);
                     
                  }
                  else if (root.getChildren().indexOf(ba8) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                  {
                     root.getChildren().remove(ba8);
                     root.getChildren().add(beaten);
                     inDialogue.set(false);
                     won.set(true);
                  }
                  else if (index == 0 && root.getChildren().indexOf(correctKey) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                  {
                     root.getChildren().remove(correctKey);
                     inDialogue.set(true);
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
                
                  else if (index == 0 && inSafe.get() && !safeOpen.get())
                  {
                     if (x >= 50 && x <= 100 && y >= 50 && y <= 100)
                     {
                        root.getChildren().remove(safe);
                        root.getChildren().remove(safeBack);
                        scenes.set(scenes.indexOf(safe),front);
                        root.getChildren().add(0,front);
                        root.getChildren().add(rightButt);
                        root.getChildren().add(leftButt);
                        inSafe.set(false);
                     }
                     if (root.getChildren().indexOf(wrongKey) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                     {
                        root.getChildren().remove(wrongKey);
                     }
                     if(y >= 250 && y <= 285)
                     {
                        //1
                        if(x >= 710 && x <= 760)
                        {
                           code.set(code.get() + "1");
                        }
                        //2
                        if(x >= 795 && x <= 845)
                        {
                           code.set(code.get() + "2");
                        }
                        //3
                        if(x >= 875 && x <= 925)
                        {
                           code.set(code.get() + "3");
                        }
                     }
                     if(y >= 312 && y <= 347)
                     {
                        //4
                        if(x >= 710 && x <= 760)
                        {
                           code.set(code.get() + "4");
                        }
                        //5
                        if(x >= 795 && x <= 845)
                        {
                           code.set(code.get() + "5");
                        }
                        //6
                        if(x >= 875 && x <= 925)
                        {
                           code.set(code.get() + "6");
                        }
                     }
                     if(y >= 375 && y <= 410)
                     {
                        //7
                        if(x >= 710 && x <= 760)
                        {
                           code.set(code.get() + "7");
                        }
                        //8
                        if(x >= 795 && x <= 845)
                        {
                           code.set(code.get() + "8");
                        }
                        //9
                        if(x >= 875 && x <= 925)
                        {
                           code.set(code.get() + "9");
                        }
                        
                     }
                     if(x >= 795 && x <= 845 && y >= 435 && y <= 470)
                     {
                        code.set(code.get() + "0");
                     }
                     System.out.println(code.get());
                     if(code.get().length() == 4)
                     {
                        
                        if(code.get().equals("5261"))
                        {
                           root.getChildren().remove(0);
                           scenes.set(scenes.indexOf(safe),frontBanana1);
                           root.getChildren().add(0,scenes.get(index));
                           root.getChildren().remove(safeBack);
                           //System.out.println("Thats the right code");
                           safeOpen.set(true);
                           root.getChildren().add(correctKey);
                           
                        }
                        else
                        {
                           root.getChildren().add(wrongKey);
                           //System.out.println("Wrong Code");
                           code.set("");
                        }
                     }
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
               else if (root.getChildren().indexOf(safeBack) != -1 && inSafe.get() && !safeOpen.get() && x >= 50 && x <= 100 && y >= 50 && y <= 100)
               {
                  scene.setCursor(Cursor.HAND);
               }
               else if (root.getChildren().indexOf(wrongKey) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
               {
                  scene.setCursor(Cursor.HAND);
               }
               else if (root.getChildren().indexOf(correctKey) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
               {
                  scene.setCursor(Cursor.HAND);
               }
               else if (inDialogue.get() && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
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