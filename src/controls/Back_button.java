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
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author ahmed
 */
public class Back_button extends JLabel implements MouseListener{
     private JFrame previous;
    private JFrame current;
    public Back_button() {
        
//        ImageIcon  imageIcon = new ImageIcon(getClass().getResource("backbutton.png"));
//        setIcon(new ImageIcon(scale(imageIcon.getImage(), 50, 50)));
        addMouseListener(this);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setSize(20,20);
    }
   
      @Override
    public void paint(Graphics grphcs) {
        super.paint(grphcs); //To change body of generated methods, choose Tools | Templates.
        ImageIcon  imageIcon = new ImageIcon(getClass().getResource("/images/Back_52px.png"));
         setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH )));
    }

  
    
    @Override
    public void setSize(int i, int i1) {
        super.setSize(i, i1); 
        ImageIcon  imageIcon = new ImageIcon(getClass().getResource("/images/Back_52px.png"));
         setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH )));
        //To change body of generated methods, choose Tools | Templates.
    }
     public void setframes(JFrame current,JFrame previous) {
        this.current = current;
        this.previous= previous;
    }
    @Override
    public void mouseClicked(MouseEvent me) {
        previous.setEnabled(true);
        previous.setVisible(true);
        current.dispose();
    }

    @Override
    public void mousePressed(MouseEvent me) {
         //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
         //To change body of generated methods, choose Tools | Templates.
    }
}
