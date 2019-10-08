/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author ahmed
 */
public class image_preview extends JLabel {

    public image_preview() {
        setUI(new LabelUI());
        setBackground(new Color(242,242,242));
    }
    
}
