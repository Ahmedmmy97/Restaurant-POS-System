/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JComponent;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;

/**
 *
 * @author ahmed
 */
public class CustomizedListButtonUI extends BasicButtonUI{

    public CustomizedListButtonUI() {
    }
 @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        AbstractButton button = (AbstractButton) c;
        button.setOpaque(false);
        button.setBorder(new EmptyBorder(7, 10, 7, 10));
        button.setFont(new Font("Calibri", 0, 18));
        button.setBackground(new Color(242,242,242));
        button.setForeground(Color.black);
        Dimension d = new Dimension(200, 200);
        button.setPreferredSize(d);
        button.setText("1");
         
        //45484f
        //bed0f6
        //5689f3
    }
    @Override
    public void paint(Graphics g, JComponent j) {
        
        FontMetrics fm = g.getFontMetrics();
        JButton b = (JButton)j;
        
        paintBackground(g, b, b.getModel().isPressed() ? 2 : 0);
     
    }
      private void paintBackground(Graphics g, JComponent c, int yOffset) {
        Dimension size = c.getSize();
        Graphics2D g2 = (Graphics2D) g;
        JButton b =(JButton)c;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(c.getBackground().darker());
        g2.fillRect(3, 3+yOffset, size.width-15, size.height-4);
        g2.setColor(c.getBackground());
        g2.fillRect(5+yOffset, 5+yOffset, size.width-20, size.height-10+yOffset );

    }
    
    
}
