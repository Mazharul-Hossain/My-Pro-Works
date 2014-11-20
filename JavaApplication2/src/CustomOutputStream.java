/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Farshad This class is used to redirect the output stream from console
 * to a jtext area of JFrame
 */
//Java library imports
import java.io.*;
import javax.swing.*;

public class CustomOutputStream extends OutputStream {

    private JTextArea textArea;
    private String print_value;

    public CustomOutputStream(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void write(int b) throws IOException {
        // redirects data to the text area
        textArea.append(String.valueOf((char) b));
        // scrolls the text area to the end of data
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}
