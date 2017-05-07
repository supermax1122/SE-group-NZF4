/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUITools;

import java.awt.Graphics;  
import java.awt.Graphics2D;  
import java.awt.image.BufferedImage;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.IOException;  
import java.io.InputStream;  
import javax.imageio.ImageIO;  
import javax.swing.JPanel;  
  
public class MyBackGround extends JPanel {  
    /**
     * This class for setup the background for Panel.
     */
    String url="sk.png";  
    public MyBackGround(String url){  
        super();  
        this.url = url;  
    }  
    public MyBackGround(){  
        super();  
    }  
    @Override  
    public void paintComponent(Graphics gs) {  
        Graphics2D g = (Graphics2D) gs;  
        super.paintComponent(g);  
  
        InputStream in;  
        try {  
            in = new FileInputStream(url);   
            BufferedImage image = ImageIO.read(in);  
            g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(),  
                    this);  
        } catch (FileNotFoundException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    }  
}