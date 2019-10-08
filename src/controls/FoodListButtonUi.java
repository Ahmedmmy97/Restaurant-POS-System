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
import java.awt.Image;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author ahmed
 */
public class FoodListButtonUi extends CustomizedListButtonUI {

    @Override
    public void installUI(JComponent c) {
        super.installUI(c); //To change body of generated methods, choose Tools | Templates.
         AbstractButton button = (AbstractButton) c;
        
        Dimension d = new Dimension(250, 250);
        button.setPreferredSize(d);
       
    }

   

    @Override
    public void paint(Graphics g, JComponent j) {
        super.paint(g, j); //To change body of generated methods, choose Tools | Templates.
        JButton b =(JButton)j;
        paint_caption_icon(g, b, b.getModel().isPressed() ? 2 : 0);
    }
    void paint_caption_icon(Graphics g, JComponent c, int yOffset){
        JButton b =(JButton)c;
        g.setColor(new Color(255,255,255).darker()); //999b9e //a2bef8
        g.fillRect((b.getWidth()-150)/2+yOffset, b.getHeight()-39+yOffset, 151+yOffset, 30+yOffset);
        g.setColor(new Color(255,255,255)); //999b9e //a2bef8
        g.fillRect((b.getWidth()-150)/2+2, b.getHeight()-38+yOffset, 149, 30);
        String caption = b.getText();
        FontMetrics fm = g.getFontMetrics();
        g.setColor(new Color(59,57,54));
        while(fm.stringWidth(caption)>=150)
            caption = caption.substring(0, caption.length()/2);
        g.drawString(caption, (b.getWidth()-150)/2+2+((150-fm.stringWidth(caption))/2), b.getHeight()-40+yOffset+((30 + fm.getAscent()) / 2));
        if(b.getIcon()!=null){
          ImageIcon  imageIcon = (ImageIcon)b.getIcon();
          
          imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(150, 123, Image.SCALE_SMOOTH));
          imageIcon.paintIcon(c, g, (b.getSize().width-imageIcon.getIconWidth())/2, (b.getSize().height-imageIcon.getIconHeight()-30)/2+yOffset);
        }
     }
}
