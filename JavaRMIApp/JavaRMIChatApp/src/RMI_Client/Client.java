/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI_Client;

import RMI_Server.RMIServerInterface;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

/**
 *
 * @author Tamanna Afreen
 */
public class Client {

    RMIServerInterface rmiServer;
    RMIClientInterface rmiClient;

    //ip = 54.173.191.128
    //port = 6302
    public Client(String ip, int port) throws RemoteException, NotBoundException {

        Registry registry = LocateRegistry.getRegistry(ip, port);
        rmiServer = (RMIServerInterface) registry.lookup("RMIchat");

        rmiClient = new RMIClient();
    }

    public boolean register(String user_name, String password) {
        return rmiServer.register(user_name, password);
    }

    public boolean sign_in(String user_name, String password, RMIClientInterface rmiClient) {
        return rmiServer.sign_in(user_name, password, rmiClient);
    }

    public List getUserList() {
        return rmiServer.getUserList();
    }

    public void chatUnicast(String my_user_name, String receiver_name, String msg) {
        rmiServer.chatUnicast(my_user_name, receiver_name, msg);
    }

    public void chatBroadcast(String my_user_name, String msg) {
        rmiServer.chatBroadcast(my_user_name, msg);
    }
}
