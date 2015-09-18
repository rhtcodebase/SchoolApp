/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolapp.utilities;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.Frame;
import java.awt.print.PrinterException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author prohit
 */
public class Utility {
    private static final String url = "jdbc:mysql://localhost:3306/my_wk_db";
    private static final String userid = "root";
    private static final String password = "";

//    private static final String url = "";
//    private static final String userid = "";
//    private static final String password = "";
    private static String user = null;
    private static Connection connection = null;
    public static final String SMS_URL = "";
    public static final String SMS_UID = "";
    public static final String SMS_PIN = "";
    public static final String SMS_ROUTE = "";
    public static final String SMS_SENDER = "";
    public static final String USER_AGENT = "Mozilla/5.0";
//   
//    private static final String url = "jdbc:mysql://localhost:3306/pragathischool";
//    private static final String userid = "root";
//    private static final String password = "";

    public static String SCHOOL_NAME = "Rajeshwari Higher Primary English Medium School";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");
        connection = (Connection) DriverManager.getConnection(url, userid, password);

        return connection;
    }

    public static void showSuccess(Frame frame, String infoMsg) {
        JOptionPane.showMessageDialog(frame, infoMsg);
    }

    public static void showError(Frame frame, String erroString) {
        JOptionPane.showMessageDialog(frame, erroString, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void closeConnections(Frame frame, Connection connection, Statement stmt, ResultSet rs) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }

            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            showError(frame, e.toString());
        }

    }

    public static void closeStatement(Frame frame, PreparedStatement preparedStatement, Connection connect) {
        try {

            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connect != null && !connect.isClosed()) {
                connect.close();
            }
        } catch (SQLException e) {
            showError(frame, e.toString());
        }
    }

    public static void updateFrameTitle(Frame frame) {
        frame.setTitle(SCHOOL_NAME);
    }

    public static void setUser(String user) {
        Utility.user = user;
    }

    public static String getUser() {
        return Utility.user;
    }

    private static void printTable(Frame frame, JTable table, String headerText) {

        MessageFormat header = null;

        header = new MessageFormat(headerText);

        MessageFormat footer = null;

        footer = new MessageFormat("Page {0}");

        boolean fitWidth = true;
        boolean showPrintDialog = true;
        boolean interactive = true;

        /* determine the print mode */
        JTable.PrintMode mode = fitWidth ? JTable.PrintMode.FIT_WIDTH
                : JTable.PrintMode.NORMAL;

        try {
            /* print the table */
            boolean complete = table.print(mode, header, footer,
                    showPrintDialog, null,
                    interactive, null);

            /* if printing completes */
            if (complete) {
                /* show a success message */
                JOptionPane.showMessageDialog(frame,
                        "Printing Complete",
                        "Printing Result",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                /* show a message indicating that printing was cancelled */
                JOptionPane.showMessageDialog(frame,
                        "Printing Cancelled",
                        "Printing Result",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (PrinterException pe) {
            /* Printing failed, report to the user */
            JOptionPane.showMessageDialog(frame,
                    "Printing Failed: " + pe.getMessage(),
                    "Printing Result",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
