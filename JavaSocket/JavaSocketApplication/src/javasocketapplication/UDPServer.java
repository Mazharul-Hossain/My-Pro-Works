/**
 *
 * @author Farshad
 */
package javasocketapplication;

import java.io.*;
import java.net.*;
public class UDPServer {
    
    public static void main(String[] args) throws Exception{
        //see if we do not use default server port
        int serverPort = 9876;
        if (args.length >=1)
            serverPort  = Integer.parseInt(args[0]);
        //create server datagram socket
        DatagramSocket serverSocket = new DatagramSocket(serverPort);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        while(true){
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
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,IPAddress,port);
            //send
            serverSocket.send(sendPacket);
            
        } //end of while
    } //end of main 
} //end of UDP server
