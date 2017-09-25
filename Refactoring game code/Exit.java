/**
 * @author Corey Valentyne A00918598
 *
 */
public class Exit {
	
	private String exitDirection;
	private Room theRoom;
	
	/**
	 * Default constructor for class Exit
	 */
	public Exit() {
	}
	
	/**
	 * @param exitDirection A string for the exit's direction
	 * @param Room An object of type Room for the neighbouringRoom exit
	 */
	public Exit(String exitDirection, Room theRoom) {
		if(exitDirection != null && theRoom != null) {
			setExitDirection(exitDirection);
			setTheRoom(theRoom);
		}
	}
	
	/**
	 * @return the exit direction as a String
	 */
	public String getExitDirection() {
		return exitDirection;
	}
	/**
	 * @param exitDirection A String for the direction to set
	 */
	public void setExitDirection(String exitDirection) {
		this.exitDirection = exitDirection;
	}
	/**
	 * @return Room object for the exit's Room
	 */
	public Room getTheRoom() {
		return theRoom;
	}
	/**
	 * @param theRoom object of type room for the exit's room to set
	 */
	public void setTheRoom(Room theRoom) {
		this.theRoom = theRoom;
	}
	
	
}
