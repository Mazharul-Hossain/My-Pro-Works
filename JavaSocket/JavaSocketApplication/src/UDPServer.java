import java.io.IOException;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
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
class UDPServer extends Thread implements Serializable{

    int serverPort;
    DatagramSocket serverSocket = null;
    boolean listening = true;
    int byteSize;

    public UDPServer(int Port) {
        serverPort = Port;
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

            byte[] receiveData = new byte[byteSize];
            byte[] sendData = new byte[byteSize];

            while (listening) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                //process data
                String sentence = new String(receivePacket.getData());
                String capitalizedSentence = sentence.toUpperCase();
                sendData = capitalizedSentence.getBytes();
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
            Logger.getLogger(TCPServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
