package pac_form;

import config.Koneksi;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.runtime.regexp.joni.constants.AsmConstants;
import pac_class.PiutangCRUD;

public class Piutang extends javax.swing.JFrame {

    public PiutangCRUD piutang = new PiutangCRUD();
    public Koneksi con = new Koneksi();

    public void kosong() {
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        dateChooserCombo_piutang.setDateFormat(dt);
        PiutangCRUD piutangid = new PiutangCRUD();
        Table_piutang.setModel(piutang.tampilPiutang());

        try {
            TextField_id_piutang.setText(piutangid.idotomatis());
            TextField_id_piutang.setEditable(false);
            TextField_NIP.setEditable(false);
            //TextField_NIP.setText(null);
            TextField_KTP.setEditable(false);
            //TextField_KTP.setText(null);
            TextField_nama.setEditable(false);
            //TextField_nama.setText(null);
            TextField_nominal_sebelum.setEditable(false);
            //TextField_nominal_sebelum.setText(null);
            TextField_nominal_jumlah.setEditable(false);
            //TextField_nominal_jumlah.setText(null);
            TextField_gaji_pokok.setEditable(false);
            //TextField_gaji_pokok.setText(null);

        } catch (SQLException ex) {
            Logger.getLogger(Piutang.class.getName()).log(Level.ALL.SEVERE, null, ex);
        }
        TextField_id_piutang.setEditable(false);
        TextField_nama.setText(null);
        TextField_KTP.setText(null);
        TextField_NIP.setText(null);
        TextField_nominal_jumlah.setText(null);
        TextField_nominal_sebelum.setText(null);
        TextField_nominal_peminjaman.setText("0.00");
        TextField_gaji_pokok.setText(null);

    }

    public String id_piutang, namapiutang, ktppiutang, nippiutang, sebelum, jumlah, idpegawai, gaji;

    public String getIdpiutang() {
        return id_piutang;
    }

    public String getNamapiutang() {
        return namapiutang;
    }

    public String getKtppiutang() {
        return ktppiutang;
    }

    public String getNippiutang() {
        return nippiutang;
    }

    public String getSebelum() {
        return sebelum;
    }

    public String getJumlah() {
        return jumlah;
    }

    public String getIdpegawai() {
        return idpegawai;
    }

    public String getGaji() {
        return gaji;
    }

