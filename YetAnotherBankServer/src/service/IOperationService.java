/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import beans.Operation;
import java.util.ArrayList;

/**
 *
 * @author pacheikh
 */
public interface IOperationService {
    
    public void ajouterOperation( Operation operation );
    
    public ArrayList<Operation> getOperationByNum(String numCompte );
    public ArrayList<Operation> getAllOperation();
    public String getNom();
}
