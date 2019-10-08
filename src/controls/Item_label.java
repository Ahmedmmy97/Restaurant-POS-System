/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import javax.swing.JLabel;

/**
 *
 * @author ahmed
 */
public class Item_label extends JLabel {
     private static final long serialVersionUID = 1L;
        private int start;
        private int end;

    public Item_label() {
        setUI(new ItemUi());
        setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
    }

        @Override
        public void paint(Graphics g)
        {
            
            
            g.setColor(new Color(219,58,49));
            g.fillRect(0, 5, start, end-40);

            super.paint(g);
        }

        public void highlightRegion(int start, int end)
        {
            this.start = start;
            this.end = end;
        }

    }

