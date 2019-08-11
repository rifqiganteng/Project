package pac_class;

import com.oracle.jrockit.jfr.DataType;
import java.sql.PreparedStatement;
import config.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import jdk.nashorn.internal.ir.TryNode;

public class BpjsCRUD {

    Koneksi con = new Koneksi();

    public String idotomatisBPJS_Kesehatan() throws SQLException {

        int max_id = 1;
        String new_id = "";

        Statement stmt = null;
        ResultSet rs = null;

        String query = "select max(substring_index(id_tbpjs_kesehatan,'BPKS',-1)) as id_max from bpjs_kesehatan ";

        try {
            stmt = con.connect().prepareStatement(query);

            rs = stmt.executeQuery(query);

            while (rs.next()) {
                max_id = rs.getInt("id_max") + 1;
            }
            new_id = "BPKS" + max_id;

        } catch (SQLException ex) {
            System.err.println("error " + ex.getMessage());
            new_id = "BPKS" + max_id;
        } finally {
            con.connect().close();
        }
        System.err.println("-- > " + new_id);
        return new_id;
    }

    
    
    public String idotomatisBPJS_Ketenagakerjaan() throws SQLException {

        int max_id = 1;
        String new_id = "";

        Statement stmt = null;
        ResultSet rs = null;

        String query = "select max(substring_index(id_tbpjs_tenagakerja,'BPKT',-1)) as id_max from bpjs_ketenagakerjaan ";

        try {
            stmt = con.connect().prepareStatement(query);

            rs = stmt.executeQuery(query);

            while (rs.next()) {
                max_id = rs.getInt("id_max") + 1;
            }
            new_id = "BPKT" + max_id;

        } catch (SQLException ex) {
            System.err.println("error " + ex.getMessage());
            new_id = "BPKT" + max_id;
        } finally {
            con.connect().close();
        }
        System.err.println("-- > " + new_id);
        return new_id;
    }

    
    
    public DefaultTableModel tampilbpjs() {
        DefaultTableModel bpjstable = new DefaultTableModel();
        bpjstable.addColumn("NAMA");
        bpjstable.addColumn("NIP");
        bpjstable.addColumn("KTP");
        bpjstable.addColumn("ID BPJS KESEHATAN");
        bpjstable.addColumn("NO BPJS KESEHATAN");
        bpjstable.addColumn("FASKES BPJS KESEHATAN");
        bpjstable.addColumn("NOMINAL BPJS KESEHATAN");
        bpjstable.addColumn("ID BPJS KETENAGAKERJAAN");
        bpjstable.addColumn("NO BPJS KETENAGAKERJAAN");
        bpjstable.addColumn("NOMINAL");
        try {
        //String sql = "SELECT * FROM bpjs_kesehatan";
            String sql = "SELECT p.nama, p.nip, p.no_ktp, bs.id_tbpjs_kesehatan, bs.nomor_bpjs, bs.faskes, bs.nominal, bk.id_tbpjs_tenagakerja, bk.nomor_bpjs, bk.nominal \n"
                    + "FROM pegawai p \n"
                    + "JOIN bpjs_kesehatan bs ON bs.id_tpegawai = p.id_tpegawai \n"
                    + "JOIN bpjs_ketenagakerjaan bk ON bk.id_tpegawai = p.id_tpegawai \n"
                    + "WHERE bs.nominal > 0 OR bk.nominal > 0";
            Statement stmt = con.connect().prepareStatement(sql);
            ResultSet res = stmt.executeQuery(sql);
            //mengisi pegawai tabel dengan perulangan hasil query
            while (res.next()) {
                bpjstable.addRow(new Object[]{
                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getString(5),
                    res.getString(6),
                    res.getString(7),
                    res.getString(8),
                    res.getString(9),
                    res.getString(10),}
                );
            }
        } catch (Exception e) {
        }
        return bpjstable;
    }
    

