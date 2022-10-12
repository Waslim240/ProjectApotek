/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.modelTransaksi;
import view.viewTransaksi;

/**
 *
 * @author Rifaldi
 */
public class controllerTransaksi {
    private modelTransaksi mt;
    private viewTransaksi vt;
    
    
    public controllerTransaksi (viewTransaksi vt){
        this.vt= vt;
    }
    
    public void bersihkanTrs(){
        vt.getIdTrs().setText("");
        vt.getTglTrs().setText("");
        vt.getId_barang().setText("");
        vt.getNamaBarang().setText("");
        vt.getHargaObat().setText("");
        vt.getJumlahBeli().setText("");
        vt.getTotalBayar().setText("");
        vt.getStok().setText("");
    }
    
    public void bersihkanObat(){
        vt.getId_barang().setText("");
        vt.getNamaBarang().setText("");
        vt.getHargaObat().setText("");
        vt.getJumlahBeli().setText("");
        vt.getStok().setText("");
    }
    
    public void simpanTrs(){
        mt = new modelTransaksi();
        mt.setIdTrs(vt.getIdTrs().getText());
        mt.setTanggalTrs(vt.getTglTrs().getText());
        mt.setIdObat(vt.getId_barang().getText());
        mt.setNamaObat(vt.getNamaBarang().getText());
        mt.setQty(vt.getJumlahBeli().getText());
        mt.setHargaObat(vt.getHargaObat().getText());
        mt.setTotalHarga(vt.getTotalBayar().getText());
        
        mt.simpanTransaksi();
        bersihkanTrs();
    }
    
    public void hapus(){
       mt = new modelTransaksi();
       mt.setIdTrs(vt.getIdTrs().getText());
       
       mt.deleteTransaksi();
       bersihkanTrs();
    }
    
}


