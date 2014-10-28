/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custommaingui;

import javax.swing.SwingUtilities;

/**
 *
 * @author Farshad
 */
public class Main_ManualReader {

    public static void PrintMan() {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UserManPrintProgram().setVisible(true);
            }
        });
        
        // TODO code application logic here
        //create an object of the ManualReader class
        ManReader manrd = new ManReader();

        // Call the ManReader function to read and print the manual in the console  
        manrd.UsrManRdr();
    }
}
