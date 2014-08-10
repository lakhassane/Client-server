/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import gui.ConnexionGUI;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author Lakhassane
 */
public class Client {

    private static Socket socket;
    public static InputStream is ;
    public static OutputStream os;
    public static ObjectOutputStream oos;
    public static ObjectInputStream ois;
    
    public Client() {
        ConnexionGUI connexionGUI = new ConnexionGUI();
        connexionGUI.setVisible(true);
        
        try{
            socket= new Socket("127.0.0.1", 3000);
            is = socket.getInputStream();
            os = socket.getOutputStream();
            oos = new ObjectOutputStream( os );
            ois = new ObjectInputStream( is );
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
         
    public static void main( String args[] ) {
        new Client();
    }
    
}
