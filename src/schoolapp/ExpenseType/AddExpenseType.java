/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolapp.ExpenseType;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import schoolapp.utilities.JTextFieldLimit;
import schoolapp.utilities.Utility;

/**
 *
 * @author prohit
 */
public class AddExpenseType extends javax.swing.JFrame {

    private Connection connect;
    private PreparedStatement preparedStatement;

    /**
     * Creates new form AddExpenseType
     */
    public AddExpenseType() {
        initComponents();
   //     Utility.updateFrameTitle(this);
        expenseTypeText.setDocument(new JTextFieldLimit(40));
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
        expenseTypeText = new javax.swing.JTextField();
        addExpenseBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Add Expense Type");

        jLabel2.setText("Expense Type");

        expenseTypeText.setColumns(24);

        addExpenseBtn.setText("Add Expense Type");
        addExpenseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addExpenseBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabel2)
                        .addGap(49, 49, 49)
                        .addComponent(expenseTypeText, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(addExpenseBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jLabel1)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(expenseTypeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(addExpenseBtn)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addExpenseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addExpenseBtnActionPerformed
        
        try {
            if (expenseTypeText.getText().isEmpty()) {
                Utility.showError(this, "Expense Type field cannot be empty!");
                return;
            }
            // Setup the connection with the DB
            connect = Utility.getConnection();
            // Statements allow to issue SQL queries to the database

            // PreparedStatements can use variables and are more efficient
            preparedStatement = connect.prepareStatement("insert into  expense_type values (?);");
            // "myuser, webpage, datum, summery, COMMENTS from feedback.comments");
            // Parameters start with 1
            preparedStatement.setString(1, expenseTypeText.getText());
            preparedStatement.executeUpdate();
            
            Utility.showSuccess(this, "New Expense Type Added!");
            clearForm();
        } catch (MySQLIntegrityConstraintViolationException ex) {
            Utility.showError(this, "Expense Type " + expenseTypeText.getText() + " already exists!");
            
        } catch (ClassNotFoundException | SQLException ex) {
            Utility.showError(this, ex.getMessage());
        }
        Utility.closeStatement(this, preparedStatement, connect);
    }//GEN-LAST:event_addExpenseBtnActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addExpenseBtn;
    private javax.swing.JTextField expenseTypeText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

    private void clearForm() {
        expenseTypeText.setText("");
    }
}
