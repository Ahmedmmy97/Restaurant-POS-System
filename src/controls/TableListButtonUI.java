/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

/**
 *
 * @author ahmed
 */
public class TableListButtonUI extends CustomizedListButtonUI {

    @Override
    public void paint(Graphics g, JComponent j) {
        super.paint(g, j);
        JButton b =(JButton)j;
        paint_caption_icon(g, b, b.getModel().isPressed() ? 2 : 0);
    }
    
     void paint_caption_icon(Graphics g, JComponent c, int yOffset){
        JButton b =(JButton)c;
        g.setColor(new Color(255,255,255).darker()); //999b9e //a2bef8
        g.fillRect(14, 14+yOffset, 52, 52);
        g.setColor(new Color(255,255,255)); //999b9e //a2bef8
        g.fillRect(15, 15+yOffset, 50, 50);
        String caption = b.getText();
        FontMetrics fm = g.getFontMetrics();
        g.setColor(new Color(59,57,54));
        g.drawString(caption, 14+((52-fm.stringWidth(caption))/2), 12+yOffset+((50 + fm.getAscent()) / 2));
      if(b.getIcon()!=null){
          ImageIcon  imageIcon = (ImageIcon)b.getIcon();
          
          imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(150, 123, Image.SCALE_SMOOTH));
          imageIcon.paintIcon(c, g, (b.getSize().width-imageIcon.getIconWidth())/2, (b.getSize().height-imageIcon.getIconHeight()-30)/2+yOffset+25);
        }
     }
}
