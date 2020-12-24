package edu.westga.cs1301.flight_management.model;

import java.util.ArrayList;

/** Manage the passengers and plane for a Flight
 * 
 * @author CS1301
 * @version Fall 2020
 */
public class Flight {
	private Plane plane;
	private ArrayList<Passenger> firstClass;
	private ArrayList<Passenger> coach;
	
	/** Create a new flight with the given Plane and no passengers,
	* either first class or coach.
	*
	* @precondition plane != null
	* @postcondition getPlane() == plane &&
	* getFirstClassPassengers().size() == 0 &&
	* getCoachPassengers().size() == 0
	*
	* @param plane the plane for this Flight
	*/
	public Flight(Plane plane) {
		if(plane == null) {
			throw new IllegalArgumentException("Plane can't be null.");
		}
		this.plane = plane;
		this.firstClass = new ArrayList<Passenger>();
		this.coach = new ArrayList<Passenger>();
		
	}
	
	/** Return the plane Object
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the plane object
	 */
	public Plane getPlane() {
		return this.plane;
	}
	
	/** Return the list of firstClass passengers
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return ArrayList of firstClass passengers
	 */
	public ArrayList<Passenger> getFirstClassPassengers(){
		return this.firstClass;
	}
	
	/** Return the list of coach passengers
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return ArrayList of coach passengers
	 */
	public ArrayList<Passenger> getCoachPassengers(){
		return this.coach;
	}
	
	/** Add a new passenger to the flight with the specified seat type.
	* The passenger is not added if there is no space left in the
	* appropriate section.
	*
	* @precondition passenger != null
	* @postcondition adds the passenger to the appropriate collection
	*
	* @param passenger the passenger to add to the flight
	* @param isFirstClass true if seat is first class; false if seat is coach
	*
	* @return true if passenger was added;
	* false if passenger was not added;
	*/
	public boolean addPassenger(Passenger passenger, boolean isFirstClass) {
		if(passenger == null) {
			throw new IllegalArgumentException("passanger can't be null.");
		}
		boolean check= false;
		
		if(isFirstClass == true && this.firstClass.size() < this.plane.getFirstClassCapacity() 
				&& this.containsPassenger(passenger) == false){
			this.firstClass.add(passenger);
			check=true;
		}
		
		if(isFirstClass == false && this.coach.size() < this.plane.getCoachCapacity()
				&& this.containsPassenger(passenger) == false) {
			this.coach.add(passenger);
			check=true;
		}
		return check;
	}
	
	/** Return the number of available first class seats remaining.
	*
	* @precondition none
	* @postcondition none
	*
	* @return the number of available first class seats remaining
	*/
	public int getCountOfRemainingFirstClassSeats() {
		return this.plane.getFirstClassCapacity() - this.firstClass.size();
	}
	
	/** Return the number of available coach seats remaining.
	*
	* @precondition none
	* @postcondition none
	*
	* @return the number of available coach seats remaining
	*/
	public int getCountOfRemainingCoachSeats() {
		return this.plane.getCoachCapacity() - this.coach.size();
	}
	
	/** Check if the specified passenger is either a
	* first class or coach passenger for this Flight.
	*
	* @precondition passenger != null
	* @postcondition none
	*
	* @param passenger
	* @return true if the passenger is in first class.
	* true if the passenger is in coach.
	* false if the passenger is *not* in first class or coach.
	*/
	public boolean containsPassenger(Passenger passenger) {
		if(passenger == null) {
			throw new IllegalArgumentException("passenger can't be null.");
		}
		boolean check= false;
		for(Passenger current: this.coach) {
			if(passenger == current) {
				check=true;
			}
		}
		for(Passenger current: this.firstClass) {
			if(passenger == current) {
				check=true;
			}
		}
		
		return check;
	}
	
	/** Remove the passenger with the specified rewardsId.
	*
	* @precondition none
	* @postcondition none
	*
	* @param rewardsId the rewards id of the passenger to be removed.
	*
	* @return true if a passenger was removed;
	* false if a passenger was not removed (i.e., no passenger with
	* the specified rewards id was found)
	*/
	public boolean removePassenger(int rewardsId) {
		if(rewardsId <= 0) {
			throw new IllegalArgumentException("Rewards id must be positive.");
		}
		boolean check= false;
		for(int i=0; i < this.coach.size(); i++){
			if(coach.get(i).getRewardsId() == rewardsId) {
				check= true;
				this.coach.remove(i);
			}
		}
		
		for(int i=0; i < this.firstClass.size(); i++){
			if(firstClass.get(i).getRewardsId() == rewardsId) {
				check= true;
				this.firstClass.remove(i);
			}
		}
		return check;
	}
	
	/** Upgrades a passenger from coach to first class if there is enough space.
	*
	* @precondition passenger != null
	* @postcondition this.firstclass.size()= @prev firstclass.size() + 1
	*
	* @param passenger the coach passenger to be upgraded.
	*
	* 
	*/
	public boolean upgradePassenger(Passenger passenger) {
		if(passenger == null) {
			throw new IllegalArgumentException("passenger can't be null.");
		}
		boolean check=false;
		for(int i=0; i < this.coach.size(); i++) {
			if(passenger == this.coach.get(i) && this.getCountOfRemainingFirstClassSeats() > 0) {
				this.firstClass.add(this.coach.get(i));
				this.coach.remove(i);
				check=true;
			}
		}
		return check;
	}
	

}
