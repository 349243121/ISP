/*
Group Members: Ethan Zhu, Sean Zhang, Leo Liu
Date: 2022-05-20
Program: This program was a test program to set a picture as the background for our application
*/
//Needed import statements from javax.swing and java.awt
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.imageio.ImageIO;
import java.io.*;

public class LevelOne extends JPanel implements Level
{
   //initializing variables
   private Image[] background;
   private String fileName;
   private JFrame frame;
   private int currentScreen;
   
   //sets fileName to "test.jpg", which was the picture used to test the program
   public LevelOne()
   {
      fileName = "test.jpg";
      background = new Image[4];
      background[0] = Main.readImage(fileName);
   }
   
   //paintComponent, which displays the image into our application
   @Override
   protected void paintComponent (Graphics g)
   {
      super.paintComponent(g);
      g.drawImage(background[0],0,0,getWidth(),getHeight(),this);
   }
   
   //setScreen()
   public void setScreen()
   {
      
   }
   //exit()
   public void exit()
   {
   
   }
   //dialogue()
   public void dialogue()
   {
   
   
   }
   //bg()
   public String bg()
   {
      return fileName;
   }

}