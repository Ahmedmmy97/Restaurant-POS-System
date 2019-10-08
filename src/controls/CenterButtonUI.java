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
import java.awt.RenderingHints;
import javax.swing.AbstractButton;
import javax.swing.JButton;

import javax.swing.JComponent;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;

/**
 *
 * @author ahmed
 */
public class CenterButtonUI extends BasicButtonUI{

    public CenterButtonUI() {
    }
 @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        AbstractButton button = (AbstractButton) c;
        button.setOpaque(false);
        button.setBorder(new EmptyBorder(7, 10, 7, 10));
        button.setFont(new Font("Calibri", 0, 15));
        button.setBackground(new Color(219,58,49));
        button.setForeground(Color.white);

    }
    @Override
    public void paint(Graphics g, JComponent j) {
        
        FontMetrics fm = g.getFontMetrics();
        JButton b = (JButton)j;
        
        paintBackground(g, b, b.getModel().isPressed() ? 2 : 0);
        super.paint(g, j);
//        Dimension d = b.getSize();
//        Graphics2D g2d = (Graphics2D)g;
//        //8bb8ea
//        g2d.setColor(new Color(0x8B,0xB8,0xEA,0xFF));
//        g2d.fillRoundRect(0, 0, d.width, d.height, 20, 20);
//        g2d.setColor(new Color(0,0,0));
//        
//        g2d.drawRoundRect(0, 0, d.width-1, d.height-1, 20, 20);
//        g2d.setFont(new java.awt.Font("segoe print", 0, 15));
//        
//          
//        
//        
//        
//        g2d.setColor(new Color(0,0,0));
//        String caption = b.getText();
//        
//        int x;
//        int y = (d.height + fm.getAscent()) / 2;
//        
//        
//            x = (d.width - fm.stringWidth(caption)) / 2;
//            g2d.drawString(caption, x, y);
        
//        if( fm.stringWidth(caption)+icon.getIconWidth()+10<d.width)
//        g.drawString(caption, x, y);
        
        
        //To change body of generated methods, choose Tools | Templates.
    }
      private void paintBackground(Graphics g, JComponent c, int yOffset) {
        Dimension size = c.getSize();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        g.setColor(c.getBackground().darker());
//        g.fillRect(0, yOffset, size.width, size.height - yOffset);
        g.setColor(c.getBackground());
        g.fillRect(0, yOffset, size.width, size.height + yOffset - 4);
    }
    
}
