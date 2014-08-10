/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import beans.Agence;
import dao.AgenceDAO;
import java.util.ArrayList;

/**
 *
 * @author pacheikh
 */
public class AgenceServiceImpl implements IAgenceService {

    AgenceDAO agenceDAO;

    @Override
    public void ajouterAgence(Agence agence) {
        agenceDAO = new AgenceDAO();
        agenceDAO.connect();
        agenceDAO.ajouter(agence);
    }

    @Override
    public ArrayList<Agence> getAllAgence() {
        agenceDAO = new AgenceDAO();
        agenceDAO.connect();
        return agenceDAO.getAllAgence();
    }

    @Override
    public String getNom() {
        return "agenceService";
    }
}
