package Client;

import Classes.ServerInstance;
import Classes.User;
import Server.Server;
import Wrapper.MyStreamSocket;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.swing.*;
import java.net.*;
import java.io.*;

/**
 * This class is a module which provides the application logic
 * for an Echo client using stream-mode socket.
 * @author M. L. Liu
 */

public class EchoClientHelper2 {

   static final String endMessage = ".";
   private MyStreamSocket mySocket;
   private InetAddress serverHost;
   private int serverPort;

   ServerInstance myserver = new ServerInstance("localhost", "7");

   EchoClientHelper2(String hostName, String portNum) throws SocketException, UnknownHostException, IOException {
                                     
  	     this.serverHost = InetAddress.getByName(hostName);
  	     this.serverPort = Integer.parseInt(portNum);

         //Instantiates a stream-mode socket and wait for a connection.
   	     this.mySocket = new MyStreamSocket(this.serverHost, this.serverPort);

   	     System.out.println("Connection request made");
   } // end constructor


    EchoClientHelper2(ServerInstance server) throws SocketException, UnknownHostException, IOException {

        this.serverHost = InetAddress.getByName(server.getHostname());
        this.serverPort = Integer.parseInt(server.getPortNum());

        //Instantiates a stream-mode socket and wait for a connection.
       if(isValidServer(server)){
            this.mySocket = new MyStreamSocket(this.serverHost, this.serverPort);
            JOptionPane.showMessageDialog(null, "Initial request made to server", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
        else
            JOptionPane.showMessageDialog(null, "Could Not connect to server", "Info", JOptionPane.INFORMATION_MESSAGE);



        //System.out.println("Connection request made to Server");

    } // end constructor


   public boolean isValidServer(ServerInstance server){
       if(server.getHostname().equals(myserver.getHostname()) & server.getPortNum().equals(myserver.getPortNum())){
           return true;
       }
       else
           return false;
   }


	
   public String getEcho(String message) throws SocketException, IOException{
      String echo = "";    
      mySocket.sendMessage(message);
	   // now receive the echo
      //echo = mySocket.receiveMessage();
      return echo;
   } // end getEcho

    public String getMessage() throws SocketException, IOException{

        String echo = mySocket.receiveMessage();
        return echo;
    } // end getMessage




    public int getMessageType(){

        String message = null;
        int type = 100;
        try {
            message = mySocket.receiveMessage();
            System.out.println("EchoClientHelper: message: " + message);
            if(message.equals("Code 400"))
                type = 400;
            else if(message.equals("Code 100"))
                type = 100;
        } catch (IOException e) {
            e.printStackTrace();
        }

       return type;
    }




    public void sendUserName(String username) throws SocketException, IOException{
        mySocket.sendMessage(username);
    }

    public void sendPassword(String password) throws SocketException, IOException{
        mySocket.sendMessage(password);
    }





    public void done( ) throws SocketException,
                              IOException{
      mySocket.sendMessage(endMessage);
      mySocket.close( );
   } // end done 
} //end class
