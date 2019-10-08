/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import Models.Product;
import Models.Table;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author ahmed
 */
public class FoodListButton extends JButton {
    private static final long serialVersionUID = 1L;
        private int start;
        private int end;
    public FoodListButton() {
         super();
        setUI(new FoodListButtonUi());
        //addMouseListener(this);
        //setIcon(new ImageIcon(scale(icon.getImage(), 30, 45)));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
        
        setHorizontalTextPosition(JButton.CENTER);
        setVerticalTextPosition(JButton.BOTTOM);
    }
      public FoodListButton(Product p) {
         super();
        setUI(new FoodListButtonUi());
        //addMouseListener(this);
        //setIcon(new ImageIcon(scale(icon.getImage(), 30, 45)));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
         setIcon( p.getIcon());
           
         setText(p.getName());
          Dimension d = new Dimension(200, 200);
        setPreferredSize(d);
        
        
        setHorizontalTextPosition(JButton.CENTER);
        setVerticalTextPosition(JButton.BOTTOM);
    }
//       @Override
//        public void paint(Graphics g)
//        {
//            
//            
//            g.setColor(new Color(219,58,49));
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
