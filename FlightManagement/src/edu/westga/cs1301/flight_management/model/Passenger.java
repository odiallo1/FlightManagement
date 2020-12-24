package edu.westga.cs1301.flight_management.model;

/** Stores information for a specific Passenger
 * 
 * @author CS1301
 * @version Fall 2020
 */
public class Passenger {
	private String name;
	private int rewardsId;
	
	/** Returns the name of the passenger
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the name of the passenger
	 */
	public String getName() {
		return this.name;
	}
	
	/** Returns the rewards id of the passenger
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the rewards id of the passenger
	 */
	public int getRewardsId() {
		return this.rewardsId;
	}
	
	/** Create a new Passenger with the specified name and rewards id.
	 * 
	 * @precondition name != null && !name.isEmpty() &&
	 * 				 rewardsId > 0 
	 * @postcondition getName() == name &&
	 * 				  getRewardsId() == rewardsId 
	 * 
	 * @param name name of the passenger
	 * @param rewardsId rewards id for the passenger
	 */
	public Passenger(String name, int rewardsId) {
		if(name == null || name.isEmpty()) {
			throw new IllegalArgumentException("A valid name must be provided");
		}
		if(rewardsId <= 0) {
			throw new IllegalArgumentException("Rewards id must be positive.");
		}
		this.name = name;
		this.rewardsId = rewardsId;
	}

}
