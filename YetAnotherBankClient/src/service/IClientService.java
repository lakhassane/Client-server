/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import beans.Customer;
import java.util.ArrayList;

/**
 *
 * @author pacheikh
 */
public interface IClientService {
    
    public void ajouterUtilisateur( Customer customer );
    public ArrayList<Customer> getAllClient();
    public ArrayList<Customer> getClientByAgence( int agence );
    public Customer getClientByName( String nomcli );
    
    public String getNom();
    
}
