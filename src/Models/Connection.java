/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ahmed
 */
public class Connection {
   public static  String url = "jdbc:mysql://127.0.0.1:3306/restaurant";
  public static  String username = "root";
  public static  String password = "root";
  static BufferedWriter out;
  public static void updateConnection(){
   
        
        try {
           // JOptionPane.showMessageDialog(this, "fisrt");
            File file = new File ("jU.jar");
            out = new BufferedWriter(new FileWriter(file));
            out.write(username);
            out.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
        try {
           // JOptionPane.showMessageDialog(this, "fisrt");
            File file = new File ("jP.jar");
            out = new BufferedWriter(new FileWriter(file));
            out.write(password);
            out.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        } 
  }
    public static void getConnection(){
   
        
      
        try {
            BufferedReader reader = new BufferedReader(new FileReader("jU.jar"));
            username = reader.readLine();
            reader = new BufferedReader(new FileReader("jP.jar"));
            password = reader.readLine();
        } catch (Exception e) {
            System.err.format("Exception occurred trying to read '%s'.", "user.txt");

        }
  }
}
