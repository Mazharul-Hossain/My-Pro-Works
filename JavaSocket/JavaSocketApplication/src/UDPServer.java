import java.io.IOException;
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
class UDPServer {

    int serverPort;
    ServerSocket serverSocket = null;
    boolean listening = true;

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
            serverSocket = new ServerSocket(serverPort);

            while (listening) {
                System.out.println("Server is listening");
                new ServerTCPThread(serverSocket.accept()).start();
            }
            serverSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(TCPServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
