/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmembanhang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class DBConnect {
    private static String xServer = "localhost";
    private static String xPort = "1433";
    private static String xDBName = "TungAnh";
    private static String xUser = "sa";
    private static String xPassword = "sa";
    public static Connection getConnection(){
        Connection con = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        String xUrl = "jdbc:sqlserver://"+ xServer+":"+xPort+";databaseName="+xDBName;
        try{
            con = DriverManager.getConnection(xUrl,xUser,xPassword);
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return con;
    }
}
