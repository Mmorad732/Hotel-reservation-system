
import java.io.*;
import java.net.Socket;
import java.util.logging.*;


public class printerthread extends Thread{
     Socket socket ;
    printerthread(Socket socket){
        this.socket = socket;
    }
    public void run(){
        try {
            String str = null ;
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            while((str = br.readLine())!= null){
            System.out.println(str);
            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(printerthread.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
}
