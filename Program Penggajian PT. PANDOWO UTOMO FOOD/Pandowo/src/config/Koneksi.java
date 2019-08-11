/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.sql.*;

public class Koneksi {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/pandawa";
    static final String USER = "root";
    static final String PASS = "";

    public static Object getKoneksi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Connection connect() {
        Connection dbCon = null;
        try {
            //getting database connection to MySQL server
            dbCon = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);

        } catch (SQLException ex) {
            System.err.println("Error Connection with " + ex);
        }
        return dbCon;
    }

}
