/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.DaoRevsion;
import Dao.DaoVehicule;
import Model.Revsion;
import helper.RevsionHelper;

import javax.swing.*;
import java.awt.*;
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
public class FormRevision extends javax.swing.JFrame {

    public String add1;
    public String add5;
    RevsionHelper hr = new RevsionHelper();
    Dao.DaoRevsion dr = new DaoRevsion();
    Dao.DaoVehicule vr = new DaoVehicule();
    int[] mois = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int[] mois1 = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private List<Revsion> rt = null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboChoix;
    private javax.swing.JButton Modfier;
    private javax.swing.JButton Rechercher;
    private javax.swing.JTextField datea;
    private javax.swing.JTextField dated;
    private javax.swing.JTextField datef;
    private javax.swing.JTextField datevi;
    private javax.swing.JTextField datevs;
    private javax.swing.JTextField id;
    private javax.swing.JTextField idrev1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField matr;
    private javax.swing.JTable rev;
    private javax.swing.JButton sup;

    /**
     * Creates new form FormRevision
     */
    public FormRevision() {
        initComponents();
        try {
            initialisation_jTable();
        } catch (SQLException ex) {
            Logger.getLogger(FormRevision.class.getName()).log(Level.SEVERE, null, ex);
        }
        dated.setEnabled(false);
        datef.setEnabled(false);
        id.setEnabled(false);
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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormRevision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormRevision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormRevision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormRevision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormRevision().setVisible(true);
            }
        });
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

    public Date inDate(String d) {
        Date x = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            x = format.parse(d);

        } catch (ParseException ex) {

        }
        return x;
    }

    public void modifier() {
        String i = idrev1.getText();
        String a = datea.getText();
        String vs = datevs.getText();
        String vi = datevi.getText();

        Revsion ret = new Revsion(i, inDate(a), inDate(vs), Integer.parseInt(vi));

        boolean g = dr.modifierRv(add1, ret);
        if (g == false) {
            JOptionPane.showMessageDialog(this, "vous n'avez pas modifiée enregistrement correctement", "Revision", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "vous  avez  modifiée enregistrement correctement", "Revision", JOptionPane.INFORMATION_MESSAGE);
            try {
                initialisation_jTable();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        ret = null;
    }

    public void count() {
        int o = hr.getRowCount();
        jTextField1.setText("" + o);
        if (o == 0) {
            JOptionPane.showMessageDialog(this, "aucun enregistrement trouvé .", "Model :(", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void initialisation_jTable() throws SQLException {
        rev.setModel(hr); // on bronche jTable avc l userHelper
        hr.setList(dr.listerTou()); // on rempli  la liste de l userHelper .. ( qui va etre afficher dans le jTable)
        count();
    }

    public void initialisation_jTableid(String f) throws SQLException {
        rev.setModel(hr); // on bronche jTable avc l userHelper
        hr.setList(dr.listerIdDe(f)); // on rempli  la liste de l userHelper .. ( qui va etre afficher dans le jTable)
        count();
    }

    public void initialisation_jTablemat(String f) throws SQLException {
        rev.setModel(hr); // on bronche jTable avc l userHelper
        hr.setList(dr.listerIDMatr(f)); // on rempli  la liste de l userHelper .. ( qui va etre afficher dans le jTable)
        count();
    }

    public void initialisation_jTablDatea(Date d1, Date d2) throws SQLException {
        rev.setModel(hr); // on bronche jTable avc l userHelper
        hr.setList(dr.RechercherAS(d1, d2)); // on rempli  la liste de l userHelper .. ( qui va etre afficher dans le jTable)
        count();
    }

    public void initialisation_jTablDatev(Date d1, Date d2) throws SQLException {
        rev.setModel(hr); // on bronche jTable avc l userHelper
        hr.setList(dr.RechercherVi(d1, d2)); // on rempli  la liste de l userHelper .. ( qui va etre afficher dans le jTable)
        count();
    }

    public void initialisation_jTablDatei() throws SQLException {
        rev.setModel(hr); // on bronche jTable avc l userHelper
        hr.setList(dr.RechercherVd()); // on rempli  la liste de l userHelper .. ( qui va etre afficher dans le jTable)
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
        rev = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        idrev1 = new javax.swing.JTextField();
        datea = new javax.swing.JTextField();
        datevs = new javax.swing.JTextField();
        datevi = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        matr = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        Modfier = new javax.swing.JButton();
        sup = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        dated = new javax.swing.JTextField();
        datef = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        ComboChoix = new javax.swing.JComboBox<>();
        Rechercher = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        rev.setBackground(new java.awt.Color(172, 220, 229));
        rev.setModel(new javax.swing.table.DefaultTableModel(
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
        rev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                revMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(rev);

        jPanel2.setBackground(new java.awt.Color(172, 220, 229));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        idrev1.setEnabled(false);

        jLabel1.setText("ID :");

        jLabel2.setText("Date Fin D'assurance            :");

        jLabel4.setText("Kmt vidange                          :");

        jLabel5.setText("Matrucle :");

        jLabel3.setText("Date Fin de visite technique :");

        matr.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel4)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(idrev1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel5)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(datea, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                                .addComponent(datevs)
                                                .addComponent(datevi))
                                        .addComponent(matr, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel1)
                                                .addComponent(idrev1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel5))
                                        .addComponent(matr, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addComponent(jLabel3))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(datevs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(datea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(datevi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        Modfier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/5.png"))); // NOI18N
        Modfier.setText("Modfier");
        Modfier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModfierActionPerformed(evt);
            }
        });

        sup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/3.png"))); // NOI18N
        sup.setText("Suprrimer");
        sup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/7.png"))); // NOI18N
        jButton1.setText("Lister");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(sup, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Modfier, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(Modfier)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sup)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        ComboChoix.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"", "ID", "Matricule", "Date Asurance", "Date Viste", "Vidange(-500)"}));
        ComboChoix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboChoixActionPerformed(evt);
            }
        });

        Rechercher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/6.png"))); // NOI18N
        Rechercher.setText("Rechercher");
        Rechercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RechercherActionPerformed(evt);
            }
        });

        jTextField1.setBackground(new java.awt.Color(204, 255, 204));
        jTextField1.setEnabled(false);

        jLabel6.setText("Date Debut");

        jLabel7.setText("Date  Fin");

        jLabel9.setText("(AAAA-MM-DD)");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ComboChoix, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(id, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(Rechercher, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                                .addComponent(jLabel7)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(datef, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                                .addComponent(jLabel6)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(dated, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                                .addComponent(jLabel9)
                                                                .addGap(22, 22, 22)))))
                                .addGap(24, 24, 24))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(ComboChoix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Rechercher)
                                        .addComponent(jLabel6)
                                        .addComponent(dated, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(datef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void revMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_revMouseClicked
        int row = rev.getSelectedRow();
        String table_click = rev.getModel().getValueAt(row, 0).toString();
        List<Revsion> Lister = null;

        Lister = dr.listerIdDe(table_click);

        for (Revsion l : Lister) {
            add1 = l.getIdRev();
            idrev1.setText(add1);
            String add2 = l.getDateFinas().toString();
            datea.setText(add2);
            String add3 = l.getDateVist().toString();
            datevs.setText(add3);

            datevi.setText(String.valueOf(l.getVid()));
            add5 = l.getV().getMatrVh();
            matr.setText(add5);
        }
    }//GEN-LAST:event_revMouseClicked

    private void supActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supActionPerformed
        try {
            int P = JOptionPane.showConfirmDialog(null, " Are you sure want to delete ?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (P == 0) {
                Boolean b = dr.supprimerRv(add1);
                if (b == true) {
                    JOptionPane.showMessageDialog(this, "vous avez supprimé enregistrement correctement");
                    hr.remove(rev.getSelectedRow());
                } else {
                    JOptionPane.showMessageDialog(this, "vous n'avez pas supprimé enregistrement correctement");
                }

            }
        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_supActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            initialisation_jTable();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ModfierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModfierActionPerformed

        boolean e1 = vDate(datea.getText(), "Date d'Asuuranse !!");
        boolean e3 = vDate(datevs.getText(), "Date Viste T !!");
        if (e1 == true && e3 == true) {
            modifier();
        }
    }//GEN-LAST:event_ModfierActionPerformed

    private void ComboChoixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboChoixActionPerformed
        if (ComboChoix.getSelectedIndex() == 0) {
            dated.setEnabled(false);
            datef.setEnabled(false);
            id.setEnabled(false);
        }
        if (ComboChoix.getSelectedIndex() == 1) {
            dated.setEnabled(false);
            datef.setEnabled(false);
            id.setEnabled(true);

        }
        if (ComboChoix.getSelectedIndex() == 2) {
            dated.setEnabled(false);
            datef.setEnabled(false);
            id.setEnabled(true);
        }
        if (ComboChoix.getSelectedIndex() == 3) {
            dated.setEnabled(true);
            datef.setEnabled(true);
            id.setEnabled(false);
        }
        if (ComboChoix.getSelectedIndex() == 4) {
            dated.setEnabled(true);
            datef.setEnabled(true);
            id.setEnabled(false);
        }
        if (ComboChoix.getSelectedIndex() == 5) {
            dated.setEnabled(false);
            datef.setEnabled(false);
            id.setEnabled(false);
        }
    }//GEN-LAST:event_ComboChoixActionPerformed

    private void RechercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RechercherActionPerformed
        if (ComboChoix.getSelectedIndex() == 1) {
            try {
                initialisation_jTableid(id.getText());
            } catch (SQLException ex) {
                Logger.getLogger(FormRevision.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (ComboChoix.getSelectedIndex() == 2) {
            try {
                initialisation_jTablemat(id.getText());
            } catch (SQLException ex) {
                Logger.getLogger(FormRevision.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (ComboChoix.getSelectedIndex() == 3) {
            try {
                initialisation_jTablDatea(inDate(dated.getText()), inDate(datef.getText()));
            } catch (SQLException ex) {
                Logger.getLogger(FormRevision.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (ComboChoix.getSelectedIndex() == 4) {
            try {
                initialisation_jTablDatev(inDate(dated.getText()), inDate(datef.getText()));
            } catch (SQLException ex) {
                Logger.getLogger(FormRevision.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (ComboChoix.getSelectedIndex() == 5) {
            try {
                initialisation_jTablDatei();
            } catch (SQLException ex) {
                Logger.getLogger(FormRevision.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_RechercherActionPerformed
    // End of variables declaration//GEN-END:variables
}
