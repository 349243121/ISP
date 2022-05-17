import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.*;

public class Test2 extends JFrame
{
   private JFrame frame;
   public Test2()
   {
      frame = new JFrame();
      frame.setTitle("Identity Crisis Be Like");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setResizable(false);
      frame.setSize(1920,1080);
      ImageIcon image = new ImageIcon("test.jpg");
      frame.setVisible(true);

   }
   
   
}