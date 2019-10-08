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
public class Table {

    private int number;
    private String State;
    private String cat;

    public Table(int number, String State, String cat) {
        this.State = State;
        this.number = number;
        this.cat = cat;
    }

    public Table(String State, String cat) throws SQLException {
        this.State = State;
        this.number = getTablenum(cat);
        this.cat = cat;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        this.State = state;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public boolean add() throws SQLException {

        java.sql.Connection con = DriverManager.getConnection(Models.Connection.url, Models.Connection.username, Models.Connection.password);
        PreparedStatement stmt = con.prepareStatement("insert into tables(`num`,`state`,`cat`) values(?,?,?)");
        stmt.setInt(1, number);
        stmt.setString(2, State);
        stmt.setString(3, cat);
        stmt.execute();
        return true;
    }

    public boolean update(int num) throws SQLException {

        java.sql.Connection con = DriverManager.getConnection(Models.Connection.url, Models.Connection.username, Models.Connection.password);
        PreparedStatement stmt = con.prepareStatement("update tables set num = ? where num =? ");
        stmt.setInt(1, num);
        stmt.setInt(2, number);

        stmt.execute();
        number = num;
        return true;
    }

    public boolean remove() throws SQLException {

        java.sql.Connection con = DriverManager.getConnection(Models.Connection.url, Models.Connection.username, Models.Connection.password);
        PreparedStatement stmt = con.prepareStatement("delete from tables where num=? and cat = ?");
        stmt.setInt(1, number);
        stmt.setString(2, cat);
        stmt.execute();
        return true;
    }

    public static int getTablenum(String cat) throws SQLException {
        int id = -1;
        java.sql.Connection con = DriverManager.getConnection(Models.Connection.url, Models.Connection.username, Models.Connection.password);
        PreparedStatement stmt = con.prepareStatement("select max(num) as num from tables where cat = ?");
        stmt.setString(1, cat);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            id = rs.getInt("num");

        }

        return id + 1;
    }

    public boolean isValid() throws SQLException {
        java.sql.Connection con = DriverManager.getConnection(Models.Connection.url, Models.Connection.username, Models.Connection.password);
        PreparedStatement stmt = con.prepareStatement("select * from tables where num=? and cat = ?");
        stmt.setInt(1, number);
        stmt.setString(2, cat.toLowerCase());
        ResultSet rs = stmt.executeQuery();
        int i = rs.getFetchSize();
        if (rs.next()) {
            return false;
        }
        return true;
    }
}
