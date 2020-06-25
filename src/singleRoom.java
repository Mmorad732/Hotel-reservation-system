
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class singleRoom implements Room {
  private static int roomnumber ;
  private static String roominfo ;
  private static List<String> info = new ArrayList<>();
     singleRoom(){}
     //constructor to initialize a room so you have access to it's info on the data base
      singleRoom(int roomnumber){setroomnumber(roomnumber);}
      //setters and getters
    @Override
     public int getroomnumber() {
        return roomnumber;
    }
 
    @Override
     public void setroomnumber(int roomnumber) {
       this.roomnumber = roomnumber ;
    }
    public void setroominfo(String info){
    roominfo = info ;
    
    }
    public String getroominfo(){
    
    return roominfo;
    }

  @Override
    public void setinfo(List<String> lst) {
        
               info.clear();
               info.addAll(lst) ;
                    
    }

  @Override
    public String getinfo() {
          return info.toString(); 
    }

    
    
    
    
    //display one room info that was initialized
    
    @Override
    public String displayaroominfo() {
        //makes sqlcommands object and send it a connection that wass made with 
        //URLconnection class
         URLconnection con = new URLconnection();
         sqlcommands sql = new sqlcommands(con.getconnection());
         sql.displayaroominfo(getroomnumber());
         return getroominfo();
    }
//display info of all single rooms in the hotel
  @Override
    public String displayallroomsinfo(boolean reservation) {
        //makes sqlcommands object and send it a connection that wass made with 
        //URLconnection class
              URLconnection con = new URLconnection();
              sqlcommands sql = new sqlcommands(con.getconnection());
               sql.displayroomsinfo(reservation , 1 );
      
         
               return getinfo();
    }

    

   

   

    
         
    

   
}

