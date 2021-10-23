import java.io.FileWriter;
import java.io.IOException;

public class Passenger {
	private String name;
	private char gender;
	private int age;
	private String address;
	private String passport_no;
	
	Passenger(){
		this.name = "";
		this.gender = '-';
		this.age = -1;
		this.address = "";
		this.passport_no = "";
	}
	Passenger(String name, char gender, int age ,String address, String passport_no){
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.passport_no = passport_no;
		this.writeToFile();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassport_no() {
		return passport_no;
	}
	public void setPassport_no(String passport_no) {
		this.passport_no = passport_no;
	}
	void writeToFile() {
		try {
			FileWriter f1 = new FileWriter("Passenger.txt", true);
			String line="";
			line += this.name;
			line += "\t";
			line += this.gender;
			line += "\t";
			line += this.age;
			line += "\t";
			line += address;
			line += "\t";
			line += passport_no;
			line += "\n";
			f1.append(line);
			System.out.println("Passenger.txt file was updated");
			f1.close();
		}
		catch(IOException e) {
			System.out.println("An error occured\n");
			e.printStackTrace();	
		}
		
	}

}
