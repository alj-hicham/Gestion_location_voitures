/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.UserDao;
import Model.user;
import helper.UserHelper;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Amine Smaki
 */
public class User extends javax.swing.JFrame {

    public String add1 = null;
    UserDao ud = new UserDao();
    UserHelper uh = new UserHelper();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Combochoix;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField rech;
    private javax.swing.JButton save;

    /**
     * Creates new form User
     */
    public User() {
        initComponents();
        try {
            initialisation_jTable();

        } catch (SQLException ex) {

        }
    }

    /**
     * @param args the saveline arguments
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
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User().setVisible(true);
            }
        });
    }

    private void Reset() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jComboBox1.setSelectedIndex(0);
        save.setEnabled(true);
        jButton2.setEnabled(false);
        jButton1.setEnabled(false);


    }

    public void modifier() {
        String n = jTextField1.getText();
        String n1 = jTextField2.getText();
        String n2 = jTextField3.getText();
        String n3 = (String) jComboBox1.getSelectedItem();
        user uu = new user(n, n1, n2, n3);
        if (jTextField1.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "S'il vous plait entrer id utilisateur .", "Erreur", JOptionPane.ERROR_MESSAGE);
            jTextField1.requestFocus();
            return;
        }
        if (jTextField2.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "S'il vous plait Selectionez le  nom  utilisateur .", "Erreur", JOptionPane.ERROR_MESSAGE);
            jTextField2.requestFocus();
            return;
        }
        if (jTextField3.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "S'il vous plait entrer le prenom utilisateur .", "Erreur", JOptionPane.ERROR_MESSAGE);
            jTextField3.requestFocus();
            return;
        }
        if (jComboBox1.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(this, "S'il vous plait entrer le role .", "Erreur", JOptionPane.ERROR_MESSAGE);
            jComboBox1.requestFocus();
            return;
        }
        try {
            boolean a = ud.modifier(add1, uu);
            if (a == false) {
                JOptionPane.showMessageDialog(this, "vous n'avez pas modifiée enregistrement correctement", "Marque", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "vous avez modifiée enregistrement correctement", "Marque", JOptionPane.INFORMATION_MESSAGE);
                uh.update(uu, jTable1.getSelectedRow());
            }
        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }

        // uu = null;
    }

    public void Ajouter() {
        String IDUTIL = this.jTextField1.getText();
        String NOMUTIL = this.jTextField2.getText();
        String PASSUTIL = this.jTextField3.getText();
//        String ROLE= this.jTextField4.getText();
        String ROLE = (String) this.jComboBox1.getSelectedItem();

        user t = new user(IDUTIL, NOMUTIL, PASSUTIL, ROLE);
        if (jTextField1.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "S'il vous plait entrer id utilisateur .", "Erreur", JOptionPane.ERROR_MESSAGE);
            jTextField1.requestFocus();
            return;
        }
        if (jTextField2.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "S'il vous plait Selectionez le  nom  utilisateur .", "Erreur", JOptionPane.ERROR_MESSAGE);
            jTextField2.requestFocus();
            return;
        }
        if (jTextField3.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "S'il vous plait entrer le prenom utilisateur .", "Erreur", JOptionPane.ERROR_MESSAGE);
            jTextField3.requestFocus();
            return;
        }
        if (jComboBox1.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(this, "S'il vous plait entrer le role .", "Erreur", JOptionPane.ERROR_MESSAGE);
            jComboBox1.requestFocus();
            return;
        }
        try {
            boolean tt = ud.ajouter(t);


            if (tt = true) {
                JOptionPane.showMessageDialog(null, "vous avez  ajouté enregistrement correctement!");
            } else {
                JOptionPane.showMessageDialog(null, "vous n'avez pas ajouté enregistrement correctement!");
            }
        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }


    }

    public void initialisation_jTable() throws SQLException {
        jTable1.setModel(uh);
        uh.setList(ud.Lister());
    }

    public void initialisationId_jTable(String cle) throws SQLException {
        jTable1.setModel(uh);
        uh.setList(ud.ListerP(cle));
        //count.setText(""+n.getRowCount());
    }

    public void initialisationN_jTable(String cle) throws SQLException {
        jTable1.setModel(uh);
        uh.setList(ud.ListerN(cle));
    }

    public void initialisationR_jTable(String cle) throws SQLException {
        jTable1.setModel(uh);
        uh.setList(ud.ListerR(cle));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        save = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        Combochoix = new javax.swing.JComboBox<>();
        rech = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(153, 102, 255));

        jLabel2.setText("Nom Utilisateur  :");

        jLabel3.setText("Pass Utilisateur  :");

        jLabel1.setText("Id Utilisateur  :");

        jLabel4.setText("Role Utilisateur  :");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{" ", "Admin", "User"}));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel4))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jTextField2)
                                                        .addComponent(jTextField1)
                                                        .addComponent(jTextField3)
                                                        .addComponent(jComboBox1, 0, 178, Short.MAX_VALUE))))
                                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 102, 255));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/5.png"))); // NOI18N
        jButton2.setText("Modifier");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/3.png"))); // NOI18N
        jButton1.setText("Supprimer");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/4.png"))); // NOI18N
        save.setText("Ajouter");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/1467670175_Shop-Payment-39.png"))); // NOI18N
        jButton4.setText("Nouveau");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(save)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2)
                                        .addComponent(save)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(153, 102, 255));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/6.png"))); // NOI18N
        jButton3.setText("rechercher");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        Combochoix.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"All", "idutil", "nomutil", "role"}));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(Combochoix, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rech, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(Combochoix, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jButton3))
                                        .addComponent(rech, javax.swing.GroupLayout.Alignment.LEADING))
                                .addContainerGap())
        );

        jTable1.setBackground(new java.awt.Color(204, 0, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:

        // UserDao g=new UserDao();


        try {
            Ajouter();
            Reset();
            initialisation_jTable();
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:

        int row = jTable1.getSelectedRow();
        String table_click = jTable1.getModel().getValueAt(row, 0).toString();
        List<user> ListerP = null;
        try {
            ListerP = ud.ListerP(table_click);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }

        for (user l : ListerP) {
            add1 = l.getIDUTIL();
            jTextField1.setText(add1);
            String add2 = l.getNONUTIL();
            jTextField2.setText(add2);
            String add3 = l.getPASSUTIL();
            jTextField3.setText(add3);
            String add4 = l.getROLE();
            jComboBox1.setSelectedItem(add4);

        }
        save.setEnabled(false);
        jButton2.setEnabled(true);
        jButton1.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        try {
            int P = JOptionPane.showConfirmDialog(null, " Voulez vous vraiment supprimer l'enregistrement ?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (P == 0) {


                boolean cc = ud.supprimer(add1);
                if (cc == true) {
                    JOptionPane.showMessageDialog(this, "vous avez supprimé enregistrement correctement");


                    uh.remove(jTable1.getSelectedRow());
                    Reset();

                } else {
                    JOptionPane.showMessageDialog(this, "vous n'avez pas supprimé enregistrement correctement");

                }

            }
        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        switch (Combochoix.getSelectedIndex()) {
            case 0:
                try {
                    initialisation_jTable();
                } catch (SQLException ex) {
                    Logger.class.getName();
                }
                break;
            case 1:
                try {
                    initialisationId_jTable(rech.getText());
                    rech.setText("");
                } catch (SQLException ex) {
                    Logger.class.getName();
                }
                break;
            case 2:
                try {
                    initialisationN_jTable(rech.getText());
                    rech.setText("");
                } catch (SQLException ex) {
                    Logger.class.getName();
                }
                break;
            case 3:
                try {
                    initialisationR_jTable(rech.getText());
                    rech.setText("");
                } catch (SQLException ex) {
                    Logger.class.getName();
                }
                break;
            default:
                break;
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        try {

            modifier();

            Reset();
        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Reset();

    }//GEN-LAST:event_jButton4ActionPerformed
    // End of variables declaration//GEN-END:variables
}
