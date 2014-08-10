/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import service.ClientServiceImpl;
import beans.Customer;
import beans.Operation;
import beans.Agence;
import beans.Compte;
import dao.AgenceDAO;
import dao.ClientDAO;
import dao.CompteDAO;
import dao.OperationDAO;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.AgenceServiceImpl;
import service.CompteServiceImpl;
import service.OperationServiceImpl;

/**
 *
 * @author Lakhassane
 */
public class Service extends Thread {
    
    Connection conn = null;
    PreparedStatement st = null;
    ResultSet rs = null;
    Socket socket;
    // DAO
    ClientDAO clientDAO;
    AgenceDAO agenceDAO;
    OperationDAO operationDAO;
    CompteDAO compteDAO;
    // Service
    DataService dataService;
    ArrayList<Object> listeAgence;
    ArrayList<Object> listeCustomer;
    ArrayList<Object> listeCompte;
    
    public Service(Socket socket) {
        this.socket = socket;
        clientDAO = new ClientDAO();
        agenceDAO = new AgenceDAO();
        compteDAO = new CompteDAO();
        operationDAO = new OperationDAO();

//        try {
//            Class.forName( "com.mysql.jdbc.Driver" );
//            conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/banque", "root", "" );
//        } catch (SQLException | ClassNotFoundException ex) {
//            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
//        } 
        agenceDAO.connect();
        clientDAO.connect();
        compteDAO.connect();
        operationDAO.connect();
    }

