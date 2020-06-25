
import java.net.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Printer  {
    static int port = 19922 ;
  
   
     
   public static void main(String[] args){
       new Printer().runserver();
   }
  
    public void runserver() { 
        try {
           ServerSocket ss ;
           Socket s;
           System.out.println("Server Started ");
           ss = new ServerSocket(port);
           System.out.println("Server waiting for client");
           while(true){
           s = ss.accept();
           new printerthread(s).start();
           }
       } catch (IOException ex) {
           Logger.getLogger(Printer.class.getName()).log(Level.SEVERE, null, ex);
       }
       
    }

       
    
}

