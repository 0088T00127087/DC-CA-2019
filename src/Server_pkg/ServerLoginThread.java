package Server_pkg;

import wrappers.MyStreamSocket;

public class ServerLoginThread implements Runnable {
    static final String endMessage = "EXIT";
    MyStreamSocket myDataSocket;

    ServerLoginThread(MyStreamSocket myDataSocket) {
        this.myDataSocket = myDataSocket;
    }

    public void run( ) {
        boolean done = false;
        String username, password;

        String uName = "Joe";
        String pwd = "1234";

        try {
            while (!done) {


                username = myDataSocket.receiveUsername( );

                /**/System.out.println("Server Thread received Username : "+ username);
                if (username.equalsIgnoreCase(endMessage)){
                    //Session over; close the data socket.
                    /**/
                    System.out.println("Session over.");
                    myDataSocket.close( );
                    done = true;
                } //end if
                else {
                    // Now send the echo to the requestor
                    myDataSocket.sendLogin(username);
                } //end else
            } //end while !done
        }// end try
        catch (Exception ex) {
            System.out.println("Exception caught in thread: " + ex);
        } // end catch
    } //end run
} //end class