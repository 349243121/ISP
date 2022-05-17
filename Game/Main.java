import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.*;

public class Main
{
   private static JFrame frame;
   public void initializeFrame()
   {
      frame = new JFrame();
      frame.setTitle("Identity Crisis Be Like");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setResizable(false);
      frame.setSize(1920,1080);
      ImageIcon image = new ImageIcon("logo.png");
      frame.setIconImage(image.getImage());
      frame.setContentPane(new LevelOne());
            frame.setVisible(true);
   }
   
   public static void main (String [] args)
   {
      Main m = new Main();
      m.initializeFrame();
      //frame.setVisible(true);
   }
}