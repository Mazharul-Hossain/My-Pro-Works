/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custommaingui;

/**
 *
 * @author Farshad This class is used to print the user manual to a Jtext area
 * of JFrame
 */
//Java library imports
import javax.swing.*;
import java.io.*;
import java.awt.*;

public class UserManPrintProgram extends JFrame {

    /**
     * The text area which is used for displaying logging information.
     */
    private JTextArea textArea;
    static String SET_VALUE;
    //   private JButton ExitButton = new JButton("EXIT");

    private PrintStream standardOut;

    //Constructor function
    public UserManPrintProgram() {

        super("User Manual Printing to TextArea");

        textArea = new JTextArea(80, 30);
        textArea.setEditable(false);

        PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));

        // keeps reference of standard output stream
        standardOut = System.out;

        // re-assigns standard output stream and error output stream
        System.setOut(printStream);
        System.setErr(printStream);

        /**
         * ***********************************************
         */
        // creates the GUI
        /**
         * ***********************************************
         */
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        /* Specify the row and column of upper left of the component.
         * gridx=0 indicates the top most column
         * gridy=0 indicates the top row
         */
     //   constraints.gridx = 0;
        //   constraints.gridy = 0;
        /*
         * insets Specifies the external padding of the component -- the minimum amount of space between the component and the edges of its display area. 
         * The value is specified as an Insets object. By default, each component has no external padding.
         */
    //    constraints.insets = new Insets(10,10,10,10);
        /*
         *anchor: Used when the component is smaller than its display area to determine where (within the area) to place the component. 
         *Valid values (defined as GridBagConstraints constants) are CENTER (the default), PAGE_START, PAGE_END, LINE_START, LINE_END, FIRST_LINE_START, FIRST_LINE_END, LAST_LINE_END, and LAST_LINE_START.
         *Here is a picture of how these values are interpreted in a container that has the default, left-to-right component orientation.
         FIRST_LINE_START	PAGE_START	FIRST_LINE_END
         LINE_START          CENTER          LINE_END
         LAST_LINE_START     PAGE_END        LAST_LINE_END
         */
     //   constraints.anchor = GridBagConstraints.WEST;

        //Add the EXIT button in position 0,0 of grid
        //  add(ExitButton, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        /*
         *gridwidth specify the number of column in the component display area
         *gridtheigth specify the number of row in the component display area
         *These constraints specify the number of cells the component uses
         */
        constraints.gridwidth = 2;
        /*
         *fill is used Used when the component's display area is larger than the component's requested size to determine whether and how to resize the component
         * Valid values: NONE (the default), HORIZONTAL (make the component wide enough to fill its display area horizontally, but do not change its height), VERTICAL (make the component tall enough to fill its display area vertically, but do not change its width), and BOTH (make the component fill its display area entirely)
         */
        constraints.fill = GridBagConstraints.BOTH;
        /*
         *weigthx and weighty: Specifying weights is an art that can have a significant impact on the appearance of the components a GridBagLayout controls. 
         *Weights are used to determine how to distribute space among columns (weightx) and among rows (weighty); this is important for specifying resizing behavior.
         */
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;

        //Add a JScrollPanel in the textArea
        add(new JScrollPane(textArea), constraints);
        //Print the output
        printLog();
        //close the window when x button is clicked
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set frame size
        setSize(800, 600);
        setLocationRelativeTo(null);    // centers on screen
        setVisible(true);
    }

    /**
     * Prints User Manual for testing in a thread
     */
    private void printLog() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(1 * 1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.out.println("\n" + SET_VALUE);
            }
        });
        thread.start();
    }

    //static function
    public static void set_method(String set_value) {
        SET_VALUE = set_value;

    }
}
