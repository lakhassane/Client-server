/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import beans.Operation;

/**
 *
 * @author pacheikh
 */
public interface IOperationService {
    
    public void ajouterOperation( Operation operation );
    public String getNom();
}
