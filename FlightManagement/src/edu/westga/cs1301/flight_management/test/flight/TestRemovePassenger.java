package edu.westga.cs1301.flight_management.test.flight;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.flight_management.model.Flight;
import edu.westga.cs1301.flight_management.model.Passenger;
import edu.westga.cs1301.flight_management.model.Plane;

public class TestRemovePassenger {
	@Test
	public void testInvalidRewardsId() {
		Plane p= new Plane(3,3);
		Flight f= new Flight(p);
		Passenger s= new Passenger("s",1);
		
		f.addPassenger(s,true);
		
		assertThrows(IllegalArgumentException.class, 
						()->{
							f.removePassenger(-1);
						}
					);
	}
	
	@Test
	public void testNoPassengers() {
		Plane p= new Plane(3,3);
		Flight f= new Flight(p);
		
		assertEquals(false, f.removePassenger(1), "checking no passengers.");
	}
	
	@Test
	public void testRemoveTheOnlyCoachPassenger() {
		Plane p= new Plane(3,3);
		Flight f= new Flight(p);
		Passenger s= new Passenger("s",1);
		
		f.addPassenger(s,false);
		
		assertEquals(true, f.removePassenger(1), "checking removing the only coach passenger");
		assertEquals(0, f.getCoachPassengers().size(), "checking coach size.");
	}
	
	@Test
	public void testRemoveTheOnlyFirstClassPassenger() {
		Plane p= new Plane(3,3);
		Flight f= new Flight(p);
		Passenger s= new Passenger("s",1);
		
		f.addPassenger(s,true);
		
		assertEquals(true, f.removePassenger(1), "checking removing the only first class passenger");
		assertEquals(0, f.getFirstClassPassengers().size(), "checking first class size.");
	}
	
	@Test
	public void testRemoveTheFirstCoachPassengerWithMultipleCoachPassengers() {
		Plane p= new Plane(3,3);
		Flight f= new Flight(p);
		Passenger s= new Passenger("s",1);
		Passenger o= new Passenger("o",2);
		Passenger g= new Passenger("g",3);
		Passenger d= new Passenger("d",4);
		
		f.addPassenger(s, true);
		f.addPassenger(g, false);
		f.addPassenger(d, false);
		f.addPassenger(o, false);
		
		assertEquals(true, f.removePassenger(3), "checking remove passenger.");
		assertEquals(2, f.getCoachPassengers().size(), "checking coach size.");
	}
	
	@Test
	public void testRemoveTheMiddleCoachPassengerWithMultipleCoachPassengers() {
		Plane p= new Plane(3,3);
		Flight f= new Flight(p);
		Passenger s= new Passenger("s",1);
		Passenger o= new Passenger("o",2);
		Passenger g= new Passenger("g",3);
		Passenger d= new Passenger("d",4);
		
		f.addPassenger(s, true);
		f.addPassenger(d, false);
		f.addPassenger(g, false);
		f.addPassenger(o, false);
		
		assertEquals(true, f.removePassenger(3), "checking remove passenger.");
		assertEquals(2, f.getCoachPassengers().size(), "checking coach size.");
	}
	
	@Test
	public void testRemoveTheLastCoachPassengerWithMultipleCoachPassengers() {
		Plane p= new Plane(3,3);
		Flight f= new Flight(p);
		Passenger s= new Passenger("s",1);
		Passenger o= new Passenger("o",2);
		Passenger g= new Passenger("g",3);
		Passenger d= new Passenger("d",4);
		
		f.addPassenger(s, true);
		f.addPassenger(d, false);
		f.addPassenger(o, false);
		f.addPassenger(g, false);
		
		assertEquals(true, f.removePassenger(3), "checking remove passenger.");
		assertEquals(2, f.getCoachPassengers().size(), "checking coach size.");
	}
	
	@Test
	public void testRemoveTheFirstFirstClassPassengerWithMultipleFirstClassPassengers() {
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
		
		assertEquals(true, f.removePassenger(3), "checking remove passenger.");
		assertEquals(2, f.getFirstClassPassengers().size(), "checking first class size.");
	}
	
	public void testRemoveTheMiddleFirstClassPassengerWithMultipleFirstClassPassengers() {
		Plane p= new Plane(3,3);
		Flight f= new Flight(p);
		Passenger s= new Passenger("s",1);
		Passenger o= new Passenger("o",2);
		Passenger g= new Passenger("g",3);
		Passenger d= new Passenger("d",4);
		
		f.addPassenger(s, false);
		f.addPassenger(d, true);
		f.addPassenger(g, true);
		f.addPassenger(o, true);
		
		assertEquals(true, f.removePassenger(3), "checking remove passenger.");
		assertEquals(2, f.getFirstClassPassengers().size(), "checking first class size.");
	}
	
	public void testRemoveTheLastFirstClassPassengerWithMultipleFirstClassPassengers() {
		Plane p= new Plane(3,3);
		Flight f= new Flight(p);
		Passenger s= new Passenger("s",1);
		Passenger o= new Passenger("o",2);
		Passenger g= new Passenger("g",3);
		Passenger d= new Passenger("d",4);
		
		f.addPassenger(s, false);
		f.addPassenger(d, true);
		f.addPassenger(o, true);
		f.addPassenger(g, true);
		
		assertEquals(true, f.removePassenger(3), "checking remove passenger.");
		assertEquals(2, f.getFirstClassPassengers().size(), "checking first class size.");
	}
	
	@Test
	public void testPassengerIsNotRemoved() {
		Plane p= new Plane(3,3);
		Flight f= new Flight(p);
		Passenger s= new Passenger("s",1);
		Passenger o= new Passenger("o",2);
		Passenger g= new Passenger("g",3);
		Passenger d= new Passenger("d",4);
		
		f.addPassenger(s, false);
		f.addPassenger(d, false);
		f.addPassenger(o, true);
		f.addPassenger(g, true);
		
		assertEquals(false, f.removePassenger(6), "checking remove passenger.");
		assertEquals(2, f.getFirstClassPassengers().size(), "checking first class size.");
	}



}
