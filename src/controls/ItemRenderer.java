/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import Models.Item;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author ahmed
 */
public class ItemRenderer extends Item_label implements ListCellRenderer<Item> {
   
    
 
    @Override
    public Component getListCellRendererComponent(JList<? extends Item> list, Item item, int index,
        boolean isSelected, boolean cellHasFocus) {
        
        ImageIcon imageIcon ;
        
        
        if(item.getIcon()!=null)
        setIcon(item.getIcon());
       
        setText(item.getText());
        setHorizontalTextPosition(JLabel.TRAILING);
        setVerticalTextPosition(JLabel.CENTER);
        
        
         if(isSelected)
             highlightRegion(300, 100);
         else
             highlightRegion(0, 0);
        return this;
    }

     
}