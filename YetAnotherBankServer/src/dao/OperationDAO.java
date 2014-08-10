/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Agence;
import beans.Operation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import test.Service;

/**
 *
 * @author pacheikh
 */
public class OperationDAO {
    
    Connection conn = null;
    PreparedStatement st = null;
    ResultSet rs = null;
    
     public void connect() {
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
            conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/banque", "root", "" );
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
     
    public void ajouter( Operation op ) {
        try {
            st = conn.prepareStatement( "insert into operation (libelleop,sensop,dateop,numcpt) values(?,?,?,?)" );
            st.setString(1, op.getLibelleop());
            st.setString(2, op.getSensop());
            st.setString(3, op.getDateop());
            st.setInt(4, op.getNumcpt());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AgenceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
