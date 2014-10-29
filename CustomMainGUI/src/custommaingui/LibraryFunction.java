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

    String tableName = "comments";

    public LibraryFunction() {
        dao = new MySQLAccess();
        dao.connectDataBase();
    }

    public String[][] Browse(int start, int limit) {
        String[][] resultData = null;
        try {
            String query = "Select * from `" + tableName + "`";
            query = query + " LIMIT " + start+ ", " + limit;
            System.out.println(query);

            ResultSet resultSet = dao.executeQuery(query);
            resultData = dao.readResultData(resultSet);
        } catch (Exception ex) {
            Logger.getLogger(LibraryFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultData;
    }

    public String[][] Search(String[] keys, String[] values) {
        String[][] resultData = null;
        try {
            String query = "Select * from  `" + tableName + "` where ";
            Boolean flag = false;
            for (int i = 0; i < keys.length; i++) {
                if (flag) {
                    query = query + " and " + keys[i] + " = '" + values[i] + "'";
                } else {
                    query = query + keys[i] + " = " + values[i];
                    flag = true;
                }
            }
            System.out.println(query);

            ResultSet resultSet = dao.executeQuery(query);
            resultData = dao.readResultData(resultSet);
        } catch (Exception ex) {
            Logger.getLogger(LibraryFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultData;
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
                query = query + ", " + value;
            } else {
                query = query + value;
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
        for (int i = 1; i < resultData.length; i++) {
            Object[] object = new Object[resultData[i].length];
            for (int j = 0; j < resultData[i].length; j++) {
                object[j] = resultData[i][j];
            }
            model.addRow(object);
        }
    }
}
