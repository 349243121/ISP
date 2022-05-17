import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.imageio.ImageIO;
import java.io.*;

public class LevelOne extends JPanel implements Level
{
   private Image[] background;
   private String fileName;
   private JFrame frame;
   private int currentScreen;
   
   public LevelOne()
   {
      fileName = "test.jpg";
      background = new Image[4];
      background[0] = readImage(fileName);
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
   
   @Override
   protected void paintComponent (Graphics g)
   {
      super.paintComponent(g);
      g.drawImage(background[0], 0, 0, getWidth(), getHeight(), this);
   }
   
   public void setScreen()
   {
      
   }
   public void exit()
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