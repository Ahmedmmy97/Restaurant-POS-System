/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import controls.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.plaf.basic.BasicLabelUI;

/**
 *
 * @author ahmed
 */
public class ItemUi extends BasicLabelUI{

    @Override
    public void installUI(JComponent jc) {
        
        super.installUI(jc); //To change body of generated methods, choose Tools | Templates.
        JLabel l = (JLabel)jc;
        l.setFont(new Font("Calibri", 0, 18));
        l.setForeground(new Color(255,255,255));
        Dimension d = new Dimension(300, 60);
        l.setPreferredSize(d);
                
    }
    
      @Override
    public void paint(Graphics g, JComponent j) {
        
        FontMetrics fm = g.getFontMetrics();
          JLabel b = (JLabel)j;
        //paintBackground(g, b);
         String caption = b.getText();
        
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                  RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                  RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, 
                  RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        ImageIcon  imageIcon = (ImageIcon)b.getIcon();
        
        
            if(imageIcon !=null)
            new ImageIcon(imageIcon.getImage().getScaledInstance(40, b.getHeight()-20, Image.SCALE_SMOOTH)).paintIcon(b, g2d, 10, 10);
            //g2d.setFont(new java.awt.Font("segoe print", Font.BOLD, 17));
            g2d.drawString(caption, (b.getWidth()-fm.stringWidth(caption)-5)/2, (b.getHeight()+fm.getAscent()-5)/2);
//        ImageIcon icon = (ImageIcon)b.getIcon();
//        Dimension d = b.getSize();
//        Graphics2D g2d = (Graphics2D)g;
////        //8bb8ea
////        g2d.setColor(new Color(0x8B,0xB8,0xEA,0xFF));
////        g2d.fillRoundRect(-10, 0, d.width+10, d.height, 20, 20);
////        g2d.setColor(new Color(0,0,0));
////        
////        g2d.drawRoundRect(-10, 0, d.width+9, d.height-1, 20, 20);
////        g2d.setFont(new java.awt.Font("segoe print", 0, 15));
////        
////          
////        
////        
////        
//        g2d.setColor(new Color(0,0,0));
//        String caption = b.getText();
//        
//        int x;
//        int y = (d.height + fm.getAscent()) / 2;
//        if(icon!=null){
//            x = (d.width - fm.stringWidth(caption)-icon.getIconWidth()) / 2;
//            if( fm.stringWidth(caption)+125<d.width)
//               g2d.drawString(caption, x, y);
//        }
//        else{
//            x = (d.width - fm.stringWidth(caption)) / 2;
//            g2d.drawString(caption, x, y);
//        }
//        if( fm.stringWidth(caption)+icon.getIconWidth()+10<d.width)
//        g.drawString(caption, x, y);
        
        
//        //To change body of generated methods, choose Tools | Templates.
    }
    
     
}
