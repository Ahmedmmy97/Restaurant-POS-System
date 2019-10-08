/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaPrintableArea;
import javax.print.attribute.standard.MediaSize;
import javax.print.attribute.standard.MediaSizeName;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author ahmed
 */
public class Report {

    private int id;
    private int tableNum;
    private String openTime;
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private DateFormat dateFormat1 = new SimpleDateFormat("hh:mm:ss");
    //Date date = new Date();
    private String employee;
    private String state = "opened";
    private double cash = 0;
    private String closeTime = null;
    private String tableType;
    private List<Order> orders = new ArrayList<>();
    private double tax = 0;
    private double service = 0;

    
    private double payed = 0;
    private double user_payed=0;
    private double diff=0;
    
    public double getDiff() {
        return diff;
    }

    public void setDiff(double diff) {
        this.diff = diff;
    }
    public double getUser_payed() {
        return user_payed;
    }

    public void setUser_payed(double user_payed) {
        this.user_payed = user_payed;
    }
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public Report(int id, int tableNum, String tableType, String employee) {
        this.id = id;
        this.tableNum = tableNum;
        this.tableType = tableType;
        this.employee = employee;
        Date date = new Date();
        openTime = dateFormat.format(date);

    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {

        this.cash = cash;
    }

    public int getId() {
        return id;
    }

    public int getTableNum() {
        return tableNum;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getEmployee() {
        return employee;
    }
public  Double getnum(){
        Double num ;
        try{
            String input = JOptionPane.showInputDialog("Enter Cash Payed :") ;
            if(input==null)
                return (double)0;
            num= Double.parseDouble(input);
        
        }catch(Exception e){
             return (double)-1;
        }
      return num;
    }
    public void add_order(Product p, int size, int num) throws SQLException {
        String s;
        if (size == 0) {
            s = "Small";
        } else if (size == 1) {
            s = "Medium";
        } else {
            s = "Large";
        }
        String time = dateFormat1.format(new Date());
        Order order = new Order(OrderList.getOrderNum(), id, p.getName(), s, p.getPrice()[size], num, p.getPrice()[size] * num, time);
        orders.add(order);
        java.sql.Connection con = DriverManager.getConnection(Models.Connection.url, Models.Connection.username, Models.Connection.password);
        PreparedStatement stmt = con.prepareStatement("insert into orders  values(?,?,?,?,?,?,?,?)");
        stmt.setInt(1, order.getId());
        stmt.setInt(2, order.getReportId());
        stmt.setString(3, order.getProduct());
        stmt.setString(4, order.getSize());
        stmt.setDouble(5, order.getTotal());
        stmt.setInt(6, order.getNum());
        stmt.setDouble(7, order.getTotal());
        stmt.setString(8, order.getTime());
        stmt.executeUpdate();
        cash += p.getPrice()[size] * num;
        settax_service();
        update_report();
    }

    public void Remove_order(int order_num) throws SQLException {
        int id = orders.get(order_num).getId();
        java.sql.Connection con = DriverManager.getConnection(Models.Connection.url, Models.Connection.username, Models.Connection.password);
        PreparedStatement stmt = con.prepareStatement("delete from orders  where idorders = ?");
        stmt.setInt(1, id);
        stmt.executeUpdate();
        cash -= orders.get(order_num).getTotal();
        orders.remove(order_num);
        settax_service();
        update_report();
    }

    private void settax_service() {
        DecimalFormat newFormat = new DecimalFormat("#.##");
        tax = Double.valueOf(newFormat.format(0.01 * cash));

        switch (tableType) {
            case "normal":
                service = Double.valueOf(newFormat.format(0.02 * cash));
                break;
            case "family":
                service = Double.valueOf(newFormat.format(0.05 * cash));
                break;
            case "couple":
                service = Double.valueOf(newFormat.format(0.10 * cash));
                break;
            case "vip":
                service = Double.valueOf(newFormat.format(0.20 * cash));
                break;

        }
        payed = cash + tax + service;

        payed = Double.valueOf(newFormat.format(payed));
    }

    public void add_report() throws SQLException {
        java.sql.Connection con = DriverManager.getConnection(Models.Connection.url, Models.Connection.username, Models.Connection.password);
        PreparedStatement stmt = con.prepareStatement("insert into report values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
        stmt.setInt(1, id);
        stmt.setInt(2, tableNum);
        stmt.setString(3, openTime);
        stmt.setString(4, employee);
        stmt.setDouble(5, cash);
        stmt.setString(6, state);
        stmt.setNull(7, Types.VARCHAR);
        stmt.setString(8, tableType);
        stmt.setDouble(9, service);
        stmt.setDouble(10, tax);
        stmt.setDouble(11, payed);
        stmt.setDouble(12, user_payed);
        stmt.setDouble(13, diff);
        stmt.executeUpdate();
        stmt = con.prepareStatement("update tables set state='Reserved' where num=? and cat=?");
        stmt.setInt(1, tableNum);
        stmt.setString(2, tableType);
        stmt.executeUpdate();
    }

    private void update_report() throws SQLException {
        java.sql.Connection con = DriverManager.getConnection(Models.Connection.url, Models.Connection.username, Models.Connection.password);
        PreparedStatement stmt = con.prepareStatement("update report set cash = ? , service =? ,tax=?,payed =? where idreport = ?");
        stmt.setInt(5, id);
        stmt.setDouble(1, cash);
        stmt.setDouble(2, service);
        stmt.setDouble(3, tax);
        stmt.setDouble(4, payed);
        stmt.executeUpdate();

    }
    private void update_report_table() throws SQLException {
        java.sql.Connection con = DriverManager.getConnection(Models.Connection.url, Models.Connection.username, Models.Connection.password);
        PreparedStatement stmt = con.prepareStatement("update report set tablenum = ? , tabletype =? where idreport = ?");
        stmt.setInt(3, id);
        stmt.setInt(1, tableNum);
        stmt.setString(2, tableType);
        stmt.executeUpdate();
        stmt = con.prepareStatement("update tables set state='Reserved' where num=? and cat=?");
        stmt.setInt(1, tableNum);
        stmt.setString(2, tableType);
        stmt.executeUpdate();
    }
    public boolean close_report() throws SQLException {
         user_payed=getnum();
        while(user_payed<0){
        user_payed= getnum();
      } 
        if(user_payed==0)
            return false;
        if(user_payed<payed){
        JOptionPane.showMessageDialog(null, "Payed cash is less than needed!","Error",JOptionPane.ERROR_MESSAGE);
        return false;
        }
         DecimalFormat newFormat = new DecimalFormat("#.##");
        diff = Double.valueOf(newFormat.format(user_payed-payed));
        java.sql.Connection con = DriverManager.getConnection(Models.Connection.url, Models.Connection.username, Models.Connection.password);
        PreparedStatement stmt = con.prepareStatement("update report set state = 'closed' , closeTime=?,customer_payed =? ,diff =? where idreport = ?");
        Date date = new Date();
        closeTime = dateFormat.format(date);
        stmt.setString(1, closeTime);
        stmt.setDouble(2, user_payed);
        stmt.setDouble(3, diff);
        stmt.setInt(4, id);
        stmt.executeUpdate();
        stmt = con.prepareStatement("update tables set state='available' where num=? and cat=?");
        stmt.setInt(1, tableNum);
        stmt.setString(2, tableType);
        stmt.executeUpdate();
         print();
         return true;
    }

    public void switch_table(int tableNum, String tableCat) throws SQLException {
        java.sql.Connection con = DriverManager.getConnection(Models.Connection.url, Models.Connection.username, Models.Connection.password);
        PreparedStatement stmt = con.prepareStatement("update tables set state='available' where num=? and cat=?");
        stmt.setInt(1, this.tableNum);
        stmt.setString(2, this.tableType);
        stmt.executeUpdate();
        this.tableNum = tableNum;
        this.tableType = tableCat;
        update_report_table();
        
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getService() {
        return service;
    }

    public void setService(double service) {
        this.service = service;
    }

    public double getPayed() {
        return payed;
    }

    public void setPayed(double payed) {
        this.payed = payed;
    }

    public void remove_report() throws SQLException {
        java.sql.Connection con = DriverManager.getConnection(Models.Connection.url, Models.Connection.username, Models.Connection.password);
        PreparedStatement stmt = con.prepareStatement("delete from report where idreport = ?");
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt = con.prepareStatement("delete from orders where reportid = ?");
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt = con.prepareStatement("update tables set state='available' where num=? and cat=?");
        stmt.setInt(1, tableNum);
        stmt.setString(2, tableType);
        stmt.executeUpdate();
    }

    public String getTableType() {
        return tableType;
    }

    public void setTableType(String tableType) {
        this.tableType = tableType;
    }
     void print() {

        try {

            Map parameters = new HashMap();
            /**
             * Passing ReportTitle and Author as parameters
             */
          
            parameters.put("id", id);
            parameters.put("Image", getClass().getResource("/images/logo.png"));
           
            
            JasperPrint jp = null;

            // TODO code application logic here
             java.sql.Connection con = DriverManager.getConnection(Models.Connection.url, Models.Connection.username, Models.Connection.password);

            //JasperReport jr =JasperCompileManager.compileReport(path);
            jp = JasperFillManager.fillReport(getClass().getResource("report1.jasper").openStream(), parameters, con);
            JasperViewer.viewReport(jp, false);

            PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
            MediaSizeName mediaSizeName = MediaSize.findMedia(4, 4, MediaPrintableArea.INCH);
            printRequestAttributeSet.add(mediaSizeName);
            printRequestAttributeSet.add(new Copies(1));
            JRPrintServiceExporter exporter;
            exporter = new JRPrintServiceExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
             exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
            // exporter.exportReport();
            con.close();
        } catch (SQLException | JRException | IOException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
