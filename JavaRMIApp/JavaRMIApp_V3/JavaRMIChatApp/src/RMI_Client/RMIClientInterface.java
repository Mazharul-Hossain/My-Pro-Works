package RMI_Client;

import java.rmi.*;

public interface RMIClientInterface extends Remote {

    /**
     * showChat
     * 
     * public abstract function for showing chat message in chat text area     
     * 
     * @param sender_name sender user name
     * @param msg message to show
     * 
     * @throws java.rmi.RemoteException
     **/
    public abstract void showChat(String sender_name, String msg) throws RemoteException;
    
    /**
     * isAlive
     * 
     * public abstract function for server to check whether 
     * this client is alive or not
     * 
     * @throws java.rmi.RemoteException
     **/
    public abstract void isAlive() throws RemoteException;
}
