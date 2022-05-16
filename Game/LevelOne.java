import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.imageio.ImageIO;
import java.io.*;

public class LevelOne implements Level
{
   private Image background;
   String fileName = "test.jpg";
   public LevelOne()
   {
      fileName = "test.jpg";
      try {
         background = ImageIO.read(new File(fileName));
      } catch (IOException e) {
         System.out.println("Can't load " + fileName + ".");
      }
   }
   
   public void changeLeftScreen()
   {
   
   }
   public void changeRightScreen()
   {
   
   }
   public void exit()
   {
   
   }
   public void background()
   {
   
   }
   public void dialogue()
   {
   
   
   }
   
   public String bg()
   {
      return fileName;
   }

}