/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pac_class;

import java.sql.PreparedStatement;
import config.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import jdk.nashorn.internal.ir.TryNode;

public class GajiCRUD {
    
 Koneksi con = new Koneksi();
    public void insergaji(String id_tgaji, String id_tpegawai, 
            String gaji_pokok, String t_struktural, 
            String t_fungsional, String uang_makan, 
            String sewa_motor) throws Exception {
        PreparedStatement stmt = null;
        String query = "INSERT INTO gaji(id_tgaji,id_tpegawai,gaji_pokok,t_struktural,t_fungsional,uang_makan,sewa_motor)VALUE(?,?,?,?,?,?,?)";
        try {
            stmt =  con.connect().prepareStatement(query);
            stmt.setString(1, id_tgaji);
            stmt.setString(2, id_tpegawai);
            stmt.setString(3, gaji_pokok);
            stmt.setString(4, t_struktural);
            stmt.setString(5, t_fungsional);
            stmt.setString(6, uang_makan);
            stmt.setString(7, sewa_motor);
            stmt.executeUpdate();
            
            System.out.println("Data berhasil disimpan");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            con.connect().close();
        }
    }
    
      //ini buat rubah
    //static Koneksi con = new Koneksi();
    public void UpdateGaji(String id_tgaji, String id_tpegawai, 
            String gaji_pokok, String t_struktural, 
            String t_fungsional, String uang_makan, 
            String sewa_motor) throws SQLException {
    PreparedStatement stmt = null;
    String query = "UPDATE gaji set id_tpegawai=?,gaji_pokok=?,t_struktural=?,t_fungsional=?,uang_makan=?,sewa_motor=? where id_tgaji=?";
     
        try {
            stmt = con.connect().prepareStatement(query);
            stmt.setString(1, id_tgaji);
            stmt.setString(2, id_tpegawai);
            stmt.setString(3, gaji_pokok);
            stmt.setString(4, t_struktural);
            stmt.setString(5, t_fungsional);
            stmt.setString(6, uang_makan);
            stmt.setString(7, sewa_motor);
            
            stmt.executeUpdate();
        
        System.out.println("Data Berhasil Diupdate");  
            } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            con.connect().close();
        }
    }
    
     public void hapusGaji(String id_tgaji)throws SQLException{
     PreparedStatement stmt = null;
     String query = "delete from gaji where id_tgaji=?";
     
        try {
        stmt = con.connect().prepareStatement(query);
        stmt.setString(1, id_tgaji);
        stmt.executeUpdate();
         
          System.out.println("Data Berhasil Dihapus");  
            } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            con.connect().close();
     }  
      
}

    public String getIdFromIdGaji(String idGaji) throws SQLException {
	
	String id_pegawai = "";

        Statement stmt = null;
        ResultSet rs = null;
        
        String query = "SELECT gaji.id_tpegawai FROM gaji WHERE gaji.id_tgaji="+"'"+idGaji+"'";
                
        try {
            stmt = con.connect().prepareStatement(query);
            
            rs = stmt.executeQuery(query);            
            while (rs.next()) {
            id_pegawai = rs.getString("id_tpegawai");
            }
	                
        } catch (SQLException ex) {
            System.err.println("error "+ex.getMessage());
	     	
        } finally {
            con.connect().close();
        }
            System.err.println("-- > "+id_pegawai);
        return id_pegawai;
    }
    
    public String idotomatis() throws SQLException {
	
	int max_id = 1;
	String new_id = "";

        Statement stmt = null;
        ResultSet rs = null;
        
        String query = "select max(substring_index(id_tgaji,'G',-1)) as id_max from gaji";
                
        try {
            stmt = con.connect().prepareStatement(query);
            rs = stmt.executeQuery(query);
            
            while (rs.next()) {
            max_id = rs.getInt("id_max")+1;
            }
	    new_id = "G"+max_id; 
            
        } catch (SQLException ex) {
            System.err.println("error "+ex.getMessage());
	    new_id = "G"+max_id; 	
        } finally {
            con.connect().close();
        }
            System.err.println("-- > "+new_id);
        return new_id;
    }
    
    
    public DefaultTableModel tampilgaji(){
    DefaultTableModel gajitable = new DefaultTableModel();
    gajitable.addColumn("ID");
    gajitable.addColumn("NAMA");
    gajitable.addColumn("NIP");
    gajitable.addColumn("GAJI POKOK");
    gajitable.addColumn("TUNJANGAN STRUKTURAL");
    gajitable.addColumn("TUNJANGAN FUNGSIONAL");
    gajitable.addColumn("UANG MAKAN");
    gajitable.addColumn("SEWA MOTOR");
    
    try {
        //String sql = "select * from bpjs_kesehatan";
        String sql = "SELECT gaji.id_tgaji, pegawai.nama, pegawai.nip, gaji.gaji_pokok,\n" +
"gaji.t_struktural, gaji.t_fungsional, gaji.uang_makan, gaji.sewa_motor\n" +
"FROM gaji LEFT JOIN pegawai\n" +
"ON gaji.id_tpegawai=pegawai.id_tpegawai\n" +
" WHERE gaji.gaji_pokok > 0";
        Statement stmt = con.connect().prepareStatement(sql);
        ResultSet res = stmt.executeQuery(sql);
        //mengisi pegawai tabel dengan perulangan hasil query
        while (res.next()) {
        gajitable.addRow(new Object[]{
            res.getString(1),
            res.getString(2),
            res.getString(3),
            res.getString(4),
            res.getString(5),
            res.getString(6),
            res.getString(7),
            res.getString(8),      
                }
        );
        }
    } catch (Exception e) {
    }
    return gajitable;
    }
    
    
    
    
}
    
    

    
    
   

