/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import java.awt.Cursor;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author ahmed
 */
public class Circle_image extends JLabel{

    public Circle_image() {
        
            
//            JLabel l = new JLabel();
//                l.setUI(new OneRing());
//        JOptionPane.showMessageDialog(null, l);
        setUI(new Circleui());
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    
//     public static void main(String[] args) throws Exception {
//        URL urlFG = new URL("http://i.stack.imgur.com/OVOg3.jpg");
//        URL urlBG = new URL("http://i.stack.imgur.com/lxthA.jpg");
//        final BufferedImage biFG = ImageIO.read(urlFG);
//        final BufferedImage biBG = ImageIO.read(urlBG);
//        SwingUtilities.invokeLater(new Runnable(){
//            @Override
//            public void run() {
//                new label(biFG);
//            }
//        });
//    }
}
