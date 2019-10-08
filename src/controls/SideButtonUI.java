/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
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
public class SideButtonUI extends BasicButtonUI{

    public SideButtonUI() {
    }
@Override
    public void installUI(JComponent c) {
        super.installUI(c);
        AbstractButton button = (AbstractButton) c;
        button.setOpaque(false);
        button.setBorder(new EmptyBorder(7, 10, 7, 10));
        button.setFont(new Font("segoe print", Font.BOLD, 15));
        button.setBackground(new Color(61,59,55));
        button.setForeground(Color.white);
//5db1ff
//417af2
    }
    @Override
    public void paint(Graphics g, JComponent j) {
        
        FontMetrics fm = g.getFontMetrics();
        JButton b = (JButton)j;
        ImageIcon icon = (ImageIcon)b.getIcon();
        paintBackground(g, b, b.getModel().isPressed() ? 2 : 0);
        
 
        
        Graphics2D g2d = (Graphics2D)g;

//       
//       
//         BufferedImage image = new BufferedImage(75, 75, BufferedImage.TYPE_INT_ARGB);
//        
//        
//         g2d.drawImage(icon.getImage(), (icon.getIconWidth())/2, (icon.getIconHeight())/2, null);
//         g2d.setClip(null);
//         Stroke s = new BasicStroke(2);
//         g2d.setStroke(s);
//         
//         g2d.setColor(new Color(61,59,55));
//         g2d.draw(circle);
//          
//         //g2d.dispose();
//         icon = new ImageIcon(image);
//         icon.paintIcon(b, g2d, 0, 0);
    }
    private void paintBackground(Graphics g, JComponent c, int yOffset) {
        FontMetrics fm = g.getFontMetrics();
        Dimension size = c.getSize();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
//        g.setColor(c.getBackground().darker());
//        g.fillRect(-10, yOffset, size.width+10, size.height - yOffset);
//        g.setColor(c.getBackground());
//        g.fillRect(-10, yOffset, size.width+9, size.height + yOffset - 4);
        JButton b = (JButton)c;
         ImageIcon icon = (ImageIcon)b.getIcon();
        Dimension d = b.getSize();
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
//       
//         if( b.getModel().isRollover())
//        g2d.setColor(b.getBackground().darker());
//        else
//         g2d.setColor(new Color(255,255,255));
        
        String caption = b.getText();
        
        int x;
        int y = (d.height-yOffset-10 + fm.getAscent()) / 2;
        ImageIcon  imageIcon = (ImageIcon)b.getIcon();
        
         
       
        
         
        if(imageIcon!=null){
        imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(40,  b.getHeight()-yOffset-20, Image.SCALE_SMOOTH));
        Ellipse2D.Double ellipse1 = new Ellipse2D.Double(
                b.getSize().width-imageIcon.getIconWidth()-10,5+yOffset,imageIcon.getIconWidth()+10,imageIcon.getIconHeight()+10); 
       
         Area circle = new Area(ellipse1);
         g2d.setColor(new Color(255,255,255));
         g2d.fill(circle);
         g2d.setClip(circle);
        //imageIcon.paintIcon(c, g, b.getSize().width-imageIcon.getIconWidth()-10, 3+yOffset);
         g2d.drawImage(imageIcon.getImage(), b.getSize().width-imageIcon.getIconWidth()-5, 10+yOffset,null);
         g2d.setClip(null);
         Stroke s = new BasicStroke(2);
         g2d.setStroke(s);
         
         g2d.setColor(new Color(61,59,55));
         g2d.draw(circle);
        }
        g2d.setColor(b.getForeground());
        if(imageIcon!=null){
            x = (d.width - fm.stringWidth(caption)-imageIcon.getIconWidth()) / 2;
            if( fm.stringWidth(caption)+125<d.width)
               g.drawString(caption, x, y);
            
        }
        else{
            x = (d.width - fm.stringWidth(caption)) / 2;
            g.drawString(caption, x, y);
        }
        
    } 
     
}
