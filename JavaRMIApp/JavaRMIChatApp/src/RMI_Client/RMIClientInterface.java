package RMI_Client;

import java.rmi.*;

public interface RMIClientInterface extends Remote {

    public void showChat(String sender_name, String msg);
}
