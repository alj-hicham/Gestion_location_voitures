/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.DaoRevsion;
import Dao.DaoVehicule;
import Model.Revsion;
import Model.Vehicule;
import helper.VehiculeHelper;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Lenovo
 */
public class ViewListVehicule extends javax.swing.JFrame {

    /**
     * Creates new form ViewListVehicule
     */
    List<Vehicule> vho = null;
    VehiculeHelper hevh = new VehiculeHelper();
    DaoVehicule v = new DaoVehicule();
    DaoRevsion rr = new DaoRevsion();
    List<Revsion> rep = null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Combochoix;
    private javax.swing.JTable Vhe;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField rech;

    public ViewListVehicule() {

        initComponents();
        try {
            initialisation_jTable();
        } catch (SQLException ex) {
            Logger.getLogger(ViewListVehicule.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(ViewListVehicule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewListVehicule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewListVehicule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewListVehicule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewListVehicule().setVisible(true);
            }
        });
    }

    public void count() {
        int o = hevh.getRowCount();
        jTextField1.setText("" + o);
        if (o == 0) {
            JOptionPane.showMessageDialog(this, "aucun enregistrement trouvé .", "Model :(", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void initialisation_jTable() throws SQLException {
        Vhe.setModel(hevh); // on bronche jTable avc l userHelper
        hevh.setList(v.listerDetail()); // on rempli  la liste de l userHelper .. ( qui va etre afficher dans le jTable)
        count();
    }

    public void initialisationMatr_jTable(String cle) throws SQLException {
        Vhe.setModel(hevh); // on bronche jTable avc l userHelper
        hevh.setList(v.listerDetailMtr(cle)); // on rempli  la liste de l userHelper .. ( qui va etre afficher dans le jTable)
        count();
    }

    //GEN-LAST:event_jButton1ActionPerformed

    public void initialisationMarq_jTable(String cle) throws SQLException {
        Vhe.setModel(hevh); // on bronche jTable avc l userHelper
        hevh.setList(v.listerDetailMarque(cle)); // on rempli  la liste de l userHelper .. ( qui va etre afficher dans le jTable)
        count();
    }

    public void initialisationModel_jTable(String cle) throws SQLException {
        Vhe.setModel(hevh); // on bronche jTable avc l userHelper
        hevh.setList(v.listerDetailModel(cle)); // on rempli  la liste de l userHelper .. ( qui va etre afficher dans le jTable)
        jTextField1.setText("" + hevh.getRowCount());
    }

    public void initialisationMatrprix_jTable(Double cle) throws SQLException {
        Vhe.setModel(hevh); // on bronche jTable avc l userHelper
        hevh.setList(v.listerprixVh(cle)); // on rempli  la liste de l userHelper .. ( qui va etre afficher dans le jTable)
        count();
    }

    public void initialisationtrue_jTable() throws SQLException {
        Vhe.setModel(hevh); // on bronche jTable avc l userHelper
        hevh.setList(v.listerVhDi()); // on rempli  la liste de l userHelper .. ( qui va etre afficher dans le jTable)
        count();
    }

    public void initialisationFalse_jTable() throws SQLException {
        Vhe.setModel(hevh); // on bronche jTable avc l userHelper
        hevh.setList(v.listerVhNotDi()); // on rempli  la liste de l userHelper .. ( qui va etre afficher dans le jTable)
        count();
    }

    public void initialisationcat_jTable(String cle) throws SQLException {
        Vhe.setModel(hevh); // on bronche jTable avc l userHelper
        hevh.setList(v.listerDetailCat(cle)); // on rempli  la liste de l userHelper .. ( qui va etre afficher dans le jTable)
        count();
    }

    public void initialisationtrue() {
        Vhe.setModel(hevh); // on bronche jTable avc l userHelper
        hevh.setList(v.listerVhDi()); // on rempli  la liste de l userHelper .. ( qui va etre afficher dans le jTable)
        count();
    }

    public void initialisationFalse() {
        Vhe.setModel(hevh); // on bronche jTable avc l userHelper
        hevh.setList(v.listerVhNotDi()); // on rempli  la liste de l userHelper .. ( qui va etre afficher dans le jTable)
        count();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Vhe = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        Combochoix = new javax.swing.JComboBox<>();
        rech = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        Vhe.setBackground(new java.awt.Color(172, 220, 229));
        Vhe.setModel(new javax.swing.table.DefaultTableModel(
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
        Vhe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VheMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Vhe);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        Combochoix.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Matriculation", "Marque", "Model", "Prix", "cat"}));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/6.png"))); // NOI18N
        jButton1.setText("Rechercher");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/1.png"))); // NOI18N
        jButton2.setText("Nouveau");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Disponible");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("No Disponible");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/7.png"))); // NOI18N
        jButton5.setText("Lister");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTextField1.setBackground(new java.awt.Color(0, 102, 102));
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(Combochoix, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rech, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                .addGap(10, 10, 10)
                                .addComponent(jButton1)
                                .addGap(32, 32, 32)
                                .addComponent(jButton5)
                                .addGap(33, 33, 33)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton4)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(rech, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Combochoix)
                                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void VheMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VheMouseClicked
        int row = Vhe.getSelectedRow();
        String table_click = Vhe.getModel().getValueAt(row, 0).toString();
        vho = v.listerDetailMtr(table_click);
        this.dispose();
        FormVehicule f = new FormVehicule();
        f.setVisible(true);

        for (Vehicule v : vho) {
            f.MtrVH.setText(v.getMatrVh());
            f.cle.setText(v.getMatrVh());
            f.dateachat.setText(v.getDateAchat().toString());
            f.idrev.setText(v.getIdRev());
            f.idrev.setEnabled(false);
            f.prixachat.setText(String.valueOf(v.getPrixAchat()));
            f.Comboboite.setSelectedItem(v.getBoitevitesse());
            f.Combocategorie.setSelectedItem(v.getCat().getNomCat());
            f.Comboclim.setSelectedItem(v.getAc());
            f.Combomarque.setSelectedItem(v.getMa().getNimMarque());
            f.Combomodel.setSelectedItem(v.getMo().getNomModel());
            if (v.isStatutVh() == false) {
                f.Combost.setSelectedItem("non");
            } else {
                f.Combost.setSelectedItem("oui");
            }

            //String s1= ""+v.getKms();
            f.kms.setText(String.valueOf(v.getKms()));
            f.prixjour.setText(String.valueOf(v.getPrixJourVh()));
            f.nombrepass.setValue(v.getNbPasssager());
            f.nombrp.setValue(v.getNbPort());
            f.jTextField8.setText(v.getImagVh());

            ImageIcon icone = new ImageIcon(v.getImagVh());
            Image ima;
            ima = icone.getImage().getScaledInstance(333, 190, Image.SCALE_DEFAULT);
            ImageIcon icone1 = new ImageIcon(ima);
            f.img.setIcon(icone1);
        }

        rep = rr.listerId(Vhe.getModel().getValueAt(row, 1).toString());
        for (Revsion v : rep) {
            f.datefinas.setText(v.getDateFinas().toString());
            f.datefinas.setEnabled(false);
            f.datefinvi.setText(v.getDateVist().toString());
            f.datefinvi.setEnabled(false);
            f.datefinvite.setText(String.valueOf(v.getVid()));
            f.datefinvite.setEnabled(false);
            f.idrev.setText(v.getIdRev());
        }

        f.Sup.setEnabled(true);
        f.modi.setEnabled(true);
        f.jButton4.setEnabled(false);
    }//GEN-LAST:event_VheMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //this.hide();
        FormVehicule f = new FormVehicule();
        f.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (Combochoix.getSelectedIndex() == 0) {
            try {
                initialisationMatr_jTable(rech.getText());
            } catch (SQLException ex) {
                Logger.getLogger(ViewMarque.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (Combochoix.getSelectedIndex() == 1) {
            try {
                initialisationMarq_jTable(rech.getText());
            } catch (SQLException ex) {
                Logger.getLogger(ViewMarque.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (Combochoix.getSelectedIndex() == 2) {
            try {
                initialisationModel_jTable(rech.getText());
            } catch (SQLException ex) {
                Logger.getLogger(ViewMarque.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (Combochoix.getSelectedIndex() == 3) {
            try {
                initialisationMatrprix_jTable(Double.parseDouble(rech.getText()));
            } catch (SQLException ex) {
                Logger.getLogger(ViewMarque.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (Combochoix.getSelectedIndex() == 4) {
            try {
                initialisationcat_jTable(rech.getText());
            } catch (SQLException ex) {
                Logger.getLogger(ViewMarque.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            initialisation_jTable();
        } catch (SQLException ex) {
            Logger.getLogger(ViewListVehicule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        initialisationtrue();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        initialisationFalse();
    }//GEN-LAST:event_jButton4ActionPerformed
    // End of variables declaration//GEN-END:variables
}