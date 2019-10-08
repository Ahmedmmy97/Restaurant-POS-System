/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ahmed
 */
public class CategoriesList {
    private static List<Category> cat = new ArrayList();
    private static List<String> catnames = new ArrayList();
    public static List<Category> getCat() {
        cat.clear();
        try {
            java.sql.Connection con = DriverManager.getConnection(Connection.url,Connection.username,Connection.password);
            
            PreparedStatement stmt = con.prepareStatement("select * from category");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                cat.add(new Category(rs.getInt(1),rs.getString(2)));
            }
            con.close();
        } catch (SQLException e) {
            
        }
        return cat;
    }
     public static List<String> getCatNames() {
        try {
            java.sql.Connection con = DriverManager.getConnection(Connection.url,Connection.username,Connection.password);
            
            PreparedStatement stmt = con.prepareStatement("select * from category");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                catnames.add(rs.getString(2));
            }
            con.close();
        } catch (SQLException e) {
            
        }
        return catnames;
    } 
}
