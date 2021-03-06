import java.util.Stack;

/**
 * @author Corey Valentyne A00918598
 * 
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kolling and David J. Barnes
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Stack<Room> route;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
        route = new Stack<Room>();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        //Create rooms
    	Room outside = new Room("outside the main entrance of the university");
        Room theatre = new Room("in a lecture theatre");
        Room pub = new Room("in the campus pub");
        Room lab = new Room("in a computing lab");
        Room office = new Room("in the computing admin office");
    	Room basement = new Room("the lab's basement");
    	
        //set exits
        outside.setExits(new Exit("east",theatre));
        outside.setExits(new Exit("south",lab));
        outside.setExits(new Exit("west", pub));
        
        theatre.setExits(new Exit("west", outside));
        
        pub.setExits(new Exit("east", outside));
        
        lab.setExits(new Exit("north", outside));
        lab.setExits(new Exit("east", office));
        lab.setExits(new Exit("down", basement));
        
        basement.setExits(new Exit("up",lab));
        
        office.setExits(new Exit("west", lab));
        
        //set current room
        currentRoom = outside;
    	
    	
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        printCurrentLocation();
        
        System.out.println();
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help"))
            printHelp();
        else if (commandWord.equals("go"))
            goRoom(command);
        else if (commandWord.equals("quit"))
            wantToQuit = quit(command);
        else if (commandWord.equals("back")) 
        	goBack();
        

        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("   go back quit help");
    }

    /** 
     * Try to go to one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = null;
        for(Exit theExits: currentRoom.getExits()) {
        	if(theExits.getExitDirection().equalsIgnoreCase(direction)) {
        		nextRoom = theExits.getTheRoom();
        	}
        }

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
        	route.push(currentRoom);
        	
            currentRoom = nextRoom;
            printCurrentLocation();
            
            System.out.println();
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
    
    /**
     * Checks if the route stack is empty, if not then sets current room
     * to the last room visited
     */
    private void goBack() {
    	if(!this.route.empty()) {
    		this.currentRoom = route.pop();
    	}else {
    		System.out.println("You can't go back!");
    	}
    	printCurrentLocation();
    }
    
    /**
     * Prints out the player's current location
     */
    private void printCurrentLocation() {
    	System.out.println("You are " + currentRoom.getDescription());
        System.out.print("Exits: ");
        currentRoom.printExits();
    }
    
}
