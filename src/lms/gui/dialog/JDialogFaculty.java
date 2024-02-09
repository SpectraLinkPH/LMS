/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms.gui.dialog;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import lms.gui.JFrameMainSLM;
import lms.gui.dialog.au.JDialogFacultyAU;
import lms.model.Course;
import lms.model.Faculty;

/**
 *
 * @author Aldrin
 */
public class JDialogFaculty extends javax.swing.JDialog implements MouseListener {
    
    private JFrameMainSLM mainMenu;
    private Faculty faculty = new Faculty();
    private Course course = new Course();

    /**
     * Creates new form JDialogStudent
     */
    public JDialogFaculty(lms.gui.JFrameMainSLM parent, boolean modal) {
        super(parent, modal);
        this.mainMenu =parent;
        initComponents();
        setTable();
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
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldSearch = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jButtonAdd = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonAddBarcode = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Student Settings");

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        jPanel2.setPreferredSize(new java.awt.Dimension(1308, 40));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("   Faculty List");
        jPanel2.add(jLabel1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2, java.awt.BorderLayout.NORTH);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setPreferredSize(new java.awt.Dimension(748, 45));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel5.setPreferredSize(new java.awt.Dimension(450, 100));
        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 10, 10));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Search");
        jPanel5.add(jLabel2);

        jTextFieldSearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldSearch.setPreferredSize(new java.awt.Dimension(200, 30));
        jTextFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchKeyReleased(evt);
            }
        });
        jPanel5.add(jTextFieldSearch);

        jPanel4.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel6.setPreferredSize(new java.awt.Dimension(550, 72));
        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 10));

        jButtonAdd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonAdd.setMnemonic('A');
        jButtonAdd.setText("Add New");
        jButtonAdd.setPreferredSize(new java.awt.Dimension(110, 30));
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        jPanel6.add(jButtonAdd);

        jButtonUpdate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonUpdate.setMnemonic('U');
        jButtonUpdate.setText("Update");
        jButtonUpdate.setPreferredSize(new java.awt.Dimension(110, 30));
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });
        jPanel6.add(jButtonUpdate);

        jButtonDelete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonDelete.setMnemonic('D');
        jButtonDelete.setText("Delete");
        jButtonDelete.setPreferredSize(new java.awt.Dimension(110, 30));
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });
        jPanel6.add(jButtonDelete);

        jButtonAddBarcode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonAddBarcode.setMnemonic('D');
        jButtonAddBarcode.setText("Add Barcode");
        jButtonAddBarcode.setPreferredSize(new java.awt.Dimension(110, 30));
        jButtonAddBarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddBarcodeActionPerformed(evt);
            }
        });
        jPanel6.add(jButtonAddBarcode);

        jPanel4.add(jPanel6, java.awt.BorderLayout.WEST);

        jPanel3.add(jPanel4, java.awt.BorderLayout.NORTH);

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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1206, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(jPanel7, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1242, 566));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchKeyReleased
        String text = jTextFieldSearch.getText().trim();
        if (text.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text + ",*"));
        }
    }//GEN-LAST:event_jTextFieldSearchKeyReleased

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        JDialogFacultyAU u = new JDialogFacultyAU(mainMenu, true, "Add");
        u.setTitle("Add Student");
        u.setVisible(true);
        jButtonUpdate.setEnabled(false);
        jButtonDelete.setEnabled(false);
        jButtonAddBarcode.setEnabled(false);
        setTable();
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        lms.gui.dialog.au.JDialogFacultyAU u = new lms.gui.dialog.au.JDialogFacultyAU(mainMenu, true, "Update", this.faculty);
        u.setTitle("Update Student");
        u.setVisible(true);
        jButtonUpdate.setEnabled(false);
        jButtonDelete.setEnabled(false);
        jButtonAddBarcode.setEnabled(false);
        setTable();
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        lms.gui.dialog.au.JDialogFacultyAU u = new lms.gui.dialog.au.JDialogFacultyAU(mainMenu, true, this.faculty, "Delete");
        u.setTitle("Delete Student");
        u.setVisible(true);
        jButtonUpdate.setEnabled(false);
        jButtonDelete.setEnabled(false);
        jButtonAddBarcode.setEnabled(false);
        setTable();
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonAddBarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddBarcodeActionPerformed
//        JDialogStudentAddBarcode addBarcode = new JDialogStudentAddBarcode(mainMenu, true, faculty);
//        addBarcode.setVisible(true);
//        jButtonUpdate.setEnabled(false);
//        jButtonDelete.setEnabled(false);
//        jButtonAddBarcode.setEnabled(false);
//        setTable();
    }//GEN-LAST:event_jButtonAddBarcodeActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonAddBarcode;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonUpdate;
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
    DefaultTableModel tableModel = new DefaultTableModel() {
        public boolean isCellEditable(int row, int col) {
            return false;
        }
    };
    
    private TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);
    
    public void setTable() {
        try {
            Vector<String> colname = new Vector<String>();
            colname.add("Id");//0
            colname.add("Course Id");//1
            colname.add("Student");
            colname.add("Firsname");//3
            colname.add("Middlename");//4
            colname.add("Lastname");//5
            colname.add("Course");
            colname.add("Gender");
            colname.add("Email");
            colname.add("Mobile No");
            colname.add("DOB");
            colname.add("Date of Birth");
            colname.add("Address");
            colname.add("Guardian");
            
            ArrayList v1 = new lms.util.QueryLMS().selectStudent();
            Vector vector = new Vector(v1);
            jTable1 = new JTable(tableModel);
            JTableHeader header = jTable1.getTableHeader();
            header.setFont(new Font("Courier New", Font.PLAIN, 14));
            header.setBackground(new java.awt.Color(153, 153, 153));
            jTable1.setRowSorter(sorter);
            jTable1.addMouseListener(this);
            jTable1.setFont(new Font("Courier New", Font.PLAIN, 14));
            tableModel.setDataVector(vector, colname);
            jScrollPane1.setViewportView(jTable1);
            
            TableColumn[] column = new TableColumn[100];
            column[0] = jTable1.getColumnModel().getColumn(0);
            column[0].setPreferredWidth(0);
            column[2] = jTable1.getColumnModel().getColumn(2);
            column[2].setPreferredWidth(200);
            column[7] = jTable1.getColumnModel().getColumn(7);
            column[7].setPreferredWidth(50);
            column[8] = jTable1.getColumnModel().getColumn(8);
            column[8].setPreferredWidth(50);
            column[9] = jTable1.getColumnModel().getColumn(9);
            column[9].setPreferredWidth(200);
            column[10] = jTable1.getColumnModel().getColumn(10);
            column[10].setPreferredWidth(100);
            column[12] = jTable1.getColumnModel().getColumn(12);
            column[12].setPreferredWidth(100);
            column[13] = jTable1.getColumnModel().getColumn(13);
            column[13].setPreferredWidth(200);
            TableColumn hidden = jTable1.getColumnModel().getColumn(0);
            hidden.setMinWidth(0);
            hidden.setPreferredWidth(0);
            hidden.setMaxWidth(0);
            TableColumn hidden1 = jTable1.getColumnModel().getColumn(1);
            hidden1.setMinWidth(0);
            hidden1.setPreferredWidth(0);
            hidden1.setMaxWidth(0);
            TableColumn hidden2 = jTable1.getColumnModel().getColumn(3);
            hidden2.setMinWidth(0);
            hidden2.setPreferredWidth(0);
            hidden2.setMaxWidth(0);
            TableColumn hidden3 = jTable1.getColumnModel().getColumn(4);
            hidden3.setMinWidth(0);
            hidden3.setPreferredWidth(0);
            hidden3.setMaxWidth(0);
            TableColumn hidden4 = jTable1.getColumnModel().getColumn(5);
            hidden4.setMinWidth(0);
            hidden4.setPreferredWidth(0);
            hidden4.setMaxWidth(0);
            TableColumn hidden6 = jTable1.getColumnModel().getColumn(10);
            hidden6.setMinWidth(0);
            hidden6.setPreferredWidth(0);
            hidden6.setMaxWidth(0);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == jTable1) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                if (e.getClickCount() == 1) {
                    jButtonUpdate.setEnabled(true);
                    jButtonDelete.setEnabled(true);
                    jButtonAddBarcode.setEnabled(true);
                    int row = jTable1.getSelectedRow();
                    if (row != -1) {
                        String idl = (String) jTable1.getValueAt(row, 0);
                        String courseIdl = (String) jTable1.getValueAt(row, 1);
                        String studentl = (String) jTable1.getValueAt(row, 2);
                        String firstnamel = (String) jTable1.getValueAt(row, 3);
                        String middlenamel = (String) jTable1.getValueAt(row, 4);
                        String lastnamel = (String) jTable1.getValueAt(row, 5);
                        String coursel = (String) jTable1.getValueAt(row, 6);
                        String genderl = (String) jTable1.getValueAt(row, 7);
                        String emaill = (String) jTable1.getValueAt(row, 8);
                        String mobileNol = (String) jTable1.getValueAt(row, 9);
                        String dobl = (String) jTable1.getValueAt(row, 10);
                        String dobFl = (String) jTable1.getValueAt(row, 11);
                        String addressl = (String) jTable1.getValueAt(row, 12);
                        String guardianl = (String) jTable1.getValueAt(row, 13);
                        faculty.setId(Integer.parseInt(idl));
                        course.setId(Integer.parseInt(courseIdl));
                        faculty.setFirstname(firstnamel);
                        faculty.setMiddlename(middlenamel);
                        faculty.setLastname(lastnamel);
                        course.setAcronym(coursel);
                        faculty.setGender(genderl);
                        faculty.setEmail(emaill);
                        faculty.setMobileNo(mobileNol);
                        faculty.setDateOfBirth(dobl);
                        faculty.setAddress(addressl);
                        
                    }
                    jButtonUpdate.setEnabled(true);
                    jButtonDelete.setEnabled(true);
                    jButtonAddBarcode.setEnabled(true);
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
    
}