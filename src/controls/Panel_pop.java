/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author ahmed
 */
public class Panel_pop extends JPanel{

    @Override
    protected void paintComponent(Graphics grphcs) {
       // super.paintComponent(grphcs); //To change body of generated methods, choose Tools | Templates.
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/PanelBack.png"));
        icon = new ImageIcon(scale(icon.getImage(), getWidth(), getHeight()));
        icon.paintIcon(this, grphcs, 0, 0);
        
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
