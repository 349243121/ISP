/*
Group Members: Ethan Zhu, Sean Zhang, Leo Liu
Date: 2022-05-20
Program: This program was a test run to create our main menu
*/
//import statements for javax.swing and java.awt
//This test program was made by  before we decided to switch to javafx
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
      //set the background to yellow and read our images "start.png" and "start_g.png"
      setBackground(Color.yellow);
      start = Main.readImage("start.png");
      startG = Main.readImage("start_g.png");
      //start = start.getScaledInstance(100, 50, Image.SCALE_DEFAULT);
   }
   protected void paintComponent (Graphics g)
   {
      //printed our image "start.png" onto the application if onStart was false
      //otherwise printed our image "start.png" onto the application
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
      //this method checks if the mouse is hovering over the start button
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