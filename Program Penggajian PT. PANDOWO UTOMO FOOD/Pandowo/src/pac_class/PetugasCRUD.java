/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pac_class;

//import com.sun.xml.internal.ws.policy.sourcemodel.ModelNode;
import java.sql.PreparedStatement;
import config.Koneksi;
//import java.awt.TextField;
//import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import javax.management.Query;
//import javax.swing.JOptionPane;
//import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//import pac_form.Petugas;

public class PetugasCRUD {

    Koneksi con = new Koneksi();

    public void insertPetugas(String id, String nama, String jenis_kel, String username, String password, String hak_akses, String alamat) throws SQLException {
        PreparedStatement stmt = null;
        String query = "INSERT INTO petugas(id,nama,jenis_kel,username,password,hak_akses,alamat)VALUE(?,?,?,?,?,?,?)";
        try {
            stmt = con.connect().prepareStatement(query);
            stmt.setString(1, id);
            stmt.setString(2, nama);
            stmt.setString(3, jenis_kel);
            stmt.setString(4, username);
            stmt.setString(5, password);
            stmt.setString(6, hak_akses);
            stmt.setString(7, alamat);
            stmt.executeUpdate();

            System.out.println("Data Berhasil Disimpan");

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            con.connect().close();
        }
    }

    //ini buat rubah
    //static Koneksi con = new Koneksi();
    public void UpdatePetugas(String id, String nama, String jenis_kel, String username, String password, String hak_akses, String alamat) throws SQLException {
        PreparedStatement stmt = null;
        String query = "UPDATE petugas set nama=?,jenis_kel=?,username=?,password=?,hak_akses=?,alamat=? where id=?";

        try {
            stmt = con.connect().prepareStatement(query);
            stmt.setString(1, id);
            stmt.setString(2, nama);
            stmt.setString(3, jenis_kel);
            stmt.setString(4, username);
            stmt.setString(5, password);
            stmt.setString(6, hak_akses);
            stmt.setString(7, alamat);

            stmt.executeUpdate();

            System.out.println("Data Berhasil Diupdate");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            con.connect().close();
        }
    }

    public void hapus(String id) throws SQLException {
        PreparedStatement stmt = null;
        String query = "delete from petugas where id=?";

        try {
            stmt = con.connect().prepareStatement(query);
            stmt.setString(1, id);
            stmt.executeUpdate();

            System.out.println("Data Berhasil Dihapus");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            con.connect().close();
        }

    }
    //untuk id otomatis

    public String getNewId() throws SQLException {

        int max_id = 1;
        String new_id = "";

        Statement stmt = null;
        ResultSet rs = null;

        String query = "select max(substring_index(id,'PET',-1)) as id_max from petugas";

        try {
            stmt = con.connect().prepareStatement(query);

            rs = stmt.executeQuery(query);

            while (rs.next()) {
                max_id = rs.getInt("id_max") + 1;
            }
            new_id = "PET" + max_id;

        } catch (SQLException ex) {
            System.err.println("error " + ex.getMessage());
            new_id = "PET" + max_id;
        } finally {
            con.connect().close();
        }
        System.err.println("-- > " + new_id);
        return new_id;
    }

    public DefaultTableModel viewData() {
        // COBA DEKLARE DI DALAM METHOD

        //public Petugas petugas = new Petugas();
        //static Koneksi con = new Koneksi();
        DefaultTableModel petugastable = new DefaultTableModel();
        petugastable.addColumn("ID");
        petugastable.addColumn("NAMA");
        petugastable.addColumn("JENIS KELAMIN");
        petugastable.addColumn("USERNAME");
        petugastable.addColumn("PASSWORD");
        petugastable.addColumn("HAK AKSES");
        petugastable.addColumn("ALAMAT");

        try {
            String sql = "select * from petugas";
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
                    res.getString(7)}
                ); //APAKAH INI SAMPAH? ATAU ADA FUNGSINYA?
            }
        } catch (Exception e) {
        }
        return petugastable;
    }
}
