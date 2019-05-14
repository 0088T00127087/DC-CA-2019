package Client_pkg;

import wrappers.MyStreamSocket;

import java.net.*;
import java.io.*;

/**
 * This class is a module which provides the application logic
 * for an Echo client using stream-mode socket.
 * @author M. L. Liu
 */

public class ClientHelper {

   static final String endMessage = ".";
   private MyStreamSocket mySocket;
   private InetAddress serverHost;
   private int serverPort;

   ClientHelper(String hostName, String portNum) throws SocketException, UnknownHostException, IOException {
                                     
  	    this.serverHost = InetAddress.getByName(hostName);
  		this.serverPort = Integer.parseInt(portNum);


  		//Instantiates a stream-mode socket and wait for a connection.
   	     this.mySocket = new MyStreamSocket(this.serverHost, this.serverPort);

   /**/  System.out.println("Connection request made using client helper!!!!");
   } // end constructor



   public String getEcho( String message) throws SocketException, IOException{
      String echo = "";    
      mySocket.sendMessage( message);
	   // now receive the echo
      echo = mySocket.receiveMessage();
      return echo;
   } // end getEcho



   public String login(String username) throws SocketException, IOException{
      String uName = "Joe";

      String msg = "Success";
      String err = "Error";

      if(username.equalsIgnoreCase(uName) ) {

         mySocket.sendMessage(username);
         return msg;
      }
         else{
         mySocket.sendMessage(username);
            return err;
         }

   }





   public void done( ) throws SocketException,
                              IOException{
      mySocket.sendMessage(endMessage);
      mySocket.close( );
   } // end done 
} //end class
