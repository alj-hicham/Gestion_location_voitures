/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewUser;

import Dao.DAOFacture;
import Dao.DaoContrat;
import Dao.DaoVehicule;
import Model.Contrat;
import Model.Facture;
import helper.facturehelper;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author azzus
 */
public class FormfactureUser extends javax.swing.JFrame {

    public String addfac;
    public String add1 = null;
    Dao.DAOFacture fac = new DAOFacture();
    DaoContrat dac = new DaoContrat();
    DaoVehicule vh = new DaoVehicule();
    List<Contrat> lc = null;
    List<Model.Vehicule> lv = null;
    facturehelper fh = new facturehelper();
    int[] mois = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int[] mois1 = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    DaoContrat dc = new DaoContrat();
    DaoVehicule dvv = new DaoVehicule();
    DAOFacture df = new DAOFacture();
    double prix;
    String mat;
    double taxes;
    double HT;
    double Tcc;
    int duree;
    double Tva;
    double mt;
    double remise;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajouter;
    private javax.swing.JTextField dat;
    private javax.swing.JTextField idf;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField mnf;
    private javax.swing.JComboBox<String> tt;

    public FormfactureUser() {
        initComponents();
        chargercombo();
        intialisation_jTable();
    }

    static public boolean bissex(int annee) {
        if (annee % 400 == 0) {
            return true;
        }
        if (annee % 100 == 0) {
            return false;
        }
        return annee % 4 == 0;
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormfactureUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormfactureUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormfactureUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormfactureUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormfactureUser().setVisible(true);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tt = new javax.swing.JComboBox<>();
        dat = new javax.swing.JTextField();
        idf = new javax.swing.JTextField();
        mnf = new javax.swing.JTextField();
        ajouter = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ttActionPerformed(evt);
            }
        });

        idf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idfActionPerformed(evt);
            }
        });

        mnf.setEnabled(false);
        mnf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnfActionPerformed(evt);
            }
        });

        ajouter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/4.png"))); // NOI18N
        ajouter.setText("ajouter");
        ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterActionPerformed(evt);
            }
        });

        jLabel1.setText("date facture");

        jLabel2.setText("ID facture ");

        jLabel3.setText(" Montant à payer");

        jLabel4.setText("ID Contrat");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/5.png"))); // NOI18N
        jButton3.setText("modifier");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

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

        jPanel2.setBackground(new java.awt.Color(255, 217, 167));

        jLabel6.setText("Remise :");

        jLabel7.setText("Prix hors taxes :");

        jLabel8.setText("Prix net HT :");

        jLabel9.setText("TVA :");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/1467670581_calculator-pencil.png"))); // NOI18N
        jButton2.setText("Calculer");
        jButton2.setActionCommand("calculer");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel10.setText("%");

        jLabel11.setText("%");

        jTextField1.setText("0");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.setText("0");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.setEnabled(false);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextField4.setEnabled(false);
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel7))
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel11))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel10))
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel10)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel9)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel11)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addContainerGap())
        );

        jLabel12.setText("DH");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/1467670419_printer.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/1467670175_Shop-Payment-39.png"))); // NOI18N
        jButton5.setText("Nouveau");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(14, 14, 14)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(tt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(idf)
                                                                                        .addComponent(dat))))))
                                                .addGap(32, 32, 32))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(0, 14, Short.MAX_VALUE)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(mnf, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel12)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton4)
                                                .addGap(8, 8, 8))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(ajouter, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                                                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(309, 309, 309)
                                                .addComponent(jLabel5))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(13, 13, 13))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(tt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(28, 28, 28)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(idf, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(40, 40, 40)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(dat, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(mnf, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel12)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void chargercombo() {
        List<Contrat> lc = dac.ListerTou();
        tt.addItem("");
        for (Contrat c : lc) {

            tt.addItem(c.getIdCont());
        }
    }

    public void intialisation_jTable() {
        jTable1.setModel(fh);
        fh.setList(df.ListerTou());
    }

    private void ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterActionPerformed
        // TODO add your handling code here:

        String date = dat.getText();
        //String idcontrat = (String) idc.getSelectedItem();
        String idcontrat = (String) tt.getSelectedItem();
        String idfac = idf.getText();
        String montf = mnf.getText();

        DAOFacture dof = new DAOFacture();
        Date date1 = null;
        Facture f = new Facture(idfac, idcontrat, date, montf);
        if (dat.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "S'il vous plait entrer la date .", "Erreur", JOptionPane.ERROR_MESSAGE);
            dat.requestFocus();
            return;
        }
        if (tt.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(this, "S'il vous plait Selectionez l'id contrat .", "Erreur", JOptionPane.ERROR_MESSAGE);
            tt.requestFocus();
            return;
        }
        if (idf.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "S'il vous plait entrer id facture .", "Erreur", JOptionPane.ERROR_MESSAGE);
            idf.requestFocus();
            return;
        }
        boolean e = vDate(dat.getText(), "Date De Facture !!");

        if (e == true) {
            try {
                boolean t = dof.ajouteFact(f);
                if (t = true) {
                    JOptionPane.showMessageDialog(null, "bien ajoutée");
                } else {
                    JOptionPane.showMessageDialog(null, "erreur n'a pas ajoutée ");

                }
            } catch (HeadlessException ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
        }

        intialisation_jTable();
    }//GEN-LAST:event_ajouterActionPerformed

    public boolean vDate(String d, String ms) {
        boolean e = false;
        String t[] = d.split("-");
        if (t.length == 3) {
            try {
                int i = Integer.parseInt(t[0]);
                if (1000 < i && i < 3000) {
                    try {
                        int p = Integer.parseInt(t[1]);
                        if (1 <= p && p <= 12) {

                            try {
                                int an = Integer.parseInt(t[0]);
                                int u = Integer.parseInt(t[2]);
                                int m = Integer.parseInt(t[1]);
                                boolean y = bissex(an);
                                if (y == false) {
                                    if (1 <= u && u <= mois[m - 1]) {
                                        e = true;
                                    } else {
                                        e = false;
                                        JOptionPane.showMessageDialog(this, " S'il vous plait verifier le jour  " + ms, ms, JOptionPane.ERROR_MESSAGE);
                                    }
                                } else if (1 <= u && u <= mois1[m - 1]) {
                                    e = true;
                                } else {
                                    e = false;
                                    JOptionPane.showMessageDialog(this, " S'il vous plait verifier le jour  " + ms, ms, JOptionPane.ERROR_MESSAGE);
                                }

                            } catch (Exception ex) {
                                e = false;
                                JOptionPane.showMessageDialog(this, " S'il vous plait verifier la formt du jour  " + ms, ms, JOptionPane.ERROR_MESSAGE);
                            }

                        } else {
                            e = false;
                            JOptionPane.showMessageDialog(this, " S'il vous plait verifier le Mois  " + ms, ms, JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, " S'il vous plait verifier la formt du Mois  " + ms, ms, JOptionPane.ERROR_MESSAGE);

                    }
                } else {
                    e = false;
                    JOptionPane.showMessageDialog(this, " S'il vous plait verifier la Annee " + ms, ms, JOptionPane.ERROR_MESSAGE);

                }
            } catch (Exception ex) {
                e = false;
                JOptionPane.showMessageDialog(this, " S'il vous plait verifier la Annee " + ms, ms, JOptionPane.ERROR_MESSAGE);
            }

        } else {
            e = false;
            JOptionPane.showMessageDialog(this, " S'il vous plait verifier la Forme Date (YYYY-MM-DD)  " + ms, ms, JOptionPane.ERROR_MESSAGE);

        }

        return e;
    }

    private void ttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ttActionPerformed


    }//GEN-LAST:event_ttActionPerformed

    private void idfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idfActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String date = dat.getText();
        String idcontrat = (String) tt.getSelectedItem();
        String idfac = idf.getText();
        String montf = mnf.getText();

        DAOFacture dof = new DAOFacture();
        Date date1 = null;
        Facture a = new Facture(idfac, idcontrat, date, montf);
        if (dat.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "S'il vous plait entrer la date .", "Erreur", JOptionPane.ERROR_MESSAGE);
            dat.requestFocus();
            return;
        }
        if (tt.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(this, "S'il vous plait Selectionez l'id contrat .", "Erreur", JOptionPane.ERROR_MESSAGE);
            tt.requestFocus();
            return;
        }
        if (idf.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "S'il vous plait entrer id facture .", "Erreur", JOptionPane.ERROR_MESSAGE);
            idf.requestFocus();
            return;
        }

        boolean e = vDate(dat.getText(), "Date De Facture !!");
        if (e == true) {
            try {
                boolean t = dof.modifierVh(add1, a);
                if (t = true) {
                    JOptionPane.showMessageDialog(null, "bien modifieé");
                } else {
                    JOptionPane.showMessageDialog(null, "erreur n'a pas modifieé");

                }
            } catch (HeadlessException ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
        }
        intialisation_jTable();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        String tc = jTable1.getModel().getValueAt(row, 0).toString();
        List<Facture> lister = null;
        lister = df.Listerp(tc);
        for (Facture f : lister) {
            add1 = f.getIdfact();
            idf.setText(add1);
            String add2 = f.getIdcont();
            tt.setSelectedItem(add2);
            String add3 = f.getDate();
            dat.setText(add3);
            String add4 = f.getMontafatct();
            mnf.setText(add4);
        }


        jButton3.setEnabled(true);
        jButton4.setEnabled(true);
        ajouter.setEnabled(false);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            int i = Integer.parseInt(jTextField1.getText());
            int p = Integer.parseInt(jTextField2.getText());

            if (i < 0 || i > 100 || p < 0 || p > 100) {
                JOptionPane.showMessageDialog(this, "Erreur Calcule .", "Erreur", JOptionPane.ERROR_MESSAGE);
                dat.requestFocus();
                return;
            }


            lc = dac.ListerDetail(tt.getSelectedItem().toString());
            for (Model.Contrat vd : lc) {
                mat = vd.getMatrVh();
                duree = vd.getDuree();
            }

            lv = vh.listerDetailMtr(mat);
            for (Model.Vehicule vd : lv) {
                prix = vd.getPrixJourVh();
            }

            taxes = prix * duree;
            jTextField3.setText(String.valueOf(taxes));
            remise = (i * taxes) / 100;
            HT = taxes - remise;
            jTextField4.setText(String.valueOf(HT));
            Tva = (p * HT) / 100;
            mt = HT + Tva;
            mnf.setText(String.valueOf(mt));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    public void Reset() {

        dat.setText("");
        idf.setText("");
        mnf.setText("");
        tt.setSelectedIndex(0);

        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        ajouter.setEnabled(true);

    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void mnfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnfActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String user = "root", pw = "", url = "jdbc:mysql://localhost:3306/ayoub";
        Connection con = null;


        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pw);
        } catch (ClassNotFoundException exp) {
            System.out.println(exp);
        } catch (SQLException sqlExp) {
            System.out.println(sqlExp);

        }

        try {

            Map<String, String> param = new HashMap<String, String>();
            param.put("idCont", idf.getText());
            param.put("Tva", jTextField2.getText());
            param.put("HT", jTextField4.getText());
            param.put("Re", jTextField1.getText());
            param.put("aur", jTextField3.getText());
            JasperReport reportes = JasperCompileManager.compileReport("report2.jrxml");
            JasperPrint print = JasperFillManager.fillReport(reportes, param, con);
            JasperViewer.viewReport(print, false);

        } catch (Exception e) {
            System.out.printf(e.getMessage());
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Reset();
    }//GEN-LAST:event_jButton5ActionPerformed
    // End of variables declaration//GEN-END:variables
}
