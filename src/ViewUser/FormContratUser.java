/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewUser;

import Dao.ClientDao;
import Dao.DaoContrat;
import Dao.DaoRevsion;
import Dao.DaoVehicule;
import Model.Contrat;
import Model.GenerContrat;
import View.FormContrat;
import helper.ContratHelper;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Lenovo
 */
public class FormContratUser extends javax.swing.JFrame {

    Dao.DaoContrat cont = new DaoContrat();
    Dao.DaoVehicule vh = new DaoVehicule();
    Dao.DaoRevsion re = new DaoRevsion();
    Dao.ClientDao cl = new ClientDao();
    List<Model.Client> lcl = null;
    List<Model.Vehicule> lvh = null;
    boolean lre = false;
    helper.ContratHelper hc = new ContratHelper();
    long UNE_HEURE = 60 * 60 * 1000L;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton calcul;
    private javax.swing.JTextField duree;
    private javax.swing.JTextField idcont;
    private javax.swing.JTextField iduser;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton news;
    private javax.swing.JButton print;
    private javax.swing.JTextField recher;
    private javax.swing.JButton refer;
    private javax.swing.JTable tableContrat;
    private com.toedter.calendar.JDateChooser txtdate;
    private com.toedter.calendar.JDateChooser txtdate1;
    private com.toedter.calendar.JDateChooser txtdate2;
    private com.toedter.calendar.JDateChooser txtdate3;

    /**
     * Creates new form FormContratUser
     */

