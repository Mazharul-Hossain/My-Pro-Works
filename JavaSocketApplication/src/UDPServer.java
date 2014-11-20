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

    ServerClientGUI serverClientGUI;

    public UDPServer(int Port, int size, String myfile, ServerClientGUI aThis) {

        serverPort = Port;
        myFileName = myfile;
        byteSize = size;

        serverClientGUI = aThis;
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

        serverClientGUI.ServerPrintMsg("Starting UDP listen()");

        try {
            serverSocket = new DatagramSocket(serverPort);

            File myFile = new File(myFileName);
            FileOutputStream fis = new FileOutputStream(myFile);
            BufferedOutputStream bos = new BufferedOutputStream(fis);

            byte[] receiveData = new byte[byteSize];
            byte[] sendData = new byte[byteSize];
            System.out.println("server byte size " + byteSize + " " + receiveData.length);
            int start = 0;
            int size = 0;

            while (listening) {

                serverClientGUI.ServerPrintMsg("Waiting for Packet size: " + receiveData.length + " ...");

                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                //process data
                //write to file
                System.out.println("server " + start + " " + receivePacket.getData().length);
                bos.write(receivePacket.getData(), 0, receivePacket.getData().length);

                bos.flush();

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
