/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.JButton;

/**
 *
 * @author ahmed
 */
public class Side_button extends JButton {
   //ImageIcon icon= new ImageIcon(getClass().getResource("close.png"));
   int i=0;
    public Side_button() {
        super();
        setUI(new SideButtonUI());
        //addMouseListener(this);
        //setIcon(new ImageIcon(scale(icon.getImage(), 30, 45)));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setSize(80, 60);
        setText("");
    }
   
    public Side_button(String text) {
        super(text);
        setText(text);
        setUI(new SideButtonUI());
        //addMouseListener(this);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        //this.icon=icon;
        setSize(80, 60);
        //setIcon(new ImageIcon(scale(icon.getImage(),30, 45)));
    }
    


    
}
