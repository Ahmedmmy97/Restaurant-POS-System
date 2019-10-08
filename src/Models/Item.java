/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TableView;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author ahmed
 */
public class Item {
    private ImageIcon icon ;
    private String text;

   
public Item(String text) {
        
        this.text = text;
         
        URL path = getClass().getResource("/images/"+text.toLowerCase()+".png");
        System.out.println(path);
        try {
            this.icon = new ImageIcon(path);
        } catch (Exception ex) {
           this.icon =null;
        }
        
    }
    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
