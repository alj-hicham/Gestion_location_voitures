/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewUser;

import Dao.DaoVehicule;
import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Lenovo
 */
public class FormVehiculeUser extends javax.swing.JFrame {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> Comboboite;
    public javax.swing.JComboBox<String> Combocategorie;
    public javax.swing.JComboBox<String> Comboclim;
    public javax.swing.JComboBox<String> Combomarque;
    public javax.swing.JComboBox<String> Combomodel;
    public javax.swing.JComboBox<String> Combost;
    public javax.swing.JButton Lister;
    public javax.swing.JTextField MtrVH;
    public javax.swing.JLabel cle;
    public javax.swing.JTextField dateachat;
    public javax.swing.JTextField datefinas;
    public javax.swing.JTextField datefinvi;
    public javax.swing.JTextField datefinvite;
    public javax.swing.JTextField idrev;
    public javax.swing.JLabel img;
    public javax.swing.JButton jButton4;
    public javax.swing.JTextField jTextField8;
    public javax.swing.JTextField kms;
    public javax.swing.JSpinner nombrepass;
    public javax.swing.JSpinner nombrp;
    public javax.swing.JTextField prixachat;
    public javax.swing.JTextField prixjour;
    /**
     * Creates new form FormVehicule
     */
    Dao.DaoModel mod = new Dao.DaoModel();
    Dao.DaoCategorie cat = new Dao.DaoCategorie();
    Dao.DaoMarque mar = new Dao.DaoMarque();
    Dao.DaoVehicule v = new DaoVehicule();
    Dao.DaoRevsion re = new Dao.DaoRevsion();
    List<Model> li = null;
    List<Categorie> lc = null;
    List<Marque> lim = null;
    List<Vehicule> liv = null;
    int[] mois = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int[] mois1 = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private javax.swing.JButton Nov;
    private javax.swing.JButton image;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;

