
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class RecentTransactions extends javax.swing.JFrame {

    User loggedUser;
    Node data;

    public RecentTransactions(User loggedUser, Node data) {
        this.loggedUser = loggedUser;
        this.data = data;
        setIconImage();
        initComponents();
        addRowToJTable();
    }

    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/favicon.png")));
    }

    public void addRowToJTable() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        Object objData[] = new Object[4];
        Node tempdata;
        tempdata = data;
        while (tempdata != null) {
//            if (userTransaction.isEmpty()) {
//                break;
//            }

            objData[0] = tempdata.mode;
            objData[1] = tempdata.amount;
            objData[2] = tempdata.date;
            objData[3] = tempdata.purpose;
            model.addRow(objData);
            tempdata = tempdata.next;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        pdf = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Recent Transactions - Sukoon Finance App");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(219, 228, 238));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(180, 34, 242));
        jLabel1.setText("Recent Transactions");

        jTable1.setBackground(new java.awt.Color(45, 49, 66));
        jTable1.setForeground(new java.awt.Color(219, 228, 238));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Mode", "Amount", "Date", "Purpose"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        pdf.setText("Generate PDF");
        pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(250, 250, 250)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(285, 285, 285)
                                .addComponent(pdf)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pdf)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfActionPerformed
        String filename = "";
        int rows = -1;
        filename = JOptionPane.showInputDialog(rootPane, "Enter File Name: ");
        while (rows <= 0) {
            try {
                rows = Integer.parseInt(JOptionPane.showInputDialog(rootPane, "How many Transactions you want to export: (0 = All Transactions)"));
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(rootPane, "Input is null");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(rootPane, "Input should be number");
            }
        }
        //        JFileChooser j = new JFileChooser();
        //        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //        int x = j.showSaveDialog(this);
        //        if (x == JFileChooser.APPROVE_OPTION) {
        //            dest = j.getSelectedFile().getPath();
        //        }
        Document doc = new Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(filename + ".pdf"));
            doc.open();
            PdfPTable tbl = new PdfPTable(4);
            tbl.addCell("Date");
            tbl.addCell("Mode");
            tbl.addCell("Amount");
            tbl.addCell("Purpose");
            if (rows == 0) {
                rows = jTable1.getRowCount();
            }
            for (int i = 0; i < rows; i++) {
                if (data == null) {
                    break;
                }
                String mode = jTable1.getValueAt(i, 0).toString();
                String amount = jTable1.getValueAt(i, 1).toString();
                String date = jTable1.getValueAt(i, 2).toString();
                String purpose = jTable1.getValueAt(i, 3).toString();
                tbl.addCell(date);
                tbl.addCell(mode);
                tbl.addCell(amount);
                tbl.addCell(purpose);
            }

            Paragraph paragraph = new Paragraph(
                    "Sukoon Finance App", new Font(Font.FontFamily.HELVETICA, 25, Font.BOLD, BaseColor.BLUE));
            doc.add(paragraph);
            doc.add(Chunk.SPACETABBING);
            Paragraph details = new Paragraph(
                    "Name: " + loggedUser.getName() + "\nRole: " + loggedUser.getRole(), new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.DARK_GRAY));
            doc.add(details);
            doc.add(Chunk.SPACETABBING);
            doc.add(tbl);
            doc.close();
            JOptionPane.showMessageDialog(null, "PDF Generated!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something Went Wrong!");
        }
    }//GEN-LAST:event_pdfActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton pdf;
    // End of variables declaration//GEN-END:variables

}
