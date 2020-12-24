package edu.westga.cs1301.flight_management.test.flight;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.flight_management.model.Flight;
import edu.westga.cs1301.flight_management.model.Plane;

public class TestConstructor {

	@Test
	public void nullConstructor() {
		
		
		assertThrows(
						IllegalArgumentException.class, 
						 ()-> {
							 	new Flight(null);
						 	}
					);
	}
	
	@Test
	public void validPlane() {
		Plane valid= new Plane(2,3);
		Flight v= new Flight(valid);
		
		assertEquals(valid, v.getPlane(), "Checking plane.");
		assertEquals(0, v.getFirstClassPassengers(), "Checking first class passengers.");
		assertEquals(0, v.getCoachPassengers(), "Checking coch passengers.");
		
	}
}
