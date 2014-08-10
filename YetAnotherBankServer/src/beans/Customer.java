/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;

/**
 *
 * @author pacheikh
 */
public class Customer implements Serializable {
    
    private int numcli;
    private String nomCli;
    private String prenomCli;
    private int numag;

    public int getNumcli() {
        return numcli;
    }

    public void setNumcli(int numcli) {
        this.numcli = numcli;
    }

    public String getNomCli() {
        return nomCli;
    }

    public void setNomCli(String nomCli) {
        this.nomCli = nomCli;
    }

    public String getPrenomCli() {
        return prenomCli;
    }

    public void setPrenomCli(String prenomCli) {
        this.prenomCli = prenomCli;
    }

    public int getNumag() {
        return numag;
    }

    public void setNumag(int numag) {
        this.numag = numag;
    }
}
