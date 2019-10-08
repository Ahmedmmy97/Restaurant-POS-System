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
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author ahmed
 */
public class tableheader extends JLabel implements TableCellRenderer{

//    @Override
//    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
//        Component c = super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1); //To change body of generated methods, choose Tools | Templates.
//         JLabel jl = (JLabel) c;
//            jl.setHorizontalAlignment(SwingConstants.CENTER);
//            jl.setBackground(Color.yellow);
//            
//        return c;
//    }
    public tableheader() {
        setBackground(new Color(0,0,0));
        setFont(new Font("Calibri", Font.BOLD, 17));
        setForeground(Color.white);
        setBorder(BorderFactory.createLineBorder(Color.white));
        setHorizontalAlignment(JLabel.CENTER);
        setVerticalAlignment(JLabel.CENTER);
        setPreferredSize(new Dimension(100, 40));
        
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
        this.setText(o.toString());
        
        
        return this;
    }
   
}
