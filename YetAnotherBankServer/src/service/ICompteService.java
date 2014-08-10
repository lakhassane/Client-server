/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import beans.Compte;
import java.util.ArrayList;

/**
 *
 * @author pacheikh
 */
public interface ICompteService {
    
    public void ajouterCompte( Compte compte );
    
    public ArrayList<Compte> getAllCompte();
    public Compte getCompteByNum(String numCmpte );
    public ArrayList<Compte> getCompteByClient( int client );
    
    public void updateCompte( int numCompte, Compte compte );
    
    public String getNom();
}
