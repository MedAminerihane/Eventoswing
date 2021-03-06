/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DaoClasse.ClientDao;
import DaoClasse.PrestataireDao;
import DaoInterface.IClientDao;
import DaoInterface.IPrestataireDao;
import Entites.Client;
import Entites.Prestataire;
import Entites.Utilisateur;
import Technique.MyConnection;
//import com.github.sarxos.webcam.Webcam;
import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author walid
 */
public class Inscription extends javax.swing.JFrame {

    /**
     * Creates new form Inscription
     */
    com.github.sarxos.webcam.Webcam webcam = com.github.sarxos.webcam.Webcam.getDefault();

    IClientDao clientDAO = new ClientDao();
    IPrestataireDao prestataireDAO = new PrestataireDao();
//    com.github.sarxos.webcam.Webcam webcam = com.github.sarxos.webcam.Webcam.getDefault();
    int i = 0;

    public Inscription() {
        initComponents();
        setBounds(300, 100, 996, 613);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nom = new javax.swing.JTextField();
        adresse = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        mail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        telephone = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        password = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        prenom = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        age = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cin = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        matricule = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        description = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        nature = new javax.swing.JComboBox();
        enregistrer = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        nom1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

        jLabel9.setText("jLabel9");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Nom :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 70, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Adresse :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 72, -1));

        nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomActionPerformed(evt);
            }
        });
        getContentPane().add(nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 145, -1));
        getContentPane().add(adresse, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 145, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Mail :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 50, -1));
        getContentPane().add(mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 145, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Telephone :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 80, -1));
        getContentPane().add(telephone, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 145, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Password :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 80, -1));

        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 145, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Prenom :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 70, -1));
        getContentPane().add(prenom, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 145, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Age :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 36, -1));
        getContentPane().add(age, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 145, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("CIN :");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 40, -1));
        getContentPane().add(cin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 145, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("Matricule Fiscale :");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 120, -1));
        getContentPane().add(matricule, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 145, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setText("Description :");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 90, -1));
        getContentPane().add(description, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, 145, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Nature :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 60, -1));

        nature.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        nature.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Prestataire", "Client" }));
        nature.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                natureActionPerformed(evt);
            }
        });
        getContentPane().add(nature, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, -1, -1));

        enregistrer.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        enregistrer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1424898582_shopping-add-64.png"))); // NOI18N
        enregistrer.setText("Enregistrer");
        enregistrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enregistrerActionPerformed(evt);
            }
        });
        getContentPane().add(enregistrer, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 190, 70));

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1424819742_arrow_return_down_left.png"))); // NOI18N
        jButton4.setText("Retour");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, 190, -1));

        nom1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nom1ActionPerformed(evt);
            }
        });
        getContentPane().add(nom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 145, -1));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("Username :");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 80, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void natureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_natureActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_natureActionPerformed

    private void nomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomActionPerformed

    private void enregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enregistrerActionPerformed
        Client client = new Client();
        Prestataire prestataire = new Prestataire();
        if (nom.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "veuillez saisir le nom du Compte");
        } else if ((!(mail.getText().contains("@")) | (!(mail.getText().contains(".")))) | (mail.getText().contains("[;,$,<]"))) {
            JOptionPane.showMessageDialog(rootPane, "veuillez saisir Un email correcte");
        } else if (adresse.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "veuillez saisir l'adresse ");
        } else if (telephone.getText() == null) {
            JOptionPane.showMessageDialog(rootPane, "veuillez saisir le numero de telephone");
        } else if (password.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "veuillez saisir le Mot de Passe");
        } else {
            if (nature.getSelectedIndex() == 0) {

                prestataire.setUsername(nom1.getText());

                prestataire.setNom(nom.getText());
                prestataire.setPassword(password.getText());
                prestataire.setAdresse(adresse.getText());
                prestataire.setMail(mail.getText());
                prestataire.setTel(Integer.parseInt(telephone.getText()));
                prestataire.setDescription(description.getText());
                prestataire.setMatriculeFiscale(matricule.getText());
                prestataire.setNature(0);

                prestataireDAO.insertPrestataire(prestataire);
                JOptionPane.showMessageDialog(prenom, "Prestataire ajouté avec succée");
            } else {
                client.setUsername(nom.getText());

                client.setNom(nom.getText());
                client.setPassword(password.getText());
                client.setAdresse(adresse.getText());
                client.setMail(mail.getText());
                client.setTel(Integer.parseInt(telephone.getText()));
                client.setAge(Integer.parseInt(age.getText()));
                client.setPrenom(prenom.getText());
                client.setCin(Integer.parseInt(cin.getText()));
                client.setNature(1);

                clientDAO.insertClient(client);
                JOptionPane.showMessageDialog(prenom, "Client ajouté avec succée");

            }
        }
    }//GEN-LAST:event_enregistrerActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new Authentification().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void nom1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nom1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nom1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inscription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inscription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inscription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inscription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inscription().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adresse;
    private javax.swing.JTextField age;
    private javax.swing.JTextField cin;
    private javax.swing.JTextField description;
    private javax.swing.JButton enregistrer;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField mail;
    private javax.swing.JTextField matricule;
    private javax.swing.JComboBox nature;
    private javax.swing.JTextField nom;
    private javax.swing.JTextField nom1;
    private javax.swing.JTextField password;
    private javax.swing.JTextField prenom;
    private javax.swing.JTextField telephone;
    // End of variables declaration//GEN-END:variables
}
