
package pac_form;

import java.sql.PreparedStatement;
import config.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pac_class.GajiCRUD;

public class Gaji extends javax.swing.JFrame {
//mendeklarasikan kelas pegawai
    public GajiCRUD gj = new GajiCRUD();
//deklarasi class Koneksi
    public Koneksi con = new Koneksi();
//private DefaultTableModel model;
    public DefaultTableModel gajitaTable;

    public void bersih() {
        GajiCRUD gjid = new GajiCRUD();
        try {
            TextField_idgaji.setText(gjid.idotomatis());
            TextField_idgaji.setEditable(false);
        } catch (SQLException ex) {
            Logger.getLogger(Petugas.class.getName()).log(Level.SEVERE, null, ex);
        }
        Text_idpegawai.setEditable(false);
        TextField_idgaji.setEditable(false);
        TextField_nama.setEditable(false);
        TextField_NIP.setEditable(false);
        Text_idpegawai.setText(null);
        TextField_nama.setText(null);
        TextField_NIP.setText(null);
        TextField_gajipokok.setText(null);
        TextField_fungsional.setText(null);
        TextField_struktural.setText(null);
        TextField_sewamotor.setText(null);
        TextField_makan.setText(null);
        Button_create.setVisible(true);
        Button_delete.setVisible(false);
        Button_update.setVisible(false);
    }

    public String nipSerch, namaSerch, idPegwaiSerch, idGaji, gajiPokok, tunStruktural, tunFungsional, uangMakan, sewaMotor;

    public String getNip() {
        return nipSerch;
    }

    public String getNama() {
        return namaSerch;
    }

    public String getIdpegawai() {
        return idPegwaiSerch;
    }

    public String getIdgaji() {
        return idGaji;
    }

    public String getGajiPokok() {
        return gajiPokok;
    }

    public String getTunStruktural() {
        return tunStruktural;
    }

    public String getTunFungsional() {
        return tunFungsional;
    }

    public String getUangMakan() {
        return uangMakan;
    }

    public String getSewaMotor() {
        return sewaMotor;
    }

    public Gaji() {
        initComponents();
        bersih();
        Table_gaji.setModel(gj.tampilgaji());
        gj.tampilgaji();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TextField_gajipokok = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TextField_struktural = new javax.swing.JTextField();
        TextField_fungsional = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TextField_makan = new javax.swing.JTextField();
        TextField_sewamotor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TextField_nama = new javax.swing.JTextField();
        TextField_NIP = new javax.swing.JTextField();
        Button_update = new javax.swing.JButton();
        Button_create = new javax.swing.JButton();
        Button_delete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_gaji = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        Text_idpegawai = new javax.swing.JTextField();
        TextField_idgaji = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(46, 68, 92));

        jPanel2.setBackground(new java.awt.Color(4, 92, 4));

