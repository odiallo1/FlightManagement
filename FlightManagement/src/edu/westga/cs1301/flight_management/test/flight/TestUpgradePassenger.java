package edu.westga.cs1301.flight_management.test.flight;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.flight_management.model.Flight;
import edu.westga.cs1301.flight_management.model.Passenger;
import edu.westga.cs1301.flight_management.model.Plane;

public class TestUpgradePassenger {
	@Test
	public void testNullPassenger() {
		Plane p= new Plane(3,1);
		Flight f= new Flight(p);
		
		assertThrows(IllegalArgumentException.class, 
						()->{
							f.upgradePassenger(null);
						}
		
					);
	}
	
	@Test
	public void testUpgradeFirstCoachPassenger() {
		Plane p= new Plane(3,3);
		Flight f= new Flight(p);
		Passenger a= new Passenger("a",1);
		Passenger b= new Passenger("b",2);
		Passenger c= new Passenger("c",3);
		Passenger d= new Passenger("d",4);
		
		f.addPassenger(a, true);
		f.addPassenger(b, false);
		f.addPassenger(c, false);
		f.addPassenger(d, false);
		
		assertEquals(true, f.upgradePassenger(b), "checking upgrade.");
		assertEquals(2, f.getFirstClassPassengers().size(), "checking first class size.");
	}
	
	@Test
	public void testUpgradeMiddleCoachPassenger() {
		Plane p= new Plane(3,3);
		Flight f= new Flight(p);
		Passenger a= new Passenger("a",1);
		Passenger b= new Passenger("b",2);
		Passenger c= new Passenger("c",3);
		Passenger d= new Passenger("d",4);
		
		f.addPassenger(a, true);
		f.addPassenger(c, false);
		f.addPassenger(b, false);
		f.addPassenger(d, false);
		
		assertEquals(true, f.upgradePassenger(b), "checking upgrade.");
		assertEquals(2, f.getFirstClassPassengers().size(), "checking first class size.");
	}
	
	@Test
	public void testUpgradeLastCoachPassenger() {
		Plane p= new Plane(3,3);
		Flight f= new Flight(p);
		Passenger a= new Passenger("a",1);
		Passenger b= new Passenger("b",2);
		Passenger c= new Passenger("c",3);
		Passenger d= new Passenger("d",4);
		
		f.addPassenger(a, true);
		f.addPassenger(c, false);
		f.addPassenger(d, false);
		f.addPassenger(b, false);
		
		assertEquals(true, f.upgradePassenger(b), "checking upgrade.");
		assertEquals(2, f.getFirstClassPassengers().size(), "checking first class size.");
	}
	
	@Test
	public void testCanNotUpgradeCoachPassenger() {
		Plane p= new Plane(1,3);
		Flight f= new Flight(p);
		Passenger a= new Passenger("a",1);
		Passenger b= new Passenger("b",2);
		Passenger c= new Passenger("c",3);
		Passenger d= new Passenger("d",4);
		
		f.addPassenger(a, true);
		f.addPassenger(c, false);
		f.addPassenger(d, false);
		f.addPassenger(b, false);
		
		assertEquals(false, f.upgradePassenger(b), "checking upgrade.");
		assertEquals(1, f.getFirstClassPassengers().size(), "checking first class size.");
	}



}
