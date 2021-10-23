import java.util.*;
import java.util.ArrayList;
public class Main {

	public static void main(String[] args) {
		ArrayList<Passenger> passengers = new ArrayList<Passenger>();
		
		FlightManagement fm = new FlightManagement(); 
		while(true) {
			System.out.println("Press 1 to add a new passenger");
			System.out.println("Press 2 to add a new flight");
			System.out.println("Press 3 to search for flights");
			System.out.println("Press 4 to make a booking");
			System.out.println("Press 5 to remove a flight");
			System.out.println("Press 6 to view bookings");
			System.out.println("Press 7 to view passengers");
			System.out.println("Press 8 to view airplanes");
			System.out.println("Press 9 to save and exit");
			Scanner input = new Scanner(System.in);
			Scanner sc2 = new Scanner(System.in);
			int choice = 9;
			try {
				choice = input.nextInt();
			}
			catch (NoSuchElementException e) {
		    	System.out.println("Problem occured");
			}
			//input.nextLine();
			
			if(choice == 1) {
				String name;
				char gender;
				String passport;
				int age;
				String address;
				System.out.println("Please enter passenger's name");
				name = sc2.nextLine(); 
				System.out.println("Please enter passenger's passport number");
				passport = sc2.nextLine();
				System.out.println("Please enter passenger's address");
				address = sc2.nextLine();
				System.out.println("Please enter passenger's gender");
				gender = sc2.next().charAt(0); 
				System.out.println("Please enter passenger's age");
				age = sc2.nextInt();
				passengers.add(fm.addPassenger(name, gender, age, address, passport));
				//sc2.close();
				
			}
			else if(choice == 2) {
				String dep, dest, dur, date;
				System.out.println("Please enter departure city");
				dep = sc2.nextLine();
				System.out.println("Please enter destination city");
				dest = sc2.nextLine();
				System.out.println("Please enter flight duration");
				dur = sc2.nextLine();
				System.out.println("Please enter date of flight");
				date = sc2.nextLine();
				fm.addFlight(dep, dest, date, dur);
				//sc2.close();
				
			}
			else if(choice == 3) {
				String dep, dest;
				System.out.println("Please enter departure city");
				dep = sc2.nextLine();
				System.out.println("Please enter destination city");
				dest = sc2.nextLine();
				fm.showFlights(dep, dest);
				//sc2.close();
			}
			else if(choice == 4) {
				String clas;
				int flightno;
				System.out.println("Please enter class");
				clas = sc2.nextLine();
				System.out.println("Please enter flight ID");
				flightno = sc2.nextInt();
				fm.addBooking(flightno, passengers.get(passengers.size()-1), clas);
				//sc2.close();
				
			}
			else if(choice == 5) {
				int flightno;
				System.out.println("Please enter flight ID");
				flightno = sc2.nextInt();
				fm.removeFlight(flightno);
				//sc2.close();
				
			}
			else if(choice == 6) {
				fm.showBookings();
			}
			else if(choice == 7) {
				fm.showPassengers();
			}
			else if(choice == 8) {
				fm.showAirplanes();
				
			}
			else if(choice == 9) {
				break;
				
			}
			else {
				System.out.println("Invalid choice, enter again");
			}
			//input.close();
		}
		
	}
}