    /**
     * This method write in the database.
     *
     * @param obj the javabean we want to write in the database
     */
//    public void writeDB( Object obj ) {
//        try {
//            /* We test the nature of the object */
//            if ( obj instanceof Agence ){
//                Agence ag = (Agence) obj;
//                st = conn.prepareStatement( "insert into agence (nomag,adresseag) values(?,?)" );
//                st.setString(1, ag.getNomag());
//                st.setString(2, ag.getAdresseag());
//                st.executeUpdate();
//            }
//            else if ( obj instanceof Customer ) {
//                Customer customer = (Customer) obj;
//                st = conn.prepareStatement( "insert into client (nomcli, prenomcli, numag) values(?, ?, ?)" );
//                st.setString(1, customer.getNomCli());
//                st.setString(2, customer.getPrenomCli());
//                st.setInt(3, customer.getNumag());
//                st.executeUpdate();
//            }
//            else if ( obj instanceof Compte ) {
//                Compte compte = (Compte) obj;
//                st = conn.prepareStatement( "insert into compte values (?, ?, ?, ?, ?)");
//                st.setInt(1, compte.getNumcpt());
//                st.setString(2, compte.getLibellecpt());
//                st.setFloat(3, compte.getSoldecpt());
//                st.setString(4, compte.getSenscpt());
//                st.setInt(5, compte.getNumcli());
//                st.executeUpdate();
//            }
//            else if ( obj instanceof Operation ) {
//                Operation operation = (Operation) obj;
//                st = conn.prepareStatement( "insert into operation (libelleop, sensop, dateop, numcpt) values (?, ?, now(), ?)");
//                st.setString(1, operation.getLibelleop());
//                st.setString(2, operation.getSensop());
////                st.setDate(3, operation.getDateop());
//                st.setInt(3, operation.getNumcpt());
//                st.executeUpdate();
//            }
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    public ArrayList<Object> getAllInfoDB ( String obj ) {
//        try {
//            if ( obj.equals("agence") ) {
//                listeAgence = new ArrayList<>();
//                st = conn.prepareStatement( "Select * from agence" );
//                rs = st.executeQuery();
//                while ( rs.next() ) {
//                    Agence agence = new Agence();
//                    agence.setNumag(rs.getInt("numag"));
//                    agence.setNomag(rs.getString("nomag"));
//                    agence.setAdresseag(rs.getString("adresseag"));
//                    listeAgence.add(agence);
//                }
//                return listeAgence;
//            }
//            else if ( obj.equals("customer") ) {
//                listeCustomer = new ArrayList<>();
//                st = conn.prepareStatement( "Select * from client" );
//                rs = st.executeQuery();
//                while ( rs.next() ) {
//                    Customer customer = new Customer();
//                    customer.setNumcli(rs.getInt("numcli"));
//                    customer.setNomCli(rs.getString("nomcli"));
//                    customer.setPrenomCli(rs.getString("prenomcli"));
//                    customer.setNumag(rs.getInt("numag"));
//                    
//                    listeCustomer.add(customer);
//                }
//                return listeCustomer;
//            }
//            else if ( obj.equals("compte") ) {
//                listeCompte = new ArrayList<>();
//                st = conn.prepareStatement( "Select * from compte" );
//                rs = st.executeQuery();
//                while ( rs.next() ) {
//                    Compte compte = new Compte();
//                    compte.setNumcli(rs.getInt("numcli"));
//                    compte.setLibellecpt(rs.getString("libellecpt"));
//                    compte.setSoldecpt(rs.getFloat("soldecpt"));
//                    compte.setSenscpt(rs.getString("senscpt"));
//                    
//                    listeCompte.add(compte);
//                }
//                return listeCompte;
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//    public ArrayList<Customer> getClientByAgenceDB ( int agence ) {
//        try {
//            ArrayList<Customer> liste = new ArrayList<Customer>();
//            st = conn.prepareStatement( "Select * from client where numag = "+agence );
//            rs = st.executeQuery();
//            while ( rs.next() ) {
//                Customer customer = new Customer();
//                customer.setNumcli(rs.getInt("numcli"));
//                customer.setNomCli(rs.getString("nomcli"));
//                customer.setPrenomCli(rs.getString("prenomcli"));
//                customer.setNumag(rs.getInt("numag"));
//
//                liste.add(customer);
//            }
//            
//            return liste;
//        } catch (SQLException ex) {
//            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        return null;
//    }
//    
//    public Customer getClientByNameDB ( String nom ) {
//        try {
//            Customer customer = new Customer();
//            st = conn.prepareStatement( "Select * from client where nomcli = ? ");
//            st.setString(1, nom);
//            rs = st.executeQuery();
//            while ( rs.next() ) {
//                customer = new Customer();
//                customer.setNumcli(rs.getInt("numcli"));
//                customer.setNomCli(rs.getString("nomcli"));
//                customer.setPrenomCli(rs.getString("prenomcli"));
//                customer.setNumag(rs.getInt("numag"));
//
//            }
//            
//            return customer;
//        } catch (SQLException ex) {
//            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        return null;
//    }
//            
//    public ArrayList<Compte> getCompteByClientDB ( int client ) {
//        try {
//            ArrayList<Compte> liste = new ArrayList<Compte>();
//            st = conn.prepareStatement( "Select * from compte where numcli = "+client );
//            rs = st.executeQuery();
//            while ( rs.next() ) {
//                Compte compte = new Compte();
//                compte.setNumcli(rs.getInt("numcli"));
//                compte.setNumcpt(rs.getInt("numcpt"));
//                compte.setLibellecpt(rs.getString("libellecpt"));
//                compte.setSoldecpt(rs.getFloat("soldecpt"));
//                compte.setSenscpt(rs.getString("senscpt"));
//
//                liste.add(compte);
//            }
//            
//            return liste;
//        } catch (SQLException ex) {
//            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        return null;
//        
//    }
//    
//    public Compte getCompteByNumDB ( String numCmpte) {
//        try {
//            Compte compte = new Compte();
//            st = conn.prepareStatement( "Select * from compte where numcpt = ?" );
//            st.setString(1, numCmpte);
//            rs = st.executeQuery();
//            while ( rs.next() ) {
//                compte.setNumcli(rs.getInt("numcli"));
//                compte.setNumcpt(rs.getInt("numcpt"));
//                compte.setLibellecpt(rs.getString("libellecpt"));
//                compte.setSoldecpt(rs.getFloat("soldecpt"));
//                compte.setSenscpt(rs.getString("senscpt"));
//            }
//            
//            return compte;
//        } catch (SQLException ex) {
//            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        return null;
//        
//    }
//    
//    public void updateCompte( int numCompte, Compte compte ) {
//        try {
//            st = conn.prepareStatement( "Update compte set libellecpt=?, soldecpt=?, senscpt=? where numcpt = "+numCompte );
//            st.setString(1, compte.getLibellecpt());
//            st.setFloat(2, compte.getSoldecpt());
//            st.setString(3, compte.getSenscpt());
//            st.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    @Override
    public void run() {
        try {
            OutputStream os = socket.getOutputStream();
            InputStream is = socket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            
            String mode;
            do {
                ClientServiceImpl CSI = new ClientServiceImpl();
                AgenceServiceImpl ASI = new AgenceServiceImpl();
                CompteServiceImpl COSI = new CompteServiceImpl();
                OperationServiceImpl OSI = new OperationServiceImpl();
                
                
                mode = (String) ois.readObject();
                System.out.println("mode: " + mode);
                switch (mode) {
                    case "ajoutService":
                        Object object = ois.readObject();
                        if (object instanceof Customer) {
                            Customer customer = (Customer) object;
                            CSI.ajouterUtilisateur(customer);
                        } else if (object instanceof Agence) {
                            Agence agence = (Agence) object;
                            ASI.ajouterAgence(agence);
                        } else if (object instanceof Compte) {
                            Compte compte = (Compte) object;
                            COSI.ajouterCompte(compte);
                            OSI.ajouterOperation((Operation) ois.readObject());
                            
                        }
                        break;
//                    case "ajoutAgence":
//                        Agence agence = (Agence) ois.readObject();
////                        writeDB(agence);
//                        agenceDAO.ajouter(agence);
//                        break;
//                    case "ajoutClient":
//                        Customer customer = (Customer) ois.readObject();
////                        writeDB(customer);
//                        clientDAO.ajouter(customer);
//                        break;
                    case "ajoutCompte":
                        Compte compte = (Compte) ois.readObject();
                        Operation operation = (Operation) ois.readObject();
//                        writeDB(compte);
//                        writeDB(operation);
                        compteDAO.ajouter(compte);
                        operationDAO.ajouter(operation);
                        break;
                    case "agenceService":
//                        ArrayList<Object> liste = getAllInfoDB("agence");
//                        ArrayList<Agence> liste = agenceDAO.getAllAgence();
                        ArrayList<Agence> liste = ASI.getAllAgence();
                        oos.writeObject(liste);
                        oos.flush();
                        break;
                    case "updateCompte":
                        System.out.println("update en cours");
                        Compte compteUpdate = (Compte) ois.readObject();
                        Operation operationUpdate = (Operation) ois.readObject();
//                        updateCompte(compteUpdate.getNumcpt(), compteUpdate);
//                        writeDB(operationUpdate);
                        compteDAO.updateCompte(compteUpdate.getNumcpt(), compteUpdate);
                        operationDAO.ajouter(operationUpdate);
                        break;
                    case "clientService":
                        int numAgence = (int) ois.readObject();
                        String nomClient = (String) ois.readObject();
                        if (numAgence >= 0) {
                            ArrayList<Customer> liste2 = CSI.getClientByAgence(numAgence);
                            oos.writeObject(liste2);
                            oos.flush();
                        } else {
                            if (!"".equals(nomClient)) {
                                Customer customer2 = CSI.getClientByName(nomClient);
                                oos.writeObject(customer2);
                                oos.flush();
                            } else {                                
                                ArrayList<Customer> liste2 = CSI.getAllClient();
                                oos.writeObject(liste2);
                                oos.flush();
                            }
                        }
                        break;
                    case "compteService":
                        int numClient = (int) ois.readObject();
                        String numcompte = (String) ois.readObject();
                        
                        if (numClient >= 0) {
                            if (!"".equals(numcompte)) {
//                                Compte compte2 = getCompteByNumDB(numcompte);
//                                Compte compte2 = compteDAO.getCompteByNum(numcompte);
                                Compte compte2 = COSI.getCompteByNum(numcompte);
                                oos.writeObject(compte2);
                                oos.flush();
                            } else {
//                                ArrayList<Compte> liste2 = getCompteByClientDB(numClient);
//                                ArrayList<Compte> liste2 = compteDAO.getCompteByClientDB(numClient);
                                ArrayList<Compte> liste2 = COSI.getCompteByClient(numClient);
                                oos.writeObject(liste2);
                                oos.flush();
                            }
                        } else {
//                            ArrayList<Object> liste2 = getAllInfoDB("compte");
//                            ArrayList<Compte> liste2 = compteDAO.getAllCompte();
                            ArrayList<Compte> liste2 = COSI.getAllCompte();
                            oos.writeObject(liste2);
                            oos.flush();
                        }
                        break;
                }
            } while (true);
            
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
}
