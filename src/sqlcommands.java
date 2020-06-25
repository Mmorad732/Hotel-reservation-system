import java.awt.*;
import java.sql.* ;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;


public class sqlcommands {
    Connection conn ;
//constructor to set connection with data base
     sqlcommands(Connection conn){
        this.conn = conn ;
     }
    //method to update the hotel income
       public void updatehotelincome(double price ){
          String query = "update Hotel set Income = Income + ? ";
                  
        try {
            PreparedStatement Query = conn.prepareStatement(query);
            Query.setDouble(1,price);
            Query.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(sqlcommands.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     }
       //assign the hotel info to class hotel
     public void gethotelinfo(){
            String query = "SELECT Name , HID , Income  "
                    + "FROM Hotel " ;
                
            String query2 = "SELECT COUNT(*) AS rowcount"
                    + " FROM Rooms " ;
             try {
            PreparedStatement Query = conn.prepareStatement(query);
            PreparedStatement Query2 = conn.prepareStatement(query2);
            ResultSet rs = Query.executeQuery(query);
            ResultSet rs2 = Query2.executeQuery(query2);
            String name ="" ;
            int  HotelID = 0 , NoOfrooms=0;
            double income  = 0.0 ;
            while(rs.next() && rs2.next()){
                name = rs.getString("Name");
                HotelID = rs.getInt("HID");
                NoOfrooms = rs2.getInt("rowcount");
                income = rs.getDouble("Income");
                
            }
            hotel h = new hotel(name , HotelID , income , NoOfrooms);
           
            }
             catch (SQLException ex) {
                 
            Logger.getLogger(sqlcommands.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
     
     }
     //changes the reservation of a certain room it takes the type of reservation ajd room number
     public void reserveroom(boolean reservation , int roomno) {
      String query = "update Rooms set Reserved = ? "
              + "Where Roomno = ? ";
     
             try { 
                   PreparedStatement Query = conn.prepareStatement(query);
                   Query.setBoolean(1,reservation);
                   Query.setInt(2, roomno);
                   Query.execute();
                   
               } catch (SQLException ex) {
                   Logger.getLogger(sqlcommands.class.getName()).log(Level.SEVERE, null, ex);
               }

            }
     //get all rooms informatin by having the reservation type(true , false) , and room type(single or double)
     public void displayroomsinfo(boolean reserved , int roomtype){
                String query = " SELECT Roomno , RoomtypeID , Hotelid"
                      + " FROM Rooms "
                      + " WHERE Reserved = ? and RoomtypeID = ? "; 
                String status , Roomtype ;
                Room room ;
                if(reserved == true){status = "Reserved" ;}
                else{status = "Empty";}
                if(roomtype == 1){
                    Roomtype = "Single Room" ;
                   room = new singleRoom();
                }
                else{
                    Roomtype = "Double Room";
                    room = new doubleRoom();
                }
                try {
              PreparedStatement Query = conn.prepareStatement(query);
              Query.setBoolean(1 ,reserved);
              Query.setInt(2,roomtype);
              ResultSet rs = Query.executeQuery();
           
               List<String> lst =  new ArrayList<>() ;
                    while(rs.next()){ 
                        
                     String str = "   RoomNo: " + rs.getInt("Roomno") + "   Status: "+ status +"   RoomType: "+ Roomtype + "   Hotel ID: " + rs.getInt("Hotelid") +"\n";                
                     lst.add(str);
                     }
                    room.setinfo(lst);
                  
                   
              
              
          } catch (SQLException ex) {
              Logger.getLogger(sqlcommands.class.getName()).log(Level.SEVERE, null, ex);
          }
     
     }
     //display a certain room info by having it's number
      public void displayaroominfo(int roomno ){
                String query = " SELECT  Roomno, Reserved , RoomtypeID , Hotelid"
                      + " FROM Rooms "
                      + " WHERE Roomno = ?  "; 
                String status , Roomtype ;
                
                
                try {
              PreparedStatement Query = conn.prepareStatement(query);
              Query.setInt(1 ,roomno);
              ResultSet rs = Query.executeQuery();
              Room room;
               while(rs.next()){
                   if(rs.getInt("RoomtypeID") == 1){Roomtype = "Single Room" ;}
                else{Roomtype = "Double Room";}
                   if(rs.getBoolean("Reserved") == true){status = "Reserved" ;}
                else{status = "Empty";}
               String str = " RoomNo: " + rs.getInt("Roomno") + " Status: "+ status +" RoomType: "+ Roomtype + " Hotel ID: " + rs.getInt("Hotelid");
               if(rs.getInt("RoomtypeID") == 1){
                    room = new singleRoom();
               }else{
                    room = new doubleRoom();
               }
               room.setroominfo(str);
             
                }
              
              
          } catch (SQLException ex) {
              Logger.getLogger(sqlcommands.class.getName()).log(Level.SEVERE, null, ex);
          }
     
     }
      //it inserts the reservation info in the reservation table in DB if the room is not reserved and 
      //adds the client info in the client table in DB if he is a new client
     public void insertreservationinfo(int Roomno , String checkin , String checkout , int clientid , int days , String clientname ){
          String query = "insert into Reservation  (Roomno  , checkindate , checkoutdate  , clientID, Days  , TotalMoney ) "
                  + "values(? , ? , ? , ? , ? ,? )";
                  
          String query2 = " SELECT Price"
                      + " FROM Rooms R "
                      + " JOIN RoomType T ON T.RTID = R.RoomtypeID "
                      + " WHERE R.Roomno = ? ";
          String query3 = "insert into Client  (CID ,  Name)" 
                  + "values(?,?)" ;  
          String query4 = "Select CID from Client where CID = ? ";
          double Total_Price = 0 ;
          
        try { 
            PreparedStatement Query4 = conn.prepareStatement(query4);
            Query4.setInt(1, clientid);
            ResultSet rs2 = Query4.executeQuery();
            if(!rs2.next()){
            PreparedStatement Query3 = conn.prepareStatement(query3);
            Query3.setInt(1 , clientid);
            Query3.setString(2,clientname);
            Query3.execute();}
            
        } catch (SQLException ex) {
            Logger.getLogger(sqlcommands.class.getName()).log(Level.SEVERE, null, ex);
        }
            
           try { 
            String query5 = "select Reserved from Rooms where Roomno = ?" ; 
            PreparedStatement Query5 = conn.prepareStatement(query5);
            Query5.setInt(1, Roomno);
            ResultSet rs3 = Query5.executeQuery();
            rs3.next();
           if(rs3.getBoolean("Reserved") != true){
            PreparedStatement Query2 = conn.prepareStatement(query2);
            Query2.setInt(1 ,Roomno);
            ResultSet rs = Query2.executeQuery();
            rs.next();
            Total_Price = rs.getDouble("Price") * days ;
            updatehotelincome(Total_Price);
            PreparedStatement Query = conn.prepareStatement(query);
            Query.setInt(1,Roomno);
            Query.setString(2, checkin);
            Query.setString(3, checkout);
            Query.setInt(4, clientid);
            Query.setInt(5, days);
            Query.setDouble(6,Total_Price);
            Query.execute();}
           
        } catch (SQLException ex) {
            Logger.getLogger(sqlcommands.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     }
     

     //get the client past reservations from the DB by having his name and id 
    public void getClientrecords(int ClientID ,String Cname){
                   
                    String query2 = " SELECT  resID , Roomno , checkindate , Days , TotalMoney , Client.Name "
                            + " FROM Reservation "
                            + "INNER JOIN Client  ON Client.CID = Reservation.clientID "
                            + " WHERE  CID = ?  AND Name = ?"; 
                    
                   
                    try {
                    
                   PreparedStatement Query2 = conn.prepareStatement(query2);
                  Query2.setInt(1,ClientID);
                  Query2.setString(2, Cname);
                  ResultSet rs2 = Query2.executeQuery();
                  Client c = new Client();
                  List<String> lst =  new ArrayList<>() ;
                    while( rs2.next()){ 
                     String str ="   Reservation ID: "+rs2.getInt("resID")+"   Room Number: "+rs2.getInt("Roomno")+"   Checkindate: "+rs2.getString("checkindate")+"  Days:  "+rs2.getInt("Days")+"   Total Money: "+rs2.getDouble("TotalMoney") +"\n";                   
                     lst.add(str);
                     }
                    
                    c.setresinfo(lst);
                    
                  
                   
                    

              } catch (SQLException ex) {
                  Logger.getLogger(sqlcommands.class.getName()).log(Level.SEVERE, null, ex);
              }

         }
    public void resetreservation() {
        try {
            String query = "select checkoutdate , Roomno "
                    + "from Reservation" ;
           
            PreparedStatement Query = conn.prepareStatement(query);
            ResultSet rs = Query.executeQuery();
            Date current = new Date() ;
            while(rs.next()){
                try {
                    Date d = new SimpleDateFormat("dd / MM /yyyy").parse(rs.getString("checkoutdate"));
                    if(d.before(current) || d.equals(current)){
                        reserveroom(false , rs.getInt("Roomno"));
                    }
                    
                } catch (ParseException ex) {
                    Logger.getLogger(sqlcommands.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(sqlcommands.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    } 
    

}
