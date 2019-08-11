package pac_class;

import java.sql.PreparedStatement;
import config.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class PiutangCRUD {

    Koneksi con = new Koneksi();

    public void insertPiutang(String id_piutang, String id_tpegawai, String nominal_sebelum, String tanggal, String nominal_sesudah, String jumlah_piutang) throws Exception {
        PreparedStatement stmt = null;
        String query = "INSERT INTO piutang (id_piutang,id_tpegawai,nominal_sebelum,tanggal,nominal_sesudah,jumlah_piutang) VALUE(?,?,?,?,?,?)";
        try {
            stmt = con.connect().prepareStatement(query);
            stmt.setString(1, id_piutang);
            stmt.setString(2, id_tpegawai);
            stmt.setString(3, nominal_sebelum);
            stmt.setString(4, tanggal);
            stmt.setString(5, nominal_sesudah);
            stmt.setString(6, jumlah_piutang);
            stmt.executeUpdate();
            System.out.println("Data berhasil disimpan");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            con.connect().close();
        }
    }

    public void updatePiutang(String id_piutang, String id_tpegawai, String nominal_sebelum, String tanggal, String nominal_sesudah, String jumlah_piutang) throws SQLException {
        PreparedStatement stmt = null;
        String query = "UPDATE piutang SET id_tpegawai=?,nominal_sebelum=?,tanggal=?, nominal_sesudah=?, jumlah_piutang=? WHERE id_piutang=?";
        //String query = "UPDATE gaji set id_tpegawai=?,gaji_pokok=?,t_struktural=?,t_fungsional=?,uang_makan=?,sewa_motor=? where id_tgaji=?";
        try {
            stmt = con.connect().prepareStatement(query);
            stmt.setString(1, id_piutang);
            stmt.setString(2, id_tpegawai);
            stmt.setString(3, nominal_sebelum);
            stmt.setString(4, tanggal);
            stmt.setString(5, nominal_sesudah);
            stmt.setString(6, jumlah_piutang);
            stmt.executeUpdate();
            System.out.println("Data Berhasil Diupdate");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            con.connect().close();
        }
    }

    public void hapusPiutang(String id_piutang) throws SQLException {
        PreparedStatement stmt = null;
        String query = "delete from piutang where id_piutang=?";

        try {
            stmt = con.connect().prepareStatement(query);
            stmt.setString(1, id_piutang);
            stmt.executeUpdate();

            System.out.println("Data Berhasil Dihapus");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            con.connect().close();
        }

    }

    public String idotomatis() throws SQLException {

        int max_id = 1;
        String new_id = "";

        Statement stmt = null;
        ResultSet rs = null;

        String query = "select max(substring_index(id_piutang,'P',-1)) as id_max from piutang";

        try {
            stmt = con.connect().prepareStatement(query);
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                max_id = rs.getInt("id_max") + 1;
            }
            new_id = "P" + max_id;

        } catch (SQLException ex) {
            System.err.println("error " + ex.getMessage());
            new_id = "P" + max_id;
        } finally {
            con.connect().close();
        }
        System.err.println("-- > " + new_id);
        return new_id;
    }

    public DefaultTableModel tampilPiutang() {
        DefaultTableModel piutangtable = new DefaultTableModel();
        piutangtable.addColumn("ID PIUTANG");
        piutangtable.addColumn("ID PEGAWAI");
        piutangtable.addColumn("NAMA");
        piutangtable.addColumn("NOMOR KTP");
        piutangtable.addColumn("NOMINAL SEBELUM");
        piutangtable.addColumn("TANGGAL");
        piutangtable.addColumn("NOMINAL SESUDAH");
        piutangtable.addColumn("JUMLAH PIUTANG");
        piutangtable.addColumn("GAJI POKOK");
        piutangtable.addColumn("NIP");

        try {
            String sql = " SELECT p.id_piutang, peg.id_tpegawai, peg.nama, peg.no_ktp, p.nominal_sebelum, p.tanggal,  p.nominal_sesudah, p.jumlah_piutang, g.gaji_pokok, peg.nip \n"
                    + "FROM piutang p, pegawai peg, gaji g \n"
                    + "WHERE peg.id_tpegawai = p.id_tpegawai and peg.id_tpegawai=g.id_tpegawai and p.jumlah_piutang > 0";

            Statement stmt = con.connect().prepareStatement(sql);
            ResultSet res = stmt.executeQuery(sql);
            //mengisi pegawai tabel dengan perulangan hasil query
            while (res.next()) {
                piutangtable.addRow(new Object[]{
                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getString(5),
                    res.getString(6),
                    res.getString(7),
                    res.getString(8),
                    res.getString(9),
                    res.getString(10)

                }
                );
            }
        } catch (Exception e) {
        }
        return piutangtable;
    }

}
