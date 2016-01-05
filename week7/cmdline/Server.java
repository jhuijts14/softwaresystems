
package ss.week7.cmdline;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Server. 
 * @author  Theo Ruys
 * @version 2005.02.21
 */
public class Server {
    private static final String USAGE
        = "usage: " + Server.class.getName() + " <name> <port>";

    
    /** Starts a Server-application. */
    public static void main(String[] args) {
    	
    	if (args.length != 3) {
            System.out.println(USAGE);
            System.exit(0);
        }

        String name = args[0];
        InetAddress addr = null;
        int port = 0;
        Socket sock = null;
        ServerSocket serverSock = null;

        // check args[1] - the IP-adress
        try {
            addr = InetAddress.getByName(args[1]);
        } catch (UnknownHostException e) {
            System.out.println(USAGE);
            System.out.println("ERROR: host " + args[1] + " unknown");
            System.exit(0);
        }

        // parse args[2] - the port
        try {
            port = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.out.println(USAGE);
            System.out.println("ERROR: port " + args[2]
            		           + " is not an integer");
            System.exit(0);
        }
        
        try {
			serverSock = new ServerSocket(port);
			
		} catch (IOException e) {
			System.out.println(USAGE);
            System.out.println("ERROR: server socket " + serverSock
            		           + " could not be made on port " + port);
            System.exit(0);
		}
        
        // try to open a Socket to the client;
        try {
            sock = serverSock.accept();
        } catch (IOException e) {
            System.out.println("ERROR: did not get a client!");
        }

        // create Peer object and start the two-way communication
        try {
            Peer client = new Peer(name, sock);
            Thread streamInputHandler = new Thread(client);
            streamInputHandler.start();
            client.handleTerminalInput();
            client.shutDown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

} // end of class Server
