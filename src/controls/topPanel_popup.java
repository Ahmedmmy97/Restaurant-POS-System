/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ahmed
 */
public class topPanel_popup extends JPanel {
JLabel TableNum;

 private controls.Dispose_button dispose_button1;

    public topPanel_popup(String text) {
        this.text= text;
        add();
         setBackground(new Color(61,59,55));
    }
public topPanel_popup() {
        add();
        setBackground(new Color(61,59,55));
    }
    private String text="Table 1";
    private JFrame previous;
    private JFrame current;
    void add(){
       TableNum = new javax.swing.JLabel();
        dispose_button1 = new controls.Dispose_button();

        setBackground(new java.awt.Color(61, 59, 55));

        TableNum.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        TableNum.setForeground(new java.awt.Color(255, 255, 255));
        TableNum.setText("Table 1");

        dispose_button1.setText("dispose_button1");
        dispose_button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dispose_button1MouseClicked(evt);
            }
        });
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(203, Short.MAX_VALUE)
                .addComponent(TableNum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                .addComponent(dispose_button1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dispose_button1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TableNum))
                .addContainerGap())
        );
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        this.removeAll();
        add();
    }
    private void dispose_button1MouseClicked(java.awt.event.MouseEvent evt) {                                             
        // TODO add your handling code here:
      current.dispose();
      previous.setVisible(true);
      previous.setEnabled(true);
    }    

    

    public void setframes(JFrame current,JFrame previous) {
        this.current = current;
        this.previous=previous;
    }
}
