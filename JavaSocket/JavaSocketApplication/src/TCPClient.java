import com.sun.security.ntlm.Client;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.NoSuchPaddingException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mazhar
 */
public class TCPClient {

    String serverName;
    int serverPort;
    int byteSize;
    InetAddress serverIPAddress;
    Socket clientSocket;

    public TCPClient(String server, int port, int size) {
        serverName = server;
        serverPort = port;
        byteSize = size;
    }

    public TCPClient(String server, int port) {
        serverName = server;
        serverPort = port;
        byteSize = 512;
    }

    public void connect() {
        try {
            serverIPAddress = InetAddress.getByName(serverName);
            clientSocket = new Socket(serverIPAddress, serverPort);
        } catch (UnknownHostException ex) {
            Logger.getLogger(TCPClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TCPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void fileReceive() {

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
            OutputStream os = clientSocket.getOutputStream();
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
            os.close();
            
            clientSocket.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TCPClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TCPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
