/*
Group Members: Ethan Zhu, Sean Zhang, Leo Liu
Date: 2022-05-20
Program: This program was a test program to set loading a picture
Hours: 0.5 Hours
*/
//Needed import statements from javax.swing and java.awt

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.*;

public class Test 
{
   private static JFrame frame;
   private static String fileName;
   private static Image img;
   
   //Reading an image by their file name
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
   /*
   public void paint (Graphics g)
   {
      super.paint(g);
      g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
   }*/
   
   public static void main (String[] args)
   {
      JFrame a = new Test1();
      a = new Test2();
   }
}