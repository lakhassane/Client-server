/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author lakhassane
 */
public class ServiceLocator {
    
    private static Cache cache;
    public static Object[] params;
    
    static {
        cache = new Cache();
        params = new Object[2];
    }
    
    public static Object getService( String nom, int numAgence, String nomClient ) {
        Object service = cache.getService(nom+""+numAgence+""+nomClient);
        
        if ( service != null ){
//            System.out.println("Getting it from the cache...");
            return service;
        }
        
//        System.out.println("Initializing system....");
        InitialContext context = new InitialContext();
        Object service1 = context.lookup(nom, numAgence, nomClient);
        cache.addService(nom+""+numAgence+""+nomClient, service1);
        
        return service1;
    }
}
