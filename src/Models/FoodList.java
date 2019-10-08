/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Connection;
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
public class FoodList {
   
   public static List<Product> food= new ArrayList<>();

    public  FoodList() {
        
    }
    public static List<Product> getfood() throws SQLException{
        food.clear();
        Connection con = DriverManager.getConnection(Models.Connection.url,Models.Connection.username,Models.Connection.password);
        PreparedStatement stmt = con.prepareStatement("select * from food");
        ResultSet rs = stmt.executeQuery();
        Boolean isSizable;
        while(rs.next()){
            if(rs.getInt(7)==1)
                isSizable=true;
            else
                isSizable=false;
            double[] price = new double[]{rs.getDouble(4),rs.getDouble(5),rs.getDouble(6)};
            food.add(new Product(rs.getString(2), rs.getString(3),price ,isSizable,rs.getString(8),rs.getString(9),rs.getString(10)));
        }
        return food;
    }
    
}
