/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.modelObat;
import view.viewObat;

/**
 *
 * @author waslim
 */
public class controllerObat {
    private modelObat mO;
    private viewObat vO;

    public controllerObat(viewObat vO) {
        this.vO = vO;
    }
    
    public void bersihkan(){
        vO.getIdObat().setText("");
        vO.getNamaObat().setText("");
        vO.getJenisObat().setText("");
        vO.getDosisObat().setText("");
        vO.getTglExp().setText("");
        vO.getStokObat().setText("");
        vO.getKgnObat().setText("");
        vO.getHargaObat().setText("");
    }
    
    public void kontrolButton(){
        vO.getTambah().setEnabled(true);
        vO.getUbah().setEnabled(false);
        vO.getDelete().setEnabled(false);
        vO.getBatal().setEnabled(true);
        
    }
    
     public void kontrolButtonDua(){
        vO.getTambah().setEnabled(false);
        vO.getUbah().setEnabled(true);
        vO.getDelete().setEnabled(true);
        vO.getBatal().setEnabled(true);
        
    }
    
    public void deleteData(){
       mO = new modelObat();
       mO.setIdObat(vO.getIdObat().getText());
       
       mO.deleteDataObat();
       bersihkan();
       kontrolButton();
    }
     
     
     public void updateData(){
       mO = new modelObat();
       mO.setIdObat(vO.getIdObat().getText());
       mO.setNamaObat(vO.getNamaObat().getText());
       mO.setJenisObat(vO.getJenisObat().getText());
       mO.setDosisObat(vO.getDosisObat().getText());
       mO.setTanggalEx(vO.getTglExp().getText());
       mO.setStokObat(vO.getStokObat().getText());
       mO.setKegunaanObat(vO.getKgnObat().getText());
       mO.setHargaObat(Integer.parseInt(vO.getHargaObat().getText()));
       
       mO.updateDataObat();
       bersihkan();
       kontrolButton();
     }
     
    public void simpan(){
       mO = new modelObat();
       mO.setIdObat(vO.getIdObat().getText());
       mO.setNamaObat(vO.getNamaObat().getText());
       mO.setJenisObat(vO.getJenisObat().getText());
       mO.setDosisObat(vO.getDosisObat().getText());
       mO.setTanggalEx(vO.getTglExp().getText());
       mO.setStokObat(vO.getStokObat().getText());
       mO.setKegunaanObat(vO.getKgnObat().getText());
       mO.setHargaObat(Integer.parseInt(vO.getHargaObat().getText()));
       
       mO.simpanDataObat();
       bersihkan();
    }
}
