/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.koneksiDatabase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author waslim
 */
public class modelLogin {
    private String username;
    private String password;
    private String hakAkses;

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

    public String getHakAkses() {
        return hakAkses;
    }

    public void setHakAkses(String hakAkses) {
        this.hakAkses = hakAkses;
    }
  
    
    public ResultSet getDataUser(){
            String sql = "SELECT * FROM user WHERE username='" + getUsername() + "' AND password='" + getPassword() + "'";
            Statement stat;
            ResultSet res = null;
            try {
                stat = koneksiDatabase.getKoneksi().createStatement();
                res = stat.executeQuery(sql);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Gagal Login \n" + e);
            }
            return res;
        }
}    
    
