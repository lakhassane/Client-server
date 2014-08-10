/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import test.Client;
import beans.Compte;
import beans.Operation;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import test.ServiceLocator;

/**
 *
 * @author pacheikh
 */
public class AjoutOperationGUI extends javax.swing.JFrame {

    /**
     * Creates new form AjoutOperationGUI
     */
    public AjoutOperationGUI() {

        ArrayList<Compte> listeCompte = (ArrayList<Compte>) ServiceLocator.getService("compteService",
                ClientGUI.customer.getNumcli(), "");

//            Client.oos.writeObject("getCompte");
//            Client.oos.flush();
//
//            Client.oos.writeObject(ClientGUI.customer.getNumcli());
//            Client.oos.flush();
//
//            Client.oos.writeObject("");
//            Client.oos.flush();

//            ArrayList<Compte> listeCompte = (ArrayList<Compte>) Client.ois.readObject();

        String[] nomCompte = new String[listeCompte.size()];
        for (int i = 0; i < listeCompte.size(); i++) {
            nomCompte[i] = String.valueOf(listeCompte.get(i).getNumcpt());
        }

        listeCompteComboBox = new JComboBox(nomCompte);

        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sommeField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        retirerButton = new javax.swing.JButton();
        deposerButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
//        listeCompteComboBox = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Somme");

        jButton2.setText("quitter");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        retirerButton.setText("Retirer");
        retirerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retirerButtonActionPerformed(evt);
            }
        });

        deposerButton.setText("Déposer");
        deposerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deposerButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Compte");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sommeField, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(retirerButton)
                        .addGap(18, 18, 18)
                        .addComponent(deposerButton))
                    .addComponent(listeCompteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(157, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(listeCompteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sommeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(retirerButton)
                    .addComponent(deposerButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void retirerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retirerButtonActionPerformed
        try {
            Compte compte = (Compte) ServiceLocator.getService("compteService",
                ClientGUI.customer.getNumcli(), (String) listeCompteComboBox.getSelectedItem());
            
//            Client.oos.writeObject("getCompte");
//            Client.oos.flush();
//
//            Client.oos.writeObject(ClientGUI.customer.getNumcli());
//            Client.oos.flush();
//
//            Client.oos.writeObject(listeCompteComboBox.getSelectedItem());
//            Client.oos.flush();

//            Compte compte = (Compte) Client.ois.readObject();
            compte.setSoldecpt(Math.abs(compte.getSoldecpt() - Float.parseFloat(sommeField.getText())));
            if (compte.getSoldecpt() - Float.parseFloat(sommeField.getText()) < 0) {
                compte.setSenscpt("DB");
            }

            Client.oos.writeObject("updateCompte");
            Client.oos.flush();

            Client.oos.writeObject(compte);
            Client.oos.flush();
            
            Date actuelle = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            
            Operation operation = new Operation();
            operation.setLibelleop("retirer de l'argent");
            operation.setSensop("DB");
            operation.setDateop(dateFormat.format(actuelle));
            operation.setNumcpt(compte.getNumcpt());

            Client.oos.writeObject(operation);
            Client.oos.flush();

            sommeField.setText("");

        } catch (IOException ex) {
            Logger.getLogger(AjoutOperationGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_retirerButtonActionPerformed

    private void deposerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deposerButtonActionPerformed
        try {
            
            Compte compte = (Compte) ServiceLocator.getService("compteService",
            ClientGUI.customer.getNumcli(), (String) listeCompteComboBox.getSelectedItem());
            
//            Client.oos.writeObject("getCompte");
//            Client.oos.flush();
//
//            Client.oos.writeObject(ClientGUI.customer.getNumcli());
//            Client.oos.flush();
//
//            Client.oos.writeObject(listeCompteComboBox.getSelectedItem());
//            Client.oos.flush();

//            Compte compte = (Compte) Client.ois.readObject();
            if ("DB".equals(compte.getSenscpt())) {
                if (-compte.getSoldecpt() + Float.parseFloat(sommeField.getText()) < 0) {
                    compte.setSoldecpt(Math.abs(-compte.getSoldecpt() + Float.parseFloat(sommeField.getText())));
                } else {
                    compte.setSoldecpt(-compte.getSoldecpt() + Float.parseFloat(sommeField.getText()));
                    compte.setSenscpt("CR");
                }
            }

            Client.oos.writeObject("updateCompte");
            Client.oos.flush();

            Client.oos.writeObject(compte);
            Client.oos.flush();

            Operation operation = new Operation();
            operation.setLibelleop("déposer de l'argent");
            operation.setSensop("CR");
            operation.setDateop(null);
            operation.setNumcpt(compte.getNumcpt());

            Client.oos.writeObject(operation);
            Client.oos.flush();

            sommeField.setText("");

        } catch (IOException ex) {
            Logger.getLogger(AjoutOperationGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deposerButtonActionPerformed
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(AjoutOperationGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AjoutOperationGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AjoutOperationGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AjoutOperationGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AjoutOperationGUI().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deposerButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox listeCompteComboBox;
    private javax.swing.JButton retirerButton;
    private javax.swing.JTextField sommeField;
    // End of variables declaration//GEN-END:variables
}
