/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custommaingui;

import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mazhar
 */
public class LibraryFunction {

    MySQLAccess dao;

    String tableName = "books";

    int paginationIndex;
    int limit;

    public LibraryFunction() {
        dao = new MySQLAccess();
        dao.connectDataBase();
        limit = 10;
    }

    public LibraryFunction(int l) {
        dao = new MySQLAccess();
        dao.connectDataBase();
        limit = l;
    }

    public String[][] Browse(int start, int limit) {
        paginationIndex = start;
        try {
            String query = "Select * from `" + tableName + "`";
            query = query + " LIMIT " + start + ", " + limit;
            System.out.println(query);

            ResultSet resultSet = dao.executeQuery(query);
            String[][] resultData = dao.readResultData(resultSet);
            return resultData;
        } catch (Exception ex) {
            Logger.getLogger(LibraryFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String[][] Search(String[] keys, String[] values) {
        try {
            ValidationEngine vEngine = new ValidationEngine();

            String query = "Select * from  `" + tableName + "` where ";
            Boolean flag = false;

            for (int i = 0; i < keys.length; i++) {

                if (!vEngine.checkString(keys[i])) {
                    break;
                }

                if (flag) {
                    query = query + " and " + keys[i] + " = '" + values[i] + "'";
                } else {
                        query = query + keys[i] + " = '" + values[i] + "'";
                    flag = true;
                }
            }
            System.out.println(query);

            ResultSet resultSet = dao.executeQuery(query);
            String[][] resultData = dao.readResultData(resultSet);
            return resultData;
        } catch (Exception ex) {
            Logger.getLogger(LibraryFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Boolean Add(String[] keys, String[] values) {
        Boolean result = false;
        Boolean flag = false;

        String query = "Insert into " + tableName + "  ( ";
        for (String key : keys) {
            if (flag) {
                query = query + ", " + key;
            } else {
                query = query + key;
                flag = true;
            }
        }
        query = query + " ) Values ( ";
        flag = false;
        for (String value : values) {
            if (flag) {
                query = query + ", '" + value + "'";
            } else {
                query = query + " '" + value + "'";
                flag = true;
            }
        }
        query = query + " )";
        System.out.println(query);

        int resultSet = dao.executeQueryUpdate(query);

        if (resultSet > 0) {
            result = true;
        }

        return result;
    }

    public void addRow(JTable jtable, String[][] resultData) {

        DefaultTableModel model = (DefaultTableModel) jtable.getModel();

        int rowCount = model.getRowCount();
        //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        int i, j;
        ValidationEngine vEngine = new ValidationEngine();
        for (i = 1; i < resultData.length; i++) {
            Object[] object = new Object[resultData[i].length];
            for (j = 0; j < resultData[i].length; j++) {
                object[j] = resultData[i][j];
            }
            if (!vEngine.checkString(resultData[i][j - 1])) {
                break;
            }
            model.addRow(object);
        }
    }

    /**
     * Functions for paginations
     *
     * @return
     *
     */
    public String[][] BrowseFirst() {
        return Browse(0, limit);
    }

    public String[][] BrowseLast() {
        String query = "Select COUNT(*) from  `" + tableName + "`";

        System.out.println(query);

        ResultSet resultSet = dao.executeQuery(query);
        String[][] resultData = dao.readResultData(resultSet);

        int start = (Integer.parseInt(resultData[1][0]) / limit) * limit;
        System.out.println("start : " + start);
        return Browse(start, limit);
    }

    public String[][] BrowseNext() {
        String query = "Select COUNT(*) from  `" + tableName + "`";

        System.out.println(query);

        ResultSet resultSet = dao.executeQuery(query);
        String[][] resultData = dao.readResultData(resultSet);

        int totalMax = Integer.parseInt(resultData[1][0]);

        if (totalMax < (paginationIndex + limit)) {
            return BrowseLast();
        } else {
            return Browse((paginationIndex + limit), limit);
        }
    }

    public String[][] BrowsePrevious() {
        if (0 > (paginationIndex - limit)) {
            return BrowseFirst();
        } else {
            return Browse((paginationIndex - limit), limit);
        }
    }
}
