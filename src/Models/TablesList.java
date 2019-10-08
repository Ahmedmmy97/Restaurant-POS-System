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
public class TablesList {
   
   public static List<Table> tables= new ArrayList<>();

    public  TablesList() {
        
    }
    public static List<Table> getTables() throws SQLException{
        tables.clear();
        Connection con = DriverManager.getConnection(Models.Connection.url,Models.Connection.username,Models.Connection.password);
        PreparedStatement stmt = con.prepareStatement("select * from tables");
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            tables.add(new Table(rs.getInt(1), rs.getString(2), rs.getString(3)));
        }
        return tables;
    }
    public static List<Table> getAvailableTables() throws SQLException{
        tables.clear();
        Connection con = DriverManager.getConnection(Models.Connection.url,Models.Connection.username,Models.Connection.password);
        PreparedStatement stmt = con.prepareStatement("select * from tables where state='available'");
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            tables.add(new Table(rs.getInt(1), rs.getString(2), rs.getString(3)));
        }
        return tables;
    }
}
