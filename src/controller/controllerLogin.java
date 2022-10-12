/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import appUtama.menuUtama;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.modelLogin;
import view.viewLogin;

/**
 *
 * @author waslim
 */
public class controllerLogin {
    modelLogin mL;
    viewLogin vL;
    public controllerLogin(viewLogin vL){
        this.vL = vL;
    }
    
    public void bersih(){
        vL.getUsername().setText("");
        vL.getPassword().setText("");
    }
    
    public void login(){
        mL = new modelLogin();
        mL.setUsername(vL.getUsername().getText());
        mL.setPassword(vL.getPassword().getText());
        Object[] hasil;
        hasil = new Object[1];
        ResultSet res = mL.getDataUser();
        try{
            if(res.next()){
                hasil[0] = res.getString("hakAkses");
                if(vL.getUsername().getText().equals(res.getString("username")) && 
                        vL.getPassword().getText().equals(res.getString("password"))){
                    
                    JOptionPane.showMessageDialog(vL, "Login Berhasil");
                    if(hasil[0].equals("pemilik")){
                        vL.setVisible(false);
                        menuUtama utama = new menuUtama();
                        utama.setVisible(true);                        
                    } 

                }
                }else{
                    JOptionPane.showMessageDialog(vL, "username atau password salah");
                }
        }catch (SQLException e){

        }
    }


}
    
