/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms.gui.dialog;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.text.DecimalFormat;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import lms.gui.JFrameMainSLM;
import lms.model.Author;
import lms.model.Book;
import lms.model.Course;
import lms.model.Student;
import lms.util.QueryLMS;

/**
 *
 * @author Aldrin
 */
public class JDialogAddBookPhoto extends javax.swing.JDialog {

    private JFrameMainSLM mainMenu;
    private lms.util.QueryLMS query = new QueryLMS();
    private File pictureFile = null;
    private Course course = new Course();
    int IMG_WIDTH = 180;
    int IMG_HEIGHT = 240;
    private lms.model.Book book = new Book();
    private static String authors = "";
    private lms.model.BookPhoto bookPhoto = new lms.model.BookPhoto();
    private DecimalFormat df = new DecimalFormat("##,##0.00");

    /**
     * Creates new form JDialogStudentAU
     */
    public JDialogAddBookPhoto(lms.gui.JFrameMainSLM parent, boolean modal, lms.model.Book book) {
        super(parent, modal);
        this.mainMenu = parent;
        this.book = query.selectBookDetails(book);
        initComponents();
        jTextFieldTitle.setText(this.book.getTitle());
        jTextFieldDescription.setText(this.book.getDescription());
        jTextFieldISBN13.setText(this.book.getIsbn());
        jTextFieldSubject.setText(this.book.getSubjects());
        jTextFieldPrice.setText(String.valueOf(df.format(this.book.getPrice())));
        for (Author a : new QueryLMS().selectAuthorList(book.getId())) {
            String fname = a.getFirstname();
            String lname = a.getLastname();
            String mname = a.getMiddlename().substring(0, 1) + ".";
            setAuthors(getAuthors() + lname + ", " + fname + " " + mname);
            if (new QueryLMS().selectAuthorList(book.getId()).size() > 1) {
                setAuthors(getAuthors() + ",");
            }

        }
        jTextFieldAuthor.setText(getAuthors());
        setAuthors("");
        if (query.isBookPhotoNull(this.book) == true) {
            jLabelPicture.setText("");
            displayBookPicture();
        } else {
            jLabelPicture.setIcon(null);
            jLabelPicture.setText("No Photo");

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

        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldAuthor = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldPrice = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabelPicture = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldISBN13 = new javax.swing.JTextField();
        jTextFieldTitle = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldDescription = new javax.swing.JTextField();
        jTextFieldSubject = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Photo");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel4.setText("Photo");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 100, -1));

        jLabel8.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel8.setText("Author");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 100, -1));

        jTextFieldAuthor.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jTextFieldAuthor.setEnabled(false);
        getContentPane().add(jTextFieldAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 125, 410, -1));

        jLabel10.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel10.setText("Pricee");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 237, 100, -1));

        jTextFieldPrice.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jTextFieldPrice.setEnabled(false);
        getContentPane().add(jTextFieldPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 253, 130, -1));

        jLabel12.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel12.setText("ISBN-13");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 100, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabelPicture.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabelPicture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPicture.setText("No Photo");
        jLabelPicture.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPictureMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelPicture, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 35, 180, 240));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setPreferredSize(new java.awt.Dimension(610, 1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 606, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 610, 2));

        jButton1.setMnemonic('S');
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 300, 80, 30));

        jLabel14.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel14.setText("Title");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 100, -1));

        jTextFieldISBN13.setEditable(false);
        jTextFieldISBN13.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        getContentPane().add(jTextFieldISBN13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 35, 130, -1));

        jTextFieldTitle.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jTextFieldTitle.setEnabled(false);
        getContentPane().add(jTextFieldTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 85, 410, -1));

        jLabel11.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel11.setText("Description");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 100, -1));

        jTextFieldDescription.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jTextFieldDescription.setEnabled(false);
        getContentPane().add(jTextFieldDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 164, 410, -1));

        jTextFieldSubject.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jTextFieldSubject.setEnabled(false);
        getContentPane().add(jTextFieldSubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 207, 410, -1));

        jLabel13.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel13.setText("Subject");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 193, 100, -1));

        setSize(new java.awt.Dimension(657, 399));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            int reply = JOptionPane.showConfirmDialog(this,
                    "Are you sure  to photo of the book ?",
                    "Confirmation - Exit", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (reply == JOptionPane.YES_OPTION) {
                addPhotoToBook();
                this.dispose();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabelPictureMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPictureMouseClicked
        browse();
    }//GEN-LAST:event_jLabelPictureMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelPicture;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldAuthor;
    private javax.swing.JTextField jTextFieldDescription;
    private javax.swing.JTextField jTextFieldISBN13;
    private javax.swing.JTextField jTextFieldPrice;
    private javax.swing.JTextField jTextFieldSubject;
    private javax.swing.JTextField jTextFieldTitle;
    // End of variables declaration//GEN-END:variables

    private void browse() {
        try {
            int returnVal = jFileChooser1.showOpenDialog(this);
            if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
                pictureFile = jFileChooser1.getSelectedFile();

                int IMG_WIDTH = jLabelPicture.getWidth();
                int IMG_HEIGHT = jLabelPicture.getHeight();

                try {
                    BufferedImage originalImage = ImageIO.read(pictureFile);
                    int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

                    BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
                    Graphics2D g = resizedImage.createGraphics();
                    g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
                    g.dispose();
                    g.setComposite(AlphaComposite.Src);

                    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                    g.setRenderingHint(RenderingHints.KEY_RENDERING,
                            RenderingHints.VALUE_RENDER_QUALITY);
                    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);

                    jLabelPicture.setIcon(new ImageIcon(resizedImage)); //to eliminate .jpeg from picture filename
                    ImageIO.write(resizedImage, "png", new File("src\\lms\\images\\model.jpg"));

                } catch (final IOException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Opss...", JOptionPane.ERROR_MESSAGE);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return the authors
     */
    public static String getAuthors() {
        return authors;
    }

    /**
     * @param aAuthors the authors to set
     */
    public static void setAuthors(String aAuthors) {
        authors = aAuthors;
    }

    private void addPhotoToBook() {
        try {
            if (pictureFile == null) {
                bookPhoto.setId(book.getId());
                bookPhoto.setPhoto(new File(System.getProperty("user.dir") + "/src/lms/images/no photo.jpg"));
                query.addPhotoToBook(bookPhoto);
                JOptionPane.showConfirmDialog(null, "You're saving without picture", "Message", JOptionPane.PLAIN_MESSAGE);
            } else {
                bookPhoto.setId(book.getId());
                bookPhoto.setPhoto(new File(System.getProperty("user.dir") + "/src/lms/images/model.jpg"));
                query.addPhotoToBook(bookPhoto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void displayBookPicture() {
        try {
            Blob blobImage = (Blob) query.selectedBookPhoto(book);
            ImageIcon icon = new ImageIcon(blobImage.getBytes(1L, (int) blobImage.length()));

            Image image = icon.getImage();
            int type = BufferedImage.TYPE_INT_ARGB;

            BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
            Graphics2D g = resizedImage.createGraphics();
            g.drawImage(image, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
            g.dispose();
            g.setComposite(AlphaComposite.Src);

            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.setRenderingHint(RenderingHints.KEY_RENDERING,
                    RenderingHints.VALUE_RENDER_QUALITY);
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            jLabelPicture.setIcon(new ImageIcon(resizedImage));//image to label

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
