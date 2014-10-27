/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.threeMusket.library_management;

import de.threeMusket.library_management.mysql.MySQLAccess;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mazhar
 */
public class LibraryFunction {

    MySQLAccess dao;

    public LibraryFunction() {
        MySQLAccess dao = new MySQLAccess();
        dao.connectDataBase();
    }
    public String[][] Browse(){
        try {
            String query = "";
            dao.executeQuery(query);
        } catch (Exception ex) {
            Logger.getLogger(LibraryFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } 

    public static void main(String[] args) throws Exception {

    }

}
