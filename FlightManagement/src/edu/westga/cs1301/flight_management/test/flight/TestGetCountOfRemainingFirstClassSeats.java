package edu.westga.cs1301.flight_management.test.flight;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.flight_management.model.Flight;
import edu.westga.cs1301.flight_management.model.Passenger;
import edu.westga.cs1301.flight_management.model.Plane;

public class TestGetCountOfRemainingFirstClassSeats {
	
	@Test
	public void testAllSeatsRemaining() {
		Plane p= new Plane(2,3);
		Flight f= new Flight(p);
		
		assertEquals(0, f.getFirstClassPassengers().size(), "checking size of first class.");
		assertEquals(2, f.getCountOfRemainingFirstClassSeats(), "checking remaining first class seats.");
	}
	
	@Test
	public void testSomeSeatsRemaining() {
		Plane p= new Plane(3,3);
		Flight f= new Flight(p);
		Passenger john= new Passenger("John", 1);
		
		f.addPassenger(john, true);
		
		assertEquals(1, f.getFirstClassPassengers().size(), "checking size of first class.");
		assertEquals(2, f.getCountOfRemainingFirstClassSeats(), "checking remaining first class seats.");
	}
	
	@Test
	public void testNoSeatsRemaining() {
		Plane p= new Plane(2,3);
		Flight f= new Flight(p);
		Passenger john= new Passenger("John", 1);
		Passenger rob= new Passenger("Rob",2);
		
		f.addPassenger(john, true);
		f.addPassenger(rob, true);
		
		assertEquals(2, f.getFirstClassPassengers().size(), "checking size of first class.");
		assertEquals(0, f.getCountOfRemainingFirstClassSeats(), "checking remaining first class seats.");
	}
	
	

}
