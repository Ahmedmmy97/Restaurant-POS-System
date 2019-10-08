/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author ahmed
 */
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ImageIcon;

/**
 *
 * @author ahmed
 */
public class Product {
    private String name;
    private String cat;
   // String filename;
    private double[] price;
    private boolean isSizable;
    private String desc;
    private String imagefile;
    private ImageIcon icon;
    private  String imageType;

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }
    public Product(String name, String cat, double[] price, boolean isSizable, String desc, String imagefile , String imageType) {
        this.name = name;
        this.cat = cat;
        this.price = price;
        this.isSizable = isSizable;
        this.desc = desc;
        this.imagefile = imagefile;
         this.imageType = imageType;
         if(imageType.equals("Default")){
         icon = new ImageIcon(scale(new ImageIcon(getClass().getResource("/images/mango.png")).getImage(),200,200)); 
         }else{
        icon = new ImageIcon(scale(new ImageIcon(new File("images/"+imagefile).getPath()).getImage(),200,200)); 
         }
    }
     public  void Add() throws SQLException{
        
       java.sql.Connection con = DriverManager.getConnection(Models.Connection.url,Models.Connection.username,Models.Connection.password);
        PreparedStatement stmt = con.prepareStatement("insert into food (`Name`, `Cat`, `sPrice`, `mPrice`, `lprice`, `isSizable`, `desc`, `imagefile`, `imageType`) values(?,?,?,?,?,?,?,?,?)");
        stmt.setString(1, name);
        stmt.setString(2, cat);
        stmt.setDouble(3, price[0]);
        stmt.setDouble(4, price[1]);
        stmt.setDouble(5, price[2]);
        stmt.setInt(6, (isSizable) ? 1:0);
        stmt.setString(7, desc);
        stmt.setString(8, imagefile);
        stmt.setString(9, imageType);
        stmt.executeUpdate();
    }
     public  void Update() throws SQLException{
        
       java.sql.Connection con = DriverManager.getConnection(Models.Connection.url,Models.Connection.username,Models.Connection.password);
        PreparedStatement stmt = con.prepareStatement("UPDATE food SET  `sPrice`=?, `mPrice`=?, `lprice`=?, `isSizable`=?, `desc`=?, `imagefile`=?, `imageType`=? WHERE `Name`=? and cat =? ");
        stmt.setString(8, name);
        stmt.setString(9, cat);
        stmt.setDouble(1, price[0]);
        stmt.setDouble(2, price[1]);
        stmt.setDouble(3, price[2]);
        stmt.setInt(4, (isSizable) ? 1:0);
        stmt.setString(5, desc);
        stmt.setString(6, imagefile);
        stmt.setString(7, imageType);
        stmt.executeUpdate();
    }
      public boolean remove() throws SQLException{
        
    java.sql.Connection con = DriverManager.getConnection(Models.Connection.url,Models.Connection.username,Models.Connection.password);
        PreparedStatement stmt = con.prepareStatement("delete from food where name=? and cat = ?");
        stmt.setString(1, name);
        stmt.setString(2, cat);
        stmt.execute();
        return true;
    }
 private Image scale(Image img,int w,int h){
     BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
     Graphics2D gf = image.createGraphics();
     gf.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
     gf.drawImage(img, 0, 0, w,h,null);
     gf.dispose();
     return image;
    }
    public String getName() {
        return name;
    }

    public String getCat() {
        return cat;
    }

    public double[] getPrice() {
        return price;
    }

    public boolean isIsSizable() {
        return isSizable;
    }

    public String getDesc() {
        return desc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public void setPrice(double[] price) {
        this.price = price;
    }

    public void setIsSizable(boolean isSizable) {
        this.isSizable = isSizable;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImagefile() {
        return imagefile;
    }

    public void setImagefile(String imagefile) {
        this.imagefile = imagefile;
    }

    @Override
    public String toString() {
        return  name ;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }
    
}
