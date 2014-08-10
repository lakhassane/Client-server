/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import beans.Agence;
import java.util.ArrayList;

/**
 *
 * @author pacheikh
 */
public interface IAgenceService {

    public void ajouterAgence( Agence agence );
    
    public ArrayList<Agence> getAllAgence();
    
    public String getNom();
}

