/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import beans.Operation;
import dao.OperationDAO;
import java.util.ArrayList;

/**
 *
 * @author pacheikh
 */
public class OperationServiceImpl implements IOperationService {

    OperationDAO operationDAO;

    @Override
    public void ajouterOperation(Operation operation) {
        operationDAO = new OperationDAO();
        operationDAO.connect();
        operationDAO.ajouter(operation);
    }

    @Override
    public ArrayList<Operation> getOperationByNum(String numCompte) {
        operationDAO = new OperationDAO();
        operationDAO.connect();
        return operationDAO.getOperationByNum(numCompte);
    }

    @Override
    public ArrayList<Operation> getAllOperation() {
        operationDAO = new OperationDAO();
        operationDAO.connect();
        return operationDAO.getAllOperation();
    }
    
    @Override
    public String getNom() {
        return "operationService";
    }
}
