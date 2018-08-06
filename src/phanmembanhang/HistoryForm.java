/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmembanhang;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class HistoryForm extends javax.swing.JDialog {

    MainForm mf;
    Connection con;
    Statement s;
    ResultSet rs;
    String xSql;
    DefaultTableModel g;
    boolean showDaily = false;

    public HistoryForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        g = (DefaultTableModel) tbl1.getModel();
        this.setLocationRelativeTo(null);
        txtXX.setEditable(false);
        txtRedBull.setEditable(false);
        txtYellow.setEditable(false);
        txtRed.setEditable(false);
        txtDoanhThu.setEditable(false);
        mf = (MainForm) parent;
        loadDB();
        xSql = "select * from History";
        displayResultSet();
        setText();
    }

    void loadDB() {
        con = DBConnect.getConnection();
        try {
            s = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void clearTable() {
        g.setRowCount(0);
    }

    void setText() {
        String xNgay;
        xNgay = txtDonTheoNgay.getText().trim();
        int r = xNgay.length();
        if (!showDaily) {
            xSql = "select sum (Gia) as Sum from History ";
            try {
                rs = s.executeQuery(xSql);
                while (rs.next()) {
                    txtDoanhThu.setText(rs.getString("Sum") + " VNĐ");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
//          bỏ xúc xích
//            xSql = "select sum (XucXich) as XX from History ";
//            try {
//                rs = s.executeQuery(xSql);
//                while (rs.next()) {
//                    txtXX.setText(rs.getString("XX"));
//                }
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
            xSql = "select sum (RedBull) as RedBull from History ";
            try {
                rs = s.executeQuery(xSql);
                while (rs.next()) {
                    txtRedBull.setText(rs.getString("RedBull"));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            xSql = "select sum (StingVang) as Yellow from History ";
            try {
                rs = s.executeQuery(xSql);
                while (rs.next()) {
                    txtYellow.setText(rs.getString("Yellow"));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            xSql = "select sum (StingDo) as Red from History ";
            try {
                rs = s.executeQuery(xSql);
                while (rs.next()) {
                    txtRed.setText(rs.getString("Red"));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            xSql = "select sum(a.Gia) as DailySum from(select * from History where left(TimeOrder," + r + ")='" + xNgay + "') a";
            try {
                rs = s.executeQuery(xSql);
                while (rs.next()) {
                    txtDoanhThu.setText(rs.getString("DailySum") + " VNĐ");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            // bỏ xúc xích
//            xSql = "select sum(a.XucXich) as XX from(select * from History where left(TimeOrder," + r + ")='" + xNgay + "') a";
//            try {
//                rs = s.executeQuery(xSql);
//                while (rs.next()) {
//                    txtXX.setText(rs.getString("XX"));
//                }
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
            xSql = "select sum(a.RedBull) as RedBull from(select * from History where left(TimeOrder," + r + ")='" + xNgay + "') a";
            try {
                rs = s.executeQuery(xSql);
                while (rs.next()) {
                    txtRedBull.setText(rs.getString("RedBull") );
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            xSql = "select sum(a.StingVang) as Yellow from(select * from History where left(TimeOrder," + r + ")='" + xNgay + "') a";
            try {
                rs = s.executeQuery(xSql);
                while (rs.next()) {
                    txtYellow.setText(rs.getString("Yellow") );
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            xSql = "select sum(a.StingDo) as Red from(select * from History where left(TimeOrder," + r + ")='" + xNgay + "') a";
            try {
                rs = s.executeQuery(xSql);
                while (rs.next()) {
                    txtRed.setText(rs.getString("Red") );
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

    void displayResultSet() {

        String xRoom, xDate;
        int xXucXich, xRedBull, xYellow, xRed, xGia;
        try {
            rs = s.executeQuery(xSql);
            clearTable();
            while (rs.next()) {
                xRoom = new String(rs.getString("Room"));
//              xXucXich = rs.getInt("XucXich");
                xRedBull = rs.getInt("REdBull");
                xYellow = rs.getInt("StingVang");
                xRed = rs.getInt("StingDo");
                xGia = rs.getInt("Gia");
                xDate = new String(rs.getString("TimeOrder"));
                g.insertRow(tbl1.getRowCount(), new Object[]{xRoom,xRedBull, xYellow, xRed, xGia, xDate});
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtRedBull = new javax.swing.JTextField();
        txtXX = new javax.swing.JTextField();
        txtYellow = new javax.swing.JTextField();
        txtRed = new javax.swing.JTextField();
        txtDoanhThu = new javax.swing.JTextField();
        btnDom = new javax.swing.JButton();
        btnGia = new javax.swing.JButton();
        txtDonTheoNgay = new javax.swing.JTextField();
        btnGio = new javax.swing.JButton();
        btnDailyDoanhThu = new javax.swing.JButton();
        rdoShowByDay = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Room", "RedBull", "Sting Vàng", "Sting Đỏ", "Giá", "Time Order"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl1);
        if (tbl1.getColumnModel().getColumnCount() > 0) {
            tbl1.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbl1.getColumnModel().getColumn(1).setPreferredWidth(40);
            tbl1.getColumnModel().getColumn(2).setPreferredWidth(40);
            tbl1.getColumnModel().getColumn(3).setPreferredWidth(40);
            tbl1.getColumnModel().getColumn(4).setPreferredWidth(50);
            tbl1.getColumnModel().getColumn(5).setPreferredWidth(100);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tổng hợp doanh thu đã bán");

        jLabel2.setText("Xúc xích bán ra");

        jLabel3.setText("RedBull bán ra");

        jLabel4.setText("Sting vàng bán ra");

        jLabel5.setText("Sting đỏ bán ra");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Tổng doanh thu");

        txtRedBull.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtXX.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtXX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtXXActionPerformed(evt);
            }
        });

        txtYellow.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtYellow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtYellowActionPerformed(evt);
            }
        });

        txtRed.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRedActionPerformed(evt);
            }
        });

        txtDoanhThu.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDoanhThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDoanhThuActionPerformed(evt);
            }
        });

        btnDom.setText("Xếp theo dom");
        btnDom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDomActionPerformed(evt);
            }
        });

        btnGia.setText("Xếp theo giá");
        btnGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiaActionPerformed(evt);
            }
        });

        txtDonTheoNgay.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDonTheoNgay.setText("2017");

        btnGio.setText("Xếp theo giờ");
        btnGio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGioActionPerformed(evt);
            }
        });

        btnDailyDoanhThu.setText("Doanh thu theo ngày");
        btnDailyDoanhThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDailyDoanhThuActionPerformed(evt);
            }
        });

        rdoShowByDay.setText("Show by day");
        rdoShowByDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoShowByDayActionPerformed(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Đơn theo ngày");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtXX, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(89, 89, 89)
                                        .addComponent(txtRedBull, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRed, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtYellow, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDonTheoNgay)
                        .addComponent(btnDailyDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(rdoShowByDay))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDom)
                        .addGap(18, 18, 18)
                        .addComponent(btnGia)
                        .addGap(26, 26, 26)
                        .addComponent(btnGio)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtDonTheoNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDailyDoanhThu)
                        .addGap(18, 18, 18)
                        .addComponent(rdoShowByDay))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtXX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtYellow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRedBull)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtXXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtXXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtXXActionPerformed

    private void txtDoanhThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDoanhThuActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_txtDoanhThuActionPerformed

    private void txtRedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRedActionPerformed

    private void btnDomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDomActionPerformed
        // TODO add your handling code here:
        if (!showDaily) {
            xSql = "select * from History order by Room asc";
        } else {
            String xNgay;
            xNgay = txtDonTheoNgay.getText().trim();
            int r = xNgay.length();
            if (r == 0) {
                JOptionPane.showMessageDialog(null, "Enter correct form");
                txtDonTheoNgay.requestFocus();
                return;
            }
            xSql = "select * from(select * from History where left(TimeOrder," + r + ")='" + xNgay + "') a order by a.Room asc";

        }
        try {
            s.execute(xSql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        displayResultSet();

    }//GEN-LAST:event_btnDomActionPerformed

    private void btnGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiaActionPerformed
        // TODO add your handling code here:
        if (!showDaily) {
            xSql = "select * from History order by Gia asc";
        } else {
            String xNgay;
            xNgay = txtDonTheoNgay.getText().trim();
            int r = xNgay.length();
            if (r == 0) {
                JOptionPane.showMessageDialog(null, "Enter correct form");
                txtDonTheoNgay.requestFocus();
                return;
            }
            xSql = "select * from(select * from History where left(TimeOrder," + r + ")='" + xNgay + "') a order by a.Gia asc";

        }
        try {
            s.execute(xSql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        displayResultSet();
    }//GEN-LAST:event_btnGiaActionPerformed

    private void btnGioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGioActionPerformed
        // TODO add your handling code here:
        if (!showDaily) {
            xSql = "select * from History order by TimeOrder asc";
        } else {
            String xNgay;
            xNgay = txtDonTheoNgay.getText().trim();
            int r = xNgay.length();
            if (r == 0) {
                JOptionPane.showMessageDialog(null, "Enter correct form");
                txtDonTheoNgay.requestFocus();
                return;
            }
            xSql = "select * from(select * from History where left(TimeOrder," + r + ")='" + xNgay + "') a order by a.TimeOrder asc";

        }
        try {
            s.execute(xSql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        displayResultSet();
    }//GEN-LAST:event_btnGioActionPerformed

    private void btnDailyDoanhThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDailyDoanhThuActionPerformed
        // TODO add your handling code here:
        String xNgay;
        xNgay = txtDonTheoNgay.getText().trim();
        int r = xNgay.length();
        if (r == 0) {
            JOptionPane.showMessageDialog(null, "Enter correct form");
            txtDonTheoNgay.requestFocus();
            return;
        }
        //     xSql = "select sum(a.Gia) as DailySum from(select * from History where left(TimeOrder," + r + ")='" + xNgay + "') a";
        //       try {
//            rs = s.executeQuery(xSql);
//            while (rs.next()) {
//                txtDoanhThuTheoNgay.setText(Integer.toString(rs.getInt("DailySum")) + " VNĐ");
//            }
        xSql = "select * from History where left(TimeOrder," + r + ")='" + xNgay + "'";
        displayResultSet();
        setText();
        //       } catch (SQLException ex) {
//            Logger.getLogger(HistoryForm.class.getName()).log(Level.SEVERE, null, ex);
        //       }


    }//GEN-LAST:event_btnDailyDoanhThuActionPerformed

    private void rdoShowByDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoShowByDayActionPerformed
        // TODO add your handling code here:
        if (rdoShowByDay.isSelected()) {
            showDaily = true;

        } else {
            showDaily = false;
        }

    }//GEN-LAST:event_rdoShowByDayActionPerformed

    private void txtYellowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtYellowActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtYellowActionPerformed

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
            java.util.logging.Logger.getLogger(HistoryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistoryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistoryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistoryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HistoryForm dialog = new HistoryForm(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDailyDoanhThu;
    private javax.swing.JButton btnDom;
    private javax.swing.JButton btnGia;
    private javax.swing.JButton btnGio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoShowByDay;
    private javax.swing.JTable tbl1;
    private javax.swing.JTextField txtDoanhThu;
    private javax.swing.JTextField txtDonTheoNgay;
    private javax.swing.JTextField txtRed;
    private javax.swing.JTextField txtRedBull;
    private javax.swing.JTextField txtXX;
    private javax.swing.JTextField txtYellow;
    // End of variables declaration//GEN-END:variables
}
