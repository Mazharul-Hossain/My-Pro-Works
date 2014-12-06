/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI_Server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author Tamanna Afreen
 */
public class Server {

    int port = 6302;

    public Server(int port) throws RemoteException {
        LocateRegistry.createRegistry(port);
    }

    public Server()  throws RemoteException {
        LocateRegistry.createRegistry(port);
    }

    public static void main(String args[]) {

        
    }

}
