package RMI_Server;

import RMI_Client.RMIClientInterface;
import java.rmi.*;
import java.util.List;

public interface RMIServerInterface extends Remote {

    public boolean register(String user_name, String password);

    public boolean sign_in(String user_name, String password, RMIClientInterface rmiClient);

    public List getUserList();

    public void chatUnicast(String sender_name, String receiver_name, String msg);

    public void chatBroadcast(String sender_name, String msg);
}
