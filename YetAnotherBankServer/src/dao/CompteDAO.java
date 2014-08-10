/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Agence;
import beans.Compte;
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
public class CompteDAO {
    
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
     
    public void ajouter( Compte cpt ) {
        try {
            st = conn.prepareStatement( "insert into compte (numcpt, libellecpt, soldecpt, senscpt, numcli) values(?,?,?,?,?)" );
            st.setInt(1, cpt.getNumcpt());
            st.setString(2, cpt.getLibellecpt());
            st.setFloat(3, cpt.getSoldecpt());
            st.setString(4, cpt.getSenscpt());
            st.setInt(5, cpt.getNumcli());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AgenceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Compte> getAllCompte() {
        ArrayList<Compte> listeCompte = new ArrayList<>();
        try {
            st = conn.prepareStatement( "Select * from compte" );
            rs = st.executeQuery();
            while ( rs.next() ) {
                Compte compte = new Compte();
                compte.setNumcpt(rs.getInt("numcpt"));
                compte.setLibellecpt(rs.getString("libellecpt"));
                compte.setSenscpt(rs.getString("senscpt"));
                compte.setSoldecpt(rs.getFloat("soldecpt"));
                compte.setNumcli(rs.getInt("numcli"));
            
                listeCompte.add(compte);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AgenceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeCompte;
    }
    
    public Compte getCompteByNum(String numCmpte ) {
        try {
            Compte compte = new Compte();
            st = conn.prepareStatement( "Select * from compte where numcpt = ?" );
            st.setString(1, numCmpte);
            rs = st.executeQuery();
            while ( rs.next() ) {
                compte.setNumcli(rs.getInt("numcli"));
                compte.setNumcpt(rs.getInt("numcpt"));
                compte.setLibellecpt(rs.getString("libellecpt"));
                compte.setSoldecpt(rs.getFloat("soldecpt"));
                compte.setSenscpt(rs.getString("senscpt"));
            }
            
            return compte;
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public ArrayList<Compte> getCompteByClientDB ( int client ) {
        try {
            ArrayList<Compte> liste = new ArrayList<Compte>();
            st = conn.prepareStatement( "Select * from compte where numcli = "+client );
            rs = st.executeQuery();
            while ( rs.next() ) {
                Compte compte = new Compte();
                compte.setNumcli(rs.getInt("numcli"));
                compte.setNumcpt(rs.getInt("numcpt"));
                compte.setLibellecpt(rs.getString("libellecpt"));
                compte.setSoldecpt(rs.getFloat("soldecpt"));
                compte.setSenscpt(rs.getString("senscpt"));

                liste.add(compte);
            }
            
            return liste;
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;        
    }
    
    public void updateCompte( int numCompte, Compte compte ) {
        try {
            st = conn.prepareStatement( "Update compte set libellecpt=?, soldecpt=?, senscpt=? where numcpt = "+numCompte );
            st.setString(1, compte.getLibellecpt());
            st.setFloat(2, compte.getSoldecpt());
            st.setString(3, compte.getSenscpt());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
