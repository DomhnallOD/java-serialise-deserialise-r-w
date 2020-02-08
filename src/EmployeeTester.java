import java.util.*;
import java.io.*;

public class EmployeeTester { //Declare tester class

	public static void main(String[] args) {
		ArrayList<SalesEmployee> employees = new ArrayList<SalesEmployee>(); //Create an arraylist of type SalesEmployee, to store 4 objects
		
		//Populate the arraylist
		populateArray(employees);
		
		//Serialise the arraylist
		serialise(employees);
		
		//Deserialise the arraylist
		deserialise();
		
		//Write arraylist to file
		write(employees);
		
		//Read arraylist from file
		read(employees);

	}
	
	public static ArrayList<SalesEmployee> populateArray(ArrayList<SalesEmployee> employees){
		SalesAgent sa1 = new SalesAgent("John", "Declan", "12121212A"); //Hardcode two employees of both subtype
		SalesAgent sa2 = new SalesAgent("Patricia", "Moore", "64646464W");
		SalesPerson sp1 = new SalesPerson("Ryan", "Doyle", "43432121R");
		SalesPerson sp2 = new SalesPerson("Fiona", "Shaw", "73827832B");
		
		employees.add(sa1); //Add them to the arraylist
		employees.add(sa2);
		employees.add(sp1);
		employees.add(sp2);
		
		Scanner inputScanner = new Scanner(System.in);
		System.out.println("1- \t\tPopulating the ArrayList");
		for(SalesEmployee emp:employees) { //Get sales figures from the user, as per the assignment question
			System.out.println("Please enter sales figures for " + emp.getFirstName() + " " + emp.getLastName() + ": ");
			double salesInput = inputScanner.nextDouble();
			emp.sales = salesInput;
			emp.calculateCommission();
		}
		
		inputScanner.close(); //Close the Scanner
		return employees; //Return the ArrayList

	}
	
	public static void serialise(ArrayList<SalesEmployee> employees) { //Deserialisation method
		try { //Try-catch block
			
			//Create a connection stream (write bytes)
			FileOutputStream fileStream = new FileOutputStream("EmployeeInfo.dat");
			
			//Create a chain stream (allows objects to be written to a stream)
			ObjectOutputStream os = new ObjectOutputStream(fileStream);
			
			//Call writeObject() on the Object stream
			os.writeObject(employees);
			
			os.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void deserialise(){ //Deserialisation method
		try{ //Try-catch block
			
			//Create an input stream (read bytes)
			FileInputStream fileStream = new FileInputStream("EmployeeInfo.dat"); 
			
			//Create a chain stream (allows the stream to be written as an object)
			ObjectInputStream os = new ObjectInputStream(fileStream);
			
			//Suppress UncheckedCast exception
			@SuppressWarnings("unchecked")
			List<SalesEmployee> emp = (ArrayList<SalesEmployee>)os.readObject(); //Read the object
			System.out.println("\n2- \t\ttoString() method of each element of ArrayList:");
			for (SalesEmployee element:emp){ //For each element in the ArrayList, call the toString() method
				System.out.println(element.toString());
			}
			
			os.close(); //Close the ObjectInputStream

			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	public static void write(ArrayList<SalesEmployee> employees){ //Write method
		try { //Try-catch block
			FileWriter fileWriter = new FileWriter("EmployeeList.txt"); //Create new FileWriter object to write to EmployeeList.txt file

			BufferedWriter writer = new BufferedWriter(fileWriter); //Create new BufferedWriter object to write text to character output stream

			System.out.println("\n3- \t\tWriting data to EmployeeList.txt");
			writer.write("Employee List \n");
			for(SalesEmployee element : employees){ //Enhanced for-loop to write data of each element to BufferedWriter
				if (element instanceof SalesAgent) writer.write("Employee Type: SalesAgent");
				else writer.write("Employee Type: SalesPerson");
				writer.write("Name: " + element.getFirstName() + " \n");
				writer.write("Employee Number: " + SalesEmployee.getBikeEmployeeNumber() + " \n");
				writer.write("PPS Number: " + element.getPPS() + " \n");
				writer.write("Sales: €" + (Double.toString(element.sales)) + " \n");
				writer.write("Commission: €" + Double.toString(((SalesEmployee) element).commission) + " \n\n");
			}
			writer.close(); //Close BufferedWriter
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void read(ArrayList<SalesEmployee> employees){
		try{
			File employeeFile = new File("EmployeeList.txt"); //Create new file EmoloyeeList.txt

			FileReader fileReader = new FileReader(employeeFile); //Create new FileReader object

			BufferedReader reader = new BufferedReader(fileReader); //Create new BufferedReader object

			String line = null; //New null string as temp

			System.out.println("\n4- \t\tReading from EmployeeList.txt:\n");
			while ((line = reader.readLine()) != null){ //Iterate through and print each line in the text file 
				System.out.println(line);
			}

			reader.close(); //Close the BufferedReader object

			} catch (IOException e){
				e.printStackTrace();
			}
	}
	
}
