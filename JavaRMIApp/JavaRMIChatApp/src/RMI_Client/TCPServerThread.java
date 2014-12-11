package RMI_Client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mazhar
 */
class TCPServerThread extends Thread implements Serializable {

    private Socket socket = null;
    File myFile = null;
    int byteSize;

    String myFileName;
    
    ClientGUI serverClientGUI;

    public TCPServerThread(Socket accept, int size, String myfile, ClientGUI aThis) {
        socket = accept;
        myFileName = myfile;
        byteSize = size;
        
        serverClientGUI = aThis;
    }

    @Override
    public void run() {
        fileReceive();
    }

    public void fileReceive() {
        try {
            File myFile = new File(myFileName);
            FileOutputStream fis = new FileOutputStream(myFile);

            byte[] mybytearray = new byte[byteSize];

            int byteReadSize = 0;
            int length = (int) myFile.length();
            int start = 0;
            int size = mybytearray.length;

            BufferedOutputStream bos = new BufferedOutputStream(fis);
            InputStream is = socket.getInputStream();

            while (true) {
                //read from socket
                byteReadSize = is.read(mybytearray, 0, mybytearray.length);
                if (byteReadSize > 0) {

                    //write to file
                    bos.write(mybytearray, 0, byteReadSize);

                    start += byteReadSize;
                    size += mybytearray.length;
                } else {
                    break;
                }
            }
            bos.flush();

            is.close();

            bos.close();
            fis.close();

            socket.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TCPClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TCPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void fileSend(File myFile) {

        try {
            FileInputStream fis;
            fis = new FileInputStream(myFile);

            byte[] mybytearray = new byte[byteSize];
            int length = (int) myFile.length();
            int start = 0;
            int size = mybytearray.length;

            BufferedInputStream bis = new BufferedInputStream(fis);
            OutputStream os = socket.getOutputStream();

            while (start < length) {
                if ((start + mybytearray.length) > length) {
                    size = length - start;
                }
                //read from file
                bis.read(mybytearray, start, size);

                //write to
                os.write(mybytearray, start, size);

                size += mybytearray.length;
            }
            os.flush();

            fis.close();
            bis.close();

            os.close();

            socket.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TCPClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TCPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
