package pac_form;

import config.Koneksi;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Statement;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.scene.control.TableSelectionModel;
import javax.swing.table.DefaultTableModel;
import pac_class.GajiCRUD;

public class Serch_gaji extends javax.swing.JFrame {

    Koneksi con = new Koneksi();
    GajiCRUD gjcrud = new GajiCRUD();
    public Gaji Ga = null;

    public DefaultTableModel viewData() {
        DefaultTableModel petugastable = new DefaultTableModel();
        petugastable.addColumn("ID");
        petugastable.addColumn("NAMA");
        petugastable.addColumn("NIP");
        petugastable.addColumn("GAJI POKOK");
        petugastable.addColumn("TUNJANGAN STRUKTURAL");
        petugastable.addColumn("TUNJANGAN FUNGSIONAL");
        petugastable.addColumn("UANG MAKAN");
        petugastable.addColumn("SEWA MOTOR");
        petugastable.addColumn("ID PEGAWAI");

        try {
            String sql = "SELECT gaji.id_tgaji, pegawai.nama, pegawai.nip, gaji.gaji_pokok,\n"
                    + "gaji.t_struktural, gaji.t_fungsional, gaji.uang_makan, gaji.sewa_motor, pegawai.id_tpegawai\n"
                    + "FROM gaji LEFT JOIN pegawai\n"
                    + "ON gaji.id_tpegawai=pegawai.id_tpegawai\n"
                    + "WHERE gaji.gaji_pokok = 0";
            Statement stmt = con.connect().prepareStatement(sql);
            ResultSet res = stmt.executeQuery(sql);
            // Mengisi pegawaiTable dengan perulangan hasil dari Query
            while (res.next()) {
                petugastable.addRow(new Object[]{
                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getString(5),
                    res.getString(6),
                    res.getString(7),
                    res.getString(8),
                    res.getString(9)
                }
                );
            }
        } catch (Exception e) {
        }
        return petugastable;
    }

    public Serch_gaji() {
        initComponents();
        jTable_serchgaji.setModel(viewData());
        viewData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_serchgaji = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable_serchgaji.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable_serchgaji.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_serchgajiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_serchgaji);

        jLabel1.setText("Cari");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable_serchgajiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_serchgajiMouseClicked
        // TODO add your handling code here:
        int tabelSerch = jTable_serchgaji.getSelectedRow();
        Ga.namaSerch = jTable_serchgaji.getValueAt(tabelSerch, 1).toString();
        Ga.nipSerch = jTable_serchgaji.getValueAt(tabelSerch, 2).toString();
        Ga.idPegwaiSerch = jTable_serchgaji.getValueAt(tabelSerch, 8).toString();
        Ga.idGaji = jTable_serchgaji.getValueAt(tabelSerch, 0).toString();
        Ga.gajiPokok = jTable_serchgaji.getValueAt(tabelSerch, 3).toString();
        Ga.tunStruktural = jTable_serchgaji.getValueAt(tabelSerch, 4).toString();
        Ga.tunFungsional = jTable_serchgaji.getValueAt(tabelSerch, 5).toString();
        Ga.uangMakan = jTable_serchgaji.getValueAt(tabelSerch, 6).toString();
        Ga.sewaMotor = jTable_serchgaji.getValueAt(tabelSerch, 7).toString();
        Ga.itemTerpilih();
        this.dispose();


    }//GEN-LAST:event_jTable_serchgajiMouseClicked

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
            java.util.logging.Logger.getLogger(Serch_gaji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Serch_gaji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Serch_gaji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Serch_gaji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Serch_gaji().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_serchgaji;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