    public void insertbpjskes(String id_tbpjs_kesehatan, String id_tpegawai,
            String nomor_bpjs, String faskes, String nominal) throws SQLException {
        PreparedStatement stmt = null;
        String query = "INSERT INTO bpjs_kesehatan(id_tbpjs_kesehatan,id_tpegawai,nomor_bpjs,faskes,nominal)VALUE(?,?,?,?,?)";
        try {
            stmt = con.connect().prepareStatement(query);
            stmt.setString(1, id_tbpjs_kesehatan);
            stmt.setString(2, id_tpegawai);
            stmt.setString(3, nomor_bpjs);
            stmt.setString(4, faskes);
            stmt.setString(5, nominal);
            stmt.executeUpdate();
            System.out.println("Data Berhasil Disimpan");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            con.connect().close();
        }
    }

    
    public void insertbpjsket(String id_tbpjs_tenagakerja, String id_tpegawai,
            String nominal, String nomor_bpjs) throws SQLException {
        PreparedStatement stmt = null;
        String query = " INSERT INTO bpjs_ketenagakerjaan(id_tbpjs_tenagakerja,id_tpegawai,nominal,nomor_bpjs)VALUE(?,?,?,?)";
        try {
            stmt = con.connect().prepareStatement(query);
            stmt.setString(1, id_tbpjs_tenagakerja);
            stmt.setString(2, id_tpegawai);
            stmt.setString(3, nominal);
            stmt.setString(4, nomor_bpjs);
            stmt.executeUpdate();
            System.out.println("data berhasil disimpan");

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            con.connect().close();
        }
    }

    
    public void updatebpjskesehatan(String id_tbpjs_kesehatan, String id_tpegawai,
            String nomor_bpjs, String faskes, String nominal) throws SQLException {
        PreparedStatement stmt = null;
        String query = "UPDATE bpjs_kesehatan set id_tpegawai=?,nomor_bpjs=?,faskes=?,nominal=? where id_tbpjs_kesehatan=?";
        try {
            stmt = con.connect().prepareStatement(query);
            stmt.setString(1, id_tbpjs_kesehatan);
            stmt.setString(2, id_tpegawai);
            stmt.setString(3, nomor_bpjs);
            stmt.setString(4, faskes);
            stmt.setString(5, nominal);

            stmt.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            con.connect().close();
        }
    }

    
    public void updatebpjsketenagakerjaan(String id_tbpjs_tenagakerja, String id_tpegawai, String nominal, String nomor_bpjs) 
            throws SQLException {
        PreparedStatement stmt = null;
        String query = "UPDATE bpjs_ketenagakerjaan set id_tpegawai=?,nominal=?,nomor_bpjs=? where id_tbpjs_tenagakerja=?";
        try {
            stmt = con.connect().prepareStatement(query);
            stmt.setString(1, id_tbpjs_tenagakerja);
            stmt.setString(2, id_tpegawai);
            stmt.setString(3, nominal);
            stmt.setString(4, nomor_bpjs);

            stmt.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            con.connect().close();
        }
    }

    
    public void deletekesehatan(String id_tbpjs_kesehatan) throws SQLException {
        PreparedStatement stmt = null;
        String query = "DELETE FROM bpjs_kesehtan where id_tbpjs_kesehatan=?";
        try {
            stmt = con.connect().prepareStatement(query);
            stmt.setString(1, id_tbpjs_kesehatan);
            stmt.executeUpdate();

            System.out.println("Data Berhasil Dihapus !");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            con.connect().close();
        }
    }

    
    public void deleteketenagakerjaan(String id_tbpjs_tenagakerja) throws SQLException {
        PreparedStatement stmt = null;
        String query = "DELETE FROM bpjs_ketenagakerjaan where id_tbpjs_tenagakerja=?";
        try {
            stmt = con.connect().prepareStatement(query);
            stmt.setString(1, id_tbpjs_tenagakerja);
            stmt.executeUpdate();

            System.out.println("Data Berhasil Dihapus !");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            con.connect().close();
        }
    }

    
    public String ambildatapegawai(String idpegawai) throws SQLException {

        Statement stmt = null;
        ResultSet rs = null;

        String id_peg_YANG_AKAN_DIRETURN = "";
        String query = "SELECT bpjs_ketenagakerjaan.id_tpegawai FROM bpjs_ketenagakerjaan WHERE bpjs_ketenagakerjaan.id_tbpjs_tenagakerja="+"'"+idpegawai+"'";
        try {
            stmt = con.connect().prepareStatement(query);

            rs = stmt.executeQuery(query);
            while (rs.next()) {
                id_peg_YANG_AKAN_DIRETURN= rs.getString("id_tpegawai");
              

            }
        } catch (SQLException ex) {
            System.err.println("error " + ex.getMessage());
            id_peg_YANG_AKAN_DIRETURN="not found";
        } finally {
            con.connect().close();
        }

        return id_peg_YANG_AKAN_DIRETURN;
    }

//    public String[] ambildatapegawai_coba(String idpegawai) throws SQLException {
//        String[] hasil = new String[5];
//        Statement stmt = null;
//        ResultSet rs = null;
//
//        String query = "SELECT bpjs_ketenagakerjaan.id_tpegawai,"
//                + " bpjs_kesehatan.id_tpegawai, pegawai.nama, pegawai.no_ktp \n"
//                + "FROM bpjs_kesehatan, bpjs_ketenagakerjaan, pegawai\n"
//                + "WHERE pegawai.id_tpegawai=bpjs_kesehatan.id_tpegawai\n"
//                + " AND pegawai.id_tpegawai=bpjs_ketenagakerjaan.id_tpegawai=" + "'" + idpegawai + "'";
//        try {
//            stmt = con.connect().prepareStatement(query);
//
//            rs = stmt.executeQuery(query);
//            while (rs.next()) {
//                hasil[0] = rs.getString("id_tpegawai");
//                hasil[1] = rs.getString("nama");
//                hasil[2] = rs.getString("no_ktp");
//                
//            }
//        } catch (SQLException ex) {
//            System.err.println("error " + ex.getMessage());
//        } finally {
//            con.connect().close();
//        }
//
//        return hasil;
//    }

}
