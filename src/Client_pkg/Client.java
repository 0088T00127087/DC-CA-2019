package Client_pkg;

import java.io.*;

/**
 * This module contains the presentaton logic of an Echo Client.
 * @author M. L. Liu
 */
public class Client {
   static final String endMessage = "EXIT";
   InputStreamReader is1 = new InputStreamReader(System.in);
   BufferedReader br1 = new BufferedReader(is1);
   public static void main(String[] args) {


      InputStreamReader is = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(is);

      String host = "localhost";
      String port = "7";



      try {


         ClientHelper helper = new ClientHelper(host, port);
         boolean done = false;
         while (!done) {

            // To Get username and password
            String username, password, msg;
            String message, echo;


            // Ask for username
            System.out.println("Please enter username!");
            username = br.readLine();



            if (username.equalsIgnoreCase("EXIT")) {
               done = true;
               helper.done();
            }
            else {
               // To check if login works
               System.out.print("\n Reached else!!!!!");
               msg = helper.login(username);
               System.out.println(msg);
            }

         } // end of While
         }// End of Try

      catch(Exception ex){
            System.out.print(ex);
         }// End of catch


   } //end main


} // end class
