import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.*;

public class Test extends JFrame
{
   private static JFrame frame;
   private static String fileName;
   private static Image img;
   
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
         System.exit(1);
      }
    
      return img;
   }
   public void paint (Graphics g)
   {
      super.paint(g);
      g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
   }
   
   public static void main (String[] args)
   {
      Test frame = new Test();
      LevelOne l1 = new LevelOne();
      fileName = l1.bg();
      frame.setSize(new Dimension(1280,1024));
      frame.setDefaultCloseOperation(EXIT_ON_CLOSE); 
      img = frame.readImage(fileName);     
      frame.setVisible(true);
   }
}