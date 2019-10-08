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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author ahmed
 */
public class Passwordfield extends JPasswordField implements FocusListener{
   String temptext;
    public Passwordfield() {
        setBorder(new LineBorder(Color.BLACK));
        setBackground(new Color(255,255,255));
        setForeground(new Color(246,207,205));
        addFocusListener(this);
        setSize(166, 31);
        setEchoChar('•');
        setHorizontalAlignment(SwingConstants.CENTER);
    }

    public Passwordfield(String string) {
        super(string);
        setBorder(new LineBorder(Color.BLACK));
        setBackground(new Color(255,255,255));
        setForeground(new Color(246,207,205));
        addFocusListener(this);
        setSize(166, 31);
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
