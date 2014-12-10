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
import java.util.logging.Level;
import java.util.logging.Logger;

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
        try {
            return rmiServer.register(user_name, password);
        } catch (RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean sign_in(String user_name, String password, RMIClientInterface rmiClient) {
        try {
            return rmiServer.sign_in(user_name, password, rmiClient);
        } catch (RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List getUserList() {
        try {
            return rmiServer.getUserList();
        } catch (RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void chatUnicast(String my_user_name, String receiver_name, String msg) {
        try {
            rmiServer.chatUnicast(my_user_name, receiver_name, msg);
        } catch (RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void chatBroadcast(String my_user_name, String msg) {
        try {
            rmiServer.chatBroadcast(my_user_name, msg);
        } catch (RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
