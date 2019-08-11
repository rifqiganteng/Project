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
import pac_class.PegawaiCRUD;
import pac_class.GajiCRUD;
import pac_class.BpjsCRUD;
import pac_class.PiutangCRUD;

/**
 *
 * @author amanullah
 */
public class Pegawai extends javax.swing.JFrame {

    //mendeklarasikan kelas piutang
    public PiutangCRUD piutang = new PiutangCRUD();
//mendeklarasikan kelas gaji
    public GajiCRUD gaji = new GajiCRUD();
//mendeklarasikan kelas bpjs
    public BpjsCRUD bpjs = new BpjsCRUD();
//mendeklarasikan kelas pegawai
    public PegawaiCRUD peg = new PegawaiCRUD();
//deklarasi class Koneksi
    public Koneksi con = new Koneksi();
//private DefaultTableModel model;
    public DefaultTableModel pegawaitaTable;

    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(jLabel_image.getWidth(), jLabel_image.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

//Method Untuk Menyaring Huruf
    public void FilterHuruf(KeyEvent a) {
        if (Character.isDigit(a.getKeyChar())) {
            a.consume();
            //Pesan Dialog Boleh Di Hapus Ini Hanya Sebagai Contoh
            JOptionPane.showMessageDialog(null, "Masukan Hanya Huruf", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }

    //Method Untuk Menyaring Angka
    public void FilterAngka(KeyEvent b) {
        if (Character.isAlphabetic(b.getKeyChar())) {
            b.consume();
            //Pesan Dialog Boleh Di Hapus Ini Hanya Sebagai Contoh
            JOptionPane.showMessageDialog(null, "Masukan Hanya Angka", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void kosong() {
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        dateChooserCombo_lahir.setDateFormat(dt);
        dateChooserCombo_masuk.setDateFormat(dt);
        PegawaiCRUD pegid = new PegawaiCRUD();

        try {
            text_id.setText(pegid.idotomatis());
            text_id.setEditable(false);
            TextField_id_gaji.setText(gaji.idotomatis());
            TextField_id_gaji.setEditable(false);
            TextField_id_kesehatan.setText(bpjs.idotomatisBPJS_Kesehatan());
            TextField_id_kesehatan.setEditable(false);
            TextField_id_ketenagakerjaan.setText(bpjs.idotomatisBPJS_Ketenagakerjaan());
            TextField_id_ketenagakerjaan.setEditable(false);
            TextField_id_piutang.setText(piutang.idotomatis());
            TextField_id_piutang.setEditable(false);
        } catch (SQLException ex) {
            Logger.getLogger(Pegawai.class.getName()).log(Level.SEVERE, null, ex);
        }
        text_id.setEditable(false);
        ComboBox_agama.setSelectedIndex(0);
        ComboBox_bagian.setSelectedItem(0);
        ComboBox_darah.setSelectedItem(0);
        ComboBox_jabatan.setSelectedItem(0);
        ComboBox_status.setSelectedItem(0);

        text_nama.setText(null);
        TextArea_alamat.setText(null);
        TextField_ktp.setText(null);
        TextField_nip.setText(null);
        TextField_tlp.setText(null);
        TextField_pendidikan.setText(null);
        TextArea_sementara.setText(null);
        Button_create.setVisible(true);
        Button_delete.setVisible(false);
        Button_update.setVisible(false);
        jLabel_image.setIcon(null);
        jLabel_location.setText("");

    }

    public Pegawai() {
        initComponents();
        kosong();

        Table_pegawai.setModel(peg.tampil());
        peg.tampil();

        buttonGroup_jk_pegawai.add(RadioButton_laki);
        buttonGroup_jk_pegawai.add(RadioButton_perempuan);
        RadioButton_laki.setSelected(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        buttonGroup_jk_pegawai = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_pegawai = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        text_id = new javax.swing.JTextField();
        text_nama = new javax.swing.JTextField();
        TextField_ktp = new javax.swing.JTextField();
        TextField_tlp = new javax.swing.JTextField();
        ComboBox_agama = new javax.swing.JComboBox<>();
        TextField_pendidikan = new javax.swing.JTextField();
        TextField_nip = new javax.swing.JTextField();
        TextField_Serch = new javax.swing.JTextField();
        ComboBox_bagian = new javax.swing.JComboBox<>();
        ComboBox_jabatan = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        TextArea_alamat = new javax.swing.JTextArea();
        Button_create = new javax.swing.JButton();
        Button_delete = new javax.swing.JButton();
        Button_update = new javax.swing.JButton();
        RadioButton_laki = new javax.swing.JRadioButton();
        RadioButton_perempuan = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        ComboBox_status = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel_image = new javax.swing.JLabel();
        buttonadd_emage = new javax.swing.JButton();
        jLabel_location = new javax.swing.JLabel();
        ComboBox_darah = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        dateChooserCombo_lahir = new datechooser.beans.DateChooserCombo();
        dateChooserCombo_masuk = new datechooser.beans.DateChooserCombo();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TextArea_sementara = new javax.swing.JTextArea();
        jLabel18 = new javax.swing.JLabel();
        TextField_id_gaji = new javax.swing.JTextField();
        TextField_id_kesehatan = new javax.swing.JTextField();
        TextField_id_ketenagakerjaan = new javax.swing.JTextField();
        TextField_id_piutang = new javax.swing.JTextField();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(46, 68, 92));

        Table_pegawai.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        Table_pegawai.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Table_pegawai.setModel(new javax.swing.table.DefaultTableModel(
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
        Table_pegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_pegawaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table_pegawai);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nama");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Jenis Kelamin");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nomor KTP");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tanggal Lahir");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nomor Telepon");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Agama");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Pendidikan");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Status");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("NIP");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Tanggal Masuk");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Bagian");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Jabatan");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Alamat Asal");

        text_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_idActionPerformed(evt);
            }
        });

        text_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_namaActionPerformed(evt);
            }
        });
        text_nama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                text_namaKeyTyped(evt);
            }
        });

        TextField_ktp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_ktpActionPerformed(evt);
            }
        });
        TextField_ktp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextField_ktpKeyTyped(evt);
            }
        });

        TextField_tlp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_tlpActionPerformed(evt);
            }
        });
        TextField_tlp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextField_tlpKeyTyped(evt);
            }
        });

        ComboBox_agama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH AGAMA", "Islam", "Kristen", "Hindu", "Budha", " " }));
        ComboBox_agama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_agamaActionPerformed(evt);
            }
        });

        TextField_pendidikan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_pendidikanActionPerformed(evt);
            }
        });
        TextField_pendidikan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextField_pendidikanKeyTyped(evt);
            }
        });

        TextField_nip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_nipActionPerformed(evt);
            }
        });
        TextField_nip.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextField_nipKeyTyped(evt);
            }
        });

        TextField_Serch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_SerchActionPerformed(evt);
            }
        });
        TextField_Serch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TextField_SerchKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextField_SerchKeyTyped(evt);
            }
        });

        ComboBox_bagian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH BAGIAN", "Pusat", "Distribusi Jawa Tengah", "Distribusi Jawa Barat", "Distribusi Jogja", "Distribusi Purwakarta", "Distribusi Purwokerto", "Produksi Gendro", "Produksi KIW" }));

        ComboBox_jabatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH JABATAN", "Kepala Cabang", "Kabag ADM", "Kepala Kendaraan", "Sales Supervisor", "Sales Force", "Driver", "Helper", "OB", "General Manager", "Finance and Acounting Manager", "Manager IT", "Staff IT", "Staff Audit", "Stuff Pajak", "Staff HRD", "Staff GA", "Staff GM", "Staff Kasir Pusat", "Staff Logistik", "SPV Audit", "SPV Pajak", "Admin Kasir", "Admin Gudang", "Admin Penjualan", "Admin Pajak", "Scurity" }));

        TextArea_alamat.setColumns(20);
        TextArea_alamat.setRows(5);
        TextArea_alamat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextArea_alamatKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(TextArea_alamat);

        Button_create.setBackground(new java.awt.Color(242, 38, 19));
        Button_create.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Button_create.setText("CREATE");
        Button_create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_createActionPerformed(evt);
            }
        });

        Button_delete.setBackground(new java.awt.Color(0, 230, 64));
        Button_delete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Button_delete.setText("DELETE");
        Button_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_deleteActionPerformed(evt);
            }
        });

        Button_update.setBackground(new java.awt.Color(247, 202, 24));
        Button_update.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Button_update.setText("UPDATE");
        Button_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_updateActionPerformed(evt);
            }
        });

        RadioButton_laki.setText("Laki - Laki");

        RadioButton_perempuan.setText("Perempuan");
        RadioButton_perempuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButton_perempuanActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(29, 188, 73));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jButton2.setBackground(new java.awt.Color(242, 38, 19));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\RIFQI\\Pictures\\close png 20.png")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        ComboBox_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH SETATUS", "Menikah", "Belum Menikah", " " }));

        jPanel3.setBackground(new java.awt.Color(0, 230, 64));
        jPanel3.setForeground(new java.awt.Color(0, 230, 64));

        jLabel_image.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_image, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_image, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                .addContainerGap())
        );

        buttonadd_emage.setBackground(new java.awt.Color(247, 202, 24));
        buttonadd_emage.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonadd_emage.setText("Load");
        buttonadd_emage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonadd_emageActionPerformed(evt);
            }
        });

        jLabel_location.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_location.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_location.setText("Location");

        ComboBox_darah.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH", "A", "B", "AB", "O", "" }));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Golongan Darah");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Alamat Sementara");

        TextArea_sementara.setColumns(20);
        TextArea_sementara.setRows(5);
        TextArea_sementara.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextArea_sementaraKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(TextArea_sementara);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("SERCH");

        TextField_id_kesehatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_id_kesehatanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(213, 213, 213)
                                        .addComponent(buttonadd_emage, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(Button_create, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(34, 34, 34)
                                                .addComponent(Button_update, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(35, 35, 35)
                                                .addComponent(Button_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel3)
                                                    .addComponent(jLabel2)
                                                    .addComponent(jLabel1)
                                                    .addComponent(jLabel5)
                                                    .addComponent(jLabel7)
                                                    .addComponent(jLabel6))
                                                .addGap(32, 32, 32)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(dateChooserCombo_lahir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(RadioButton_laki, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(RadioButton_perempuan, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(TextField_tlp, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(TextField_ktp, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(text_nama, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(text_id, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel8)
                                                    .addGap(68, 68, 68))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel13)
                                                        .addComponent(jLabel10)
                                                        .addComponent(jLabel9)
                                                        .addComponent(jLabel11))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(ComboBox_status, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TextField_nip, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TextField_pendidikan, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ComboBox_agama, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ComboBox_bagian, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dateChooserCombo_masuk, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(37, 37, 37))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18)
                                .addComponent(TextField_Serch, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(TextField_id_gaji, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TextField_id_kesehatan, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TextField_id_ketenagakerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TextField_id_piutang, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_location)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel16)
                                            .addComponent(jLabel14))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(ComboBox_darah, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(ComboBox_jabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel15)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1348, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ComboBox_jabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ComboBox_darah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16)))
                        .addGap(11, 11, 11)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(ComboBox_agama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TextField_pendidikan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ComboBox_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ComboBox_bagian, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(8, 8, 8)
                                        .addComponent(TextField_nip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dateChooserCombo_masuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel2)
                                        .addGap(11, 11, 11)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel6)
                                        .addGap(9, 9, 9)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel5))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(text_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(text_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(RadioButton_laki)
                                            .addComponent(RadioButton_perempuan))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(dateChooserCombo_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TextField_tlp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TextField_ktp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(buttonadd_emage, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(47, 47, 47)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(Button_update, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Button_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Button_create, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12)))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextField_id_gaji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(TextField_Serch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextField_id_kesehatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextField_id_ketenagakerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextField_id_piutang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel_location, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1389, 727));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonadd_emageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonadd_emageActionPerformed
        // TODO add your handling code here:
        JFileChooser OpenFile = new JFileChooser();
        OpenFile.showOpenDialog(null);
        File x_file = OpenFile.getSelectedFile();

        String fileLocation = x_file.getAbsolutePath();

        jLabel_location.setText(fileLocation);

        //Set Icon Label dengan gambar yg di pilih
        jLabel_image.setIcon(ResizeImage(fileLocation));
    }//GEN-LAST:event_buttonadd_emageActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        this.dispose(); //kode jbutton2 / panggil form lain
        new Menu_Utama().setVisible(true);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void RadioButton_perempuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButton_perempuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioButton_perempuanActionPerformed

    private void Button_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_updateActionPerformed
        // TODO add your handling code here:
        String gender = null;
        if (RadioButton_laki.isSelected() == true) {
            gender = "laki-laki";
        } else {
            gender = "perempuan";
        }
        try {

        } catch (Exception e) {
        }
        try {
            peg.Updatepegawai(text_nama.getText(),
                    gender,
                    TextField_ktp.getText(),
                    dateChooserCombo_lahir.getText(),
                    TextField_tlp.getText(),
                    ComboBox_agama.getSelectedItem().toString(),
                    TextField_pendidikan.getText(),
                    ComboBox_status.getSelectedItem().toString(),
                    TextField_nip.getText(),
                    dateChooserCombo_masuk.getText(),
                    ComboBox_bagian.getSelectedItem().toString(),
                    ComboBox_jabatan.getSelectedItem().toString(),
                    TextArea_alamat.getText(),
                    jLabel_location.getText(),
                    ComboBox_darah.getSelectedItem().toString(),
                    TextArea_sementara.getText(),
                    text_id.getText());
            JOptionPane.showMessageDialog(rootPane, "Data berhasil dirubah");
            Table_pegawai.setModel(peg.tampil());
            kosong();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "data gagaldirubah");
            Logger.getLogger(Pegawai.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Button_updateActionPerformed

    private void Button_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_deleteActionPerformed
        // TODO add your handling code here:
        String gender = null;
        String ObjButtons[] = {"Yes", "No"};
        int PromptResult = JOptionPane.showOptionDialog(null, "yakin Mau Hapus ?", "Massage", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, ObjButtons, ObjButtons[1]);
        if (PromptResult == 0) {

            try {
                peg.hapus(text_id.getText());
                JOptionPane.showMessageDialog(rootPane, "Data berhasil dihapus");
                Table_pegawai.setModel(peg.tampil());
                kosong();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "data gagal dihapus");
                Logger.getLogger(Pegawai.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_Button_deleteActionPerformed

    private void Button_createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_createActionPerformed

        String gender = null;
        if (RadioButton_laki.isSelected() == true) {
            gender = "laki-laki";
        } else {
            gender = "perempuan";
        }
        try {
            peg.insertpegawai(text_id.getText(),
                    text_nama.getText(),
                    gender,
                    TextField_ktp.getText(),
                    dateChooserCombo_lahir.getText(),
                    TextField_tlp.getText(),
                    ComboBox_agama.getSelectedItem().toString(),
                    TextField_pendidikan.getText(),
                    ComboBox_status.getSelectedItem().toString(),
                    //TextField_status.getText(),
                    TextField_nip.getText(),
                    dateChooserCombo_masuk.getText(),
                    ComboBox_bagian.getSelectedItem().toString(),
                    ComboBox_jabatan.getSelectedItem().toString(),
                    TextArea_alamat.getText(),
                    jLabel_location.getText(),
                    ComboBox_darah.getSelectedItem().toString(),
                    TextArea_sementara.getText());

            JOptionPane.showMessageDialog(rootPane, "Data berhasil disimpan");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "GAGAL");
            Logger.getLogger(Pegawai.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            gaji.insergaji(TextField_id_gaji.getText(),
                    text_id.getText(),
                    "0",
                    "0",
                    "0",
                    "0",
                    "0");
            JOptionPane.showMessageDialog(rootPane, "ATUR NOMINAL GAJI DI MENU GAJI");
//            Table_pegawai.setModel(peg.tampil());
//            kosong();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Data Gagal Diproses");
            Logger.getLogger(Pegawai.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            bpjs.insertbpjskes(TextField_id_kesehatan.getText(),
                    text_id.getText(),
                    "0",
                    "-",
                    "0");
            JOptionPane.showMessageDialog(rootPane, "ATUR NOMINAL BPJS KESEHATAN");
//            Table_pegawai.setModel(peg.tampil());
//            kosong();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Data Gagal Diproses");
            Logger.getLogger(Pegawai.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            bpjs.insertbpjsket(TextField_id_ketenagakerjaan.getText(),
                    text_id.getText(),
                    "0",
                    "0");
            JOptionPane.showMessageDialog(rootPane, "ATUR NOMINAL BPJS KETENAGAKERJAAN");
            //Table_pegawai.setModel(peg.tampil());
            //kosong();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Data Gagal Diproses");
            Logger.getLogger(Pegawai.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            piutang.insertPiutang(TextField_id_piutang.getText(),
                    text_id.getText(),
                    "0",
                    dateChooserCombo_masuk.getText(),
                    "0",
                    "0");
            JOptionPane.showMessageDialog(rootPane, "PEGAWAI BELUM MEMILIKI PIUTANG");
            Table_pegawai.setModel(peg.tampil());
            kosong();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Data Gagal Diproses");
            Logger.getLogger(Pegawai.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_Button_createActionPerformed

    private void TextField_SerchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextField_SerchKeyTyped
        // TODO add your handling code here:
        FilterHuruf(evt);
        if (TextField_Serch.getText() == "" || TextField_Serch.getText() == " ") {
            Table_pegawai.setModel(peg.tampil());
        } else {
            Table_pegawai.setModel(peg.cariByName(TextField_Serch.getText()));
        }
    }//GEN-LAST:event_TextField_SerchKeyTyped

    private void TextField_nipKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextField_nipKeyTyped
        if (TextField_nip.getText().length() == 20) {
            evt.consume();
        }// TODO add your handling code here:
        FilterAngka(evt);
    }//GEN-LAST:event_TextField_nipKeyTyped

    private void ComboBox_agamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_agamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBox_agamaActionPerformed

    private void TextField_tlpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextField_tlpKeyTyped
        // TODO add your handling code here:
//        public void JumlahKarakter(KeyEvent e) {
//        if (karakter.getText().length() == 8) {
//            e.consume();
//            //Pesan Dialog Boleh Di Hapus Ini Hanya Sebagai Contoh
//            JOptionPane.showMessageDialog(null, "Maksimal yang dimasukan Hanya 8 Karakter", "Peringatan", JOptionPane.WARNING_MESSAGE);
//        }
//    }
        if (TextField_tlp.getText().length() == 12) {
            evt.consume();
        }
        FilterAngka(evt);

    }//GEN-LAST:event_TextField_tlpKeyTyped

    private void TextField_ktpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextField_ktpKeyTyped
        // TODO add your handling code here:
        if (TextField_ktp.getText().length() == 16) {
            evt.consume();
        }
        FilterAngka(evt);
    }//GEN-LAST:event_TextField_ktpKeyTyped

    private void text_namaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_namaKeyTyped
        // TODO add your handling code here:

        FilterHuruf(evt);
    }//GEN-LAST:event_text_namaKeyTyped

    private void Table_pegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_pegawaiMouseClicked
        String pattern = "yyyy-MM-dd";
        DateFormat format = new SimpleDateFormat(pattern);
        Button_create.setVisible(false);
        Button_delete.setVisible(true);
        Button_update.setVisible(true);
        int kolom = 0;
        kolom = Table_pegawai.getSelectedRow();
        text_id.setText(Table_pegawai.getValueAt(kolom, 0).toString());
        text_nama.setText(Table_pegawai.getValueAt(kolom, 1).toString());
        if (Table_pegawai.getValueAt(kolom, 2).toString().equals("laki-laki")) {
            RadioButton_laki.setSelected(true);
        } else {
            RadioButton_perempuan.setSelected(true);
        }
        TextField_ktp.setText(Table_pegawai.getValueAt(kolom, 3).toString());
        dateChooserCombo_lahir.setDateFormat(format);
        String dateInString = Table_pegawai.getValueAt(kolom, 4).toString();
        Date date = null;
        try {
            date = format.parse(dateInString);
        } catch (ParseException ex) {
            Logger.getLogger(Pegawai.class.getName()).log(Level.SEVERE, null, ex);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        dateChooserCombo_lahir.setSelectedDate(calendar);
        dateChooserCombo_lahir.setText(Table_pegawai.getValueAt(kolom, 4).toString());
        TextField_tlp.setText(Table_pegawai.getValueAt(kolom, 5).toString());
        ComboBox_agama.setSelectedItem(Table_pegawai.getValueAt(kolom, 6).toString());
        TextField_pendidikan.setText(Table_pegawai.getValueAt(kolom, 7).toString());
        TextField_nip.setText(Table_pegawai.getValueAt(kolom, 9).toString());
        ComboBox_status.setSelectedItem(Table_pegawai.getValueAt(kolom, 8).toString());
        //TextField_status.setText(Table_pegawai.getValueAt(kolom, 8).toString());
        System.out.println("tanggal" + Table_pegawai.getValueAt(kolom, 10).toString());
        dateChooserCombo_masuk.setText(Table_pegawai.getValueAt(kolom, 10).toString());
        dateChooserCombo_masuk.setDateFormat(format);
        String dateInString1 = Table_pegawai.getValueAt(kolom, 10).toString();
        jLabel_image.setIcon(ResizeImage(Table_pegawai.getValueAt(kolom, 14).toString()));
        jLabel_location.setText(Table_pegawai.getValueAt(kolom, 14).toString());
        ComboBox_darah.setSelectedItem(Table_pegawai.getValueAt(kolom, 15).toString());
        TextArea_sementara.setText(Table_pegawai.getValueAt(kolom, 16).toString());
        Date date1 = null;
        try {
            date1 = format.parse(dateInString1);
        } catch (ParseException ex) {
            Logger.getLogger(Pegawai.class.getName()).log(Level.SEVERE, null, ex);
        }
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);
        dateChooserCombo_masuk.setSelectedDate(calendar1);
        ComboBox_bagian.setSelectedItem(Table_pegawai.getValueAt(kolom, 11).toString());
        ComboBox_jabatan.setSelectedItem(Table_pegawai.getValueAt(kolom, 12).toString());
        TextArea_alamat.setText(Table_pegawai.getValueAt(kolom, 13).toString());
        TextField_id_gaji.setText(Table_pegawai.getValueAt(kolom, 17).toString());
        TextField_id_kesehatan.setText(Table_pegawai.getValueAt(kolom, 18).toString());
        TextField_id_ketenagakerjaan.setText(Table_pegawai.getValueAt(kolom, 19).toString());
        TextField_id_piutang.setText(Table_pegawai.getValueAt(kolom, 20).toString());
        text_id.setEnabled(false);
        //System.out.println("tanggal" +Table_pegawai.getValueAt(kolom, 4).toString());
        //String pattern = "yyyy-MM-dd";
        //DateFormat format = new SimpleDateFormat(pattern);
        //String dateInString = Table_pegawai.getValueAt(kolom, 4).toString();
        //dateChooserCombo_lahir.setDateFormat((Table_pegawai.getValueAt(kolom, 4).toString()));
        //jDateChooser1.setDate(Table_pegawai.getValueAt(kolom, 4).toString());
        //dateChooserCombo_lahir.setDate(Table_pegawai(kolom, 2));
        //dateChooserCombo_lahir.setDateFormat((Table_pegawai.getValueAt(kolom, 4).toString()));
        //String dateInString = Table_pegawai.getValueAt(kolom, 4).toString();
        //jLabel_image.setse
        //Set Icon Label dengan gambar yg di pilih
        //SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        //dateChooserCombo_lahir.setDateFormat(dt);
        //dateChooserCombo_masuk.setDateFormat(dt);
        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_Table_pegawaiMouseClicked

    private void TextField_nipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_nipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_nipActionPerformed

    private void TextField_SerchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_SerchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_SerchActionPerformed

    private void TextField_SerchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextField_SerchKeyPressed
        // TODO add your handling code here:
//        if (TextField_status.getText()=="" || TextField_status.getText()==" "){
//             Table_pegawai.setModel(peg.tampil());
//       }
//        else
//        {
//            Table_pegawai.setModel(peg.cariByName(TextField_status.getText())); 
//           }
    }//GEN-LAST:event_TextField_SerchKeyPressed

    private void text_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_idActionPerformed

    private void TextField_tlpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_tlpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_tlpActionPerformed

    private void TextField_ktpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_ktpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_ktpActionPerformed

    private void TextField_pendidikanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextField_pendidikanKeyTyped
        // TODO add your handling code here:
        if (TextField_pendidikan.getText().length() == 40) {
            evt.consume();
        }

    }//GEN-LAST:event_TextField_pendidikanKeyTyped

    private void TextArea_sementaraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextArea_sementaraKeyTyped
        if (TextArea_sementara.getText().length() > 80) {  // --- 80 adalah jumlah karakter yang saya inginkan
            // Your Command, for examples :
            JOptionPane.showMessageDialog(null, "Maaf Kalimat Terlalu Panjang !!!!"); // --- Memunculkan Pesan ke User
            evt.consume(); // --- Karakter tidak akan di Input
        }
    }//GEN-LAST:event_TextArea_sementaraKeyTyped

    private void TextArea_alamatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextArea_alamatKeyTyped
        // TODO add your handling code here:
        if (TextArea_alamat.getText().length() == 80) {
            JOptionPane.showMessageDialog(null, "Maaf Klimat Terlalu Panjang !!!");
            evt.consume();
        }
    }//GEN-LAST:event_TextArea_alamatKeyTyped

    private void TextField_pendidikanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_pendidikanActionPerformed
        // TODO add your handling code here:
