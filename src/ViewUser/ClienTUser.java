/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewUser;

import Dao.ClientDao;
import Dao.PermitDao;
import Model.Client;
import Model.Permit;
import View.AddP;
import helper.ClientHelper;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Amine Smaki
 */
public class ClienTUser extends javax.swing.JFrame {

    public String add1 = null;
    ClientDao cd = new ClientDao();
    PermitDao pd = new PermitDao();
    ClientHelper ch = new ClientHelper();
    List<Permit> lp = null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Combochoix;
    private javax.swing.JButton jButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    // List<Client> lc=null;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField rech;
    private javax.swing.JButton save;
    private javax.swing.JTextField txtadresse;
    private javax.swing.JTextField txtcin;
    private com.toedter.calendar.JDateChooser txtdate;
    private javax.swing.JTextField txtnom;
    private javax.swing.JTextField txtprenom;
    private javax.swing.JTextField txttele;
    private javax.swing.JTextField txttelee;
    private javax.swing.JTextField txtville;

    /**
     * Creates new form Client
     */
    public ClienTUser() {
        initComponents();

        try {
            chargercombo();
            Reset();
            initialisation_jTable();

        } catch (SQLException ex) {

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClienTUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienTUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienTUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienTUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienTUser().setVisible(true);
            }
        });
    }

    private void Reset() {
        txtcin.setText("");
        jComboBox2.setSelectedIndex(0);
        txtnom.setText("");
        txtprenom.setText("");
        //txtdatee.setText("");
        JTextField txt = ((JTextField) txtdate.getDateEditor().getUiComponent());
        txt.setText("");
        txtville.setText("");
        txtadresse.setText("");
        txttelee.setText("");
        txttele.setText("");
        save.setEnabled(true);

        jButton3.setEnabled(false);
    }

    public void modifier() {
        String i = txtcin.getText();
        String n1 = jComboBox2.getSelectedItem().toString();
        String n2 = txtnom.getText();
        String n3 = txtprenom.getText();
        //String n4= txtdatee.getText();
        JTextField txt = ((JTextField) txtdate.getDateEditor().getUiComponent());
        String n4 = txt.getText();
        String n5 = txtville.getText();
        String n6 = txtadresse.getText();
        String n7 = txttelee.getText();
        String n8 = txttele.getText();

        Model.Client ec = new Model.Client(i, n1, n2, n3, n4, n5, n6, n7, n8);
        if (txtcin.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "S'il vous plait entrer CIN .", "Erreur", JOptionPane.ERROR_MESSAGE);
            txtcin.requestFocus();
            return;
        }
        if (jComboBox2.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(this, "S'il vous plait Selectionez le  numero  permit .", "Erreur", JOptionPane.ERROR_MESSAGE);
            jComboBox2.requestFocus();
            return;
        }
        if (txtnom.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "S'il vous plait entrer le nom .", "Erreur", JOptionPane.ERROR_MESSAGE);
            txtnom.requestFocus();
            return;
        }
        if (txtprenom.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "S'il vous plait entrer prenom .", "Erreur", JOptionPane.ERROR_MESSAGE);
            txtprenom.requestFocus();
            return;
        }

        if (txt.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "S'il vous plait entrer la date naissance .", "Erreur", JOptionPane.ERROR_MESSAGE);
            txt.requestFocus();
            return;
        }
        if (txtville.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "S'il vous plait entrer la ville .", "Erreur", JOptionPane.ERROR_MESSAGE);
            txtville.requestFocus();
            return;
        }
        if (txtadresse.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "S'il vous plait entrer l'adresse .", "Erreur", JOptionPane.ERROR_MESSAGE);
            txtadresse.requestFocus();
            return;
        }
        if (txttelee.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "S'il vous plait entrer numero de telephone 1 .", "Erreur", JOptionPane.ERROR_MESSAGE);
            txttelee.requestFocus();
            return;
        }
        try {
            boolean a = cd.modifierr(add1, ec);
            if (a == false) {
                JOptionPane.showMessageDialog(this, "vous n'avez pas modifiée enregistrement correctement", "Marque", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "vous avez modifiée enregistrement correctement", "Marque", JOptionPane.INFORMATION_MESSAGE);
                ch.update(ec, jTable1.getSelectedRow());
            }
        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }


    }

    public void initialisation_jTable() throws SQLException {
        jTable1.setModel(ch);
        ch.setList(cd.Lister());
    }

    public void initialisationC_jTable(String cle) throws SQLException {
        jTable1.setModel(ch);
        ch.setList(cd.ListerP(cle));
    }

    public void initialisationN_jTable(String cle) throws SQLException {
        jTable1.setModel(ch);
        ch.setList(cd.ListerN(cle));
    }

    public void initialisationNM_jTable(String cle) throws SQLException {
        jTable1.setModel(ch);
        ch.setList(cd.ListerNM(cle));
    }

    public void chargercombo() throws SQLException {
        lp = pd.Lister();

        for (Permit l : lp) {
            jComboBox2.removeItem(l.getNUMPT());
            jComboBox2.addItem(l.getNUMPT());
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtcin = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtnom = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtprenom = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtdate = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        txtville = new javax.swing.JTextField();
        txttele = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtadresse = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txttelee = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        save = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        Combochoix = new javax.swing.JComboBox<>();
        rech = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Cin :");

        jLabel2.setText("Num Permit :");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{" "}));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton.setText("+");
        jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Nom Client :");

        txtnom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnomActionPerformed(evt);
            }
        });

        jLabel4.setText("Prenom Client");

        txtprenom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprenomActionPerformed(evt);
            }
        });

        jLabel5.setText("Date de Naissance :");

        txtdate.setDateFormatString("yyyy-MM-dd HH:mm:ss");

        jLabel6.setText("Ville de Naissance :");

        txtville.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtvilleActionPerformed(evt);
            }
        });

        txttele.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtteleActionPerformed(evt);
            }
        });

        jLabel9.setText("Adresse :");

        jLabel8.setText("Tele 2 :");

        jLabel7.setText("Tele 1 :");

        txttelee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtteleeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel2)
                                                                        .addComponent(jLabel1)
                                                                        .addComponent(jLabel3))
                                                                .addGap(45, 45, 45)
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                .addComponent(txtcin, javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(jButton))))
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                                .addComponent(jLabel5)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                                                .addComponent(jLabel4)
                                                                                .addGap(40, 40, 40)))
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txtdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                                .addComponent(txtprenom, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, Short.MAX_VALUE)))))
                                                .addGap(39, 39, 39))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel9)
                                                        .addComponent(jLabel7)
                                                        .addComponent(jLabel8))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(txtville, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                                                        .addComponent(txtadresse)
                                                        .addComponent(txttelee)
                                                        .addComponent(txttele, javax.swing.GroupLayout.Alignment.TRAILING))
                                                .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(txtcin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jButton)
                                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(txtprenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel5)
                                        .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(txtville, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(txtadresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(txttelee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(txttele, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(28, Short.MAX_VALUE))
        );

        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/4.png"))); // NOI18N
        save.setText("Ajouter");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/5.png"))); // NOI18N
        jButton3.setText("Modifier");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/1467670175_Shop-Payment-39.png"))); // NOI18N
        jButton4.setText("Nouveau");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(save)
                                .addGap(57, 57, 57)
                                .addComponent(jButton3)
                                .addGap(31, 31, 31)
                                .addComponent(jButton4)
                                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(save)
                                        .addComponent(jButton3)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(14, Short.MAX_VALUE))
        );

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

        Combochoix.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"ALL", "CIN", "NUMPT", "NOMCLI"}));
        Combochoix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CombochoixActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/6.png"))); // NOI18N
        jButton1.setText("rechercher");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(rech, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Combochoix, 0, 134, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(rech, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Combochoix, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane1)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtvilleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtvilleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtvilleActionPerformed

    private void txtnomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnomActionPerformed

    private void txtprenomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprenomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprenomActionPerformed

    private void txtteleeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtteleeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtteleeActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        ClientDao g = new ClientDao();
        String CIN = this.txtcin.getText();
        //String NUMPT = this.txtpermit.getText();
//         String NUMPT =  this.jComboBox2.getSelectedItem().toString();
        String NUMPT = (String) jComboBox2.getSelectedItem();
        String NOMCLI = this.txtnom.getText();
        String PRENCLI = this.txtprenom.getText();
        //String DATENAIS=this.txtdatee.getText();
        JTextField txt = ((JTextField) txtdate.getDateEditor().getUiComponent());
        String DATENAIS = txt.getText().toString();
        String VILLENAIS = this.txtville.getText();
        String ADRES = this.txtadresse.getText();
        String TEL1 = this.txttelee.getText();
        String TEL2 = this.txttele.getText();


        Client e = new Client(CIN, NUMPT, NOMCLI, PRENCLI, DATENAIS, VILLENAIS, ADRES, TEL1, TEL2);
        if (txtcin.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "S'il vous plait entrer CIN .", "Erreur", JOptionPane.ERROR_MESSAGE);
            txtcin.requestFocus();
            return;
        }
        if (jComboBox2.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(this, "S'il vous plait Selectionez le  numero  permit .", "Erreur", JOptionPane.ERROR_MESSAGE);
            jComboBox2.requestFocus();
            return;
        }
        if (txtnom.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "S'il vous plait entrer le nom .", "Erreur", JOptionPane.ERROR_MESSAGE);
            txtnom.requestFocus();
            return;
        }
        if (txtprenom.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "S'il vous plait entrer prenom .", "Erreur", JOptionPane.ERROR_MESSAGE);
            txtprenom.requestFocus();
            return;
        }
        if (txt.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "S'il vous plait entrer la date naissance .", "Erreur", JOptionPane.ERROR_MESSAGE);
            txt.requestFocus();
            return;
        }
        if (txtville.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "S'il vous plait entrer la ville .", "Erreur", JOptionPane.ERROR_MESSAGE);
            txtville.requestFocus();
            return;
        }
        if (txtadresse.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "S'il vous plait entrer l'adresse .", "Erreur", JOptionPane.ERROR_MESSAGE);
            txtadresse.requestFocus();
            return;
        }
        if (txttelee.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "S'il vous plait entrer numero de telephone 1 .", "Erreur", JOptionPane.ERROR_MESSAGE);
            txttelee.requestFocus();
            return;
        }
        try {
            boolean tt = g.ajouter(e);


            if (tt = true) {
                JOptionPane.showMessageDialog(null, "vous avez  ajouté enregistrement correctement!");
            } else {
                JOptionPane.showMessageDialog(null, "vous n'avez pas ajouté enregistrement correctement!");
            }
            Reset();

            initialisation_jTable();
        } catch (SQLException ex) {
            Logger.getLogger(ClienTUser.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_saveActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:

        int row = jTable1.getSelectedRow();
        String table_click = jTable1.getModel().getValueAt(row, 0).toString();
        List<Client> ListterP = null;
        try {
            ListterP = cd.ListerP(table_click);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }

        for (Client l : ListterP) {
            add1 = l.getCIN();
            txtcin.setText(add1);
            String add2 = l.getNUMPT();
            jComboBox2.setSelectedItem(add2);
            String add3 = l.getNOMCLI();
            txtnom.setText(add3);
            String add4 = l.getPRENCLI();
            txtprenom.setText(add4);
            String add5 = l.getDATENAIS();
            JTextField txt = ((JTextField) txtdate.getDateEditor().getUiComponent());
            txt.setText(add5);
            //txtdatee.setText(add5);
            String add6 = l.getVILLENAIS();
            txtville.setText(add6);
            String add7 = l.getADRES();
            txtadresse.setText(add7);
            String add8 = l.getTEL1();
            txttelee.setText(add8);
            String add9 = l.getTEL2();
            txttele.setText(add9);


        }
        save.setEnabled(false);

        jButton3.setEnabled(true);

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActionPerformed
        // TODO add your handling code here:

        ClienTUser.this.setVisible(false);
        AddP p = new AddP();
        p.setVisible(true);

    }//GEN-LAST:event_jButtonActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed

        // try {
        // TODO add your handling code here:
        // chargercombo();
        // } catch (SQLException ex) {
        //  Logger.getLogger(ClienTUser.class.getName()).log(Level.SEVERE, null, ex);
        // }

    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void CombochoixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CombochoixActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CombochoixActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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
                    initialisationC_jTable(rech.getText());
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
                    initialisationNM_jTable(rech.getText());
                    rech.setText("");
                } catch (SQLException ex) {
                    Logger.class.getName();
                }
                break;
            default:
                break;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed


        try {

            modifier();

            Reset();

        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:

    }//GEN-LAST:event_formWindowClosed

    private void txtteleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtteleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtteleActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Reset();
    }//GEN-LAST:event_jButton4ActionPerformed
    // End of variables declaration//GEN-END:variables
}
