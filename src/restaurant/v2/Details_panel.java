/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.v2;

/**
 *
 * @author ahmed
 */
public class Details_panel extends javax.swing.JPanel {

    /**
     * Creates new form text
     */
    public Details_panel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        text = new javax.swing.JLabel();
        value = new javax.swing.JTextField();

        text.setBackground(new java.awt.Color(225, 88, 81));
        text.setFont(new java.awt.Font("Calibri", 1, 17)); // NOI18N
        text.setForeground(new java.awt.Color(255, 255, 255));
        text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        text.setText("SubTotal");
        text.setOpaque(true);

        value.setEditable(false);
        value.setBackground(new java.awt.Color(255, 255, 255));
        value.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        value.setForeground(new java.awt.Color(0, 0, 0));
        value.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        value.setText("0.0");
        value.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(198, 198, 198)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(text, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(value, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(text, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(value, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel text;
    public javax.swing.JTextField value;
    // End of variables declaration//GEN-END:variables
}