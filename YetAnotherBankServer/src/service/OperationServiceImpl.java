/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import beans.Operation;
import dao.OperationDAO;

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
    public String getNom() {
        return "operationService";
    }
}
