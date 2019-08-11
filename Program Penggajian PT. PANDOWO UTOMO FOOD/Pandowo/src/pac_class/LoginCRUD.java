/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pac_class;

import java.sql.PreparedStatement;
import config.Koneksi;
import pac_form.Login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



/**
 *
 * @author rifqi
 */
public class LoginCRUD {
    
static Koneksi con = new Koneksi();
static Login f_login = new Login();

public String getStatus(){
    return "BEBAS";
    }

    public Boolean loginCheck(String user,String pass) throws SQLException {//String user, String pass

        Statement stmt = null;
        ResultSet rs = null;
        
        String query = "select * from petugas where username='"+user+"' and password='"+pass+"'";
        System.out.println("-----------"+query);
        Boolean status = false;
        
        
        try {
            stmt = con.connect().prepareStatement(query);
            
            rs = stmt.executeQuery(query);
            
            while (rs.next()) {
            status=true;
            
                
            }
        } catch (SQLException ex) {
            System.err.println("error "+ex.getMessage());
        } finally {
            con.connect().close();
        }        
        return status;
    }    
}
