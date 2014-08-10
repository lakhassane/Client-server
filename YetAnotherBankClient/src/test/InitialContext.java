/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import beans.Agence;
import beans.Compte;
import beans.Customer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pacheikh
 */
class InitialContext {

    public Object lookup(String nom, int numAgence, String nomClient) {
//        System.out.println("Searching for the object....");
        if ( nom.equalsIgnoreCase("clientService")){
            try {
                System.out.println(" nom : " + nom);
                System.out.println(" agence : " + numAgence);
                System.out.println(" client : " + nomClient);
                
                Client.oos.writeObject(nom);
                Client.oos.flush();
                
                Client.oos.writeObject(numAgence);
                Client.oos.flush();
                
                Client.oos.writeObject(nomClient);
                Client.oos.flush();
                
                if ( !"".equals(nomClient) ){
                    Customer client = (Customer) Client.ois.readObject();
                    return client;
                }
                else {
                    ArrayList<Customer> listeClient = (ArrayList<Customer>) Client.ois.readObject();
                    return listeClient;
                }
                    
            } catch (    IOException | ClassNotFoundException ex) {
                Logger.getLogger(InitialContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (nom.equalsIgnoreCase("agenceService")) {
            try {
                Client.oos.writeObject(nom);
                Client.oos.flush();
                
                ArrayList<Agence> listeAgence = (ArrayList<Agence>) Client.ois.readObject();
                return listeAgence;
                
            } catch (    IOException | ClassNotFoundException ex) {
                Logger.getLogger(InitialContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if ( nom.equalsIgnoreCase("compteService")) {
            try {
                Client.oos.writeObject(nom);
                Client.oos.flush();
                
                Client.oos.writeObject(numAgence);
                Client.oos.flush();
                
                Client.oos.writeObject(nomClient);
                Client.oos.flush();
                
                if ( numAgence > 0 ) {
                    if( !"".equals(nomClient) ){
                        Compte compte = (Compte) Client.ois.readObject();
                        return compte;
                    }
                    else {
                        ArrayList<Compte> liste = (ArrayList<Compte>) Client.ois.readObject();
                        return liste;
                    }
                }
                else {
                    ArrayList<Compte> liste = (ArrayList<Compte>) Client.ois.readObject();
                    return liste;
                }     
            } catch (    IOException | ClassNotFoundException ex) {
                Logger.getLogger(InitialContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if ( nom.equalsIgnoreCase("ajoutService")) {
            try {
                Client.oos.writeObject(nom);
                Client.oos.flush();
                
                Client.oos.writeObject(ServiceLocator.params[0]);
                Client.oos.flush();
                
                if ( ServiceLocator.params[0] instanceof Compte ){
                    Client.oos.writeObject(ServiceLocator.params[1]);
                    Client.oos.flush();
                }
                
            } catch (IOException ex) {
                Logger.getLogger(InitialContext.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        return null;
    }
    
}
