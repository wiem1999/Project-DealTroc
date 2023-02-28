/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author ASUS
 */
public class MyConnection {
     public static MyConnection instance;


    Connection conn ; 
    String url ="jdbc:mysql://localhost:3306/dealtroc";
    String user ="root" ;
    String pwd="" ;
            
            
public MyConnection () {
                
                try {
                    
                   conn = (Connection) DriverManager.getConnection(url , user , pwd );
                   
                   System.out.println ("Connexion etablie !");
                }
                
                catch(SQLException ex)
                
                {
                    System.out.println ("Probleme de connexion");
                }
                
       
 }
    public static MyConnection getInstance()
    {
        if(instance == null)
        {
            instance = new MyConnection();
        }
        return instance ;
    }
    public Connection getConn()
    {
        return conn ;
    }
}
