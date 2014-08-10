/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import beans.Compte;
import dao.CompteDAO;
import java.util.ArrayList;

/**
 *
 * @author pacheikh
 */
public class CompteServiceImpl implements ICompteService {
    
    CompteDAO compteDAO;

    @Override
    public void ajouterCompte(Compte compte) {
        compteDAO = new CompteDAO();
        compteDAO.connect();
        compteDAO.ajouter(compte);
    }

    @Override
    public ArrayList<Compte> getAllCompte() {
        compteDAO = new CompteDAO();
        compteDAO.connect();
        return compteDAO.getAllCompte();
    }

    @Override
    public Compte getCompteByNum(String numCmpte) {
        compteDAO = new CompteDAO();
        compteDAO.connect();
        return compteDAO.getCompteByNum(numCmpte);
    }

    @Override
    public ArrayList<Compte> getCompteByClient(int client) {
        compteDAO = new CompteDAO();
        compteDAO.connect();
        return compteDAO.getCompteByClientDB(client);
    }

    @Override
    public void updateCompte(int numCompte, Compte compte) {
        compteDAO = new CompteDAO();
        compteDAO.connect();
        compteDAO.updateCompte(numCompte, compte);
    }

    @Override
    public String getNom() {
        return "compteService";
    }
}
