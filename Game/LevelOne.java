import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.imageio.ImageIO;
import java.io.*;

public class LevelOne extends JFrame implements Level
{
   private Image background;
   String fileName = "test.jpg";
   private JFrame frame;
   
   public LevelOne()
   {
      fileName = "test.jpg";
      
   }
   
   public Image readImage(String fileName)
   {
      Image img = null;
    
      File imageFile = new File(fileName);
      try
      {
         img = ImageIO.read(imageFile);
      }
      catch (IOException ex)
      {
         System.out.println("*** Can't load " + fileName + " ***");
      }
    
      return img;
   }
   
   public void paint (Graphics g)
   {
      super.paint(g);
      g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
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