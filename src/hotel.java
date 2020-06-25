
public final class hotel {
	private static String name;
	private static double income;
        private static int ID , noOfrooms ; 
        hotel(){
            //starts a connection and sen it to sqlcommands class and then
            //use method gethotelinfo to set hotelinfo
         URLconnection con = new URLconnection();
         sqlcommands sql = new sqlcommands(con.getconnection());
         sql.gethotelinfo();
          
        }
        //constructor to initialize hotel
	hotel(String name ,int ID , double income , int noOfrooms) {
		setName(name);
                setID(ID);
                setIncome(income);
                setnoOfrooms(noOfrooms);
                         
	}
        //setter and getter for the variables
	public String getName() {
		return name;
	}
        
	public void setName(String name) {
		this.name = name;
	}
        public int getID() {
		return ID;
	}
        
	public void setID(int ID) {
		this.ID = ID;
	}
        
	public double getIncome() {
		return income;
	}
        
	public void setIncome(double income) {
		this.income = income;
	}
        public int getnoOfrooms() {
		return noOfrooms;
	}
        
	public void setnoOfrooms(int noOfrooms) {
		this.noOfrooms = noOfrooms;
	}
        
	//method to display info
        public String displayinfo(){
        return " Hotel name: "+ getName() + "\n Hotel ID: " + getID() + "\n Hotel income: " + getIncome() + "\n Number of Rooms:" + getnoOfrooms() ;
        }
}
