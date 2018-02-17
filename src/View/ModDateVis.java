/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.DaoRevsion;
import Dao.DaoVehicule;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Lenovo
 */
public class ModDateVis extends javax.swing.JFrame {

    public static javax.swing.JTextField jTextField11;
    public javax.swing.JLabel jLabel11;
    public javax.swing.JLabel jLabel33;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    protected javax.swing.JTextField jTextField3;
    int[] mois = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int[] mois1 = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    DaoRevsion r = new DaoRevsion();
    DaoVehicule dv = new DaoVehicule();
    Date d = new Date();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;

    /**
     * Creates new form ModDateVis
     */
    public ModDateVis() {
        initComponents();
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
            java.util.logging.Logger.getLogger(ModDateVis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModDateVis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModDateVis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModDateVis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModDateVis().setVisible(true);
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/5.png"))); // NOI18N
        jButton1.setText("Modifier");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgApp/12.png"))); // NOI18N
        jButton2.setText("Reteur");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Mat:");

        jLabel5.setText("id re v: ");

        jTextField11.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel5)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jLabel11)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jLabel4)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jLabel33))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jButton1)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                                                                .addComponent(jButton2)))
                                                .addGap(18, 18, 18))))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel33)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (vDate(jTextField3.getText(), "Date Viste Tequnique")) {
            boolean b = r.modifierVist(jLabel11.getText(), inDate(jTextField3.getText()));
            boolean a = r.listerpan(d, jLabel33.getText());
            if (a == true) {
                JOptionPane.showMessageDialog(this, "veuillez svp vérifier la maintenance de cette voiture", "Revision", JOptionPane.ERROR_MESSAGE);
            } else {
                dv.disponible(jLabel33.getText());
            }

            if (b == false) {
                JOptionPane.showMessageDialog(this, "vous n'avez pas modifiée enregistrement correctement", "Revision", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "vous  avez  modifiée enregistrement correctement", "Revision", JOptionPane.INFORMATION_MESSAGE);
                jLabel11.setText("xxxx");
                jLabel33.setText("xxxx");
                jTextField3.setText("");
                jButton1.setEnabled(false);
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ModDateVis.this.setVisible(false);
        ViewRevison vr = new ViewRevison();
        vr.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed
    // End of variables declaration//GEN-END:variables
}
