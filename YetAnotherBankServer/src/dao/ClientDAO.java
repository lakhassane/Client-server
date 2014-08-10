/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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

public class ClientDAO {
    
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
     
    public void ajouter( Customer customer ) {
        try {
            st = conn.prepareStatement( "insert into client (nomcli, prenomcli, numag) values(?, ?, ?)" );
            st.setString(1, customer.getNomCli());
            st.setString(2, customer.getPrenomCli());
            st.setInt(3, customer.getNumag());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public Customer getClientByName( String nomcli ) {
        Customer customer = new Customer();
        try {
            st = conn.prepareStatement( "Select * from client where nomcli = ?" );
            st.setString(1, nomcli);
            rs = st.executeQuery();
            while ( rs.next() ) {
                customer.setNumcli(rs.getInt("numcli"));
                customer.setNomCli(rs.getString("nomcli"));
                customer.setPrenomCli(rs.getString("prenomcli"));
                customer.setNumag(rs.getInt("numag"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customer;
    }
    
    public ArrayList<Customer> getAllCustomer(){
        ArrayList<Customer> listeCustomer = new ArrayList<>();
        try {
            st = conn.prepareStatement( "Select * from client" );
            rs = st.executeQuery();
            while ( rs.next() ) {
                Customer customer = new Customer();
                customer.setNumcli(rs.getInt("numcli"));
                customer.setNomCli(rs.getString("nomcli"));
                customer.setPrenomCli(rs.getString("prenomcli"));
                customer.setNumag(rs.getInt("numag"));
         
                listeCustomer.add(customer);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeCustomer;
    }
    
    public ArrayList<Customer> getClientByAgence( int agence ) {
        try {
            ArrayList<Customer> liste = new ArrayList<Customer>();
            System.out.println("agence : " + agence);
            st = conn.prepareStatement( "Select * from client where numag = "+agence );
            rs = st.executeQuery();
            while ( rs.next() ) {
                Customer customer = new Customer();
                customer.setNumcli(rs.getInt("numcli"));
                customer.setNomCli(rs.getString("nomcli"));
                customer.setPrenomCli(rs.getString("prenomcli"));
                customer.setNumag(rs.getInt("numag"));

                liste.add(customer);
            }
            return liste;
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
