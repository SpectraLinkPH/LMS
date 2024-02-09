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
import lms.model.Author;

/**
 *
 * @author Aldrin
 */
public class JDialogAddAuthorToList extends javax.swing.JDialog implements MouseListener{

    private lms.model.Author author = new lms.model.Author();
    private ArrayList<lms.model.Author> authorList;
    private static Integer authorId;

    /**
     * Creates new form JDialogAddAuthorToList
     */
    public JDialogAddAuthorToList(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonClose = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldSearch = new javax.swing.JTextField();
        jButtonOK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Author");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Author", "Select"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 73, 336, 152));

        jButtonClose.setMnemonic('C');
        jButtonClose.setText("Close");
        getContentPane().add(jButtonClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 90, 30));

        jLabel1.setText("Search:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 39, -1, 23));

        jTextFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchKeyReleased(evt);
            }
        });
        getContentPane().add(jTextFieldSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 290, 23));

        jButtonOK.setMnemonic('O');
        jButtonOK.setText("OK");
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 90, 30));

        setSize(new java.awt.Dimension(381, 330));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchKeyReleased
        String text = jTextFieldSearch.getText().trim();
        if (text.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text + ",*"));
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSearchKeyReleased

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        addAuthorToList();
        dispose();
    }//GEN-LAST:event_jButtonOKActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldSearch;
    // End of variables declaration//GEN-END:variables
    DefaultTableModel tableModel = new DefaultTableModel() {
        public boolean isCellEditable(int row, int col) {
            if (col == 5) {
                return true;
            } else {
                return false;
            }
        }

        public Class getColumnClass(int columnIndex) {
            switch (columnIndex) {
                case 1:
                    return Integer.class;
                case 2:
                    return String.class;
                case 3:
                    return String.class;
                case 4:
                    return String.class;
                case 5:
                    return Boolean.class;
                default:
                    return String.class;
            }
        }

    };

    private TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);

    public void setTable() {
        try {
            Vector<String> colname = new Vector<String>();
            colname.add("Id");
            colname.add("Firsname");
            colname.add("Middlename");
            colname.add("Lastname");
            colname.add("Author");
            colname.add("Select");

            ArrayList v1 = new lms.util.QueryLMS().selectAuthor();
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
            column[4] = jTable1.getColumnModel().getColumn(4);
            column[4].setPreferredWidth(300);
            column[5] = jTable1.getColumnModel().getColumn(5);
            column[5].setPreferredWidth(100);
            TableColumn hidden = jTable1.getColumnModel().getColumn(0);
            hidden.setMinWidth(0);
            hidden.setPreferredWidth(0);
            hidden.setMaxWidth(0);
            TableColumn hidden1 = jTable1.getColumnModel().getColumn(1);
            hidden1.setMinWidth(0);
            hidden1.setPreferredWidth(0);
            hidden1.setMaxWidth(0);
            TableColumn hidden2 = jTable1.getColumnModel().getColumn(2);
            hidden2.setMinWidth(0);
            hidden2.setPreferredWidth(0);
            hidden2.setMaxWidth(0);
            TableColumn hidden3 = jTable1.getColumnModel().getColumn(3);
            hidden3.setMinWidth(0);
            hidden3.setPreferredWidth(0);
            hidden3.setMaxWidth(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == jTable1) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                if (e.getClickCount() == 1) {
                    jButtonOK.setEnabled(true);
                    jButtonClose.setEnabled(true);
                    int row = jTable1.getSelectedRow();
                    if (row != -1) {

                        Object idl = jTable1.getValueAt(row, 0);
                        Object firsnamel = jTable1.getValueAt(row, 1);
                        Object middlenamel = jTable1.getValueAt(row, 2);
                        Object lastnamel = jTable1.getValueAt(row, 3);
                        author.setId(Integer.parseInt(idl.toString()));
                        author.setFirstname(firsnamel.toString());
                        author.setMiddlename(middlenamel.toString());
                        author.setLastname(lastnamel.toString());
                        setAuthorId(Integer.parseInt(idl.toString()));

                    }
                    jButtonOK.setEnabled(true);
                    jButtonClose.setEnabled(true);
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

    /**
     * @return the authorList
     */
    public ArrayList<lms.model.Author> getAuthorList() {
        return authorList;
    }

    /**
     * @param authorList the authorList to set
     */
    public void setAuthorList(ArrayList<lms.model.Author> authorList) {
        this.authorList = authorList;
    }

    private void addAuthorToList() {
        this.setAuthorList(new ArrayList<>());
        Author a;
        try {
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                if ((Boolean) jTable1.getValueAt(i, 5)==null) {
                } else {
                   a = new Author(Integer.parseInt(jTable1.getValueAt(i, 0).toString()), jTable1.getValueAt(i, 1).toString(), jTable1.getValueAt(i, 2).toString(), jTable1.getValueAt(i, 3).toString());
                    getAuthorList().add(a);
                }    
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return the authorId
     */
    public static Integer getAuthorId() {
        return authorId;
    }

    /**
     * @param aAuthorId the authorId to set
     */
    public static void setAuthorId(Integer aAuthorId) {
        authorId = aAuthorId;
    }

  

}
