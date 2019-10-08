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
public class EmployeeList {
    public static List<Employee> employees = new ArrayList<>();
    public static List<Employee> get_employees() throws SQLException{
        employees.clear();
        java.sql.Connection con = DriverManager.getConnection(Connection.url,Connection.username,Connection.password);
        PreparedStatement stmt = con.prepareStatement("select * from employees");
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            Employee e = new Employee(rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)==1 ? true :false, rs.getInt(6)==1 ? true :false, rs.getInt(7)==1 ? true :false, rs.getInt(8)==1 ? true :false);
            e.setId(rs.getInt(1));
            employees.add(e);
        }
        return employees;
    }
   public static boolean check(String username ,String pass) throws SQLException {
        get_employees();
        for(Employee e :employees)
            if(e.getUsername().equals(username)&&e.getPassword().equals(pass)){
                 Employee.currentEmployee = e;
                return true;
            }
            
        return false;
    }
}
