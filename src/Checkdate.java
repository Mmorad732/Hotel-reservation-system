
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Checkdate {
    public void Checkreservation(){
     URLconnection con = new URLconnection();
         sqlcommands sql = new sqlcommands(con.getconnection());
         sql.resetreservation();
    }
    Date current = new Date();
    public boolean checkin(String cidate){
        try {
            Date cid = new SimpleDateFormat("dd / MM /yyyy").parse(cidate);
             
          
            if(current.after(cid)){
                return false ;
            }else{
            return true ;
            }
        } catch (ParseException ex) {
            Logger.getLogger(Checkdate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false ;
    }
     public boolean checkout(String codate){
        try {
            Date cod = new SimpleDateFormat("dd / MM /yyyy").parse(codate);
            if(current.after(cod) || current.equals(cod)){
                return false ;
            }else{
            return true ;
            }
        } catch (ParseException ex) {
            Logger.getLogger(Checkdate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false ;
    }
     public boolean equality(String cidate , String codate){
        try {
            Date cod = new SimpleDateFormat("dd / MM /yyyy").parse(codate);
            Date cid = new SimpleDateFormat("dd / MM /yyyy").parse(cidate);
            if(cod.equals(cid)){
                return true ;
             }else{
                return false ;
            }
        } catch (ParseException ex) {
            Logger.getLogger(Checkdate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false ;
     }
     public long getDateDiff(String codate, String cidate, TimeUnit timeUnit) {
        try {
            Date cod = new SimpleDateFormat("dd / MM /yyyy").parse(codate);
            Date cid = new SimpleDateFormat("dd / MM /yyyy").parse(cidate);
            long diffInMillies = cod.getTime() - cid.getTime();
            return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
        } catch (ParseException ex) {
            Logger.getLogger(Checkdate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
}
    
}
