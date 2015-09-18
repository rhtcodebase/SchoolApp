/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolapp.Expense;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import schoolapp.utilities.Utility;

/**
 *
 * @author prohit
 */
public class DeleteExpense extends javax.swing.JFrame {
    
    private int DESCRIPTION = 3;
    private int AMOUNT = 4;
    private Vector<Object> comboItems;
    private int EXPENSE_TYPE = 1;
    private int EXPENSE_DATE = 5;
    private int EXPENSE_NAME = 2;
    private Connection connection;
    private Statement stmt;
    private ResultSet rs;
    private Connection connect;
    private PreparedStatement preparedStatement;

    /**
     * Creates new form EditExpense
     */
    public DeleteExpense() {
        initComponents();
        Utility.updateFrameTitle(this);
        amountText.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.')) {
                    e.consume();  // ignore event
                }
            }
        });
        Vector<Object> columnNames = new Vector<Object>();
        Vector<Object> data = new Vector<Object>();
        //  Connect to an MySQL Database, run query, get result set

        String sql = "SELECT * FROM expense_type ;";

        // Java SE 7 has try-with-resources
        // This will ensure that the sql objects are closed when the program 
        // is finished with them
        try {
            connection = Utility.getConnection();
            stmt = (Statement) connection.createStatement();
            rs = stmt.executeQuery(sql);
            ResultSetMetaData md = (ResultSetMetaData) rs.getMetaData();
            int columns = md.getColumnCount();

            //  Get column names
            for (int i = 1; i <= columns; i++) {
                columnNames.add(md.getColumnName(i));
            }
            
            comboItems = new Vector<Object>();
            //  Get row data
            while (rs.next()) {
                comboItems.add(rs.getString(EXPENSE_TYPE));
                
            }
            
        } catch (SQLException | ClassNotFoundException e) {
            Utility.showError(this, e.toString());
        }
        Utility.closeConnections(this, connection, stmt, rs);
        DefaultComboBoxModel model = new DefaultComboBoxModel(comboItems);
        expenseTypeCombo.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        expenseIdText = new javax.swing.JTextField();
        searchExpenseBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        expenseTypeCombo = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionText = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        dateText = new com.toedter.calendar.JDateChooser();
        amountText = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        deleteBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Delete Expense");

        jLabel2.setText("Expense Id");

        searchExpenseBtn.setText("Search");
        searchExpenseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchExpenseBtnActionPerformed(evt);
            }
        });

        jLabel3.setText("Expense Type");

        expenseTypeCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Expense Description");

        descriptionText.setEditable(false);
        descriptionText.setColumns(20);
        descriptionText.setRows(5);
        jScrollPane1.setViewportView(descriptionText);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Date");

        amountText.setEditable(false);
        amountText.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setText("Amount");

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deleteBtn)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(dateText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(expenseTypeCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(searchExpenseBtn)
                                .addComponent(jScrollPane1)
                                .addComponent(amountText)
                                .addComponent(expenseIdText)))))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(expenseIdText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(searchExpenseBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(expenseTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel4)
                        .addGap(44, 44, 44)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amountText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(26, 26, 26)
                .addComponent(deleteBtn)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchExpenseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchExpenseBtnActionPerformed
        
        if (expenseIdText.getText().equals("")) {
            Utility.showError(this, "Please enter the expense ID!");
            clearForm();
            return;
        }
        
        Vector<Object> columnNames = new Vector<>();
        Vector<Object> data = new Vector<>();
        //  Connect to an MySQL Database, run query, get result set

        String sql = "SELECT * FROM expense where id=" + expenseIdText.getText() + ";";
        
        try {
            connection = Utility.getConnection();
            stmt = (Statement) connection.createStatement();
            rs = stmt.executeQuery(sql);
            
            ResultSetMetaData md = (ResultSetMetaData) rs.getMetaData();
            int columns = md.getColumnCount();

            //  Get column names
            for (int i = 1; i <= columns; i++) {
                columnNames.add(md.getColumnName(i));
            }
            
            boolean empty = true;
            while (rs.next()) {
                empty = false;
                descriptionText.setText(rs.getString(DESCRIPTION));
                amountText.setText(Double.toString(rs.getDouble(AMOUNT)));
                expenseTypeCombo.setSelectedItem(rs.getString(EXPENSE_NAME));
                dateText.setDate(rs.getDate(EXPENSE_DATE));
                break;
            }
            if (empty) {
                Utility.showError(this, "Found no expense matching id " + expenseIdText.getText());
                clearForm();
            }
        } catch (SQLException | ClassNotFoundException e) {
            Utility.showError(this, e.toString());
        }
        Utility.closeConnections(this, connection, stmt, rs);
    }//GEN-LAST:event_searchExpenseBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        if (expenseIdText.getText().isEmpty()) {
            Utility.showError(this, "Please provide the expense Id.");
            return;
        }
        try {
            connect = Utility.getConnection();
            // Statements allow to issue SQL queries to the database
            String sqlStmt = "DELETE FROM expense WHERE id='" + expenseIdText.getText() + "';";
            // PreparedStatements can use variables and are more efficient
            preparedStatement = connect.prepareStatement(sqlStmt);
            // "myuser, webpage, datum, summery, COMMENTS from feedback.comments");
            // Parameters start with 1
            Object[] options = {"Yes", "No"};
            int n = JOptionPane.showOptionDialog(this, "Do you like to delete the expense id  " + expenseIdText.getText() + " ?", "Remove Confirmation", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options);
            if (n == JOptionPane.YES_OPTION) {
                
                int affectedRows = preparedStatement.executeUpdate();
                if (affectedRows > 0) {
                    Utility.showSuccess(this, "Deleted the Expense!");
                    clearForm();
                    
                } else {
                    Utility.showError(this, "Nothing was Deleted. Please check the expense Id.");
                }
            }

//            preparedStatement.execute();
        } catch (SQLException | ClassNotFoundException ex) {
            Utility.showError(this, ex.toString());
        }
        Utility.closeStatement(this, preparedStatement, connect);
    }//GEN-LAST:event_deleteBtnActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField amountText;
    private com.toedter.calendar.JDateChooser dateText;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextArea descriptionText;
    private javax.swing.JTextField expenseIdText;
    private javax.swing.JComboBox expenseTypeCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton searchExpenseBtn;
    // End of variables declaration//GEN-END:variables

    private void clearForm() {
        amountText.setText("");
        dateText.setDate(null);
        descriptionText.setText("");
        expenseIdText.setText("");
    }
}
