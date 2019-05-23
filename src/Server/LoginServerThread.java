package Server;

import Classes.User;
import Wrapper.MyStreamSocket;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This module is to be used with a concurrent Echo server.
 * Its run method carries out the logic of a client session.
 * @author M. L. Liu
 */

class LoginServerThread implements Runnable {
   static final String endMessage = "EXIT";
   MyStreamSocket myDataSocket;
   String username = "";
   User user;

   LoginServerThread(MyStreamSocket myDataSocket) {
      this.myDataSocket = myDataSocket;
   }





 
   public void run( ) {
      boolean done = false;
      String err400 = "Code 400";
      String con100 = "Code 100";
      String username = "";
      String password = "";
      User user;

       ArrayList<User> allusers = new ArrayList<>();
       User test = new User ("test", "1234");
       allusers.add(test);

       try{


           while(true){

               //System.out.println(myDataSocket.receiveMessage());
               username = myDataSocket.receiveMessage();
               //System.out.println(myDataSocket.receiveMessage());
               password = myDataSocket.receiveMessage();
               user = new User(username, password);
               int outcome = isExistingUser(allusers, user);

//                switch (outcome){
//                    case true:
//                        myDataSocket.sendMessage(err400);
//                        System.out.println("User already exists");
//                        break;
//                    case false:
//                        myDataSocket.sendMessage(con100);
//                        System.out.println("User Created");
//                        break;
//                }


               if(outcome == 1){
                   myDataSocket.sendMessage(err400);
                   System.out.println("User already exists");
               }
               if(outcome == 2) {
                   myDataSocket.sendMessage(con100);
                   System.out.println("User Created");
               }
           }




       }
       catch (IOException e){
           e.printStackTrace();
       }

   } //end run



    public int isExistingUser(ArrayList<User> list, User user){

       int outcome = 0;

       for(User x: list) {
           if (user.getUsername().equals(x.getUsername()) & user.getPassword().equals(x.getPassword())) {
               outcome = 1;
               return outcome;
           }
            else outcome = 2;
       }

       return outcome;

    }



} //end class 
