/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author ahmed
 */
public class Mytable extends JTable{

    public Mytable() {
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setCellSelectionEnabled(false);
        setColumnSelectionAllowed(false);
        setRowSelectionAllowed(true);
        setRowHeight(40);
        //setRowMargin(3);
        setShowVerticalLines(false);
        setShowHorizontalLines(false);
        setRowMargin(0);
        setShowGrid(false);
        setIntercellSpacing(new Dimension(0, 0));
        setBorder(null);
    }

    
    

    


    @Override
    protected JTableHeader createDefaultTableHeader() {
          JTableHeader header = super.createDefaultTableHeader(); //To change body of generated methods, choose Tools | Templates.
          header.setBackground(new Color(61,59,55)); //3D3B37
          header.setFont(new Font("Calibri", Font.BOLD, 17));
          header.setForeground(Color.white);
          
          return header;
    }
    
 
    @Override
    public Component prepareRenderer(TableCellRenderer tcr, int i, int i1) {
        Component comp = super.prepareRenderer(tcr, i, i1);
       
           ((DefaultTableCellRenderer) tcr).setHorizontalAlignment(JLabel.CENTER);
           ((DefaultTableCellRenderer) tcr).setVerticalAlignment(JLabel.CENTER);
           this.getColumnModel().getColumn(i1).setHeaderRenderer(new tableheader());
           
           if(i%2==0 && !this.isCellSelected(i, i1))
               comp.setBackground(new Color(203, 203, 203));
           else if(!this.isCellSelected(i, i1))
               comp.setBackground(new Color(231, 231, 231));
           else
               comp.setBackground(new Color(85, 173, 211));
        
        comp.setPreferredSize(new Dimension(100,30));
        ((JComponent)comp).setBorder(BorderFactory.createLineBorder(Color.white,1));
        setCellSelectionEnabled(false);
        setColumnSelectionAllowed(false);
        setRowSelectionAllowed(true);
         return comp;
    }

  

   
    
}
