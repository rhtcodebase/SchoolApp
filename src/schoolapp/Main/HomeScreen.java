/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolapp.Main;

import java.sql.Connection;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import schoolapp.Expense.AddExpense;
import schoolapp.Expense.DeleteExpense;
import schoolapp.Expense.EditExpense;
import schoolapp.Expense.ViewExpense;
import schoolapp.ExpenseType.AddExpenseType;
import schoolapp.ExpenseType.DeleteExpenseType;
import schoolapp.ExpenseType.EditExpenseType;
import schoolapp.ExpenseType.ViewExpenseType;
import schoolapp.report.ViewBatchWiseReport;
import schoolapp.report.ViewIncome;
import schoolapp.report.ViewStudentReport;
import schoolapp.utilities.Utility;
import schoolapp.SMS.SMSService;
import schoolapp.certificates.StudyCertificate;

/**
 *
 * @author prohit
 */
public class HomeScreen extends javax.swing.JFrame {
   
    /**
     * Creates new form HomeScreen
     */
    public HomeScreen() {
        initComponents();
      //  Utility.updateFrameTitle(this);
        titleText.setText(Utility.SCHOOL_NAME);
        boolean isEnabled=true;
        if(Utility.getUser().equalsIgnoreCase("clerk")){
            isEnabled=false;
        }
       
        updateBtns(isEnabled);
                
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleText = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        expenseAddBtn = new javax.swing.JButton();
        expenseEditBtn = new javax.swing.JButton();
        expenseDeleteBtn = new javax.swing.JButton();
        expenseViewBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        SMS = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        consolidatedReportBtn = new javax.swing.JButton();
        batchWiseBtn = new javax.swing.JButton();
        studentReportBtn = new javax.swing.JButton();
        logOutBtn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        expenseTypeAddBtn = new javax.swing.JButton();
        expenseTypeDeleteBtn = new javax.swing.JButton();
        expenseTypeViewBtn = new javax.swing.JButton();
        expenseTypeEdit = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        studyCertificate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 0, 0));
        setForeground(new java.awt.Color(255, 51, 0));
        setLocationByPlatform(true);
        setResizable(false);

        titleText.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        titleText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Expense Operations", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(204, 0, 0));

        expenseAddBtn.setText("Add");
        expenseAddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expenseAddBtnActionPerformed(evt);
            }
        });

        expenseEditBtn.setText("Edit");
        expenseEditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expenseEditBtnActionPerformed(evt);
            }
        });

        expenseDeleteBtn.setText("Delete");
        expenseDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expenseDeleteBtnActionPerformed(evt);
            }
        });

        expenseViewBtn.setText("View");
        expenseViewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expenseViewBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(expenseAddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(expenseEditBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(expenseDeleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(expenseViewBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(expenseAddBtn)
                    .addComponent(expenseEditBtn)
                    .addComponent(expenseDeleteBtn)
                    .addComponent(expenseViewBtn))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SMS Service", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(204, 0, 0));

        SMS.setText("SMS");
        SMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SMSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(SMS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(145, 145, 145))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(SMS)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Income Report", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(204, 0, 0));

        consolidatedReportBtn.setText("Consolidated Report");
        consolidatedReportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consolidatedReportBtnActionPerformed(evt);
            }
        });

        batchWiseBtn.setText("Batch-Wise Report");
        batchWiseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batchWiseBtnActionPerformed(evt);
            }
        });

        studentReportBtn.setText("Student Report");
        studentReportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentReportBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(batchWiseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(studentReportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(consolidatedReportBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(batchWiseBtn)
                    .addComponent(studentReportBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(consolidatedReportBtn)
                .addContainerGap())
        );

        logOutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolapp/Main/log_off.png"))); // NOI18N
        logOutBtn.setText("Log Out");
        logOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutBtnActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Expense Type Operations", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel4.setForeground(new java.awt.Color(204, 0, 0));

        expenseTypeAddBtn.setText("Add");
        expenseTypeAddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expenseTypeAddBtnActionPerformed(evt);
            }
        });

        expenseTypeDeleteBtn.setText("Delete");
        expenseTypeDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expenseTypeDeleteBtnActionPerformed(evt);
            }
        });

        expenseTypeViewBtn.setText("View");
        expenseTypeViewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expenseTypeViewBtnActionPerformed(evt);
            }
        });

        expenseTypeEdit.setText("Edit");
        expenseTypeEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expenseTypeEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(expenseTypeAddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(expenseTypeEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(expenseTypeDeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(expenseTypeViewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(expenseTypeAddBtn)
                    .addComponent(expenseTypeEdit)
                    .addComponent(expenseTypeDeleteBtn)
                    .addComponent(expenseTypeViewBtn))
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Certificates", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel5.setForeground(new java.awt.Color(204, 0, 0));

        studyCertificate.setText("Study Certificate");
        studyCertificate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studyCertificateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(studyCertificate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(272, 272, 272))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(studyCertificate)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 38, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(logOutBtn)
                                    .addContainerGap())
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(44, 44, 44)))
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(titleText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleText, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logOutBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.getAccessibleContext().setAccessibleName("Certificates");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void consolidatedReportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consolidatedReportBtnActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ViewIncome viewIncome=new ViewIncome();
                viewIncome.setVisible(true);
            }
        });
    }//GEN-LAST:event_consolidatedReportBtnActionPerformed

    private void expenseViewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expenseViewBtnActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ViewExpense viewExpenseWindow=new ViewExpense();
                viewExpenseWindow.setVisible(true);
            }
        });
    }//GEN-LAST:event_expenseViewBtnActionPerformed

    private void expenseDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expenseDeleteBtnActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DeleteExpense deleteExpenseWindow=new DeleteExpense();
                deleteExpenseWindow.setVisible(true);
            }
        });
    }//GEN-LAST:event_expenseDeleteBtnActionPerformed

    private void expenseEditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expenseEditBtnActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditExpense editExpenseWindow=new EditExpense();
                editExpenseWindow.setVisible(true);
            }
        });

    }//GEN-LAST:event_expenseEditBtnActionPerformed

    private void expenseAddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expenseAddBtnActionPerformed

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddExpense addExpenseWindow=new AddExpense();
                addExpenseWindow.setVisible(true);
            }
        });

    }//GEN-LAST:event_expenseAddBtnActionPerformed

    private void logOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutBtnActionPerformed
        try {
            Connection connect = Utility.getConnection();
            if(!connect.isClosed()){
                connect.close();
            }
            setVisible(false);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(HomeScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HomeScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_logOutBtnActionPerformed

    private void batchWiseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batchWiseBtnActionPerformed
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ViewBatchWiseReport batchwiseReport=new ViewBatchWiseReport();
                batchwiseReport.setVisible(true);
            }
        });

    }//GEN-LAST:event_batchWiseBtnActionPerformed

    private void studentReportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentReportBtnActionPerformed
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ViewStudentReport viewStudentReport=new ViewStudentReport();
                viewStudentReport.setVisible(true);
            }
        });
    }//GEN-LAST:event_studentReportBtnActionPerformed

    private void SMSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SMSActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SMSService smsService=new SMSService();
                smsService.setVisible(true);
            }
        });
    }//GEN-LAST:event_SMSActionPerformed

    private void expenseTypeAddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expenseTypeAddBtnActionPerformed
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddExpenseType expenseTypeAdd =new AddExpenseType();
                expenseTypeAdd.setVisible(true);
            }
        });
    }//GEN-LAST:event_expenseTypeAddBtnActionPerformed

    private void expenseTypeDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expenseTypeDeleteBtnActionPerformed
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DeleteExpenseType expenseTypeDel =new DeleteExpenseType();
                expenseTypeDel.setVisible(true);
            }
        });
    }//GEN-LAST:event_expenseTypeDeleteBtnActionPerformed

    private void expenseTypeViewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expenseTypeViewBtnActionPerformed
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ViewExpenseType expenseTypeView=new ViewExpenseType();
                expenseTypeView.setVisible(true);
            }
        });
    }//GEN-LAST:event_expenseTypeViewBtnActionPerformed

    private void expenseTypeEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expenseTypeEditActionPerformed
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditExpenseType editExpenseType=new EditExpenseType();
                editExpenseType.setVisible(true);
            }
        });
    }//GEN-LAST:event_expenseTypeEditActionPerformed

    private void studyCertificateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studyCertificateActionPerformed
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                StudyCertificate sc=new StudyCertificate();
                sc.setVisible(true);
            }
        });
    }//GEN-LAST:event_studyCertificateActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SMS;
    private javax.swing.JButton batchWiseBtn;
    private javax.swing.JButton consolidatedReportBtn;
    private javax.swing.JButton expenseAddBtn;
    private javax.swing.JButton expenseDeleteBtn;
    private javax.swing.JButton expenseEditBtn;
    private javax.swing.JButton expenseTypeAddBtn;
    private javax.swing.JButton expenseTypeDeleteBtn;
    private javax.swing.JButton expenseTypeEdit;
    private javax.swing.JButton expenseTypeViewBtn;
    private javax.swing.JButton expenseViewBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton logOutBtn;
    private javax.swing.JButton studentReportBtn;
    private javax.swing.JButton studyCertificate;
    private javax.swing.JLabel titleText;
    // End of variables declaration//GEN-END:variables

    private void updateBtns(boolean isEnabled) {
        expenseDeleteBtn.setEnabled(isEnabled);
        expenseViewBtn.setEnabled(isEnabled);
        expenseTypeDeleteBtn.setEnabled(isEnabled);
        expenseTypeViewBtn.setEnabled(isEnabled);
        batchWiseBtn.setEnabled(isEnabled);
        studentReportBtn.setEnabled(isEnabled);
        consolidatedReportBtn.setEnabled(isEnabled);
    }
}