    public FormVehiculeUser() {
        initComponents();
        chargerMarque();
        chargerCat();
        try {
            inCode();
        } catch (Exception ex) {
            System.out.println("errreer");
        }
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormVehiculeUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormVehiculeUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormVehiculeUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormVehiculeUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormVehiculeUser().setVisible(true);
            }
        });
    }

    public void Reset() {
        datefinvi.setEnabled(true);
        datefinvite.setEnabled(true);
        MtrVH.setText("");
        cle.setText("");
        dateachat.setText("");

        prixachat.setText("");
        Comboboite.setSelectedIndex(0);
        Combocategorie.setSelectedIndex(0);
        Comboclim.setSelectedIndex(0);
        Combomarque.setSelectedIndex(0);
        Combost.setSelectedIndex(0);

        kms.setText("");
        prixjour.setText("");
        nombrepass.setValue(0);
        nombrp.setValue(0);
        jTextField8.setText("");
        datefinas.setText("");
        datefinvi.setText("");
        datefinvite.setText("");

        jButton4.setEnabled(true);
        datefinas.setEnabled(true);
        idrev.setEnabled(false);
    }

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

    public void inCode() throws SQLException {
        int j;

        String num = "";
        String c = "";
        c = re.dernier();
        if (c == null) {
            idrev.setText("rev000001");
        } else {
            char r1 = c.charAt(3);
            char r2 = c.charAt(4);
            char r3 = c.charAt(5);
            char r4 = c.charAt(6);
            char r5 = c.charAt(7);
            char r6 = c.charAt(8);
            String r = "";
            r = "" + r1 + r2 + r3 + r4 + r5 + r6;
            j = Integer.parseInt(r) + 1;
            GenerVh gen = new GenerVh();
            gen.generar(j);
            idrev.setText("rev" + gen.serie());

        }

    }

    public void chargerModel(String n) {
        try {
            li = mod.ListerModeMarque(n);
        } catch (SQLException ex) {
            Logger.getLogger(FormVehiculeUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        Combomodel.removeAllItems();
        for (Model o : li) {

            Combomodel.addItem(o.getNomModel());
        }

    }

    public void chargerCat() {

        lc = cat.lister();
        for (Categorie o : lc) {
            // Combocategorie.removeAllItems();
            Combocategorie.addItem(o.getNomCat());
        }


    }

    public void chargerMarque() {
        try {
            lim = mar.ListerMarque();
        } catch (SQLException ex) {
            Logger.getLogger(FormVehiculeUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Marque o : lim) {
            Combomarque.addItem(o.getNimMarque());
        }

    }

    public void ajouter() {
        Vehicule v1 = null;
        try {
            lim = mar.ListerMarqueNom(Combomarque.getSelectedItem().toString());
        } catch (SQLException ex) {
            Logger.getLogger(FormVehiculeUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            li = mod.ListerModelNom(Combomodel.getSelectedItem().toString());
        } catch (SQLException ex) {
            Logger.getLogger(FormVehiculeUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        lc = cat.ListerNomCat(Combocategorie.getSelectedItem().toString());

        v1 = new Vehicule();
        v1.setMatrVh(MtrVH.getText());
        v1.setAc(Comboclim.getSelectedItem().toString());
        v1.setBoitevitesse(Comboboite.getSelectedItem().toString());
        v1.setDateAchat(inDate(dateachat.getText()));
        for (Categorie marque : lc) {
            v1.setIdCat(marque.getIdCat());
        }

        v1.setImagVh(jTextField8.getText());
        v1.setKms(Integer.parseInt(kms.getText()));
        v1.setIdRev(idrev.getText());
        for (Marque marque : lim) {
            v1.setMarquVh(marque.getIdMarque());
        }

        Model mod1 = null;
        for (Model i : li) {
            v1.setModVh(i.getIdModel());
        }

        v1.setNbPasssager(Integer.parseInt(nombrepass.getValue().toString()));
        v1.setNbPort(Integer.parseInt(nombrp.getValue().toString()));
        try {
            v1.setPrixAchat(Double.parseDouble(prixachat.getText()));

            v1.setPrixJourVh(Double.parseDouble(prixjour.getText()));

            if (Combost.getSelectedItem().equals("oui")) {
                v1.setStatutVh(true);
            } else if (Combost.getSelectedItem().equals("non")) {
                v1.setStatutVh(false);
            }
            Revsion r = new Revsion();
            r.setIdRev(idrev.getText());
            r.setDateFinas(inDate(datefinas.getText()));
            r.setVid(Integer.parseInt(datefinvite.getText()));
            r.setDateVist(inDate(datefinvi.getText()));
            boolean a = re.ajouterRev(r);
            if (a == true) {
                Boolean b = v.ajouterVh(v1);
                if (b == false) {
                    JOptionPane.showMessageDialog(this, "vous n'avez pas ajouté enregistrement correctement", "Voiture", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "vous avez ajouté enregistrement correctement", "Voiture", JOptionPane.INFORMATION_MESSAGE);
                }
                JOptionPane.showMessageDialog(this, "vous avez ajouté enregistrement correctement", "revition", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "vous n'avez pas ajouté enregistrement correctement", "revition", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "  " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        Reset();
    }

    public Date inDate(String d) {
        Date x = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            x = format.parse(d);

        } catch (ParseException ex) {

        }
        return x;
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
        jTable1 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        dateachat = new javax.swing.JTextField();
        prixachat = new javax.swing.JTextField();
        kms = new javax.swing.JTextField();
        Combomarque = new javax.swing.JComboBox<>();
        MtrVH = new javax.swing.JTextField();
        Combomodel = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Combocategorie = new javax.swing.JComboBox<>();
        Comboclim = new javax.swing.JComboBox<>();
        Combost = new javax.swing.JComboBox<>();
        prixjour = new javax.swing.JTextField();
        Comboboite = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        nombrp = new javax.swing.JSpinner();
        nombrepass = new javax.swing.JSpinner();
        jLabel16 = new javax.swing.JLabel();
        idrev = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        datefinvi = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        datefinas = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        datefinvite = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        image = new javax.swing.JButton();
        img = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Lister = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        cle = new javax.swing.JLabel();
        Nov = new javax.swing.JButton();

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
        jScrollPane1.setViewportView(jTable1);

        jPanel6.setBackground(new java.awt.Color(172, 220, 229));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 102), 1, true));

        jLabel2.setText("Matriculation          :");

        jLabel4.setText("Date D'Achat          :");

        jLabel3.setText("Prix D'Achat            :");

        jLabel5.setText("Kilométrage             :");

        jLabel21.setText("Model De Voiture    :");

        jLabel6.setText("Marque De voiture :");

        dateachat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateachatActionPerformed(evt);
            }
        });

        prixachat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prixachatActionPerformed(evt);
            }
        });

        kms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kmsActionPerformed(evt);
            }
        });
        kms.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                kmsKeyTyped(evt);
            }
        });

        Combomarque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CombomarqueActionPerformed(evt);
            }
        });

        Combomodel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CombomodelActionPerformed(evt);
            }
        });

        jLabel22.setText("(yyyy-MM-dd)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel2)
                                                                        .addComponent(jLabel4)
                                                                        .addComponent(jLabel3))
                                                                .addGap(27, 27, 27)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(prixachat, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(MtrVH, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(dateachat, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(jLabel22))))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel21)
                                                                .addGap(30, 30, 30)
                                                                .addComponent(Combomodel, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel5))
                                                .addGap(31, 31, 31)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(kms, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(Combomarque, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(MtrVH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(dateachat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel22))
                                .addGap(13, 13, 13)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(prixachat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(kms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Combomarque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Combomodel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel21))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102)));
        jPanel3.setForeground(new java.awt.Color(255, 102, 102));

        jLabel14.setText("Climatisation              :");

        jLabel12.setText("Catégorie de voiture :");

        jLabel15.setText("Disponibilité de Voiture :");

        jLabel11.setText("Prix de Jour :");

        jLabel10.setText("Type De Boite Vitesse :");

        Comboclim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Airco manuel", "Airco semi-automatique", "Airco automatique", "non disponible"}));
        Comboclim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboclimActionPerformed(evt);
            }
        });

        Combost.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"oui", "non"}));
        Combost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CombostActionPerformed(evt);
            }
        });

        prixjour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prixjourActionPerformed(evt);
            }
        });

        Comboboite.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"", "mécanique", "automatique", "mécanique robotisée"}));
        Comboboite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboboiteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel10)
                                                        .addComponent(jLabel11))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(prixjour, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(Comboboite, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel12)
                                                                        .addComponent(jLabel14))
                                                                .addGap(27, 27, 27))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                                .addComponent(jLabel15)
                                                                .addGap(18, 18, 18)))
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(Combocategorie, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(Comboclim, 0, 141, Short.MAX_VALUE)
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addGap(3, 3, 3)
                                                                .addComponent(Combost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel12)
                                                        .addComponent(Combocategorie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel14))
                                        .addComponent(Comboclim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel15)
                                        .addComponent(Combost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(prixjour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel10)
                                        .addComponent(Comboboite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102)));

        jLabel8.setText("Nombre des Portes:");

        jLabel9.setText("Nombre des passager :");

        jLabel16.setText("Id Rvesion :");

        idrev.setEnabled(false);
        idrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idrevActionPerformed(evt);
            }
        });

        jLabel18.setText("Date Fin du Viste :");

        datefinvi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datefinviActionPerformed(evt);
            }
        });

        jLabel17.setText("Date Fin D'Assurance :");

        datefinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datefinasActionPerformed(evt);
            }
        });

        jLabel19.setText("KMT fin vitange          :");

        datefinvite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datefinviteActionPerformed(evt);
            }
        });
        datefinvite.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                datefinviteKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(datefinvi, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel8)
                                                                .addComponent(jLabel9)
                                                                .addComponent(jLabel16)
                                                                .addComponent(jLabel18)
                                                                .addComponent(jLabel17))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(datefinvite, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(datefinas, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(idrev, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(nombrepass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(nombrp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addComponent(jLabel19))
                                .addGap(92, 92, 92))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nombrp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(nombrepass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel16)
                                        .addComponent(idrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel18)
                                        .addComponent(datefinvi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel17)
                                        .addComponent(datefinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(datefinvite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102)));

        jLabel13.setText("Image de Voiture :");

        jTextField8.setEnabled(false);
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        image.setText("image");
        image.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageActionPerformed(evt);
            }
        });

        img.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField8, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(image)
                                .addGap(6, 6, 6))
                        .addComponent(img, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel13)
                                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(image))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102)));

        Lister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/7.png"))); // NOI18N
        Lister.setText("       Lister");
        Lister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListerActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/2.png"))); // NOI18N
        jButton4.setText("   Ajouter");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        Nov.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/4.png"))); // NOI18N
        Nov.setText("  Nouveau");
        Nov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NovActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cle)
                                .addGap(46, 46, 46))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(Lister, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Nov, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jButton4)
                                .addGap(18, 18, 18)
                                .addComponent(Lister)
                                .addGap(18, 18, 18)
                                .addComponent(Nov)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cle)
                                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void prixachatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prixachatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prixachatActionPerformed

    private void prixjourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prixjourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prixjourActionPerformed

    private void ComboclimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboclimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboclimActionPerformed

    private void CombostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CombostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CombostActionPerformed

    private void ComboboiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboboiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboboiteActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void dateachatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateachatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateachatActionPerformed

    private void CombomarqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CombomarqueActionPerformed
        chargerModel(Combomarque.getSelectedItem().toString());
    }//GEN-LAST:event_CombomarqueActionPerformed

    private void ListerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListerActionPerformed

        ViewListVehiculeUser li = new ViewListVehiculeUser();
        li.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ListerActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        if (MtrVH.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "S'il vous plait entrer Matricule .", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (Combomarque.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(this, "S'il vous plait sélectionner Maarque  .", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (idrev.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "S'il vous plait entrer ID revistion", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (Combocategorie.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(this, "S'il vous plait sélectionner categorie .", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (Combomodel.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(this, "S'il vous plait sélectionner  Model .", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (prixjour.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "S'il vous plait entrer Prix jour (dh) .", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (prixachat.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "S'il vous plait entrer Prix achat .", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        boolean e = vDate(dateachat.getText(), "Date D'Achat !!");
        boolean e1 = vDate(datefinas.getText(), "Date d'Asuuranse !!");
        boolean e3 = vDate(datefinvi.getText(), "Date Viste T !!");
        if (e == true && e1 == true && e3 == true) {
            ajouter();
        }


    }//GEN-LAST:event_jButton4ActionPerformed

    private void idrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idrevActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idrevActionPerformed

    private void datefinviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datefinviActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_datefinviActionPerformed

    private void datefinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datefinasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_datefinasActionPerformed

    private void datefinviteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datefinviteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_datefinviteActionPerformed

    private void imageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageActionPerformed
        try {

            JFileChooser chose = new JFileChooser();
            chose.showOpenDialog(null);
            File f = chose.getSelectedFile();

            String path = f.getAbsolutePath();
            jTextField8.setText(path);

            ImageIcon icone = new ImageIcon(path);
            Image ima;
            ima = icone.getImage().getScaledInstance(333, 200, Image.SCALE_DEFAULT);
            ImageIcon icone1 = new ImageIcon(ima);

            img.setIcon(icone1);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_imageActionPerformed

    private void NovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NovActionPerformed


        jButton4.setEnabled(true);
        datefinas.setEnabled(true);
        idrev.setEnabled(false);
        try {
            inCode();
        } catch (SQLException ex) {
            Logger.getLogger(FormVehiculeUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        datefinvi.setEnabled(true);
        datefinvite.setEnabled(true);
        MtrVH.setText("");
        cle.setText("");
        dateachat.setText("");

        prixachat.setText("");
        Comboboite.setSelectedIndex(0);
        Combocategorie.setSelectedIndex(0);
        Comboclim.setSelectedIndex(0);
        Combomarque.setSelectedIndex(0);
        Combost.setSelectedIndex(0);

        kms.setText("");
        prixjour.setText("");
        nombrepass.setValue(0);
        nombrp.setValue(0);
        jTextField8.setText("");
        datefinas.setText("");
        datefinvi.setText("");
        datefinvite.setText("");

        // ImageIcon icone = new ImageIcon("default");
        // img.setIcon(icone);

    }//GEN-LAST:event_NovActionPerformed

    private void kmsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kmsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kmsActionPerformed

    private void kmsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kmsKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_kmsKeyTyped

    private void datefinviteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_datefinviteKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_datefinviteKeyTyped

    private void CombomodelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CombomodelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CombomodelActionPerformed
    // End of variables declaration//GEN-END:variables
}
