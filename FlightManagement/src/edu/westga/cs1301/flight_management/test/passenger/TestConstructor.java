package edu.westga.cs1301.flight_management.test.passenger;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.flight_management.model.Passenger;

public class TestConstructor {

	@Test
	public void testValid() {
		Passenger result = new Passenger("Elizabeth", 1);
		
		assertEquals("Elizabeth", result.getName());
		assertEquals(1, result.getRewardsId());
	}

	@Test
	public void testNullName() {
		assertThrows(IllegalArgumentException.class, ()->{new Passenger(null, 1);});
	}

	@Test
	public void testEmptyName() {
		assertThrows(IllegalArgumentException.class, ()->{new Passenger("", 1);});
	}

	@Test
	public void testZeroRewardsId() {
		assertThrows(IllegalArgumentException.class, ()->{new Passenger("Elizabeth", 0);});
	}

	@Test
	public void testNegativeRewardsId() {
		assertThrows(IllegalArgumentException.class, ()->{new Passenger("Elizabeth", -1);});
	}

}
