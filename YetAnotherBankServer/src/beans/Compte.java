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
public class Compte implements Serializable {
    
    private int numcpt;
    private String libellecpt;
    private float soldecpt;
    private String senscpt;
    private int numcli;

    public int getNumcpt() {
        return numcpt;
    }

    public void setNumcpt(int numcpt) {
        this.numcpt = numcpt;
    }

    public String getLibellecpt() {
        return libellecpt;
    }

    public void setLibellecpt(String libellecpt) {
        this.libellecpt = libellecpt;
    }

    public float getSoldecpt() {
        return soldecpt;
    }

    public void setSoldecpt(float soldecpt) {
        this.soldecpt = soldecpt;
    }

    public String getSenscpt() {
        return senscpt;
    }

    public void setSenscpt(String senscpt) {
        this.senscpt = senscpt;
    }

    public int getNumcli() {
        return numcli;
    }

    public void setNumcli(int numcli) {
        this.numcli = numcli;
    }
    
}
