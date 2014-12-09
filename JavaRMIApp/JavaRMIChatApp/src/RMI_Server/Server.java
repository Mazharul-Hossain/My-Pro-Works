/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI_Server;

import java.net.MalformedURLException;
import java.rmi.Naming;
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

    public Server(int port) throws RemoteException, MalformedURLException {

        this.port = port;
        rmiRegistry = LocateRegistry.createRegistry(port);

        Naming.rebind("RMIchat", new RMIServer());
    }

    public Server() throws RemoteException, MalformedURLException {
        rmiRegistry = LocateRegistry.createRegistry(port);

        Naming.rebind("RMIchat", new RMIServer());
    }

    public void close() throws NoSuchObjectException {
        // deregister the registry
        if (rmiRegistry != null) {
            UnicastRemoteObject.unexportObject(rmiRegistry, true);
        }
    }
}
