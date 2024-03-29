/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms.gui.internalframe;

import lms.gui.dialog.JDialogStudentPenaltiesDetails;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.JTextComponent;
import lms.gui.JFrameMainSLM;
import lms.model.Student;
import lms.reports.JDialogPenaltyListReport;
import lms.util.QueryLMS;

/**
 *
 * @author Aldrin
 */
public class JInternalFrameStudentPenalty extends javax.swing.JInternalFrame implements MouseListener {

    private JFrameMainSLM mainFrame;
    private QueryLMS query = new QueryLMS();
    private Student student = new Student();
    private JTextComponent comboBoxEditor;
    private static String studentName = "";

    /**
     * Creates new form JInternalFrameBooksList
     */
    public JInternalFrameStudentPenalty() {
        initComponents();
    }

    public JInternalFrameStudentPenalty(String title, boolean resizable, boolean closable, boolean maximizable, boolean iconifiable, lms.gui.JFrameMainSLM mainFrame) {

        setRootPane(createRootPane());
        setLayout(new BorderLayout());
        this.title = title;
        this.resizable = resizable;
        this.closable = closable;
        this.maximizable = maximizable;
        isMaximum = true;
        this.iconable = iconifiable;
        isIcon = false;
        setRootPaneCheckingEnabled(true);
        desktopIcon = new JDesktopIcon(this);
        updateUI();
        sun.awt.SunToolkit.checkAndSetPolicy(this);
        this.mainFrame = mainFrame;
        initComponents();
        setTable();
        selectStudentBookBorrewed();
        jButtonViewDetails.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldSearch = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jButtonViewDetails = new javax.swing.JButton();
        jButtonViewReport = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setMaximizable(true);
        setTitle("Student Penalty");
        setFocusable(false);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        jPanel2.setPreferredSize(new java.awt.Dimension(1308, 40));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("   Student Penalty");
        jPanel2.add(jLabel1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2, java.awt.BorderLayout.NORTH);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setPreferredSize(new java.awt.Dimension(748, 65));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel5.setPreferredSize(new java.awt.Dimension(450, 100));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Search");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, 30));

        jTextFieldSearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldSearch.setPreferredSize(new java.awt.Dimension(200, 30));
        jTextFieldSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldSearchMouseClicked(evt);
            }
        });
        jTextFieldSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSearchActionPerformed(evt);
            }
        });
        jTextFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchKeyReleased(evt);
            }
        });
        jPanel5.add(jTextFieldSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, -1));

        jPanel4.add(jPanel5, java.awt.BorderLayout.EAST);

        jPanel6.setPreferredSize(new java.awt.Dimension(550, 72));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonViewDetails.setMnemonic('R');
        jButtonViewDetails.setText("<html><center>View<br><p style=\"font-weight: bold; color: red;padding-top: 0px;\">Details</p></center></html>");
        jButtonViewDetails.setFocusable(false);
        jButtonViewDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewDetailsActionPerformed(evt);
            }
        });
        jPanel6.add(jButtonViewDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 90, 40));

        jButtonViewReport.setMnemonic('R');
        jButtonViewReport.setText("<html><center>View<br><p style=\"font-weight: bold; color: red;padding-top: 0px;\">Report</p></center></html>");
        jButtonViewReport.setFocusable(false);
        jButtonViewReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewReportActionPerformed(evt);
            }
        });
        jPanel6.add(jButtonViewReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 40));

        jPanel4.add(jPanel6, java.awt.BorderLayout.WEST);

        jPanel3.add(jPanel4, java.awt.BorderLayout.NORTH);

        jScrollPane1.setFocusable(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setFocusable(false);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1166, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(jPanel7, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchKeyReleased
        String text = jTextFieldSearch.getText().trim();
        if (text.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text + ",*"));
        }
    }//GEN-LAST:event_jTextFieldSearchKeyReleased

    private void jTextFieldSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSearchActionPerformed
        jTextFieldSearch.setFocusable(true);
    }//GEN-LAST:event_jTextFieldSearchActionPerformed

    private void jTextFieldSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldSearchMouseClicked
        jTextFieldSearch.setFocusable(true);
    }//GEN-LAST:event_jTextFieldSearchMouseClicked

    private void jButtonViewDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonViewDetailsActionPerformed

        JDialogStudentPenaltiesDetails details = new JDialogStudentPenaltiesDetails(mainFrame, true, student, getStudentName());
        details.setVisible(true);
        jButtonViewDetails.setEnabled(false);
        student.setId(null);
        
    }//GEN-LAST:event_jButtonViewDetailsActionPerformed

    private void jButtonViewReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonViewReportActionPerformed
        JDialogPenaltyListReport report = new JDialogPenaltyListReport(mainFrame, true);
        report.setVisible(true);
    }//GEN-LAST:event_jButtonViewReportActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonViewDetails;
    private javax.swing.JButton jButtonViewReport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldSearch;
    // End of variables declaration//GEN-END:variables
    public DefaultTableModel tableModel = new DefaultTableModel() {
        public Class getColumnClass(int columnIndex) {
            if (columnIndex == 0) {
                return String.class;
            }
            switch (columnIndex) {
                case 1:
                    return String.class;
                case 2:
                    return String.class;
                case 3:
                    return Integer.class;
                case 4:
                    return Integer.class;
                case 5:
                    return Integer.class;
                default:
                    return String.class;
            }
        }

        public boolean isCellEditable(int row, int col) {
            if (col < 10) {
                return false;

            } else {
                return true;
            }
        }
    };
    private TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);

    public void setTable() {
        try {
            String[] columnNames = {
                "Id",//
                "StudentId",//1
                "Student",//2
                "Days",//3
                "Rate",//4
                "Penalty Days",//5
            };//15

            jTable1 = new javax.swing.JTable(tableModel);
            JTableHeader header = jTable1.getTableHeader();
            header.setPreferredSize(new Dimension(100, 35));
            header.setFont(new Font("Courier New", Font.PLAIN, 14));
            header.setBackground(new java.awt.Color(153, 153, 153));
            jTable1.addMouseListener(this);
            jTable1.setRowSorter(sorter);
            jTable1.setRowHeight(30);
            jTable1.setFont(new Font("Courier New", Font.PLAIN, 14));
//            jTable1.setCellSelectionEnabled(true);
            jTable1.setFocusable(false);
            for (int i = 0; i < columnNames.length;) {
                tableModel.addColumn(columnNames[i]);
                i++;
            }

            jScrollPane1.setViewportView(jTable1);

            TableColumn[] column = new TableColumn[100];

            column[0] = jTable1.getColumnModel().getColumn(0);
            column[0].setPreferredWidth(40);

            column[1] = jTable1.getColumnModel().getColumn(1);
            column[1].setPreferredWidth(250);

            column[2] = jTable1.getColumnModel().getColumn(2);
            column[2].setPreferredWidth(80);

            column[3] = jTable1.getColumnModel().getColumn(3);
            column[3].setPreferredWidth(80);

            column[3] = jTable1.getColumnModel().getColumn(4);
            column[3].setPreferredWidth(100);

            TableColumn hidden1 = jTable1.getColumnModel().getColumn(0);
            hidden1.setMinWidth(0);
            hidden1.setPreferredWidth(0);
            hidden1.setMaxWidth(0);
            TableColumn hidden2 = jTable1.getColumnModel().getColumn(1);
            hidden2.setMinWidth(0);
            hidden2.setPreferredWidth(0);
            hidden2.setMaxWidth(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == jTable1) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                if (e.getClickCount() == 2) {
                    int row = jTable1.getSelectedRow();
                    if (row != -1) {

                        Object idl = jTable1.getValueAt(row, 0);
                        Object studentIdl = jTable1.getValueAt(row, 1);
                        Object studentl = jTable1.getValueAt(row, 2);
                        student.setId(Integer.parseInt(studentIdl.toString()));
                        String s = studentl.toString();
                        setStudentName(s);

                        JDialogStudentPenaltiesDetails details = new JDialogStudentPenaltiesDetails(mainFrame, true, student, s);
                        details.setVisible(true);
                        jButtonViewDetails.setEnabled(false);

                    }

                } else if (e.getClickCount() == 1) {
                    int row = jTable1.getSelectedRow();
                    if (row != -1) {
                        Object idl = jTable1.getValueAt(row, 0);
                        Object studentIdl = jTable1.getValueAt(row, 1);
                        Object studentl = jTable1.getValueAt(row, 2);
                        student.setId(Integer.parseInt(studentIdl.toString()));
                        String s = studentl.toString();
                        setStudentName(s);

                        jButtonViewDetails.setEnabled(true);
                    }
                }
            }

        }
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void selectStudentBookBorrewed() {
        tableModel.setRowCount(0);
        query.selectStudentPenalties();
        for (int i = 0; i < query.getData().size(); i++) {
            tableModel.addRow((Vector) query.getData().get(i));
        }
    }

    /**
     * @return the studentName
     */
    public static String getStudentName() {
        return studentName;
    }

    /**
     * @param aStudentName the studentName to set
     */
    public static void setStudentName(String aStudentName) {
        studentName = aStudentName;
    }

}
