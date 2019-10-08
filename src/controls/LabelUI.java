/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import java.awt.Color;
import java.awt.Dimension;
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
public class LabelUI extends BasicLabelUI{
      @Override
    public void paint(Graphics g, JComponent j) {
        
        FontMetrics fm = g.getFontMetrics();
          JLabel b = (JLabel)j;
        paintBackground(g, b);
        
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
     private void paintBackground(Graphics g, JComponent c) {
        FontMetrics fm = g.getFontMetrics();
        Dimension size = c.getSize();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      
        
        
        g.setColor(c.getBackground().darker());
        g.fillRect(3, 3, size.width-15, size.height-4);
        g.setColor(c.getBackground());
        g.fillRect(5, 5, size.width-20, size.height-10);
        JLabel b = (JLabel)c;
         ImageIcon icon = (ImageIcon)b.getIcon();
        Dimension d = b.getSize();
        Graphics2D g2d = (Graphics2D)g;
//        //8bb8ea
//        g2d.setColor(new Color(0x8B,0xB8,0xEA,0xFF));
//        g2d.fillRoundRect(-10, 0, d.width+10, d.height, 20, 20);
//        g2d.setColor(new Color(0,0,0));
//        
//        g2d.drawRoundRect(-10, 0, d.width+9, d.height-1, 20, 20);
//        g2d.setFont(new java.awt.Font("segoe print", 0, 15));
//        
//          
//        
//        
//        
        
        
       
        ImageIcon  imageIcon = (ImageIcon)b.getIcon();
        int x;
        int y;
        if(imageIcon!=null){
            imageIcon = new ImageIcon(scale(imageIcon.getImage(),109, 80));
        
            x = (d.width -109) / 2;
            y =(d.height -80) / 2;
            imageIcon.paintIcon(c, g, x, y);
            
        }
        
         
       
        
    } 
      
     Image scale(Image img,int w,int h){
     BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
     Graphics2D gf = image.createGraphics();
     gf.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
     gf.drawImage(img, 0, 0, w,h,null);
     gf.dispose();
     return image;
    }
}
