import java.util.ArrayList;

/**
 * @author Corey Valentyne A00918598
 * 
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kolling and David J. Barnes
 */
public class Room 
{
    private String description;
    private ArrayList<Exit> exits; 
    
    
    /**
     * Default constructor for class Room
     */
    public Room() {
    }
    
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) {
        setDescription(description);
        this.exits = new ArrayList<>();
    }

    /**
     * @return The description of the room as a String
     */
    public String getDescription()
    {
        	return this.description;
    }
    
    /**
     * @param description A String for the room's description
     */
    public void setDescription(String description) {
    	if(description != null) {
    		this.description = description;
    	}
    }
    
    /**
     * @param exit The exit object to add to the ArrayList
     */
    public void setExits(Exit exit) {
    	if(exit != null) {
    		this.exits.add(exit);
    	}
    }
    
    /**
     * @return ArrayList<Exit> The exits ArrayList for the room
     */
    public ArrayList<Exit> getExits(){
    	return this.exits;
    }
    
    /**
     * Prints out all the available exits
     */
    public void printExits() {
    	for(Exit exits: this.getExits()) {
        	System.out.print(exits.getExitDirection() + " ");
        }
    }
}
