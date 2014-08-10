/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import beans.*;
import java.util.ArrayList;

/**
 *
 * @author pacheikh
 */
public interface DataService {
    
    public void ajouterUtilisateur();
    public void ajouterOperation();
    public void ajouterCompte();
    public void ajouterAgence();
    
    public ArrayList<Customer> getAllClient();
    public ArrayList<Agence> getAllAgence();
    public ArrayList<Compte> getAllCompte();
    
    public ArrayList<Customer> getClientByAgence( int agence );
    public Customer getClientByName( String nomcli );
    public Compte getCompteByNum(String numCmpte );
    public ArrayList<Compte> getCompteByClient( int client );
    
    public void updateCompte( int numCompte, Compte compte );
    
    public String getNom();
    
}
