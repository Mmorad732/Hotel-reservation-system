
import java.lang.String;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reservation {
    private static int roomno ,ID , clientid , resdays ;
    private static String checkindate , checkoutdate , ClientName;
    Reservation(){}
     Reservation(int roomNo , String checkin , String checkout , int clientid , String ClientName ,int days){
               setRoomNo(roomNo);
               setClientName(ClientName);
               setcheckin(checkin);
               setcheckout(checkout);
               setClientid(clientid);
               setDays(days) ;
               reserveroom(getRoomNo());
               
    }
//reserves a room in database by having the room number     
     void reserveroom(int roomno){
         //makes sqlcommands object and send it a connection that wass made with 
        //URLconnection class
             URLconnection con = new URLconnection();
              sqlcommands sql = new sqlcommands(con.getconnection());
            sql.insertreservationinfo(roomno , getcheckin() , getcheckout(), getClientid() , getDays() , getClientName());
            sql.reserveroom(true, roomno );
       
            
    }
        //setter and getters
          void setRoomNo(int room){
              roomno = room ;
    }
         
          void setcheckin(String date){
                checkindate = date ;
    }
          void setcheckout(String date){
                checkoutdate = date ;
    }    
          void setClientName(String name){
                ClientName = name ;
    }  
          void setClientid(int ID){
                this. clientid = ID ;
    }
          void setDays(int days){
                resdays = days ;
    
    } 
          int getRoomNo(){
              return roomno ; 
    }
       
           int getresID(){
                return ID;
    }  
           String getClientName(){
              return ClientName ;
    }

          String getcheckin(){
               return checkindate  ;
    }
          String getcheckout(){
                return checkoutdate;
    }    
          int getClientid(){
                return clientid  ;
    }      
            int getDays(){
                return resdays  ;
    } 
            //returns string containing reservation information
          String displayinfo(){
               return "Reservation info : \n" + "ID : " + getresID() +"\nRoom no :"+getRoomNo() + "\nCheckin date : " + getcheckin() +  "\nCheckout date : " + getcheckout() + "\nClient ID :" + getClientid() + "\n" ;
        
    }   
}



