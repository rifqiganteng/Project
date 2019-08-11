
package pac_form;

import config.Koneksi;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class Serch_Cetak_laporan extends javax.swing.JFrame {
    Koneksi con = new Koneksi();
    //public CetakLaporan ct = new CetakLaporan();
     public CetakLaporan ct = null;

    
      public DefaultTableModel viewData(){
          DefaultTableModel Cetak_laporan = new DefaultTableModel();
        Cetak_laporan.addColumn("NAMA");
        Cetak_laporan.addColumn("KTP");
        Cetak_laporan.addColumn("JABATAN");
        Cetak_laporan.addColumn("KESEHATAN");
        Cetak_laporan.addColumn("KETENAGAKERJAAN");
        Cetak_laporan.addColumn("GAJI");
        Cetak_laporan.addColumn("MAKAN");
        Cetak_laporan.addColumn("MOTOR");
        
        
        
        
     try{          
           String sql = "SELECT p.nama, p.no_ktp, p.jabatan, bks.nominal, bkt.nominal, g.gaji_pokok, g.uang_makan, g.sewa_motor\n" +
"FROM pegawai p, gaji g ,bpjs_kesehatan bks, bpjs_ketenagakerjaan bkt\n" +
"WHERE p.id_tpegawai=g.id_tpegawai AND p.id_tpegawai=bks.id_tpegawai AND p.id_tpegawai=bkt.id_tpegawai";
           Statement stmt = con.connect().prepareStatement(sql);
           ResultSet res = stmt.executeQuery(sql);
           // Mengisi pegawaiTable dengan perulangan hasil dari Query
	    while (res.next()) {
                Cetak_laporan.addRow(new Object[]{
		res.getString(1),
		res.getString(2),
                res.getString(3),
                res.getString(4),
                res.getString(5),
		res.getString(6),
                res.getString(7),
                res.getString(8)}
	      );
            }
        } catch (Exception e) {
        }
     return Cetak_laporan;
    }
   
    public Serch_Cetak_laporan() {
        initComponents();
        Tabel_serch_laporan.setModel(viewData());
        viewData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabel_serch_laporan = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SERCH");

        Tabel_serch_laporan.setModel(new javax.swing.table.DefaultTableModel(
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
        Tabel_serch_laporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabel_serch_laporanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabel_serch_laporan);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Tabel_serch_laporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabel_serch_laporanMouseClicked
        // TODO add your handling code here:
       // Table_serch_bpjs src_bpjs = new Table_serch_bpjs();
        int tabelcetak = Tabel_serch_laporan.getSelectedRow();
        ct.nama = Tabel_serch_laporan.getValueAt(tabelcetak, 0).toString();
        ct.nik = Tabel_serch_laporan.getValueAt(tabelcetak, 1).toString();
        ct.jabatan = Tabel_serch_laporan.getValueAt(tabelcetak, 2).toString();
        ct.bpjs_kesehatan = Tabel_serch_laporan.getValueAt(tabelcetak, 3).toString();
        ct.bpjs_ketenagakerjaan = Tabel_serch_laporan.getValueAt(tabelcetak, 4).toString();
        ct.gajiPokok = Tabel_serch_laporan.getValueAt(tabelcetak, 5).toString();
        ct.uang_makan = Tabel_serch_laporan.getValueAt(tabelcetak, 6).toString();
        ct.sewa_motor = Tabel_serch_laporan.getValueAt(tabelcetak, 7).toString();
//     ct.golongan = Tabel_serch_laporan.getValueAt(tabelcetak, 2).toString();
//     ct.piutang = Tabel_serch_laporan.getValueAt(tabelcetak, 5).toString();                
        ct.itemDipilih();
        this.dispose();
    }//GEN-LAST:event_Tabel_serch_laporanMouseClicked

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
            java.util.logging.Logger.getLogger(Serch_Cetak_laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Serch_Cetak_laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Serch_Cetak_laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Serch_Cetak_laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Serch_Cetak_laporan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabel_serch_laporan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
