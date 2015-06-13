package com.addressapp;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class DBManager {

    private static final String DBDRIVER = "com.mysql.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost/address_book";
    private static final String DBUSER = "root";
    private static final String DBPASSWORD = "toor";

    static {
        try {
            Class.forName(DBDRIVER);
            System.out.println("Driver Loaded...");
        } catch (Exception ex) {
            System.out.println("Exception - " + ex);
        }
    }
    
    
    
    public static String login(String ContactId, String Passwd) {
       
        String name=null;
        try {
            Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
            PreparedStatement st = con.prepareStatement("Select * from login where ContactId=? and Passwd=password(?)");
            st.setString(1, ContactId);
            st.setString(2, Passwd);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                     
                     name= rs.getString(3);
                    System.out.println(name);             
                 }

            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return name;
    }

     public static boolean changepasswd(String UserName,String passwdold,String passwdnew) {
        boolean status = false;
        try {

            Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
            PreparedStatement st = con.prepareStatement("update login set Passwd=password(?) where ContactId=? AND Passwd=password(?) ");

            st.setString(1, passwdnew);
            st.setString(2, UserName);
            st.setString(3, passwdold);
            st.executeUpdate();
            con.close();
            status = true;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return status;
    }
}
