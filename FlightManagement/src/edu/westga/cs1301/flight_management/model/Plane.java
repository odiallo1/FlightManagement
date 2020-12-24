package edu.westga.cs1301.flight_management.model;

/** Stores information for a specific Plane
 * 
 * @author CS1301
 * @version Fall 2020
 */
public class Plane {
	private int firstClassCapacity;
	private int coachCapacity;
	
	/** Return the maximum number of first class passengers
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the maximum number of first class passengers
	 */
	public int getFirstClassCapacity() {
		return this.firstClassCapacity;
	}
	
	/** Return the maximum number of coach passengers
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the maximum number of coach passengers
	 */
	public int getCoachCapacity() {
		return this.coachCapacity;
	}
	
	/** Create a new Plane with the given first class and coach capacities.
	 * 
	 * @precondition firstClassCapacity >= 0 &&
	 * 				 coachCapacity > 0
	 * @postcondition getFirstClassCapacity() == firstClassCapacity &&
	 * 				  getCoachCapacity() == coachCapacity
	 * 
	 * @param firstClassCapacity Maximum number of first class passengers
	 * @param coachCapacity Maximum number of coach passengers
	 */
	public Plane(int firstClassCapacity, int coachCapacity) {
		if(firstClassCapacity < 0) {
			throw new IllegalArgumentException("First class capacity must not be negative");
		}
		if(coachCapacity <= 0) {
			throw new IllegalArgumentException("Coach capacity must be positive");
		}
		this.firstClassCapacity = firstClassCapacity;
		this.coachCapacity = coachCapacity;
	}

}
