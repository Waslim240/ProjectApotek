/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.koneksiDatabase;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Rifaldi
 */
public class modelTransaksi {
    String idTrs;
    String tanggalTrs;
    String idObat;
    String namaObat;
    String qty;
    String hargaObat;
    String totalHarga;
    
    koneksiDatabase koneksi = new koneksiDatabase();

    public String getIdTrs() {
        return idTrs;
    }

    public void setIdTrs(String idTrs) {
        this.idTrs = idTrs;
    }

    public String getTanggalTrs() {
        return tanggalTrs;
    }

    public void setTanggalTrs(String tanggalTrs) {
        this.tanggalTrs = tanggalTrs;
    }

    public String getIdObat() {
        return idObat;
    }

    public void setIdObat(String idObat) {
        this.idObat = idObat;
    }

    public String getNamaObat() {
        return namaObat;
    }

    public void setNamaObat(String namaObat) {
        this.namaObat = namaObat;
    }

    public String getHargaObat() {
        return hargaObat;
    }

    public void setHargaObat(String hargaObat) {
        this.hargaObat = hargaObat;
    }

    

    public String getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(String totalHarga) {
        this.totalHarga = totalHarga;
    }

    public koneksiDatabase getKoneksi() {
        return koneksi;
    }

    public void setKoneksi(koneksiDatabase koneksi) {
        this.koneksi = koneksi;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }
    
    
    public void simpanTransaksi(){;
    
    String sql=("insert into transaksi(idTransaksi, idObat, namaObat,qty, hargaObat, totalBayar)"
                        + "value(null,?,?,?,?,?)");
        
    try {
                PreparedStatement eks = koneksi.getKoneksi().prepareStatement(sql);
                
                eks.setString(1, getIdObat());
                eks.setString(2, getNamaObat());
                eks.setString(3, getQty());
                eks.setString(4, getHargaObat());
                eks.setString(5, getTotalHarga());
                eks.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Data Berhasil DiBuat");
        } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Data Gagal DiBuat \n "+ex);

        }
    
    
    }
    
    
    public void deleteTransaksi(){
         String sql = "DELETE FROM transaksi WHERE idTransaksi = "
                 + " '"+getIdTrs()+"' ";
         try {
                PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
                eksekusi.execute();
                
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Data Gagal Dihapus \n "+ex);

        }
     }
    
}
