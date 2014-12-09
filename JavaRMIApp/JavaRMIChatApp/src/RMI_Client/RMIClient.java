/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI_Client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Tamanna Afreen
 */
public class RMIClient extends UnicastRemoteObject implements RMIClientInterface {

    public RMIClient() throws RemoteException {
    }

    @Override
    public void showChat(String sender_name, String msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
