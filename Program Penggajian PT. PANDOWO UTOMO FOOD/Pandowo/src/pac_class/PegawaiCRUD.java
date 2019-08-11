
package pac_class;

import java.sql.PreparedStatement;
import config.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;




/**
 *
 * @author amanullah
 */
public class PegawaiCRUD {

    
    Koneksi con = new Koneksi();
    public void insertpegawai(String id_tpegawai, String nama, String jenis_kelamin, String no_ktp,
            String tgl_lahir, String no_tlp, String agama, String pendidikan_terakhir,
            String status, String nip, String tgl_masuk, String bagian,
            String jabatan, String alamat, String image, String darah, String alamat_sementara) throws Exception {
        PreparedStatement stmt = null;
        String query = "INSERT INTO pegawai(id_tpegawai,nama,jenis_kelamin,no_ktp,tgl_lahir,no_tlp,agama,pendidikan_terakhir,status,nip,tgl_masuk,bagian,jabatan,alamat,image,darah,alamat_sementara)VALUE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            stmt =  con.connect().prepareStatement(query);
            stmt.setString(1, id_tpegawai);
            stmt.setString(2, nama);
            stmt.setString(3, jenis_kelamin);
            stmt.setString(4, no_ktp);
            stmt.setString(5, tgl_lahir);
            stmt.setString(6, no_tlp);
            stmt.setString(7, agama);
            stmt.setString(8, pendidikan_terakhir);
            stmt.setString(9, status);
            stmt.setString(10, nip);
            stmt.setString(11, tgl_masuk);
            stmt.setString(12, bagian);
            stmt.setString(13, jabatan);
            stmt.setString(14, alamat);
            stmt.setString(15, image);
            stmt.setString(16, darah);
            stmt.setString(17, alamat_sementara);
            stmt.executeUpdate();
            
            System.out.println("Data berhasil disimpan");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            con.connect().close();
        }
    }
    
    
    
    
    
    public void Updatepegawai(String id_tpegawai, String nama, String jenis_kelamin, String no_ktp,
            String tgl_lahir, String no_tlp, String agama, String pendidikan_terakhir,
            String status, String nip, String tgl_masuk, String bagian,
            String jabatan, String alamat, String image, String darah, String alamat_sementara) throws SQLException {
     PreparedStatement stmt = null;
     String query = "UPDATE pegawai set nama=?,jenis_kelamin=?,no_ktp=?,tgl_lahir=?,no_tlp=?,agama=?,pendidikan_terakhir=?,status=?,nip=?,tgl_masuk=?,bagian=?,jabatan=?,alamat=?,image=?,darah=?,alamat_sementara=? where id_tpegawai=?";
     
        try {
            stmt = con.connect().prepareStatement(query);
            //PreparedStatement stmt = con.connect().prepareStatement(query);
            stmt.setString(1, id_tpegawai);
            stmt.setString(2, nama);
            stmt.setString(3, jenis_kelamin);
            stmt.setString(4, no_ktp);
            stmt.setString(5, tgl_lahir);
            stmt.setString(6, no_tlp);
            stmt.setString(7, agama);
            stmt.setString(8, pendidikan_terakhir);
            stmt.setString(9, status);
            stmt.setString(10, nip);
            stmt.setString(11, tgl_masuk);
            stmt.setString(12, bagian);
            stmt.setString(13, jabatan);
            stmt.setString(14, alamat);
            stmt.setString(15, image);
            stmt.setString(16, darah);  
            stmt.setString(17, alamat_sementara);
            stmt.executeUpdate();
         System.out.println("Data Berhasil Diupdate");  
            } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            con.connect().close();
        }
    }
    
    
     public void hapus(String id_tpegawai)throws SQLException{
     PreparedStatement stmt = null;
     String query = "delete from pegawai where id_tpegawai=?";
     
        try {
        stmt = con.connect().prepareStatement(query);
        stmt.setString(1, id_tpegawai);
        stmt.executeUpdate();
         
          System.out.println("Data Berhasil Dihapus");  
            } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            con.connect().close();
     }   
     }
//untuk id otomatis
       public String idotomatis() throws SQLException {
	
	int max_id = 1;
	String new_id = "";

        Statement stmt = null;
        ResultSet rs = null;
        
        String query = "select max(substring_index(id_tpegawai,'PEG',-1)) as id_max from pegawai";
                
        try {
            stmt = con.connect().prepareStatement(query);
            
            rs = stmt.executeQuery(query);
            
            while (rs.next()) {
            max_id = rs.getInt("id_max")+1;
            }
	    new_id = "PEG"+max_id; 
            
        } catch (SQLException ex) {
            System.err.println("error "+ex.getMessage());
	    new_id = "PEG"+max_id; 	
        } finally {
            con.connect().close();
        }
            System.err.println("-- > "+new_id);
        return new_id;
    }
   
