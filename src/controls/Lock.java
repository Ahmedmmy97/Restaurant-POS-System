/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author ahmed
 */
public class Lock extends JLabel{
    public Lock() {
//        
//        ImageIcon  imageIcon = new ImageIcon(getClass().getResource("home.png"));
//        setIcon(new ImageIcon(scale(imageIcon.getImage(), 50, 50)));
       // addMouseListener(this);

        setSize(20,20);
    }
     @Override
    public void paint(Graphics grphcs) {
        super.paint(grphcs); //To change body of generated methods, choose Tools | Templates.
        ImageIcon  imageIcon = new ImageIcon(getClass().getResource("/images/lock.png"));
        setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance( getWidth(), getHeight(),Image.SCALE_SMOOTH)));
    }

     
    
   

    
}
