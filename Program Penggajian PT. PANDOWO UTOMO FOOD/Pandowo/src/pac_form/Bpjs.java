
package pac_form;

import config.Koneksi;
import java.awt.Image;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import pac_class.BpjsCRUD;

public class Bpjs extends javax.swing.JFrame {

    public BpjsCRUD bpjs = new BpjsCRUD();
    //deklarasi class Koneksi
    public Koneksi con = new Koneksi();
    //private DefaultTableModel model;
    public DefaultTableModel bpjstable;

    public void kosongkesehatan() {
        BpjsCRUD kesehatanid = new BpjsCRUD();

        try {
            TextField1_idkesehatan.setText(kesehatanid.idotomatisBPJS_Kesehatan());
            TextField1_idkesehatan.setEditable(false);
        } catch (SQLException ex) {
            Logger.getLogger(Bpjs.class.getName()).log(Level.SEVERE, null, ex);
        }
        TextField1_idkesehatan.setEditable(false);

        TextField_nama_bpjskesehatan.setText(null);
        TextField_nominal_bpjskesehatan.setText(null);
        TextField_nik_bpjskesehatan.setText(null);
        TextField_no_bpjskesehatan.setText(null);
        TextField_faskes_bpjskesehatan.setText(null);
        Button_INSERT.setVisible(true);
        Button_DELETE.setVisible(false);
        Button_UPDATE.setVisible(false);
//      jLabel_image.setIcon(null);
//      jLabel_location.setText("");

    }

    public void kosongketenagakerjaan() {
        BpjsCRUD ketenagakerjaanid = new BpjsCRUD();

        try {
            TextField_id_ketenagakerjaan.setText(ketenagakerjaanid.idotomatisBPJS_Ketenagakerjaan());
            TextField_id_ketenagakerjaan.setEditable(false);
        } catch (SQLException ex) {
            Logger.getLogger(Bpjs.class.getName()).log(Level.SEVERE, null, ex);
        }
        TextField_id_ketenagakerjaan.setEditable(false);

        TextField_nama_ketenagakerjaan.setText(null);
        TextField_nominal_ketenagakerjaan.setText(null);
        TextField_no_ketenagakerjaan.setText(null);       
        Button_INSERT.setVisible(true);
        Button_DELETE.setVisible(false);
        Button_UPDATE.setVisible(false);
    }

    public String nipserchbpjs, namaserchbpjs, idpegwaiserchbpjs, no_ktpserchbpjs, id_bpjskesehatan, no_bpjskesehatan,
            faskes_kesehatan, nominal_kesehatan, id_bpjsketenagakerjaan, no_bpjsketenagakerjaan, nominal_ketenagakerjaan;

    public String getNipbpjs() {
        return nipserchbpjs;
    }

    public String getNamabpjs() {
        return namaserchbpjs;
    }

    public String getIdpegawaibpjs() {
        return idpegwaiserchbpjs;
    }

    public String getno_ktpbpjs() {
        return no_ktpserchbpjs;
    }
    public String getIdbpjskesehatan(){
        return id_bpjskesehatan;
    }
    public String getNobpjskesehatan(){
        return no_bpjskesehatan;
    }
    public String getFaskesbpjskesehatan(){
        return faskes_kesehatan;
    }
    public String getNominalbpjskesehatan(){
        return nominal_kesehatan;
    }
    public String getIdbpjsketenagakerjaan(){
        return id_bpjsketenagakerjaan;
    }
    public String getNobpjsketenagakerjaan(){
        return no_bpjsketenagakerjaan;
    }
    public String getNominalbpjsketenagakerjaan(){
        return nominal_ketenagakerjaan;
    }

    public Bpjs() {
        initComponents();
        Table_bpjs.setModel(bpjs.tampilbpjs());
        bpjs.tampilbpjs();

        kosongketenagakerjaan();
        kosongkesehatan();
    }


