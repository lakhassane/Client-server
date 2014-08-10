/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import beans.Customer;
import dao.ClientDAO;
import java.util.ArrayList;

/**
 *
 * @author pacheikh
 */
public class ClientServiceImpl implements IClientService {
    
    ClientDAO clientDAO;

    @Override
    public void ajouterUtilisateur(Customer customer) {
        System.out.println("here");
        clientDAO = new ClientDAO();
        clientDAO.connect();
        clientDAO.ajouter(customer);
    }

    @Override
    public ArrayList<Customer> getAllClient() {
        clientDAO = new ClientDAO();
        clientDAO.connect();
        return clientDAO.getAllCustomer();
    }

    @Override
    public ArrayList<Customer> getClientByAgence(int agence) {
        clientDAO = new ClientDAO();
        clientDAO.connect();
        return clientDAO.getClientByAgence(agence);
    }

    @Override
    public Customer getClientByName(String nomcli) {
        clientDAO = new ClientDAO();
        clientDAO.connect();
        return clientDAO.getClientByName(nomcli);
    }

    @Override
    public String getNom() {
        return "clientService";
    }
    
}
