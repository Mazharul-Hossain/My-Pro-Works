package RMI_Server;

import RMI_Client.RMIClientInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * implements abstract class RMIServerInterface
 **/
public class RMIServer extends UnicastRemoteObject implements RMIServerInterface {

    Map<String, RMIClientInterface> map;

    MySQLAccess dao;

    public RMIServer() throws RemoteException {

        map = new ConcurrentHashMap<>();

        dao = new MySQLAccess();
    }

    /**
     * implementation of abstract method from abstract class RMIServerInterface
     **/
    @Override
    public synchronized boolean register(String user_name, String password) {

        boolean returnFlag = false;
        try {
            dao.connectDataBase();

            String query = "SELECT * FROM `users` WHERE `user_name` = '" + user_name + "'";
            ResultSet rs = dao.executeQuery(query);

            if (!rs.next()) {
                query = "INSERT INTO `users` (`user_name`, `password`) VALUES('" + user_name + "', MD5('" + password + "'))";
                int rsUpdate = dao.executeQueryUpdate(query);

                if (rsUpdate != 0) {
                    returnFlag = true;
                }
            }
            dao.close();

        } catch (SQLException ex) {
            Logger.getLogger(RMIServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnFlag;
    }

    /**
     * implementation of abstract method from abstract class RMIServerInterface
     **/
    @Override
    public synchronized boolean sign_in(String user_name, String password, RMIClientInterface rmiClient) {

        boolean returnFlag = false;
        try {
            dao.connectDataBase();

            String query = "SELECT * FROM `users` WHERE `user_name` = '" + user_name + "' AND `password` = MD5('" + password + "')";
            ResultSet rs = dao.executeQuery(query);

            if (rs.next()) {
                map.put(user_name, rmiClient);
                returnFlag = true;

                chatBroadcast("Server", "user \"" + user_name + "\" just joined the chat");
            }
            dao.close();

        } catch (SQLException ex) {
            Logger.getLogger(RMIServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnFlag;
    }

    /**
     * implementation of abstract method from abstract class RMIServerInterface
     **/
    @Override
    public synchronized List getUserList() {

        isUserAlive();

        List<String> keys = new ArrayList<>();

        for (String key : map.keySet()) {
            keys.add(key);
        }
        return keys;
    }

    /**
     * implementation of abstract method from abstract class RMIServerInterface
     **/
    @Override
    public synchronized void chatUnicast(String sender_name, String receiver_name, String msg) {

        try {
            RMIClientInterface rmiClient = map.get(receiver_name);

            if (rmiClient != null) {
                rmiClient.showChat(sender_name, msg);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(RMIServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * implementation of abstract method from abstract class RMIServerInterface
     **/
    @Override
    public synchronized void chatBroadcast(String sender_name, String msg) {

        isUserAlive();
        for (Map.Entry pairs : map.entrySet()) {
            try {
                RMIClientInterface rmiClient = (RMIClientInterface) pairs.getValue();

                if (rmiClient != null) {
                    rmiClient.showChat(sender_name, msg);
                }
            } catch (RemoteException ex) {
                Logger.getLogger(RMIServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * isUserAlive
     * 
     * protected function for checking alive users
     * 
     * iterate through map of all logged-in users to find out who are not 
     * connected anymore and remove them from map
     **/
    protected synchronized void isUserAlive() {

        String user_name = "";

        List<String> keys = new ArrayList<>();

        for (Map.Entry pairs : map.entrySet()) {
            try {
                RMIClientInterface rmiClient = (RMIClientInterface) pairs.getValue();
                user_name = (String) pairs.getKey();

                rmiClient.isAlive();
            } catch (RemoteException ex) {

                map.remove(user_name);
                keys.add(user_name);

                Logger.getLogger(RMIServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        bradcastLeave(keys);
    }

    /**
     *
     * @param leftClientUserName list of all people who have left
     *
     */
    protected void bradcastLeave(List leftClientUserName) {

        for (Object object : leftClientUserName) {
            String user_name = (String) object;

            chatBroadcast("Server", "user \"" + user_name + "\" just left the chat");
        }
    }
    
    /*===============================================
     *
     *===============================================*/

    /**
     * Executes mySQL query 
     * needed for login and sign up of users
     * no other work is done here
     **/
    public class MySQLAccess {

        /**
         * DB information 
         * 
         * @param dbServer saves the mySQL server host address
         * @param dbName saves the name of database
         * @param dbUserID user name for authentication in mySQL server
         * @param dbPass password for authentication
         **/
        private final String dbServer = "localhost";
        private final String dbName = "rmi_chat";
        private final String dbUserID = "root";
        private final String dbPass = "nopass123";

        /**
         * mySQL information
         * 
         * @param connect A connection (session) with a specific database. 
         *                SQL statements are executed and results are returned 
         *                within the context of a connection
         * @param statement The object used for executing a static SQL statement 
         *                  and returning the results it produces
         **/
        private Connection connect = null;
        private Statement statement = null;

        /**
         * connectDataBase
         * 
         * public function used to open an ODBC connection. 
         * Creates a session with the server to communicate with mySQL server. 
         * Creates statement object to execute query.
         **/
        public void connectDataBase() {
            try {
                System.out.println("this will load the MySQL driver, each DB has its own driver");
                Class.forName("com.mysql.jdbc.Driver");

                System.out.println("setup the connection with the DB");
                connect = DriverManager
                        .getConnection("jdbc:mysql://" + dbServer + "/" + dbName + "?"
                                + "user=" + dbUserID + "&password=" + dbPass);

                // statements allow to issue SQL queries to the database
                statement = connect.createStatement();

                System.out.println("MySQL connected");

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(MySQLAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        /**
         * executeQuery
         * 
         * public function to execute query
         * java supports select query only
         * 
         * @param query mySQL query as a string
         * @return ResultSet of query
         */
        
        public ResultSet executeQuery(String query) {
            try {
                System.out.println("MySQL query: " + query);

                ResultSet resultSetLocal = statement.executeQuery(query);
                return resultSetLocal;
            } catch (SQLException ex) {
                Logger.getLogger(MySQLAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }

        /**
         * executeQueryUpdate
         * 
         * public function to execute query
         * java supports insert update delete query
         * 
         * @param query mySQL query as a string
         * @return 0 for SQL statements that return nothing
         *         1 for the row count
         */
        
        public int executeQueryUpdate(String query) {
            int resultSetLocal = 0;
            try {
                System.out.println("MySQL query: " + query);

                resultSetLocal = statement.executeUpdate(query);
            } catch (SQLException ex) {
                Logger.getLogger(MySQLAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
            return resultSetLocal;
        }

        /**
         * close   
         * 
         * public function to safely close all connection with database
         **/
        private void close() {
            try {
                statement.close();
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(RMIServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
