/*
Group Members: Ethan Zhu, Sean Zhang, Leo Liu
Date: 2022-05-20
Program: This program was a test case that used javafx to create a test of main menu for our game.
*/
//These are the many import statements used to import all the needed javafx modules
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

public class Test extends Application {

   //This main method launches our program
   public static void main (String [] args)
   {
      launch(args);
   }
   
   //The start method makes all the needed changes to our program when it runs
   @Override
   public void start (Stage stage) throws Exception {
      //Stage stage = new Stage();
      Group root = new Group();
      //This lines sets the scene color to black
      Scene scene = new Scene(root, Color.BLACK);
      stage.setScene(scene);
      //sets the title of the application it "Identity Crisis Be Like"
      stage.setTitle("Identity Crisis Be Like");
      //changes the icon picture to "logo.png", which is a banana
      Image icon = new Image("logo.png");
      //sets the icon and displays our application
      stage.getIcons().add(icon);
      stage.show();
   }
}