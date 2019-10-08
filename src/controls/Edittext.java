/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author ahmed
 */
public class Edittext extends JTextField implements FocusListener{
   String temptext;
    public Edittext() {
        setBorder(new LineBorder(Color.BLACK));
        setBackground(new Color(255,255,255));
        setForeground(new Color(246,207,205));
        addFocusListener(this);
        setHorizontalAlignment(SwingConstants.CENTER);
    }

    public Edittext(String string) {
        super(string);
        setBorder(new LineBorder(Color.BLACK));
        setBackground(new Color(255,255,255));
        setForeground(new Color(246,207,205));
        addFocusListener(this);
    }

    

    @Override
    public void focusGained(FocusEvent fe) {
        Color temp = new Color(246,207,205);
        if(getForeground().equals(temp)){
            temptext = getText();
            setText("");
            setForeground(new Color(219,58,49));
        }
       
    }

    @Override
    public void focusLost(FocusEvent fe) {
       if(getText().equals("")){
        setForeground(new Color(246,207,205));
           setText(temptext);
       }
    }
    
}
