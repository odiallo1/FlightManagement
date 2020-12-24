package edu.westga.cs1301.flight_management.test.flight;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.flight_management.model.Flight;
import edu.westga.cs1301.flight_management.model.Passenger;
import edu.westga.cs1301.flight_management.model.Plane;

public class TestAddPassenger {
	
	@Test
	public void testNullPassenger() {
		Plane p= new Plane(2,3);
		Flight f= new Flight(p);
		
		assertThrows(IllegalArgumentException.class, 
				
						()-> f.addPassenger(null, true)
					);
	}
	
	@Test
	public void testFirstCoachPassenger() {
		Plane p= new Plane(2,3);
		Flight f= new Flight(p);
		Passenger john= new Passenger("John",1);
		
		f.addPassenger(john, false);
		
		assertEquals(f.getCoachPassengers().get(0), john, "Checking first coach passenger.");
		assertEquals(1, f.getCoachPassengers().size(), "checking first coach passenger.");
	}
	
	@Test
	public void testSecondCoachPassenger() {
		Plane p= new Plane(2,3);
		Flight f= new Flight(p);
		Passenger john= new Passenger("John",1);
		f.addPassenger(john, false);
		Passenger rob= new Passenger("rob",2);
		
		f.addPassenger(rob, false);
		
		
		assertEquals(f.getCoachPassengers().get(1), rob, "Checking second coach passenger.");
		assertEquals(2, f.getCoachPassengers().size(), "checking second coach passenger.");
	}
	
	@Test
	public void testNotEnoughCoachPassenger() {
		Plane p= new Plane(2,1);
		Flight f= new Flight(p);
		Passenger john= new Passenger("John",1);
		f.addPassenger(john, false);
		Passenger rob= new Passenger("rob",2);
		
		f.addPassenger(rob, false);
		
		
		assertEquals(f.getCoachPassengers().get(0), john, "Checking not enough coach passenger.");
		assertEquals(1, f.getCoachPassengers().size(), "checking not enough coach passenger.");
	}
	
	@Test
	public void testFirstFirstClassPassenger() {
		Plane p= new Plane(2,3);
		Flight f= new Flight(p);
		Passenger john= new Passenger("John",1);
		
		f.addPassenger(john, true);
		
		assertEquals(f.getFirstClassPassengers().get(0), john, "Checking first first class passenger.");
		assertEquals(1, f.getFirstClassPassengers().size(), "checking first first class passenger.");
	}
	
	@Test
	public void testSecondFirstClassPassenger() {
		Plane p= new Plane(2,3);
		Flight f= new Flight(p);
		Passenger john= new Passenger("John",1);
		f.addPassenger(john, true);
		Passenger rob= new Passenger("rob",2);
		
		f.addPassenger(rob, true);
		
		
		assertEquals(f.getFirstClassPassengers().get(1), rob, "Checking second first class passenger.");
		assertEquals(2, f.getFirstClassPassengers().size(), "checking second first class passenger.");
	}
	
	@Test
	public void testNotEnoughFirstClassPassenger() {
		Plane p= new Plane(1,2);
		Flight f= new Flight(p);
		Passenger john= new Passenger("John",1);
		f.addPassenger(john, true);
		Passenger rob= new Passenger("rob",2);
		
		f.addPassenger(rob, true);
		
		
		assertEquals(f.getFirstClassPassengers().get(0), john, "Checking not enough first class passengers.");
		assertEquals(1, f.getFirstClassPassengers().size(), "checking not enough first class passengers.");
	}
	
	@Test
	public void testCoachPassengerAlreadyInCoach() {
		Plane p= new Plane(1,2);
		Flight f= new Flight(p);
		Passenger john= new Passenger("John",1);
		f.addPassenger(john, false);
		
		f.addPassenger(john, false);
		
		assertEquals(1, f.getCoachPassengers().size(), "checking Coach Passenger Already In Coach");
	}
	
	@Test
	public void testCoachPassengerAlreadyInFirstClass() {
		Plane p= new Plane(2,2);
		Flight f= new Flight(p);
		Passenger john= new Passenger("John",1);
		f.addPassenger(john, true);
		
		f.addPassenger(john, false);
		
		assertEquals(0, f.getCoachPassengers().size(), "checking Coach Passenger Already In First Class");
	}
	
	@Test
	public void testFirstClassPassengerAlreadyInFirstClass() {
		Plane p= new Plane(2,2);
		Flight f= new Flight(p);
		Passenger john= new Passenger("John",1);
		f.addPassenger(john, true);
		
		f.addPassenger(john, true);
		
		assertEquals(1, f.getFirstClassPassengers().size(), "checking First Class Passenger Already In First Class");
	}
	
	@Test
	public void testFirstClassPassengerAlreadyInCoach() {
		Plane p= new Plane(2,2);
		Flight f= new Flight(p);
		Passenger john= new Passenger("John",1);
		f.addPassenger(john, false);
		
		f.addPassenger(john, true);
		
		assertEquals(0, f.getFirstClassPassengers().size(), "checking First Class Passenger Already In Coach");
	}

}