    @SuppressWarnings("unchecked")
    public void itemTerpilih() {
//        Serch_gaji SG = new Serch_gaji();
//        SG.Bp = this;
//        TextField_nama_bpjskesehatan.setText(namaserchbpjs);
//        TextField_nama_ketenagakerjaan.setText(namaserchbpjs);
//        TextField_nik_bpjskesehatan.setText(no_ktpserchbpjs);
        // Text.setText(idpegwaiserch);
        Serch_bpjs SB = new Serch_bpjs();
        SB.Bp = this;
        TextField_id_tpegawai.setText(idpegwaiserchbpjs);
        TextField_nama_bpjskesehatan.setText(namaserchbpjs);
        TextField_nama_ketenagakerjaan.setText(namaserchbpjs);
        TextField_nik_bpjskesehatan.setText(no_ktpserchbpjs);
        TextField1_idkesehatan.setText(id_bpjskesehatan);
        TextField_no_bpjskesehatan.setText(no_bpjskesehatan);
        TextField_faskes_bpjskesehatan.setText(faskes_kesehatan);
        TextField_nominal_bpjskesehatan.setText(nominal_kesehatan);
        TextField_id_ketenagakerjaan.setText(id_bpjsketenagakerjaan);
        TextField_no_ketenagakerjaan.setText(no_bpjsketenagakerjaan);
        TextField_nominal_ketenagakerjaan.setText(nominal_ketenagakerjaan);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TextField_no_bpjskesehatan = new javax.swing.JTextField();
        TextField_nama_bpjskesehatan = new javax.swing.JTextField();
        TextField_nik_bpjskesehatan = new javax.swing.JTextField();
        TextField_nominal_bpjskesehatan = new javax.swing.JTextField();
        TextField_faskes_bpjskesehatan = new javax.swing.JTextField();
        TextField1_idkesehatan = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        TextField_no_ketenagakerjaan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        TextField_nama_ketenagakerjaan = new javax.swing.JTextField();
        TextField_nominal_ketenagakerjaan = new javax.swing.JTextField();
        Button_DELETE = new javax.swing.JButton();
        Button_UPDATE = new javax.swing.JButton();
        Button_INSERT = new javax.swing.JButton();
        TextField_id_ketenagakerjaan = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_bpjs = new javax.swing.JTable();
        TextField_cari = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        Button_load = new javax.swing.JButton();
        TextField_id_tpegawai = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 51), 7));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/BPJS Kesehatan .png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("NO BPJS");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("NAMA LENGKAP");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("NIK");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("FASKES");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("NOMINAL");

        TextField_no_bpjskesehatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_no_bpjskesehatanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextField_no_bpjskesehatan, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(TextField_faskes_bpjskesehatan)
                                .addComponent(TextField_nominal_bpjskesehatan, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TextField1_idkesehatan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TextField_nik_bpjskesehatan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TextField_nama_bpjskesehatan, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextField_nama_bpjskesehatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextField_nik_bpjskesehatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextField_no_bpjskesehatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(TextField_faskes_bpjskesehatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(TextField_nominal_bpjskesehatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextField1_idkesehatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 51), 7));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("NO BPJS");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("NAMA LENGKAP");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("NOMINAL");

        Button_DELETE.setBackground(new java.awt.Color(0, 153, 51));
        Button_DELETE.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Button_DELETE.setText("DELETE");
        Button_DELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_DELETEActionPerformed(evt);
            }
        });

        Button_UPDATE.setBackground(new java.awt.Color(0, 153, 0));
        Button_UPDATE.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Button_UPDATE.setText("UPDATE");
        Button_UPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_UPDATEActionPerformed(evt);
            }
        });

        Button_INSERT.setBackground(new java.awt.Color(0, 153, 0));
        Button_INSERT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Button_INSERT.setText("INSERT");
        Button_INSERT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_INSERTActionPerformed(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/BPJS Ketenagakerjaan.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 54, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextField_nominal_ketenagakerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextField_nama_ketenagakerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextField_no_ketenagakerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TextField_id_ketenagakerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(88, 88, 88))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(Button_INSERT, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Button_UPDATE)
                        .addGap(18, 18, 18)
                        .addComponent(Button_DELETE, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 130, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(TextField_nama_ketenagakerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TextField_no_ketenagakerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(TextField_nominal_ketenagakerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TextField_id_ketenagakerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_UPDATE)
                    .addComponent(Button_INSERT)
                    .addComponent(Button_DELETE))
                .addGap(22, 22, 22))
        );

        Table_bpjs.setModel(new javax.swing.table.DefaultTableModel(
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
        Table_bpjs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_bpjsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table_bpjs);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("SERCH");

        Button_load.setBackground(new java.awt.Color(0, 204, 51));
        Button_load.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Button_load.setText("LOAD ");
        Button_load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_loadActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 204, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 204, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("REFRESH");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Button_load)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TextField_id_tpegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addGap(22, 22, 22)
                        .addComponent(TextField_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_load)
                    .addComponent(TextField_id_tpegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(TextField_cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextField_no_bpjskesehatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_no_bpjskesehatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_no_bpjskesehatanActionPerformed

    private void Button_loadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_loadActionPerformed
        // TODO add your handling code here:
        Serch_bpjs SB = new Serch_bpjs();
        SB.Bp = this;
        SB.setVisible(true);
        SB.setResizable(false);
    }//GEN-LAST:event_Button_loadActionPerformed

    private void Button_UPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_UPDATEActionPerformed
        // TODO add your handling code here:
        try {
            bpjs.updatebpjskesehatan(TextField_id_tpegawai.getText(),
                    TextField_no_bpjskesehatan.getText(),
                    TextField_faskes_bpjskesehatan.getText(),
                    TextField_nominal_bpjskesehatan.getText(),
                    TextField1_idkesehatan.getText());

            JOptionPane.showMessageDialog(rootPane, "Data sedang diproses");
            //Table_bpjs.setModel(bpjs.tampilbpjs());
            //bersih();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "data gagaldirubah");
            Logger.getLogger(Bpjs.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            bpjs.updatebpjsketenagakerjaan(TextField_id_tpegawai.getText(),                    
                    TextField_nominal_ketenagakerjaan.getText(),
                    TextField_no_ketenagakerjaan.getText(),            
                    TextField_id_ketenagakerjaan.getText()); 
            JOptionPane.showMessageDialog(rootPane, "Data berhasil dirubah");
            Table_bpjs.setModel(bpjs.tampilbpjs());
        } catch (SQLException ex) {
            //JOptionPane.show
            JOptionPane.showMessageDialog(rootPane, "data gagaldirubah");
            Logger.getLogger(Bpjs.class.getName()).log(Level.SEVERE, null, ex);
            
        }   
    }//GEN-LAST:event_Button_UPDATEActionPerformed

    private void Button_INSERTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_INSERTActionPerformed
        // TODO add your handling code here:
//        try {
//            bpjs.insertbpjskes(TextField1_idkesehatan.getText(),
//                    TextField_id_tpegawai.getText(),
//                    TextField_no_bpjskesehatan.getText(),
//                    TextField_faskes_bpjskesehatan.getText(),
//                    TextField_nominal_bpjskesehatan.getText());
//
//            JOptionPane.showMessageDialog(rootPane, "Data bpjs kesehatan berhasil diproses");
//
//            //Table_bpjs.setModel(bpjs.tampilbpjs());
//            //bersih();
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(rootPane, "GAGAL");
//            Logger.getLogger(Bpjs.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        try {
//            bpjs.insertbpjsket(TextField_id_ketenagakerjaan.getText(),
//                    TextField_id_tpegawai.getText(),
//                    TextField_nominal_ketenagakerjaan.getText(),
//                    TextField_no_ketenagakerjaan.getText());
//
//            JOptionPane.showMessageDialog(rootPane, "Data berhasil disimpan");
//
//            Table_bpjs.setModel(bpjs.tampilbpjs());
//            //bersih();
//            kosongkesehatan();
//            kosongketenagakerjaan();
//
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(rootPane, "GAGAL");
//            Logger.getLogger(Bpjs.class.getName()).log(Level.SEVERE, null, ex);
//        }


try {
            bpjs.updatebpjskesehatan(TextField_id_tpegawai.getText(),
                    TextField_no_bpjskesehatan.getText(),
                    TextField_faskes_bpjskesehatan.getText(),
                    TextField_nominal_bpjskesehatan.getText(),
                    TextField1_idkesehatan.getText());

            JOptionPane.showMessageDialog(rootPane, "Data sedang diproses");
            //Table_bpjs.setModel(bpjs.tampilbpjs());
            //bersih();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "data gagaldirubah");
            Logger.getLogger(Bpjs.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            bpjs.updatebpjsketenagakerjaan(TextField_id_tpegawai.getText(),
                    TextField_no_ketenagakerjaan.getText(),
                    TextField_nominal_ketenagakerjaan.getText(),
                    
                    TextField_id_ketenagakerjaan.getText());  
            JOptionPane.showMessageDialog(rootPane, "Data sedang diproses");
            Table_bpjs.setModel(bpjs.tampilbpjs());
        } catch (SQLException ex) {
            //JOptionPane.show
            JOptionPane.showMessageDialog(rootPane, "data gagaldirubah");
            Logger.getLogger(Bpjs.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_Button_INSERTActionPerformed

    private void Table_bpjsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_bpjsMouseClicked
        // TODO add your handling code here:
        Button_INSERT.setVisible(false);
        Button_DELETE.setVisible(true);
        Button_UPDATE.setVisible(true);
        int kolom = 0;
        kolom = Table_bpjs.getSelectedRow();
        TextField_nama_bpjskesehatan.setText(Table_bpjs.getValueAt(kolom, 0).toString());
        TextField1_idkesehatan.setText(Table_bpjs.getValueAt(kolom, 3).toString());
        TextField_nik_bpjskesehatan.setText(Table_bpjs.getValueAt(kolom, 1).toString());
        TextField_no_bpjskesehatan.setText(Table_bpjs.getValueAt(kolom, 4).toString());
        TextField_faskes_bpjskesehatan.setText(Table_bpjs.getValueAt(kolom, 5).toString());
        TextField_nominal_bpjskesehatan.setText(Table_bpjs.getValueAt(kolom, 6).toString());
        TextField_id_ketenagakerjaan.setText(Table_bpjs.getValueAt(kolom, 7).toString());
        TextField_nama_ketenagakerjaan.setText(Table_bpjs.getValueAt(kolom, 0).toString());
        TextField_no_ketenagakerjaan.setText(Table_bpjs.getValueAt(kolom, 8).toString());
        TextField_nominal_ketenagakerjaan.setText(Table_bpjs.getValueAt(kolom, 9).toString());

        TextField_id_ketenagakerjaan.setEnabled(false);
        TextField1_idkesehatan.setEnabled(false);
        TextField_id_tpegawai.setEnabled(false);
        TextField_nama_bpjskesehatan.setEnabled(false);
        TextField_nama_ketenagakerjaan.setEnabled(false);
        TextField_nik_bpjskesehatan.setEnabled(false);

        try {
//            String[] hasilFunc = bpjs.ambildatapegawai_coba(Table_bpjs.getValueAt(kolom, 7).toString());
//            TextField_id_tpegawai.setText(hasilFunc[0]);
//            TextField_nama_bpjskesehatan.setText(hasilFunc[1]);
//            TextField_nik_bpjskesehatan.setText(hasilFunc[2]);

            TextField_id_tpegawai.setText(bpjs.ambildatapegawai(Table_bpjs.getValueAt(kolom, 7).toString()));
            //TextField_nama_bpjskesehatan.setText(bpjs.ambildatapegawai(Table_bpjs.getValueAt(kolom, 3).toString()));
            //TextField_nik_bpjskesehatan.setText(bpjs.ambildatapegawai(Table_bpjs.getValueAt(kolom, 3).toString()));
            //TextField_nama_bpjskesehatan.setText(bpjs.ambildatapegawai(Table_bpjs.getValueAt(kolom, 1).toString()));
            //TextField_nama_ketenagakerjaan.setText(bpjs.ambildatapegawai(Table_bpjs.getValueAt(kolom, 1).toString()));
        } catch (SQLException ex) {
            Logger.getLogger(Bpjs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Table_bpjsMouseClicked

    private void Button_DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_DELETEActionPerformed
        // TODO add your handling code here:
        String ObjButtons[] = {"Yes", "No"};
        int PromptResult = JOptionPane.showOptionDialog(null, "yakin Mau Hapus ?", "Massage", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, ObjButtons, ObjButtons[1]);
        if (PromptResult == 0) {

            try {
                bpjs.deletekesehatan(TextField1_idkesehatan.getText());
                JOptionPane.showMessageDialog(rootPane, "Data berhasil diproses");
                Table_bpjs.setModel(bpjs.tampilbpjs());
                //kosong();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "data gagal dihapus");
                Logger.getLogger(Bpjs.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                bpjs.deleteketenagakerjaan(TextField_id_ketenagakerjaan.getText());
                JOptionPane.showMessageDialog(rootPane, "Data berhasil dihapus");
                Table_bpjs.setModel(bpjs.tampilbpjs());
                //kosong();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "data gagal dihapus");
                Logger.getLogger(Bpjs.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_Button_DELETEActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose(); //kode jbutton2 / panggil form lain
        new Menu_Utama().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         Table_bpjs.setModel(bpjs.tampilbpjs());
        bpjs.tampilbpjs();

        kosongketenagakerjaan();
        kosongkesehatan();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Bpjs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bpjs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bpjs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bpjs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bpjs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_DELETE;
    private javax.swing.JButton Button_INSERT;
    private javax.swing.JButton Button_UPDATE;
    private javax.swing.JButton Button_load;
    private javax.swing.JTable Table_bpjs;
    private javax.swing.JTextField TextField1_idkesehatan;
    private javax.swing.JTextField TextField_cari;
    private javax.swing.JTextField TextField_faskes_bpjskesehatan;
    private javax.swing.JTextField TextField_id_ketenagakerjaan;
    private javax.swing.JTextField TextField_id_tpegawai;
    private javax.swing.JTextField TextField_nama_bpjskesehatan;
    private javax.swing.JTextField TextField_nama_ketenagakerjaan;
    private javax.swing.JTextField TextField_nik_bpjskesehatan;
    private javax.swing.JTextField TextField_no_bpjskesehatan;
    private javax.swing.JTextField TextField_no_ketenagakerjaan;
    private javax.swing.JTextField TextField_nominal_bpjskesehatan;
    private javax.swing.JTextField TextField_nominal_ketenagakerjaan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
