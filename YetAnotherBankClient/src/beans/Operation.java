/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author pacheikh
 */
public class Operation implements Serializable {
     
    private int codeop;
    private String libelleop;
    private String sensop;
    private String dateop;
    private int numcpt;

    public int getCodeop() {
        return codeop;
    }

    public void setCodeop(int codeop) {
        this.codeop = codeop;
    }

    public String getLibelleop() {
        return libelleop;
    }

    public void setLibelleop(String libelleop) {
        this.libelleop = libelleop;
    }

    public String getSensop() {
        return sensop;
    }

    public void setSensop(String sensop) {
        this.sensop = sensop;
    }

    public String getDateop() {
        return dateop;
    }

    public void setDateop(String dateop) {
        this.dateop = dateop;
    }

    public int getNumcpt() {
        return numcpt;
    }

    public void setNumcpt(int numcpt) {
        this.numcpt = numcpt;
    }
    
}
