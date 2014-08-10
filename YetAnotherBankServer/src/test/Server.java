/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Lakhassane
 */
public class Server extends JFrame {
    
    private JTextArea zonerecep;
    private JButton   qt;
    private JPanel    pan1, pan2;

    public Server(){
        
        /* We intatiate a little window to show that the server has started. */
        zonerecep = new JTextArea( 15, 40 );
        qt = new JButton( "Quitter" );
        qt.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setTitle( "Interface Serveur Multiclients" );
        pan1 = new JPanel();
        pan2 = new JPanel();

        pan1.add( new JScrollPane( zonerecep ) );
        
        pan2.add( qt );

        add( pan1, BorderLayout.CENTER );
        add( pan2, BorderLayout.SOUTH );

        setSize( 500, 600 );
        setVisible( true );
        
        try {
            /* Connection to the socket via the port 3000. */
            ServerSocket serv = new ServerSocket( 3000 );
            zonerecep.append( "Le Serveur a demarre " + "\n" );
            
            while ( true ) {
                Socket socket = serv.accept();
                InetAddress adr = socket.getInetAddress();
                String ip = adr.getHostAddress();
                
                zonerecep.append("adresse ip " + ip);
                
                /* Running the class handling the services */
                Service s = new Service(socket);
                s.start();
            }

        } catch ( IOException ex ) {
            System.out.println( ex.getMessage() );
        }
        
    }
    
    
        
    public static void main( String args[] ) {
        new Server();
    }
}
