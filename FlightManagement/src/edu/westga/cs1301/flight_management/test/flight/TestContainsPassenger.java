package edu.westga.cs1301.flight_management.test.flight;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.flight_management.model.Flight;
import edu.westga.cs1301.flight_management.model.Passenger;
import edu.westga.cs1301.flight_management.model.Plane;

public class TestContainsPassenger {
	
	@Test
	public void testNullPassenger() {
		Plane p= new Plane(1,2);
		Flight f= new Flight(p);
		
		assertThrows(IllegalArgumentException.class, 
						()->{
							f.containsPassenger(null);
						}
					
					);
	}
	
	@Test
	public void testNoPassenger() {
		Plane p= new Plane(1,2);
		Flight f= new Flight(p);
		Passenger s= new Passenger("s",1);
		
		assertEquals(false, f.containsPassenger(s), "checking no passenger.");
	}
	
	@Test
	public void testPassengerNotFound() {
		Plane p= new Plane(2,2);
		Flight f= new Flight(p);
		Passenger s= new Passenger("s",1);
		Passenger o= new Passenger("o",2);
		Passenger g= new Passenger("g",3);
		Passenger d= new Passenger("d",4);
		Passenger test= new Passenger("test",5);
		
		f.addPassenger(s, true);
		f.addPassenger(o, true);
		f.addPassenger(g, false);
		f.addPassenger(d, false);
		
		assertEquals(false, f.containsPassenger(test), "checking passanger not found");
	}
	
	@Test
	public void testFirstCoachPassenger() {
		Plane p= new Plane(2,3);
		Flight f= new Flight(p);
		Passenger s= new Passenger("s",1);
		Passenger o= new Passenger("o",2);
		Passenger g= new Passenger("g",3);
		Passenger d= new Passenger("d",4);
		
		f.addPassenger(s, true);
		f.addPassenger(o, false);
		f.addPassenger(g, false);
		f.addPassenger(d, false);
		
		assertEquals(true, f.containsPassenger(o), "checking first coach passenger.");
	}
	
	@Test
	public void testMiddleCoachPassenger() {
		Plane p= new Plane(2,3);
		Flight f= new Flight(p);
		Passenger s= new Passenger("s",1);
		Passenger o= new Passenger("o",2);
		Passenger g= new Passenger("g",3);
		Passenger d= new Passenger("d",4);
		
		f.addPassenger(s, true);
		f.addPassenger(g, false);
		f.addPassenger(o, false);
		f.addPassenger(d, false);
		
		assertEquals(true, f.containsPassenger(o), "checking middle coach passenger.");
	}
	
	@Test
	public void testLastCoachPassenger() {
		Plane p= new Plane(2,3);
		Flight f= new Flight(p);
		Passenger s= new Passenger("s",1);
		Passenger o= new Passenger("o",2);
		Passenger g= new Passenger("g",3);
		Passenger d= new Passenger("d",4);
		
		f.addPassenger(s, true);
		f.addPassenger(g, false);
		f.addPassenger(d, false);
		f.addPassenger(o, false);
		
		assertEquals(true, f.containsPassenger(o), "checking last coach passenger.");
	}
	
	@Test
	public void testFirstFirstClassPassenger() {
		Plane p= new Plane(3,3);
		Flight f= new Flight(p);
		Passenger s= new Passenger("s",1);
		Passenger o= new Passenger("o",2);
		Passenger g= new Passenger("g",3);
		Passenger d= new Passenger("d",4);
		
		f.addPassenger(s, false);
		f.addPassenger(o, true);
		f.addPassenger(g, true);
		f.addPassenger(d, true);
		
		assertEquals(true, f.containsPassenger(o), "checking first first class passenger.");
	}
	
	@Test
	public void testMiddleFirstClassPassenger() {
		Plane p= new Plane(3,3);
		Flight f= new Flight(p);
		Passenger s= new Passenger("s",1);
		Passenger o= new Passenger("o",2);
		Passenger g= new Passenger("g",3);
		Passenger d= new Passenger("d",4);
		
		f.addPassenger(s, false);
		f.addPassenger(g, true);
		f.addPassenger(o, true);
		f.addPassenger(d, true);
		
		assertEquals(true, f.containsPassenger(o), "checking middle first class passenger.");
	}
	
	@Test
	public void testLastFirstClassPassenger() {
		Plane p= new Plane(3,3);
		Flight f= new Flight(p);
		Passenger s= new Passenger("s",1);
		Passenger o= new Passenger("o",2);
		Passenger g= new Passenger("g",3);
		Passenger d= new Passenger("d",4);
		
		f.addPassenger(s, false);
		f.addPassenger(g, true);
		f.addPassenger(d, true);
		f.addPassenger(o, true);
		
		assertEquals(true, f.containsPassenger(o), "checking last first class passenger.");
	}
	

}
