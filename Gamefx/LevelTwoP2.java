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
      AtomicReference<Boolean> safeOpen = new AtomicReference<>(false);
      AtomicReference<String> code = new AtomicReference<>("");
      
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
                     System.out.println(code.get());
                     if(code.get().length() == 4)
                     {

                        if(code.get() == "5261")
                        {
                           System.out.println("Thats the right code");
                           safeOpen.set(true);
                        }
                        else
                        {
                           //add the wrong code dialogue here
                           System.out.println("Wrong Code");
                           code.set("");
                        }
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