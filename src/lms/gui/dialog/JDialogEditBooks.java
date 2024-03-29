/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms.gui.dialog;

import lms.gui.dialog.au.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.JTextComponent;
import lms.model.Author;
import lms.model.Book;
import lms.model.BookAuthor;
import lms.model.CallNumberLine1;
import lms.model.Genre;
import lms.model.Publisher;
import lms.util.AutoSearch;
import lms.util.ComboBoxList;
import lms.util.QueryLMS;

/**
 *
 * @author admin
 */
public class JDialogEditBooks extends javax.swing.JDialog implements MouseListener {

    private lms.gui.JFrameMainSLM mainMenu;
    private lms.model.Book book;
    private ArrayList<lms.model.Author> authorList = new ArrayList<>();
    private QueryLMS query = new QueryLMS();
    private Publisher publisher = new Publisher();
    private CallNumberLine1 callNumberLine1 = new CallNumberLine1();
    private Genre genre = new Genre();
    private static int callNoL4Index;
    private BookAuthor bookAuthor = new BookAuthor();

    public JDialogEditBooks(lms.gui.JFrameMainSLM parent, boolean modal, lms.model.Book book, String title) {
        super(parent, modal);
        this.mainMenu = parent;
        this.book = book;
        initComponents();
        setTitle(title);
        setTable();
        jTextFieldISBN.setText(book.getIsbn());
        jTextFieldTitle.setText(book.getTitle());
        jTextFieldDescription.setText(book.getDescription());
        jTextFieldNotes.setText(book.getNotes());
        jTextFieldURL.setText(book.getUrl());
        jTextFieldQty.setText(String.valueOf(book.getQuantity()));
        jTextFieldSubject.setText(book.getSubjects());
        jTextFieldPrice.setText(String.valueOf(book.getPrice()));
        jTextFieldL2.setText(book.getCallNoLine2());
        jTextFieldL3.setText(book.getCallNoLine3());
        comboLine4();
        jComboBoxL4.setSelectedIndex(getCallNoL4Index());
        comboPublisher();
        for (ComboBoxList a : this.query.getList()) {
            a.setSelectedId(query.getList(), String.valueOf(book.getPublisher().getId()), jComboBoxPublisher);
        }
        comboCallNumberLine1();

        for (ComboBoxList a : this.query.getList()) {
            a.setSelectedId(query.getList(), String.valueOf(book.getCallNoLine1().getId()), jComboBoxLine1);
        }
        comboGenre();
        for (ComboBoxList a : this.query.getList()) {
            a.setSelectedId(query.getList(), String.valueOf(book.getGenre().getId()), jComboBoxGenre);
        }
        selectBookByAuthor(book.getId());
        jButtonRemove.setEnabled(false);
        jTextFieldQty.setEditable(false);
        jTextFieldPrice.setEditable(false);
        
    }