//        if (TextField_pendidikan.getText().length() == 40) {
//         JOptionPane.showMessageDialog(null,"Maaf Klimat Terlalu Panjang !!!");
//         evt.consume();
//        }
    }//GEN-LAST:event_TextField_pendidikanActionPerformed

    private void text_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_namaActionPerformed

    private void TextField_id_kesehatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_id_kesehatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_id_kesehatanActionPerformed

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
            java.util.logging.Logger.getLogger(Pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pegawai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_create;
    private javax.swing.JButton Button_delete;
    private javax.swing.JButton Button_update;
    private javax.swing.JComboBox<String> ComboBox_agama;
    private javax.swing.JComboBox<String> ComboBox_bagian;
    private javax.swing.JComboBox<String> ComboBox_darah;
    private javax.swing.JComboBox<String> ComboBox_jabatan;
    private javax.swing.JComboBox<String> ComboBox_status;
    private javax.swing.JRadioButton RadioButton_laki;
    private javax.swing.JRadioButton RadioButton_perempuan;
    private javax.swing.JTable Table_pegawai;
    private javax.swing.JTextArea TextArea_alamat;
    private javax.swing.JTextArea TextArea_sementara;
    private javax.swing.JTextField TextField_Serch;
    private javax.swing.JTextField TextField_id_gaji;
    private javax.swing.JTextField TextField_id_kesehatan;
    private javax.swing.JTextField TextField_id_ketenagakerjaan;
    private javax.swing.JTextField TextField_id_piutang;
    private javax.swing.JTextField TextField_ktp;
    private javax.swing.JTextField TextField_nip;
    private javax.swing.JTextField TextField_pendidikan;
    private javax.swing.JTextField TextField_tlp;
    private javax.swing.ButtonGroup buttonGroup_jk_pegawai;
    private javax.swing.JButton buttonadd_emage;
    private datechooser.beans.DateChooserCombo dateChooserCombo_lahir;
    private datechooser.beans.DateChooserCombo dateChooserCombo_masuk;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_image;
    private javax.swing.JLabel jLabel_location;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField text_id;
    private javax.swing.JTextField text_nama;
    // End of variables declaration//GEN-END:variables
}
