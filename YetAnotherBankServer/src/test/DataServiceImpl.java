/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import beans.Agence;
import beans.Compte;
import beans.Customer;
import beans.Operation;
import dao.AgenceDAO;
import dao.ClientDAO;
import dao.CompteDAO;
import dao.OperationDAO;
import java.util.ArrayList;

/**
 *
 * @author pacheikh
 */
public class DataServiceImpl implements DataService {

    ClientDAO clientDAO;
    OperationDAO operationDAO;
    CompteDAO compteDAO;
    AgenceDAO agenceDAO;
       
    @Override
    public void ajouterUtilisateur( Customer customer ) {
        clientDAO = new ClientDAO();
        clientDAO.ajouter(customer);
    }

    @Override
    public void ajouterOperation( Operation operation ) {
        operationDAO = new OperationDAO();
        operationDAO.ajouter(operation);
    }

    @Override
    public void ajouterCompte( Compte compte) {
        compteDAO = new CompteDAO();
        compteDAO.ajouter(compte);
    }

    @Override
    public void ajouterAgence( Agence agence ) {
        agenceDAO = new AgenceDAO();
        agenceDAO.ajouter(agence);
    }

    @Override
    public ArrayList<Customer> getAllClient() {
        clientDAO = new ClientDAO();
        clientDAO.connect();
        return clientDAO.getAllCustomer();
    }

    @Override
    public ArrayList<Agence> getAllAgence() {
        agenceDAO = new AgenceDAO();
        return agenceDAO.getAllAgence();
    }

    @Override
    public ArrayList<Compte> getAllCompte() {
        compteDAO = new CompteDAO();
        return compteDAO.getAllCompte();
    }

    @Override
    public ArrayList<Customer> getClientByAgence(int agence) {
        System.out.println("impl : " + agence);
        clientDAO = new ClientDAO();
        return clientDAO.getClientByAgence(agence);
    }

    @Override
    public Customer getClientByName(String nomcli) {
        clientDAO = new ClientDAO();
        return clientDAO.getClientByName(nomcli);
    }

    @Override
    public Compte getCompteByNum(String numCmpte) {
        compteDAO = new CompteDAO();
        return compteDAO.getCompteByNum(numCmpte);
    }

    @Override
    public ArrayList<Compte> getCompteByClient(int client) {
        compteDAO = new CompteDAO();
        return compteDAO.getCompteByClientDB(client);
    }

    @Override
    public void updateCompte(int numCompte, Compte compte) {
        compteDAO = new CompteDAO();
        compteDAO.updateCompte(numCompte, compte);
    }

    @Override
    public String getNom() {
        return "dataService";
    }
    
}
