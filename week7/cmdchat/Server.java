package ss.week7.cmdchat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

/**
 * Server. 
 * @author  Theo Ruys
 * @version 2005.02.21
 */
public class Server {
    private static final String USAGE
            = "usage: " + Server.class.getName() + " <port>";

    /** Start een Server-applicatie op. */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println(USAGE);
            System.exit(0);
        }
        
        Server server = new Server(Integer.parseInt(args[0]));
        System.out.println("Server started.");
        server.run();
        
        
    }


    private int port;
    private List<ClientHandler> threads;
    private ServerSocket serverSocket;
    
    /** Constructs a new Server object. */
    public Server(int portArg) {
        
    	
    	this.port = portArg;
        
    	try {
    		serverSocket = new ServerSocket(this.port);
    	} catch (IOException e) {
    		System.out.println("Could not create a server socket from this port!");
    	}
        
        threads = new Vector<ClientHandler>();
    }
    
    /**
     * Listens to a port of this Server if there are any Clients that 
     * would like to connect. For every new socket connection a new
     * ClientHandler thread is started that takes care of the further
     * communication with the Client.
     */
    public void run() {
        while (true) {
        	try {
        		
        		Socket newClient = serverSocket.accept();
        		
        		ClientHandler newClientHandler = new ClientHandler(this, newClient);
        		System.out.println("Made a client handler");
        		newClientHandler.announce();
        		System.out.println("New client announced his/her name!");
        		this.addHandler(newClientHandler);
        		newClientHandler.start();
        		System.out.println("New client handler has started!");
        	
        	} catch (IOException e) {
        		System.out.println("Couldn't accept new socket!");
        	}
        	
        }
    }
    
    public void print(String message) {
        System.out.println(message);
    }
    
    /**
     * Sends a message using the collection of connected ClientHandlers
     * to all connected Clients.
     * @param msg message that is send
     */
    public void broadcast(String msg) {
        
    	for (int i = 0; i < threads.size(); i++) {
        	ClientHandler temp = threads.get(i);
        	System.out.println("Client Handler " + i);
        	temp.sendMessage(msg);
        }
    }
    
    /**
     * Add a ClientHandler to the collection of ClientHandlers.
     * @param handler ClientHandler that will be added
     */
    public void addHandler(ClientHandler handler) {
    	threads.add(handler);
    }
    
    /**
     * Remove a ClientHandler from the collection of ClientHanlders. 
     * @param handler ClientHandler that will be removed
     */
    public void removeHandler(ClientHandler handler) {
        threads.remove(handler);
        
    }
}
