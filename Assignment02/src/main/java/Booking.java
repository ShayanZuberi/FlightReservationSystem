import java.io.FileWriter;
import java.io.IOException;

public class Booking {
	private int flightID;
	private Passenger passenger;
	private String planeClass;
	private int seatNumber;
	private float price;
	private float factor;
	
	Booking(int flightID, Passenger passenger, String planeClass, int seatNumber, float factor){
		this.flightID = flightID;
		this.passenger = passenger;
		this.planeClass = planeClass;
		this.seatNumber = seatNumber;
		this.setFactor(factor);
		this.price = this.CalculatePrice();
		this.writeToFile();
	}
	
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public String getPlaneClass() {
		return planeClass;
	}
	public void setPlaneClass(String planeClass) {
		this.planeClass = planeClass;
	}
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public float getFactor() {
		return factor;
	}

	public void setFactor(float factor) {
		this.factor = factor;
	}

	public float CalculatePrice() {
		if (planeClass == "Economy") {
			price = 1000;
			
		}
		else if (planeClass == "Business") {
			price = 1500;
			
		}
		else if (planeClass == "First Class") {
			price = 2000;
			
		}
		else {
			price = 500;
		}
		return price*factor;
	}
	
	void writeToFile() {
		try {
			FileWriter f1 = new FileWriter("Bookings.txt", true);
			String line="";
			line += String.valueOf(this.flightID);
			line += "\t";
			line += "\t";
			line += "\t";
			line += this.passenger.getName();
			line += "\t";
			line += this.passenger.getPassport_no();
			line += "\t";
			line += "\t";
			line += this.planeClass;
			line += "\t";
			line += "\t";
			line += String.valueOf(this.seatNumber);
			line += "\t";
			line += this.price;
			line += "\n";
			f1.append(line);
			System.out.println("Bookings.txt file was updated");
			f1.close();
		}
		catch(IOException e) {
			System.out.println("An error occured\n");
			e.printStackTrace();	
		}
		
	}

}
