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
public class ReportList {
     public static List<Report> reports= new ArrayList<>();
     public static List<Report> getreports() throws SQLException{
        reports.clear();
        java.sql.Connection con = DriverManager.getConnection(Models.Connection.url,Models.Connection.username,Models.Connection.password);
        PreparedStatement stmt = con.prepareStatement("select * from report");
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            Report r = new Report(rs.getInt(1), rs.getInt(2),rs.getString(8),rs.getString(4));
            r.setCash(rs.getDouble(5));
            r.setOpenTime(rs.getString(3));
            r.setState(rs.getString(6));
            r.setCloseTime(rs.getString(7));
            r.setService(rs.getDouble(9));
            r.setTax(rs.getDouble(10));
            r.setPayed(rs.getDouble(11));
            r.setUser_payed(rs.getDouble(12));
            r.setDiff(rs.getDouble(13));
            r.setOrders(OrderList.getOrders(r.getId()));
            
            reports.add(r);
            
        }
        return reports;
    }
     public static Report getreport(int id) throws SQLException{
        Report r = null;
        java.sql.Connection con = DriverManager.getConnection(Models.Connection.url,Models.Connection.username,Models.Connection.password);
        PreparedStatement stmt = con.prepareStatement("select * from report where idreport = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            
            r=new Report(rs.getInt(1), rs.getInt(2),rs.getString(8),rs.getString(4));
            r.setCash(rs.getDouble(5));
            r.setOpenTime(rs.getString(3));
            r.setState(rs.getString(6));
            r.setCloseTime(rs.getString(7));
            r.setService(rs.getDouble(9));
            r.setTax(rs.getDouble(10));
            r.setPayed(rs.getDouble(11));
            r.setUser_payed(rs.getDouble(12));
            r.setDiff(rs.getDouble(13));
            r.setOrders(OrderList.getOrders(r.getId()));
        }
        
        return r;
    }
     public static Report getreportbytable(int tableNum) throws SQLException{
        Report r = null;
        java.sql.Connection con = DriverManager.getConnection(Models.Connection.url,Models.Connection.username,Models.Connection.password);
        PreparedStatement stmt = con.prepareStatement("select * from report where tablenum = ? and state = 'opened'");
        stmt.setInt(1, tableNum);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            
            r=new Report(rs.getInt(1), rs.getInt(2),rs.getString(8),rs.getString(4));
            r.setCash(rs.getDouble(5));
            r.setOpenTime(rs.getString(3));
            r.setState(rs.getString(6));
            r.setCloseTime(rs.getString(7));
            r.setService(rs.getDouble(9));
            r.setTax(rs.getDouble(10));
            r.setPayed(rs.getDouble(11));
            r.setUser_payed(rs.getDouble(12));
            r.setDiff(rs.getDouble(13));
            r.setOrders(OrderList.getOrders(r.getId()));
        }
        
        return r;
    }
      public static int getreportnumber() throws SQLException{
        int id=-1;
        java.sql.Connection con = DriverManager.getConnection(Models.Connection.url,Models.Connection.username,Models.Connection.password);
        PreparedStatement stmt = con.prepareStatement("select max(idreport) as id from report");
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            id = rs.getInt("id");
            
        }
        
        return id+1;
    }
}
