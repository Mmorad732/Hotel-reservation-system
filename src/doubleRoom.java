
import java.util.ArrayList;
import java.util.List;


public class doubleRoom implements Room{

         private static int roomnumber ;
         private static String roominfo ;
        private static List<String> info = new ArrayList<>();
            doubleRoom(){}
            doubleRoom(int roomnumber){setroomnumber(roomnumber);
            }
           // setters and getters
          @Override
        public  int getroomnumber() {
              return roomnumber;
          }

          @Override
          public void setroomnumber(int roomnumber) {
             this.roomnumber = roomnumber ;
          }
          
        public void setinfo(List<String> lst ){
                       info.clear();
                       info.addAll(lst) ;
                            
                        }
         
        public String getinfo(){

          return info.toString();        


       }
        @Override
    public void setroominfo(String info) {
        roominfo = info ;
    }

    @Override
    public String getroominfo() {
        return roominfo ;
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
    //display info of all double rooms in the hotel
          @Override
        public String displayallroomsinfo(boolean reservation) {
            //makes sqlcommands object and send it a connection that wass made with 
        //URLconnection class
               URLconnection con = new URLconnection();
               sqlcommands sql = new sqlcommands(con.getconnection());
               sql.displayroomsinfo(reservation , 2);
               return getinfo();
    }

    

    
    
}
