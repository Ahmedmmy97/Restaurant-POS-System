/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;


import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import Models.Table;

/**
 *
 * @author ahmed
 */
public class TableListButton extends JButton{
private static final long serialVersionUID = 1L;
        private int start;
        private int end;
    public TableListButton() {
         super();
        setUI(new TableListButtonUI());
        //addMouseListener(this);
        //setIcon(new ImageIcon(scale(icon.getImage(), 30, 45)));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
        
        setHorizontalTextPosition(JButton.CENTER);
        setVerticalTextPosition(JButton.BOTTOM);
    }
     public TableListButton(Table t) {
         super();
        setUI(new TableListButtonUI());
        //addMouseListener(this);
        //setIcon(new ImageIcon(scale(icon.getImage(), 30, 45)));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        if(t.getState().equalsIgnoreCase("available"))
        setIcon( new ImageIcon(getClass().getResource("/images/back.png"))); 
       else 
       setIcon( new ImageIcon(getClass().getResource("/images/back_res.png")));
           
         setText(t.toString());
        
        setHorizontalTextPosition(JButton.CENTER);
        setVerticalTextPosition(JButton.BOTTOM);
    }
//       @Override
//        public void paint(Graphics g)
//        {
//            
//            
//            g.setColor(new Color(0x33, 0x66, 0xFF, 0x66));
//            g.fillRect(0, 0, start, end);
//
//            super.paint(g);
//        }
//        
//        public void highlightRegion(int start, int end)
//        {
//            this.start = start;
//            this.end = end;
//        }
}
