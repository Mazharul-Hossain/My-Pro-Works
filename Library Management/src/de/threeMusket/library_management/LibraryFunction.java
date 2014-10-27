/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.threeMusket.library_management;

import de.threeMusket.library_management.mysql.MySQLAccess;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mazhar
 */
public class LibraryFunction {

    MySQLAccess dao;

    public LibraryFunction() {
        dao = new MySQLAccess();
        dao.connectDataBase();
    }

    public String[][] Browse() {
        String[][] resultData = null;
        try {
            String query = "Select * from books";
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
            String query = "Select * from books where ";
            Boolean flag = false;
            for (int i = 0; i < keys.length; i++) {
                if (flag) {
                    query = query + " and " + keys[i] + " = " + values[i];
                } else {
                    query = query + keys[i] + " = " + values[i];
                    flag = true;
                }
            }
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

        String query = "Insert into books  ( ";
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
        int resultSet = dao.executeQueryUpdate(query);

        if (resultSet > 0) {
            result = true;
        }

        return result;
    }

    public static void main(String[] args) throws Exception {

    }

}
