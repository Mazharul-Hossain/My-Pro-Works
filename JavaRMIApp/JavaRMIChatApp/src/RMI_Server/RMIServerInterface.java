package RMI_Server;

import RMI_Client.RMIClientInterface;
import java.rmi.*;
import java.util.List;

/**
 * RMIServerInterface is an interface class for Server.
 * does all work like register a new user, authenticate an user 
 * passes message to desired user client chat area
 */
public interface RMIServerInterface extends Remote {

    /**
     * register
     * 
     * public abstract function for registering new user
     * 
     * @param user_name unique user name for an client
     * @param password authentication password
     * @return true for a successful registration
     *         false otherwise
     * 
     * @throws java.rmi.RemoteException
     **/
    public abstract boolean register(String user_name, String password) throws RemoteException;

    /**
     * sign_in
     * 
     * public abstract function for authenticating an user
     * 
     * @param user_name unique user name for an client
     * @param password authentication password
     * @param rmiClient reference of client's RMI interface class 
     * @return true for a successful sign in
     *         false otherwise
     * 
     * @throws java.rmi.RemoteException
     **/
    public abstract boolean sign_in(String user_name, String password, RMIClientInterface rmiClient) throws RemoteException;

    /**
     * getUserList
     * 
     * public abstract function for getting list of all authenticated users
     * 
     * @return list of all logged-in users
     * 
     * @throws java.rmi.RemoteException
     **/
    public abstract List getUserList() throws RemoteException;

    /**
     * chatUnicast
     * 
     * public abstract function for sending message to one user
     * 
     * @param sender_name sender user name
     * @param receiver_name receiver user name
     * @param msg message to pass on
     * 
     * @throws java.rmi.RemoteException
     **/
    public abstract void chatUnicast(String sender_name, String receiver_name, String msg) throws RemoteException;

    /**
     * chatBroadcast
     * 
     * public abstract function for sending message to all users
     * 
     * @param sender_name sender user name
     * @param msg message to pass on
     * 
     * @throws java.rmi.RemoteException
     **/
    public abstract void chatBroadcast(String sender_name, String msg) throws RemoteException;
}