        jPanel1.setBackground(new java.awt.Color(198, 202, 198));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Gaji Pokok");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Tunjangan Struktural");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Tunjangan Fungsional");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Uang Makan");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Sewa Motor");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Nama");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("NIP");

        TextField_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_namaActionPerformed(evt);
            }
        });

        TextField_NIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_NIPActionPerformed(evt);
            }
        });

        Button_update.setBackground(new java.awt.Color(3, 81, 3));
        Button_update.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Button_update.setForeground(new java.awt.Color(255, 255, 255));
        Button_update.setText("UPDATE");
        Button_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_updateActionPerformed(evt);
            }
        });

        Button_create.setBackground(new java.awt.Color(11, 103, 11));
        Button_create.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Button_create.setForeground(new java.awt.Color(255, 255, 255));
        Button_create.setText("CREATE");
        Button_create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_createActionPerformed(evt);
            }
        });

        Button_delete.setBackground(new java.awt.Color(19, 87, 19));
        Button_delete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Button_delete.setForeground(new java.awt.Color(255, 255, 255));
        Button_delete.setText("DELETE");
        Button_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_deleteActionPerformed(evt);
            }
        });

        Table_gaji.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Table_gaji.setModel(new javax.swing.table.DefaultTableModel(
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
        Table_gaji.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_gajiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table_gaji);

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\RIFQI\\Pictures\\Open_40px.png")); // NOI18N
        jButton4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 204, 0), 3, true));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        Text_idpegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text_idpegawaiActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("ID Gaji");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(Text_idpegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addComponent(jLabel2)
                                .addComponent(jLabel1)
                                .addComponent(jLabel7)
                                .addComponent(jLabel6)
                                .addComponent(jLabel8))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(TextField_idgaji, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TextField_sewamotor, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TextField_makan, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TextField_fungsional, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TextField_struktural, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TextField_gajipokok, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TextField_nama, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                        .addComponent(TextField_NIP))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Button_create, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Button_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Button_update, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Text_idpegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextField_idgaji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TextField_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(9, 9, 9)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TextField_NIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)))
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextField_gajipokok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextField_struktural, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextField_fungsional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextField_makan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextField_sewamotor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Button_create)
                            .addComponent(Button_update)
                            .addComponent(Button_delete))))
                .addContainerGap())
        );

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\RIFQI\\Pictures\\close png 20.png")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void itemTerpilih() {
        Serch_gaji SG = new Serch_gaji();
        SG.Ga = this;
        TextField_nama.setText(namaSerch);
        TextField_NIP.setText(nipSerch);
        Text_idpegawai.setText(idPegwaiSerch);
        TextField_idgaji.setText(idGaji);
        TextField_gajipokok.setText(gajiPokok);
        TextField_struktural.setText(tunStruktural);
        TextField_fungsional.setText(tunFungsional);
        TextField_makan.setText(uangMakan);
        TextField_sewamotor.setText(sewaMotor);

    }


    private void TextField_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_namaActionPerformed

    private void TextField_NIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_NIPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_NIPActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        Serch_gaji SG = new Serch_gaji();
        SG.Ga = this;
        SG.setVisible(true);
        SG.setResizable(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void Text_idpegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_idpegawaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_idpegawaiActionPerformed

    private void Button_createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_createActionPerformed
        // TODO add your handling code here: 
        try {
            gj.UpdateGaji(Text_idpegawai.getText(),
                    TextField_gajipokok.getText(),
                    TextField_struktural.getText(),
                    TextField_fungsional.getText(),
                    TextField_makan.getText(),
                    TextField_sewamotor.getText(),
                    TextField_idgaji.getText());

            JOptionPane.showMessageDialog(rootPane, "Data berhasil disimpan");
            Table_gaji.setModel(gj.tampilgaji());
            bersih();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "GAGAL");
            Logger.getLogger(Gaji.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Button_createActionPerformed

    private void Table_gajiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_gajiMouseClicked
        // TODO add your handling code here:
        Button_create.setVisible(false);
        Button_delete.setVisible(true);
        Button_update.setVisible(true);
        int kolom = 0;
        kolom = Table_gaji.getSelectedRow();
        TextField_idgaji.setText(Table_gaji.getValueAt(kolom, 0).toString());
        TextField_nama.setText(Table_gaji.getValueAt(kolom, 1).toString());
        TextField_NIP.setText(Table_gaji.getValueAt(kolom, 2).toString());
        TextField_gajipokok.setText(Table_gaji.getValueAt(kolom, 3).toString());
        TextField_struktural.setText(Table_gaji.getValueAt(kolom, 4).toString());
        TextField_fungsional.setText(Table_gaji.getValueAt(kolom, 5).toString());
        TextField_makan.setText(Table_gaji.getValueAt(kolom, 6).toString());
        TextField_sewamotor.setText(Table_gaji.getValueAt(kolom, 7).toString());

        TextField_idgaji.setEnabled(false);
        try {
            Text_idpegawai.setText(gj.getIdFromIdGaji(Table_gaji.getValueAt(kolom, 0).toString()));
        } catch (SQLException ex) {
            Logger.getLogger(Gaji.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_Table_gajiMouseClicked

    private void Button_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_updateActionPerformed
        // TODO add your handling code here:
        try {
            gj.UpdateGaji(Text_idpegawai.getText(),
                    TextField_gajipokok.getText(),
                    TextField_struktural.getText(),
                    TextField_fungsional.getText(),
                    TextField_makan.getText(),
                    TextField_sewamotor.getText(),
                    TextField_idgaji.getText());

            JOptionPane.showMessageDialog(rootPane, "Data berhasil dirubah");
            Table_gaji.setModel(gj.tampilgaji());
            bersih();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "data gagaldirubah");
            Logger.getLogger(Gaji.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Button_updateActionPerformed

    private void Button_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_deleteActionPerformed
        // TODO add your handling code here:
        String ObjButtons[] = {"Yes", "No"};
        int PromptResult = JOptionPane.showOptionDialog(null, "yakin Mau Hapus ?", "Massage", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, ObjButtons, ObjButtons[1]);
        if (PromptResult == 0) {

            try {
                gj.hapusGaji(TextField_idgaji.getText());
                JOptionPane.showMessageDialog(rootPane, "Data berhasil dihapus");
                Table_gaji.setModel(gj.tampilgaji());
                bersih();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "data gagal dihapus");
                Logger.getLogger(Gaji.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_Button_deleteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose(); //kode jbutton2 / panggil form lain
        new Menu_Utama().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Gaji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gaji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gaji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gaji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gaji().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_create;
    private javax.swing.JButton Button_delete;
    private javax.swing.JButton Button_update;
    private javax.swing.JTable Table_gaji;
    private javax.swing.JTextField TextField_NIP;
    private javax.swing.JTextField TextField_fungsional;
    private javax.swing.JTextField TextField_gajipokok;
    private javax.swing.JTextField TextField_idgaji;
    private javax.swing.JTextField TextField_makan;
    private javax.swing.JTextField TextField_nama;
    private javax.swing.JTextField TextField_sewamotor;
    private javax.swing.JTextField TextField_struktural;
    private javax.swing.JTextField Text_idpegawai;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
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