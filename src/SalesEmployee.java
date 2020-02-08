import java.io.Serializable;

public abstract class SalesEmployee implements Serializable{ //Declare class

	private static final long serialVersionUID = 1L;
	private String firstName; //Declare data members
	private String lastName;
	private static int bikeEmployeeNumber;
	private String ppsNumber;
	protected double sales;
	protected double commission;
	//private int employeeNumber; Comment out employeeNumber as it's not required
	
	//Default constructor
	public SalesEmployee(){
		firstName = "unassigned";
		lastName = "unassigned";
		ppsNumber = "unassigned";
		bikeEmployeeNumber++;
	}
	
	//Overloaded constructor
	public SalesEmployee(String fname, String lname, String pps){
		firstName = fname;
		lastName = lname;
		ppsNumber = pps;
		bikeEmployeeNumber++;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPPS() {
		return ppsNumber;
	}

	public void setPPS(String ppsNumber) {
		this.ppsNumber = ppsNumber;
	}

	public static int getBikeEmployeeNumber() {
		return bikeEmployeeNumber;
	}

	@Override
	public String toString() {
		return "SalesEmployee [commission=" + commission + ", getFirstName()=" + getFirstName() + ", getLastName()="
				+ getLastName() + ", getPPS()=" + getPPS() + "]";
	}
	
	public abstract void calculateCommission();
}
