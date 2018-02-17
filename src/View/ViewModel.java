/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.GenerModel;
import Model.Marque;
import Model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Lenovo
 */
public class ViewModel extends javax.swing.JFrame {

    public String add1 = null;
    public javax.swing.JComboBox<String> ComboMarque;
    Dao.DaoModel m = new Dao.DaoModel();
    Dao.DaoMarque mar = new Dao.DaoMarque();
    helper.ModelHelper n = new helper.ModelHelper();
    List<Marque> lii = null;
    List<Marque> lmar = null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboChoix;
    private javax.swing.JTable Model;
    private javax.swing.JButton Modifier;
    private javax.swing.JTextField Recherche;
    private javax.swing.JButton ajouter;
    private javax.swing.JButton ajouterMarque;
    private javax.swing.JTextField annee;
    private javax.swing.JTextField idmodel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton lister;
    private javax.swing.JTextField nomModel;
    private javax.swing.JButton nouv;
    private javax.swing.JButton rechercher;
    private javax.swing.JButton sup;

    /**
     * Creates new form ViewModel
     */
    public ViewModel() {

        initComponents();
        try {
            initialisation_jTable();
        } catch (SQLException ex) {
            Logger.getLogger(ViewModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            chargercombo();
        } catch (SQLException ex) {
            Logger.getLogger(ViewModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            inCode();
        } catch (SQLException ex) {
            Logger.getLogger(ViewModel.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(ViewModel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewModel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewModel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewModel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new ViewModel().setVisible(true);
            }
        });
    }

    private void Reset() {
        idmodel.setText("");
        nomModel.setText("");
        annee.setText("");
        ComboMarque.setSelectedIndex(0);
        ajouter.setEnabled(true);
        Modifier.setEnabled(false);
        sup.setEnabled(false);

    }

    public void inCode() throws SQLException {
        int j;
        int cont = 1;
        String num = "";
        String c = "";
        c = m.dernier();
        if (c == null) {
            idmodel.setText("mod00001");
        } else {

            char r1 = c.charAt(3);
            char r2 = c.charAt(4);
            char r3 = c.charAt(5);
            char r4 = c.charAt(6);
            char r5 = c.charAt(7);
            String r = "";
            r = "" + r1 + r2 + r3 + r4 + r5;
            j = Integer.parseInt(r) + cont;
            GenerModel mo = new GenerModel();
            mo.generar(j);
            idmodel.setText("mod" + mo.serie());

        }

    }

    public void initialisation_jTable() throws SQLException {
        Model.setModel(n);
        n.setList(m.ListerModel());

        count();


    }

    public void count() {
        int o = n.getRowCount();
        jTextField1.setText("" + o);
        if (o == 0) {
            JOptionPane.showMessageDialog(this, "aucun enregistrement trouvé .", "Model :(", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void initialisation_jTable(String re) throws SQLException {
        Model.setModel(n);
        n.setList(m.ListerModel(re));

        count();
    }

    public void initialisation_jTable1(String re) throws SQLException {
        Model.setModel(n);
        n.setList(m.ListerModelNom(re));
        count();
    }

    public void initialisation_jTable2(String re) throws SQLException {
        Model.setModel(n);
        n.setList(m.ListerModeMarque(re));
        count();
    }

    public void ajouter() {
        String i = idmodel.getText();
        String n1 = nomModel.getText();
        String an = annee.getText();
        String nj = (String) ComboMarque.getSelectedItem();

        try {
            lii = mar.ListerMarqueNom(nj);
        } catch (SQLException ex) {
            Logger.getLogger(ViewModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        Marque mop = null;
        for (Marque marque : lii) {
            mop = new Marque(marque.getIdMarque(), marque.getNimMarque());
        }
        Model mp = new Model(i, mop.getIdMarque(), n1, an);

        boolean a = m.ajouterModel(mp);
        if (a == false) {
            JOptionPane.showMessageDialog(this, "vous n'avez pas ajoutée enregistrement correctement", "Model", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "vous avez ajoutée enregistrement correctement", "Model", JOptionPane.INFORMATION_MESSAGE);
            mp.setM(mop);
            n.save(mp);
        }
        mop = null;
    }

    public void modifier() {
        String i = idmodel.getText();
        String n1 = nomModel.getText();
        String an = annee.getText();
        String nj = (String) ComboMarque.getSelectedItem();

        try {
            lii = mar.ListerMarqueNom(nj);
        } catch (SQLException ex) {
            Logger.getLogger(ViewModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        Marque mop = null;
        for (Marque marque : lii) {
            mop = new Marque(marque.getIdMarque(), marque.getNimMarque());
        }
        Model mp = new Model(i, mop.getIdMarque(), n1, an);
        boolean a = m.ModModel(add1, mp);
        if (a == false) {
            JOptionPane.showMessageDialog(this, "vous n'avez pas modifiée enregistrement correctement", "Model", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "vous avez  modifiée enregistrement correctement", "Model", JOptionPane.INFORMATION_MESSAGE);
            mp.setM(mop);
            n.update(mp, Model.getSelectedRow());

        }
        mop = null;
    }

    public void chargercombo() throws SQLException {
        lmar = mar.ListerMarque();
        for (Marque l : lmar) {
            ComboMarque.addItem(l.getNimMarque());
        }

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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        idmodel = new javax.swing.JTextField();
        nomModel = new javax.swing.JTextField();
        annee = new javax.swing.JTextField();
        ComboMarque = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ajouterMarque = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        ComboChoix = new javax.swing.JComboBox<>();
        Recherche = new javax.swing.JTextField();
        lister = new javax.swing.JButton();
        rechercher = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        ajouter = new javax.swing.JButton();
        Modifier = new javax.swing.JButton();
        nouv = new javax.swing.JButton();
        sup = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Model = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(102, 175, 121));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Id Model     :");

        jLabel2.setText("Nom Model :");

        jLabel3.setText("marque       :");

        jLabel4.setText("Annee         :");

        idmodel.setEnabled(false);

        nomModel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomModelActionPerformed(evt);
            }
        });

        annee.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                anneeCaretUpdate(evt);
            }
        });
        annee.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                anneeHierarchyChanged(evt);
            }
        });
        annee.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }

            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                anneeInputMethodTextChanged(evt);
            }
        });
        annee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anneeActionPerformed(evt);
            }
        });
        annee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                anneeKeyTyped(evt);
            }
        });

        ComboMarque.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{" "}));
        ComboMarque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboMarqueActionPerformed(evt);
            }
        });

        jLabel5.setText("(AAAA)");

        jLabel6.setText("(mo+++)");

        ajouterMarque.setText("+");
        ajouterMarque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterMarqueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(18, 18, 18)
                                                .addComponent(annee, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(6, 6, 6)
                                                .addComponent(jLabel5)
                                                .addContainerGap())
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(18, 18, 18)
                                                .addComponent(ComboMarque, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(52, 52, 52)
                                                .addComponent(ajouterMarque)
                                                .addContainerGap())
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel1))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(idmodel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel6)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(nomModel)
                                                                .addContainerGap())))))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(idmodel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6))
                                .addGap(14, 14, 14)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(nomModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(ComboMarque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ajouterMarque))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(annee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(102, 175, 121));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        ComboChoix.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Id Model", "Nom Model", "Nom Marque"}));
        ComboChoix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboChoixActionPerformed(evt);
            }
        });

        lister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/7.png"))); // NOI18N
        lister.setText("        Lister");
        lister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listerActionPerformed(evt);
            }
        });

        rechercher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/6.png"))); // NOI18N
        rechercher.setText("Rechercher");
        rechercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechercherActionPerformed(evt);
            }
        });

        jTextField1.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(Recherche, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(ComboChoix, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(rechercher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Recherche, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ComboChoix, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addContainerGap(15, Short.MAX_VALUE)
                                .addComponent(rechercher)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lister)
                                .addGap(13, 13, 13))
        );

        jPanel3.setBackground(new java.awt.Color(102, 175, 121));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        ajouter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/2.png"))); // NOI18N
        ajouter.setText("Ajouter");
        ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterActionPerformed(evt);
            }
        });

        Modifier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/5.png"))); // NOI18N
        Modifier.setText("Modifer");
        Modifier.setEnabled(false);
        Modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifierActionPerformed(evt);
            }
        });

        nouv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/4.png"))); // NOI18N
        nouv.setText("Nouveau");
        nouv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nouvActionPerformed(evt);
            }
        });

        sup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/3.png"))); // NOI18N
        sup.setText("Suprrimer");
        sup.setEnabled(false);
        sup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(Modifier, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                        .addComponent(ajouter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(sup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(nouv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ajouter)
                                        .addComponent(nouv))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(Modifier)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(sup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        Model.setBackground(new java.awt.Color(228, 235, 145));
        Model.setModel(new javax.swing.table.DefaultTableModel(
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
        Model.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ModelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Model);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/11.JPG"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(1, 1, 1)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterActionPerformed
        if (idmodel.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "S'il vous plait entrer ID Model .", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (nomModel.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "S'il vous plait entrer Nom Model .", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (ComboMarque.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "S'il vous plait Donnez Marque  .", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {

            ajouter();

            Reset();
        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_ajouterActionPerformed

    private void nouvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nouvActionPerformed
        Reset();
        try {
            inCode();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_nouvActionPerformed

    private void nomModelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomModelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomModelActionPerformed

    private void ComboMarqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboMarqueActionPerformed
        // Tchargercombo()ODO add your handling code here:
    }//GEN-LAST:event_ComboMarqueActionPerformed

    private void ModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifierActionPerformed

        try {

            modifier();

            try {
                initialisation_jTable();
            } catch (SQLException ex) {
                Logger.getLogger(ViewMarque.class.getName()).log(Level.SEVERE, null, ex);
            }

            Reset();
        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_ModifierActionPerformed

    private void ModelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ModelMouseClicked

        int row = Model.getSelectedRow();
        String table_click = Model.getModel().getValueAt(row, 0).toString();
        List<Model> ListerModel = null;
        try {
            ListerModel = m.ListerModel(table_click);
        } catch (SQLException ex) {
            Logger.getLogger(ViewMarque.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Model l : ListerModel) {
            add1 = l.getIdModel();
            idmodel.setText(add1);
            String add2 = l.getNomModel();
            nomModel.setText(add2);
            String add3 = l.getAnnee();
            annee.setText(add3);
            ComboMarque.setSelectedItem(l.getM().getNimMarque());
        }
        Modifier.setEnabled(true);
        sup.setEnabled(true);
        ajouter.setEnabled(false);
    }//GEN-LAST:event_ModelMouseClicked

    private void supActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supActionPerformed
        try {
            int P = JOptionPane.showConfirmDialog(null, " Voulez vous vraiment supprimer ce model?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (P == 0) {
                boolean c = m.supModel(add1);
                if (c == true) {
                    JOptionPane.showMessageDialog(this, "vous avez supprimé enregistrement correctement");
                    n.remove(Model.getSelectedRow());
                    Reset();
                } else {
                    JOptionPane.showMessageDialog(this, "vous n'avez pas supprimé enregistrement correctement");

                }
            }
        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }

    }//GEN-LAST:event_supActionPerformed

    private void rechercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechercherActionPerformed

        if (ComboChoix.getSelectedIndex() == 0) {
            try {
                initialisation_jTable(Recherche.getText());
            } catch (SQLException ex) {
                Logger.getLogger(ViewMarque.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (ComboChoix.getSelectedIndex() == 1) {
            try {
                initialisation_jTable1(Recherche.getText());
            } catch (SQLException ex) {
                Logger.getLogger(ViewMarque.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                initialisation_jTable2(Recherche.getText());
            } catch (SQLException ex) {
                Logger.getLogger(ViewMarque.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_rechercherActionPerformed

    private void listerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listerActionPerformed
        try {
            initialisation_jTable();
        } catch (SQLException ex) {
            Logger.getLogger(ViewModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_listerActionPerformed

    private void ComboChoixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboChoixActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboChoixActionPerformed

    private void ajouterMarqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterMarqueActionPerformed
        ViewModel.this.setVisible(false);
        MarqueVa mv = new MarqueVa();
        mv.setVisible(true);
    }//GEN-LAST:event_ajouterMarqueActionPerformed

    private void anneeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anneeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_anneeActionPerformed

    private void anneeInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_anneeInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_anneeInputMethodTextChanged

    private void anneeHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_anneeHierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_anneeHierarchyChanged

    private void anneeCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_anneeCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_anneeCaretUpdate

    private void anneeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anneeKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            getToolkit().beep();
            evt.consume();
        }


// TODO add your handling code here:
    }//GEN-LAST:event_anneeKeyTyped
    // End of variables declaration//GEN-END:variables
}
