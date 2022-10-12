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
 * @author waslim
 */
public class modelObat {
    String idObat;
    String namaObat;
    String jenisObat;
    String dosisObat;
    String tanggalEx;
    String stokObat;
    String kegunaanObat;
    int hargaObat;
    
    koneksiDatabase koneksi = new koneksiDatabase();
    public modelObat() {
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

    public String getJenisObat() {
        return jenisObat;
    }

    public void setJenisObat(String jenisObat) {
        this.jenisObat = jenisObat;
    }

    public String getStokObat() {
        return stokObat;
    }

    public void setStokObat(String stokObat) {
        this.stokObat = stokObat;
    }

    public int getHargaObat() {
        return hargaObat;
    }

    public void setHargaObat(int hargaObat) {
        this.hargaObat = hargaObat;
    }

    public String getDosisObat() {
        return dosisObat;
    }

    public void setDosisObat(String dosisObat) {
        this.dosisObat = dosisObat;
    }

    public String getTanggalEx() {
        return tanggalEx;
    }

    public void setTanggalEx(String tanggalEx) {
        this.tanggalEx = tanggalEx;
    }

    public String getKegunaanObat() {
        return kegunaanObat;
    }

    public void setKegunaanObat(String kegunaanObat) {
        this.kegunaanObat = kegunaanObat;
    }


   
    
    public void simpanDataObat(){;
    
    String sql = ("INSERT INTO obat(namaObat, jenisObat, dosisObat, tanggalEx, stokObat, kegunaanObat, hargaObat)"
            + " VALUES ('"+getNamaObat()+"', '"+getJenisObat()+"', '"+getDosisObat()+"', '"+getTanggalEx()+"'"
            + ",'"+getStokObat()+"', '"+getKegunaanObat()+"', '"+getHargaObat()+"')");
        
    try {
                PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
                eksekusi.execute();
                
                JOptionPane.showMessageDialog(null, "Data Berhasil DiBuat");
        } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Data Gagal DiBuat \n "+ex);

        }
    
    
    }
    
    
     public void deleteDataObat(){
         String sql = "DELETE FROM obat WHERE idObat = "
                 + " '"+getIdObat()+"' ";
         try {
                PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
                eksekusi.execute();
                
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Data Gagal Dihapus \n "+ex);

        }
     }
    
     public void updateDataObat(){;
    
     String sql = "UPDATE obat SET namaObat ='"+getNamaObat()+"'"
             + " ,jenisObat = '"+getJenisObat()+"'"
             + " ,dosisObat = '"+getDosisObat()+"'"
             + " ,tanggalEx = '"+getTanggalEx()+"'"
             + " ,stokObat = '"+getStokObat()+"'"
             + " ,kegunaanObat = '"+getKegunaanObat()+"'"
             + " ,hargaObat = '"+getHargaObat()+"' WHERE idObat = '"+getIdObat()+"'";
     try {
                PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
                eksekusi.execute();
                
                JOptionPane.showMessageDialog(null, "Data Berhasil DiUpdate");
        } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Data Gagal DiUpdate \n "+ex);

        }
    
    
    }
}
