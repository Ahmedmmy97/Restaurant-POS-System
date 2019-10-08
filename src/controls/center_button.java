/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/**
 *
 * @author ahmed
 */
public class center_button extends JButton implements MouseListener{
   //ImageIcon icon= new ImageIcon(getClass().getResource("close.png"));
   int i=0;
    public center_button() {
        super();
        setUI(new CenterButtonUI());
        
        //setIcon(new ImageIcon(scale(icon.getImage(), 30, 45)));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setSize(60, 38);
        setText("");
        addMouseListener(this);
    }
   
    public center_button(String text) {
        super(text);
        setText(text);
        setUI(new CenterButtonUI());
        
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        //this.icon=icon;
        setSize(60, 38);
        //setIcon(new ImageIcon(scale(icon.getImage(),30, 45)));
        addMouseListener(this);
    }
    
   

//    @Override
//    public void setSize(int i, int i1) {
//           super.setSize(i, i1);
////           ImageIcon  imageIcon = (ImageIcon)getIcon();
////           if(imageIcon!=null)
////           setIcon(new ImageIcon(scale(imageIcon.getImage(),30, 45)));
//           
//           //To change body of generated methods, choose Tools | Templates.
//        
//            
//    }

    @Override
    public void mouseClicked(MouseEvent me) {
       //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent me) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
         //To change body of generated methods, choose Tools | Templates.
    }
     
    @Override
    public void mouseEntered(MouseEvent me) {
        //To change body of generated methods, choose Tools | Templates.
        Mouse_in(me);
      
    }

    @Override
    public void mouseExited(MouseEvent me) {
         Mouse_out(me);
    }
private void Mouse_in(java.awt.event.MouseEvent evt) {
        setForeground(getBackground().darker());
        
    }

    private void Mouse_out(java.awt.event.MouseEvent evt) {                                    
        setForeground(Color.white);
    }                  
    
}