    public JDialogEditBooks(ArrayList<lms.model.Author> authorList) {
        this.authorList = authorList;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldISBN = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonRemove = new javax.swing.JButton();
        jButtonAdd = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldTitle = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldDescription = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldNotes = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldSubject = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldQty = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldPrice = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jComboBoxPublisher = new javax.swing.JComboBox<>();
        jButtonNew = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldURL = new javax.swing.JTextField();
        jTextFieldL2 = new javax.swing.JTextField();
        jTextFieldL3 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jComboBoxL4 = new javax.swing.JComboBox<>();
        jComboBoxLine1 = new javax.swing.JComboBox<>();
        jComboBoxGenre = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Books");

        jPanel2.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setMaximumSize(new java.awt.Dimension(402, 902));
        jScrollPane2.setMinimumSize(new java.awt.Dimension(402, 902));

        jPanel3.setMaximumSize(new java.awt.Dimension(400, 700));
        jPanel3.setMinimumSize(new java.awt.Dimension(400, 700));
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 600));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel1.setMinimumSize(new java.awt.Dimension(410, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(410, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Genre:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 80, 23));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("ISBN-13:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 23, 80, 23));
        jPanel1.add(jTextFieldISBN, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 23, 310, 23));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Title:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 80, 23));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Author"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 220, 110));

        jButtonRemove.setText("Remove");
        jButtonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 80, 30));

        jButtonAdd.setText("Add");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 103, 80, 30));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Author:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 80, 23));
        jPanel1.add(jTextFieldTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 310, 23));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Publisher:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 80, 23));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Description:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 80, 23));
        jPanel1.add(jTextFieldDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 310, 23));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Notes:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 80, 23));
        jPanel1.add(jTextFieldNotes, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 310, 23));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Subjects:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 80, 23));
        jPanel1.add(jTextFieldSubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 310, 23));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Quantity:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 80, 23));

        jTextFieldQty.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldQtyMouseClicked(evt);
            }
        });
        jPanel1.add(jTextFieldQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 310, 23));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Price:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 80, 23));

        jTextFieldPrice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldPriceMouseClicked(evt);
            }
        });
        jPanel1.add(jTextFieldPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 310, 23));

        jButton3.setMnemonic('S');
        jButton3.setText("Save");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 610, 70, 30));

        jComboBoxPublisher.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBoxPublisher, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 310, 23));

        jButtonNew.setText("New");
        jButtonNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 80, 30));

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("URL:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 80, 23));
        jPanel1.add(jTextFieldURL, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, 310, 23));
        jPanel1.add(jTextFieldL2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, 310, 23));
        jPanel1.add(jTextFieldL3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 490, 310, 23));

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Call No:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 80, 23));
        jPanel1.add(jComboBoxL4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 520, 310, 23));

        jComboBoxLine1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));
        jPanel1.add(jComboBoxLine1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, 310, 23));

        jPanel1.add(jComboBoxGenre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 550, 310, 23));

        jPanel3.add(jPanel1, java.awt.BorderLayout.CENTER);

        jScrollPane2.setViewportView(jPanel3);

        jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(490, 704));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveActionPerformed
        int i = jTable1.getSelectedRow();
        if (i < 0) {
            JOptionPane.showMessageDialog(null, "NO SELECTED ITEM", "EMPTY SELECTION", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (jTable1.getRowCount() == 1) {
            JOptionPane.showMessageDialog(null, "Book should have author!", "EMPTY SELECTION", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (confirm("REMOVE SELECTED ITEM?")) {
            DefaultTableModel tbl = (DefaultTableModel) jTable1.getModel();
            tbl.removeRow(i);
            jTable1.updateUI();
            query.deleteBookAuthor(bookAuthor);

        }
    }//GEN-LAST:event_jButtonRemoveActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        try {
            JDialogAddAuthorToList aatlist = new JDialogAddAuthorToList(mainMenu, true);
            aatlist.setVisible(true);
            setAuthorList(aatlist.getAuthorList());
            boolean duplicate = true;
            if (jTable1.getRowCount() == 0) {
                if (aatlist.getAuthorList() != null) {
                    addToTable();
                }
            } else {
                for (int i = 0; i < jTable1.getRowCount(); i++) {
                    Object authorId = jTable1.getValueAt(i, 0);
                    if (aatlist.getAuthorId() == null) {
                        JOptionPane.showMessageDialog(mainMenu, "Try again to select author.", "WARNING!!!", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    if (aatlist.getAuthorId() == Integer.parseInt(authorId.toString())) {
                        JOptionPane.showMessageDialog(mainMenu, "Author is already added.", "WARNING!!!", JOptionPane.WARNING_MESSAGE);
                        return;
                    } else {
                        duplicate = false;
                    }
                }
            }
            if (duplicate == false) {
                addToTable();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewActionPerformed
        JDialogAuthorAUD u = new JDialogAuthorAUD(mainMenu, true, "Add");
        u.setTitle("Add Author");
        u.setVisible(true);

    }//GEN-LAST:event_jButtonNewActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        updateBook();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextFieldQtyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldQtyMouseClicked
       JOptionPane.showMessageDialog(mainMenu, "Ask administrator if you want to change the quantity.", "WARNING!!!", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_jTextFieldQtyMouseClicked

    private void jTextFieldPriceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldPriceMouseClicked
        JOptionPane.showMessageDialog(mainMenu, "Ask administrator if you want to change the price.", "WARNING!!!", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_jTextFieldPriceMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    public javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonNew;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JComboBox<Object> jComboBoxGenre;
    private javax.swing.JComboBox<Object> jComboBoxL4;
    private javax.swing.JComboBox<Object> jComboBoxLine1;
    private javax.swing.JComboBox<Object> jComboBoxPublisher;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldDescription;
    private javax.swing.JTextField jTextFieldISBN;
    private javax.swing.JTextField jTextFieldL2;
    private javax.swing.JTextField jTextFieldL3;
    private javax.swing.JTextField jTextFieldNotes;
    private javax.swing.JTextField jTextFieldPrice;
    private javax.swing.JTextField jTextFieldQty;
    private javax.swing.JTextField jTextFieldSubject;
    private javax.swing.JTextField jTextFieldTitle;
    private javax.swing.JTextField jTextFieldURL;
    // End of variables declaration//GEN-END:variables

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

    public DefaultTableModel tableModel = new DefaultTableModel() {
        public Class getColumnClass(int columnIndex) {
            if (columnIndex == 0) {
                return String.class;
            }
            switch (columnIndex) {
                case 1:
                    return String.class;
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
                "Firstname",
                "Middlename",
                "Lastname",
                "Author"//1
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

            TableColumn hidden1 = jTable1.getColumnModel().getColumn(0);
            hidden1.setMinWidth(0);
            hidden1.setPreferredWidth(0);
            hidden1.setMaxWidth(0);
            TableColumn hidden2 = jTable1.getColumnModel().getColumn(1);
            hidden2.setMinWidth(0);
            hidden2.setPreferredWidth(0);
            hidden2.setMaxWidth(0);
            TableColumn hidden3 = jTable1.getColumnModel().getColumn(2);
            hidden3.setMinWidth(0);
            hidden3.setPreferredWidth(0);
            hidden3.setMaxWidth(0);
            TableColumn hidden4 = jTable1.getColumnModel().getColumn(3);
            hidden4.setMinWidth(0);
            hidden4.setPreferredWidth(0);
            hidden4.setMaxWidth(0);
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
                        Author author = new Author();
                        author.setId(Integer.parseInt(idl.toString()));
                        bookAuthor.setBook(book);
                        bookAuthor.setAuthor(author);
                        jButtonRemove.setEnabled(true);
                    }

                } else if (e.getClickCount() == 1) {
                    int row = jTable1.getSelectedRow();
                    if (row != -1) {
                        Object idl = jTable1.getValueAt(row, 0);
                        Author author = new Author();
                        author.setId(Integer.parseInt(idl.toString()));
                        bookAuthor.setBook(book);
                        bookAuthor.setAuthor(author);
                        jButtonRemove.setEnabled(true);
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

    private void selectStudentBookBorrewed() {
        tableModel.setRowCount(0);
        query.selectStudentPenalties();
        for (int i = 0; i < query.getData().size(); i++) {
            tableModel.addRow((Vector) query.getData().get(i));
        }
    }

    public void addToTable() {
        if (getAuthorList() == null) {
            return;
        } else {
            try {
                for (lms.model.Author a : getAuthorList()) {
                    tableModel.addRow(new Object[]{a.getId(), a.getFirstname(), a.getMiddlename(), a.getLastname(), a.getLastname() + ", " + a.getFirstname() + " " + a.getMiddlename() + "."});
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean confirm(String confirmMessage) {
        int ans = JOptionPane.showConfirmDialog(this, confirmMessage, "CONFIRMATION", JOptionPane.YES_NO_OPTION);
        return (ans == JOptionPane.YES_OPTION);
    }

    private void comboPublisher() {
        this.jComboBoxPublisher.removeAllItems();
        query.publisherComboBox();
        for (ComboBoxList a : query.getList()) {
            this.jComboBoxPublisher.addItem(a);
        }
    }

    private void fieldValidation() {

        try {
            if (jTable1.getRowCount() < 1) {
                JOptionPane.showMessageDialog(mainMenu, "No added author!!", "Warning!!!", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (jTextFieldISBN.getText().equals("") || jTextFieldTitle.getText().equals("") || jTextFieldDescription.getText().equals("") || jTextFieldNotes.getText().equals("") || jTextFieldSubject.getText().equals("") || jTextFieldQty.getText().equals("") || jTextFieldPrice.getText().equals("") || jTextFieldURL.getText().equals("") || jTextFieldL2.getText().equals("") || jTextFieldL3.getText().equals("")) {
                JOptionPane.showMessageDialog(mainMenu, "There's empty text field is not allowed!", "Warning!!!", JOptionPane.WARNING_MESSAGE);
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void comboCallNumberLine1() {
        this.jComboBoxLine1.removeAllItems();
        query.callNumberLine1ComboBox();
        for (ComboBoxList a : query.getList()) {
            this.jComboBoxLine1.addItem(a);
        }
    }

    private void comboLine4() {
        int year = 2022;
        for (int i = 0; year > 1950; --year, i++) {
            this.jComboBoxL4.addItem(year);
            Integer n = Integer.parseInt(book.getCallNoLine4());
            if (n == year) {
                setCallNoL4Index(i);
            }

        }
    }

    private void comboGenre() {
        this.jComboBoxGenre.removeAllItems();
        query.genreComboBox();
        for (ComboBoxList a : query.getList()) {
            this.jComboBoxGenre.addItem(a);
        }
    }

    private void addNewBookPerList() {
        try {
            if (jComboBoxPublisher.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(mainMenu, "No publisher selected!! try again.", "Warring!!", JOptionPane.WARNING_MESSAGE);
                return;
            } else {
                ComboBoxList publisherIdl = (ComboBoxList) this.jComboBoxPublisher.getSelectedItem();
                publisher.setId(Integer.parseInt(publisherIdl.getId()));
                publisher.setName(publisherIdl.getName());
            }

            if (jComboBoxLine1.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(mainMenu, "No call number line 1 selected!! try again.", "Warring!!", JOptionPane.WARNING_MESSAGE);
                return;
            } else {
                ComboBoxList callNumberL1l = (ComboBoxList) this.jComboBoxLine1.getSelectedItem();
                callNumberLine1.setId(Integer.parseInt(callNumberL1l.getId()));
                callNumberLine1.setDescription(callNumberL1l.getName());
            }

            if (jComboBoxGenre.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(mainMenu, "No genre selected!! try again.", "Warring!!", JOptionPane.WARNING_MESSAGE);
                return;
            } else {
                ComboBoxList genrel = (ComboBoxList) this.jComboBoxGenre.getSelectedItem();
                genre.setId(Integer.parseInt(genrel.getId()));
                genre.setGenre(genrel.getName());
            }

            setBook(new Book(jTextFieldISBN.getText(), jTextFieldTitle.getText(), getAuthorList(), publisher, jTextFieldDescription.getText(), jTextFieldNotes.getText(), jTextFieldSubject.getText(), Integer.parseInt(jTextFieldQty.getText()), Float.parseFloat(jTextFieldPrice.getText()), jTextFieldURL.getText(), callNumberLine1, jTextFieldL2.getText(), jTextFieldL3.getText(), jComboBoxL4.getSelectedItem().toString(), genre));
            dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return the book
     */
    public lms.model.Book getBook() {
        return book;
    }

    /**
     * @param book the book to set
     */
    public void setBook(lms.model.Book book) {
        this.book = book;
    }

    /**
     * @return the callNoL4Index
     */
    public static int getCallNoL4Index() {
        return callNoL4Index;
    }

    /**
     * @param aCallNoL4Index the callNoL4Index to set
     */
    public static void setCallNoL4Index(int aCallNoL4Index) {
        callNoL4Index = aCallNoL4Index;
    }

    private void selectBookByAuthor(Integer bookId) {
        tableModel.setRowCount(0);
        query.selectBookByAuthor(bookId);
        for (int i = 0; i < query.getData().size(); i++) {
            tableModel.addRow((Vector) query.getData().get(i));
        }
    }

    private void updateBook() {
        try {

            //1 ISBN 
            if (jTextFieldISBN.getText().isEmpty() == true) {
                JOptionPane.showMessageDialog(mainMenu, "ISBN field is empty!", "Try again!!", JOptionPane.WARNING_MESSAGE);
                return;
            } else {
                book.setIsbn(jTextFieldISBN.getText());
            }
            //2 Title
            if (jTextFieldTitle.getText().isEmpty() == true) {
                JOptionPane.showMessageDialog(mainMenu, "Title field is empty!", "Try again!!", JOptionPane.WARNING_MESSAGE);
                return;
            } else {
                book.setTitle(jTextFieldTitle.getText());
            }
//            //3 Publisher 
//            if (jComboBoxPublisher.getSelectedIndex() == 0) {
//                JOptionPane.showMessageDialog(mainMenu, "No publisher selected!! try again.", "Warring!!", JOptionPane.WARNING_MESSAGE);
//                return;
//            } else {
            ComboBoxList publisherIdl = (ComboBoxList) this.jComboBoxPublisher.getSelectedItem();
            publisher.setId(Integer.parseInt(publisherIdl.getId()));
            publisher.setName(publisherIdl.getName());
//            }
            book.setPublisher(publisher);
            //4 Description
            if (jTextFieldDescription.getText().isEmpty() == true) {
                JOptionPane.showMessageDialog(mainMenu, "Description field is empty!", "Try again!!", JOptionPane.WARNING_MESSAGE);
                return;
            } else {
                book.setDescription(jTextFieldDescription.getText());
            }
            //5 Notes
            if (jTextFieldNotes.getText().isEmpty() == true) {
                JOptionPane.showMessageDialog(mainMenu, "Notes field is empty!", "Try again!!", JOptionPane.WARNING_MESSAGE);
                return;
            } else {
                book.setNotes(jTextFieldNotes.getText());
            }
            //6 Subjects
            if (jTextFieldSubject.getText().isEmpty() == true) {
                JOptionPane.showMessageDialog(mainMenu, "Subjects field is empty!", "Try again!!", JOptionPane.WARNING_MESSAGE);
                return;
            } else {
                book.setSubjects(jTextFieldSubject.getText());
            }
            //7 Quantity
            if (jTextFieldQty.getText().isEmpty() == true) {
                JOptionPane.showMessageDialog(mainMenu, "Quantity field is empty!", "Try again!!", JOptionPane.WARNING_MESSAGE);
                return;
            } else {
                book.setQuantity(Integer.parseInt(jTextFieldQty.getText()));
            }
            //8 Price
            if (jTextFieldPrice.getText().isEmpty() == true) {
                JOptionPane.showMessageDialog(mainMenu, "Price field is empty!", "Try again!!", JOptionPane.WARNING_MESSAGE);
                return;
            } else {
                book.setPrice(Float.parseFloat(jTextFieldPrice.getText()));
            }
            //9 URL
            if (jTextFieldURL.getText().isEmpty() == true) {
                JOptionPane.showMessageDialog(mainMenu, "URL field is empty!", "Try again!!", JOptionPane.WARNING_MESSAGE);
                return;
            } else {
                book.setUrl(jTextFieldURL.getText());
            }
//            //10 CallLineNo 1
//            if (jComboBoxLine1.getSelectedIndex() == 0) {
//                JOptionPane.showMessageDialog(mainMenu, "No call number line 1 selected!! try again.", "Warring!!", JOptionPane.WARNING_MESSAGE);
//                return;
//            } else {
            ComboBoxList callNumberL1l = (ComboBoxList) this.jComboBoxLine1.getSelectedItem();
            callNumberLine1.setId(Integer.parseInt(callNumberL1l.getId()));
            callNumberLine1.setDescription(callNumberL1l.getName());
//            }
            book.setCallNoLine1(callNumberLine1);
            //11 CallNoLine2
            if (jTextFieldL2.getText().isEmpty() == true) {
                JOptionPane.showMessageDialog(mainMenu, "Call Number Line 2 field is empty!", "Try again!!", JOptionPane.WARNING_MESSAGE);
                return;
            } else {
                book.setCallNoLine2(jTextFieldL2.getText());
            }
            //12 CallNoLine 3
            if (jTextFieldL3.getText().isEmpty() == true) {
                JOptionPane.showMessageDialog(mainMenu, "Call Number Line 3 field is empty!", "Try again!!", JOptionPane.WARNING_MESSAGE);
                return;
            } else {
                book.setCallNoLine3(jTextFieldL3.getText());
            }
            //13 CallNoLine 4
            book.setCallNoLine4(jComboBoxL4.getSelectedItem().toString());
//            //14 Genre
//            if (jComboBoxGenre.getSelectedIndex() == 0) {
//                JOptionPane.showMessageDialog(mainMenu, "No genre selected!! try again.", "Warring!!", JOptionPane.WARNING_MESSAGE);
//                return;
//            } else {
            ComboBoxList genrel = (ComboBoxList) this.jComboBoxGenre.getSelectedItem();
            genre.setId(Integer.parseInt(genrel.getId()));
            genre.setGenre(genrel.getName());
//            }
            book.setGenre(genre);
            int response = JOptionPane.showConfirmDialog(mainMenu, "Are you sure to update the book details?", "Update book confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                query.updateBook(book);
            }

            //Update Author book
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                Integer authorId = (Integer) jTable1.getValueAt(i, 0);
                lms.model.Author author = new lms.model.Author();
                author.setId(authorId);
                bookAuthor.setAuthor(author);
                bookAuthor.setBook(book);
                if (query.isAuthortoThisBook(bookAuthor) == true) {
                    //do nothing
                } else {
                    query.updateBookAuthor(bookAuthor);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
