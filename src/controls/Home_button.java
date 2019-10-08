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
import restaurant.v2.Main;

/**
 *
 * @author ahmed
 */
public class Home_button extends JLabel implements MouseListener{
    Main m;
    JFrame current;
    public Home_button() {
//        
//        ImageIcon  imageIcon = new ImageIcon(getClass().getResource("home.png"));
//        setIcon(new ImageIcon(scale(imageIcon.getImage(), 50, 50)));
        addMouseListener(this);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setSize(20,20);
    }
     @Override
    public void paint(Graphics grphcs) {
        super.paint(grphcs); //To change body of generated methods, choose Tools | Templates.
        ImageIcon  imageIcon = new ImageIcon(getClass().getResource("/images/Home_104px.png"));
         setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH )));
    }

    public void setMain(Main m,JFrame current) {
        this.m = m;
        this.current=current;
    }

     
   
    @Override
    public void setSize(int i, int i1) {
        super.setSize(i, i1); 
        ImageIcon  imageIcon = new ImageIcon(getClass().getResource("/images/Home_104px.png"));
         setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH )));
        //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void mouseClicked(MouseEvent me) {
        try{
        m.setEnabled(true);
        m.setVisible(true);
        current.dispose();
        }catch(Exception e){
        }
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
