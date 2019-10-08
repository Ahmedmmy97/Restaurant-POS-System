/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;


import Models.Product;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author ahmed
 */
public class FoodRenderer extends FoodListButton implements ListCellRenderer<Product> {
   
    
 
    @Override
    public Component getListCellRendererComponent(JList<? extends Product> list, Product food, int index,
        boolean isSelected, boolean cellHasFocus) {
        
        
        
        
        setIcon(food.getIcon());
       
        setText(food.toString());
        
       
        
//         if(isSelected)
//             highlightRegion(240, 300);
//        else
//             highlightRegion(0, 0);
        return this;
    }

     
}