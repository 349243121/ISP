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
 * This is the levelThree class of the game.
 *
 * <p>
 * Version 1 - 6 hours
 * <br>
 * Finished the scene and added the dialogue
 * </p>
 *
 * @author Ethan Zhu
 * @version 01.00.00
 */

public class LevelThree
{
   /*
    * Variable to store the current status of the game, 
    * status = 0 = default
    * status = 1 = lostBeginning
    * status = 2 = lostEnd
    * status = 3 = won
    */
   private static AtomicReference <Integer> status = new AtomicReference<>(0);
   /*
    * Variable that stores whether or not the user has lost
    * lost = 0 = undetermined
    * lost = 1 = lost
    * lost = -1 = won
    */
   private static AtomicReference <Integer> lost = new AtomicReference<>(0);
   /**Variable to store how many personality questions the user got right*/
   private static AtomicReference <Integer> amtRight = new AtomicReference<>(0);
   
   /**
    * Method to return if the user has won or not
    * @return An int that represents the win/lose status
    */
   public static int getWin()
   {
      return lost.get();
   }
   
   /**
    * This is the createLevelThree method of the levelThree class. It will initalize the scene and add elements to the group root, which will be used to initalize the scene. 
    * It will also handle any user input (click/hover).
    * @return The scene that gets created.
    * @throws FileNotFoundException To ignore file not found exception.
    */
   public static Scene createLevelThree() throws FileNotFoundException
   {
   
      //Background Images
      ImageView voidRoom = new ImageView(new Image("/Images/Room3/room3_void.png"));
      voidRoom.setPreserveRatio(true);
      voidRoom.setFitWidth(1280);
      voidRoom.setFitHeight(720);
      
      ImageView ps5 = new ImageView(new Image("/Images/Room3/room3_ps5.png"));
      ps5.setPreserveRatio(true);
      ps5.setFitWidth(1280);
      ps5.setFitHeight(720);
      
      ImageView painting = new ImageView(new Image("/Images/Room3/room3_painting.png"));
      painting.setPreserveRatio(true);
      painting.setFitWidth(1280);
      painting.setFitHeight(720);
      
      ImageView guitar = new ImageView(new Image("/Images/Room3/room3_guitar.png"));
      guitar.setPreserveRatio(true);
      guitar.setFitWidth(1280);
      guitar.setFitHeight(720);
      
      ImageView happy = new ImageView(new Image("/Images/Room3/room3_happy.png"));
      happy.setPreserveRatio(true);
      happy.setFitWidth(1280);
      happy.setFitHeight(720);
      
      //Dialogue
      ImageView ba1 = new ImageView(new Image("/Images/Room3/Dialogue/BA1.png"));
      ba1.setPreserveRatio(true);
      ba1.setFitWidth(1280);
      ba1.setFitHeight(720);
   
      ImageView ba2 = new ImageView(new Image("/Images/Room3/Dialogue/BA2.png"));
      ba2.setPreserveRatio(true);
      ba2.setFitWidth(1280);
      ba2.setFitHeight(720);
   
      ImageView ba3 = new ImageView(new Image("/Images/Room3/Dialogue/BA3.png"));
      ba3.setPreserveRatio(true);
      ba3.setFitWidth(1280);
      ba3.setFitHeight(720);
      
      ImageView ba3C = new ImageView(new Image("/Images/Room3/Dialogue/BA3_Choices.png"));
      ba3C.setPreserveRatio(true);
      ba3C.setFitWidth(1280);
      ba3C.setFitHeight(720);
      
      ImageView ba4 = new ImageView(new Image("/Images/Room3/Dialogue/BA4.png"));
      ba4.setPreserveRatio(true);
      ba4.setFitWidth(1280);
      ba4.setFitHeight(720);
   
      ImageView ba4_1_1 = new ImageView(new Image("/Images/Room3/Dialogue/BA4-1-1.png"));
      ba4_1_1.setPreserveRatio(true);
      ba4_1_1.setFitWidth(1280);
      ba4_1_1.setFitHeight(720);
      
      ImageView ba4_1_2 = new ImageView(new Image("/Images/Room3/Dialogue/BA4-1-2.png"));
      ba4_1_2.setPreserveRatio(true);
      ba4_1_2.setFitWidth(1280);
      ba4_1_2.setFitHeight(720);
      
      ImageView ba5 = new ImageView(new Image("/Images/Room3/Dialogue/BA5.png"));
      ba5.setPreserveRatio(true);
      ba5.setFitWidth(1280);
      ba5.setFitHeight(720);
      
      ImageView ba6 = new ImageView(new Image("/Images/Room3/Dialogue/BA6.png"));
      ba6.setPreserveRatio(true);
      ba6.setFitWidth(1280);
      ba6.setFitHeight(720);
      
      ImageView ba6C = new ImageView(new Image("/Images/Room3/Dialogue/BA6_Choices.png"));
      ba6C.setPreserveRatio(true);
      ba6C.setFitWidth(1280);
      ba6C.setFitHeight(720);
      
      ImageView ba7_1 = new ImageView(new Image("/Images/Room3/Dialogue/BA7-1.png"));
      ba7_1.setPreserveRatio(true);
      ba7_1.setFitWidth(1280);
      ba7_1.setFitHeight(720);
      
      ImageView ba7_2 = new ImageView(new Image("/Images/Room3/Dialogue/BA7-2.png"));
      ba7_2.setPreserveRatio(true);
      ba7_2.setFitWidth(1280);
      ba7_2.setFitHeight(720);
      
      ImageView ba8C = new ImageView(new Image("/Images/Room3/Dialogue/BA8_Choices.png"));
      ba8C.setPreserveRatio(true);
      ba8C.setFitWidth(1280);
      ba8C.setFitHeight(720);
      
      ImageView ba8_1 = new ImageView(new Image("/Images/Room3/Dialogue/BA8-1.png"));
      ba8_1.setPreserveRatio(true);
      ba8_1.setFitWidth(1280);
      ba8_1.setFitHeight(720);
      
      ImageView ba8_2 = new ImageView(new Image("/Images/Room3/Dialogue/BA8-2.png"));
      ba8_2.setPreserveRatio(true);
      ba8_2.setFitWidth(1280);
      ba8_2.setFitHeight(720);
      
      ImageView ba9C = new ImageView(new Image("/Images/Room3/Dialogue/BA9_Choices.png"));
      ba9C.setPreserveRatio(true);
      ba9C.setFitWidth(1280);
      ba9C.setFitHeight(720);
      
      ImageView ba9_1 = new ImageView(new Image("/Images/Room3/Dialogue/BA9-1.png"));
      ba9_1.setPreserveRatio(true);
      ba9_1.setFitWidth(1280);
      ba9_1.setFitHeight(720);
      
      ImageView ba9_2 = new ImageView(new Image("/Images/Room3/Dialogue/BA9-2.png"));
      ba9_2.setPreserveRatio(true);
      ba9_2.setFitWidth(1280);
      ba9_2.setFitHeight(720);
      
      ImageView ba10_1_1 = new ImageView(new Image("/Images/Room3/Dialogue/BA10-1-1.png"));
      ba10_1_1.setPreserveRatio(true);
      ba10_1_1.setFitWidth(1280);
      ba10_1_1.setFitHeight(720);
      
      ImageView ba10_1_2 = new ImageView(new Image("/Images/Room3/Dialogue/BA10-1-2.png"));
      ba10_1_2.setPreserveRatio(true);
      ba10_1_2.setFitWidth(1280);
      ba10_1_2.setFitHeight(720);
      
      ImageView ba10_1_3 = new ImageView(new Image("/Images/Room3/Dialogue/BA10-1-3.png"));
      ba10_1_3.setPreserveRatio(true);
      ba10_1_3.setFitWidth(1280);
      ba10_1_3.setFitHeight(720);
      
      ImageView ba10_1_4 = new ImageView(new Image("/Images/Room3/Dialogue/BA10-1-4.png"));
      ba10_1_4.setPreserveRatio(true);
      ba10_1_4.setFitWidth(1280);
      ba10_1_4.setFitHeight(720);
      
      ImageView ba10_2_2 = new ImageView(new Image("/Images/Room3/Dialogue/BA10-2-2.png"));
      ba10_2_2.setPreserveRatio(true);
      ba10_2_2.setFitWidth(1280);
      ba10_2_2.setFitHeight(720);
      
      ImageView ba10_2_3 = new ImageView(new Image("/Images/Room3/Dialogue/BA10-2-3.png"));
      ba10_2_3.setPreserveRatio(true);
      ba10_2_3.setFitWidth(1280);
      ba10_2_3.setFitHeight(720);
      
      ImageView ba10_2_4 = new ImageView(new Image("/Images/Room3/Dialogue/BA10-2-4.png"));
      ba10_2_4.setPreserveRatio(true);
      ba10_2_4.setFitWidth(1280);
      ba10_2_4.setFitHeight(720);
      
      ImageView ba10_2_5 = new ImageView(new Image("/Images/Room3/Dialogue/BA10-2-5.png"));
      ba10_2_5.setPreserveRatio(true);
      ba10_2_5.setFitWidth(1280);
      ba10_2_5.setFitHeight(720);
      
      ImageView ba10_2_1 = new ImageView(new Image("/Images/Room3/Dialogue/BA10-2-1.png"));
      ba10_2_1.setPreserveRatio(true);
      ba10_2_1.setFitWidth(1280);
      ba10_2_1.setFitHeight(720);
      
      ImageView endLost = new ImageView(new Image("/Images/General/Ending.png"));
      endLost.setPreserveRatio(true);
      endLost.setFitWidth(1280);
      endLost.setFitHeight(720);
      
      ImageView ps5End = new ImageView(new Image("/Images/Room3/room3_ps5End.png"));
      ps5End.setPreserveRatio(true);
      ps5End.setFitWidth(1280);
      ps5End.setFitHeight(720);
      
      ImageView paintingEnd = new ImageView(new Image("/Images/Room3/room3_paintingEnd.png"));
      paintingEnd.setPreserveRatio(true);
      paintingEnd.setFitWidth(1280);
      paintingEnd.setFitHeight(720);
      
      ImageView badEnd1 = new ImageView(new Image("/Images/Room3/room3_badEnd1.png"));
      badEnd1.setPreserveRatio(true);
      badEnd1.setFitWidth(1280);
      badEnd1.setFitHeight(720);
      
      ImageView badEnd2 = new ImageView(new Image("/Images/Room3/room3_badEnd2.png"));
      badEnd2.setPreserveRatio(true);
      badEnd2.setFitWidth(1280);
      badEnd2.setFitHeight(720);
      
      ImageView badEnd3 = new ImageView(new Image("/Images/Room3/room3_badEnd3.png"));
      badEnd3.setPreserveRatio(true);
      badEnd3.setFitWidth(1280);
      badEnd3.setFitHeight(720);
      
      ImageView goodEnd = new ImageView(new Image("/Images/Room3/room3_happy.png"));
      goodEnd.setPreserveRatio(true);
      goodEnd.setFitWidth(1280);
      goodEnd.setFitHeight(720);
      
      Group root = new Group();
      root.getChildren().add(voidRoom);
      root.getChildren().add(ba1);
      Scene scene = new Scene(root, Color.WHITE);
   
      
      scene.setOnMouseClicked(
            new EventHandler<MouseEvent>() {
               @Override
               public void handle(MouseEvent event) {
                  int x = (int)event.getX();
                  int y = (int)event.getY();
                  //For normal dialogue
                  if (status.get() == 1)
                  {
                     if (root.getChildren().indexOf(ba4_1_1) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                     {
                        root.getChildren().remove(ba4_1_1);
                        root.getChildren().add(ba4_1_2);
                     }  
                     else if (root.getChildren().indexOf(ba4_1_2) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                     {
                        root.getChildren().remove(ba4_1_2);
                        root.getChildren().add(endLost);
                        lost.set(1);
                     }  
                  }
                  if (status.get() == 3)
                  {
                     if (amtRight.get() == 2 && root.getChildren().indexOf(ps5) != -1)
                     {
                        root.getChildren().remove(ps5);
                        root.getChildren().add(ps5End);
                     }
                     else if (amtRight.get() == 2 && root.getChildren().indexOf(painting) != -1)
                     {
                        root.getChildren().remove(painting);
                        root.getChildren().add(paintingEnd);
                     }
                     else if (amtRight.get() == 3)
                     {
                        root.getChildren().remove(painting);
                        root.getChildren().remove(ps5);
                        root.getChildren().remove(guitar);
                        root.getChildren().add(goodEnd);
                     }
                     if (root.getChildren().indexOf(ba9_1) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                     {
                        root.getChildren().remove(ba9_1);
                        root.getChildren().add(ba10_1_1);
                     }
                     else if (root.getChildren().indexOf(ba10_1_1) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                     {
                        root.getChildren().remove(ba10_1_1);
                        root.getChildren().add(ba10_1_2);
                     }
                     else if (root.getChildren().indexOf(ba10_1_2) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                     {
                        root.getChildren().remove(ba10_1_2);
                        root.getChildren().add(ba10_1_3);
                     }
                     else if (root.getChildren().indexOf(ba10_1_3) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                     {
                        root.getChildren().remove(ba10_1_3);
                        root.getChildren().add(ba10_1_4);
                     }
                     else if (root.getChildren().indexOf(ba10_1_4) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                     {
                        root.getChildren().remove(ba10_1_4);
                        root.getChildren().add(endLost);
                        lost.set(1);
                     }
                  }
                  if (status.get() == 2)
                  {
                     if (root.getChildren().indexOf(ba9_1) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                     {
                        root.getChildren().remove(ba9_1);
                        root.getChildren().add(ba10_2_1);
                        if (root.getChildren().indexOf(ps5) != -1)
                           root.getChildren().remove(ps5);
                        if (root.getChildren().indexOf(painting) != -1)
                           root.getChildren().remove(painting);
                        if (root.getChildren().indexOf(guitar) != -1)
                           root.getChildren().remove(guitar);
                     }
                     else if (root.getChildren().indexOf(ba9_2) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                     {
                        root.getChildren().remove(ba9_2);
                        root.getChildren().add(ba10_2_1);
                        if (root.getChildren().indexOf(ps5) != -1)
                           root.getChildren().remove(ps5);
                        if (root.getChildren().indexOf(painting) != -1)
                           root.getChildren().remove(painting);
                        if (root.getChildren().indexOf(guitar) != -1)
                           root.getChildren().remove(guitar);
                     }
                     else if (root.getChildren().indexOf(ba10_2_1) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                     {
                        root.getChildren().remove(ba10_2_1);
                        root.getChildren().remove(voidRoom);
                        root.getChildren().add(badEnd1);
                        root.getChildren().add(ba10_2_2);
                     }
                     else if (root.getChildren().indexOf(ba10_2_2) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                     {
                        root.getChildren().remove(ba10_2_2);
                        root.getChildren().add(ba10_2_3);
                     }
                     else if (root.getChildren().indexOf(ba10_2_3) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                     {
                        root.getChildren().remove(ba10_2_3);
                        root.getChildren().remove(badEnd1);
                        root.getChildren().add(badEnd2);
                        root.getChildren().add(ba10_2_4);
                     }
                     else if (root.getChildren().indexOf(ba10_2_4) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                     {
                        root.getChildren().remove(ba10_2_4);
                        root.getChildren().remove(badEnd2);
                        root.getChildren().add(badEnd3);
                        root.getChildren().add(ba10_2_5);
                     }
                     else if (root.getChildren().indexOf(ba10_2_5) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                     {
                        root.getChildren().remove(ba10_2_5);
                        root.getChildren().add(endLost);
                        lost.set(1);
                     }
                     
                  }
                  else if (root.getChildren().indexOf(ba1) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                  {
                     root.getChildren().remove(ba1);
                     root.getChildren().add(ba2);
                  }
                  else if (root.getChildren().indexOf(ba2) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                  {
                     root.getChildren().remove(ba2);
                     root.getChildren().add(ba3);
                  }
                  else if (root.getChildren().indexOf(ba3) != -1 && root.getChildren().indexOf(ba3C) == -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                  {
                     root.getChildren().add(ba3C);
                  }
                  else if (root.getChildren().indexOf(ba4) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                  {
                     root.getChildren().remove(ba4);
                     root.getChildren().add(ba5);
                  }
                  else if (root.getChildren().indexOf(ba5) != -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                  {
                     root.getChildren().remove(ba5);
                     root.getChildren().add(ba6);
                  }
                  else if (root.getChildren().indexOf(ba6) != -1 && root.getChildren().indexOf(ba6C) == -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                  {
                     root.getChildren().add(ba6C);
                  }
                  else if ((root.getChildren().indexOf(ba7_1) != -1 || root.getChildren().indexOf(ba7_2) != -1) && root.getChildren().indexOf(ba8C) == -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                  {
                     root.getChildren().add(ba8C);
                  }
                  else if ((root.getChildren().indexOf(ba8_1) != -1 || root.getChildren().indexOf(ba8_2) != -1) && root.getChildren().indexOf(ba9C) == -1 && x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                  {
                     root.getChildren().add(ba9C);
                  }
                  
                  //For choosing dialogue
                  else if (root.getChildren().indexOf(ba3C) != -1)
                  {
                     if (x >= 910 && x <= 1250 && y >= 250 && y <= 350){
                        root.getChildren().add(ba4);
                        root.getChildren().remove(ba3);
                        root.getChildren().remove(ba3C);
                     }
                     else if (x >= 910 && x <= 1250 && y >= 350 && y <= 440){
                        root.getChildren().add(ba4_1_1);
                        root.getChildren().remove(ba3);
                        root.getChildren().remove(ba3C);
                        status.set(1);
                     }    
                  }
                  else if (root.getChildren().indexOf(ba6C) != -1)
                  {
                     if (x >= 910 && x <= 1250 && y >= 250 && y <= 350){
                        root.getChildren().remove(ba6C);
                        root.getChildren().remove(ba6);
                        root.getChildren().add(ba7_1);
                        root.getChildren().add(painting);
                        amtRight.set(amtRight.get()+1);
                     }
                     else if (x >= 910 && x <= 1250 && y >= 350 && y <= 440){
                        root.getChildren().add(ba7_2);
                        root.getChildren().remove(ba6C);
                        root.getChildren().remove(ba6);
                     }    
                  }
                  else if (root.getChildren().indexOf(ba8C) != -1)
                  {
                     if (x >= 910 && x <= 1250 && y >= 250 && y <= 350){
                        root.getChildren().remove(ba8C);
                        if (root.getChildren().indexOf(ba7_1) != -1)
                           root.getChildren().remove(ba7_1);
                        if (root.getChildren().indexOf(ba7_2) != -1)
                           root.getChildren().remove(ba7_2);
                        root.getChildren().add(ba8_1);
                        root.getChildren().add(ps5);
                        amtRight.set(amtRight.get()+1);
                     }
                     else if (x >= 910 && x <= 1250 && y >= 350 && y <= 440){
                        root.getChildren().remove(ba8C);
                        if (root.getChildren().indexOf(ba7_1) != -1)
                           root.getChildren().remove(ba7_1);
                        if (root.getChildren().indexOf(ba7_2) != -1)
                           root.getChildren().remove(ba7_2);
                        root.getChildren().add(ba8_2);
                     }    
                  }
                  else if (root.getChildren().indexOf(ba9C) != -1)
                  {
                     if (x >= 910 && x <= 1250 && y >= 250 && y <= 350){
                        root.getChildren().remove(ba9C);
                        if (root.getChildren().indexOf(ba8_1) != -1)
                           root.getChildren().remove(ba8_1);
                        if (root.getChildren().indexOf(ba8_2) != -1)
                           root.getChildren().remove(ba8_2);
                        root.getChildren().add(ba9_2);
                        status.set(2);
                     }
                     else if (x >= 910 && x <= 1250 && y >= 350 && y <= 440){
                        root.getChildren().remove(ba9C);
                        if (root.getChildren().indexOf(ba8_1) != -1)
                           root.getChildren().remove(ba8_1);
                        if (root.getChildren().indexOf(ba8_2) != -1)
                           root.getChildren().remove(ba8_2);
                        root.getChildren().add(ba9_1);
                        root.getChildren().add(guitar);
                        amtRight.set(amtRight.get()+1);
                     if (amtRight.get() >= 2)
                        status.set(3);
                     else
                        status.set(2);
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
               //Normal dialogue
               if (root.getChildren().indexOf(ba3C) == -1 && root.getChildren().indexOf(ba6C) == -1 && root.getChildren().indexOf(ba8C) == -1 && root.getChildren().indexOf(ba9C) == -1 && root.getChildren().indexOf(endLost) == -1)
               {
                  if (x >= 30 && x <= 1245 && y >= 440 && y <= 630)
                     scene.setCursor(Cursor.HAND);
                  else
                     scene.setCursor(Cursor.DEFAULT);
               }
               //Choose
               else if (root.getChildren().indexOf(endLost) == -1)
               {
                  if (x >= 910 && x <= 1250 && y >= 350 && y <= 440)
                     scene.setCursor(Cursor.HAND);
                  else if (x >= 910 && x <= 1250 && y >= 250 && y <= 350)
                     scene.setCursor(Cursor.HAND);
                  else
                     scene.setCursor(Cursor.DEFAULT);
               }
               else
                  scene.setCursor(Cursor.DEFAULT);
            }
         });
      return scene;
            
   
   }

}