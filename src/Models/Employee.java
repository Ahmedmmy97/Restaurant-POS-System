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

/**
 *
 * @author ahmed
 */
public class Employee {
    private int id;
    private String Name;
    private String username;
    private String password;
    private boolean isSetting;
    private boolean isFood;
    private boolean isTable;
    private boolean isSell;
    public static Employee currentEmployee = new Employee("Admin", null, null, true, true, true, true);
    public Employee(String Name, String username, String password, boolean isSetting, boolean isFood, boolean isTable, boolean isSell) {
        this.Name = Name;
        this.username = username;
        this.password = password;
        this.isSetting = isSetting;
        this.isFood = isFood;
        this.isTable = isTable;
        this.isSell = isSell;
    }
    public void Add() throws SQLException{
        java.sql.Connection con = DriverManager.getConnection(Connection.url,Connection.username,Connection.password);
        PreparedStatement stmt = con.prepareStatement("insert into employees (`name`, `username`, `Password`, `isSetting`, `isFood`, `isTable`, `isSell`) VALUES (?,?,?,?,?,?,?)");
        stmt.setString(1, Name);
        stmt.setString(2, username);
        stmt.setString(3, password);
        stmt.setInt(4, isSetting?1:0);
        stmt.setInt(5, isFood?1:0);
        stmt.setInt(6, isTable?1:0);
        stmt.setInt(7, isSell?1:0);
        stmt.executeUpdate();
    }
    public void update() throws SQLException{
        java.sql.Connection con = DriverManager.getConnection(Connection.url,Connection.username,Connection.password);
        PreparedStatement stmt = con.prepareStatement("update employees set `name`=?, `username`=?, `Password`=?, `isSetting`=?, `isFood`=?, `isTable`=?, `isSell`=? where idemployees=?");
        stmt.setString(1, Name);
        stmt.setString(2, username);
        stmt.setString(3, password);
        stmt.setInt(4, isSetting?1:0);
        stmt.setInt(5, isFood?1:0);
        stmt.setInt(6, isTable?1:0);
        stmt.setInt(7, isSell?1:0);
        stmt.setInt(8, id);
        stmt.executeUpdate();
    }
    public void remove() throws SQLException{
        java.sql.Connection con = DriverManager.getConnection(Connection.url,Connection.username,Connection.password);
        PreparedStatement stmt = con.prepareStatement("delete from employees where idemployees =?");
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }
   
    public boolean isIsSell() {
        return isSell;
    }

    public void setIsSell(boolean isSell) {
        this.isSell = isSell;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIsSetting() {
        return isSetting;
    }

    public void setIsSetting(boolean isSetting) {
        this.isSetting = isSetting;
    }

    public boolean isIsFood() {
        return isFood;
    }

    public void setIsFood(boolean isFood) {
        this.isFood = isFood;
    }

    public boolean isIsTable() {
        return isTable;
    }

    public void setIsTable(boolean isTable) {
        this.isTable = isTable;
    }
    
}
