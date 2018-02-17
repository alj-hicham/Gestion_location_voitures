/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.DaoMarque;
import Model.GenerMarque;
import Model.Marque;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Lenovo
 */
public class ViewMarque extends javax.swing.JFrame {

    public String add1 = null;
    DaoMarque dm = new DaoMarque();
    helper.MarqueHelper n = new helper.MarqueHelper();
    String re = null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Choix;
    private javax.swing.JTable Marque;
    private javax.swing.JButton Rechercher;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnGetData;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JTextField count;
    private javax.swing.JTextField idmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomMar;
    private javax.swing.JTextField rechercher;

    /**
     * Creates new form ViewModel
     */
    public ViewMarque() {

        initComponents();
        try {
            initialisation_jTable();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewMarque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewMarque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewMarque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewMarque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewMarque().setVisible(true);

            }
        });
    }

    public void inCode() throws SQLException {
        int j;
        String num = "";
        String c = "";
        c = dm.dernier();
        if (c == null) {
            idmar.setText("mar0001");
        } else {
            char r1 = c.charAt(3);
            char r2 = c.charAt(4);
            char r3 = c.charAt(5);
            char r4 = c.charAt(6);
            String r = "";
            r = "" + r1 + r2 + r3 + r4;
            j = Integer.parseInt(r) + 1;
            GenerMarque gen = new GenerMarque();
            gen.generar(j);
            idmar.setText("mar" + gen.serie());

        }

    }

    private void Reset() {
        idmar.setText("");
        nomMar.setText("");
        btnSave.setEnabled(true);
        btnDelete.setEnabled(false);
        btnUpdate.setEnabled(false);

    }

    public void initialisation_jTable() throws SQLException {
        Marque.setModel(n);
        n.setList(dm.ListerMarque());
        count.setText("" + n.getRowCount());
    }

    public void initialisation_jTable(String cle) throws SQLException {
        Marque.setModel(n);
        if (dm.ListerMarqueNom(cle).size() == 0) {
            JOptionPane.showMessageDialog(this, "aucun enregistrement trouvé .", "Marque :( ", JOptionPane.ERROR_MESSAGE);
            initialisation_jTable();
        } else {
            n.setList(dm.ListerMarqueNom(cle));
        }
        count.setText("" + n.getRowCount());

    }

    public void initialisation_jTable1(String cle) throws SQLException {
        Marque.setModel(n);
        if (dm.ListerMarque(cle).size() == 0) {
            JOptionPane.showMessageDialog(this, "aucun enregistrement trouvé .", "Marque :( ", JOptionPane.ERROR_MESSAGE);
            initialisation_jTable();
        } else {
            n.setList(dm.ListerMarque(cle));
        }
        count.setText("" + n.getRowCount());
    }

    public void ajouter() {
        String i = idmar.getText();
        String n1 = nomMar.getText();
        Marque m = new Marque(i, n1);
        boolean a = dm.ajouterMarque(m);
        if (a == false) {
            JOptionPane.showMessageDialog(this, "vous n'avez pas ajouté enregistrement correctement", "Marque", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "vous avez ajouté enregistrement correctement", "Marque", JOptionPane.INFORMATION_MESSAGE);
            n.save(m);
        }

        count.setText("" + n.getRowCount());
        m = null;
    }

    public void modifier() {
        String i = idmar.getText();
        String n1 = nomMar.getText();
        Marque m = new Marque(i, n1);
        boolean a = dm.ModMarque(add1, m);
        if (a == false) {
            JOptionPane.showMessageDialog(this, "vous n'avez pas modifiée enregistrement correctement", "Marque", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "vous avez modifiée enregistrement correctement", "Marque", JOptionPane.INFORMATION_MESSAGE);
            n.update(m, Marque.getSelectedRow());
        }
        // n.getList().set(Marque.getSelectedRow(),m);

        //  n.getList().(m);
        count.setText("" + n.getRowCount());

        m = null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Choix = new javax.swing.JComboBox<>();
        rechercher = new javax.swing.JTextField();
        Rechercher = new javax.swing.JButton();
        count = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnGetData = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Marque = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nomMar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        idmar = new javax.swing.JTextField();

        jRadioButton1.setText("jRadioButton1");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Rechercher"));

        Choix.setBackground(new java.awt.Color(102, 102, 102));
        Choix.setForeground(new java.awt.Color(255, 255, 255));
        Choix.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Id Marque", "Nom Marque", " "}));
        Choix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChoixActionPerformed(evt);
            }
        });

        rechercher.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                rechercherHierarchyChanged(evt);
            }
        });
        rechercher.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }

            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                rechercherInputMethodTextChanged(evt);
            }
        });
        rechercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechercherActionPerformed(evt);
            }
        });
        rechercher.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                rechercherPropertyChange(evt);
            }
        });
        rechercher.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rechercherKeyReleased(evt);
            }
        });
        rechercher.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt) throws java.beans.PropertyVetoException {
                rechercherVetoableChange(evt);
            }
        });

        Rechercher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/6.png"))); // NOI18N
        Rechercher.setText("Rechercher");
        Rechercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RechercherActionPerformed(evt);
            }
        });

        count.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(rechercher, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Choix, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(Rechercher)
                                .addGap(18, 18, 18)
                                .addComponent(count, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(count)
                                        .addComponent(Rechercher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Choix, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(rechercher, javax.swing.GroupLayout.Alignment.LEADING))
                                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnNew.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/4.png"))); // NOI18N
        btnNew.setText("Nouveau");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/2.png"))); // NOI18N
        btnSave.setText("Ajouter");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/5.png"))); // NOI18N
        btnUpdate.setText("Modifier");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/3.png"))); // NOI18N
        btnDelete.setText("Supprimer");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnGetData.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnGetData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/7.png"))); // NOI18N
        btnGetData.setText("Lister");
        btnGetData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnGetData, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnNew)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addComponent(btnSave)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdate)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelete)
                                .addGap(18, 18, 18)
                                .addComponent(btnGetData)
                                .addContainerGap())
        );

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/marque.png"))); // NOI18N

        Marque.setBackground(new java.awt.Color(0, 204, 204));
        Marque.setModel(new javax.swing.table.DefaultTableModel(
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
        Marque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MarqueMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Marque);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setText("Nom Marque : ");

        nomMar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomMarActionPerformed(evt);
            }
        });

        jLabel1.setText("Id Marque    :");

        jLabel4.setText("(mar+++)");

        idmar.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(idmar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel4)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(nomMar))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel4)
                                        .addComponent(idmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(nomMar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
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

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        Reset();
        try {
            inCode();
        } catch (SQLException ex) {
            Logger.getLogger(ViewMarque.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (idmar.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "S'il vous plait entrer ID Marque .", "Erreur", JOptionPane.ERROR_MESSAGE);
            idmar.requestFocus();
            return;
        }
        if (nomMar.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "s'il vous plait entrer Nom De Marque .", "Erreur", JOptionPane.ERROR_MESSAGE);
            nomMar.requestFocus();
            return;
        }

        try {
            ajouter();
            Reset();
        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (idmar.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "S'il vous plait entrer ID Marque .", "Erreur", JOptionPane.ERROR_MESSAGE);
            idmar.requestFocus();
            return;
        }
        if (nomMar.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "s'il vous plait entrer Nom De Marque .", "Erreur", JOptionPane.ERROR_MESSAGE);
            nomMar.requestFocus();
            return;
        }

        try {

            modifier();

            Reset();
        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            int P = JOptionPane.showConfirmDialog(this, "Voulez vous vraiment supprimer cette marque ?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (P == 0) {
                boolean c = dm.supMarque(add1);
                if (c == true) {
                    JOptionPane.showMessageDialog(this, "vous avez supprimé enregistrement correctement");
                    Reset();
                    //n.getList().remove(Marque.getSelectedRow());
                    // n.fireTableDataChanged();
                    // initialisation_jTable();

                    n.remove(Marque.getSelectedRow());
                    count.setText("" + n.getRowCount());
                } else {
                    JOptionPane.showMessageDialog(this, "vous n'avez pas supprimé enregistrement correctement");
                }
            }
        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(this, ex);
            //  } catch (SQLException ex) {
            // JOptionPane.showMessageDialog(this, ex);
            // }

        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnGetDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetDataActionPerformed
        try {
            initialisation_jTable();
            rechercher.setText("");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_btnGetDataActionPerformed

    private void nomMarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomMarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomMarActionPerformed

    private void MarqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MarqueMouseClicked
        int row = Marque.getSelectedRow();
        String table_click = Marque.getModel().getValueAt(row, 0).toString();
        List<Marque> ListerMarque = null;
        try {
            ListerMarque = dm.ListerMarque(table_click);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }

        for (Marque l : ListerMarque) {
            add1 = l.getIdMarque();
            idmar.setText(add1);
            String add2 = l.getNimMarque();
            nomMar.setText(add2);

        }
        btnUpdate.setEnabled(true);
        btnDelete.setEnabled(true);
        btnSave.setEnabled(false);

        // TODO add your handling code here:
    }//GEN-LAST:event_MarqueMouseClicked

    private void rechercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechercherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rechercherActionPerformed

    private void rechercherInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_rechercherInputMethodTextChanged


    }//GEN-LAST:event_rechercherInputMethodTextChanged

    private void rechercherHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_rechercherHierarchyChanged

    }//GEN-LAST:event_rechercherHierarchyChanged

    private void rechercherPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_rechercherPropertyChange

    }//GEN-LAST:event_rechercherPropertyChange

    private void rechercherVetoableChange(java.beans.PropertyChangeEvent evt) throws java.beans.PropertyVetoException {//GEN-FIRST:event_rechercherVetoableChange

    }//GEN-LAST:event_rechercherVetoableChange

    private void RechercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RechercherActionPerformed

        String re = rechercher.getText();

        if (Choix.getSelectedIndex() == 1) {
            try {
                initialisation_jTable(re);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
        } else {
            try {
                initialisation_jTable1(re);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
        }

    }//GEN-LAST:event_RechercherActionPerformed

    private void ChoixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChoixActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ChoixActionPerformed

    private void rechercherKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rechercherKeyReleased

    }//GEN-LAST:event_rechercherKeyReleased
    // End of variables declaration//GEN-END:variables
}
