/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI_Server;

import java.rmi.AlreadyBoundException;
import java.rmi.NoSuchObjectException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Tamanna Afreen
 */
public class Server {

    int port = 6302;
    Registry rmiRegistry;

    ServerGUI serverGUI;

    public Server(String ip, int port, ServerGUI gui) throws RemoteException, AlreadyBoundException {

        serverGUI = gui;

        serverGUI.writeToTextArea("Server is starting in ip: " + ip + " and port: " + port + "\n");
        this.port = port;

        System.setProperty("java.rmi.server.hostname", ip);
        rmiRegistry = LocateRegistry.createRegistry(this.port);
        //rmiRegistry = LocateRegistry.getRegistry();

        rmiRegistry.rebind("RMIchat", new RMIServer());

        serverGUI.writeToTextArea("Server is listening........\n");
    }

    public void close() throws NoSuchObjectException {
        // deregister the registry
        if (rmiRegistry != null) {
            serverGUI.writeToTextArea("Server is stoping........\n");

            UnicastRemoteObject.unexportObject(rmiRegistry, true);

            serverGUI.writeToTextArea("Server is stoped\n");
        }
    }
}
