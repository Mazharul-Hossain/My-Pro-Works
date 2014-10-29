/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custommaingui;

/**
 *
 * @author Tamanna Afreen
 */
public class ValidationEngine {

    String[][] defaultString = {{"Enter Manual Serial Number", "Enter Manual Title", "Enter Author Name"},
    {"Enter the Manual Serial Number", "Enter Manual Title", "Enter Author Name"}};

    public Boolean checkString(String myString, int i, int j) {

        if (myString != null && !myString.isEmpty() && !myString.equalsIgnoreCase(defaultString[i][j])) {
            return true;
        }

        return false;
    }

    public Boolean checkInt(String myString, int i, int j) {

        if (checkString(myString, i, j)) {

            try {
                Integer.parseInt(myString);
            } catch (NumberFormatException e) {
                return false;
            }
            // only got here if we didn't return false
            return true;
        }
        return false;
    }

    String[] getMessage(int i) {
        if (i > -1 && i < 2) {
            return defaultString[i];
        } else {
            //To change body of generated methods, choose Tools | Templates.
            throw new UnsupportedOperationException("Not supported yet.");

        }
    }

    boolean checkString(String myString) {
        if (myString != null && !myString.isEmpty()) {
            return true;
        }
        return false;
    }

}