    public Piutang() {
        initComponents();
        kosong();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TextField_id_piutang = new javax.swing.JTextField();
        TextField_nama = new javax.swing.JTextField();
        TextField_KTP = new javax.swing.JTextField();
        TextField_NIP = new javax.swing.JTextField();
        TextField_nominal_sebelum = new javax.swing.JTextField();
        TextField_nominal_peminjaman = new javax.swing.JTextField();
        TextField_nominal_jumlah = new javax.swing.JTextField();
        TextField_gaji_pokok = new javax.swing.JTextField();
        Button_simpan = new javax.swing.JButton();
        Button_update = new javax.swing.JButton();
        dateChooserCombo_piutang = new datechooser.beans.DateChooserCombo();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_piutang = new javax.swing.JTable();
        jButton_Search = new javax.swing.JButton();
        TextField_id_pegawai = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("ID PIUTANG");

        jLabel2.setText("Nama Karyawan");

        jLabel3.setText("Nomor KTP");

        jLabel4.setText("NIP");

        jLabel5.setText("Nominal Piutang Saat ini");

        jLabel6.setText("Gaji Pokok");

        jLabel7.setText("Nominal Peminjaman");

        jLabel8.setText("Jumlah Piutang");

        TextField_nominal_sebelum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_nominal_sebelumActionPerformed(evt);
            }
        });

        TextField_nominal_peminjaman.setText("0.00");
        TextField_nominal_peminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_nominal_peminjamanActionPerformed(evt);
            }
        });
        TextField_nominal_peminjaman.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TextField_nominal_peminjamanKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextField_nominal_peminjamanKeyReleased(evt);
            }
        });

        TextField_gaji_pokok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_gaji_pokokActionPerformed(evt);
            }
        });

        Button_simpan.setText("SIMPAN");
        Button_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_simpanActionPerformed(evt);
            }
        });

        Button_update.setText("UPDATE");
        Button_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_updateActionPerformed(evt);
            }
        });

        Table_piutang.setModel(new javax.swing.table.DefaultTableModel(
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
        Table_piutang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_piutangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table_piutang);

        jButton_Search.setText("SERCH");
        jButton_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Button_simpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Button_update)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Search)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TextField_id_pegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateChooserCombo_piutang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(TextField_KTP, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(TextField_nama, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextField_id_piutang, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextField_NIP))
                        .addGap(86, 86, 86)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TextField_gaji_pokok, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TextField_nominal_peminjaman, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TextField_nominal_jumlah, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(TextField_nominal_sebelum, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 117, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(TextField_nominal_sebelum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(TextField_nominal_peminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(TextField_nominal_jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(TextField_gaji_pokok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(TextField_id_piutang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(TextField_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(TextField_KTP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(TextField_NIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Button_simpan)
                        .addComponent(Button_update)
                        .addComponent(jButton_Search))
                    .addComponent(dateChooserCombo_piutang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextField_id_pegawai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jButton1.setBackground(new java.awt.Color(255, 0, 51));
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\RIFQI\\Pictures\\close png 20.png")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void ItemTerpilih() {
        Serch_piutang SP = new Serch_piutang();
        SP.Piu = this;
        TextField_id_piutang.setText(id_piutang);
        TextField_nama.setText(namapiutang);
        TextField_KTP.setText(ktppiutang);
        TextField_NIP.setText(nippiutang);
        TextField_nominal_sebelum.setText(sebelum);
        TextField_id_pegawai.setText(idpegawai);
        TextField_gaji_pokok.setText(gaji);
        // TextField_.setText(no_bpjskesehatan);
//        TextField_faskes_bpjskesehatan.setText(faskes_kesehatan);
//        TextField_nominal_bpjskesehatan.setText(nominal_kesehatan);
//        TextField_id_ketenagakerjaan.setText(id_bpjsketenagakerjaan);
//        TextField_no_ketenagakerjaan.setText(no_bpjsketenagakerjaan);
//        TextField_nominal_ketenagakerjaan.setText(nominal_ketenagakerjaan);

    }
    private void TextField_nominal_sebelumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_nominal_sebelumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_nominal_sebelumActionPerformed

    private void Button_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_simpanActionPerformed
        // TODO add your handling code here:
        try {
            piutang.updatePiutang(TextField_id_pegawai.getText(),
                    TextField_nominal_sebelum.getText(),
                    dateChooserCombo_piutang.getText(),
                    TextField_nominal_peminjaman.getText(),
                    TextField_nominal_jumlah.getText(),
                    TextField_id_piutang.getText());
            JOptionPane.showMessageDialog(rootPane, "Data berhasil disimpan");
            Table_piutang.setModel(piutang.tampilPiutang());
            kosong();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, "data gagaldirubah");
            Logger.getLogger(Piutang.class.getName()).log(Level.SEVERE, null, e);
        }


    }//GEN-LAST:event_Button_simpanActionPerformed

    private void jButton_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SearchActionPerformed
        // TODO add your handling code here:
        Serch_piutang SP = new Serch_piutang();
        SP.Piu = this;
        SP.setVisible(true);
        SP.setResizable(false);
        
         
    }//GEN-LAST:event_jButton_SearchActionPerformed

    private void TextField_nominal_peminjamanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextField_nominal_peminjamanKeyPressed
        double sekarang = 0.00;
        double sebelum = Double.valueOf(TextField_nominal_sebelum.getText());
        if (!TextField_nominal_peminjaman.getText().equals("")){
        sekarang = Double.valueOf(TextField_nominal_peminjaman.getText());
        }
        
        TextField_nominal_jumlah.setText(String.valueOf(sebelum + sekarang));       
        
//        double jumlah = Double.parseDouble(sebelum)+
//                Double.parseDouble(TextField_nominal_peminjaman.getText());       
//            TextField_nominal_jumlah.setText(Double.toString(jumlah));
    }//GEN-LAST:event_TextField_nominal_peminjamanKeyPressed

    private void TextField_nominal_peminjamanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextField_nominal_peminjamanKeyReleased
        // TODO add your handling code here:
//        int sebelum = Integer.valueOf(TextField_nominal_sebelum.getText());
//        int sekarang = Integer.valueOf(TextField_nominal_jumlah.getText());
//        TextField_nominal_sesudah.setText(String.valueOf(sebelum+sekarang));
    }//GEN-LAST:event_TextField_nominal_peminjamanKeyReleased

    private void TextField_gaji_pokokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_gaji_pokokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_gaji_pokokActionPerformed

    private void Table_piutangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_piutangMouseClicked
        // TODO add your handling code here:
        Button_simpan.setVisible(false);
//        Button_delete.setVisible(true);
        Button_update.setVisible(true);
        int kolom = 0;
        kolom = Table_piutang.getSelectedRow();
        TextField_id_piutang.setText(Table_piutang.getValueAt(kolom, 0).toString());
        TextField_id_pegawai.setText(Table_piutang.getValueAt(kolom, 1).toString());
        TextField_nama.setText(Table_piutang.getValueAt(kolom, 2).toString());
        TextField_KTP.setText(Table_piutang.getValueAt(kolom, 3).toString());

        TextField_nominal_sebelum.setText(Table_piutang.getValueAt(kolom, 6).toString());
        TextField_gaji_pokok.setText(Table_piutang.getValueAt(kolom, 8).toString());
        TextField_NIP.setText(Table_piutang.getValueAt(kolom, 9).toString());


    }//GEN-LAST:event_Table_piutangMouseClicked

    private void Button_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_updateActionPerformed

        try {
            piutang.updatePiutang(TextField_id_pegawai.getText(),
                    TextField_nominal_sebelum.getText(),
                    dateChooserCombo_piutang.getText(),
                    TextField_nominal_peminjaman.getText(),
                    TextField_nominal_jumlah.getText(),
                    TextField_id_piutang.getText());
            JOptionPane.showMessageDialog(rootPane, "Data berhasil diubah");
            Table_piutang.setModel(piutang.tampilPiutang());
            kosong();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "data gagaldirubah");
            Logger.getLogger(Piutang.class.getName()).log(Level.SEVERE, null, e);
        }

    }//GEN-LAST:event_Button_updateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Menu_Utama().setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void TextField_nominal_peminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_nominal_peminjamanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_nominal_peminjamanActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Piutang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Piutang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Piutang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Piutang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Piutang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_simpan;
    private javax.swing.JButton Button_update;
    private javax.swing.JTable Table_piutang;
    private javax.swing.JTextField TextField_KTP;
    private javax.swing.JTextField TextField_NIP;
    private javax.swing.JTextField TextField_gaji_pokok;
    private javax.swing.JTextField TextField_id_pegawai;
    private javax.swing.JTextField TextField_id_piutang;
    private javax.swing.JTextField TextField_nama;
    private javax.swing.JTextField TextField_nominal_jumlah;
    private javax.swing.JTextField TextField_nominal_peminjaman;
    private javax.swing.JTextField TextField_nominal_sebelum;
    private datechooser.beans.DateChooserCombo dateChooserCombo_piutang;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_Search;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
