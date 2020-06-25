import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SendToprinter {
    
    
    
public void print(String str){
        try { 
            
            Socket s = new Socket("localhost" , 19922);
            OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
            PrintWriter out = new PrintWriter(os ,true);
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            out.println(str);
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(SendToprinter.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
}
