/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custommaingui;

/**
 *
 * @author farshad
 */
import java.io.*;
import javax.swing.*;
import java.awt.*;

public class ManReader {
 
    private String RDR = new String();
    private String Ghorar_Anda = new String();
    
    public void UsrManRdr() {
        File file = new File("User_Manual.txt");
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        DataInputStream dis = null;
        try {
            fis = new FileInputStream(file);

            // Here BufferedInputStream is added for fast reading.
            bis = new BufferedInputStream(fis);
            dis = new DataInputStream(bis);

            // dis.available() returns 0 if the file does not have more lines.
            while (dis.available() != 0) {

                // this statement reads the line from the file and print it to
                // the console.
                //System.out.println(dis.readLine());
                RDR = dis.readLine();
                System.out.println(RDR);
                
                Ghorar_Anda += RDR + "\n";
                UserManPrintProgram.set_method(Ghorar_Anda);
            }
         //   System.out.println(Ghorar_Anda);
            // dispose all the resources after using them.
            fis.close();
            bis.close();
            dis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