public DefaultTableModel tampil(){
    DefaultTableModel pegawaitable = new DefaultTableModel();
    pegawaitable.addColumn("ID");
    pegawaitable.addColumn("NAMA");
    pegawaitable.addColumn("JENIS KELAMIN");
    pegawaitable.addColumn("KTP");
    pegawaitable.addColumn("TANGGAL LAHIR");
    pegawaitable.addColumn("NO HP");
    pegawaitable.addColumn("AGAMA");
    pegawaitable.addColumn("PENDIDIKAN");
    pegawaitable.addColumn("STATUS");
    pegawaitable.addColumn("NIP");
    pegawaitable.addColumn("TANGGAL MASUK");
    pegawaitable.addColumn("BAGIAN");
    pegawaitable.addColumn("JABATAN");
    pegawaitable.addColumn("ALAMAT");
    pegawaitable.addColumn("IMAGE");
    pegawaitable.addColumn("GOLONGAN DARAH");
    pegawaitable.addColumn("ALAMAT SEMENTARA");
    pegawaitable.addColumn("ID GAJI");
    pegawaitable.addColumn("BPJS KES");
    pegawaitable.addColumn("BPJS KET");
    pegawaitable.addColumn("ID PIUTANG");
    
    try {
        String sql = " SELECT p.id_tpegawai, p.nama, p.jenis_kelamin, p.no_ktp, p.tgl_lahir, p.no_tlp, p.agama, p.pendidikan_terakhir, p.status, p.nip,\n" +
"p.tgl_masuk, p.bagian, p.jabatan, p.alamat, p.image, p.darah, p.alamat_sementara, g.id_tgaji, bks.id_tbpjs_kesehatan, bkt.id_tbpjs_tenagakerja, piu.id_piutang\n" +
"FROM pegawai p, gaji g, bpjs_kesehatan bks, bpjs_ketenagakerjaan bkt, piutang piu\n" +
"WHERE p.id_tpegawai=g.id_tpegawai AND p.id_tpegawai=bks.id_tpegawai AND p.id_tpegawai=bkt.id_tpegawai AND p.id_tpegawai=piu.id_tpegawai";
//        String sql = "select * from pegawai";
        Statement stmt = con.connect().prepareStatement(sql);
        ResultSet res = stmt.executeQuery(sql);
        //mengisi pegawai tabel dengan perulangan hasil query
        while (res.next()) {
        pegawaitable.addRow(new Object[]{
            res.getString(1),
            res.getString(2),
            res.getString(3),
            res.getString(4),
            res.getString(5),
            res.getString(6),
            res.getString(7),
            res.getString(8),
            res.getString(9),
            res.getString(10),
            res.getString(11),
            res.getString(12),
            res.getString(13),
            res.getString(14),
            res.getString(15),
            res.getString(16),
            res.getString(17),
            res.getString(18),
            res.getString(19),
            res.getString(20),
            res.getString(21),
            
                }
        );
        }
    } catch (Exception e) {
    }
    return pegawaitable;
    }

public DefaultTableModel cariByName(String keyword){
    DefaultTableModel pegawaitable = new DefaultTableModel();
    pegawaitable.addColumn("ID");
    pegawaitable.addColumn("NAMA");
    pegawaitable.addColumn("JENIS KELAMIN");
    pegawaitable.addColumn("KTP");
    pegawaitable.addColumn("TANGGAL LAHIR");
    pegawaitable.addColumn("NO HP");
    pegawaitable.addColumn("AGAMA");
    pegawaitable.addColumn("PENDIDIKAN");
    pegawaitable.addColumn("STATUS");
    pegawaitable.addColumn("NIP");
    pegawaitable.addColumn("TANGGAL MASUK");
    pegawaitable.addColumn("BAGIAN");
    pegawaitable.addColumn("JABATAN");
    pegawaitable.addColumn("ALAMAT");    
    pegawaitable.addColumn("IMAGE");
    pegawaitable.addColumn("GOLONGAN DARAH");
    pegawaitable.addColumn("ALAMAT SEMENTARA");
    pegawaitable.addColumn("ID GAJI");
    pegawaitable.addColumn("BPJS KES");
    pegawaitable.addColumn("BPJS KET");
    pegawaitable.addColumn("ID PIUTANG");
    
    try {
        String sql = "select * from pegawai where nama like '%"+keyword+"%'";
        Statement stmt = con.connect().prepareStatement(sql);
        ResultSet res = stmt.executeQuery(sql);
        //mengisi pegawai tabel dengan perulangan hasil query
        while (res.next()) {
        pegawaitable.addRow(new Object[]{
            res.getString(1),
            res.getString(2),
            res.getString(3),
            res.getString(4),
            res.getString(5),
            res.getString(6),
            res.getString(7),
            res.getString(8),
            res.getString(9),
            res.getString(10),
            res.getString(11),
            res.getString(12),
            res.getString(13),
            res.getString(14),
            res.getString(15),
            res.getString(16),
            res.getString(17),
            res.getString(18),
            res.getString(19),
            res.getString(20),
            res.getString(21),
                }
        );
        }
    } catch (Exception e) {
    }
    return pegawaitable;
    }

//  public String ambildatapegawai(String idgaji) throws SQLException {
//
//        Statement stmt = null;
//        ResultSet rs = null;
//
//        String id_peg_YANG_AKAN_DIRETURN = "";
//        String query = "SELECT bpjs_ketenagakerjaan.id_tpegawai FROM bpjs_ketenagakerjaan WHERE bpjs_ketenagakerjaan.id_tbpjs_tenagakerja="+"'"+idgaji+"'";
//        try {
//            stmt = con.connect().prepareStatement(query);
//
//            rs = stmt.executeQuery(query);
//            while (rs.next()) {
//                id_peg_YANG_AKAN_DIRETURN= rs.getString("id_tpegawai");
//              
//
//            }
//        } catch (SQLException ex) {
//            System.err.println("error " + ex.getMessage());
//            id_peg_YANG_AKAN_DIRETURN="not found";
//        } finally {
//            con.connect().close();
//        }
//
//        return id_peg_YANG_AKAN_DIRETURN;
//    }

}


    

