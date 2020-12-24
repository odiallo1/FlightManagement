package edu.westga.cs1301.flight_management.test.plane;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.flight_management.model.Plane;

public class TestConstructor {

	@Test
	public void testZeroFirstClassCapacityANDPositiveCoachCapacity() {
		Plane result = new Plane(0, 1);
		
		assertEquals(0, result.getFirstClassCapacity());
		assertEquals(1, result.getCoachCapacity());
	}
	@Test
	public void testPositiveFirstClassCapacityANDPositiveCoachCapacity() {
		Plane result = new Plane(1, 1);
		
		assertEquals(1, result.getFirstClassCapacity());
		assertEquals(1, result.getCoachCapacity());
	}

	@Test
	public void testNegativeFirstClassCapacity() {
		assertThrows(IllegalArgumentException.class, ()->{new Plane(-1, 1);});
		
	}

	@Test
	public void testNegativeCoachCapacity() {
		assertThrows(IllegalArgumentException.class, ()->{new Plane(1, -1);});
	}

	@Test
	public void testZeroCoachCapacity() {
		assertThrows(IllegalArgumentException.class, ()->{new Plane(0, 0);});
	}

}
