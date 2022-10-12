/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.mysql.jdbc.Statement;
import controller.controllerTransaksi;
import database.koneksiDatabase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author waslim
 */


public class viewTransaksi extends javax.swing.JInternalFrame {
    private controller.controllerTransaksi ct;
    private DefaultTableModel tabel,tabel2;
    private String sql = "";
    

    /**
     * Creates new form viewTransaksi
     */
    public viewTransaksi() {
        initComponents();
        ct = new controllerTransaksi(this);
        tabelTransaksi();
        tabelObat();
        tampilDataObat("");
        tampilDataTransaksi("");
        
    }

    public JTextField getCari() {
        return Cari;
    }

    public JButton getBbatalTransaksi() {
        return bbatalTransaksi;
    }

    public JButton getBprosesTransaksi() {
        return bprosesTransaksi;
    }

    public JTextField getHargaObat() {
        return hargaObat;
    }

    public JTextField getIdTrs() {
        return idTrs;
    }

    public JTextField getId_barang() {
        return id_barang;
    }

    public JLabel getJ() {
        return j;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public JLabel getjLabel10() {
        return jLabel10;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public JLabel getjLabel7() {
        return jLabel7;
    }

    public JLabel getjLabel8() {
        return jLabel8;
    }

    public JLabel getjLabel9() {
        return jLabel9;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public JPanel getjPanel3() {
        return jPanel3;
    }

    public JPanel getjPanel4() {
        return jPanel4;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public JScrollPane getjScrollPane3() {
        return jScrollPane3;
    }

    public JTable getjTable2() {
        return jTable2;
    }

    

    public JTextField getJumlahBeli() {
        return jumlahBeli;
    }

    public JTextField getNamaBarang() {
        return namaBarang;
    }

    public JTable getTabelBarang() {
        return tabelBarang;
    }

    public JTable getTabelTransaksi() {
        return tabelTransaksi;
    }

    public JTextField getTglTrs() {
        return tglTrs;
    }

    public JTextField getTotalBayar() {
        return totalBayar;
    }

    public JTextField getStok() {
        return stok;
    }

    
    
    
    
    

    public void tabelObat(){
        tabel = new DefaultTableModel();
        tabelBarang.setModel(tabel);
        tabel.addColumn("Id Obat");
        tabel.addColumn("Nama Obat");
        tabel.addColumn("Harga Obat");
        tabel.addColumn("Stok");
    }
    
    public void tabelTransaksi(){
        tabel2 = new DefaultTableModel();
        tabelTransaksi.setModel(tabel2);
        tabel2.addColumn("Id Transaksi");
        tabel2.addColumn("Tanggal Transaksi");
        tabel2.addColumn("Id Obat");
        tabel2.addColumn("Nama Obat");
        tabel2.addColumn("Qty Beli");
        tabel2.addColumn("Harga Obat");
        tabel2.addColumn("Total Harga");
    }
    
    public void tampilDataObat(String data){
        tabel.getDataVector().removeAllElements();
        tabel.fireTableDataChanged();
        
        if(data.equals("")){
            sql = "select * from obat";
        }else sql = "select * from obat where namaObat LIKE '"+data+"%'";
        
        try {
            Statement stat = (Statement) koneksiDatabase.getKoneksi().createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()){
                Object[] hasil;
                hasil = new Object[8];
                hasil[0] = res.getString("idObat");
                hasil[1] = res.getString("namaObat");
                hasil[2] = res.getString("hargaObat");
                hasil[3] = res.getInt("stokObat");
                
                tabel.addRow(hasil);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(viewObat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void ambilDataObat(){
        int index = tabelBarang.getSelectedRow();
        String idObat = String.valueOf(tabelBarang.getValueAt(index, 0));
        String namaObat = String.valueOf(tabelBarang.getValueAt(index, 1));
        int hargaObat = Integer.parseInt(String.valueOf(tabelBarang.getValueAt(index, 2)));
        int stok1 = Integer.parseInt(String.valueOf(tabelBarang.getValueAt(index, 3)));
        
        
        this.id_barang.setText(idObat);
        this.namaBarang.setText(namaObat);
        this.hargaObat.setText(String.valueOf(hargaObat));
        stok.setText(String.valueOf(stok1));
    }
    public void tampilDataTransaksi(String data){
        tabel2.getDataVector().removeAllElements();
        tabel2.fireTableDataChanged();
        if(data.equals("")){
            sql = "select * from transaksi";
        }else sql = "select * from transaksi where tanggalTransaksi LIKE '"+data+"%'";
        
        try {        
            Statement stat = (Statement) koneksiDatabase.getKoneksi().createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()){
                Object[] hasil;
                hasil = new Object[7];
                hasil[0] = res.getString("idTransaksi");
                hasil[1] = res.getString("tanggalTransaksi");
                hasil[2] = res.getString("idObat");
                hasil[3] = res.getString("namaObat");
                hasil[4] = res.getString("qty");
                hasil[5] = res.getString("hargaObat");
                hasil[6] = res.getString("totalBayar");
                
                
               tabel2.addRow(hasil);  
            }
            } catch (SQLException ex) {
            Logger.getLogger(viewObat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void hitungan(){
        int index = tabelBarang.getSelectedRow();
        int hargaObat,qty;
        hargaObat = Integer.parseInt(this.hargaObat.getText());
        qty = Integer.parseInt(jumlahBeli.getText());
        int perhitungan;
        perhitungan = qty * hargaObat;
        
        this.totalBayar.setText(String.valueOf(perhitungan));
        
    }
    
    public void ambilDataTransaksi(){
        int index = tabelTransaksi.getSelectedRow();
        String idTrs = String.valueOf(tabelTransaksi.getValueAt(index, 0));
        String tglTrs = String.valueOf(tabelTransaksi.getValueAt(index, 1));
        String idOb = String.valueOf(tabelTransaksi.getValueAt(index, 2));
        String namaOb = String.valueOf(tabelTransaksi.getValueAt(index, 3));
        String hargaOb = String.valueOf(tabelTransaksi.getValueAt(index, 4));
        String totalByr = String.valueOf(tabelTransaksi.getValueAt(index, 5));
        
        
        
        this.idTrs.setText(idTrs);
        this.tglTrs.setText(tglTrs);
        id_barang.setText(idOb);
        namaBarang.setText(namaOb);
        hargaObat.setText(hargaOb);
        totalBayar.setText(totalByr);
        
    }
    
    private void kurangStok (){
        
        int stok,qty;
            stok = Integer.parseInt(this.stok.getText());
            qty = Integer.parseInt(this.jumlahBeli.getText());
            int kurangStok;
            kurangStok= stok-qty;
            
        try {
            
            
            
            String sql = ("UPDATE obat SET stokObat ='"+kurangStok+"' WHERE idObat = '"+id_barang.getText()+"'");
            PreparedStatement eksekusi = koneksiDatabase.getKoneksi().prepareStatement(sql);
            eksekusi.execute();            
            
            
            
        } catch (Exception e) {
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jumlahBeli = new javax.swing.JTextField();
        hargaObat = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        namaBarang = new javax.swing.JTextField();
        id_barang = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelBarang = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        Cari = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        clearButton = new javax.swing.JButton();
        stok = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        totalBayar = new javax.swing.JTextField();
        bprosesTransaksi = new javax.swing.JButton();
        bbatalTransaksi = new javax.swing.JButton();
        hitung = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        j = new javax.swing.JLabel();
        idTrs = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tglTrs = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelTransaksi = new javax.swing.JTable();
        deleteButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Daftar Barang - Transaksi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 10), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel2.setText("id Barang");

        jLabel5.setText("Harga Obat");

        jLabel1.setText("Qty Beli");

        jumlahBeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumlahBeliActionPerformed(evt);
            }
        });
        jumlahBeli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jumlahBeliKeyPressed(evt);
            }
        });

        hargaObat.setEditable(false);

        jLabel3.setText("nama barang");

        namaBarang.setEditable(false);

        id_barang.setEditable(false);

        tabelBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelBarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelBarang);

        jLabel7.setText("Pilih Barang");

        Cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CariActionPerformed(evt);
            }
        });
        Cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CariKeyPressed(evt);
            }
        });

        jLabel9.setText("Cari");

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        stok.setEditable(false);

        jLabel4.setText("Stok");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(clearButton)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(namaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(56, 56, 56)
                                        .addComponent(hargaObat, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(id_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Cari, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jumlahBeli, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                            .addComponent(stok))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(id_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(hargaObat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jumlahBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(clearButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Proses - Transaksi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 10), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel6.setText("Total Bayar");

        totalBayar.setEditable(false);

        bprosesTransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/kalkulator.png"))); // NOI18N
        bprosesTransaksi.setText("PROSES TRANSAKSI");
        bprosesTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bprosesTransaksiActionPerformed(evt);
            }
        });

        bbatalTransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/batal.png"))); // NOI18N
        bbatalTransaksi.setText("BATAL TRANSAKSI");
        bbatalTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbatalTransaksiActionPerformed(evt);
            }
        });

        hitung.setText("hitung");
        hitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitungActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(bbatalTransaksi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bprosesTransaksi))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(51, 51, 51)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hitung, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(totalBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(totalBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(hitung)
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bbatalTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bprosesTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(51, 153, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transaksi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        j.setText("id Transaksi");

        idTrs.setEditable(false);

        jLabel8.setText("Tanggal Transaksi");

        tglTrs.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(j)
                    .addComponent(jLabel8))
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tglTrs, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idTrs, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(j)
                    .addComponent(idTrs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tglTrs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(51, 153, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Transaksi"));

        tabelTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelTransaksiMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelTransaksi);

        deleteButton.setText("hapus");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 916, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deleteButton)
                .addGap(37, 37, 37))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Input Data Transaksi");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
            .addGroup(layout.createSequentialGroup()
                .addGap(378, 378, 378)
                .addComponent(jLabel10)
                .addGap(0, 425, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.getAccessibleContext().setAccessibleName("");
        jPanel1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelBarangMouseClicked
        // TODO add your handling code here:
        ambilDataObat();
    }//GEN-LAST:event_tabelBarangMouseClicked

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        ct.bersihkanObat();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void CariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CariKeyPressed
        // TODO add your handling code here:
        tampilDataObat(Cari.getText());
    }//GEN-LAST:event_CariKeyPressed

    private void jumlahBeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumlahBeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jumlahBeliActionPerformed

    private void CariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CariActionPerformed

    private void jumlahBeliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jumlahBeliKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jumlahBeliKeyPressed

    private void hitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitungActionPerformed
        // TODO add your handling code here:
        hitungan();
    }//GEN-LAST:event_hitungActionPerformed

    private void bbatalTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbatalTransaksiActionPerformed
        // TODO add your handling code here:
        ct.bersihkanTrs();
    }//GEN-LAST:event_bbatalTransaksiActionPerformed

    private void bprosesTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bprosesTransaksiActionPerformed
        // TODO add your handling code here:
        kurangStok();
        ct.simpanTrs();
        ct.bersihkanTrs();
        tampilDataTransaksi("");
        tampilDataObat("");
    }//GEN-LAST:event_bprosesTransaksiActionPerformed

    private void tabelTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelTransaksiMouseClicked
        // TODO add your handling code here:
        ambilDataTransaksi();
        
        
    }//GEN-LAST:event_tabelTransaksiMouseClicked

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        ct.hapus();
        tampilDataTransaksi("");
    }//GEN-LAST:event_deleteButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Cari;
    private javax.swing.JButton bbatalTransaksi;
    private javax.swing.JButton bprosesTransaksi;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField hargaObat;
    private javax.swing.JButton hitung;
    private javax.swing.JTextField idTrs;
    private javax.swing.JTextField id_barang;
    private javax.swing.JLabel j;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jumlahBeli;
    private javax.swing.JTextField namaBarang;
    private javax.swing.JTextField stok;
    private javax.swing.JTable tabelBarang;
    private javax.swing.JTable tabelTransaksi;
    private javax.swing.JTextField tglTrs;
    private javax.swing.JTextField totalBayar;
    // End of variables declaration//GEN-END:variables
}
