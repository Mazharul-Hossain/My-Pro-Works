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

    int fileSize;

    ServerClientGUI serverClientGUI;

    public UDPClient(String server, int port, int size, File file, ServerClientGUI aThis) {
        serverName = server;
        serverPort = port;
        byteSize = size;
        myFile = file;

        serverClientGUI = aThis;
    }

    @Override
    public void run() {
        connect();
    }

    void connect() {
        try {
            startTime = System.nanoTime();
            serverClientGUI.setClientStartTimeTextField(Long.toString(startTime));
            serverClientGUI.ClientPrintMsg("Starting transfer in: " + Long.toString(startTime));

            serverIPAddress = InetAddress.getByName(serverName);
            //create socket
            clientSocket = new DatagramSocket();

            fileSend();

            endTime = System.nanoTime();
            serverClientGUI.ClientPrintMsg("Finish transfer in: " + Long.toString(endTime));

            duration = (endTime - startTime);

            float speed = (fileSize / 1024) / duration;
            serverClientGUI.ClientPrintMsg("Speed: " + Float.toString(speed));

            serverClientGUI.setClientEndTimeTextField(Long.toString(endTime));
            serverClientGUI.setClientTransferTimeTextField(Long.toString(duration));
            serverClientGUI.setClientSpeedTextField(Float.toString(speed) + " KBps");

        } //end of main
        catch (UnknownHostException | SocketException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fileSend() {
        serverClientGUI.ClientPrintMsg("Sending file: " + myFile.getName());

        try {
            FileInputStream fis = new FileInputStream(myFile);
            BufferedInputStream bis = new BufferedInputStream(fis);

            byte[] sendData = new byte[byteSize];
            byte[] receiveData = new byte[byteSize];

            int fileSize = (int) myFile.length();
            int start = 0;
            int size = sendData.length;

            while (start < fileSize) {
                if ((start + sendData.length) > fileSize) {
                    size = fileSize - start;
                }
                System.out.println("client " + start + " " + size);
                //read from file
                bis.read(sendData, 0, size);

                //construct and send datagram
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverIPAddress, serverPort);
                serverClientGUI.ClientPrintMsg("Sending packet size to server:" + Integer.toString(sendData.length));
                clientSocket.send(sendPacket);

                //receive datagram
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                clientSocket.receive(receivePacket);
                serverClientGUI.ClientPrintMsg("Got response packet");

                start += sendData.length;
            }
            serverClientGUI.ClientPrintMsg("Sending len to server: " + Integer.toString(size));
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
