/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gui;

import java.awt.Dimension;  
import java.awt.Graphics;  
import java.awt.event.MouseAdapter;  
import java.awt.event.MouseEvent;  
import java.awt.image.BufferedImage;  
import java.awt.image.PixelGrabber;  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.IOException;  
  
import javax.imageio.ImageIO;  
import javax.swing.JButton;  
  
public class CustomizeButton extends JButton {  
    private BufferedImage image_over; //mouse on the button
    private BufferedImage image_off; //mouse not on the button
    private BufferedImage image_pressed; //mouse push the button
    private int buttonWidth; //width of button
    private int buttonHeight; // height of button
    private int[] pixels; //arry for save picture
    private boolean mouseOn;  
    private boolean mousePressed;  
    
    public int getButtonWidth(){
    	return buttonWidth= image_off.getWidth();
    }
    public int getButtonHeight(){
    	return buttonHeight = image_off.getHeight(); 
    }
    /** 
     * @param img_off 
     *            
     * @param img_over 
     *           
     * @param img_pressed 
     *           
     */  
    public CustomizeButton(String img_off, String img_over, String img_pressed) {  
        mouseOn = false;  
        mousePressed = false;  
        // load picture
        try {  
            image_over = ImageIO.read(new FileInputStream(img_over));  
            image_off = ImageIO.read(new FileInputStream(img_off));  
            image_pressed = ImageIO.read(new FileInputStream(img_pressed));  
        } catch (FileNotFoundException e1) {  
            // TODO Auto-generated catch block  
            e1.printStackTrace();  
        } catch (IOException e1) {  
            // TODO Auto-generated catch block  
            e1.printStackTrace();  
        }  
  
        buttonWidth = image_off.getWidth();  
        buttonHeight = image_off.getHeight();  
  
        // read picture  
        pixels = new int[buttonWidth * buttonHeight];  
        // take picture 
        PixelGrabber pg = new PixelGrabber(image_off, 0, 0, buttonWidth,  
                buttonHeight, pixels, 0, buttonWidth);  
        try {  
            pg.grabPixels();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
        // must set or has ghost  
        this.setOpaque(false);  
        this.setPreferredSize(new Dimension(buttonWidth, buttonHeight));  
        this.addMouseListener(new MouseHandler());  
    }  
  
    // read picture  
    public BufferedImage loadImage(String filename) {  
        File file = new File(filename);  
  
        if (!file.exists())  
            return null;  
  
        try {  
            return ImageIO.read(file);  
        } catch (IOException e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  
  
    //take picture  
    @Override  
    public void paintComponent(Graphics g) {  
        g.drawImage(image_off, 0, 0, this);  
        if (mouseOn)  
            g.drawImage(image_over, 0, 0, this);  
        else if (mousePressed)  
            g.drawImage(image_pressed, 0, 0, this);  
    }  
  
    // set border
    @Override  
    public void paintBorder(Graphics g) {  
        //no border
    }  
  
    @Override  
    public void setSize(Dimension d) {  
        // TODO Auto-generated method stub  
        super.setSize(d);  
    }  
  
    public boolean contains(int x, int y) {  
        // check the border of picture 
        if (!super.contains(x, y))  
            return false;  
  
       int alpha = (pixels[(buttonWidth * y + x)] >> 24) & 0xff;  
  
        repaint();  
        if (alpha == 0) {  
            return false;  
        } else {  
            return true;  
        }  
    }  
  
    //when the muser goin or leave the button.
    class MouseHandler extends MouseAdapter {  
        public void mouseExited(MouseEvent e) {  
            mouseOn = false;  
            repaint();  
        }  
  
        public void mouseEntered(MouseEvent e) {  
            mouseOn = true;  
            repaint();  
        }  
  
        public void mousePressed(MouseEvent e) {  
            mouseOn = false;  
            mousePressed = true;  
            repaint();  
        }  
  
        public void mouseReleased(MouseEvent e) {  
            //prevent user undo mouse on the outside of button
            if (contains(e.getX(), e.getY()))  
                mouseOn = true;  
            else  
                mouseOn = false;  
  
            mousePressed = false;  
            repaint();  
        }  
    }  
}  