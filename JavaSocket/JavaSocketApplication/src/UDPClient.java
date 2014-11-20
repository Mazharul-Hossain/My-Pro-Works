/**
 *
 * @author Farshad
 */
import java.io.*;
import java.net.*;

public class UDPClient extends Thread implements Serializable {

    String serverName;
    int serverPort;
    int byteSize;
    InetAddress serverIPAddress;
    Socket clientSocket;
    
    public UDPClient(){}
    
    
    public static void main(String[] args) throws Exception {
        //get server address
        String serverName = "localhost";
        if (args.length >= 1) {
            serverName = args[0];
        }
        InetAddress serverIPAddress = InetAddress.getByName(serverName);
        //get server port
        int serverPort = 9876;
        if (args.length >= 2) {
            serverPort = Integer.parseInt(args[1]);
        }

        //create socket
        DatagramSocket clientSocket = new DatagramSocket();
        //get input from keyboard
        byte[] sendData = new byte[1024];
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        String sentence = inFromUser.readLine();

        //construct and send datagram
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverIPAddress, serverPort);
        clientSocket.send(sendPacket);

        //receive datagram
        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        //print output
        String sentenceFromServer = new String(receivePacket.getData());
        System.out.println("From Server: " + sentenceFromServer);
        //close client socket
        clientSocket.close();
    } //end of main

} //end of UDPClient
