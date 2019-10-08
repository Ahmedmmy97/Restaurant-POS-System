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
public class OrderList {
    private static List<Order> orders = new ArrayList<>();
    public static List<Order> getOrders(int id) throws SQLException{
     orders.clear();
        java.sql.Connection con = DriverManager.getConnection(Models.Connection.url,Models.Connection.username,Models.Connection.password);
        PreparedStatement stmt = con.prepareStatement("select * from orders where reportid = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            Order o = new Order( rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getInt(6),rs.getDouble(7),rs.getString(8));
            
           
            orders.add(o);
        }
        return orders;
    }
     public static int getOrderNum() throws SQLException{
        int id=-1;
        java.sql.Connection con = DriverManager.getConnection(Models.Connection.url,Models.Connection.username,Models.Connection.password);
        PreparedStatement stmt = con.prepareStatement("select max(idorders) as id from orders");
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            id = rs.getInt("id");
            
        }
        
        return id+1;
    }
}
