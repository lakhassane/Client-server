/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;

/**
 *
 * @author Lakhassane
 */
public class Agence implements Serializable{
    
    private int numag;
    private String nomag;
    private String adresseag;

    public int getNumag() {
        return numag;
    }

    public void setNumag(int numag) {
        this.numag = numag;
    }

    public String getNomag() {
        return nomag;
    }

    public void setNomag(String nomag) {
        this.nomag = nomag;
    }

    public String getAdresseag() {
        return adresseag;
    }

    public void setAdresseag(String adresseag) {
        this.adresseag = adresseag;
    }
        
}
