import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;  

public class FlightManagement {
	static int seat = 1;
	private ArrayList<Flight> flights;
	private ArrayList<Airplane> planes;
	private ArrayList<Passenger> passengers;	
	FlightManagement(){
		flights = new ArrayList<Flight>();
		planes = new ArrayList<Airplane>();
		passengers = new ArrayList<Passenger>();
		///adding some planes
		Airplane plane1 = new Airplane("A380", "Commercial", 400, 2.5f);
		Airplane plane2 = new Airplane("A330", "Commercial", 250, 2.0f);
		Airplane plane3 = new Airplane("A350", "Commercial", 300, 2.3f);
		Airplane plane4 = new Airplane("B747", "Commercial", 300, 2.4f);
		planes.add(plane1);
		planes.add(plane2);
		planes.add(plane3);
		planes.add(plane4);
	}
	
	public void addBooking(int flightno, Passenger pass, String pclass) {
		for (int i=0; i<flights.size(); i++) {
			if(flights.get(i).getFlightID() == flightno) {	//finding the flight to book a seat on 
				flights.get(i).bookSeat(pass, pclass);
				System.out.println("Booking was added successfully");
			}
		}
		Booking newBooking = new Booking(flightno, pass, pclass, seat++ , 2.5f);
		System.out.println("Booking was added successfully, cost: " + newBooking.CalculatePrice());
		//newBooking.getPassenger();
	}
	
	public void addFlight(String dep, String dest, String date, String dur) {
		Flight newFlight = new Flight(1, planes.get(1), dep, dest, date, dur );
		flights.add(newFlight);
		System.out.println("New flight was added successfully");
	}
	
	public void removeFlight(int flightno) {
		for (int i=0; i<flights.size(); i++) {
			if(flights.get(i).getFlightID() == flightno) {	//finding the flight to book a seat on 
				flights.remove(i);
				System.out.println("flight was removed successfully");
			}
		}
	}
	
	public Passenger addPassenger(String name, char gender, int age ,String address, String passport_no) {
		Passenger newPass = new Passenger(name, gender, age ,address,passport_no);
		passengers.add(newPass);
		System.out.println("Passenger was added successfully");
		return newPass;
	}
	
	@SuppressWarnings("unused")
	public void showFlights(String source, String destination) {
		try {
			File f1 = new File("Flights.txt");
			Scanner reader = new Scanner(f1);
			while(reader.hasNextLine()) {
				String line = reader.nextLine();
				String line2 = line;
				//System.out.println(line2);
				StringTokenizer st = new StringTokenizer(line," "); 
				//System.out.println(st.nextToken());
				//System.out.println(st.nextToken());
				st.nextToken();
				st.nextToken();
				String src = "";
				if(st.hasMoreTokens()) {
					src = st.nextToken();
				}
				//else System.out.println("PROBS");
				//System.out.println("SRC: "+ src);
				//System.out.println("Source: "+ source);
				if (src.equals(source)) {
					//System.out.println("HERE1");
					System.out.println(line2);
				}  
				else {
					String dest = st.nextToken();
					//System.out.println("dest: "+ dest);
					if (dest == destination) {
						System.out.println("HERE2");
						System.out.println(line2);
					}
				}   
			}
			reader.close();
		}
		catch(IOException e) {
			System.out.println("An error occured\n");
			e.printStackTrace();	
		}
	}

	
	public void showBookings() {
		try {
			File f1 = new File("Bookings.txt");
			Scanner reader = new Scanner(f1);
			while(reader.hasNextLine()) {
				String line = reader.nextLine();
				System.out.println(line);
 
			}
			reader.close();
		}
		catch(IOException e) {
			System.out.println("An error occured\n");
			e.printStackTrace();	
		}
	}
	
	public void showPassengers() {
		try {
			File f1 = new File("Passenger.txt");
			Scanner reader = new Scanner(f1);
			while(reader.hasNextLine()) {
				String line = reader.nextLine();
				System.out.println(line);
 
			}
			reader.close();
		}
		catch(IOException e) {
			System.out.println("An error occured\n");
			e.printStackTrace();	
		}
	}
	
	public void showAirplanes() {
		try {
			File f1 = new File("Airplanes.txt");
			Scanner reader = new Scanner(f1);
			while(reader.hasNextLine()) {
				String line = reader.nextLine();
				System.out.println(line);
 
			}
			reader.close();
		}
		catch(IOException e) {
			System.out.println("An error occured\n");
			e.printStackTrace();	
		}
	}
	
	public ArrayList<Flight> getFlights() {
		return flights;
	}

	public void setFlights(ArrayList<Flight> flights) {
		this.flights = flights;
	}

}