    public FormContratUser() {
        initComponents();
        rest();

        try {
            initialisation_jTable();
        } catch (SQLException ex) {
            Logger.getLogger(FormContrat.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            iduser.setText(Choix1.getidUser());
        } catch (Exception ex) {

        }

        try {
            chargercombo();
            chargercombo1();
        } catch (SQLException ex) {
            Logger.getLogger(FormContrat.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(FormContratUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormContratUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormContratUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormContratUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormContratUser().setVisible(true);
            }
        });
    }

    public void chargercombo() throws SQLException {
        lcl = cl.Lister();
        jComboBox1.removeAllItems();
        jComboBox1.addItem("clients ");
        for (Model.Client l : lcl) {
            jComboBox1.addItem(l.getCIN());
        }

    }

    public void chargercombo1() throws SQLException {
        lvh = vh.listerVhDi();
        jComboBox2.removeAllItems();
        jComboBox2.addItem("Voitures disponibles");
        for (Model.Vehicule l : lvh) {
            jComboBox2.addItem(l.getMatrVh());
        }

    }

    public void initialisation_jTable() throws SQLException {
        tableContrat.setModel(hc);
        hc.setList(cont.ListerDetail());
    }

    public void initialisation_jTable1(String cle) throws SQLException {
        tableContrat.setModel(hc);
        hc.setList(cont.ListerDetail(cle));
    }

    public void initialisation_jTable2(String cle) throws SQLException {
        tableContrat.setModel(hc);
        hc.setList(cont.ListerDetailCin(cle));
    }

    public void initialisation_jTable3(String cle) throws SQLException {
        tableContrat.setModel(hc);
        hc.setList(cont.ListerDetailVh(cle));
    }

    public void initialisation_jTable4(String cle, String cle1) throws SQLException {

        tableContrat.setModel(hc);
        hc.setList(cont.ListerDetailDateD(cle, cle1));

    }

    public void initialisation_jTable5(String cle, String cle1) throws SQLException {

        tableContrat.setModel(hc);
        hc.setList(cont.ListerDetailDateF(cle, cle1));

    }

    public boolean verf() {
        JTextField txt = ((JTextField) txtdate.getDateEditor().getUiComponent());
        String DATEDebut = txt.getText().toString();
        JTextField txt1 = ((JTextField) txtdate1.getDateEditor().getUiComponent());
        String DATEFin = txt1.getText().toString();
        lre = re.RechercherVi(jComboBox2.getSelectedItem().toString(), DATEDebut, DATEFin);
        return lre == true;

    }

    public void ajouter() {
        boolean a = false;
        boolean b = false;
        boolean c = false;

        String id = idcont.getText();
        String id1 = iduser.getText();
        int dure = Integer.parseInt(duree.getText());
        String id2 = (String) jComboBox1.getSelectedItem();
        String id3 = (String) jComboBox2.getSelectedItem();
        String id4 = (String) jComboBox4.getSelectedItem();
        String id5 = (String) jComboBox6.getSelectedItem();
        String id6 = (String) jComboBox7.getSelectedItem();
        if (id4 == "oui") {
            a = true;
        }
        if (id5 == "oui") {
            b = true;
        }
        if (id6 == "oui") {
            c = true;
        }
        JTextField txt = ((JTextField) txtdate.getDateEditor().getUiComponent());
        String DATEDebut = txt.getText().toString();
        JTextField txt1 = ((JTextField) txtdate1.getDateEditor().getUiComponent());
        String DATEFin = txt1.getText().toString();
        Contrat cont1 = new Contrat(id, DATEDebut, id1, id2, id3, DATEFin, dure, a, b, c);
        boolean h = cont.ajouteCont(cont1);
        if (h == false) {
            JOptionPane.showMessageDialog(this, "vous n'avez pas ajouté enregistrement correctement", "Contrat", JOptionPane.ERROR_MESSAGE);
        } else {

            JOptionPane.showMessageDialog(this, "vous avez ajouté enregistrement correctement", "Contrat", JOptionPane.INFORMATION_MESSAGE);
            rest();
        }
    }

    public void Calculation() {

        Date dt1 = txtdate.getDate();
        Date dt2 = txtdate1.getDate();
        String d = "0";
        try {
            if (dt1.after(dt2)) {
                JOptionPane.showMessageDialog(this, "date debut est supérieure de date fin", "Date", JOptionPane.ERROR_MESSAGE);
            } else {

                d = String.valueOf((dt2.getTime() - dt1.getTime() + UNE_HEURE) / (UNE_HEURE * 24));
                duree.setText(d);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR DATE !!!! :( ", "Contrat", JOptionPane.ERROR_MESSAGE);
        }

    }

    public String CalculationUp() {

        Date dt1 = txtdate.getDate();
        Date dt2 = txtdate1.getDate();
        String d = "0";
        try {
            if (dt1.after(dt2)) {
                JOptionPane.showMessageDialog(this, "date debut est supérieure de date fin", "Date", JOptionPane.ERROR_MESSAGE);
            } else {

//DateTime dateTimeDeb = new DateTime("2012-12-25");
//DateTime dateTimeFin = new DateTime("2012-12-31");
//Days d = Days.daysBetween(dateTimeDeb, dateTimeFin);
//int days = d.getDays();
                d = String.valueOf((dt2.getTime() - dt1.getTime() + UNE_HEURE) / (UNE_HEURE * 24));

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR DATE !!!! :( ", "Contrat", JOptionPane.ERROR_MESSAGE);
        }
        return d;
    }

    public void inCode() {
        try {
            int j;
            int cont1 = 1;
            String num = "";
            String c = "";
            c = cont.dernier();
            if (c == null) {
                idcont.setText("Cont000000001");
            } else {

                char r1 = c.charAt(4);
                char r2 = c.charAt(5);
                char r3 = c.charAt(6);
                char r4 = c.charAt(7);
                char r5 = c.charAt(8);
                char r6 = c.charAt(9);
                char r7 = c.charAt(10);
                char r8 = c.charAt(11);
                char r9 = c.charAt(12);

                String r = "";
                r = "" + r1 + r2 + r3 + r4 + r5 + r5 + r5 + r6 + r7 + r8 + r9;
                j = Integer.parseInt(r) + cont1;
                GenerContrat mo = new GenerContrat();
                mo.generar(j);
                idcont.setText("Cont" + mo.serie());

            }
        } catch (SQLException ex) {
            Logger.getLogger(FormContrat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void rest() {
        try {
            chargercombo1();
        } catch (SQLException ex) {
            Logger.getLogger(FormContrat.class.getName()).log(Level.SEVERE, null, ex);
        }
        idcont.setText("");
        inCode();
        try {
            iduser.setText(Choix1.getidUser());
        } catch (Exception ex) {

        }
        jLabel5.setText("");
        add.setEnabled(true);
        print.setEnabled(false);
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        jComboBox3.setSelectedIndex(0);
        jComboBox4.setSelectedIndex(0);
        jComboBox6.setSelectedIndex(0);
        jComboBox7.setSelectedIndex(0);
        txtdate.setDate(Calendar.getInstance().getTime());
        txtdate1.setDate(Calendar.getInstance().getTime());
        duree.setText("0");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tableContrat = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        txtdate1 = new com.toedter.calendar.JDateChooser();
        txtdate = new com.toedter.calendar.JDateChooser();
        duree = new javax.swing.JTextField();
        calcul = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox6 = new javax.swing.JComboBox<>();
        jComboBox7 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        idcont = new javax.swing.JTextField();
        iduser = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        add = new javax.swing.JButton();
        news = new javax.swing.JButton();
        refer = new javax.swing.JButton();
        print = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jComboBox3 = new javax.swing.JComboBox<>();
        recher = new javax.swing.JTextField();
        txtdate2 = new com.toedter.calendar.JDateChooser();
        txtdate3 = new com.toedter.calendar.JDateChooser();
        jButton7 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tableContrat.setBackground(new java.awt.Color(204, 204, 255));
        tableContrat.setModel(new javax.swing.table.DefaultTableModel(
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
        tableContrat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableContratMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableContrat);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(102, 102, 102)));

        txtdate1.setDateFormatString("yyyy-MM-dd HH:mm:ss");

        txtdate.setDateFormatString("yyyy-MM-dd HH:mm:ss");

        duree.setText("0");
        duree.setEnabled(false);
        duree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dureeActionPerformed(evt);
            }
        });

        calcul.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/1467670581_calculator-pencil.png"))); // NOI18N
        calcul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculActionPerformed(evt);
            }
        });

        jLabel9.setText("date de début    :");

        jLabel10.setText("Date Fin             :");

        jLabel11.setText("Durée par Jour  :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(duree)
                                                .addGap(72, 72, 72))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtdate1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(calcul, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel10)
                                        .addComponent(txtdate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11)
                                        .addComponent(duree, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(calcul))
                                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(51, 51, 51), new java.awt.Color(102, 102, 102)));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"oui", "non"}));

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"oui", "non"}));

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"oui", "non"}));

        jLabel6.setText("Siège auto en solde :");

        jLabel7.setText("chaine neige moto   :");

        jLabel8.setText("Gps : ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addComponent(jLabel8)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addComponent(jLabel6)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(32, 32, 32))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7))
                                .addGap(27, 27, 27))
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 51, 51), new java.awt.Color(102, 102, 102)));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{" "}));

        jLabel1.setText(" Client           :");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{" "}));

        jLabel2.setText("Matruclation :");

        idcont.setEnabled(false);

        jLabel3.setText("Utilisateur     :");

        jLabel4.setText("ID Contrat    :");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(117, 117, 117))
                                                        .addComponent(idcont, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel2))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jComboBox2, 0, 187, Short.MAX_VALUE)
                                                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(iduser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(idcont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(iduser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(102, 102, 102)));

        add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/1467670010_file_add.png"))); // NOI18N
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        news.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/1467670175_Shop-Payment-39.png"))); // NOI18N
        news.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newsActionPerformed(evt);
            }
        });

        refer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/1467670146_sync_synchronisation_recycle_refresh.png"))); // NOI18N
        refer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                referActionPerformed(evt);
            }
        });

        print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/1467670419_printer.png"))); // NOI18N
        print.setToolTipText("");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(add)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(print))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(refer)
                                                .addGap(29, 29, 29)
                                                .addComponent(news)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(add)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(print)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(refer, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(news, javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addGap(60, 60, 60))
        );

        jPanel6.setBackground(new java.awt.Color(204, 204, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(102, 102, 102)));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"ALL", "IDCONT", "CIN", "MATR", "DATEDEBUT", "DATEFIN"}));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        txtdate2.setDateFormatString("yyyy-MM-dd HH:mm:ss");

        txtdate3.setDateFormatString("yyyy-MM-dd HH:mm:ss");

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/6.png"))); // NOI18N
        jButton7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton7.setBorderPainted(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel12.setText("date de début    :");

        jLabel14.setText("Date Fin             :");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(recher)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(txtdate2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel14)
                                .addGap(41, 41, 41)
                                .addComponent(txtdate3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(recher))
                                        .addComponent(jButton7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                                        .addComponent(jComboBox3)
                                        .addComponent(txtdate2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtdate3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel14)
                                                        .addComponent(jLabel12))))
                                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    }// </editor-fold>//GEN-END:initComponents

    private void tableContratMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableContratMouseClicked

        add.setEnabled(false);
        print.setEnabled(true);
        int row = tableContrat.getSelectedRow();
        String table_click = tableContrat.getModel().getValueAt(row, 0).toString();
        List<Contrat> Licont = null;
        Licont = cont.ListerTouparID(table_click);

        for (Contrat l : Licont) {

            idcont.setText(l.getIdCont());
            jLabel5.setText(l.getIdCont());
            jComboBox1.setSelectedItem(l.getCin());
            iduser.setText(l.getIdutil());
            JTextField txt1 = ((JTextField) txtdate1.getDateEditor().getUiComponent());
            txt1.setText(l.getDateFin());
            JTextField txt = ((JTextField) txtdate.getDateEditor().getUiComponent());
            txt.setText(l.getDateDebut());
            jComboBox2.setSelectedItem(l.getMatrVh());
            duree.setText(String.valueOf(l.getDuree()));
            if (l.isGps()) {
                jComboBox4.setSelectedItem("oui");
            } else {
                jComboBox4.setSelectedItem("non");
            }
            if (l.isSiegebebe()) {
                jComboBox6.setSelectedItem("oui");
            } else {
                jComboBox6.setSelectedItem("non");
            }
            if (l.isChainesnaige()) {
                jComboBox7.setSelectedItem("oui");
            } else {
                jComboBox7.setSelectedItem("non");
            }

        }
    }//GEN-LAST:event_tableContratMouseClicked

    private void dureeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dureeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dureeActionPerformed

    private void calculActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculActionPerformed
        Calculation();
    }//GEN-LAST:event_calculActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        if (iduser.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "S'il vous plait entrer ID user .", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (duree.getText().equals("") || duree.getText().equals("0")) {
            JOptionPane.showMessageDialog(this, "S'il vous plait calculer la durée .", "Erreur", JOptionPane.ERROR_MESSAGE);

            return;
        }
        if (jComboBox1.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "S'il vous plait Donnez Client  .", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (jComboBox2.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "S'il vous plait Donnez Voiture  .", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (verf()) {
            JOptionPane.showMessageDialog(this, "S'il vous plait changer les dates   .", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ajouter();
        try {
            initialisation_jTable();
        } catch (SQLException ex) {
            Logger.getLogger(FormContrat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addActionPerformed

    private void newsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newsActionPerformed
        rest();
    }//GEN-LAST:event_newsActionPerformed

    private void referActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_referActionPerformed
        try {
            initialisation_jTable();
            chargercombo1();
            chargercombo();
        } catch (SQLException ex) {
            Logger.getLogger(FormContrat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_referActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
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
            param.put("idcat", idcont.getText());
            JasperReport reportes = JasperCompileManager.compileReport("report4.jrxml");


            JasperPrint print = JasperFillManager.fillReport(reportes, param, con);
            JasperViewer.viewReport(print, false);

        } catch (Exception e) {
            System.out.printf(e.getMessage());
        }


    }//GEN-LAST:event_printActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        if (jComboBox3.getSelectedIndex() == 0) {
            recher.setEditable(true);
            txtdate2.setEnabled(false);
            txtdate3.setEnabled(false);
        }
        if (jComboBox3.getSelectedIndex() == 1) {
            recher.setEditable(true);
            txtdate2.setEnabled(false);
            txtdate3.setEnabled(false);
        }
        if (jComboBox3.getSelectedIndex() == 2) {
            recher.setEditable(true);
            txtdate2.setEnabled(false);
            txtdate3.setEnabled(false);
        }
        if (jComboBox3.getSelectedIndex() == 3) {
            recher.setEditable(true);
            txtdate2.setEnabled(false);
            txtdate3.setEnabled(false);
        }
        if (jComboBox3.getSelectedIndex() == 4) {
            recher.setEditable(false);
            txtdate2.setEnabled(true);
            txtdate3.setEnabled(true);
        }
        if (jComboBox3.getSelectedIndex() == 5) {
            recher.setEditable(false);
            txtdate2.setEnabled(true);
            txtdate3.setEnabled(true);
        }
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {

            if (jComboBox3.getSelectedIndex() == 0) {
                initialisation_jTable();
            }
            if (jComboBox3.getSelectedIndex() == 1) {
                initialisation_jTable1(recher.getText());
            }
            if (jComboBox3.getSelectedIndex() == 2) {
                initialisation_jTable2(recher.getText());
            }
            if (jComboBox3.getSelectedIndex() == 3) {
                initialisation_jTable3(recher.getText());
            }
            if (jComboBox3.getSelectedIndex() == 4) {
                JTextField txt111 = ((JTextField) txtdate2.getDateEditor().getUiComponent());
                String DATEDebut11 = txt111.getText().toString();
                JTextField txt222 = ((JTextField) txtdate3.getDateEditor().getUiComponent());
                String DATEFin11 = txt222.getText().toString();
                initialisation_jTable4(DATEDebut11, DATEFin11);
            }
            if (jComboBox3.getSelectedIndex() == 5) {
                JTextField txt111 = ((JTextField) txtdate2.getDateEditor().getUiComponent());
                String DATEDebut11 = txt111.getText().toString();
                JTextField txt222 = ((JTextField) txtdate3.getDateEditor().getUiComponent());
                String DATEFin11 = txt222.getText().toString();
                initialisation_jTable5(DATEDebut11, DATEFin11);

            }

        } catch (SQLException ex) {
            Logger.getLogger(FormContrat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, " ERROR !!!!!!! De Recherche", "Contrat", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton7ActionPerformed
    // End of variables declaration//GEN-END:variables
}
