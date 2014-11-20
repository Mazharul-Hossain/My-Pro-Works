package javasocketapplication;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
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
class UDPServer extends Thread implements Serializable {

    int serverPort;
    DatagramSocket serverSocket = null;
    boolean listening = true;
    int byteSize;

    String myFileName;

    public UDPServer(int Port, int size, String myfile) {
        serverPort = Port;
        myFileName = myfile;
        byteSize = size;
    }

    public void startListening() {
        listening = true;
    }

    public void stopListening() {
        listening = false;
    }

    @Override
    public void run() {
        connect();
    }

    public void connect() {

        try {
            serverSocket = new DatagramSocket(serverPort);

            File myFile = new File(myFileName);
            FileOutputStream fis = new FileOutputStream(myFile);
            BufferedOutputStream bos = new BufferedOutputStream(fis);

            byte[] receiveData = new byte[byteSize];
            byte[] sendData = new byte[byteSize];

            int start = 0;
            int size = 0;

            while (listening) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                //process data
                //write to file
                bos.write(receivePacket.getData(), start, start + receivePacket.getData().length);

                start += receivePacket.getData().length;
                
                sendData = receivePacket.getData();
                //determine client address and port
                InetAddress IPAddress = receivePacket.getAddress();
                int port = receivePacket.getPort();
                //construct datagram
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                //send
                serverSocket.send(sendPacket);
            }
            serverSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
