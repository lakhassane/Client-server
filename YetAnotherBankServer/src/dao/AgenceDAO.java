/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Agence;
import beans.Customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import test.Service;

/**
 *
 * @author pacheikh
 */
public class AgenceDAO {
    
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
    
    public void ajouter( Agence ag ) {
        try {
            st = conn.prepareStatement( "insert into agence (nomag,adresseag) values(?,?)" );
            st.setString(1, ag.getNomag());
            st.setString(2, ag.getAdresseag());
            st.executeUpdate();
            System.out.println("nom agence : " + ag.getNomag());
        } catch (SQLException ex) {
            Logger.getLogger(AgenceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Agence> getAllAgence() {
        ArrayList<Agence> listeAgence = new ArrayList<>();
        try {
            st = conn.prepareStatement( "Select * from agence" );
            rs = st.executeQuery();
            while ( rs.next() ) {
                Agence agence = new Agence();
                agence.setNumag(rs.getInt("numag"));
                agence.setNomag(rs.getString("nomag"));
                agence.setAdresseag(rs.getString("adresseag"));
            
                listeAgence.add(agence);
            }
        } catch (SQLException ex) {
            System.out.println("here");
            Logger.getLogger(AgenceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listeAgence;
    }
    
}
