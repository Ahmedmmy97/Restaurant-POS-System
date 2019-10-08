/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.plaf.basic.BasicLabelUI;

/**
 *
 * @author ahmed
 */
public class Circleui extends BasicLabelUI {



    @Override
    public void installUI(JComponent jc) {
        super.installUI(jc); //To change body of generated methods, choose Tools | Templates.
        JLabel l = (JLabel)jc;
        
        //Default_icon
        l.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/mango.png")).getImage().getScaledInstance(50,50, Image.SCALE_SMOOTH)));
        
        Dimension d = new Dimension(50,50);
        l.setSize(d);
    }

    @Override
    public void paint(Graphics grphcs, JComponent jc) {
        
        paintback(grphcs, jc);
        
    }

    public Circleui() {
       
        
    }
    
    void paintback( Graphics g , JComponent j) {
       
         JLabel l =(JLabel)j;
         ImageIcon icon = (ImageIcon)l.getIcon();
         int w = l.getWidth();
         int h = l.getHeight();
         icon = new ImageIcon(icon.getImage().getScaledInstance(l.getWidth()-20, l.getHeight()-20, Image.SCALE_SMOOTH));
        
         Ellipse2D.Double ellipse1 = new Ellipse2D.Double(
                0,0,w,h); 
       
         Area circle = new Area(ellipse1);
        
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
       
       
         BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        
         g2d.setColor(new Color(255,255,255));
         g2d.fill(circle);
         g2d.setClip(circle);
         g2d.drawImage(icon.getImage(), (w-icon.getIconWidth())/2, (h-icon.getIconHeight())/2, null);
         g2d.setClip(null);
         Stroke s = new BasicStroke(2);
         g2d.setStroke(s);
         
         g2d.setColor(new Color(61,59,55));
         g2d.draw(circle);
          
         //g2d.dispose();
//         icon = new ImageIcon(image);
//         icon.paintIcon(l, g2d, 0, 0);
    }
    
   
}
