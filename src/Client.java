
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Client {
    private static String Name ;
    private static List<String> reserinfo =  new ArrayList<>() ;
    private static int ID  ;
   
    Client(){}
   
    Client(int Cid , String name){
            setName(name);
            setID(Cid);
    }
    //settes and getters
    void setresinfo(List<String> lst ){
        
          reserinfo.clear();
         reserinfo.addAll(lst) ;
        
    }
    String getresinfo(){
        
    return reserinfo.toString();        
      
    
    }
    
    String getName(){
    return Name ;
    }
    void setName(String Name){
    this.Name = Name;
    }
    int getID(){
    return ID ;
    }
    void setID(int ID){
    this.ID = ID ;
    }
    //gets client's past reservations info
    public String getClientrecords(){
         //makes sqlcommands object and send it a connection that wass made with 
        //URLconnection class
        URLconnection con = new URLconnection();
        sqlcommands sql = new sqlcommands(con.getconnection());
        sql.getClientrecords(getID(),getName());
        
        return "Client Name: " + getName() + "\n Client ID: " + getID() + "\n Reservations: "+ getresinfo() ;
    }
}
