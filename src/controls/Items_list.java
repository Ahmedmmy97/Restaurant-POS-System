/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;


import Models.Item;
import java.awt.Cursor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author ahmed
 */
public class Items_list extends JList<Item> {
    DefaultListModel<Item> listModel = new DefaultListModel<>();
   public Items_list(int num) {
         List<Item> items = new ArrayList<>();
        for(int i=1;i<=num;i++){
         items.add(new Item("picture1"));
        }
       
        for(Item i :items)
            listModel.addElement(i);
        setModel(listModel);
        setLayoutOrientation(JList.HORIZONTAL_WRAP);
        setVisibleRowCount(-1);
        
        
        //create the list
        setOpaque(false);
        setCellRenderer(new ItemRenderer());
        setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
    }
    
    

    public Items_list() {
         List<Item> items = new ArrayList<>();
        for(int i=1;i<=1;i++){
         items.add(new Item("picture1"));
        }
       
        for(Item i :items)
            listModel.addElement(i);
        setModel(listModel);
        setLayoutOrientation(JList.HORIZONTAL_WRAP);
        setVisibleRowCount(-1);
        
        
        //create the list
        setOpaque(false);
        setCellRenderer(new ItemRenderer());
        setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
    }
}
