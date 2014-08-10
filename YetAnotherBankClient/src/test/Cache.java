/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author pacheikh
 */
public class Cache {
    
    Map<String, Object> services;
    
    public Cache(){
        services = new HashMap<>();
    }
    
    public void addService(String nom, Object objet) {
        boolean exist = false;
        System.out.println("Service ajouté au cache : " + nom );
        for (String service : services.keySet()){
            if ( service.equalsIgnoreCase(nom)){
                exist = true;
            }
        }
        if ( !exist )
            services.put(nom, objet);
    }
    
    public Object getService( String nom ){
        System.out.println("service : " + nom);
        for (String service : services.keySet()){
            if ( service.equalsIgnoreCase(nom)){
                return services.get(nom);
            }
        }
        return null;
    }
}
