package ss.week7.cmdline;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


/**
 * Peer for a simple client-server application.
 * @author  Theo Ruys
 * @version 2005.02.21
 */
public class Peer implements Runnable {
    public static final String EXIT = "exit";

    private static final String USAGE
    						= "usage: " + Server.class.getName() + " <name> <port>";
    
    protected String name;
    protected Socket sock;
    protected BufferedReader in;
    protected BufferedWriter out;


    /*@
       requires (nameArg != null) && (sockArg != null);
     */
    /**
     * Constructor. creates a peer object based in the given parameters.
     * @param   nameArg name of the Peer-proces
     * @param   sockArg Socket of the Peer-proces
     */
    public Peer(String nameArg, Socket sockArg) throws IOException {
    	this.name = nameArg;
    	this.sock = sockArg;
    	this.in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
    	this.out = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
    }

    /**
     * Reads strings of the stream of the socket-connection and
     * writes the characters to the default output.
     */
    public void run() {
    	handleStreamInput();
    }


    /**
     * Reads a string from the console and sends this string over
     * the socket-connection to the Peer process.
     * On Peer.EXIT the method ends
     */
    public void handleStreamInput() {
        	
    	try {
			
			String text = in.readLine();
				
			while (text != null) {
				System.out.println(text);
				text = in.readLine();
			}
			
			shutDown();
				
		} catch (IOException e) {
			System.out.println("Can't read data from Terminal!");
			e.printStackTrace();
		}
    }
    
    public void handleTerminalInput() {
    	try {
    		String msg = readString("> ");
    		while (msg != null && !msg.equals(Peer.EXIT)) {
    			out.write(getName() + ": " + msg);
    			out.newLine();
    			out.flush();
    			msg = readString("> ");
    		}
    		shutDown();
    	} catch (IOException e) {
    		shutDown();
    	}
    }

    /**
     * Closes the connection, the sockets will be terminated.
     */
    public void shutDown() {
    	try {
    		sock.close();
    	} catch (NullPointerException e) {
    		System.out.print("Closed");
    		System.exit(0);
    		

    	} catch (IOException e) {
    		System.out.println("The streams and socket couldn't be closed!");
    		e.printStackTrace();
    	}
    	
    	
    }

    /**  .
     * returns name of the peer object.
     */
    public String getName() {
        return name;
    }

    /** 
     * read a line from the default input.
     */
    static public String readString(String tekst) {
        System.out.print(tekst);
        String antw = null;
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    System.in));
            antw = in.readLine();
        } catch (IOException e) {
        }

        return (antw == null) ? "" : antw;
    }
    
    /**
     * Create a socket with a given port and address.
     */
    public Socket createSock(InetAddress address, int port) {
    	Socket socket = null;
    	try {
    		socket = new Socket(address, port);
    	} catch (IOException e) {
    		System.out.println("ERROR: could not create a socket on " + address
    						+ " and port " + port);
    	}

    	return socket;
    }
    
    /**
     * Check if an String is a port if so return it.
     */
    public int getPort(String portTemp) {
    	int port = 0;
    	try {
            port = Integer.parseInt(portTemp);
        } catch (NumberFormatException e) {
            System.out.println(USAGE);
            System.out.println("ERROR: port " + portTemp
            		           + " is not an integer");
            System.exit(0);
        }
    	
    	return port;
    }
    
    /**
     * Check if a String is a address.
     */
    public InetAddress getAddress(String address) {
    	InetAddress addr = null;
    	
    	try {
            addr = InetAddress.getByName(address);
        } catch (UnknownHostException e) {
            System.out.println(USAGE);
            System.out.println("ERROR: host " + address + " unknown");
            System.exit(0);
        }
		return addr;
    }
    
    
    
}
