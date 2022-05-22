/*
Group Members: Ethan Zhu, Sean Zhang, Leo Liu
Date: 2022-05-20
Program: This program was a test program to test JFrames
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

public class Test1 extends JFrame
{
   private JFrame frame;
   public Test1()
   {
      frame = new JFrame();
      frame.setTitle("Identity Crisis Be Like");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setResizable(false);
      frame.setSize(1920,1080);
      ImageIcon image = new ImageIcon("logo.png");
      frame.setVisible(true);

   }
   
   
}