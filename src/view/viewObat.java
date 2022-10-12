/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.mysql.jdbc.Statement;
import controller.controllerObat;
import database.koneksiDatabase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author waslim
 */
public class viewObat extends javax.swing.JInternalFrame {

    /**
     * Creates new form viewBarang
     */
    private controllerObat cO;
    private DefaultTableModel tabel;
    private String sql ="";
    
    public viewObat() {
        initComponents();
        cO = new controllerObat(this);
        tabel = new DefaultTableModel();
        tabelObat.setModel(tabel);
        tabel.addColumn("Id Obat");
        tabel.addColumn("Nama Obat");
        tabel.addColumn("Jenis Obat");
        tabel.addColumn("Dosis Obat");
        tabel.addColumn("Tanggal Expired");
        tabel.addColumn("Stok Obat");
        tabel.addColumn("Kegunaan Obat");
        tabel.addColumn("Harga Obat");
        
        tampilDataObat("");
        cO.kontrolButton();
    }

    public JButton getjButton1() {
        return tambah;
    }

    public JButton getjButton2() {
        return ubah;
    }

    public JButton getjButton3() {
        return delete;
    }

    public JButton getjButton5() {
        return batal;
    }

    public JTextField getjTextField1() {
        return idObat;
    }

    public JTextField getjTextField2() {
        return namaObat;
    }

    public JTextField getjTextField4() {
        return stokObat;
    }

    public JTextField getjTextField5() {
        return hargaObat;
    }

    public JTextField getjTextField6() {
        return jenisObat;
    }

    public JButton getBatal() {
        return batal;
    }

    public JButton getDelete() {
        return delete;
    }

    public JTextField getHargaObat() {
        return hargaObat;
    }

    public JTextField getIdObat() {
        return idObat;
    }

    public JTextField getJenisObat() {
        return jenisObat;
    }

    public JTextField getNamaObat() {
        return namaObat;
    }

    public JTextField getStokObat() {
        return stokObat;
    }

    public JTable getTabelObat() {
        return tabelObat;
    }

    public JButton getTambah() {
        return tambah;
    }

    public JButton getUbah() {
        return ubah;
    }

    public JTextArea getDosisObat() {
        return dosisObat;
    }

    public JTextArea getKgnObat() {
        return kgnObat;
    }

    public JTextField getTglExp() {
        return tglExp;
    }

    
    
    private void tampilDataObat(String data){
        
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
                hasil[2] = res.getString("jenisObat");
                hasil[3] = res.getString("dosisObat");
                hasil[4] = res.getString("tanggalEx");
                hasil[5] = res.getString("stokObat");
                hasil[6] = res.getString("kegunaanObat");
                hasil[7] = res.getString("hargaObat");
                
                
               tabel.addRow(hasil);
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(viewObat.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void ambilDataTabel(){
        
        int index = tabelObat.getSelectedRow();
        String idObat = String.valueOf(tabelObat.getValueAt(index, 0));
        String namaObat = String.valueOf(tabelObat.getValueAt(index, 1));
        String jenisObat  = String.valueOf(tabelObat.getValueAt(index, 2));
        String dosisObat = String.valueOf(tabelObat.getValueAt(index, 3));
        String tanggalEx = String.valueOf(tabelObat.getValueAt(index, 4));
        String stokObat  = String.valueOf(tabelObat.getValueAt(index, 5));
        String kegunaanObat = String.valueOf(tabelObat.getValueAt(index, 6));
        String hargaObat  = String.valueOf(tabelObat.getValueAt(index, 7));

        this.idObat.setText(idObat);
        this.namaObat.setText(namaObat);
        this.jenisObat.setText(jenisObat);
        this.dosisObat.setText(dosisObat);
        tglExp.setText(tanggalEx);
        this.stokObat.setText(stokObat);
        kgnObat.setText(kegunaanObat);
        this.hargaObat.setText(hargaObat);
        
        cO.kontrolButtonDua();
        
        
    }
    
   
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        stokObat = new javax.swing.JTextField();
        batal = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        hargaObat = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jenisObat = new javax.swing.JTextField();
        tambah = new javax.swing.JButton();
        ubah = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        idObat = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        namaObat = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelObat = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cariNama = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tglExp = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        kgnObat = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        dosisObat = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(51, 204, 255));
        setBorder(new javax.swing.border.MatteBorder(null));
        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/batal.png"))); // NOI18N
        batal.setText("Batal");
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });

        jLabel5.setText("Stok Obat");

        jLabel6.setText("Harga Obat");

        tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/buat.png"))); // NOI18N
        tambah.setText("Tambah");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });

        ubah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/update.png"))); // NOI18N
        ubah.setText("Ubah");
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });

        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/hapus.png"))); // NOI18N
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        idObat.setEditable(false);

        jLabel3.setText("Nama Obat");

        jLabel2.setText("Id Obat");

        jLabel4.setText("Jenis Obat");

        tabelObat.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelObat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelObatMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelObat);

        jLabel1.setText("Cari Data Obat");

        cariNama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cariNamaKeyPressed(evt);
            }
        });

        jLabel7.setText("Kegunaan Obat");

        jLabel8.setText("Dosis Obat");

        jLabel9.setText("Tanggal Expired");

        kgnObat.setColumns(20);
        kgnObat.setRows(5);
        jScrollPane2.setViewportView(kgnObat);

        dosisObat.setColumns(20);
        dosisObat.setRows(5);
        jScrollPane3.setViewportView(dosisObat);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(batal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(namaObat, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jenisObat, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tglExp, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stokObat, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hargaObat, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idObat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel1)
                        .addGap(29, 29, 29)
                        .addComponent(cariNama, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(idObat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(cariNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(namaObat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jenisObat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tglExp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stokObat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hargaObat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(batal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tambah)
                    .addComponent(ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        // TODO add your handling code here:
        cO.updateData();
        tampilDataObat("");
    }//GEN-LAST:event_ubahActionPerformed

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        // TODO add your handling code here:
        cO.simpan();
        tampilDataObat("");
    }//GEN-LAST:event_tambahActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        cO.deleteData();
        tampilDataObat("");
    }//GEN-LAST:event_deleteActionPerformed

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
        // TODO add your handling code here:
        cO.bersihkan();
        cO.kontrolButton();
    }//GEN-LAST:event_batalActionPerformed

    private void tabelObatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelObatMouseClicked
        // TODO add your handling code here:
        ambilDataTabel();
    }//GEN-LAST:event_tabelObatMouseClicked

    private void cariNamaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariNamaKeyPressed
        // TODO add your handling code here:
        tampilDataObat(cariNama.getText());
    }//GEN-LAST:event_cariNamaKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton batal;
    private javax.swing.JTextField cariNama;
    private javax.swing.JButton delete;
    private javax.swing.JTextArea dosisObat;
    private javax.swing.JTextField hargaObat;
    private javax.swing.JTextField idObat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jenisObat;
    private javax.swing.JTextArea kgnObat;
    private javax.swing.JTextField namaObat;
    private javax.swing.JTextField stokObat;
    private javax.swing.JTable tabelObat;
    private javax.swing.JButton tambah;
    private javax.swing.JTextField tglExp;
    private javax.swing.JButton ubah;
    // End of variables declaration//GEN-END:variables
}
