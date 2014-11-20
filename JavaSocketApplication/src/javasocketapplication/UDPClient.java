package javasocketapplication;

/**
 *
 * @author Farshad
 */
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UDPClient extends Thread implements Serializable {

    String serverName;
    int serverPort;
    int byteSize;
    InetAddress serverIPAddress;
    DatagramSocket clientSocket;
    File myFile;

    long startTime;
    long endTime;
    long duration;

    public UDPClient(String server, int port, int size, File file) {
        serverName = server;
        serverPort = port;
        byteSize = size;
        myFile = file;
    }

    @Override
    public void run() {
        connect();
    }

    void connect() {
        try {
            startTime = System.nanoTime();

            serverIPAddress = InetAddress.getByName(serverName);
            //create socket
            clientSocket = new DatagramSocket();

            fileSend();

            endTime = System.nanoTime();
            duration = (endTime - startTime);
        } //end of main
        catch (UnknownHostException | SocketException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fileSend() {

        try {
            FileInputStream fis = new FileInputStream(myFile);
            BufferedInputStream bis = new BufferedInputStream(fis);

            byte[] sendData = new byte[byteSize];
            byte[] receiveData = new byte[byteSize];

            int length = (int) myFile.length();
            int start = 0;
            int size = sendData.length;

            while (start < length) {
                if ((start + sendData.length) > length) {
                    size = length;
                } else {
                    size += sendData.length;
                }
                //read from file
                bis.read(sendData, start, size);

                //construct and send datagram
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverIPAddress, serverPort);
                clientSocket.send(sendPacket);

                //receive datagram
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                clientSocket.receive(receivePacket);

                start += sendData.length;
            }
            bis.close();
            fis.close();

            clientSocket.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TCPClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TCPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

} //end of UDPClient
