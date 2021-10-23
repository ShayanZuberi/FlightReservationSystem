import java.util.ArrayList;
import java.io.*;
import java.io.IOException;

public class Flight {
	static int fCount = 10;
	private int flightID;
	private int seatsBooked;
	private Airplane plane;
	private String departure;
	private String destination;
	private String date;
	private String duration;
	private ArrayList<Booking> bookings;
	
	Flight(int flightID, String departure, String destination, String date, String duration){
		this.flightID = fCount++;
		this.seatsBooked = 0;
		this.departure = departure;
		this.destination = destination;
		this.date = date;
		this.duration = duration;
		bookings = new ArrayList<Booking>();
		
	}
	
	Flight(int flightID, Airplane plane, String departure, String destination, String date, String duration){
		this.flightID = fCount++;
		this.plane = plane;
		this.seatsBooked = 0;
		this.departure = departure;
		this.destination = destination;
		this.date = date;
		this.duration = duration;
		bookings = new ArrayList<Booking>();
		this.writeToFile();
		
	}
	
	public void bookSeat(Passenger pass, String pclass) {
		if (seatsBooked >= plane.getCapacity()) {
			System.out.println("Plane is full, can not add more bookings");
		}
		else {
			seatsBooked++;
			Booking newBooking = new Booking(this.flightID, pass, pclass, seatsBooked, plane.getPriceFactor());
			bookings.add(newBooking);
		}
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}     

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public Airplane getPlane() {
		return plane;
	}

	public void setPlane(Airplane plane) {
		this.plane = plane;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public int getSeatsBooked() {
		return seatsBooked;
	}

	public void setSeatsBooked(int seatsBooked) {
		this.seatsBooked = seatsBooked;
		
	}
	
	void writeToFile() {
		try {
			FileWriter f1 = new FileWriter("Flights.txt", true);
			String line="";
			line += String.valueOf(this.flightID);
			line += " ";
			line += this.plane.getName();
			line += " ";
			line += this.departure;
			line += " ";
			line += this.destination;
			line += " ";
			line += this.date;
			line += " ";
			line += this.duration;
			line += " ";
			line += String.valueOf(this.plane.getCapacity());
			line += "\n";
			//f1.write(line);
			f1.append(line);
			System.out.println("Flights.txt file was updated");
			f1.close();
		}
		catch(IOException e) {
			System.out.println("An error occured\n");
			e.printStackTrace();	
		}
		
	}

	public int getFlightID() {
		return flightID;
	}

	public void setFlightID(int flightID) {
		this.flightID = flightID;
	}

}
