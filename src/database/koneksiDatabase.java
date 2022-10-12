/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


/**
 *
 * @author waslim
 */
public class koneksiDatabase {
    
    //inisialisasi variabel dg connection file clas JDBC
    private static Connection conn;
    
    private static Properties propert = new Properties();
    
    public static Connection getKoneksi() throws SQLException{
        if(conn == null){
                try {
                    propert.load(new FileInputStream("E:\\DOCUMENT\\materi\\semester 5\\pemrograman dekstop\\uas\\PROJECT UAS PAK KAMAL (1)\\project_uas\\src\\database\\konfigurasiDatabase.properties"));
                } catch (IOException ex) {
                   System.err.println("error mengambil file"+ex);
                   
                   System.err.println("error mengambil file"+ex);
                }
                //inisialisasi koneksi database
                conn = DriverManager.getConnection(propert.getProperty("jdbc.url"),propert.getProperty("jdbc.username"),propert.getProperty("jdbc.password"));
            } 
          return conn;
        }
  
        public static void main(String[] args) throws SQLException {
        if (getKoneksi().equals(conn)){
            System.out.print("sukses terkoneksi ");
        }
    }
}
