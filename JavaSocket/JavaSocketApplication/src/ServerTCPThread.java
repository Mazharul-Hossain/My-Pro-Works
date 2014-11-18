import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mazhar
 */
class ServerTCPThread extends Thread implements Serializable {

    private Socket socket = null;

    public ServerTCPThread(Socket accept) {
        super("ServerThread");
        socket = accept;
    }

    @Override
    public void run() {
        receivePacket();
    }

    public void receivePacket() {
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];

        TCPPacket receivePacket = new TCPPacket(receiveData, receiveData.length);
        socket.receive(receivePacket);
    }

}
