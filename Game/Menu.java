import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.*;
import java.awt.PointerInfo;

public class Menu extends JPanel implements ActionListener, MouseMotionListener
{
   private Image start;
   private Image startG;
   boolean onStart = false;
   public Menu()
   {
      setBackground(Color.yellow);
      start = Main.readImage("start.png");
      startG = Main.readImage("start_g.png");
      //start = start.getScaledInstance(100, 50, Image.SCALE_DEFAULT);
   }
   protected void paintComponent (Graphics g)
   {
      super.paintComponent(g);
      if (!onStart)
         g.drawImage(start, 80, 600, this);
      else
         g.drawImage(startG, 80, 600, this);
   }
   public void actionPerformed(ActionEvent a)
   {
   
   }
   
   public void mouseMoved (MouseEvent e)
   {
      int x = (int)getLocation().getX();
      int y = (int)getLocation().getY();
      if (x >= 80 && x <= 210 && y >= 600 && y <= 651)
      {
         onStart = true;
         revalidate();
         repaint();
      }
   }
   
   public void mouseDragged(MouseEvent e)
   {
   
   }
}