package edu.westga.cs1301.flight_management.test.flight;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.flight_management.model.Flight;
import edu.westga.cs1301.flight_management.model.Passenger;
import edu.westga.cs1301.flight_management.model.Plane;

public class TestGetCountOfRemainingCoachSeats {
	@Test
	public void testAllSeatsRemaining() {
		Plane p= new Plane(2,3);
		Flight f= new Flight(p);
		
		assertEquals(0, f.getCoachPassengers().size(), "checking size of coach.");
		assertEquals(3, f.getCountOfRemainingCoachSeats(), "checking remaining coach seats.");
	}
	
	@Test
	public void testSomeSeatsRemaining() {
		Plane p= new Plane(3,3);
		Flight f= new Flight(p);
		Passenger john= new Passenger("John", 1);
		
		f.addPassenger(john, false);
		
		assertEquals(1, f.getCoachPassengers().size(), "checking size of coach.");
		assertEquals(2, f.getCountOfRemainingCoachSeats(), "checking remaining coach seats.");
	}
	
	@Test
	public void testNoSeatsRemaining() {
		Plane p= new Plane(3,2);
		Flight f= new Flight(p);
		Passenger john= new Passenger("John", 1);
		Passenger rob= new Passenger("Rob",2);
		
		f.addPassenger(john, false);
		f.addPassenger(rob, false);
		
		assertEquals(2, f.getCoachPassengers().size(), "checking size of coach.");
		assertEquals(0, f.getCountOfRemainingCoachSeats(), "checking remaining coach seats.");
	}

}
